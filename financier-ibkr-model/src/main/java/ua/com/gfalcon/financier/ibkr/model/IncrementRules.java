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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Price increment value contract trades.
 */
@ApiModel(description = "Price increment value contract trades.")
public class IncrementRules {

    /**
     * The minimum contract price on the market that supports the specified increment.
     */
    @ApiModelProperty(value = "The minimum contract price on the market that supports the specified increment.")
    @JsonProperty("lowerEdge")
    @SerializedName("lowerEdge")
    private BigDecimal lowerEdge = null;

    /**
     * The minimum increment value for contract price.
     */
    @ApiModelProperty(value = "The minimum increment value for contract price.")
    @JsonProperty("increment")
    @SerializedName("increment")
    private BigDecimal increment = null;

    /**
     * The minimum contract price on the market that supports the specified increment.
     */
    @ApiModelProperty(value = "The minimum contract price on the market that supports the specified increment.")
    @JsonProperty("lowerEdge")
    public BigDecimal getLowerEdge() {
        return lowerEdge;
    }

    public void setLowerEdge(BigDecimal lowerEdge) {
        this.lowerEdge = lowerEdge;
    }

    /**
     * The minimum increment value for contract price.
     */
    @ApiModelProperty(value = "The minimum increment value for contract price.")
    @JsonProperty("increment")
    public BigDecimal getIncrement() {
        return increment;
    }

    public void setIncrement(BigDecimal increment) {
        this.increment = increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IncrementRules)) return false;
        IncrementRules that = (IncrementRules) o;
        return Objects.equals(getLowerEdge(), that.getLowerEdge()) && Objects.equals(getIncrement(),
                that.getIncrement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLowerEdge(), getIncrement());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IncrementRules{");
        sb.append("lowerEdge=")
                .append(lowerEdge);
        sb.append(", increment=")
                .append(increment);
        sb.append('}');
        return sb.toString();
    }
}
