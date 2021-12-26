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

import java.util.Currency;
import java.util.stream.Stream;

import javax.money.Monetary;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import ua.com.gfalcon.financier.model.currency.CurrencyCode;
import ua.com.gfalcon.financier.model.currency.CurrencyProvider;

/**
 * Tests of correct using of CurrencyCode.
 */
class CurrencyCodeTest {

    private static Stream<Arguments> getCurrencyCodes() {
        return Currency.getAvailableCurrencies()
                .parallelStream()
                .map(Currency::getCurrencyCode)
                .map(Arguments::of);
    }
    
    @ParameterizedTest
    @EnumSource(CurrencyCode.class)
    void correctCurrencyEnumTest(CurrencyCode currencyCode) {
        assertNotNull(Currency.getInstance(currencyCode.name()),
                String.format("Currency code %s is invalid", currencyCode.name()));
    }

    @ParameterizedTest
    @MethodSource("getCurrencyCodes")
    void currencyProviderTest(String code) {
        assertTrue(Monetary.isCurrencyAvailable(code, CurrencyProvider.DEFAULT));
    }

    @ParameterizedTest
    @MethodSource("getCurrencyCodes")
    void fillingCurrencyEnumTest(String code) {
        assertNotNull(CurrencyCode.valueOf(code), String.format("Currency code %s is not present", code));
    }

}