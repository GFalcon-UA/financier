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
 * portfolio allocation by group.
 */
public class GroupAllocation {

    /**
     * long positions allocation.
     */
    @ApiModelProperty(value = "long positions allocation")
    @JsonProperty("long")
    @SerializedName("long")
    private GroupAllocationDetail longGroupAllocation;

    /**
     * short positions allocation.
     */
    @ApiModelProperty(value = "short positions allocation")
    @JsonProperty("short")
    @SerializedName("short")
    private GroupAllocationDetail shortGroupAllocation;

    public GroupAllocationDetail getLongGroupAllocation() {
        return longGroupAllocation;
    }

    public void setLongGroupAllocation(GroupAllocationDetail longGroupAllocation) {
        this.longGroupAllocation = longGroupAllocation;
    }

    public GroupAllocationDetail getShortGroupAllocation() {
        return shortGroupAllocation;
    }

    public void setShortGroupAllocation(GroupAllocationDetail shortGroupAllocation) {
        this.shortGroupAllocation = shortGroupAllocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupAllocation)) return false;
        GroupAllocation that = (GroupAllocation) o;
        return Objects.equals(getLongGroupAllocation(), that.getLongGroupAllocation()) && Objects.equals(
                getShortGroupAllocation(), that.getShortGroupAllocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongGroupAllocation(), getShortGroupAllocation());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupAllocation{");
        sb.append("longGroupAllocation=")
                .append(longGroupAllocation);
        sb.append(", shortGroupAllocation=")
                .append(shortGroupAllocation);
        sb.append('}');
        return sb.toString();
    }
}
