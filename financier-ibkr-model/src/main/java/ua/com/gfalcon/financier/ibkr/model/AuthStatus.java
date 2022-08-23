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
 * AuthStatus
 */
@Validated
public class AuthStatus {

    @ApiModelProperty(value = "Brokerage session is authenticated")
    /**
     * Brokerage session is authenticated
     **/
    @JsonProperty("authenticated")
    @SerializedName("authenticated")
    private Boolean authenticated = null;

    @ApiModelProperty(value = "Connected to backend")
    /**
     * Connected to backend
     **/
    @JsonProperty("connected")
    @SerializedName("connected")
    private Boolean connected = null;

    @ApiModelProperty(value = "Brokerage session is competing, e.g. user is logged in to IBKR Mobile, WebTrader, TWS or other trading platforms.")
    /**
     * Brokerage session is competing, e.g. user is logged in to IBKR Mobile, WebTrader, TWS or other trading platforms.
     **/
    @JsonProperty("competing")
    @SerializedName("competing")
    private Boolean competing = null;

    @ApiModelProperty(value = "Authentication failed, why.")
    /**
     * Authentication failed, why.
     **/
    @JsonProperty("fail")
    @SerializedName("fail")
    private String fail = null;

    @ApiModelProperty(value = "System messages that may affect trading")
    /**
     * System messages that may affect trading
     **/
    @JsonProperty("message")
    @SerializedName("message")
    private String message = null;

    @ApiModelProperty(value = "Prompt messages that may affect trading or the account")
    /**
     * Prompt messages that may affect trading or the account
     **/
    @JsonProperty("prompts")
    @Valid
    @SerializedName("prompts")
    private List<String> prompts = null;

    /**
     * Authentication failed, why.
     *
     * @return fail
     **/
    @ApiModelProperty(value = "Authentication failed, why.")
    @JsonProperty("fail")
    public String getFail() {
        return fail;
    }

    public void setFail(String fail) {
        this.fail = fail;
    }

    /**
     * System messages that may affect trading
     *
     * @return message
     **/
    @ApiModelProperty(value = "System messages that may affect trading")
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Prompt messages that may affect trading or the account
     *
     * @return prompts
     **/
    @ApiModelProperty(value = "Prompt messages that may affect trading or the account")
    @JsonProperty("prompts")
    public List<String> getPrompts() {
        return prompts;
    }

    public void setPrompts(List<String> prompts) {
        this.prompts = prompts;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setCompeting(Boolean competing) {
        this.competing = competing;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(authenticated, connected, competing, fail, message, prompts);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthStatus authStatus = (AuthStatus) o;
        return Objects.equals(authenticated, authStatus.authenticated) && Objects.equals(connected,
                authStatus.connected) && Objects.equals(competing, authStatus.competing) && Objects.equals(fail,
                authStatus.fail) && Objects.equals(message, authStatus.message) && Objects.equals(prompts,
                authStatus.prompts);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthStatus {\n");

        sb.append("    authenticated: ")
                .append(toIndentedString(authenticated))
                .append("\n");
        sb.append("    connected: ")
                .append(toIndentedString(connected))
                .append("\n");
        sb.append("    competing: ")
                .append(toIndentedString(competing))
                .append("\n");
        sb.append("    fail: ")
                .append(toIndentedString(fail))
                .append("\n");
        sb.append("    message: ")
                .append(toIndentedString(message))
                .append("\n");
        sb.append("    prompts: ")
                .append(toIndentedString(prompts))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public AuthStatus addPromptsItem(String promptsItem) {
        if (this.prompts == null) {
            this.prompts = new ArrayList<String>();
        }
        this.prompts.add(promptsItem);
        return this;
    }

    public AuthStatus authenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public AuthStatus competing(Boolean competing) {
        this.competing = competing;
        return this;
    }

    public AuthStatus connected(Boolean connected) {
        this.connected = connected;
        return this;
    }

    public AuthStatus fail(String fail) {
        this.fail = fail;
        return this;
    }

    /**
     * Brokerage session is authenticated
     *
     * @return authenticated
     **/
    @ApiModelProperty(value = "Brokerage session is authenticated")
    @JsonProperty("authenticated")
    public Boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * Brokerage session is competing, e.g. user is logged in to IBKR Mobile, WebTrader, TWS or other trading platforms.
     *
     * @return competing
     **/
    @ApiModelProperty(value = "Brokerage session is competing, e.g. user is logged in to IBKR Mobile, WebTrader, TWS or other trading platforms.")
    @JsonProperty("competing")
    public Boolean isCompeting() {
        return competing;
    }

    /**
     * Connected to backend
     *
     * @return connected
     **/
    @ApiModelProperty(value = "Connected to backend")
    @JsonProperty("connected")
    public Boolean isConnected() {
        return connected;
    }

    public AuthStatus message(String message) {
        this.message = message;
        return this;
    }

    public AuthStatus prompts(List<String> prompts) {
        this.prompts = prompts;
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

