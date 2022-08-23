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
 * Information about the account's portfolio allocation.
 */
public class PortfolioAllocation {

    /**
     * Portfolio allocation by asset class.
     */
    @ApiModelProperty(value = "Portfolio allocation by asset class")
    @JsonProperty("assetClass")
    @SerializedName("assetClass")
    private AssetClassAllocation assetClass;

    /**
     * Portfolio allocation by sector.
     */
    @ApiModelProperty(value = "Portfolio allocation by sector")
    @JsonProperty("sector")
    @SerializedName("sector")
    private SectorAllocation sector;

    /**
     * Portfolio allocation by group.
     */
    @ApiModelProperty(value = "Portfolio allocation by group")
    @JsonProperty("group")
    @SerializedName("group")
    private GroupAllocation group;

    public AssetClassAllocation getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(AssetClassAllocation assetClass) {
        this.assetClass = assetClass;
    }

    public SectorAllocation getSector() {
        return sector;
    }

    public void setSector(SectorAllocation sector) {
        this.sector = sector;
    }

    public GroupAllocation getGroup() {
        return group;
    }

    public void setGroup(GroupAllocation group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PortfolioAllocation)) return false;
        PortfolioAllocation that = (PortfolioAllocation) o;
        return Objects.equals(getAssetClass(), that.getAssetClass()) && Objects.equals(getSector(), that.getSector())
                && Objects.equals(getGroup(), that.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssetClass(), getSector(), getGroup());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PortfolioAllocation{");
        sb.append("assetClass=")
                .append(assetClass);
        sb.append(", sector=")
                .append(sector);
        sb.append(", group=")
                .append(group);
        sb.append('}');
        return sb.toString();
    }
}
