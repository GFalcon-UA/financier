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

package ua.com.gfalcon.financier.server.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.com.gfalcon.financier.server.domain.currency.CurrencyCode;
import ua.com.gfalcon.financier.server.domain.plan.FinancePlanEntry;
import ua.com.gfalcon.financier.server.domain.plan.FinanceTarget;

/**
 * Tests of {@link SaverCalculator}.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class SaverCalculatorTest {

    private static final Date currentDate = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testRegular() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(40, CurrencyCode.USD.name()))
                .setRegular(true)
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.MARCH, 15).getTime())
                .setAmount(Money.of(30, CurrencyCode.USD.name()))
                .setRegular(true)
                .build();

        Money availableMoney = Money.of(100, CurrencyCode.USD.name());
        List<FinanceTarget> targets = Arrays.asList(target1, target2);
        List<FinancePlanEntry> expectedPlan = Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(20, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(30, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(20, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(30, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MARCH, 1).getTime())
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(10, CurrencyCode.USD.name()))
                .build());

        List<FinancePlanEntry> actualPlan = SaverCalculator.calculate(availableMoney, targets, currentDate);

        Assert.assertArrayEquals("", expectedPlan.toArray(new FinancePlanEntry[0]),
                actualPlan.toArray(new FinancePlanEntry[0]));

    }

    @Test
    public void testSetNullPlan() {
        SaverCalculator calculator = new SaverCalculator(Money.of(100, CurrencyCode.USD.name()), Arrays.asList(
                FinanceTarget.builder()
                        .setName("target 1")
                        .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                        .setAmount(Money.of(40, CurrencyCode.USD.name()))
                        .setRegular(true)
                        .build(), FinanceTarget.builder()
                        .setName("target 2")
                        .setUntilDate(new GregorianCalendar(2020, Calendar.MARCH, 15).getTime())
                        .setAmount(Money.of(30, CurrencyCode.USD.name()))
                        .setRegular(true)
                        .build()));

        List<FinancePlanEntry> plan = calculator.calc();

        Assert.assertFalse(calculator.setPreparedPlan(new ArrayList<>()));
        Assert.assertArrayEquals(plan.toArray(new FinancePlanEntry[0]), calculator.getPlan()
                .toArray(new FinancePlanEntry[0]));
    }

}
