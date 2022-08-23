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

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contains all details of the contract, including rules you can use when placing orders
 **/
@ApiModel(description = "Contains all details of the contract, including rules you can use when placing orders")
@Validated
public class Contract {

    /**
     * true means you can trade outside RTH(regular trading hours)
     **/
    @JsonProperty("r_t_h")
    @ApiModelProperty(value = "true means you can trade outside RTH(regular trading hours)")
    @SerializedName("r_t_h")
    private Boolean rTH = null;

    /**
     * same as that in request
     **/
    @JsonProperty("con_id")
    @ApiModelProperty(value = "same as that in request")
    @SerializedName("con_id")
    private String conId = null;

    /**
     * Contracts company name
     **/
    @JsonProperty("company_name")
    @ApiModelProperty(value = "Contracts company name")
    @SerializedName("company_name")
    private String companyName = null;

    @JsonProperty("exchange")
    @ApiModelProperty(value = "")
    @SerializedName("exchange")
    private String exchange = null;

    /**
     * for exmple FB
     **/
    @JsonProperty("local_symbol")
    @ApiModelProperty(value = "for exmple FB")
    @SerializedName("local_symbol")
    private String localSymbol = null;

    /**
     * for example STK
     **/
    @JsonProperty("instrument_type")
    @ApiModelProperty(value = "for example STK")
    @SerializedName("instrument_type")
    private String instrumentType = null;

    @JsonProperty("currency")
    @ApiModelProperty(value = "")
    @SerializedName("currency")
    private String currency = null;

    @JsonProperty("companyName")
    @ApiModelProperty(value = "")
    @SerializedName("companyName")
    private String companyName2 = null;

    @JsonProperty("category")
    @ApiModelProperty(value = "")
    @SerializedName("category")
    private String category = null;

    @JsonProperty("industry")
    @ApiModelProperty(value = "")
    @SerializedName("industry")
    private String industry = null;

    @JsonProperty("rules")
    @ApiModelProperty(value = "")
    @SerializedName("rules")
    private Object rules = null;

    /**
     * Get category
     *
     * @return category
     **/
    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Contracts company name
     *
     * @return companyName
     **/
    @JsonProperty("company_name")
    @ApiModelProperty(value = "Contracts company name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get companyName
     *
     * @return companyName
     **/
    @JsonProperty("companyName")
    public String getCompanyName2() {
        return companyName2;
    }

    public void setCompanyName2(String companyName) {
        this.companyName = companyName;
    }

    /**
     * same as that in request
     *
     * @return conId
     **/
    @JsonProperty("con_id")
    @ApiModelProperty(value = "same as that in request")
    public String getConId() {
        return conId;
    }

    public void setConId(String conId) {
        this.conId = conId;
    }

    /**
     * Get currency
     *
     * @return currency
     **/
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Get exchange
     *
     * @return exchange
     **/
    @JsonProperty("exchange")
    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * Get industry
     *
     * @return industry
     **/
    @JsonProperty("industry")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * for example STK
     *
     * @return instrumentType
     **/
    @JsonProperty("instrument_type")
    @ApiModelProperty(value = "for example STK")
    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    /**
     * for example FB
     *
     * @return localSymbol
     **/
    @JsonProperty("local_symbol")
    @ApiModelProperty(value = "for example FB")
    public String getLocalSymbol() {
        return localSymbol;
    }

    public void setLocalSymbol(String localSymbol) {
        this.localSymbol = localSymbol;
    }

    /**
     * Get rules
     *
     * @return rules
     **/
    @JsonProperty("rules")
    public Object getRules() {
        return rules;
    }

    public void setRules(Object rules) {
        this.rules = rules;
    }

    public void setRTH(Boolean rTH) {
        this.rTH = rTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rTH, conId, companyName, exchange, localSymbol, instrumentType, currency, companyName,
                category, industry, rules);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contract contract = (Contract) o;
        return Objects.equals(this.rTH, contract.rTH) && Objects.equals(this.conId, contract.conId) && Objects.equals(
                this.companyName, contract.companyName) && Objects.equals(this.exchange, contract.exchange)
                && Objects.equals(this.localSymbol, contract.localSymbol) && Objects.equals(this.instrumentType,
                contract.instrumentType) && Objects.equals(this.currency, contract.currency) && Objects.equals(
                this.companyName, contract.companyName) && Objects.equals(this.category, contract.category)
                && Objects.equals(this.industry, contract.industry) && Objects.equals(this.rules, contract.rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Contract {\n");

        sb.append("    rTH: ")
                .append(toIndentedString(rTH))
                .append("\n");
        sb.append("    conId: ")
                .append(toIndentedString(conId))
                .append("\n");
        sb.append("    companyName: ")
                .append(toIndentedString(companyName))
                .append("\n");
        sb.append("    exchange: ")
                .append(toIndentedString(exchange))
                .append("\n");
        sb.append("    localSymbol: ")
                .append(toIndentedString(localSymbol))
                .append("\n");
        sb.append("    instrumentType: ")
                .append(toIndentedString(instrumentType))
                .append("\n");
        sb.append("    currency: ")
                .append(toIndentedString(currency))
                .append("\n");
        sb.append("    companyName: ")
                .append(toIndentedString(companyName))
                .append("\n");
        sb.append("    category: ")
                .append(toIndentedString(category))
                .append("\n");
        sb.append("    industry: ")
                .append(toIndentedString(industry))
                .append("\n");
        sb.append("    rules: ")
                .append(toIndentedString(rules))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Contract category(String category) {
        this.category = category;
        return this;
    }

    public Contract companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Contract companyName2(String companyName) {
        this.companyName2 = companyName;
        return this;
    }

    public Contract conId(String conId) {
        this.conId = conId;
        return this;
    }

    public Contract currency(String currency) {
        this.currency = currency;
        return this;
    }

    public Contract exchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public Contract industry(String industry) {
        this.industry = industry;
        return this;
    }

    public Contract instrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
        return this;
    }

    /**
     * true means you can trade outside RTH(regular trading hours)
     *
     * @return rTH
     **/
    @JsonProperty("r_t_h")
    @ApiModelProperty(value = "true means you can trade outside RTH(regular trading hours)")
    public Boolean isRTH() {
        return rTH;
    }

    public Contract localSymbol(String localSymbol) {
        this.localSymbol = localSymbol;
        return this;
    }

    public Contract rTH(Boolean rTH) {
        this.rTH = rTH;
        return this;
    }

    public Contract rules(Object rules) {
        this.rules = rules;
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
}

