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

package ua.com.gfalcon.financier.server.util;

import java.util.Objects;

import javax.money.CurrencyUnit;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;

import ua.com.gfalcon.financier.model.currency.CurrencyCode;


/**
 * Util class for working with {@link Money}.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class MoneyUtils {

    private MoneyUtils() {

    }

    /**
     * Convert money amount to another currency.
     *
     * @param input        input amount
     * @param currencyCode target currency
     * @return output amount
     */
    public static Money convertMoneyToCurrency(Money input, CurrencyCode currencyCode) {
        if (Objects.isNull(input)) {
            return Money.of(0, currencyCode.name());
        }

        CurrencyConversion conversion = MonetaryConversions.getConversion(currencyCode.name());
        return input.with(conversion);
    }

    /**
     * Convert money amount to another currency.
     *
     * @param input    input amount
     * @param currency target currency
     * @return output amount
     */
    public static Money convertMoneyToCurrency(Money input, CurrencyUnit currency) {
        if (Objects.isNull(input)) {
            return Money.of(0, currency);
        }

        CurrencyConversion conversion = MonetaryConversions.getConversion(currency.getCurrencyCode());
        return input.with(conversion);
    }

}
