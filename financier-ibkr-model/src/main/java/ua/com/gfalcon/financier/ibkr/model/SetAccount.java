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


import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * SetAccount
 */
@Validated
public class SetAccount {

    @ApiModelProperty(value = "Account ID")
    /**
     * Account ID
     **/
    @JsonProperty("acctId")
    @SerializedName("acctId")
    private String acctId = null;

    /**
     * Account ID
     *
     * @return acctId
     **/
    @JsonProperty("acctId")
    @ApiModelProperty(value = "Account ID")
    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acctId);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SetAccount setAccount = (SetAccount) o;
        return Objects.equals(this.acctId, setAccount.acctId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SetAccount {\n");

        sb.append("    acctId: ")
                .append(toIndentedString(acctId))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public SetAccount acctId(String acctId) {
        this.acctId = acctId;
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

