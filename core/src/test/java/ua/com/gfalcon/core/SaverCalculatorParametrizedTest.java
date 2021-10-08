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

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.javamoney.moneta.Money;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ua.com.gfalcon.financier.model.currency.CurrencyCode;
import ua.com.gfalcon.financier.model.plan.FinancePlanEntry;
import ua.com.gfalcon.financier.model.plan.FinanceTarget;


/**
 * Tests of {@link SaverCalculator}.
 */
@RunWith(Parameterized.class)
public class SaverCalculatorParametrizedTest {

    private static final Date currentDate = new GregorianCalendar(2020, Calendar.JANUARY,
            1).getTime();
    @Parameter(value = 0)
    public               String                 description;
    @Parameter(value = 1)
    public               Money                  availableMoney;
    @Parameter(value = 2)
    public               List<FinanceTarget>    targets;
    @Parameter(value = 3)
    public               List<FinancePlanEntry> expectedResult;
    private              List<FinancePlanEntry> results;
    private              List<FinancePlanEntry> actual;
    private              List<FinancePlanEntry> expected;

    /**
     * Collection of test data.
     *
     * @return test data
     */
    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(twoTargetsWithTheSameEndDateAndEnoughMoney(), twoTargetsWithDifferentDateAndEnoughMoney(),
                twoTargetsWithDifferentDateAndLotOfMoney(), twoTargetsWithDifferentDateAndNotEnoughMoney(),
                twoRegularTargets());
    }

    @Test
    public void checkAmountsForEachTargets() {
        FinancePlanEntry expectedEntry;
        FinancePlanEntry actualEntry;
        for (int i = 0; i < actual.size(); i++) {
            expectedEntry = expected.get(i);
            actualEntry = actual.get(i);

            Assume.assumeNotNull(expectedEntry.getDetailedMoney(), actualEntry.getDetailedMoney());

            for (FinanceTarget target : expectedEntry.getDetailedMoney()
                    .keySet()) {
                Assert.assertEquals("Incorrect money amount for target: " + target.getName() + " on month " + i,
                        expectedEntry.getDetailedMoney()
                                .get(target), actualEntry.getDetailedMoney()
                                .get(target));
            }
        }
    }

    @Test
    public void checkDateForDoSaving() {
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals("Wrong date", expected.get(i)
                    .getDate(), actual.get(i)
                    .getDate());
        }
    }

    @Test
    public void checkDetailedPlanSize() {
        FinancePlanEntry expectedEntry;
        FinancePlanEntry actualEntry;
        for (int i = 0; i < actual.size(); i++) {
            expectedEntry = expected.get(i);
            actualEntry = actual.get(i);

            Assume.assumeNotNull(expectedEntry.getDetailedMoney(), actualEntry.getDetailedMoney());

            Assert.assertEquals("Wrong detailed plan size", expectedEntry.getDetailedMoney()
                    .size(), actualEntry.getDetailedMoney()
                    .size());
        }
    }

    @Test
    public void checkPlanSize() {
        Assert.assertEquals("Wrong size", expected.size(), actual.size());
    }

    @Test
    public void checkThatDetailedPlanIncludesTarget() {
        FinancePlanEntry expectedEntry;
        FinancePlanEntry actualEntry;
        for (int i = 0; i < actual.size(); i++) {
            expectedEntry = expected.get(i);
            actualEntry = actual.get(i);

            Assume.assumeNotNull(expectedEntry.getDetailedMoney(), actualEntry.getDetailedMoney());

            for (FinanceTarget target : expectedEntry.getDetailedMoney()
                    .keySet()) {
                Assert.assertTrue("Detailed plan does not contain target", actualEntry.getDetailedMoney()
                        .containsKey(target));
            }
        }
    }

    @Test
    public void checkTotalAmountForToSave() {
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals("Wrong amount of total. Wrong item id " + i, expected.get(i)
                    .getTotal(), actual.get(i)
                    .getTotal());
        }
    }

    @Test
    public void containsDetailedPlan() {
        for (int i = 0; i < actual.size(); i++) {
            Assume.assumeNotNull(expected.get(i)
                    .getDetailedMoney());
            Assert.assertNotNull("Entry does not contain detailed plan", actual.get(i)
                    .getDetailedMoney());
        }
    }

    /**
     * Set up test cases.
     */
    @Before
    public void setUp() throws Exception {
        Assume.assumeNotNull(targets, availableMoney, expectedResult);
        Assume.assumeFalse(targets.isEmpty());
        Assume.assumeFalse(expectedResult.isEmpty());

        results = SaverCalculator.calculate(availableMoney, targets, currentDate);
        Assume.assumeNotNull(results);
        actual = results.stream()
                .sorted(Comparator.comparing(FinancePlanEntry::getDate))
                .collect(Collectors.toList());
        expected = expectedResult.stream()
                .sorted(Comparator.comparing(FinancePlanEntry::getDate))
                .collect(Collectors.toList());
    }

    /**
     * Tear down test cases.
     */
    @After
    public void tearDown() throws Exception {
        results = null;
        actual = null;
        expected = null;
        targets.forEach(target -> target.setSavedAmount(null));
    }

    private static Object[] fullCase() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(40, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.MARCH, 15).getTime())
                .setAmount(Money.of(10, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target3 = FinanceTarget.builder()
                .setName("target 3")
                .setUntilDate(new GregorianCalendar(2020, Calendar.MAY, 15).getTime())
                .setAmount(Money.of(105, CurrencyCode.USD.name()))
                .setDelayable(true)
                .build();
        FinanceTarget target4 = FinanceTarget.builder()
                .setName("target 4")
                .setUntilDate(new GregorianCalendar(2020, Calendar.MAY, 15).getTime())
                .setAmount(Money.of(50, CurrencyCode.USD.name()))
                .setRegular(true)
                .build();
        return new Object[]{"hard case", Money.of(40, CurrencyCode.USD.name()), Arrays.asList(target1, target2, target3,
                target4), Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(20, CurrencyCode.USD.name()))
                .addDetailedMoney(target3, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target4, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(40, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(20, CurrencyCode.USD.name()))
                .addDetailedMoney(target3, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target4, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(40, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MARCH, 1).getTime())
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target3, Money.of(20, CurrencyCode.USD.name()))
                .addDetailedMoney(target4, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(40, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.APRIL, 1).getTime())
                .addDetailedMoney(target3, Money.of(30, CurrencyCode.USD.name()))
                .addDetailedMoney(target4, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(40, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MAY, 1).getTime())
                .addDetailedMoney(target3, Money.of(30, CurrencyCode.USD.name()))
                .addDetailedMoney(target4, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(40, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JUNE, 1).getTime())
                .addDetailedMoney(target3, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(5, CurrencyCode.USD.name()))
                .build())};
    }

    private static Object[] twoRegularTargets() {
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
        return new Object[]{"Two regular targets with enough money", Money.of(100,
                CurrencyCode.USD.name()), Arrays.asList(target1, target2), Arrays.asList(FinancePlanEntry.builder()
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
                .build())};
    }

    private static Object[] twoTargetsWithDifferentDateAndEnoughMoney() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(20, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.APRIL, 15).getTime())
                .setAmount(Money.of(60, CurrencyCode.USD.name()))
                .build();
        return new Object[]{"Two targets with different date and enough money", Money.of(100,
                CurrencyCode.USD.name()), Arrays.asList(target1, target2), Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(20, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(10, CurrencyCode.USD.name()))
                .setTotal(Money.of(20, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MARCH, 1).getTime())
                .addDetailedMoney(target2, Money.of(20, CurrencyCode.USD.name()))
                .setTotal(Money.of(20, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.APRIL, 1).getTime())
                .addDetailedMoney(target2, Money.of(20, CurrencyCode.USD.name()))
                .setTotal(Money.of(20, CurrencyCode.USD.name()))
                .build())};
    }

    private static Object[] twoTargetsWithDifferentDateAndLotOfMoney() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(20, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.APRIL, 15).getTime())
                .setAmount(Money.of(40, CurrencyCode.USD.name()))
                .build();
        return new Object[]{"Two targets with different date and a lot of money", Money.of(15,
                CurrencyCode.USD.name()), Arrays.asList(target1, target2), Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MARCH, 1).getTime())
                .addDetailedMoney(target2, Money.of(15, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.APRIL, 1).getTime())
                .addDetailedMoney(target2, Money.of(15, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build())};
    }

    private static Object[] twoTargetsWithDifferentDateAndNotEnoughMoney() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(20, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.APRIL, 15).getTime())
                .setAmount(Money.of(60, CurrencyCode.USD.name()))
                .setDelayable(true)
                .build();
        return new Object[]{"Two targets with different date and not enough money", Money.of(15,
                CurrencyCode.USD.name()), Arrays.asList(target1, target2), Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MARCH, 1).getTime())
                .addDetailedMoney(target2, Money.of(15, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.APRIL, 1).getTime())
                .addDetailedMoney(target2, Money.of(15, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.MAY, 1).getTime())
                .addDetailedMoney(target2, Money.of(15, CurrencyCode.USD.name()))
                .setTotal(Money.of(15, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JUNE, 1).getTime())
                .addDetailedMoney(target2, Money.of(5, CurrencyCode.USD.name()))
                .setTotal(Money.of(5, CurrencyCode.USD.name()))
                .build())};
    }

    private static Object[] twoTargetsWithTheSameEndDateAndEnoughMoney() {
        FinanceTarget target1 = FinanceTarget.builder()
                .setName("target 1")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(20, CurrencyCode.USD.name()))
                .build();
        FinanceTarget target2 = FinanceTarget.builder()
                .setName("target 2")
                .setUntilDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 15).getTime())
                .setAmount(Money.of(50, CurrencyCode.USD.name()))
                .build();
        return new Object[]{"Two targets with the same date and enough money", Money.of(100,
                CurrencyCode.USD.name()), Arrays.asList(target1, target2), Arrays.asList(FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(25, CurrencyCode.USD.name()))
                .setTotal(Money.of(35, CurrencyCode.USD.name()))
                .build(), FinancePlanEntry.builder()
                .setDate(new GregorianCalendar(2020, Calendar.FEBRUARY, 1).getTime())
                .addDetailedMoney(target1, Money.of(10, CurrencyCode.USD.name()))
                .addDetailedMoney(target2, Money.of(25, CurrencyCode.USD.name()))
                .setTotal(Money.of(35, CurrencyCode.USD.name()))
                .build())};
    }

}