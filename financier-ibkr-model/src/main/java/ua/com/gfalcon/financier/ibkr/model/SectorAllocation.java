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

import io.swagger.annotations.ApiModelProperty;

/**
 * portfolio allocation by sector.
 */
public class SectorAllocation {

    /**
     * long positions allocation.
     */
    @ApiModelProperty(value = "long positions allocation")
    @JsonProperty("long")
    @SerializedName("long")
    private SectorAllocationDetail longSectorAllocation;

    /**
     * short positions allocation.
     */
    @ApiModelProperty(value = "short positions allocation")
    @JsonProperty("short")
    @SerializedName("short")
    private SectorAllocationDetail shortSectorAllocation;

    public SectorAllocationDetail getLongSectorAllocation() {
        return longSectorAllocation;
    }

    public void setLongSectorAllocation(SectorAllocationDetail longSectorAllocation) {
        this.longSectorAllocation = longSectorAllocation;
    }

    public SectorAllocationDetail getShortSectorAllocation() {
        return shortSectorAllocation;
    }

    public void setShortSectorAllocation(SectorAllocationDetail shortSectorAllocation) {
        this.shortSectorAllocation = shortSectorAllocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectorAllocation)) return false;
        SectorAllocation that = (SectorAllocation) o;
        return Objects.equals(getLongSectorAllocation(), that.getLongSectorAllocation()) && Objects.equals(
                getShortSectorAllocation(), that.getShortSectorAllocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongSectorAllocation(), getShortSectorAllocation());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SectorAllocation{");
        sb.append("longSectorAllocation=")
                .append(longSectorAllocation);
        sb.append(", shortSectorAllocation=")
                .append(shortSectorAllocation);
        sb.append('}');
        return sb.toString();
    }
}
