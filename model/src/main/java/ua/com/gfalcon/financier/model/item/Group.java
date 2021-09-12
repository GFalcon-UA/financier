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

package ua.com.gfalcon.financier.model.item;

import java.math.BigDecimal;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.gfalcon.financier.model.currency.CurrencyProvider;

/**
 * Grouping of items.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public class Group implements Item {

    @Getter
    private List<Item> items;
    @Setter
    private String     name;

    @Override
    public Money getAmount() {
        BigDecimal number = BigDecimal.ZERO;
        CurrencyUnit currency = Monetary.getCurrency(CurrencyProvider.defaultCurrency.name());
        Money amount = Money.of(number, currency);
        for (Item item : items) {
            amount = amount.add(item.getAmount());
        }
        return amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
