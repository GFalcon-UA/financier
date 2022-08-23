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
 * ScannerResult
 */
@Validated
public class ScannerResult {

    @ApiModelProperty(value = "")
    @JsonProperty("total")
    @SerializedName("total")
    private Integer total = null;

    @ApiModelProperty(value = "")
    @JsonProperty("size")
    @SerializedName("size")
    private Integer size = null;

    @ApiModelProperty(value = "")
    @JsonProperty("offset")
    @SerializedName("offset")
    private Integer offset = null;

    @ApiModelProperty(value = "")
    @JsonProperty("scanTime")
    @SerializedName("scanTime")
    private String scanTime = null;

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @SerializedName("id")
    private BigDecimal id = null;

    @ApiModelProperty(value = "")
    @JsonProperty("position")
    @SerializedName("position")
    private String position = null;

    @ApiModelProperty(value = "Contains list of contracts matching the scanner query")
    /**
     * Contains list of contracts matching the scanner query
     **/
    @JsonProperty("Contracts")
    @SerializedName("Contracts")
    private Object contracts = null;

    /**
     * Contains list of contracts matching the scanner query
     *
     * @return contracts
     **/
    @JsonProperty("Contracts")
    @ApiModelProperty(value = "Contains list of contracts matching the scanner query")
    public Object getContracts() {
        return contracts;
    }

    public void setContracts(Object contracts) {
        this.contracts = contracts;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @JsonProperty("id")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * Get offset
     *
     * @return offset
     **/
    @JsonProperty("offset")
    @ApiModelProperty(value = "")
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Get position
     *
     * @return position
     **/
    @JsonProperty("position")
    @ApiModelProperty(value = "")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Get scanTime
     *
     * @return scanTime
     **/
    @JsonProperty("scanTime")
    @ApiModelProperty(value = "")
    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    /**
     * Get size
     *
     * @return size
     **/
    @JsonProperty("size")
    @ApiModelProperty(value = "")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Get total
     *
     * @return total
     **/
    @JsonProperty("total")
    @ApiModelProperty(value = "")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, size, offset, scanTime, id, position, contracts);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScannerResult scannerResult = (ScannerResult) o;
        return Objects.equals(this.total, scannerResult.total) && Objects.equals(this.size, scannerResult.size)
                && Objects.equals(this.offset, scannerResult.offset) && Objects.equals(this.scanTime,
                scannerResult.scanTime) && Objects.equals(this.id, scannerResult.id) && Objects.equals(this.position,
                scannerResult.position) && Objects.equals(this.contracts, scannerResult.contracts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScannerResult {\n");

        sb.append("    total: ")
                .append(toIndentedString(total))
                .append("\n");
        sb.append("    size: ")
                .append(toIndentedString(size))
                .append("\n");
        sb.append("    offset: ")
                .append(toIndentedString(offset))
                .append("\n");
        sb.append("    scanTime: ")
                .append(toIndentedString(scanTime))
                .append("\n");
        sb.append("    id: ")
                .append(toIndentedString(id))
                .append("\n");
        sb.append("    position: ")
                .append(toIndentedString(position))
                .append("\n");
        sb.append("    contracts: ")
                .append(toIndentedString(contracts))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public ScannerResult contracts(Object contracts) {
        this.contracts = contracts;
        return this;
    }

    public ScannerResult id(BigDecimal id) {
        this.id = id;
        return this;
    }

    public ScannerResult offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public ScannerResult position(String position) {
        this.position = position;
        return this;
    }

    public ScannerResult scanTime(String scanTime) {
        this.scanTime = scanTime;
        return this;
    }

    public ScannerResult size(Integer size) {
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

    public ScannerResult total(Integer total) {
        this.total = total;
        return this;
    }
}

