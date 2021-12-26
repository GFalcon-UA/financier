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

package ua.com.financier.model.currency;

import javax.money.Monetary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ua.com.gfalcon.financier.model.currency.CurrencyProvider;

/**
 * Test of CurrencyProvider.
 */
public class CurrencyProviderTest {

    @Test
    public void defaultCurrencyProviderTest() {
        Assertions.assertTrue(Monetary.getCurrencyProviderNames()
                .contains(CurrencyProvider.DEFAULT), "Wrong default currency provider name");
    }

}