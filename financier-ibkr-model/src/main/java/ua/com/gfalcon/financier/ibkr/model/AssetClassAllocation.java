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
 * portfolio allocation by asset class.
 */
public class AssetClassAllocation {

    /**
     * long positions allocation.
     */
    @ApiModelProperty(value = "long positions allocation")
    @JsonProperty("long")
    @SerializedName("long")
    private AssetClassAllocationDetail longAssetClass;

    /**
     * short positions allocation.
     */
    @ApiModelProperty(value = "short positions allocation")
    @JsonProperty("short")
    @SerializedName("short")
    private AssetClassAllocationDetail shortAssetClass;

    public AssetClassAllocationDetail getLongAssetClass() {
        return longAssetClass;
    }

    public void setLongAssetClass(AssetClassAllocationDetail longAssetClass) {
        this.longAssetClass = longAssetClass;
    }

    public AssetClassAllocationDetail getShortAssetClass() {
        return shortAssetClass;
    }

    public void setShortAssetClass(AssetClassAllocationDetail shortAssetClass) {
        this.shortAssetClass = shortAssetClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetClassAllocation)) return false;
        AssetClassAllocation that = (AssetClassAllocation) o;
        return Objects.equals(getLongAssetClass(), that.getLongAssetClass()) && Objects.equals(getShortAssetClass(),
                that.getShortAssetClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongAssetClass(), getShortAssetClass());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AssetClassAllocation{");
        sb.append("longAssetClass=")
                .append(longAssetClass);
        sb.append(", shortAssetClass=")
                .append(shortAssetClass);
        sb.append('}');
        return sb.toString();
    }
}
