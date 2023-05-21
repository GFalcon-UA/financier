/*
 * Copyright (c) 2016-2023 Oleksii Khalikov @GFalcon-UA (http://gfalcon.com.ua)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.com.financier.model.plan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import ua.com.gfalcon.financier.model.plan.FinancePlanEntry;
import ua.com.gfalcon.financier.model.plan.FinanceTarget;
import ua.com.gfalcon.financier.util.currency.CurrencyCode;


/**
 * Test of FinancePlanEntry.
 */
public class FinancePlanEntryTest {

    @Test
    public void createWithTargetListTest() {
        int amount1 = (int) (Math.random() * 10000);
        int amount2 = (int) (Math.random() * 10000);
        Map<FinanceTarget, Money> details = new HashMap<>();
        details.put(FinanceTarget.builder()
                .setAmount(Money.of(amount1, CurrencyCode.USD.name()))
                .build(), Money.of(amount1, CurrencyCode.USD.name()));
        details.put(FinanceTarget.builder()
                .setAmount(Money.of(amount2, CurrencyCode.USD.name()))
                .build(), Money.of(amount2, CurrencyCode.USD.name()));
        FinancePlanEntry entry = new FinancePlanEntry(new Date(), details);

        checkNotNull(entry);
        Assertions.assertTrue(entry.isDetailed());
        Assertions.assertEquals(Money.of(amount1 + amount2, CurrencyCode.USD.name()), entry.getTotal());
    }

    @Test
    public void createWithoutTargetListTest() {
        int amount = (int) (Math.random() * 10000);
        FinancePlanEntry entry = new FinancePlanEntry(new Date(), Money.of(amount, CurrencyCode.USD.name()));

        checkNotNull(entry);
        Assertions.assertFalse(entry.isDetailed());
        Assertions.assertEquals(Money.of(amount, CurrencyCode.USD.name()), entry.getTotal());
    }

    private void checkNotNull(FinancePlanEntry entry) {
        Assertions.assertNotNull(entry.getDate());
        Assertions.assertNotNull(entry.getDetailedMoney());
        Assertions.assertNotNull(entry.getTotal());
    }

}