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
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Asset class allocation detail.
 */
public class AssetClassAllocationDetail {

    @ApiModelProperty(value = "")
    @JsonProperty("STK")
    @SerializedName("STK")
    private BigDecimal stk;

    @ApiModelProperty(value = "")
    @JsonProperty("OPT")
    @SerializedName("OPT")
    private BigDecimal opt;

    @ApiModelProperty(value = "")
    @JsonProperty("FUT")
    @SerializedName("FUT")
    private BigDecimal fut;

    @ApiModelProperty(value = "")
    @JsonProperty("WAR")
    @SerializedName("WAR")
    private BigDecimal war;

    @ApiModelProperty(value = "")
    @JsonProperty("BOND")
    @SerializedName("BOND")
    private BigDecimal bond;

    @ApiModelProperty(value = "")
    @JsonProperty("CASH")
    @SerializedName("CASH")
    private BigDecimal cash;

    public BigDecimal getStk() {
        return stk;
    }

    public void setStk(BigDecimal stk) {
        this.stk = stk;
    }

    public BigDecimal getOpt() {
        return opt;
    }

    public void setOpt(BigDecimal opt) {
        this.opt = opt;
    }

    public BigDecimal getFut() {
        return fut;
    }

    public void setFut(BigDecimal fut) {
        this.fut = fut;
    }

    public BigDecimal getWar() {
        return war;
    }

    public void setWar(BigDecimal war) {
        this.war = war;
    }

    public BigDecimal getBond() {
        return bond;
    }

    public void setBond(BigDecimal bond) {
        this.bond = bond;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssetClassAllocationDetail)) return false;
        AssetClassAllocationDetail that = (AssetClassAllocationDetail) o;
        return Objects.equals(getStk(), that.getStk()) && Objects.equals(getOpt(), that.getOpt()) && Objects.equals(
                getFut(), that.getFut()) && Objects.equals(getWar(), that.getWar()) && Objects.equals(getBond(),
                that.getBond()) && Objects.equals(getCash(), that.getCash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStk(), getOpt(), getFut(), getWar(), getBond(), getCash());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LongAssetClassAllocation{");
        sb.append("stk=")
                .append(stk);
        sb.append(", opt=")
                .append(opt);
        sb.append(", fut=")
                .append(fut);
        sb.append(", war=")
                .append(war);
        sb.append(", bond=")
                .append(bond);
        sb.append(", cash=")
                .append(cash);
        sb.append('}');
        return sb.toString();
    }
}
