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
 * AlertResponse
 */
@Validated
public class AlertResponse {

    @ApiModelProperty(value = "account id")
    /**
     * account id
     **/
    @JsonProperty("account")
    @SerializedName("account")
    private String account = null;

    @ApiModelProperty(value = "")
    @JsonProperty("order_id")
    @SerializedName("order_id")
    private Integer orderId = null;

    @ApiModelProperty(value = "name of alert")
    /**
     * name of alert
     **/
    @JsonProperty("alert_name")
    @SerializedName("alert_name")
    private String alertName = null;

    @ApiModelProperty(value = "The message you want to receive via email or text message")
    /**
     * The message you want to receive via email or text message
     **/
    @JsonProperty("alert_message")
    @SerializedName("alert_message")
    private String alertMessage = null;

    @ApiModelProperty(value = "whether alert is active or not, so value can only be 0 or 1")
    /**
     * whether alert is active or not, so value can only be 0 or 1
     **/
    @JsonProperty("alert_active")
    @SerializedName("alert_active")
    private Integer alertActive = null;

    @ApiModelProperty(value = "whether alert is repeatable or not, so value can only be 0 or 1")
    /**
     * whether alert is repeatable or not, so value can only be 0 or 1
     **/
    @JsonProperty("alert_repeatable")
    @SerializedName("alert_repeatable")
    private Integer alertRepeatable = null;

    @ApiModelProperty(value = "email address to receive alert")
    /**
     * email address to receive alert
     **/
    @JsonProperty("alert_email")
    @SerializedName("alert_email")
    private String alertEmail = null;

    @ApiModelProperty(value = "whether allowing to send email or not, so value can only be 0 or 1, ")
    /**
     * whether allowing to send email or not, so value can only be 0 or 1,
     **/
    @JsonProperty("alert_send_message")
    @SerializedName("alert_send_message")
    private Integer alertSendMessage = null;

    @ApiModelProperty(value = "time in force, can only be GTC or GTD")
    /**
     * time in force, can only be GTC or GTD
     **/
    @JsonProperty("tif")
    @SerializedName("tif")
    private String tif = null;

    @ApiModelProperty(example = "20201105-19:51:14", value = "format, YYYYMMDD-HH:mm:ss ")
    /**
     * format, YYYYMMDD-HH:mm:ss
     **/
    @JsonProperty("expire_time")
    @SerializedName("expire_time")
    private String expireTime = null;

    @ApiModelProperty(example = "Submitted", value = "status of alert")
    /**
     * status of alert
     **/
    @JsonProperty("order_status")
    @SerializedName("order_status")
    private String orderStatus = null;

    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours. ")
    /**
     * value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours.
     **/
    @JsonProperty("outsideRth")
    @SerializedName("outsideRth")
    private Integer outsideRth = null;

    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile ")
    /**
     * value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile
     **/
    @JsonProperty("itws_orders_only")
    @SerializedName("itws_orders_only")
    private Integer itwsOrdersOnly = null;

    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to allow to show alert in pop-ups")
    /**
     * value can only be 0 or 1, set to 1 to allow to show alert in pop-ups
     **/
    @JsonProperty("alert_show_popup")
    @SerializedName("alert_show_popup")
    private Integer alertShowPopup = null;

    @ApiModelProperty(value = "whether the alert has been triggered")
    /**
     * whether the alert has been triggered
     **/
    @JsonProperty("alert_triggered")
    @SerializedName("alert_triggered")
    private Boolean alertTriggered = null;

    @ApiModelProperty(value = "whether the alert can be edited")
    /**
     * whether the alert can be edited
     **/
    @JsonProperty("order_not_editable")
    @SerializedName("order_not_editable")
    private Boolean orderNotEditable = null;

    @ApiModelProperty(value = "for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert ")
    /**
     * for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert
     **/
    @JsonProperty("tool_id")
    @SerializedName("tool_id")
    private Integer toolId = null;

    @ApiModelProperty(value = "audio message to play when alert is triggered")
    /**
     * audio message to play when alert is triggered
     **/
    @JsonProperty("alert_play_audio")
    @SerializedName("alert_play_audio")
    private String alertPlayAudio = null;

    @ApiModelProperty(value = "MTA alert only")
    /**
     * MTA alert only
     **/
    @JsonProperty("alert_mta_currency")
    @SerializedName("alert_mta_currency")
    private String alertMtaCurrency = null;

    @ApiModelProperty(value = "MTA alert only")
    /**
     * MTA alert only
     **/
    @JsonProperty("alert_mta_defaults")
    @SerializedName("alert_mta_defaults")
    private String alertMtaDefaults = null;

    @ApiModelProperty(value = "MTA alert only")
    /**
     * MTA alert only
     **/
    @JsonProperty("time_zone")
    @SerializedName("time_zone")
    private String timeZone = null;

    @ApiModelProperty(value = "MTA alert only")
    /**
     * MTA alert only
     **/
    @JsonProperty("alert_default_type")
    @SerializedName("alert_default_type")
    private String alertDefaultType = null;

    @ApiModelProperty(value = "size of conditions array")
    /**
     * size of conditions array
     **/
    @JsonProperty("condition_size")
    @SerializedName("condition_size")
    private Integer conditionSize = null;

    @ApiModelProperty(value = "whether allowing the condition can be triggered outside of regular trading hours, 1 means allow")
    /**
     * whether allowing the condition can be triggered outside of regular trading hours, 1 means allow
     **/
    @JsonProperty("condition_outside_rth")
    @SerializedName("condition_outside_rth")
    private Integer conditionOutsideRth = null;

    @ApiModelProperty(value = "")
    @JsonProperty("conditions")
    @Valid
    @SerializedName("conditions")
    private List<Object> conditions = new ArrayList<Object>();

    /**
     * account id
     *
     * @return account
     **/
    @JsonProperty("account")
    @ApiModelProperty(value = "account id")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * whether alert is active or not, so value can only be 0 or 1
     *
     * @return alertActive
     **/
    @JsonProperty("alert_active")
    @ApiModelProperty(value = "whether alert is active or not, so value can only be 0 or 1")
    public Integer getAlertActive() {
        return alertActive;
    }

    public void setAlertActive(Integer alertActive) {
        this.alertActive = alertActive;
    }

    /**
     * MTA alert only
     *
     * @return alertDefaultType
     **/
    @JsonProperty("alert_default_type")
    @ApiModelProperty(value = "MTA alert only")
    public String getAlertDefaultType() {
        return alertDefaultType;
    }

    public void setAlertDefaultType(String alertDefaultType) {
        this.alertDefaultType = alertDefaultType;
    }

    /**
     * email address to receive alert
     *
     * @return alertEmail
     **/
    @JsonProperty("alert_email")
    @ApiModelProperty(value = "email address to receive alert")
    public String getAlertEmail() {
        return alertEmail;
    }

    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    /**
     * The message you want to receive via email or text message
     *
     * @return alertMessage
     **/
    @JsonProperty("alert_message")
    @ApiModelProperty(value = "The message you want to receive via email or text message")
    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    /**
     * MTA alert only
     *
     * @return alertMtaCurrency
     **/
    @JsonProperty("alert_mta_currency")
    @ApiModelProperty(value = "MTA alert only")
    public String getAlertMtaCurrency() {
        return alertMtaCurrency;
    }

    public void setAlertMtaCurrency(String alertMtaCurrency) {
        this.alertMtaCurrency = alertMtaCurrency;
    }

    /**
     * MTA alert only
     *
     * @return alertMtaDefaults
     **/
    @JsonProperty("alert_mta_defaults")
    @ApiModelProperty(value = "MTA alert only")
    public String getAlertMtaDefaults() {
        return alertMtaDefaults;
    }

    public void setAlertMtaDefaults(String alertMtaDefaults) {
        this.alertMtaDefaults = alertMtaDefaults;
    }

    /**
     * name of alert
     *
     * @return alertName
     **/
    @JsonProperty("alert_name")
    @ApiModelProperty(value = "name of alert")
    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    /**
     * audio message to play when alert is triggered
     *
     * @return alertPlayAudio
     **/
    @JsonProperty("alert_play_audio")
    @ApiModelProperty(value = "audio message to play when alert is triggered")
    public String getAlertPlayAudio() {
        return alertPlayAudio;
    }

    public void setAlertPlayAudio(String alertPlayAudio) {
        this.alertPlayAudio = alertPlayAudio;
    }

    /**
     * whether alert is repeatable or not, so value can only be 0 or 1
     *
     * @return alertRepeatable
     **/
    @JsonProperty("alert_repeatable")
    @ApiModelProperty(value = "whether alert is repeatable or not, so value can only be 0 or 1")
    public Integer getAlertRepeatable() {
        return alertRepeatable;
    }

    public void setAlertRepeatable(Integer alertRepeatable) {
        this.alertRepeatable = alertRepeatable;
    }

    /**
     * whether allowing to send email or not, so value can only be 0 or 1,
     *
     * @return alertSendMessage
     **/
    @JsonProperty("alert_send_message")
    @ApiModelProperty(value = "whether allowing to send email or not, so value can only be 0 or 1, ")
    public Integer getAlertSendMessage() {
        return alertSendMessage;
    }

    public void setAlertSendMessage(Integer alertSendMessage) {
        this.alertSendMessage = alertSendMessage;
    }

    /**
     * value can only be 0 or 1, set to 1 to allow to show alert in pop-ups
     *
     * @return alertShowPopup
     **/
    @JsonProperty("alert_show_popup")
    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to allow to show alert in pop-ups")
    public Integer getAlertShowPopup() {
        return alertShowPopup;
    }

    public void setAlertShowPopup(Integer alertShowPopup) {
        this.alertShowPopup = alertShowPopup;
    }

    /**
     * whether allowing the condition can be triggered outside of regular trading hours, 1 means allow
     *
     * @return conditionOutsideRth
     **/
    @JsonProperty("condition_outside_rth")
    @ApiModelProperty(value = "whether allowing the condition can be triggered outside of regular trading hours, 1 means allow")
    public Integer getConditionOutsideRth() {
        return conditionOutsideRth;
    }

    public void setConditionOutsideRth(Integer conditionOutsideRth) {
        this.conditionOutsideRth = conditionOutsideRth;
    }

    /**
     * size of conditions array
     *
     * @return conditionSize
     **/
    @JsonProperty("condition_size")
    @ApiModelProperty(value = "size of conditions array")
    public Integer getConditionSize() {
        return conditionSize;
    }

    public void setConditionSize(Integer conditionSize) {
        this.conditionSize = conditionSize;
    }

    /**
     * Get conditions
     *
     * @return conditions
     **/
    @JsonProperty("conditions")
    @ApiModelProperty(value = "")
    public List<Object> getConditions() {
        return conditions;
    }

    public void setConditions(List<Object> conditions) {
        this.conditions = conditions;
    }

    /**
     * format, YYYYMMDD-HH:mm:ss
     *
     * @return expireTime
     **/
    @JsonProperty("expire_time")
    @ApiModelProperty(example = "20201105-19:51:14", value = "format, YYYYMMDD-HH:mm:ss ")
    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile
     *
     * @return itwsOrdersOnly
     **/
    @JsonProperty("itws_orders_only")
    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile ")
    public Integer getItwsOrdersOnly() {
        return itwsOrdersOnly;
    }

    public void setItwsOrdersOnly(Integer itwsOrdersOnly) {
        this.itwsOrdersOnly = itwsOrdersOnly;
    }

    /**
     * Get orderId
     *
     * @return orderId
     **/
    @JsonProperty("order_id")
    @ApiModelProperty(value = "")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * status of alert
     *
     * @return orderStatus
     **/
    @JsonProperty("order_status")
    @ApiModelProperty(example = "Submitted", value = "status of alert")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours.
     *
     * @return outsideRth
     **/
    @JsonProperty("outsideRth")
    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours. ")
    public Integer getOutsideRth() {
        return outsideRth;
    }

    public void setOutsideRth(Integer outsideRth) {
        this.outsideRth = outsideRth;
    }

    /**
     * time in force, can only be GTC or GTD
     *
     * @return tif
     **/
    @JsonProperty("tif")
    @ApiModelProperty(value = "time in force, can only be GTC or GTD")
    public String getTif() {
        return tif;
    }

    public void setTif(String tif) {
        this.tif = tif;
    }

    /**
     * MTA alert only
     *
     * @return timeZone
     **/
    @JsonProperty("time_zone")
    @ApiModelProperty(value = "MTA alert only")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert
     *
     * @return toolId
     **/
    @JsonProperty("tool_id")
    @ApiModelProperty(value = "for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert ")
    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    public void setAlertTriggered(Boolean alertTriggered) {
        this.alertTriggered = alertTriggered;
    }

    public void setOrderNotEditable(Boolean orderNotEditable) {
        this.orderNotEditable = orderNotEditable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, orderId, alertName, alertMessage, alertActive, alertRepeatable, alertEmail,
                alertSendMessage, tif, expireTime, orderStatus, outsideRth, itwsOrdersOnly, alertShowPopup,
                alertTriggered, orderNotEditable, toolId, alertPlayAudio, alertMtaCurrency, alertMtaDefaults, timeZone,
                alertDefaultType, conditionSize, conditionOutsideRth, conditions);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlertResponse alertResponse = (AlertResponse) o;
        return Objects.equals(this.account, alertResponse.account) && Objects.equals(this.orderId,
                alertResponse.orderId) && Objects.equals(this.alertName, alertResponse.alertName) && Objects.equals(
                this.alertMessage, alertResponse.alertMessage) && Objects.equals(this.alertActive,
                alertResponse.alertActive) && Objects.equals(this.alertRepeatable, alertResponse.alertRepeatable)
                && Objects.equals(this.alertEmail, alertResponse.alertEmail) && Objects.equals(this.alertSendMessage,
                alertResponse.alertSendMessage) && Objects.equals(this.tif, alertResponse.tif) && Objects.equals(
                this.expireTime, alertResponse.expireTime) && Objects.equals(this.orderStatus,
                alertResponse.orderStatus) && Objects.equals(this.outsideRth, alertResponse.outsideRth)
                && Objects.equals(this.itwsOrdersOnly, alertResponse.itwsOrdersOnly) && Objects.equals(
                this.alertShowPopup, alertResponse.alertShowPopup) && Objects.equals(this.alertTriggered,
                alertResponse.alertTriggered) && Objects.equals(this.orderNotEditable, alertResponse.orderNotEditable)
                && Objects.equals(this.toolId, alertResponse.toolId) && Objects.equals(this.alertPlayAudio,
                alertResponse.alertPlayAudio) && Objects.equals(this.alertMtaCurrency, alertResponse.alertMtaCurrency)
                && Objects.equals(this.alertMtaDefaults, alertResponse.alertMtaDefaults) && Objects.equals(
                this.timeZone, alertResponse.timeZone) && Objects.equals(this.alertDefaultType,
                alertResponse.alertDefaultType) && Objects.equals(this.conditionSize, alertResponse.conditionSize)
                && Objects.equals(this.conditionOutsideRth, alertResponse.conditionOutsideRth) && Objects.equals(
                this.conditions, alertResponse.conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlertResponse {\n");

        sb.append("    account: ")
                .append(toIndentedString(account))
                .append("\n");
        sb.append("    orderId: ")
                .append(toIndentedString(orderId))
                .append("\n");
        sb.append("    alertName: ")
                .append(toIndentedString(alertName))
                .append("\n");
        sb.append("    alertMessage: ")
                .append(toIndentedString(alertMessage))
                .append("\n");
        sb.append("    alertActive: ")
                .append(toIndentedString(alertActive))
                .append("\n");
        sb.append("    alertRepeatable: ")
                .append(toIndentedString(alertRepeatable))
                .append("\n");
        sb.append("    alertEmail: ")
                .append(toIndentedString(alertEmail))
                .append("\n");
        sb.append("    alertSendMessage: ")
                .append(toIndentedString(alertSendMessage))
                .append("\n");
        sb.append("    tif: ")
                .append(toIndentedString(tif))
                .append("\n");
        sb.append("    expireTime: ")
                .append(toIndentedString(expireTime))
                .append("\n");
        sb.append("    orderStatus: ")
                .append(toIndentedString(orderStatus))
                .append("\n");
        sb.append("    outsideRth: ")
                .append(toIndentedString(outsideRth))
                .append("\n");
        sb.append("    itwsOrdersOnly: ")
                .append(toIndentedString(itwsOrdersOnly))
                .append("\n");
        sb.append("    alertShowPopup: ")
                .append(toIndentedString(alertShowPopup))
                .append("\n");
        sb.append("    alertTriggered: ")
                .append(toIndentedString(alertTriggered))
                .append("\n");
        sb.append("    orderNotEditable: ")
                .append(toIndentedString(orderNotEditable))
                .append("\n");
        sb.append("    toolId: ")
                .append(toIndentedString(toolId))
                .append("\n");
        sb.append("    alertPlayAudio: ")
                .append(toIndentedString(alertPlayAudio))
                .append("\n");
        sb.append("    alertMtaCurrency: ")
                .append(toIndentedString(alertMtaCurrency))
                .append("\n");
        sb.append("    alertMtaDefaults: ")
                .append(toIndentedString(alertMtaDefaults))
                .append("\n");
        sb.append("    timeZone: ")
                .append(toIndentedString(timeZone))
                .append("\n");
        sb.append("    alertDefaultType: ")
                .append(toIndentedString(alertDefaultType))
                .append("\n");
        sb.append("    conditionSize: ")
                .append(toIndentedString(conditionSize))
                .append("\n");
        sb.append("    conditionOutsideRth: ")
                .append(toIndentedString(conditionOutsideRth))
                .append("\n");
        sb.append("    conditions: ")
                .append(toIndentedString(conditions))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public AlertResponse account(String account) {
        this.account = account;
        return this;
    }

    public AlertResponse addConditionsItem(Object conditionsItem) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<Object>();
        }
        this.conditions.add(conditionsItem);
        return this;
    }

    public AlertResponse alertActive(Integer alertActive) {
        this.alertActive = alertActive;
        return this;
    }

    public AlertResponse alertDefaultType(String alertDefaultType) {
        this.alertDefaultType = alertDefaultType;
        return this;
    }

    public AlertResponse alertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
        return this;
    }

    public AlertResponse alertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
        return this;
    }

    public AlertResponse alertMtaCurrency(String alertMtaCurrency) {
        this.alertMtaCurrency = alertMtaCurrency;
        return this;
    }

    public AlertResponse alertMtaDefaults(String alertMtaDefaults) {
        this.alertMtaDefaults = alertMtaDefaults;
        return this;
    }

    public AlertResponse alertName(String alertName) {
        this.alertName = alertName;
        return this;
    }

    public AlertResponse alertPlayAudio(String alertPlayAudio) {
        this.alertPlayAudio = alertPlayAudio;
        return this;
    }

    public AlertResponse alertRepeatable(Integer alertRepeatable) {
        this.alertRepeatable = alertRepeatable;
        return this;
    }

    public AlertResponse alertSendMessage(Integer alertSendMessage) {
        this.alertSendMessage = alertSendMessage;
        return this;
    }

    public AlertResponse alertShowPopup(Integer alertShowPopup) {
        this.alertShowPopup = alertShowPopup;
        return this;
    }

    public AlertResponse alertTriggered(Boolean alertTriggered) {
        this.alertTriggered = alertTriggered;
        return this;
    }

    public AlertResponse conditionOutsideRth(Integer conditionOutsideRth) {
        this.conditionOutsideRth = conditionOutsideRth;
        return this;
    }

    public AlertResponse conditionSize(Integer conditionSize) {
        this.conditionSize = conditionSize;
        return this;
    }

    public AlertResponse conditions(List<Object> conditions) {
        this.conditions = conditions;
        return this;
    }

    public AlertResponse expireTime(String expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    /**
     * whether the alert has been triggered
     *
     * @return alertTriggered
     **/
    @JsonProperty("alert_triggered")
    @ApiModelProperty(value = "whether the alert has been triggered")
    public Boolean isAlertTriggered() {
        return alertTriggered;
    }

    /**
     * whether the alert can be edited
     *
     * @return orderNotEditable
     **/
    @JsonProperty("order_not_editable")
    @ApiModelProperty(value = "whether the alert can be edited")
    public Boolean isOrderNotEditable() {
        return orderNotEditable;
    }

    public AlertResponse itwsOrdersOnly(Integer itwsOrdersOnly) {
        this.itwsOrdersOnly = itwsOrdersOnly;
        return this;
    }

    public AlertResponse orderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public AlertResponse orderNotEditable(Boolean orderNotEditable) {
        this.orderNotEditable = orderNotEditable;
        return this;
    }

    public AlertResponse orderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public AlertResponse outsideRth(Integer outsideRth) {
        this.outsideRth = outsideRth;
        return this;
    }

    public AlertResponse tif(String tif) {
        this.tif = tif;
        return this;
    }

    public AlertResponse timeZone(String timeZone) {
        this.timeZone = timeZone;
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

    public AlertResponse toolId(Integer toolId) {
        this.toolId = toolId;
        return this;
    }
}

