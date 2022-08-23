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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import io.swagger.annotations.ApiModelProperty;

/**
 * OrderData
 */
@Validated
public class OrderData {

    @ApiModelProperty(value = "")
    @JsonProperty("clientOrderId")
    @SerializedName("clientOrderId")
    private String clientOrderId = null;

    @ApiModelProperty(value = "")
    @JsonProperty("execId")
    @SerializedName("execId")
    private String execId = null;
    @ApiModelProperty(value = "")
    @JsonProperty("execType")
    @SerializedName("execType")
    private ExecTypeEnum execType = null;
    @ApiModelProperty(value = "")
    @JsonProperty("orderType")
    @SerializedName("orderType")
    private OrderTypeEnum orderType = null;
    @ApiModelProperty(value = "")
    @JsonProperty("orderStatus")
    @SerializedName("orderStatus")
    private OrderStatusEnum orderStatus = null;
    @ApiModelProperty(value = "Underlying symbol for contract")
    /**
     * Underlying symbol for contract
     **/
    @JsonProperty("symbol")
    @SerializedName("symbol")
    private String symbol = null;
    @ApiModelProperty(value = "Quantity of active order")
    /**
     * Quantity of active order
     **/
    @JsonProperty("orderQty")
    @SerializedName("orderQty")
    private String orderQty = null;
    @ApiModelProperty(value = "Price of active order")
    /**
     * Price of active order
     **/
    @JsonProperty("price")
    @SerializedName("price")
    private String price = null;
    @ApiModelProperty(value = "Quantity of the last partial fill")
    /**
     * Quantity of the last partial fill
     **/
    @JsonProperty("lastShares")
    @SerializedName("lastShares")
    private String lastShares = null;
    @ApiModelProperty(value = "Price of the last partial fill")
    /**
     * Price of the last partial fill
     **/
    @JsonProperty("lastPrice")
    @SerializedName("lastPrice")
    private String lastPrice = null;
    @ApiModelProperty(value = "Cumulative fill quantity")
    /**
     * Cumulative fill quantity
     **/
    @JsonProperty("cumQty")
    @SerializedName("cumQty")
    private String cumQty = null;
    @ApiModelProperty(value = "Remaining quantity to be filled")
    /**
     * Remaining quantity to be filled
     **/
    @JsonProperty("leavesQty")
    @SerializedName("leavesQty")
    private String leavesQty = null;
    @ApiModelProperty(value = "Average fill price")
    /**
     * Average fill price
     **/
    @JsonProperty("avgPrice")
    @SerializedName("avgPrice")
    private String avgPrice = null;
    @ApiModelProperty(value = "")
    @JsonProperty("side")
    @SerializedName("side")
    private SideEnum side = null;
    @ApiModelProperty(value = "Order identifier")
    /**
     * Order identifier
     **/
    @JsonProperty("orderId")
    @SerializedName("orderId")
    private String orderId = null;
    @ApiModelProperty(value = "Account number")
    /**
     * Account number
     **/
    @JsonProperty("account")
    @SerializedName("account")
    private String account = null;
    @ApiModelProperty(value = "Contracts asset class")
    /**
     * Contracts asset class
     **/
    @JsonProperty("secType")
    @SerializedName("secType")
    private SecTypeEnum secType = null;
    @ApiModelProperty(value = "Time of transaction in GMT, format YYYYMMDD-hh:m:ss")
    /**
     * Time of transaction in GMT, format YYYYMMDD-hh:m:ss
     **/
    @JsonProperty("txTime")
    @SerializedName("txTime")
    private String txTime = null;
    @ApiModelProperty(value = "Time of receipt in GMT, format YYYYMMDD-hh:mm:ss")
    /**
     * Time of receipt in GMT, format YYYYMMDD-hh:mm:ss
     **/
    @JsonProperty("rcptTime")
    @SerializedName("rcptTime")
    private String rcptTime = null;
    @ApiModelProperty(value = "Time in Force")
    /**
     * Time in Force
     **/
    @JsonProperty("tif")
    @SerializedName("tif")
    private TifEnum tif = null;
    @ApiModelProperty(value = "Contract identifier from IBKR's database.")
    /**
     * Contract identifier from IBKR's database.
     **/
    @JsonProperty("conid")
    @SerializedName("conid")
    private String conid = null;
    @ApiModelProperty(value = "Trading currency")
    /**
     * Trading currency
     **/
    @JsonProperty("currency")
    @SerializedName("currency")
    private String currency = null;
    @ApiModelProperty(value = "Exchange or venue")
    /**
     * Exchange or venue
     **/
    @JsonProperty("exchange")
    @SerializedName("exchange")
    private String exchange = null;
    @ApiModelProperty(value = "Listing Exchange")
    /**
     * Listing Exchange
     **/
    @JsonProperty("listingExchange")
    @SerializedName("listingExchange")
    private String listingExchange = null;
    @ApiModelProperty(value = "error message")
    /**
     * error message
     **/
    @JsonProperty("text")
    @SerializedName("text")
    private BigDecimal text = null;
    @ApiModelProperty(value = "")
    @JsonProperty("warnings")
    @SerializedName("warnings")
    private Object warnings = null;
    @ApiModelProperty(value = "Commission currency")
    /**
     * Commission currency
     **/
    @JsonProperty("commCurr")
    @SerializedName("commCurr")
    private String commCurr = null;
    @ApiModelProperty(value = "Commissions")
    /**
     * Commissions
     **/
    @JsonProperty("comms")
    @SerializedName("comms")
    private String comms = null;
    @ApiModelProperty(value = "Realized PnL")
    /**
     * Realized PnL
     **/
    @JsonProperty("realizedPnl")
    @SerializedName("realizedPnl")
    private String realizedPnl = null;

    /**
     * Account number
     *
     * @return account
     **/
    @JsonProperty("account")
    @ApiModelProperty(value = "Account number")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Average fill price
     *
     * @return avgPrice
     **/
    @JsonProperty("avgPrice")
    @ApiModelProperty(value = "Average fill price")
    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    /**
     * Get clientOrderId
     *
     * @return clientOrderId
     **/
    @JsonProperty("clientOrderId")
    @ApiModelProperty(value = "")
    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    /**
     * Commission currency
     *
     * @return commCurr
     **/
    @JsonProperty("commCurr")
    @ApiModelProperty(value = "Commission currency")
    public String getCommCurr() {
        return commCurr;
    }

    public void setCommCurr(String commCurr) {
        this.commCurr = commCurr;
    }

    /**
     * Commissions
     *
     * @return comms
     **/
    @JsonProperty("comms")
    @ApiModelProperty(value = "Commissions")
    public String getComms() {
        return comms;
    }

    public void setComms(String comms) {
        this.comms = comms;
    }

    /**
     * Contract identifier from IBKR's database.
     *
     * @return conid
     **/
    @JsonProperty("conid")
    @ApiModelProperty(value = "Contract identifier from IBKR's database.")
    public String getConid() {
        return conid;
    }

    public void setConid(String conid) {
        this.conid = conid;
    }

    /**
     * Cumulative fill quantity
     *
     * @return cumQty
     **/
    @JsonProperty("cumQty")
    @ApiModelProperty(value = "Cumulative fill quantity")
    public String getCumQty() {
        return cumQty;
    }

    public void setCumQty(String cumQty) {
        this.cumQty = cumQty;
    }

    /**
     * Trading currency
     *
     * @return currency
     **/
    @JsonProperty("currency")
    @ApiModelProperty(value = "Trading currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Exchange or venue
     *
     * @return exchange
     **/
    @JsonProperty("exchange")
    @ApiModelProperty(value = "Exchange or venue")
    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * Get execId
     *
     * @return execId
     **/
    @JsonProperty("execId")
    @ApiModelProperty(value = "")
    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    /**
     * Get execType
     *
     * @return execType
     **/
    @JsonProperty("execType")
    @ApiModelProperty(value = "")
    public ExecTypeEnum getExecType() {
        return execType;
    }

    public void setExecType(ExecTypeEnum execType) {
        this.execType = execType;
    }

    /**
     * Get execType
     *
     * @return execType
     **/
    @JsonProperty("execType")
    public String getExecTypeAsString() {
        if (execType == null) {
            return null;
        }
        return execType.value();
    }

    /**
     * Price of the last partial fill
     *
     * @return lastPrice
     **/
    @JsonProperty("lastPrice")
    @ApiModelProperty(value = "Price of the last partial fill")
    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * Quantity of the last partial fill
     *
     * @return lastShares
     **/
    @JsonProperty("lastShares")
    @ApiModelProperty(value = "Quantity of the last partial fill")
    public String getLastShares() {
        return lastShares;
    }

    public void setLastShares(String lastShares) {
        this.lastShares = lastShares;
    }

    /**
     * Remaining quantity to be filled
     *
     * @return leavesQty
     **/
    @JsonProperty("leavesQty")
    @ApiModelProperty(value = "Remaining quantity to be filled")
    public String getLeavesQty() {
        return leavesQty;
    }

    public void setLeavesQty(String leavesQty) {
        this.leavesQty = leavesQty;
    }

    /**
     * Listing Exchange
     *
     * @return listingExchange
     **/
    @JsonProperty("listingExchange")
    @ApiModelProperty(value = "Listing Exchange")
    public String getListingExchange() {
        return listingExchange;
    }

    public void setListingExchange(String listingExchange) {
        this.listingExchange = listingExchange;
    }

    /**
     * Order identifier
     *
     * @return orderId
     **/
    @JsonProperty("orderId")
    @ApiModelProperty(value = "Order identifier")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Quantity of active order
     *
     * @return orderQty
     **/
    @JsonProperty("orderQty")
    @ApiModelProperty(value = "Quantity of active order")
    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * Get orderStatus
     *
     * @return orderStatus
     **/
    @JsonProperty("orderStatus")
    @ApiModelProperty(value = "")
    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Get orderStatus
     *
     * @return orderStatus
     **/
    @JsonProperty("orderStatus")
    public String getOrderStatusAsString() {
        if (orderStatus == null) {
            return null;
        }
        return orderStatus.value();
    }

    /**
     * Get orderType
     *
     * @return orderType
     **/
    @JsonProperty("orderType")
    @ApiModelProperty(value = "")
    public OrderTypeEnum getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
    }

    /**
     * Get orderType
     *
     * @return orderType
     **/
    @JsonProperty("orderType")
    public String getOrderTypeAsString() {
        if (orderType == null) {
            return null;
        }
        return orderType.value();
    }

    /**
     * Price of active order
     *
     * @return price
     **/
    @JsonProperty("price")
    @ApiModelProperty(value = "Price of active order")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Time of receipt in GMT, format YYYYMMDD-hh:mm:ss
     *
     * @return rcptTime
     **/
    @JsonProperty("rcptTime")
    @ApiModelProperty(value = "Time of receipt in GMT, format YYYYMMDD-hh:mm:ss")
    public String getRcptTime() {
        return rcptTime;
    }

    public void setRcptTime(String rcptTime) {
        this.rcptTime = rcptTime;
    }

    /**
     * Realized PnL
     *
     * @return realizedPnl
     **/
    @JsonProperty("realizedPnl")
    @ApiModelProperty(value = "Realized PnL")
    public String getRealizedPnl() {
        return realizedPnl;
    }

    public void setRealizedPnl(String realizedPnl) {
        this.realizedPnl = realizedPnl;
    }

    /**
     * Contracts asset class
     *
     * @return secType
     **/
    @JsonProperty("secType")
    @ApiModelProperty(value = "Contracts asset class")
    public SecTypeEnum getSecType() {
        return secType;
    }

    public void setSecType(SecTypeEnum secType) {
        this.secType = secType;
    }

    /**
     * Contracts asset class
     *
     * @return secType
     **/
    @JsonProperty("secType")
    public String getSecTypeAsString() {
        if (secType == null) {
            return null;
        }
        return secType.value();
    }

    /**
     * Get side
     *
     * @return side
     **/
    @JsonProperty("side")
    @ApiModelProperty(value = "")
    public SideEnum getSide() {
        return side;
    }

    public void setSide(SideEnum side) {
        this.side = side;
    }

    /**
     * Get side
     *
     * @return side
     **/
    @JsonProperty("side")
    public String getSideAsString() {
        if (side == null) {
            return null;
        }
        return side.value();
    }

    /**
     * Underlying symbol for contract
     *
     * @return symbol
     **/
    @JsonProperty("symbol")
    @ApiModelProperty(value = "Underlying symbol for contract")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * error message
     *
     * @return text
     **/
    @JsonProperty("text")
    @ApiModelProperty(value = "error message")
    @Valid
    public BigDecimal getText() {
        return text;
    }

    public void setText(BigDecimal text) {
        this.text = text;
    }

    /**
     * Time in Force
     *
     * @return tif
     **/
    @JsonProperty("tif")
    @ApiModelProperty(value = "Time in Force")
    public TifEnum getTif() {
        return tif;
    }

    public void setTif(TifEnum tif) {
        this.tif = tif;
    }

    /**
     * Time in Force
     *
     * @return tif
     **/
    @JsonProperty("tif")
    public String getTifAsString() {
        if (tif == null) {
            return null;
        }
        return tif.value();
    }

    /**
     * Time of transaction in GMT, format YYYYMMDD-hh:m:ss
     *
     * @return txTime
     **/
    @JsonProperty("txTime")
    @ApiModelProperty(value = "Time of transaction in GMT, format YYYYMMDD-hh:m:ss")
    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    /**
     * Get warnings
     *
     * @return warnings
     **/
    @JsonProperty("warnings")
    @ApiModelProperty(value = "")
    public Object getWarnings() {
        return warnings;
    }

    public void setWarnings(Object warnings) {
        this.warnings = warnings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientOrderId, execId, execType, orderType, orderStatus, symbol, orderQty, price,
                lastShares, lastPrice, cumQty, leavesQty, avgPrice, side, orderId, account, secType, txTime, rcptTime,
                tif, conid, currency, exchange, listingExchange, text, warnings, commCurr, comms, realizedPnl);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderData orderData = (OrderData) o;
        return Objects.equals(this.clientOrderId, orderData.clientOrderId) && Objects.equals(this.execId,
                orderData.execId) && Objects.equals(this.execType, orderData.execType) && Objects.equals(this.orderType,
                orderData.orderType) && Objects.equals(this.orderStatus, orderData.orderStatus) && Objects.equals(
                this.symbol, orderData.symbol) && Objects.equals(this.orderQty, orderData.orderQty) && Objects.equals(
                this.price, orderData.price) && Objects.equals(this.lastShares, orderData.lastShares) && Objects.equals(
                this.lastPrice, orderData.lastPrice) && Objects.equals(this.cumQty, orderData.cumQty) && Objects.equals(
                this.leavesQty, orderData.leavesQty) && Objects.equals(this.avgPrice, orderData.avgPrice)
                && Objects.equals(this.side, orderData.side) && Objects.equals(this.orderId, orderData.orderId)
                && Objects.equals(this.account, orderData.account) && Objects.equals(this.secType, orderData.secType)
                && Objects.equals(this.txTime, orderData.txTime) && Objects.equals(this.rcptTime, orderData.rcptTime)
                && Objects.equals(this.tif, orderData.tif) && Objects.equals(this.conid, orderData.conid)
                && Objects.equals(this.currency, orderData.currency) && Objects.equals(this.exchange,
                orderData.exchange) && Objects.equals(this.listingExchange, orderData.listingExchange)
                && Objects.equals(this.text, orderData.text) && Objects.equals(this.warnings, orderData.warnings)
                && Objects.equals(this.commCurr, orderData.commCurr) && Objects.equals(this.comms, orderData.comms)
                && Objects.equals(this.realizedPnl, orderData.realizedPnl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderData {\n");

        sb.append("    clientOrderId: ")
                .append(toIndentedString(clientOrderId))
                .append("\n");
        sb.append("    execId: ")
                .append(toIndentedString(execId))
                .append("\n");
        sb.append("    execType: ")
                .append(toIndentedString(execType))
                .append("\n");
        sb.append("    orderType: ")
                .append(toIndentedString(orderType))
                .append("\n");
        sb.append("    orderStatus: ")
                .append(toIndentedString(orderStatus))
                .append("\n");
        sb.append("    symbol: ")
                .append(toIndentedString(symbol))
                .append("\n");
        sb.append("    orderQty: ")
                .append(toIndentedString(orderQty))
                .append("\n");
        sb.append("    price: ")
                .append(toIndentedString(price))
                .append("\n");
        sb.append("    lastShares: ")
                .append(toIndentedString(lastShares))
                .append("\n");
        sb.append("    lastPrice: ")
                .append(toIndentedString(lastPrice))
                .append("\n");
        sb.append("    cumQty: ")
                .append(toIndentedString(cumQty))
                .append("\n");
        sb.append("    leavesQty: ")
                .append(toIndentedString(leavesQty))
                .append("\n");
        sb.append("    avgPrice: ")
                .append(toIndentedString(avgPrice))
                .append("\n");
        sb.append("    side: ")
                .append(toIndentedString(side))
                .append("\n");
        sb.append("    orderId: ")
                .append(toIndentedString(orderId))
                .append("\n");
        sb.append("    account: ")
                .append(toIndentedString(account))
                .append("\n");
        sb.append("    secType: ")
                .append(toIndentedString(secType))
                .append("\n");
        sb.append("    txTime: ")
                .append(toIndentedString(txTime))
                .append("\n");
        sb.append("    rcptTime: ")
                .append(toIndentedString(rcptTime))
                .append("\n");
        sb.append("    tif: ")
                .append(toIndentedString(tif))
                .append("\n");
        sb.append("    conid: ")
                .append(toIndentedString(conid))
                .append("\n");
        sb.append("    currency: ")
                .append(toIndentedString(currency))
                .append("\n");
        sb.append("    exchange: ")
                .append(toIndentedString(exchange))
                .append("\n");
        sb.append("    listingExchange: ")
                .append(toIndentedString(listingExchange))
                .append("\n");
        sb.append("    text: ")
                .append(toIndentedString(text))
                .append("\n");
        sb.append("    warnings: ")
                .append(toIndentedString(warnings))
                .append("\n");
        sb.append("    commCurr: ")
                .append(toIndentedString(commCurr))
                .append("\n");
        sb.append("    comms: ")
                .append(toIndentedString(comms))
                .append("\n");
        sb.append("    realizedPnl: ")
                .append(toIndentedString(realizedPnl))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public OrderData account(String account) {
        this.account = account;
        return this;
    }

    public OrderData avgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
        return this;
    }

    public OrderData clientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    public OrderData commCurr(String commCurr) {
        this.commCurr = commCurr;
        return this;
    }

    public OrderData comms(String comms) {
        this.comms = comms;
        return this;
    }

    public OrderData conid(String conid) {
        this.conid = conid;
        return this;
    }

    public OrderData cumQty(String cumQty) {
        this.cumQty = cumQty;
        return this;
    }

    public OrderData currency(String currency) {
        this.currency = currency;
        return this;
    }

    public OrderData exchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public OrderData execId(String execId) {
        this.execId = execId;
        return this;
    }

    public OrderData execType(ExecTypeEnum execType) {
        this.execType = execType;
        return this;
    }

    public OrderData lastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
        return this;
    }

    public OrderData lastShares(String lastShares) {
        this.lastShares = lastShares;
        return this;
    }

    public OrderData leavesQty(String leavesQty) {
        this.leavesQty = leavesQty;
        return this;
    }

    public OrderData listingExchange(String listingExchange) {
        this.listingExchange = listingExchange;
        return this;
    }

    public OrderData orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderData orderQty(String orderQty) {
        this.orderQty = orderQty;
        return this;
    }

    public OrderData orderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderData orderType(OrderTypeEnum orderType) {
        this.orderType = orderType;
        return this;
    }

    public OrderData price(String price) {
        this.price = price;
        return this;
    }

    public OrderData rcptTime(String rcptTime) {
        this.rcptTime = rcptTime;
        return this;
    }

    public OrderData realizedPnl(String realizedPnl) {
        this.realizedPnl = realizedPnl;
        return this;
    }

    public OrderData secType(SecTypeEnum secType) {
        this.secType = secType;
        return this;
    }

    public OrderData side(SideEnum side) {
        this.side = side;
        return this;
    }

    public OrderData symbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public OrderData text(BigDecimal text) {
        this.text = text;
        return this;
    }

    public OrderData tif(TifEnum tif) {
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

    public OrderData txTime(String txTime) {
        this.txTime = txTime;
        return this;
    }

    public OrderData warnings(Object warnings) {
        this.warnings = warnings;
        return this;
    }

    /**
     * Gets or Sets execType
     */
    @XmlType(name = "ExecTypeEnum")
    @XmlEnum(String.class)
    @JsonAdapter(ExecTypeEnum.Adapter.class)
    public enum ExecTypeEnum {

        @XmlEnumValue("-1 \"Invalid\"") _1_INVALID_(String.valueOf("-1 \"Invalid\"")),

        @XmlEnumValue("0 \"New\"") _0_NEW_(String.valueOf("0 \"New\"")),

        @XmlEnumValue("1 \"Partially Filled\"") _1_PARTIALLY_FILLED_(String.valueOf("1 \"Partially Filled\"")),

        @XmlEnumValue("2 \"Filled\"") _2_FILLED_(String.valueOf("2 \"Filled\"")),

        @XmlEnumValue("3 \"Done for the Day\"") _3_DONE_FOR_THE_DAY_(String.valueOf("3 \"Done for the Day\"")),

        @XmlEnumValue("4 \"Canceled\"") _4_CANCELED_(String.valueOf("4 \"Canceled\"")),

        @XmlEnumValue("5 \"Replaced\"") _5_REPLACED_(String.valueOf("5 \"Replaced\"")),

        @XmlEnumValue("6 \"Pending Cancel\"") _6_PENDING_CANCEL_(String.valueOf("6 \"Pending Cancel\"")),

        @XmlEnumValue("7 \"Stopped\"") _7_STOPPED_(String.valueOf("7 \"Stopped\"")),

        @XmlEnumValue("8 \"Rejected\"") _8_REJECTED_(String.valueOf("8 \"Rejected\"")),

        @XmlEnumValue("9 \"Suspended\"") _9_SUSPENDED_(String.valueOf("9 \"Suspended\"")),

        @XmlEnumValue("A \"Pending New\"") A_PENDING_NEW_(String.valueOf("A \"Pending New\"")),

        @XmlEnumValue("B \"Calculated\"") B_CALCULATED_(String.valueOf("B \"Calculated\"")),

        @XmlEnumValue("C \"Expired\"") C_EXPIRED_(String.valueOf("C \"Expired\"")),

        @XmlEnumValue("D \"Restated\"") D_RESTATED_(String.valueOf("D \"Restated\"")),

        @XmlEnumValue("E \"Pending Replace\"") E_PENDING_REPLACE_(String.valueOf("E \"Pending Replace\"")),

        @XmlEnumValue("F \"Trade\"") F_TRADE_(String.valueOf("F \"Trade\"")),

        @XmlEnumValue("G \"Trade Correct\"") G_TRADE_CORRECT_(String.valueOf("G \"Trade Correct\"")),

        @XmlEnumValue("H \"Trade Cancel\"") H_TRADE_CANCEL_(String.valueOf("H \"Trade Cancel\"")),

        @XmlEnumValue("I \"Order Status\"") I_ORDER_STATUS_(String.valueOf("I \"Order Status\""));


        private String value;

        ExecTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ExecTypeEnum fromValue(String text) {
            for (ExecTypeEnum b : ExecTypeEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<ExecTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ExecTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ExecTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ExecTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Gets or Sets orderType
     */
    @XmlType(name = "OrderTypeEnum")
    @XmlEnum(String.class)
    @JsonAdapter(OrderTypeEnum.Adapter.class)
    public enum OrderTypeEnum {
        @XmlEnumValue("1 \"Market\"") _1_MARKET_(String.valueOf("1 \"Market\"")),

        @XmlEnumValue("2 \"Limit\"") _2_LIMIT_(String.valueOf("2 \"Limit\"")),

        @XmlEnumValue("3 \"Stop\"") _3_STOP_(String.valueOf("3 \"Stop\"")),

        @XmlEnumValue("4 \"Stop Limit\"") _4_STOP_LIMIT_(String.valueOf("4 \"Stop Limit\"")),

        @XmlEnumValue("5 \"Market on Close\"") _5_MARKET_ON_CLOSE_(String.valueOf("5 \"Market on Close\"")),

        @XmlEnumValue("6 \"With or Without\"") _6_WITH_OR_WITHOUT_(String.valueOf("6 \"With or Without\"")),

        @XmlEnumValue("7 \"Limit or Better\"") _7_LIMIT_OR_BETTER_(String.valueOf("7 \"Limit or Better\"")),

        @XmlEnumValue("8 \"Limit With or Without\"") _8_LIMIT_WITH_OR_WITHOUT_(
                String.valueOf("8 \"Limit With or Without\"")),

        @XmlEnumValue("9 \"On Basis\"") _9_ON_BASIS_(String.valueOf("9 \"On Basis\"")),

        @XmlEnumValue("A \"On Close\"") A_ON_CLOSE_(String.valueOf("A \"On Close\"")),

        @XmlEnumValue("B \"Limit On Close\"") B_LIMIT_ON_CLOSE_(String.valueOf("B \"Limit On Close\"")),

        @XmlEnumValue("C \"Forex Market\"") C_FOREX_MARKET_(String.valueOf("C \"Forex Market\"")),

        @XmlEnumValue("D \"Previously Quoted\"") D_PREVIOUSLY_QUOTED_(String.valueOf("D \"Previously Quoted\"")),

        @XmlEnumValue("E \"Previously Indicated\"") E_PREVIOUSLY_INDICATED_(
                String.valueOf("E \"Previously Indicated\"")),

        @XmlEnumValue("F \"Forex Limit\"") F_FOREX_LIMIT_(String.valueOf("F \"Forex Limit\"")),

        @XmlEnumValue("G \"Forex Swap\"") G_FOREX_SWAP_(String.valueOf("G \"Forex Swap\"")),

        @XmlEnumValue("H \"Forex Previously Quoted\"") H_FOREX_PREVIOUSLY_QUOTED_(
                String.valueOf("H \"Forex Previously Quoted\"")),

        @XmlEnumValue("I \"Funari\"") I_FUNARI_(String.valueOf("I \"Funari\"")),

        @XmlEnumValue("K \"Market To Limit\"") K_MARKET_TO_LIMIT_(String.valueOf("K \"Market To Limit\"")),

        @XmlEnumValue("P \"Pegged\"") P_PEGGED_(String.valueOf("P \"Pegged\""));


        private String value;

        OrderTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OrderTypeEnum fromValue(String text) {
            for (OrderTypeEnum b : OrderTypeEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<OrderTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final OrderTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public OrderTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return OrderTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }


    /**
     * Gets or Sets orderStatus
     */
    @XmlType(name = "OrderStatusEnum")
    @XmlEnum(String.class)
    @JsonAdapter(OrderStatusEnum.Adapter.class)
    public enum OrderStatusEnum {

        @XmlEnumValue("-1 \"Invalid Order Status\"") _1_INVALID_ORDER_STATUS_(
                String.valueOf("-1 \"Invalid Order Status\"")),

        @XmlEnumValue("0 \"New\"") _0_NEW_(String.valueOf("0 \"New\"")),

        @XmlEnumValue("1 \"Partially Filled\"") _1_PARTIALLY_FILLED_(String.valueOf("1 \"Partially Filled\"")),

        @XmlEnumValue("2 \"Filled\"") _2_FILLED_(String.valueOf("2 \"Filled\"")),

        @XmlEnumValue("3 \"Done for the Day\"") _3_DONE_FOR_THE_DAY_(String.valueOf("3 \"Done for the Day\"")),

        @XmlEnumValue("4 \"Canceled\"") _4_CANCELED_(String.valueOf("4 \"Canceled\"")),

        @XmlEnumValue("5 \"Replaced\"") _5_REPLACED_(String.valueOf("5 \"Replaced\"")),

        @XmlEnumValue("6 \"Pending Cancel\"") _6_PENDING_CANCEL_(String.valueOf("6 \"Pending Cancel\"")),

        @XmlEnumValue("7 \"Stopped\"") _7_STOPPED_(String.valueOf("7 \"Stopped\"")),

        @XmlEnumValue("8 \"Rejected\"") _8_REJECTED_(String.valueOf("8 \"Rejected\"")),

        @XmlEnumValue("9 \"Suspended\"") _9_SUSPENDED_(String.valueOf("9 \"Suspended\"")),

        @XmlEnumValue("A \"Pending New\"") A_PENDING_NEW_(String.valueOf("A \"Pending New\"")),

        @XmlEnumValue("B \"Calculated\"") B_CALCULATED_(String.valueOf("B \"Calculated\"")),

        @XmlEnumValue("C \"Expired\"") C_EXPIRED_(String.valueOf("C \"Expired\"")),

        @XmlEnumValue("D \"Restated\"") D_RESTATED_(String.valueOf("D \"Restated\"")),

        @XmlEnumValue("E \"Pending Replace\"") E_PENDING_REPLACE_(String.valueOf("E \"Pending Replace\""));


        private String value;

        OrderStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OrderStatusEnum fromValue(String text) {
            for (OrderStatusEnum b : OrderStatusEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<OrderStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final OrderStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public OrderStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return OrderStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Gets or Sets side
     */
    @XmlType(name = "SideEnum")
    @XmlEnum(String.class)
    @JsonAdapter(SideEnum.Adapter.class)
    public enum SideEnum {

        @XmlEnumValue("1 \"Buy\"") _1_BUY_(String.valueOf("1 \"Buy\"")),

        @XmlEnumValue("2 \"Sell\"") _2_SELL_(String.valueOf("2 \"Sell\"")),

        @XmlEnumValue("3 \"Buy Minus\"") _3_BUY_MINUS_(String.valueOf("3 \"Buy Minus\"")),

        @XmlEnumValue("4 \"Sell Plus\"") _4_SELL_PLUS_(String.valueOf("4 \"Sell Plus\"")),

        @XmlEnumValue("5 \"Sell Short\"") _5_SELL_SHORT_(String.valueOf("5 \"Sell Short\"")),

        @XmlEnumValue("6 \"Sell Short Exempt\"") _6_SELL_SHORT_EXEMPT_(String.valueOf("6 \"Sell Short Exempt\""));


        private String value;

        SideEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static SideEnum fromValue(String text) {
            for (SideEnum b : SideEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<SideEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SideEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SideEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SideEnum.fromValue(String.valueOf(value));
            }
        }
    }


    /**
     * Contracts asset class
     */
    @XmlType(name = "SecTypeEnum")
    @XmlEnum(String.class)
    @JsonAdapter(SecTypeEnum.Adapter.class)
    public enum SecTypeEnum {

        @XmlEnumValue("CS \"Stock\"") CS_STOCK_(String.valueOf("CS \"Stock\"")),

        @XmlEnumValue("CASH \"Forex\"") CASH_FOREX_(String.valueOf("CASH \"Forex\"")),

        @XmlEnumValue("CFD \"Contract for Difference\"") CFD_CONTRACT_FOR_DIFFERENCE_(
                String.valueOf("CFD \"Contract for Difference\"")),

        @XmlEnumValue("FUT \"Future\"") FUT_FUTURE_(String.valueOf("FUT \"Future\"")),

        @XmlEnumValue("OPT \"Option\"") OPT_OPTION_(String.valueOf("OPT \"Option\""));


        private String value;

        SecTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static SecTypeEnum fromValue(String text) {
            for (SecTypeEnum b : SecTypeEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<SecTypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final SecTypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public SecTypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return SecTypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Time in Force
     */
    @XmlType(name = "TifEnum")
    @XmlEnum(String.class)
    @JsonAdapter(TifEnum.Adapter.class)
    public enum TifEnum {

        @XmlEnumValue("0 \"Day\"") _0_DAY_(String.valueOf("0 \"Day\"")),

        @XmlEnumValue("1 \"GTC\"") _1_GTC_(String.valueOf("1 \"GTC\"")),

        @XmlEnumValue("2 \"At the Opening\"") _2_AT_THE_OPENING_(String.valueOf("2 \"At the Opening\""));


        private String value;

        TifEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TifEnum fromValue(String text) {
            for (TifEnum b : TifEnum.values()) {
                if (String.valueOf(b.value)
                        .equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String value() {
            return value;
        }

        public static class Adapter extends TypeAdapter<TifEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TifEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TifEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TifEnum.fromValue(String.valueOf(value));
            }
        }
    }
}

