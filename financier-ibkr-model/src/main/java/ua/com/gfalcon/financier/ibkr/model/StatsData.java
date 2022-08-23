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
 * StatsData
 */
@Validated
public class StatsData {

    @ApiModelProperty(value = "")
    @JsonProperty("Conid")
    @SerializedName("Conid")
    private BigDecimal conid = null;

    @ApiModelProperty(value = "")
    @JsonProperty("Exchange")
    @SerializedName("Exchange")
    private String exchange = null;

    @ApiModelProperty(value = "")
    @JsonProperty("V")
    @SerializedName("V")
    private BigDecimal V = null;

    @ApiModelProperty(value = "")
    @JsonProperty("T")
    @SerializedName("T")
    private BigDecimal T = null;

    @ApiModelProperty(value = "")
    @JsonProperty("TT")
    @SerializedName("TT")
    private BigDecimal TT = null;

    @ApiModelProperty(value = "Object, payload depends on event type. See confluence page for IGEvntUpd.")
    /**
     * Object, payload depends on event type. See confluence page for IGEvntUpd.
     **/
    @JsonProperty("P")
    @SerializedName("P")
    private String P = null;

    /**
     * Get conid
     *
     * @return conid
     **/
    @JsonProperty("Conid")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getConid() {
        return conid;
    }

    public void setConid(BigDecimal conid) {
        this.conid = conid;
    }

    /**
     * Get exchange
     *
     * @return exchange
     **/
    @JsonProperty("Exchange")
    @ApiModelProperty(value = "")
    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * Object, payload depends on event type. See confluence page for IGEvntUpd.
     *
     * @return P
     **/
    @JsonProperty("P")
    @ApiModelProperty(value = "Object, payload depends on event type. See confluence page for IGEvntUpd.")
    public String getP() {
        return P;
    }

    public void setP(String P) {
        this.P = P;
    }

    /**
     * Get T
     *
     * @return T
     **/
    @JsonProperty("T")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getT() {
        return T;
    }

    public void setT(BigDecimal T) {
        this.T = T;
    }

    /**
     * Get TT
     *
     * @return TT
     **/
    @JsonProperty("TT")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getTT() {
        return TT;
    }

    public void setTT(BigDecimal TT) {
        this.TT = TT;
    }

    /**
     * Get V
     *
     * @return V
     **/
    @JsonProperty("V")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getV() {
        return V;
    }

    public void setV(BigDecimal V) {
        this.V = V;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conid, exchange, V, T, TT, P);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StatsData statsData = (StatsData) o;
        return Objects.equals(this.conid, statsData.conid) && Objects.equals(this.exchange, statsData.exchange)
                && Objects.equals(this.V, statsData.V) && Objects.equals(this.T, statsData.T) && Objects.equals(this.TT,
                statsData.TT) && Objects.equals(this.P, statsData.P);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StatsData {\n");

        sb.append("    conid: ")
                .append(toIndentedString(conid))
                .append("\n");
        sb.append("    exchange: ")
                .append(toIndentedString(exchange))
                .append("\n");
        sb.append("    V: ")
                .append(toIndentedString(V))
                .append("\n");
        sb.append("    T: ")
                .append(toIndentedString(T))
                .append("\n");
        sb.append("    TT: ")
                .append(toIndentedString(TT))
                .append("\n");
        sb.append("    P: ")
                .append(toIndentedString(P))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public StatsData P(String P) {
        this.P = P;
        return this;
    }

    public StatsData T(BigDecimal T) {
        this.T = T;
        return this;
    }

    public StatsData TT(BigDecimal TT) {
        this.TT = TT;
        return this;
    }

    public StatsData V(BigDecimal V) {
        this.V = V;
        return this;
    }

    public StatsData conid(BigDecimal conid) {
        this.conid = conid;
        return this;
    }

    public StatsData exchange(String exchange) {
        this.exchange = exchange;
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

