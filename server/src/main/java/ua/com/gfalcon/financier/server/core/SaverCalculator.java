/*
 *   Copyright 2016-2020 Oleksii V. KHALIKOV, PE
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

package ua.com.gfalcon.financier.server.core;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.gfalcon.financier.server.domain.FinancePlanEntry;
import ua.com.gfalcon.financier.server.domain.FinanceTarget;
import ua.com.gfalcon.financier.server.util.DateUtils;

/**
 * Saver calculator.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class SaverCalculator {

  private static final Logger LOG = LoggerFactory.getLogger(SaverCalculator.class);

  private final List<FinanceTarget> targets;
  private final Money availableMoney;
  private final LocalDate currentDate;

  public SaverCalculator(Money availableMoney, List<FinanceTarget> targets) {
    this(availableMoney, targets, LocalDate.now());
  }

  public SaverCalculator(Money availableMoney, List<FinanceTarget> targets, Date currentDate) {
    this(availableMoney, targets, DateUtils.convertToLocalDate(currentDate));
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
  }

  public static List<FinancePlanEntry> calculate(
      Money availableMoney, List<FinanceTarget> targets
  ) {
    return calculate(availableMoney, targets, LocalDate.now());
  }

  public static List<FinancePlanEntry> calculate(
      Money availableMoney, List<FinanceTarget> targets, Date currentDate
  ) {
    return calculate(availableMoney, targets, DateUtils.convertToLocalDate(currentDate));
  }

  /**
   * Calculate finance plan.
   *
   * @param availableMoney available money
   * @param targets        list of finance targets
   * @param currentDate    current date
   * @return finance plan of saving/
   */
  public static List<FinancePlanEntry> calculate(
      Money availableMoney, List<FinanceTarget> targets, LocalDate currentDate
  ) {

    return new SaverCalculator(availableMoney, targets, currentDate).calc();
  }

  private List<FinancePlanEntry> calc() {
    List<FinancePlanEntry> plan = new ArrayList<>();

    List<FinanceTarget> sortedTargetList = targets.stream()
        .sorted(Comparator
            .comparing(FinanceTarget::getUntilDate)
            .thenComparing(FinanceTarget::getAmount))
        .collect(Collectors.toList());

    List<FinanceTarget> regularTargets = sortedTargetList.parallelStream()
        .filter(FinanceTarget::isRegular)
        .collect(Collectors.toList());

    Money forSave;
    for (FinanceTarget target : regularTargets) {
      LOG.debug("Start plan Target {}", target.getName());

      int months = Period.between(currentDate, target.getUntilDate()).getMonths() + 1;
      LOG.debug("{} month = {}", target.getName(), months);
      forSave = (target.getAmount().subtract(target.getSavedAmount())).divide(months);
      LOG.debug("{} forSave = {}", target.getName(), forSave);
      LOG.debug("Start cycle per month for {}", target.getName());
      for (int i = 0; i < months; i++) {
        LOG.debug("  i = {}", i);
        if (plan.isEmpty() || plan.size() <= i) {
          LOG.debug(" i = {}; The condition for create new entry is {}", i, "TRUE");
          LocalDate date = currentDate.plusMonths(i);
          LOG.debug("{} plan date = {}", target.getName(), date.toString());
          Map<FinanceTarget, Money> byTargets = new HashMap<>();
          byTargets.put(target, forSave);
          FinancePlanEntry entry = new FinancePlanEntry(DateUtils.convertToDate(date), byTargets);
          LOG.debug("Created entry {}", entry);
          plan.add(entry);
        } else {
          LOG.debug(" i = {}; The condition for create new entry is {}", i, "FALSE");
          LOG.debug("Try to get item {} from plan with size {}", i, plan.size());
          FinancePlanEntry entry = plan.get(i);
          LOG.debug("Existing entry is got");
          entry.addDetailedMoney(target, forSave);
          LOG.debug("Target {} was added in existing entry", target.getName());
        }
      }
    }

    List<Money> savedPlan = plan.stream()
        .map(FinancePlanEntry::getTotal)
        .collect(Collectors.toList());

    Money maxLevel = savedPlan.stream().reduce((money, money2) -> {
      if (money.isGreaterThanOrEqualTo(money2)) {
        return Money.of(money.getNumberStripped(), money.getCurrency());
      } else {
        return Money.of(money2.getNumberStripped(), money2.getCurrency());
      }
    }).orElse(Money.of(0, availableMoney.getCurrency()));

    List<FinanceTarget> targetList = sortedTargetList.parallelStream()
        .filter(t -> !t.isDelayable() && !t.isRegular())
        .collect(Collectors.toList());

    LocalDate maxLocalDate = targetList.stream()
        .map(FinanceTarget::getUntilDate)
        .reduce((date, date2) -> date.isBefore(date2) ? date2 : date)
        .orElse(currentDate);

    Date maxDate = DateUtils.convertToDate(maxLocalDate);

    while (!plan.isEmpty() && plan.get(plan.size() - 1).getDate().before(maxDate)) {
      Date lastDate = plan.get(plan.size() - 1).getDate();
      LocalDate localDate = DateUtils.convertToLocalDate(lastDate).plusMonths(1);
      plan.add(new FinancePlanEntry(DateUtils.convertToDate(localDate),
          Money.of(0, availableMoney.getCurrency())));
    }

    for (FinanceTarget target : targetList) {
      int months = Period.between(currentDate, target.getUntilDate()).getMonths() + 1;

      // расчитываем количество, которые можем дополнить
      Money freeDeep = Money.of(0, availableMoney.getCurrency());
      int fromMonth = 0; // месяц с которого наинаем откладывать
      for (int i = months - 1; i >= 0; i--) {
        if (plan.size() > i) {
          Money alreadyUsed = plan.get(i).getTotal();
          freeDeep = freeDeep.add(maxLevel.subtract(alreadyUsed));
        } else {
          freeDeep = freeDeep.add(maxLevel);
        }
        if (target.getAmount().isLessThanOrEqualTo(freeDeep)) {
          fromMonth = i;
          break;
        }
      }

      Money alreadyUsed = Money.of(0, target.getAmount().getCurrency());
      for (int i = fromMonth; i < plan.size(); i++) {
        if (i <= months) {
          FinancePlanEntry entry = plan.get(i);
          alreadyUsed = alreadyUsed.add(entry.getTotal());
        }
      }
      Money forSaveLimit = (alreadyUsed.add(target.getAmount())).divide(months - fromMonth);

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

    List<FinanceTarget> delayedTargets = sortedTargetList.parallelStream()
        .filter(FinanceTarget::isDelayable)
        .collect(Collectors.toList());

    for (FinanceTarget target : delayedTargets) {

    }

    return plan;
  }
}
