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

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Symbol or Company Name to be searched.
 */
@ApiModel(description = "Symbol or Company Name to be searched")
@Validated
public class Symbol {

    /**
     * symbol or name to be searched.
     */
    @ApiModelProperty(value = "symbol or name to be searched")
    @JsonProperty("symbol")
    @SerializedName("symbol")
    @NotNull
    private String symbol = null;

    /**
     * should be true if the search is to be performed by name. false by default.
     */
    @ApiModelProperty(value = "should be true if the search is to be performed by name. false by default.")
    @JsonProperty("name")
    @SerializedName("name")
    private Boolean name = null;

    /**
     * If search is done by name, only the assets provided in this field will be returned. Currently, only STK is supported.
     */
    @ApiModelProperty(value = "If search is done by name, only the assets provided in this field will be returned. Currently, only STK is supported.")
    @JsonProperty("secType")
    @SerializedName("secType")
    private String secType = null;

    /**
     * symbol or name to be searched.
     */
    @ApiModelProperty(value = "symbol or name to be searched")
    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * should be true if the search is to be performed by name. false by default.
     */
    @ApiModelProperty(value = "should be true if the search is to be performed by name. false by default.")
    @JsonProperty("name")
    public Boolean getName() {
        return name;
    }

    public void setName(Boolean name) {
        this.name = name;
    }

    /**
     * If search is done by name, only the assets provided in this field will be returned. Currently, only STK is supported.
     */
    @ApiModelProperty(value = "If search is done by name, only the assets provided in this field will be returned. Currently, only STK is supported.")
    @JsonProperty("secType")
    public String getSecType() {
        return secType;
    }

    public void setSecType(String secType) {
        this.secType = secType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol1 = (Symbol) o;
        return getSymbol().equals(symbol1.getSymbol()) && Objects.equals(getName(), symbol1.getName())
                && Objects.equals(getSecType(), symbol1.getSecType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol(), getName(), getSecType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Symbol{");
        sb.append("symbol='")
                .append(symbol)
                .append('\'');
        sb.append(", name=")
                .append(name);
        sb.append(", secType='")
                .append(secType)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
