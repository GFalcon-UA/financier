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
import java.util.List;
import java.util.stream.Collectors;
import org.javamoney.moneta.Money;
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

  private List<FinanceTarget> targets;
  private Money availableMoney;
  private LocalDate currentDate;

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
    List<FinancePlanEntry> plan = new ArrayList<>();
    List<FinanceTarget> targetList = targets.stream()
        .sorted(Comparator.comparing(FinanceTarget::getUntilDate))
        .collect(Collectors.toList());
    LocalDate maxDate = targetList.get(targetList.size() - 1).getUntilDate();

    int months = Period.between(
        currentDate,
        maxDate
    ).getMonths();

    for (int i = 0; i <= months; i++) {
      FinancePlanEntry planEntry = createPlanEntry(availableMoney, currentDate, targetList, i);
      plan.add(planEntry);
    }

    return plan;
  }

  private static FinancePlanEntry createPlanEntry(Money availableMoney,
                                                  LocalDate currentDate,
                                                  List<FinanceTarget> targets, int monthNumber) {
    FinancePlanEntry.FinancePlanEntryBuilder builder = FinancePlanEntry.builder()
        .setDate(currentDate.plusMonths(monthNumber));

    for (FinanceTarget target : targets) {
      Money need = target.getAmountIn(availableMoney.getCurrency());
      Money diffSaved = need.subtract(target.getSavedAmount());
      int periods = Period.between(currentDate, target.getUntilDate()).getMonths() - monthNumber;
      Money forSave = diffSaved.divide(periods + 1);
      target.setSavedAmount(forSave);
      builder.addDetailedMoney(target, forSave);
      availableMoney = availableMoney.subtract(forSave);
    }

    return builder.build();
  }

}
