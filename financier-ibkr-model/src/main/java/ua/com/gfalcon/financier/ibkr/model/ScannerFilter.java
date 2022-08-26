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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public abstract class ScannerFilter {

    @JsonProperty("code")
    @SerializedName("code")
    private String code;

    public ScannerFilter(String code, Object value) {
        setCode(code);
        setValue(value);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public abstract void setValue(Object value);

    public abstract Object getValue();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScannerFilter)) return false;
        ScannerFilter that = (ScannerFilter) o;
        return getCode().equals(that.getCode()) && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getValue());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScannerFilter{");
        sb.append("code='")
                .append(getCode())
                .append('\'');
        sb.append(", value=")
                .append(getValue());
        sb.append('}');
        return sb.toString();
    }
}
