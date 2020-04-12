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
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.money.CurrencyUnit;
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
    Map<FinanceTarget, Money> alreadySaved = new HashMap<>();

    List<FinanceTarget> sortedTargetList = targets.stream()
        .sorted(Comparator
            .comparing(FinanceTarget::getUntilDate)
            .thenComparing(FinanceTarget::getAmount))
        .collect(Collectors.toList());

    sortedTargetList.forEach(target -> alreadySaved.put(target, target.getSavedAmount()));

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

    for (FinanceTarget target : targetList) {
      int months = Period.between(currentDate, target.getUntilDate()).getMonths() + 1;
      for (int i = 0; i < months; i++) {
        forSave = (target.getAmount().subtract(target.getSavedAmount())).divide(months);
        LocalDate date = currentDate.plusMonths(i);
        if (plan.isEmpty() || plan.size() <= i) {
          Map<FinanceTarget, Money> byTargets = new HashMap<>();
          byTargets.put(target, forSave);
          FinancePlanEntry entry = new FinancePlanEntry(DateUtils.convertToDate(date), byTargets);
          plan.add(entry);
        } else {
          FinancePlanEntry entry = plan.get(i);
          Money alreadySavedInPlan = plan.stream()
              .map(planEntry -> planEntry.getSavedAmountByTarget(target))
              .reduce(Money::add)
              .orElse(Money.of(0, target.getAmount().getCurrency()));
          forSave = (target.getAmount().subtract(target.getSavedAmount().add(alreadySavedInPlan)))
              .divide(months - i);
          entry.addDetailedMoney(target, forSave);
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

  private List<FinancePlanEntry> calculate() {
    List<FinanceTarget> targetList = targets.stream()
        .sorted(Comparator.comparing(FinanceTarget::getUntilDate))
        .collect(Collectors.toList());
    CurrencyUnit currency = availableMoney.getCurrency();
    int months = getMonths(targetList);

    Money optimalSaveBalance = getAmountPerPeriod(targetList, months, currency);

    if (optimalSaveBalance.isGreaterThan(availableMoney)) {
      List<FinanceTarget> delayableTargets = targetList.stream()
          .filter(FinanceTarget::isDelayable)
          .sorted(Comparator.comparing(FinanceTarget::getUntilDateAsDate)
              .thenComparing(FinanceTarget::getAmount))
          .collect(Collectors.toList());

      if (delayableTargets.isEmpty()) {
        // todo not enough money
        return null;
      } else {
        // move delayable targets
        optimalSaveBalance = availableMoney;
        List<FinanceTarget> fixedTarget = targetList.stream()
            .filter(t -> !t.isDelayable())
            .collect(Collectors.toList());

        Money fixedTargetsAmount = targetList.stream()
            .map(FinanceTarget::getAmount)
            .reduce(Money::add)
            .orElse(Money.of(0, currency));

        int monthsFixed = getMonths(fixedTarget);
        Money optimalSaveBalanceFixed = getAmountPerPeriod(fixedTarget, monthsFixed, currency);
        if (optimalSaveBalanceFixed.isGreaterThan(availableMoney)) {
          // todo not enough money
          return null;
        }

        List<FinancePlanEntry> plan = getFinancePlanEntries(fixedTarget, optimalSaveBalanceFixed);
        for (FinanceTarget target : delayableTargets) {
          List<FinancePlanEntry> list = plan.stream().filter(new Predicate<FinancePlanEntry>() {
            @Override
            public boolean test(FinancePlanEntry entry) {
              return entry.getLocalDate().isBefore(target.getUntilDate());
            }
          }).collect(Collectors.toList());

          for (FinancePlanEntry entry : list) {
            Money freeMoney = availableMoney.subtract(entry.getTotal());
            Money forSave = null;
            if (target.getAmount().isLessThanOrEqualTo(freeMoney)) {
              forSave = target.getAmount();
            } else {
              forSave = freeMoney;
            }
            target.setSavedAmount(target.getSavedAmount().add(forSave));
            Map<FinanceTarget, Money> detailedMoney = entry.getDetailedMoney();
            detailedMoney.put(target, forSave);
          }
          if (target.getAmount().isGreaterThan(target.getSavedAmount())) {
            int i = Period.between(currentDate, target.getUntilDate()).getMonths() - list.size();
            Money diff = (target.getAmount().subtract(target.getSavedAmount())).divide(i);
            Money forSave;
            for (int j = list.size(); j < plan.size(); j++) {
              FinancePlanEntry entry = plan.get(j);
              if (diff.isGreaterThan(availableMoney.subtract(entry.getTotal()))) {
                forSave = availableMoney.subtract(entry.getTotal());
              } else {
                forSave = diff;
              }
              target.setSavedAmount(forSave);
              Map<FinanceTarget, Money> detailedMoney = entry.getDetailedMoney();
              detailedMoney.put(target, forSave);
            }
            while (target.getSavedAmount().isLessThan(target.getAmount())) {
              Money subtract = target.getAmount().subtract(target.getSavedAmount());
              if (diff.isGreaterThan(subtract) && subtract.isLessThanOrEqualTo(availableMoney)) {
                forSave = subtract;
              } else if (diff.isGreaterThan(availableMoney)) {
                forSave = availableMoney;
              } else {
                forSave = diff;
              }
              LocalDate date = plan.get(plan.size() - 1).getLocalDate();
              target.setSavedAmount(target.getSavedAmount().add(forSave));
              FinancePlanEntry entry = FinancePlanEntry.builder()
                  .setDate(date.plusMonths(1L))
                  .addDetailedMoney(target, forSave)
                  .build();
              plan.add(entry);
            }
          }
        }
        return plan;
      }
    } else {
      // enough money
      return getFinancePlanEntries(targetList, optimalSaveBalance);
    }
  }

  private List<FinancePlanEntry> getFinancePlanEntries(List<FinanceTarget> targetList, Money optimalSaveBalance) {
    int months = getMonths(targetList);
    CurrencyUnit currency = optimalSaveBalance.getCurrency();
    List<FinancePlanEntry> plan = new ArrayList<>();
    for (int month = 0; month <= months; month++) {
      Money spend = Money.of(0, currency);
      FinancePlanEntry.FinancePlanEntryBuilder builder = FinancePlanEntry.builder()
          .setDate(currentDate.plusMonths(month));

      for (FinanceTarget target : targetList) {
        Money need = target.getAmountIn(currency);
        Money diffSaved = need.subtract(target.getSavedAmount());
        int periods = Period.between(currentDate, target.getUntilDate()).getMonths() - month;
        if (periods < 0) {
          continue;
        }
        Money forSave = diffSaved.divide(periods + 1);
        if (optimalSaveBalance.isLessThan(spend.add(forSave))) {
          forSave = optimalSaveBalance.subtract(spend);
        } else if (availableMoney.isLessThan(spend.add(forSave))) {
          forSave = availableMoney.subtract(spend);
        }
        if (forSave.isNegative()) {
          forSave = Money.of(0, currency);
        }
        target.setSavedAmount(forSave.add(target.getSavedAmount()));
        builder.addDetailedMoney(target, forSave);
        spend = spend.add(forSave);
      }

      FinancePlanEntry planEntry = builder.build();
      plan.add(planEntry);
    }
    return plan;
  }

  private Money getAmountPerPeriod(List<FinanceTarget> targetList, int months, CurrencyUnit currency) {
    return targetList.stream()
        .map(FinanceTarget::getAmount)
        .reduce(Money::add)
        .orElse(Money.of(0, currency))
        .divide(months + 1);
  }

  private int getMonths(List<FinanceTarget> targetList) {
    LocalDate maxDate = targetList.get(targetList.size() - 1).getUntilDate();

    return Period.between(
        currentDate,
        maxDate
    ).getMonths();
  }

}
