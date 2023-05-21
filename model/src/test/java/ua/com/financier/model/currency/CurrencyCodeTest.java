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

package ua.com.financier.model.currency;

import java.util.Arrays;
import java.util.Currency;
import java.util.stream.Stream;

import javax.money.Monetary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ua.com.gfalcon.financier.util.currency.CurrencyCode;
import ua.com.gfalcon.financier.util.currency.CurrencyProvider;

/**
 * Tests of correct using of CurrencyCode.
 */
public class CurrencyCodeTest {

    @SuppressWarnings("unused")
    private static Stream<Arguments> getCurrencyCodes() {
        return Currency.getAvailableCurrencies()
                .parallelStream()
                .map(Currency::getCurrencyCode)
                .map(Arguments::of);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> getEnumValues() {
        return Arrays.stream(CurrencyCode.values()).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("getEnumValues")
    public void correctCurrencyEnumTest(CurrencyCode currencyCode) {
        Assertions.assertNotNull(Currency.getInstance(currencyCode.name()),
                String.format("Currency code %s is invalid", currencyCode.name()));
    }

    @ParameterizedTest
    @MethodSource("getCurrencyCodes")
    public void currencyProviderTest(String code) {
        Assertions.assertTrue(Monetary.isCurrencyAvailable(code, CurrencyProvider.DEFAULT));
    }

    @ParameterizedTest
    @MethodSource("getCurrencyCodes")
    public void fillingCurrencyEnumTest(String code) {
        CurrencyCode object = null;
        try {
            object = CurrencyCode.valueOf(code);
        } catch (Exception e) {
            Assertions.fail("No found currency code: " + code);
        }
        Assertions.assertNotNull(object, String.format("Currency code %s is not present", code));
    }

}