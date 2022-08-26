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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

/**
 * Using a direct connection to the market data farm, will provide results to the requested scanner.
 */
@Data
public class DirectScanner {

    @JsonProperty("instrument")
    @SerializedName("instrument")
    private String instrument;

    @JsonProperty("locations")
    @SerializedName("locations")
    private String locations;

    @JsonProperty("scanCode")
    @SerializedName("scanCode")
    private String scanCode;

    @JsonProperty("secType")
    @SerializedName("secType")
    private String secType;

    /**
     * Value can be either an integer, double, boolean or a string depending upon the type of filter specified in the
     * code section.
     */
    @JsonProperty("filters")
    @SerializedName("filters")
    private List<ScannerFilter> filters;
}
