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

public class GroupAllocationDetail {

    @JsonProperty("Computers")
    @SerializedName("Computers")
    private BigDecimal computers;

    @JsonProperty("Semiconductors")
    @SerializedName("Semiconductors")
    private BigDecimal semiconductors;

    @JsonProperty("Others")
    @SerializedName("Others")
    private BigDecimal others;

    @JsonProperty("Chemicals")
    @SerializedName("Chemicals")
    private BigDecimal chemicals;

    @JsonProperty("Apparel")
    @SerializedName("Apparel")
    private BigDecimal apparel;

    @JsonProperty("Communications")
    @SerializedName("Communications")
    private BigDecimal communications;

    @JsonProperty("Banks")
    @SerializedName("Banks")
    private BigDecimal banks;

    @JsonProperty("Airlines")
    @SerializedName("Airlines")
    private BigDecimal airlines;

    @JsonProperty("Internet")
    @SerializedName("Internet")
    private BigDecimal internet;

    public BigDecimal getComputers() {
        return computers;
    }

    public void setComputers(BigDecimal computers) {
        this.computers = computers;
    }

    public BigDecimal getSemiconductors() {
        return semiconductors;
    }

    public void setSemiconductors(BigDecimal semiconductors) {
        this.semiconductors = semiconductors;
    }

    public BigDecimal getOthers() {
        return others;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getChemicals() {
        return chemicals;
    }

    public void setChemicals(BigDecimal chemicals) {
        this.chemicals = chemicals;
    }

    public BigDecimal getApparel() {
        return apparel;
    }

    public void setApparel(BigDecimal apparel) {
        this.apparel = apparel;
    }

    public BigDecimal getCommunications() {
        return communications;
    }

    public void setCommunications(BigDecimal communications) {
        this.communications = communications;
    }

    public BigDecimal getBanks() {
        return banks;
    }

    public void setBanks(BigDecimal banks) {
        this.banks = banks;
    }

    public BigDecimal getAirlines() {
        return airlines;
    }

    public void setAirlines(BigDecimal airlines) {
        this.airlines = airlines;
    }

    public BigDecimal getInternet() {
        return internet;
    }

    public void setInternet(BigDecimal internet) {
        this.internet = internet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupAllocationDetail)) return false;
        GroupAllocationDetail that = (GroupAllocationDetail) o;
        return Objects.equals(getComputers(), that.getComputers()) && Objects.equals(getSemiconductors(),
                that.getSemiconductors()) && Objects.equals(getOthers(), that.getOthers()) && Objects.equals(
                getChemicals(), that.getChemicals()) && Objects.equals(getApparel(), that.getApparel())
                && Objects.equals(getCommunications(), that.getCommunications()) && Objects.equals(getBanks(),
                that.getBanks()) && Objects.equals(getAirlines(), that.getAirlines()) && Objects.equals(getInternet(),
                that.getInternet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComputers(), getSemiconductors(), getOthers(), getChemicals(), getApparel(),
                getCommunications(), getBanks(), getAirlines(), getInternet());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroupAllocationDetail{");
        sb.append("computers=")
                .append(computers);
        sb.append(", semiconductors=")
                .append(semiconductors);
        sb.append(", others=")
                .append(others);
        sb.append(", chemicals=")
                .append(chemicals);
        sb.append(", apparel=")
                .append(apparel);
        sb.append(", communications=")
                .append(communications);
        sb.append(", banks=")
                .append(banks);
        sb.append(", airlines=")
                .append(airlines);
        sb.append(", internet=")
                .append(internet);
        sb.append('}');
        return sb.toString();
    }
}
