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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * The current session for the SSO user.
 */
@Data
public class ValidateSso {

    /**
     * 1 for Live, 2 for Paper.
     */
    @ApiModelProperty(value = "1 for Live, 2 for Paper.")
    @JsonProperty("LOGIN_TYPE")
    @SerializedName("LOGIN_TYPE")
    private Integer loginType;

    /**
     * Username.
     */
    @ApiModelProperty(value = "Username.")
    @JsonProperty("USER_NAME")
    @SerializedName("USER_NAME")
    private String userName;

    /**
     * User ID.
     */
    @ApiModelProperty(value = "User ID.")
    @JsonProperty("USER_ID")
    @SerializedName("USER_ID")
    private Integer userId;

    /**
     * Time in milliseconds until session expires. Caller needs to call the again to re-validate session.
     */
    @ApiModelProperty(value = "Time in milliseconds until session expires. Caller needs to call the again to re-validate session.")
    @JsonProperty("expire")
    @SerializedName("expire")
    private BigDecimal expire;

    /**
     * true if session was validated; false if not.
     */
    @ApiModelProperty(value = "true if session was validated; false if not.")
    @JsonProperty("RESULT")
    @SerializedName("RESULT")
    private Boolean result;

    /**
     * Time of session validation.
     */
    @ApiModelProperty(value = "Time of session validation.")
    @JsonProperty("AUTH_TIME")
    @SerializedName("AUTH_TIME")
    private BigDecimal authTime;
}
