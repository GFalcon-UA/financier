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

package ua.com.gfalcon.financier.server.domain;

import javax.money.Monetary;

import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;

import ua.com.gfalcon.financier.server.domain.plan.FinanceTarget;

/**
 * Test {@link FinanceTarget}.
 */
public class FinanceTargetTest {


    @Test
    public void getAmountInTest() {
        FinanceTarget target = new FinanceTarget();
        int usdAmount = (int) (Math.random() * 1000);
        target.setAmount(Money.of(usdAmount, "USD"));

        Money eur = target.getAmountIn(Monetary.getCurrency("EUR"));

        Assert.assertEquals("Wrong first amount set", usdAmount, target.getAmount()
                .getNumberStripped()
                .intValue());

        Assert.assertNotNull(eur);
    }

}
