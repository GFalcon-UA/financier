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
 * PositionData
 */
@Validated
public class PositionData {

    @ApiModelProperty(value = "Contract identifier from IBKR's database.")
    /**
     * Contract identifier from IBKR's database.
     **/
    @JsonProperty("conid")
    @SerializedName("conid")
    private BigDecimal conid = null;

    @ApiModelProperty(value = "Number of shares or quantity of the position.")
    /**
     * Number of shares or quantity of the position.
     **/
    @JsonProperty("position")
    @SerializedName("position")
    private BigDecimal position = null;

    @ApiModelProperty(value = "Average cost of the position.")
    /**
     * Average cost of the position.
     **/
    @JsonProperty("avgCost")
    @SerializedName("avgCost")
    private BigDecimal avgCost = null;

    /**
     * Average cost of the position.
     *
     * @return avgCost
     **/
    @JsonProperty("avgCost")
    @ApiModelProperty(value = "Average cost of the position.")
    @Valid
    public BigDecimal getAvgCost() {
        return avgCost;
    }

    public void setAvgCost(BigDecimal avgCost) {
        this.avgCost = avgCost;
    }

    /**
     * Contract identifier from IBKR's database.
     *
     * @return conid
     **/
    @JsonProperty("conid")
    @ApiModelProperty(value = "Contract identifier from IBKR's database.")
    @Valid
    public BigDecimal getConid() {
        return conid;
    }

    public void setConid(BigDecimal conid) {
        this.conid = conid;
    }

    /**
     * Number of shares or quantity of the position.
     *
     * @return position
     **/
    @JsonProperty("position")
    @ApiModelProperty(value = "Number of shares or quantity of the position.")
    @Valid
    public BigDecimal getPosition() {
        return position;
    }

    public void setPosition(BigDecimal position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conid, position, avgCost);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositionData positionData = (PositionData) o;
        return Objects.equals(this.conid, positionData.conid) && Objects.equals(this.position, positionData.position)
                && Objects.equals(this.avgCost, positionData.avgCost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PositionData {\n");

        sb.append("    conid: ")
                .append(toIndentedString(conid))
                .append("\n");
        sb.append("    position: ")
                .append(toIndentedString(position))
                .append("\n");
        sb.append("    avgCost: ")
                .append(toIndentedString(avgCost))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public PositionData avgCost(BigDecimal avgCost) {
        this.avgCost = avgCost;
        return this;
    }

    public PositionData conid(BigDecimal conid) {
        this.conid = conid;
        return this;
    }

    public PositionData position(BigDecimal position) {
        this.position = position;
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

