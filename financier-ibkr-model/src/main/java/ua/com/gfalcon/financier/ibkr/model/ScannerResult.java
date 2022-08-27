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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class ScannerResult {

    @JsonProperty("server_id")
    @SerializedName("server_id")
    private String serverId;

    @JsonProperty("column_name")
    @SerializedName("column_name")
    private String columnName;

    /**
     * Underlying symbol.
     */
    @JsonProperty("symbol")
    @SerializedName("symbol")
    private String symbol;

    /**
     * conid and exchange. Format supports conid or conid@exchange.
     */
    @JsonProperty("conidex")
    @SerializedName("conidex")
    private String conidex;

    @JsonProperty("con_id")
    @SerializedName("con_id")
    private BigDecimal conId;

    /**
     * List of available chart periods.
     */
    @JsonProperty("available_chart_periods")
    @SerializedName("available_chart_periods")
    private String availableChartPeriods;

    /**
     * Contracts company name.
     */
    @JsonProperty("company_name")
    @SerializedName("company_name")
    private String companyName;

    /**
     * Format contract name.
     */
    @JsonProperty("contract_description_1")
    @SerializedName("contract_description_1")
    private String contractDescription;

    @JsonProperty("listing_exchange")
    @SerializedName("listing_exchange")
    private String listingExchange;

    @JsonProperty("sec_type")
    @SerializedName("sec_type")
    private String secType;
}
