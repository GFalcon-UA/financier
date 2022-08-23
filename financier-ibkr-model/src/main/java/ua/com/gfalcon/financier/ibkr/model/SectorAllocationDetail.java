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

public class SectorAllocationDetail {

    @JsonProperty("Others")
    @SerializedName("Others")
    private BigDecimal others;

    @JsonProperty("Utilities")
    @SerializedName("Utilities")
    private BigDecimal utilities;

    @JsonProperty("Energy")
    @SerializedName("Energy")
    private BigDecimal energy;

    @JsonProperty("Technology")
    @SerializedName("Technology")
    private BigDecimal technology;

    @JsonProperty("Financial")
    @SerializedName("Financial")
    private BigDecimal financial;

    @JsonProperty("Communications")
    @SerializedName("Communications")
    private BigDecimal communications;

    @JsonProperty("Industrial")
    @SerializedName("Industrial")
    private BigDecimal industrial;

    @JsonProperty("Consumer")
    @SerializedName("Consumer")
    private BigDecimal consumer;

    @JsonProperty("Diversified")
    @SerializedName("Diversified")
    private BigDecimal diversified;

    public BigDecimal getOthers() {
        return others;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getUtilities() {
        return utilities;
    }

    public void setUtilities(BigDecimal utilities) {
        this.utilities = utilities;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getTechnology() {
        return technology;
    }

    public void setTechnology(BigDecimal technology) {
        this.technology = technology;
    }

    public BigDecimal getFinancial() {
        return financial;
    }

    public void setFinancial(BigDecimal financial) {
        this.financial = financial;
    }

    public BigDecimal getCommunications() {
        return communications;
    }

    public void setCommunications(BigDecimal communications) {
        this.communications = communications;
    }

    public BigDecimal getIndustrial() {
        return industrial;
    }

    public void setIndustrial(BigDecimal industrial) {
        this.industrial = industrial;
    }

    public BigDecimal getConsumer() {
        return consumer;
    }

    public void setConsumer(BigDecimal consumer) {
        this.consumer = consumer;
    }

    public BigDecimal getDiversified() {
        return diversified;
    }

    public void setDiversified(BigDecimal diversified) {
        this.diversified = diversified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectorAllocationDetail)) return false;
        SectorAllocationDetail that = (SectorAllocationDetail) o;
        return Objects.equals(getOthers(), that.getOthers()) && Objects.equals(getUtilities(), that.getUtilities())
                && Objects.equals(getEnergy(), that.getEnergy()) && Objects.equals(getTechnology(),
                that.getTechnology()) && Objects.equals(getFinancial(), that.getFinancial()) && Objects.equals(
                getCommunications(), that.getCommunications()) && Objects.equals(getIndustrial(), that.getIndustrial())
                && Objects.equals(getConsumer(), that.getConsumer()) && Objects.equals(getDiversified(),
                that.getDiversified());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOthers(), getUtilities(), getEnergy(), getTechnology(), getFinancial(),
                getCommunications(), getIndustrial(), getConsumer(), getDiversified());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SectorAllocationDetail{");
        sb.append("others=")
                .append(others);
        sb.append(", utilities=")
                .append(utilities);
        sb.append(", energy=")
                .append(energy);
        sb.append(", technology=")
                .append(technology);
        sb.append(", financial=")
                .append(financial);
        sb.append(", communications=")
                .append(communications);
        sb.append(", industrial=")
                .append(industrial);
        sb.append(", consumer=")
                .append(consumer);
        sb.append(", diversified=")
                .append(diversified);
        sb.append('}');
        return sb.toString();
    }
}
