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
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Summary
 */
@Validated
public class Summary {

    @ApiModelProperty(value = "")
    @JsonProperty("amount")
    @SerializedName("amount")
    private BigDecimal amount = null;

    @ApiModelProperty(value = "")
    @JsonProperty("currency")
    @SerializedName("currency")
    private String currency = null;

    @ApiModelProperty(value = "")
    @JsonProperty("isNull")
    @SerializedName("isNull")
    private Boolean isNull = null;

    @ApiModelProperty(value = "")
    @JsonProperty("timestamp")
    @SerializedName("timestamp")
    private Integer timestamp = null;

    @ApiModelProperty(value = "")
    @JsonProperty("value")
    @SerializedName("value")
    private String value = null;

    /**
     * Get amount
     *
     * @return amount
     **/
    @JsonProperty("amount")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Get currency
     *
     * @return currency
     **/
    @JsonProperty("currency")
    @ApiModelProperty(value = "")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Get timestamp
     *
     * @return timestamp
     **/
    @JsonProperty("timestamp")
    @ApiModelProperty(value = "")
    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @JsonProperty("value")
    @ApiModelProperty(value = "")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIsNull(Boolean isNull) {
        this.isNull = isNull;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency, isNull, timestamp, value);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Summary summary = (Summary) o;
        return Objects.equals(this.amount, summary.amount) && Objects.equals(this.currency, summary.currency)
                && Objects.equals(this.isNull, summary.isNull) && Objects.equals(this.timestamp, summary.timestamp)
                && Objects.equals(this.value, summary.value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Summary {\n");

        sb.append("    amount: ")
                .append(toIndentedString(amount))
                .append("\n");
        sb.append("    currency: ")
                .append(toIndentedString(currency))
                .append("\n");
        sb.append("    isNull: ")
                .append(toIndentedString(isNull))
                .append("\n");
        sb.append("    timestamp: ")
                .append(toIndentedString(timestamp))
                .append("\n");
        sb.append("    value: ")
                .append(toIndentedString(value))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Summary amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Summary currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get isNull
     *
     * @return isNull
     **/
    @JsonProperty("isNull")
    @ApiModelProperty(value = "")
    public Boolean isIsNull() {
        return isNull;
    }

    public Summary isNull(Boolean isNull) {
        this.isNull = isNull;
        return this;
    }

    public Summary timestamp(Integer timestamp) {
        this.timestamp = timestamp;
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

    public Summary value(String value) {
        this.value = value;
        return this;
    }
}

