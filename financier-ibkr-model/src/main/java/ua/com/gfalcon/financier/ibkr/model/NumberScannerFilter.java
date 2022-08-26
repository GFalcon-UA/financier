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

public class NumberScannerFilter extends ScannerFilter {
    @JsonProperty("value")
    @SerializedName("value")
    private BigDecimal value;

    public NumberScannerFilter(String code, BigDecimal value) {
        super(code, value);
    }

    @Override
    public void setValue(Object value) {
        this.value = (BigDecimal) value;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }
}
