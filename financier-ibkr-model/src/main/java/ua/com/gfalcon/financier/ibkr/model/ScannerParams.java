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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ScannerParams
 */
@Validated
public class ScannerParams {

    @ApiModelProperty(value = "for example-STK")
    /**
     * for example-STK
     **/
    @JsonProperty("instrument")
    @SerializedName("instrument")
    private String instrument = null;

    @ApiModelProperty(value = "for example-TOP_PERC_GAIN")
    /**
     * for example-TOP_PERC_GAIN
     **/
    @JsonProperty("type")
    @SerializedName("type")
    private String type = null;

    @ApiModelProperty(value = "")
    @JsonProperty("filter")
    @Valid
    @SerializedName("filter")
    private List<Object> filter = new ArrayList<Object>();

    @ApiModelProperty(value = "")
    @JsonProperty("location")
    @SerializedName("location")
    private String location = null;

    @ApiModelProperty(value = "")
    @JsonProperty("size")
    @SerializedName("size")
    private String size = null;

    /**
     * Get filter
     *
     * @return filter
     **/
    @JsonProperty("filter")
    @ApiModelProperty(value = "")
    public List<Object> getFilter() {
        return filter;
    }

    public void setFilter(List<Object> filter) {
        this.filter = filter;
    }

    /**
     * for example-STK
     *
     * @return instrument
     **/
    @JsonProperty("instrument")
    @ApiModelProperty(value = "for example-STK")
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Get location
     *
     * @return location
     **/
    @JsonProperty("location")
    @ApiModelProperty(value = "")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get size
     *
     * @return size
     **/
    @JsonProperty("size")
    @ApiModelProperty(value = "")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    /**
     * for example-TOP_PERC_GAIN
     *
     * @return type
     **/
    @JsonProperty("type")
    @ApiModelProperty(value = "for example-TOP_PERC_GAIN")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrument, type, filter, location, size);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScannerParams scannerParams = (ScannerParams) o;
        return Objects.equals(this.instrument, scannerParams.instrument) && Objects.equals(this.type,
                scannerParams.type) && Objects.equals(this.filter, scannerParams.filter) && Objects.equals(
                this.location, scannerParams.location) && Objects.equals(this.size, scannerParams.size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScannerParams {\n");

        sb.append("    instrument: ")
                .append(toIndentedString(instrument))
                .append("\n");
        sb.append("    type: ")
                .append(toIndentedString(type))
                .append("\n");
        sb.append("    filter: ")
                .append(toIndentedString(filter))
                .append("\n");
        sb.append("    location: ")
                .append(toIndentedString(location))
                .append("\n");
        sb.append("    size: ")
                .append(toIndentedString(size))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public ScannerParams addFilterItem(Object filterItem) {
        if (this.filter == null) {
            this.filter = new ArrayList<Object>();
        }
        this.filter.add(filterItem);
        return this;
    }

    public ScannerParams filter(List<Object> filter) {
        this.filter = filter;
        return this;
    }

    public ScannerParams instrument(String instrument) {
        this.instrument = instrument;
        return this;
    }

    public ScannerParams location(String location) {
        this.location = location;
        return this;
    }

    public ScannerParams size(String size) {
        this.size = size;
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

    public ScannerParams type(String type) {
        this.type = type;
        return this;
    }
}

