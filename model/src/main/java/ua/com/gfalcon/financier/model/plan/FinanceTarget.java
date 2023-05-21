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

package ua.com.gfalcon.financier.model.plan;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;

import ua.com.gfalcon.financier.util.Builder;
import ua.com.gfalcon.financier.util.DateUtils;

/**
 * Describing of finance target.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class FinanceTarget {

    private Money     amount;
    private LocalDate untilDate;
    private String    name;
    private boolean   regular;
    private boolean   delayable;
    private LocalDate optimisticDate;

    private Money savedAmount; // FIXME: 25.07.21 transient

    public Money getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getOptimisticDate() {
        return optimisticDate;
    }

    /**
     * Get amount of already saved money.
     *
     * @return amount (temporary field)
     */
    public Money getSavedAmount() {
        if (Objects.isNull(savedAmount)) {
            setSavedAmount(Money.of(0, getAmount().getCurrency()));
        }
        return savedAmount;
    }

    public LocalDate getUntilDate() {
        return untilDate;
    }

    public Date getUntilDateAsDate() {
        return DateUtils.convertToDate(untilDate);
    }

    public boolean isDelayable() {
        return delayable;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public void setDelayable(boolean delayable) {
        this.delayable = delayable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOptimisticDate(LocalDate optimisticDate) {
        this.optimisticDate = optimisticDate;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public void setSavedAmount(Money savedAmount) {
        this.savedAmount = savedAmount;
    }

    public void setUntilDate(LocalDate untilDate) {
        this.untilDate = untilDate;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = DateUtils.convertToLocalDate(untilDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getUntilDate(), getName(), isRegular(), isDelayable(), getOptimisticDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FinanceTarget)) {
            return false;
        }
        FinanceTarget that = (FinanceTarget) o;
        return isRegular() == that.isRegular() && isDelayable() == that.isDelayable() && getAmount().equals(
                that.getAmount()) && getUntilDate().equals(that.getUntilDate()) && getName().equals(that.getName())
                && Objects.equals(getOptimisticDate(), that.getOptimisticDate());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FinanceTarget{");
        sb.append("amount=")
                .append(amount);
        sb.append(", untilDate=")
                .append(untilDate);
        sb.append(", name='")
                .append(name)
                .append('\'');
        sb.append(", regular=")
                .append(regular);
        sb.append(", delayable=")
                .append(delayable);
        sb.append(", optimisticDate=")
                .append(optimisticDate);
        sb.append(", savedAmount=")
                .append(savedAmount);
        sb.append('}');
        return sb.toString();
    }

    public static FinanceTargetBuilder builder() {
        return new FinanceTarget().new FinanceTargetBuilder();
    }

    /**
     * Convert amount value with currency exchange rate.
     *
     * @param currency target currency/
     * @return converted value
     */
    public Money getAmountIn(CurrencyUnit currency) {
        if (Objects.isNull(getAmount())) {
            return Money.of(0, currency);
        }

        CurrencyConversion conversion = MonetaryConversions.getConversion(currency.getCurrencyCode());
        return getAmount().with(conversion);
    }

    public void setAmountIn(Number amount, Currency currency) {
        setAmountIn(amount, Monetary.getCurrency(currency.getCurrencyCode()));
    }

    public void setAmountIn(Number amount, CurrencyUnit currency) {
        setAmount(Money.of(amount, currency));
    }

    /**
     * Builder of finance targets.
     */
    public class FinanceTargetBuilder implements Builder<FinanceTarget> {

        private FinanceTargetBuilder() {

        }

        public FinanceTargetBuilder setAmount(Money value) {
            FinanceTarget.this.setAmount(value);
            return this;
        }

        public FinanceTargetBuilder setDelayable(boolean delayable) {
            FinanceTarget.this.setDelayable(delayable);
            return this;
        }

        public FinanceTargetBuilder setName(String name) {
            FinanceTarget.this.setName(name);
            return this;
        }

        public FinanceTargetBuilder setRegular(boolean isRegular) {
            FinanceTarget.this.setRegular(isRegular);
            return this;
        }

        public FinanceTargetBuilder setUntilDate(Date date) {
            FinanceTarget.this.setUntilDate(date);
            return this;
        }

        @Override
        public FinanceTarget build() {
            return FinanceTarget.this;
        }

    }

}
