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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * PnL for the selected account and its models (if any).
 */
@Validated
@ApiModel(description = "PnL for the selected account and its models (if any)")
public class AccountPnL {

    /**
     * Account and model(s) pnl.
     */
    @ApiModelProperty(value = "Account and model(s) pnl.")
    @JsonProperty("acctId")
    @SerializedName("acctId")
    private Object acctId;

    public Object getAcctId() {
        return acctId;
    }

    public void setAcctId(Object acctId) {
        this.acctId = acctId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountPnL)) {
            return false;
        }
        AccountPnL that = (AccountPnL) o;
        return Objects.equals(getAcctId(), that.getAcctId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcctId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountPnL{");
        sb.append("acctId=")
                .append(acctId);
        sb.append('}');
        return sb.toString();
    }
}
