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

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class Conid {

    /**
     * IBKR contract identifier.
     */
    @ApiModelProperty(value = "IBKR contract identifier.")
    @JsonProperty("conid")
    @SerializedName("conid")
    @NotNull
    private String conid = null;

    /**
     * Side of the market rules apply too. Set to true for Buy Orders, set to false for Sell Orders.
     */
    @ApiModelProperty(value = "Side of the market rules apply too. Set to true for Buy Orders, set to false for Sell Orders.")
    @JsonProperty("isBuy")
    @SerializedName("isBuy")
    @NotNull
    private Boolean isBuy = null;

    /**
     * IBKR contract identifier.
     */
    @ApiModelProperty(value = "IBKR contract identifier.")
    @JsonProperty("conid")
    public String getConid() {
        return conid;
    }

    public void setConid(String conid) {
        this.conid = conid;
    }

    /**
     * Side of the market rules apply too. Set to true for Buy Orders, set to false for Sell Orders.
     */
    @ApiModelProperty(value = "Side of the market rules apply too. Set to true for Buy Orders, set to false for Sell Orders.")
    @JsonProperty("isBuy")
    public Boolean getBuy() {
        return isBuy;
    }

    public void setBuy(Boolean buy) {
        isBuy = buy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conid)) return false;
        Conid conid1 = (Conid) o;
        return getConid().equals(conid1.getConid()) && isBuy.equals(conid1.isBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConid(), isBuy);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Conid{");
        sb.append("conid='")
                .append(conid)
                .append('\'');
        sb.append(", isBuy=")
                .append(isBuy);
        sb.append('}');
        return sb.toString();
    }
}
