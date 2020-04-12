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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.javamoney.moneta.Money;
import ua.com.gfalcon.financier.server.domain.currency.CurrencyCode;
import ua.com.gfalcon.financier.server.util.Builder;
import ua.com.gfalcon.financier.server.util.DateUtils;

/**
 * One entry of finance plan.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class FinancePlanEntry {

  private Date date;
  private Map<FinanceTarget, Money> detailedMoney;
  private Money total;

  /**
   * Create plan entry without details.
   *
   * @param date  date
   * @param total total amount
   */
  public FinancePlanEntry(Date date, Money total) {
    setDate(date);
    setTotal(total);
    detailedMoney = new HashMap<>();
  }

  public FinancePlanEntry(Date date, Map<FinanceTarget, Money> detailedMoney) {
    setDate(date);
    setDetailedMoney(detailedMoney);
  }

  private FinancePlanEntry() {

  }

  public static FinancePlanEntryBuilder builder() {
    return new FinancePlanEntry().new FinancePlanEntryBuilder();
  }

  public boolean isDetailed() {
    return !(Objects.isNull(this.detailedMoney) || this.detailedMoney.isEmpty());
  }

  public Date getDate() {
    return date;
  }

  public LocalDate getLocalDate() {
    return DateUtils.convertToLocalDate(date);
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Map<FinanceTarget, Money> getDetailedMoney() {
    return detailedMoney;
  }

  /**
   * Set details.
   *
   * @param detailedMoney details map.
   */
  public void setDetailedMoney(Map<FinanceTarget, Money> detailedMoney) {
    this.detailedMoney = detailedMoney;
//    Optional<Money> amount = detailedMoney.values().stream().reduce(Money::add);
//    setTotal(amount.orElse(Money.of(0, CurrencyCode.USD.name())));
  }

  /**
   * Add entry to detail by target.
   *
   * @param target  finance target.
   * @param forSave amount for save.
   */
  public void addDetailedMoney(FinanceTarget target, Money forSave) {
    if (this.detailedMoney == null) {
      this.detailedMoney = new HashMap<>();
    }
    if (this.detailedMoney.containsKey(target)) {
      this.detailedMoney.replace(target, forSave);
    } else {
      this.detailedMoney.put(target, forSave);
    }
//    setTotal(getTotal().add(forSave));
  }

  /**
   * Get saved amount by finance target in this entry.
   *
   * @param target finance target.
   * @return money amount.
   */
  public Money getSavedAmountByTarget(FinanceTarget target) {
    if (detailedMoney == null || detailedMoney.isEmpty() || !detailedMoney.containsKey(target)) {
      return Money.of(0, target.getAmount().getCurrency());
    }
    return detailedMoney.get(target);
  }

  /**
   * Get total amount for this plan entry.
   *
   * @return amount
   */
  public Money getTotal() {
    if (isDetailed()) {
      return this.detailedMoney.values()
          .stream().reduce(Money::add).orElse(Money.of(0, CurrencyCode.USD.name()));
    }
    return total;
  }

  public void setTotal(Money total) {
    this.total = total;
  }

  public class FinancePlanEntryBuilder implements Builder<FinancePlanEntry> {

    private FinancePlanEntryBuilder() {

    }

    public FinancePlanEntryBuilder setDate(Date date) {
      FinancePlanEntry.this.setDate(date);
      return this;
    }

    public FinancePlanEntryBuilder setDate(LocalDate localDate) {
      return this.setDate(DateUtils.convertToDate(localDate));
    }

    public FinancePlanEntryBuilder setTotal(Money amount) {
      FinancePlanEntry.this.setTotal(amount);
      return this;
    }

    /**
     * Add target to finance plan.
     *
     * @param target finance target.
     * @param money  money amount for target.
     * @return builder
     */
    public FinancePlanEntryBuilder addDetailedMoney(FinanceTarget target, Money money) {
      if (Objects.isNull(FinancePlanEntry.this.getDetailedMoney())) {
        FinancePlanEntry.this.setDetailedMoney(new HashMap<>());
      }
      FinancePlanEntry.this.getDetailedMoney().put(target, money);
      return this;
    }

    @Override
    public FinancePlanEntry build() {
      return FinancePlanEntry.this;
    }

  }

}
