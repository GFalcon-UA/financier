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
 * ModifyOrder
 */
@Validated
public class ModifyOrder {

    @ApiModelProperty(value = "")
    @JsonProperty("acctId")
    @SerializedName("acctId")
    private String acctId = null;

    @ApiModelProperty(value = "")
    @JsonProperty("conid")
    @SerializedName("conid")
    private Integer conid = null;

    @ApiModelProperty(value = "for example LMT")
    /**
     * for example LMT
     **/
    @JsonProperty("orderType")
    @SerializedName("orderType")
    private String orderType = null;

    @ApiModelProperty(value = "")
    @JsonProperty("outsideRTH")
    @SerializedName("outsideRTH")
    private Boolean outsideRTH = null;

    @ApiModelProperty(value = "")
    @JsonProperty("price")
    @SerializedName("price")
    private BigDecimal price = null;

    @ApiModelProperty(value = "")
    @JsonProperty("auxPrice")
    @SerializedName("auxPrice")
    private BigDecimal auxPrice = null;

    @ApiModelProperty(value = "SELL or BUY")
    /**
     * SELL or BUY
     **/
    @JsonProperty("side")
    @SerializedName("side")
    private String side = null;

    @ApiModelProperty(value = "optional, not required")
    /**
     * optional, not required
     **/
    @JsonProperty("listingExchange")
    @SerializedName("listingExchange")
    private String listingExchange = null;

    @ApiModelProperty(value = "The ticker symbol of the original place order")
    /**
     * The ticker symbol of the original place order
     **/
    @JsonProperty("ticker")
    @SerializedName("ticker")
    private String ticker = null;

    @ApiModelProperty(example = "tif = DAY to tif = GTC",
            value = "Specify a time in force to change how long your order will continue to work in the market")
    /**
     * Specify a time in force to change how long your order will continue to work in the market
     **/
    @JsonProperty("tif")
    @SerializedName("tif")
    private String tif = null;

    @ApiModelProperty(value = "usually integer, for some special cases can be float numbers")
    /**
     * usually integer, for some special cases can be float numbers
     **/
    @JsonProperty("quantity")
    @SerializedName("quantity")
    private BigDecimal quantity = null;

    @ApiModelProperty(value = "Set to true if you want to pause a working order. For details refer to the [TWS Users' Guide:](https://guides.interactivebrokers.com/tws/twsguide.html#usersguidebook/getstarted/pause_execution.htm) ")
    /**
     * Set to true if you want to pause a working order. For details refer to the [TWS Users' Guide:](https://guides.interactivebrokers.com/tws/twsguide.html#usersguidebook/getstarted/pause_execution.htm)
     **/
    @JsonProperty("deactivated")
    @SerializedName("deactivated")
    private Boolean deactivated = null;

    /**
     * Get acctId
     *
     * @return acctId
     **/
    @JsonProperty("acctId")
    @ApiModelProperty(value = "")
    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    /**
     * Get auxPrice
     *
     * @return auxPrice
     **/
    @JsonProperty("auxPrice")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getAuxPrice() {
        return auxPrice;
    }

    public void setAuxPrice(BigDecimal auxPrice) {
        this.auxPrice = auxPrice;
    }

    /**
     * Get conid
     *
     * @return conid
     **/
    @JsonProperty("conid")
    @ApiModelProperty(value = "")
    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }

    /**
     * optional, not required
     *
     * @return listingExchange
     **/
    @JsonProperty("listingExchange")
    @ApiModelProperty(value = "optional, not required")
    public String getListingExchange() {
        return listingExchange;
    }

    public void setListingExchange(String listingExchange) {
        this.listingExchange = listingExchange;
    }

    /**
     * for example LMT
     *
     * @return orderType
     **/
    @JsonProperty("orderType")
    @ApiModelProperty(value = "for example LMT")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Get price
     *
     * @return price
     **/
    @JsonProperty("price")
    @ApiModelProperty(value = "")
    @Valid
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * usually integer, for some special cases can be float numbers
     *
     * @return quantity
     **/
    @JsonProperty("quantity")
    @ApiModelProperty(value = "usually integer, for some special cases can be float numbers")
    @Valid
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * SELL or BUY
     *
     * @return side
     **/
    @JsonProperty("side")
    @ApiModelProperty(value = "SELL or BUY")
    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    /**
     * The ticker symbol of the original place order
     *
     * @return ticker
     **/
    @JsonProperty("ticker")
    @ApiModelProperty(value = "The ticker symbol of the original place order")
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * Specify a time in force to change how long your order will continue to work in the market
     *
     * @return tif
     **/
    @JsonProperty("tif")
    @ApiModelProperty(example = "tif = DAY to tif = GTC",
            value = "Specify a time in force to change how long your order will continue to work in the market")
    public String getTif() {
        return tif;
    }

    public void setTif(String tif) {
        this.tif = tif;
    }

    public void setDeactivated(Boolean deactivated) {
        this.deactivated = deactivated;
    }

    public void setOutsideRTH(Boolean outsideRTH) {
        this.outsideRTH = outsideRTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctId, conid, orderType, outsideRTH, price, auxPrice, side, listingExchange, ticker, tif,
                quantity, deactivated);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModifyOrder modifyOrder = (ModifyOrder) o;
        return Objects.equals(this.acctId, modifyOrder.acctId) && Objects.equals(this.conid, modifyOrder.conid)
                && Objects.equals(this.orderType, modifyOrder.orderType) && Objects.equals(this.outsideRTH,
                modifyOrder.outsideRTH) && Objects.equals(this.price, modifyOrder.price) && Objects.equals(
                this.auxPrice, modifyOrder.auxPrice) && Objects.equals(this.side, modifyOrder.side) && Objects.equals(
                this.listingExchange, modifyOrder.listingExchange) && Objects.equals(this.ticker, modifyOrder.ticker)
                && Objects.equals(this.tif, modifyOrder.tif) && Objects.equals(this.quantity, modifyOrder.quantity)
                && Objects.equals(this.deactivated, modifyOrder.deactivated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModifyOrder {\n");

        sb.append("    acctId: ")
                .append(toIndentedString(acctId))
                .append("\n");
        sb.append("    conid: ")
                .append(toIndentedString(conid))
                .append("\n");
        sb.append("    orderType: ")
                .append(toIndentedString(orderType))
                .append("\n");
        sb.append("    outsideRTH: ")
                .append(toIndentedString(outsideRTH))
                .append("\n");
        sb.append("    price: ")
                .append(toIndentedString(price))
                .append("\n");
        sb.append("    auxPrice: ")
                .append(toIndentedString(auxPrice))
                .append("\n");
        sb.append("    side: ")
                .append(toIndentedString(side))
                .append("\n");
        sb.append("    listingExchange: ")
                .append(toIndentedString(listingExchange))
                .append("\n");
        sb.append("    ticker: ")
                .append(toIndentedString(ticker))
                .append("\n");
        sb.append("    tif: ")
                .append(toIndentedString(tif))
                .append("\n");
        sb.append("    quantity: ")
                .append(toIndentedString(quantity))
                .append("\n");
        sb.append("    deactivated: ")
                .append(toIndentedString(deactivated))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public ModifyOrder acctId(String acctId) {
        this.acctId = acctId;
        return this;
    }

    public ModifyOrder auxPrice(BigDecimal auxPrice) {
        this.auxPrice = auxPrice;
        return this;
    }

    public ModifyOrder conid(Integer conid) {
        this.conid = conid;
        return this;
    }

    public ModifyOrder deactivated(Boolean deactivated) {
        this.deactivated = deactivated;
        return this;
    }

    /**
     * Set to true if you want to pause a working order. For details refer to the [TWS Users'
     * Guide:](https://guides.interactivebrokers.com/tws/twsguide.html#usersguidebook/getstarted/pause_execution.htm)
     *
     * @return deactivated
     **/
    @JsonProperty("deactivated")
    @ApiModelProperty(value = "Set to true if you want to pause a working order. For details refer to the [TWS Users' Guide:](https://guides.interactivebrokers.com/tws/twsguide.html#usersguidebook/getstarted/pause_execution.htm) ")
    public Boolean isDeactivated() {
        return deactivated;
    }

    /**
     * Get outsideRTH
     *
     * @return outsideRTH
     **/
    @JsonProperty("outsideRTH")
    @ApiModelProperty(value = "")
    public Boolean isOutsideRTH() {
        return outsideRTH;
    }

    public ModifyOrder listingExchange(String listingExchange) {
        this.listingExchange = listingExchange;
        return this;
    }

    public ModifyOrder orderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public ModifyOrder outsideRTH(Boolean outsideRTH) {
        this.outsideRTH = outsideRTH;
        return this;
    }

    public ModifyOrder price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ModifyOrder quantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    public ModifyOrder side(String side) {
        this.side = side;
        return this;
    }

    public ModifyOrder ticker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public ModifyOrder tif(String tif) {
        this.tif = tif;
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

