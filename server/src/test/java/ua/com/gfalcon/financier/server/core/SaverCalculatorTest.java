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

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;
import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import ua.com.gfalcon.financier.server.domain.FinancePlanEntry;
import ua.com.gfalcon.financier.server.domain.FinanceTarget;
import ua.com.gfalcon.financier.server.domain.currency.CurrencyCode;


@RunWith(Parameterized.class)
public class SaverCalculatorTest {

  private static Date currentDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
  @Parameter(value = 0)
  public Money availableMoney;
  @Parameter(value = 1)
  public List<FinanceTarget> targets;
  @Parameter(value = 2)
  public List<FinancePlanEntry> expectedResult;

  /**
   * Collection of test data.
   *
   * @return test data
   */
  @Parameters
  public static Iterable<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {
            Money.of(100, CurrencyCode.USD.name()),
            Arrays.asList(
                FinanceTarget.builder()
                    .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                    .setAmount(Money.of(20, CurrencyCode.USD.name()))
                    .build(),
                FinanceTarget.builder()
                    .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                    .setAmount(Money.of(50, CurrencyCode.USD.name()))
                    .build()
            ),
            Arrays.asList(
                FinancePlanEntry.builder()
                    .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                    .setTotal(Money.of(35, CurrencyCode.USD.name()))
                    .build(),
                FinancePlanEntry.builder()
                    .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                    .setTotal(Money.of(35, CurrencyCode.USD.name()))
                    .build()
            )
        },
    });
  }

  @Test
  public void calculate() {
    List<FinancePlanEntry> results = SaverCalculator
        .calculate(availableMoney, targets, currentDate);

    Assert.assertNotNull("Result must not be null", results);

    List<FinancePlanEntry> actual = results.stream()
        .sorted(Comparator.comparing(FinancePlanEntry::getDate))
        .collect(Collectors.toList());

    List<FinancePlanEntry> expected = expectedResult.stream()
        .sorted(Comparator.comparing(FinancePlanEntry::getDate))
        .collect(Collectors.toList());

    Assert.assertEquals("Wrong size", expected.size(), actual.size());

    for (int i = 0; i < actual.size(); i++) {
      FinancePlanEntry expectedEntry = expected.get(i);
      FinancePlanEntry actualEntry = actual.get(i);

      Assert.assertEquals("Wrong date",
          expectedEntry.getDate(), actualEntry.getDate());
      Assert.assertEquals("Wrong amount of total",
          expectedEntry.getTotal(), actualEntry.getTotal());
    }
  }

}