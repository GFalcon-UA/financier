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

/**
 * Session Token Authentication.
 */
@ApiModel(description = "Session Token Authentication")
@Validated
public class Auth {

    @JsonProperty("response")
    @SerializedName("response")
    private String response = null;

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Auth response(String response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auth{");
        sb.append("response='")
                .append(response)
                .append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auth)) return false;
        Auth auth = (Auth) o;
        return Objects.equals(getResponse(), auth.getResponse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponse());
    }
}
