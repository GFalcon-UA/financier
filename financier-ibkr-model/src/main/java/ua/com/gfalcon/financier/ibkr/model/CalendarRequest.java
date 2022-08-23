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

import io.swagger.annotations.ApiModelProperty;

/**
 * CalendarRequest
 */
@Validated
public class CalendarRequest {

    @JsonProperty("date")
    @ApiModelProperty(value = "")
    @SerializedName("date")
    private Object date = null;

    @JsonProperty("filters")
    @ApiModelProperty(value = "")
    @SerializedName("filters")
    private Object filters = null;

    /**
     * Get date
     *
     * @return date
     **/
    @JsonProperty("date")
    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    /**
     * Get filters
     *
     * @return filters
     **/
    @JsonProperty("filters")
    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, filters);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalendarRequest calendarRequest = (CalendarRequest) o;
        return Objects.equals(this.date, calendarRequest.date) && Objects.equals(this.filters, calendarRequest.filters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CalendarRequest {\n");

        sb.append("    date: ")
                .append(toIndentedString(date))
                .append("\n");
        sb.append("    filters: ")
                .append(toIndentedString(filters))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public CalendarRequest date(Object date) {
        this.date = date;
        return this;
    }

    public CalendarRequest filters(Object filters) {
        this.filters = filters;
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

