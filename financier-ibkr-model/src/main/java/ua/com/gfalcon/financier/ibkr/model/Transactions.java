/*
 *   Copyright 2016-2022 Oleksii V. KHALIKOV
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

package ua.com.gfalcon.financier.ibkr.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * account transactions
 **/
@ApiModel(description = "account transactions")
@Validated
public class Transactions {

    @ApiModelProperty(value = "will always be getTransactions")
    /**
     * will always be getTransactions
     **/
    @JsonProperty("id")
    @SerializedName("id")
    private String id = null;

    @ApiModelProperty(value = "same as request")
    /**
     * same as request
     **/
    @JsonProperty("currency")
    @SerializedName("currency")
    private String currency = null;

    @ApiModelProperty(value = "Indicates whether current day and realtime data is included in the result")
    /**
     * Indicates whether current day and realtime data is included in the result
     **/
    @JsonProperty("includesRealTime")
    @SerializedName("includesRealTime")
    private Boolean includesRealTime = null;

    @ApiModelProperty(value = "Period start date. Epoch time, GMT")
    /**
     * Period start date. Epoch time, GMT
     **/
    @JsonProperty("from")
    @SerializedName("from")
    private BigDecimal from = null;

    @ApiModelProperty(value = "Period end date. Epoch time, GMT")
    /**
     * Period end date. Epoch time, GMT
     **/
    @JsonProperty("to")
    @SerializedName("to")
    private BigDecimal to = null;

    @ApiModelProperty(value = "Sorted by date descending")
    /**
     * Sorted by date descending
     **/
    @JsonProperty("transactions")
    @Valid
    @SerializedName("transactions")
    private List<Object> transactions = new ArrayList<Object>();

    /**
     * same as request
     *
     * @return currency
     **/
    @JsonProperty("currency")
    @ApiModelProperty(value = "same as request")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Period start date. Epoch time, GMT
     *
     * @return from
     **/
    @JsonProperty("from")
    @ApiModelProperty(value = "Period start date. Epoch time, GMT")
    @Valid
    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    /**
     * will always be getTransactions
     *
     * @return id
     **/
    @JsonProperty("id")
    @ApiModelProperty(value = "will always be getTransactions")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Period end date. Epoch time, GMT
     *
     * @return to
     **/
    @JsonProperty("to")
    @ApiModelProperty(value = "Period end date. Epoch time, GMT")
    @Valid
    public BigDecimal getTo() {
        return to;
    }

    public void setTo(BigDecimal to) {
        this.to = to;
    }

    /**
     * Sorted by date descending
     *
     * @return transactions
     **/
    @JsonProperty("transactions")
    @ApiModelProperty(value = "Sorted by date descending")
    public List<Object> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Object> transactions) {
        this.transactions = transactions;
    }

    public void setIncludesRealTime(Boolean includesRealTime) {
        this.includesRealTime = includesRealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, includesRealTime, from, to, transactions);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transactions transactions = (Transactions) o;
        return Objects.equals(this.id, transactions.id) && Objects.equals(this.currency, transactions.currency)
                && Objects.equals(this.includesRealTime, transactions.includesRealTime) && Objects.equals(this.from,
                transactions.from) && Objects.equals(this.to, transactions.to) && Objects.equals(this.transactions,
                transactions.transactions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transactions {\n");

        sb.append("    id: ")
                .append(toIndentedString(id))
                .append("\n");
        sb.append("    currency: ")
                .append(toIndentedString(currency))
                .append("\n");
        sb.append("    includesRealTime: ")
                .append(toIndentedString(includesRealTime))
                .append("\n");
        sb.append("    from: ")
                .append(toIndentedString(from))
                .append("\n");
        sb.append("    to: ")
                .append(toIndentedString(to))
                .append("\n");
        sb.append("    transactions: ")
                .append(toIndentedString(transactions))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Transactions addTransactionsItem(Object transactionsItem) {
        if (this.transactions == null) {
            this.transactions = new ArrayList<Object>();
        }
        this.transactions.add(transactionsItem);
        return this;
    }

    public Transactions currency(String currency) {
        this.currency = currency;
        return this;
    }

    public Transactions from(BigDecimal from) {
        this.from = from;
        return this;
    }

    public Transactions id(String id) {
        this.id = id;
        return this;
    }

    public Transactions includesRealTime(Boolean includesRealTime) {
        this.includesRealTime = includesRealTime;
        return this;
    }

    /**
     * Indicates whether current day and realtime data is included in the result
     *
     * @return includesRealTime
     **/
    @JsonProperty("includesRealTime")
    @ApiModelProperty(value = "Indicates whether current day and realtime data is included in the result")
    public Boolean isIncludesRealTime() {
        return includesRealTime;
    }

    public Transactions to(BigDecimal to) {
        this.to = to;
        return this;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString()
                .replace("\n", "\n    ");
    }

    public Transactions transactions(List<Object> transactions) {
        this.transactions = transactions;
        return this;
    }
}

