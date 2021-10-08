/*
 *   Copyright 2016-2021 Oleksii V. KHALIKOV, PE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.core;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;

import lombok.extern.slf4j.Slf4j;
import ua.com.gfalcon.financier.model.plan.FinancePlanEntry;
import ua.com.gfalcon.financier.model.plan.FinanceTarget;
import ua.com.gfalcon.financier.util.DateUtils;

/**
 * Saver calculator.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
@Slf4j
public class SaverCalculator {

    private final List<FinanceTarget> targets;
    private final Money               availableMoney;
    private final LocalDate           currentDate;

    private List<FinancePlanEntry> plan;

    public SaverCalculator(Money availableMoney, List<FinanceTarget> targets) {
        this(availableMoney, targets, LocalDate.now());
    }

    /**
     * Create saver calculator.
     *
     * @param availableMoney available money
     * @param targets        list of finance targets
     * @param currentDate    current date
     */
    public SaverCalculator(Money availableMoney, List<FinanceTarget> targets, LocalDate currentDate) {
        this.targets = targets;
        this.availableMoney = availableMoney;
        this.currentDate = currentDate;
        initNewPlan();
    }

    public List<FinancePlanEntry> getPlan() {
        return this.plan;
    }

    /**
     * Calculate finance plan.
     *
     * @param availableMoney available money
     * @param targets        list of finance targets
     * @param currentDate    current date
     * @return finance plan of saving/
     */
    public static List<FinancePlanEntry> calculate(Money availableMoney, List<FinanceTarget> targets,
            LocalDate currentDate) {

        return new SaverCalculator(availableMoney, targets, currentDate).calc();
    }

    public static List<FinancePlanEntry> calculate(Money availableMoney, List<FinanceTarget> targets,
            Date currentDate) {
        return calculate(availableMoney, targets, DateUtils.convertToLocalDate(currentDate));
    }

    /**
     * Calculate finance plan.
     *
     * @return propose of saving plan
     */
    public List<FinancePlanEntry> calc() {
        initNewPlan();

        List<FinanceTarget> sortedTargetList = targets.stream()
                .sorted(Comparator.comparing(FinanceTarget::getUntilDate)
                        .thenComparing(FinanceTarget::getAmount))
                .collect(Collectors.toList());

        scheduleRegularTargets(sortedTargetList);

        scheduleStrictTargets(sortedTargetList);

        scheduleDelayableTargets(sortedTargetList);

        return plan;
    }

    protected boolean setPreparedPlan(List<FinancePlanEntry> inputPlan) {
        if (Objects.isNull(inputPlan) || inputPlan.isEmpty()) {
            return false;
        }
        if (Objects.nonNull(this.plan) && !this.plan.isEmpty()) {
            return false;
        }

        this.plan = inputPlan.stream()
                .sorted(Comparator.comparing(FinancePlanEntry::getDate))
                .collect(Collectors.toList());
        return true;
    }

    private Money getMaxLevel(List<FinancePlanEntry> plan) {
        List<Money> savedPlan = plan.stream()
                .map(FinancePlanEntry::getTotal)
                .collect(Collectors.toList());

        return savedPlan.stream()
                .reduce((money, money2) -> {
                    if (money.isGreaterThanOrEqualTo(money2)) {
                        return Money.of(money.getNumberStripped(), money.getCurrency());
                    } else {
                        return Money.of(money2.getNumberStripped(), money2.getCurrency());
                    }
                })
                .orElse(Money.of(0, availableMoney.getCurrency()));
    }

    private void initNewPlan() {
        plan = new ArrayList<>();
    }

    private List<FinancePlanEntry> scheduleDelayableTargets(List<FinanceTarget> targets) {
        List<FinanceTarget> delayedTargets = targets.parallelStream()
                .filter(FinanceTarget::isDelayable)
                .collect(Collectors.toList());

        if (delayedTargets.isEmpty()) {
            return plan;
        }

        Money maxLevel = getMaxLevel(plan);

        Money forSave = Money.of(0, availableMoney.getCurrency());

        for (FinanceTarget target : delayedTargets) {
            int months = Period.between(currentDate, target.getUntilDate())
                    .getMonths() + 1;

            // расчитываем количество, которые можем дополнить
            Money freeDeep = Money.of(0, availableMoney.getCurrency());
            int fromMonth = 0; // месяц с которого наинаем откладывать
            for (int i = months - 1; i >= 0; i--) {
                if (plan.size() > i) {
                    Money alreadyUsed = plan.get(i)
                            .getTotal();
                    freeDeep = freeDeep.add(maxLevel.subtract(alreadyUsed));
                } else {
                    freeDeep = freeDeep.add(maxLevel);
                }
                if (target.getAmount()
                        .isLessThanOrEqualTo(freeDeep)) {
                    fromMonth = i;
                    break;
                }
            }

            Money alreadyUsed = Money.of(0, target.getAmount()
                    .getCurrency());
            for (int i = fromMonth; i < plan.size(); i++) {
                if (i <= months) {
                    FinancePlanEntry entry = plan.get(i);
                    alreadyUsed = alreadyUsed.add(entry.getTotal());
                }
            }
            Money forSaveLimit = (alreadyUsed.add(target.getAmount())).divide(months - (long) fromMonth);
            Money saved = Money.of(0, target.getAmount()
                    .getCurrency());
            if (forSaveLimit.isGreaterThan(availableMoney)) {
                forSave = availableMoney;
            }

            int iteration = fromMonth;
            while (saved.isLessThan(target.getAmount())) {
                if (iteration + 1 > plan.size()) {
                    Date date = DateUtils.convertToDate(currentDate.plusMonths(iteration));
                    FinancePlanEntry entry = new FinancePlanEntry(date, forSave);
                    if (forSave.isGreaterThan(target.getAmount()
                            .subtract(saved))) {
                        forSave = target.getAmount()
                                .subtract(saved);
                    }
                    saved = saved.add(forSave);
                    entry.addDetailedMoney(target, forSave);
                    plan.add(entry);
                } else {
                    FinancePlanEntry entry = plan.get(iteration);
                    Money save = forSave.subtract(entry.getTotal());
                    if (save.isGreaterThan(target.getAmount()
                            .subtract(saved))) {
                        save = target.getAmount()
                                .subtract(saved);
                    }
                    saved = saved.add(save);
                    entry.addDetailedMoney(target, save);
                }
                iteration++;
            }
        }
        return plan;
    }

    private List<FinancePlanEntry> scheduleRegularTargets(List<FinanceTarget> targets) {
        List<FinanceTarget> regularTargets = targets.parallelStream()
                .filter(FinanceTarget::isRegular)
                .collect(Collectors.toList());

        if (regularTargets.isEmpty()) {
            return plan;
        }

        Money forSave;
        for (FinanceTarget target : regularTargets) {
            log.debug("Start plan Target {}", target.getName());

            int months = Period.between(currentDate, target.getUntilDate())
                    .getMonths() + 1;
            log.debug("{} month = {}", target.getName(), months);
            forSave = (target.getAmount()
                    .subtract(target.getSavedAmount())).divide(months);
            log.debug("{} forSave = {}", target.getName(), forSave);
            log.debug("Start cycle per month for {}", target.getName());
            for (int i = 0; i < months; i++) {
                log.debug("  i = {}", i);
                if (plan.isEmpty() || plan.size() <= i) {
                    log.debug(" i = {}; The condition for create new entry is {}", i, "TRUE");
                    LocalDate date = currentDate.plusMonths(i);
                    log.debug("{} plan date = {}", target.getName(), date);
                    Map<FinanceTarget, Money> byTargets = new HashMap<>();
                    byTargets.put(target, forSave);
                    FinancePlanEntry entry = new FinancePlanEntry(DateUtils.convertToDate(date), byTargets);
                    log.debug("Created entry {}", entry);
                    plan.add(entry);
                } else {
                    log.debug(" i = {}; The condition for create new entry is {}", i, "FALSE");
                    log.debug("Try to get item {} from plan with size {}", i, plan.size());
                    FinancePlanEntry entry = plan.get(i);
                    log.debug("Existing entry is got");
                    entry.addDetailedMoney(target, forSave);
                    log.debug("Target {} was added in existing entry", target.getName());
                }
            }
        }
        return plan;
    }

    private List<FinancePlanEntry> scheduleStrictTargets(List<FinanceTarget> targets) {
        List<FinanceTarget> targetList = targets.parallelStream()
                .filter(t -> !t.isDelayable() && !t.isRegular())
                .collect(Collectors.toList());

        if (targetList.isEmpty()) {
            return plan;
        }

        Money maxLevel = getMaxLevel(plan);

        for (FinanceTarget target : targetList) {
            int months = Period.between(currentDate, target.getUntilDate())
                    .getMonths() + 1;

            // расчитываем количество, которые можем дополнить
            Money freeDeep = Money.of(0, availableMoney.getCurrency());
            int fromMonth = 0; // месяц с которого наинаем откладывать
            for (int i = months - 1; i >= 0; i--) {
                if (plan.size() > i) {
                    Money alreadyUsed = plan.get(i)
                            .getTotal();
                    freeDeep = freeDeep.add(maxLevel.subtract(alreadyUsed));
                } else {
                    freeDeep = freeDeep.add(maxLevel);
                }
                if (target.getAmount()
                        .isLessThanOrEqualTo(freeDeep)) {
                    fromMonth = i;
                    break;
                }
            }

            Money alreadyUsed = Money.of(0, target.getAmount()
                    .getCurrency());
            for (int i = fromMonth; i < plan.size(); i++) {
                if (i <= months) {
                    FinancePlanEntry entry = plan.get(i);
                    alreadyUsed = alreadyUsed.add(entry.getTotal());
                }
            }
            Money forSaveLimit = (alreadyUsed.add(target.getAmount())).divide(months - (long) fromMonth);

            for (int i = fromMonth; i < months; i++) {
                if (i + 1 > plan.size()) {
                    Date date = DateUtils.convertToDate(currentDate.plusMonths(i));
                    FinancePlanEntry entry = new FinancePlanEntry(date, forSaveLimit);
                    entry.addDetailedMoney(target, forSaveLimit);
                    plan.add(entry);
                } else {
                    FinancePlanEntry entry = plan.get(i);
                    Money save = forSaveLimit.subtract(entry.getTotal());
                    entry.addDetailedMoney(target, save);
                }
            }
        }
        return plan;
    }

}
