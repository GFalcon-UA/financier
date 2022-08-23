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
 * HistoryData
 */
@Validated
public class HistoryData {

    @JsonProperty("symbol")
    @ApiModelProperty(value = "Underlying symbol")
    /**
     * Underlying symbol
     **/
    @SerializedName("symbol")
    private String symbol = null;

    @JsonProperty("text")
    @ApiModelProperty(value = "companyName")
    /**
     * companyName
     **/
    @SerializedName("text")
    private String text = null;

    @JsonProperty("priceFactor")
    @ApiModelProperty(example = "100", value = "priceFactor is price increment obtained from display rule")
    /**
     * priceFactor is price increment obtained from display rule
     **/
    @SerializedName("priceFactor")
    private Integer priceFactor = null;

    @ApiModelProperty(value = "start date time in the format YYYYMMDD-HH:mm:ss")
    /**
     * start date time in the format YYYYMMDD-HH:mm:ss
     **/
    @JsonProperty("startTime")
    @SerializedName("startTime")
    private String startTime = null;

    @ApiModelProperty(value = "High value during this time series with format %h/%v/%t. %h is the high price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart ")
    /**
     * High value during this time series with format %h/%v/%t. %h is the high price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart
     **/
    @JsonProperty("high")
    @SerializedName("high")
    private String high = null;

    @ApiModelProperty(value = "Low value during this time series with format %l/%v/%t. %l is the low price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart ")
    /**
     * Low value during this time series with format %l/%v/%t. %l is the low price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart
     **/
    @JsonProperty("low")
    @SerializedName("low")
    private String low = null;

    @ApiModelProperty(value = "The duration for the historical data request")
    /**
     * The duration for the historical data request
     **/
    @JsonProperty("timePeriod")
    @SerializedName("timePeriod")
    private String timePeriod = null;

    @ApiModelProperty(value = "The number of seconds in a bar")
    /**
     * The number of seconds in a bar
     **/
    @JsonProperty("barLength")
    @SerializedName("barLength")
    private Integer barLength = null;

    @ApiModelProperty(value = "Market Data Availability. The field may contain two chars. The first char is the primary code: S = Streaming, R = Realtime, D = Delayed, Z = Frozen, Y = Frozen Delayed. The second char is the secondary code: P = Snapshot Available, p = Consolidated. ")
    /**
     * Market Data Availability. The field may contain two chars. The first char is the primary code: S = Streaming, R = Realtime, D = Delayed, Z = Frozen, Y = Frozen Delayed. The second char is the secondary code: P = Snapshot Available, p = Consolidated.
     **/
    @JsonProperty("mdAvailability")
    @SerializedName("mdAvailability")
    private String mdAvailability = null;

    @ApiModelProperty(value = "The time it takes, in milliseconds, to process the historical data request")
    /**
     * The time it takes, in milliseconds, to process the historical data request
     **/
    @JsonProperty("mktDataDelay")
    @SerializedName("mktDataDelay")
    private Integer mktDataDelay = null;

    @ApiModelProperty(value = "The historical data returned includes outside of regular trading hours ")
    /**
     * The historical data returned includes outside of regular trading hours
     **/
    @JsonProperty("outsideRth")
    @SerializedName("outsideRth")
    private Boolean outsideRth = null;

    @ApiModelProperty(value = "The number of seconds in the trading day")
    /**
     * The number of seconds in the trading day
     **/
    @JsonProperty("tradingDayDuration")
    @SerializedName("tradingDayDuration")
    private Integer tradingDayDuration = null;

    @ApiModelProperty(value = "")
    @JsonProperty("volumeFactor")
    @SerializedName("volumeFactor")
    private Integer volumeFactor = null;

    @ApiModelProperty(value = "")
    @JsonProperty("priceDisplayRule")
    @SerializedName("priceDisplayRule")
    private Integer priceDisplayRule = null;

    @ApiModelProperty(value = "")
    @JsonProperty("priceDisplayValue")
    @SerializedName("priceDisplayValue")
    private String priceDisplayValue = null;

    @ApiModelProperty(value = "")
    @JsonProperty("negativeCapable")
    @SerializedName("negativeCapable")
    private Boolean negativeCapable = null;

    @ApiModelProperty(value = "")
    @JsonProperty("messageVersion")
    @SerializedName("messageVersion")
    private Integer messageVersion = null;

    @ApiModelProperty(value = "")
    @JsonProperty("data")
    @Valid
    @SerializedName("data")
    private List<Object> data = new ArrayList<Object>();

    @ApiModelProperty(value = "total number of points")
    /**
     * total number of points
     **/
    @JsonProperty("points")
    @SerializedName("points")
    private Integer points = null;

    @ApiModelProperty(value = "")
    @JsonProperty("travelTime")
    @SerializedName("travelTime")
    private Integer travelTime = null;

    /**
     * The number of seconds in a bar
     *
     * @return barLength
     **/
    @JsonProperty("barLength")
    @ApiModelProperty(value = "The number of seconds in a bar")
    public Integer getBarLength() {
        return barLength;
    }

    public void setBarLength(Integer barLength) {
        this.barLength = barLength;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @JsonProperty("data")
    @ApiModelProperty(value = "")
    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    /**
     * High value during this time series with format %h/%v/%t. %h is the high price (scaled by priceFactor), %v is
     * volume (volume factor will always be 100 (reported volume &#x3D; actual volume/100)) and %t is minutes from start
     * time of the chart
     *
     * @return high
     **/
    @JsonProperty("high")
    @ApiModelProperty(value = "High value during this time series with format %h/%v/%t. %h is the high price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart ")
    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    /**
     * Low value during this time series with format %l/%v/%t. %l is the low price (scaled by priceFactor), %v is volume
     * (volume factor will always be 100 (reported volume &#x3D; actual volume/100)) and %t is minutes from start time
     * of the chart
     *
     * @return low
     **/
    @JsonProperty("low")
    @ApiModelProperty(value = "Low value during this time series with format %l/%v/%t. %l is the low price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume = actual volume/100)) and %t is minutes from start time of the chart ")
    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    /**
     * Market Data Availability. The field may contain two chars. The first char is the primary code: S &#x3D;
     * Streaming, R &#x3D; Realtime, D &#x3D; Delayed, Z &#x3D; Frozen, Y &#x3D; Frozen Delayed. The second char is the
     * secondary code: P &#x3D; Snapshot Available, p &#x3D; Consolidated.
     *
     * @return mdAvailability
     **/
    @JsonProperty("mdAvailability")
    @ApiModelProperty(value = "Market Data Availability. The field may contain two chars. The first char is the primary code: S = Streaming, R = Realtime, D = Delayed, Z = Frozen, Y = Frozen Delayed. The second char is the secondary code: P = Snapshot Available, p = Consolidated. ")
    public String getMdAvailability() {
        return mdAvailability;
    }

    public void setMdAvailability(String mdAvailability) {
        this.mdAvailability = mdAvailability;
    }

    /**
     * Get messageVersion
     *
     * @return messageVersion
     **/
    @JsonProperty("messageVersion")
    @ApiModelProperty(value = "")
    public Integer getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(Integer messageVersion) {
        this.messageVersion = messageVersion;
    }

    /**
     * The time it takes, in milliseconds, to process the historical data request
     *
     * @return mktDataDelay
     **/
    @JsonProperty("mktDataDelay")
    @ApiModelProperty(value = "The time it takes, in milliseconds, to process the historical data request")
    public Integer getMktDataDelay() {
        return mktDataDelay;
    }

    public void setMktDataDelay(Integer mktDataDelay) {
        this.mktDataDelay = mktDataDelay;
    }

    /**
     * total number of points
     *
     * @return points
     **/
    @JsonProperty("points")
    @ApiModelProperty(value = "total number of points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * Get priceDisplayRule
     *
     * @return priceDisplayRule
     **/
    @JsonProperty("priceDisplayRule")
    @ApiModelProperty(value = "")
    public Integer getPriceDisplayRule() {
        return priceDisplayRule;
    }

    public void setPriceDisplayRule(Integer priceDisplayRule) {
        this.priceDisplayRule = priceDisplayRule;
    }

    /**
     * Get priceDisplayValue
     *
     * @return priceDisplayValue
     **/
    @JsonProperty("priceDisplayValue")
    @ApiModelProperty(value = "")
    public String getPriceDisplayValue() {
        return priceDisplayValue;
    }

    public void setPriceDisplayValue(String priceDisplayValue) {
        this.priceDisplayValue = priceDisplayValue;
    }

    /**
     * priceFactor is price increment obtained from display rule
     *
     * @return priceFactor
     **/
    @JsonProperty("priceFactor")
    @ApiModelProperty(example = "100", value = "priceFactor is price increment obtained from display rule")
    public Integer getPriceFactor() {
        return priceFactor;
    }

    public void setPriceFactor(Integer priceFactor) {
        this.priceFactor = priceFactor;
    }

    /**
     * start date time in the format YYYYMMDD-HH:mm:ss
     *
     * @return startTime
     **/
    @JsonProperty("startTime")
    @ApiModelProperty(value = "start date time in the format YYYYMMDD-HH:mm:ss")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Underlying symbol
     *
     * @return symbol
     **/
    @JsonProperty("symbol")
    @ApiModelProperty(value = "Underlying symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * companyName
     *
     * @return text
     **/
    @JsonProperty("text")
    @ApiModelProperty(value = "companyName")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * The duration for the historical data request
     *
     * @return timePeriod
     **/
    @JsonProperty("timePeriod")
    @ApiModelProperty(value = "The duration for the historical data request")
    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    /**
     * The number of seconds in the trading day
     *
     * @return tradingDayDuration
     **/
    @JsonProperty("tradingDayDuration")
    @ApiModelProperty(value = "The number of seconds in the trading day")
    public Integer getTradingDayDuration() {
        return tradingDayDuration;
    }

    public void setTradingDayDuration(Integer tradingDayDuration) {
        this.tradingDayDuration = tradingDayDuration;
    }

    /**
     * Get travelTime
     *
     * @return travelTime
     **/
    @JsonProperty("travelTime")
    @ApiModelProperty(value = "")
    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    /**
     * Get volumeFactor
     *
     * @return volumeFactor
     **/
    @JsonProperty("volumeFactor")
    @ApiModelProperty(value = "")
    public Integer getVolumeFactor() {
        return volumeFactor;
    }

    public void setVolumeFactor(Integer volumeFactor) {
        this.volumeFactor = volumeFactor;
    }

    public void setNegativeCapable(Boolean negativeCapable) {
        this.negativeCapable = negativeCapable;
    }

    public void setOutsideRth(Boolean outsideRth) {
        this.outsideRth = outsideRth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, text, priceFactor, startTime, high, low, timePeriod, barLength, mdAvailability,
                mktDataDelay, outsideRth, tradingDayDuration, volumeFactor, priceDisplayRule, priceDisplayValue,
                negativeCapable, messageVersion, data, points, travelTime);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HistoryData historyData = (HistoryData) o;
        return Objects.equals(this.symbol, historyData.symbol) && Objects.equals(this.text, historyData.text)
                && Objects.equals(this.priceFactor, historyData.priceFactor) && Objects.equals(this.startTime,
                historyData.startTime) && Objects.equals(this.high, historyData.high) && Objects.equals(this.low,
                historyData.low) && Objects.equals(this.timePeriod, historyData.timePeriod) && Objects.equals(
                this.barLength, historyData.barLength) && Objects.equals(this.mdAvailability,
                historyData.mdAvailability) && Objects.equals(this.mktDataDelay, historyData.mktDataDelay)
                && Objects.equals(this.outsideRth, historyData.outsideRth) && Objects.equals(this.tradingDayDuration,
                historyData.tradingDayDuration) && Objects.equals(this.volumeFactor, historyData.volumeFactor)
                && Objects.equals(this.priceDisplayRule, historyData.priceDisplayRule) && Objects.equals(
                this.priceDisplayValue, historyData.priceDisplayValue) && Objects.equals(this.negativeCapable,
                historyData.negativeCapable) && Objects.equals(this.messageVersion, historyData.messageVersion)
                && Objects.equals(this.data, historyData.data) && Objects.equals(this.points, historyData.points)
                && Objects.equals(this.travelTime, historyData.travelTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HistoryData {\n");

        sb.append("    symbol: ")
                .append(toIndentedString(symbol))
                .append("\n");
        sb.append("    text: ")
                .append(toIndentedString(text))
                .append("\n");
        sb.append("    priceFactor: ")
                .append(toIndentedString(priceFactor))
                .append("\n");
        sb.append("    startTime: ")
                .append(toIndentedString(startTime))
                .append("\n");
        sb.append("    high: ")
                .append(toIndentedString(high))
                .append("\n");
        sb.append("    low: ")
                .append(toIndentedString(low))
                .append("\n");
        sb.append("    timePeriod: ")
                .append(toIndentedString(timePeriod))
                .append("\n");
        sb.append("    barLength: ")
                .append(toIndentedString(barLength))
                .append("\n");
        sb.append("    mdAvailability: ")
                .append(toIndentedString(mdAvailability))
                .append("\n");
        sb.append("    mktDataDelay: ")
                .append(toIndentedString(mktDataDelay))
                .append("\n");
        sb.append("    outsideRth: ")
                .append(toIndentedString(outsideRth))
                .append("\n");
        sb.append("    tradingDayDuration: ")
                .append(toIndentedString(tradingDayDuration))
                .append("\n");
        sb.append("    volumeFactor: ")
                .append(toIndentedString(volumeFactor))
                .append("\n");
        sb.append("    priceDisplayRule: ")
                .append(toIndentedString(priceDisplayRule))
                .append("\n");
        sb.append("    priceDisplayValue: ")
                .append(toIndentedString(priceDisplayValue))
                .append("\n");
        sb.append("    negativeCapable: ")
                .append(toIndentedString(negativeCapable))
                .append("\n");
        sb.append("    messageVersion: ")
                .append(toIndentedString(messageVersion))
                .append("\n");
        sb.append("    data: ")
                .append(toIndentedString(data))
                .append("\n");
        sb.append("    points: ")
                .append(toIndentedString(points))
                .append("\n");
        sb.append("    travelTime: ")
                .append(toIndentedString(travelTime))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public HistoryData addDataItem(Object dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<Object>();
        }
        this.data.add(dataItem);
        return this;
    }

    public HistoryData barLength(Integer barLength) {
        this.barLength = barLength;
        return this;
    }

    public HistoryData data(List<Object> data) {
        this.data = data;
        return this;
    }

    public HistoryData high(String high) {
        this.high = high;
        return this;
    }

    /**
     * Get negativeCapable
     *
     * @return negativeCapable
     **/
    @JsonProperty("negativeCapable")
    @ApiModelProperty(value = "")
    public Boolean isNegativeCapable() {
        return negativeCapable;
    }

    /**
     * The historical data returned includes outside of regular trading hours
     *
     * @return outsideRth
     **/
    @JsonProperty("outsideRth")
    @ApiModelProperty(value = "The historical data returned includes outside of regular trading hours ")
    public Boolean isOutsideRth() {
        return outsideRth;
    }

    public HistoryData low(String low) {
        this.low = low;
        return this;
    }

    public HistoryData mdAvailability(String mdAvailability) {
        this.mdAvailability = mdAvailability;
        return this;
    }

    public HistoryData messageVersion(Integer messageVersion) {
        this.messageVersion = messageVersion;
        return this;
    }

    public HistoryData mktDataDelay(Integer mktDataDelay) {
        this.mktDataDelay = mktDataDelay;
        return this;
    }

    public HistoryData negativeCapable(Boolean negativeCapable) {
        this.negativeCapable = negativeCapable;
        return this;
    }

    public HistoryData outsideRth(Boolean outsideRth) {
        this.outsideRth = outsideRth;
        return this;
    }

    public HistoryData points(Integer points) {
        this.points = points;
        return this;
    }

    public HistoryData priceDisplayRule(Integer priceDisplayRule) {
        this.priceDisplayRule = priceDisplayRule;
        return this;
    }

    public HistoryData priceDisplayValue(String priceDisplayValue) {
        this.priceDisplayValue = priceDisplayValue;
        return this;
    }

    public HistoryData priceFactor(Integer priceFactor) {
        this.priceFactor = priceFactor;
        return this;
    }

    public HistoryData startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public HistoryData symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public HistoryData text(String text) {
        this.text = text;
        return this;
    }

    public HistoryData timePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
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

    public HistoryData tradingDayDuration(Integer tradingDayDuration) {
        this.tradingDayDuration = tradingDayDuration;
        return this;
    }

    public HistoryData travelTime(Integer travelTime) {
        this.travelTime = travelTime;
        return this;
    }

    public HistoryData volumeFactor(Integer volumeFactor) {
        this.volumeFactor = volumeFactor;
        return this;
    }
}

