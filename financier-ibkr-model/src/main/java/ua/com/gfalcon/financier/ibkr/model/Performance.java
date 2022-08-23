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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Performance
 */
@Validated
public class Performance {

    @ApiModelProperty(value = "")
    @JsonProperty("id")
    @SerializedName("id")
    private String id = null;

    @ApiModelProperty(value = "Cumulative performance data")
    /**
     * Cumulative performance data
     **/
    @JsonProperty("cps")
    @SerializedName("cps")
    private Object cps = null;

    @ApiModelProperty(value = "Time period performance data")
    /**
     * Time period performance data
     **/
    @JsonProperty("tpps")
    @SerializedName("tpps")
    private Object tpps = null;

    @ApiModelProperty(value = "Net asset value data for the account or consolidated accounts. NAV data is not applicable to benchmarks.")
    /**
     * Net asset value data for the account or consolidated accounts. NAV data is not applicable to benchmarks.
     **/
    @JsonProperty("nav")
    @SerializedName("nav")
    private Object nav = null;

    @ApiModelProperty(value = "")
    @JsonProperty("pm")
    @SerializedName("pm")
    private String pm = null;

    @ApiModelProperty(value = "")
    @JsonProperty("included")
    @Valid
    @SerializedName("included")
    private List<String> included = new ArrayList<String>();

    @ApiModelProperty(value = "")
    @JsonProperty("currencyType")
    @SerializedName("currencyType")
    private String currencyType = null;

    @ApiModelProperty(value = "")
    @JsonProperty("rc")
    @SerializedName("rc")
    private Integer rc = null;

    /**
     * Cumulative performance data
     *
     * @return cps
     **/
    @JsonProperty("cps")
    @ApiModelProperty(value = "Cumulative performance data")
    public Object getCps() {
        return cps;
    }

    public void setCps(Object cps) {
        this.cps = cps;
    }

    /**
     * Get currencyType
     *
     * @return currencyType
     **/
    @JsonProperty("currencyType")
    @ApiModelProperty(value = "")
    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @JsonProperty("id")
    @ApiModelProperty(value = "")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get included
     *
     * @return included
     **/
    @JsonProperty("included")
    @ApiModelProperty(value = "")
    public List<String> getIncluded() {
        return included;
    }

    public void setIncluded(List<String> included) {
        this.included = included;
    }

    /**
     * Net asset value data for the account or consolidated accounts. NAV data is not applicable to benchmarks.
     *
     * @return nav
     **/
    @JsonProperty("nav")
    @ApiModelProperty(value = "Net asset value data for the account or consolidated accounts. NAV data is not applicable to benchmarks.")
    public Object getNav() {
        return nav;
    }

    public void setNav(Object nav) {
        this.nav = nav;
    }

    /**
     * Get pm
     *
     * @return pm
     **/
    @JsonProperty("pm")
    @ApiModelProperty(value = "")
    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    /**
     * Get rc
     *
     * @return rc
     **/
    @JsonProperty("rc")
    @ApiModelProperty(value = "")
    public Integer getRc() {
        return rc;
    }

    public void setRc(Integer rc) {
        this.rc = rc;
    }

    /**
     * Time period performance data
     *
     * @return tpps
     **/
    @JsonProperty("tpps")
    @ApiModelProperty(value = "Time period performance data")
    public Object getTpps() {
        return tpps;
    }

    public void setTpps(Object tpps) {
        this.tpps = tpps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cps, tpps, nav, pm, included, currencyType, rc);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Performance performance = (Performance) o;
        return Objects.equals(this.id, performance.id) && Objects.equals(this.cps, performance.cps) && Objects.equals(
                this.tpps, performance.tpps) && Objects.equals(this.nav, performance.nav) && Objects.equals(this.pm,
                performance.pm) && Objects.equals(this.included, performance.included) && Objects.equals(
                this.currencyType, performance.currencyType) && Objects.equals(this.rc, performance.rc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Performance {\n");

        sb.append("    id: ")
                .append(toIndentedString(id))
                .append("\n");
        sb.append("    cps: ")
                .append(toIndentedString(cps))
                .append("\n");
        sb.append("    tpps: ")
                .append(toIndentedString(tpps))
                .append("\n");
        sb.append("    nav: ")
                .append(toIndentedString(nav))
                .append("\n");
        sb.append("    pm: ")
                .append(toIndentedString(pm))
                .append("\n");
        sb.append("    included: ")
                .append(toIndentedString(included))
                .append("\n");
        sb.append("    currencyType: ")
                .append(toIndentedString(currencyType))
                .append("\n");
        sb.append("    rc: ")
                .append(toIndentedString(rc))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Performance addIncludedItem(String includedItem) {
        if (this.included == null) {
            this.included = new ArrayList<String>();
        }
        this.included.add(includedItem);
        return this;
    }

    public Performance cps(Object cps) {
        this.cps = cps;
        return this;
    }

    public Performance currencyType(String currencyType) {
        this.currencyType = currencyType;
        return this;
    }

    public Performance id(String id) {
        this.id = id;
        return this;
    }

    public Performance included(List<String> included) {
        this.included = included;
        return this;
    }

    public Performance nav(Object nav) {
        this.nav = nav;
        return this;
    }

    public Performance pm(String pm) {
        this.pm = pm;
        return this;
    }

    public Performance rc(Integer rc) {
        this.rc = rc;
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

    public Performance tpps(Object tpps) {
        this.tpps = tpps;
        return this;
    }
}

