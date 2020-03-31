/*
 *   Copyright 2016-2020 Oleksii V. KHALIKOV, PE
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

import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.persistence.Transient;
import org.javamoney.moneta.Money;
import ua.com.gfalcon.financier.server.util.Builder;
import ua.com.gfalcon.financier.server.util.DateUtils;

/**
 * Describing of finance target.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class FinanceTarget {

  private Money amount;
  private LocalDate untilDate;
  private String name;
  private boolean regular;

  @Transient
  private Money savedAmount;

  public static FinanceTargetBuilder builder() {
    return new FinanceTarget().new FinanceTargetBuilder();
  }

  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }

  public void setAmount(Number amount, Currency currency) {
    setAmount(amount, Monetary.getCurrency(currency.getCurrencyCode()));
  }

  public void setAmount(Number amount, CurrencyUnit currency) {
    setAmount(Money.of(amount, currency));
  }

  public LocalDate getUntilDate() {
    return untilDate;
  }

  public void setUntilDate(LocalDate untilDate) {
    this.untilDate = untilDate;
  }

  public void setUntilDate(Date untilDate) {
    this.untilDate = DateUtils.convertToLocalDate(untilDate);
  }

  public Date getUntilDateAsDate() {
    return DateUtils.convertToDate(untilDate);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isRegular() {
    return regular;
  }

  public void setRegular(boolean regular) {
    this.regular = regular;
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

  public void setSavedAmount(Money savedAmount) {
    this.savedAmount = savedAmount;
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

  public class FinanceTargetBuilder implements Builder<FinanceTarget> {

    private FinanceTargetBuilder() {

    }

    public FinanceTargetBuilder setAmount(Money value) {
      FinanceTarget.this.setAmount(value);
      return this;
    }

    public FinanceTargetBuilder setRegular(boolean isRegular) {
      FinanceTarget.this.setRegular(isRegular);
      return this;
    }

    public FinanceTargetBuilder setName(String name) {
      FinanceTarget.this.setName(name);
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
