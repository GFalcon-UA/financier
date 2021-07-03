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

package ua.com.gfalcon.financier.server.domain.currency;

import java.util.Currency;

import javax.money.Monetary;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

/**
 * Tests of correct using of CurrencyCode.
 */
@RunWith(JUnitParamsRunner.class)
public class CurrencyCodeTest {

    @SuppressWarnings("unused")
    private Object[] getCurrencyCodes() {
        return Currency.getAvailableCurrencies()
                .parallelStream()
                .map(Currency::getCurrencyCode)
                .toArray();
    }

    @SuppressWarnings("unused")
    private Object[] getEnumValues() {
        return CurrencyCode.values();
    }

    @Test
    @Parameters(method = "getEnumValues")
    public void correctCurrencyEnumTest(CurrencyCode currencyCode) {
        Assert.assertNotNull(String.format("Currency code %s is invalid", currencyCode.name()),
                Currency.getInstance(currencyCode.name()));
    }

    @Test
    @Parameters(method = "getCurrencyCodes")
    public void currencyProviderTest(String code) {
        Assert.assertTrue(Monetary.isCurrencyAvailable(code, CurrencyProvider.DEFAULT));
    }

    @Test
    @Parameters(method = "getCurrencyCodes")
    public void fillingCurrencyEnumTest(String code) {
        Assert.assertNotNull(String.format("Currency code %s is not present", code), CurrencyCode.valueOf(code));
    }

}