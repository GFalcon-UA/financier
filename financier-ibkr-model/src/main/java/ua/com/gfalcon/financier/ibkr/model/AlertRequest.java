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
 * AlertRequest
 */
@Validated
public class AlertRequest {

    @ApiModelProperty(value = "orderId is required when modifying alert. You can get it from /iserver/account/:accountId/alerts ")
    /**
     * orderId is required when modifying alert. You can get it from /iserver/account/:accountId/alerts
     **/
    @JsonProperty("orderId")
    @SerializedName("orderId")
    private Integer orderId = null;

    @ApiModelProperty(value = "name of alert")
    /**
     * name of alert
     **/
    @JsonProperty("alertName")
    @SerializedName("alertName")
    private String alertName = null;

    @ApiModelProperty(value = "The message you want to receive via email or text message")
    /**
     * The message you want to receive via email or text message
     **/
    @JsonProperty("alertMessage")
    @SerializedName("alertMessage")
    private String alertMessage = null;

    @ApiModelProperty(value = "whether alert is repeatable or not, so value can only be 0 or 1, this has to be 1 for MTA alert")
    /**
     * whether alert is repeatable or not, so value can only be 0 or 1, this has to be 1 for MTA alert
     **/
    @JsonProperty("alertRepeatable")
    @SerializedName("alertRepeatable")
    private Integer alertRepeatable = null;

    @ApiModelProperty(value = "email address to receive alert")
    /**
     * email address to receive alert
     **/
    @JsonProperty("email")
    @SerializedName("email")
    private String email = null;

    @ApiModelProperty(value = "whether allowing to send email or not, so value can only be 0 or 1, ")
    /**
     * whether allowing to send email or not, so value can only be 0 or 1,
     **/
    @JsonProperty("sendMessage")
    @SerializedName("sendMessage")
    private Integer sendMessage = null;

    @ApiModelProperty(value = "time in force, can only be GTC or GTD")
    /**
     * time in force, can only be GTC or GTD
     **/
    @JsonProperty("tif")
    @SerializedName("tif")
    private String tif = null;

    @ApiModelProperty(example = "20201105-19:51:14",
            value = "format, YYYYMMDD-HH:mm:ss, please NOTE this will only work when tif is GTD ")
    /**
     * format, YYYYMMDD-HH:mm:ss, please NOTE this will only work when tif is GTD
     **/
    @JsonProperty("expireTime")
    @SerializedName("expireTime")
    private String expireTime = null;

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
    @JsonProperty("iTWSOrdersOnly")
    @SerializedName("iTWSOrdersOnly")
    private Integer iTWSOrdersOnly = null;

    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to allow to show alert in pop-ups")
    /**
     * value can only be 0 or 1, set to 1 to allow to show alert in pop-ups
     **/
    @JsonProperty("showPopup")
    @SerializedName("showPopup")
    private Integer showPopup = null;

    @ApiModelProperty(value = "for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert ")
    /**
     * for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert
     **/
    @JsonProperty("toolId")
    @SerializedName("toolId")
    private Integer toolId = null;

    @ApiModelProperty(value = "audio message to play when alert is triggered")
    /**
     * audio message to play when alert is triggered
     **/
    @JsonProperty("playAudio")
    @SerializedName("playAudio")
    private String playAudio = null;

    @ApiModelProperty(value = "")
    @JsonProperty("conditions")
    @Valid
    @SerializedName("conditions")
    private List<Object> conditions = null;

    /**
     * The message you want to receive via email or text message
     *
     * @return alertMessage
     **/
    @JsonProperty("alertMessage")
    @ApiModelProperty(value = "The message you want to receive via email or text message")
    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    /**
     * name of alert
     *
     * @return alertName
     **/
    @JsonProperty("alertName")
    @ApiModelProperty(value = "name of alert")
    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    /**
     * whether alert is repeatable or not, so value can only be 0 or 1, this has to be 1 for MTA alert
     *
     * @return alertRepeatable
     **/
    @JsonProperty("alertRepeatable")
    @ApiModelProperty(value = "whether alert is repeatable or not, so value can only be 0 or 1, this has to be 1 for MTA alert")
    public Integer getAlertRepeatable() {
        return alertRepeatable;
    }

    public void setAlertRepeatable(Integer alertRepeatable) {
        this.alertRepeatable = alertRepeatable;
    }

    /**
     * Get conditions
     *
     * @return conditions
     **/
    @JsonProperty("conditions")
    public List<Object> getConditions() {
        return conditions;
    }

    public void setConditions(List<Object> conditions) {
        this.conditions = conditions;
    }

    /**
     * email address to receive alert
     *
     * @return email
     **/
    @JsonProperty("email")
    @ApiModelProperty(value = "email address to receive alert")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * format, YYYYMMDD-HH:mm:ss, please NOTE this will only work when tif is GTD
     *
     * @return expireTime
     **/
    @JsonProperty("expireTime")
    @ApiModelProperty(example = "20201105-19:51:14",
            value = "format, YYYYMMDD-HH:mm:ss, please NOTE this will only work when tif is GTD ")
    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile
     *
     * @return iTWSOrdersOnly
     **/
    @JsonProperty("iTWSOrdersOnly")
    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile ")
    public Integer getITWSOrdersOnly() {
        return iTWSOrdersOnly;
    }

    public void setITWSOrdersOnly(Integer iTWSOrdersOnly) {
        this.iTWSOrdersOnly = iTWSOrdersOnly;
    }

    /**
     * orderId is required when modifying alert. You can get it from /iserver/account/:accountId/alerts
     *
     * @return orderId
     **/
    @ApiModelProperty(value = "orderId is required when modifying alert. You can get it from /iserver/account/:accountId/alerts ")
    @JsonProperty("orderId")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
     * audio message to play when alert is triggered
     *
     * @return playAudio
     **/
    @JsonProperty("playAudio")
    @ApiModelProperty(value = "audio message to play when alert is triggered")
    public String getPlayAudio() {
        return playAudio;
    }

    public void setPlayAudio(String playAudio) {
        this.playAudio = playAudio;
    }

    /**
     * whether allowing to send email or not, so value can only be 0 or 1,
     *
     * @return sendMessage
     **/
    @JsonProperty("sendMessage")
    @ApiModelProperty(value = "whether allowing to send email or not, so value can only be 0 or 1, ")
    public Integer getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(Integer sendMessage) {
        this.sendMessage = sendMessage;
    }

    /**
     * value can only be 0 or 1, set to 1 to allow to show alert in pop-ups
     *
     * @return showPopup
     **/
    @JsonProperty("showPopup")
    @ApiModelProperty(value = "value can only be 0 or 1, set to 1 to allow to show alert in pop-ups")
    public Integer getShowPopup() {
        return showPopup;
    }

    public void setShowPopup(Integer showPopup) {
        this.showPopup = showPopup;
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
     * for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert
     *
     * @return toolId
     **/
    @JsonProperty("toolId")
    @ApiModelProperty(value = "for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert ")
    public Integer getToolId() {
        return toolId;
    }

    public void setToolId(Integer toolId) {
        this.toolId = toolId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, alertName, alertMessage, alertRepeatable, email, sendMessage, tif, expireTime,
                outsideRth, iTWSOrdersOnly, showPopup, toolId, playAudio, conditions);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlertRequest alertRequest = (AlertRequest) o;
        return Objects.equals(orderId, alertRequest.orderId) && Objects.equals(alertName, alertRequest.alertName)
                && Objects.equals(alertMessage, alertRequest.alertMessage) && Objects.equals(alertRepeatable,
                alertRequest.alertRepeatable) && Objects.equals(email, alertRequest.email) && Objects.equals(
                sendMessage, alertRequest.sendMessage) && Objects.equals(tif, alertRequest.tif) && Objects.equals(
                expireTime, alertRequest.expireTime) && Objects.equals(outsideRth, alertRequest.outsideRth)
                && Objects.equals(iTWSOrdersOnly, alertRequest.iTWSOrdersOnly) && Objects.equals(showPopup,
                alertRequest.showPopup) && Objects.equals(toolId, alertRequest.toolId) && Objects.equals(playAudio,
                alertRequest.playAudio) && Objects.equals(conditions, alertRequest.conditions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlertRequest {\n");

        sb.append("    orderId: ")
                .append(toIndentedString(orderId))
                .append("\n");
        sb.append("    alertName: ")
                .append(toIndentedString(alertName))
                .append("\n");
        sb.append("    alertMessage: ")
                .append(toIndentedString(alertMessage))
                .append("\n");
        sb.append("    alertRepeatable: ")
                .append(toIndentedString(alertRepeatable))
                .append("\n");
        sb.append("    email: ")
                .append(toIndentedString(email))
                .append("\n");
        sb.append("    sendMessage: ")
                .append(toIndentedString(sendMessage))
                .append("\n");
        sb.append("    tif: ")
                .append(toIndentedString(tif))
                .append("\n");
        sb.append("    expireTime: ")
                .append(toIndentedString(expireTime))
                .append("\n");
        sb.append("    outsideRth: ")
                .append(toIndentedString(outsideRth))
                .append("\n");
        sb.append("    iTWSOrdersOnly: ")
                .append(toIndentedString(iTWSOrdersOnly))
                .append("\n");
        sb.append("    showPopup: ")
                .append(toIndentedString(showPopup))
                .append("\n");
        sb.append("    toolId: ")
                .append(toIndentedString(toolId))
                .append("\n");
        sb.append("    playAudio: ")
                .append(toIndentedString(playAudio))
                .append("\n");
        sb.append("    conditions: ")
                .append(toIndentedString(conditions))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public AlertRequest addConditionsItem(Object conditionsItem) {
        if (this.conditions == null) {
            this.conditions = new ArrayList<Object>();
        }
        this.conditions.add(conditionsItem);
        return this;
    }

    public AlertRequest alertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
        return this;
    }

    public AlertRequest alertName(String alertName) {
        this.alertName = alertName;
        return this;
    }

    public AlertRequest alertRepeatable(Integer alertRepeatable) {
        this.alertRepeatable = alertRepeatable;
        return this;
    }

    public AlertRequest conditions(List<Object> conditions) {
        this.conditions = conditions;
        return this;
    }

    public AlertRequest email(String email) {
        this.email = email;
        return this;
    }

    public AlertRequest expireTime(String expireTime) {
        this.expireTime = expireTime;
        return this;
    }

    public AlertRequest iTWSOrdersOnly(Integer iTWSOrdersOnly) {
        this.iTWSOrdersOnly = iTWSOrdersOnly;
        return this;
    }

    public AlertRequest orderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public AlertRequest outsideRth(Integer outsideRth) {
        this.outsideRth = outsideRth;
        return this;
    }

    public AlertRequest playAudio(String playAudio) {
        this.playAudio = playAudio;
        return this;
    }

    public AlertRequest sendMessage(Integer sendMessage) {
        this.sendMessage = sendMessage;
        return this;
    }

    public AlertRequest showPopup(Integer showPopup) {
        this.showPopup = showPopup;
        return this;
    }

    public AlertRequest tif(String tif) {
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

    public AlertRequest toolId(Integer toolId) {
        this.toolId = toolId;
        return this;
    }
}

