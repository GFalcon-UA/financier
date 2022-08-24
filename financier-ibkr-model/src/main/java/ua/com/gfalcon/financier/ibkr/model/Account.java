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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * account information
 */
@ApiModel(description = "account information")
@Validated
public class Account {

    /**
     * The account identification value
     */
    @ApiModelProperty(value = "The account identification value")
    @JsonProperty("id")
    @SerializedName("id")
    private String id = null;

    /**
     * The account number
     */
    @ApiModelProperty(example = "U12345678 for Individual Live Accounts, DU12345678 for Individual Paper Accounts",
            value = "The account number")
    @JsonProperty("accountId")
    @SerializedName("accountId")
    private String accountId = null;

    /**
     * The accountAlias
     */
    @ApiModelProperty(value = "The accountAlias")
    @JsonProperty("accountVan")
    @SerializedName("accountVan")
    private String accountVan = null;

    /**
     * Title of the account
     */
    @ApiModelProperty(value = "Title of the account")
    @JsonProperty("accountTitle")
    @SerializedName("accountTitle")
    private String accountTitle = null;
    /**
     * Whichever value is not null in this priority
     */
    @ApiModelProperty(value = "Whichever value is not null in this priority")
    @JsonProperty("displayName")
    @SerializedName("displayName")
    private DisplayNameEnum displayName = null;
    /**
     * User customizable account alias. Refer to [Configure Account
     * Alias](https://guides.interactivebrokers.com/cp/cp.htm#am/settings/accountalias.htm) for details.
     */
    @ApiModelProperty(value = "User customizable account alias. Refer to [Configure Account Alias](https://guides.interactivebrokers.com/cp/cp.htm#am/settings/accountalias.htm) for details.")
    @JsonProperty("accountAlias")
    @SerializedName("accountAlias")
    private String accountAlias = null;
    /**
     * When the account was opened in unix time.
     */
    @ApiModelProperty(value = "When the account was opened in unix time.")
    @JsonProperty("accountStatus")
    @SerializedName("accountStatus")
    private BigDecimal accountStatus = null;
    /**
     * Base currency of the account.
     */
    @ApiModelProperty(value = "Base currency of the account.")
    @JsonProperty("currency")
    @SerializedName("currency")
    private CurrencyEnum currency = null;
    /**
     * Account Type
     */
    @ApiModelProperty(value = "Account Type")
    @JsonProperty("type")
    @SerializedName("type")
    private TypeEnum type = null;
    /**
     * UNI - Deprecated property
     */
    @ApiModelProperty(value = "UNI - Deprecated property")
    @JsonProperty("tradingType")
    @SerializedName("tradingType")
    private String tradingType = null;
    /**
     * If an account is a sub-account to a Financial Advisor.
     */
    @ApiModelProperty(value = "If an account is a sub-account to a Financial Advisor.")
    @JsonProperty("faclient")
    @SerializedName("faclient")
    private Boolean faclient = null;
    /**
     * Status of the Account   * O = Open   * P or N = Pending   * A = Abandoned   * R = Rejected   * C = Closed
     */
    @ApiModelProperty(value = "Status of the Account   * O = Open   * P or N = Pending   * A = Abandoned   * R = Rejected   * C = Closed ")
    @JsonProperty("clearingStatus")
    @SerializedName("clearingStatus")
    private ClearingStatusEnum clearingStatus = null;
    /**
     * Is a Covestor Account
     */
    @ApiModelProperty(value = "Is a Covestor Account")
    @JsonProperty("covestor")
    @SerializedName("covestor")
    private Boolean covestor = null;

    @ApiModelProperty(value = "")
    @JsonProperty("parent")
    @SerializedName("parent")
    private ParentAccount parent = null;

    /**
     * Formatted \"accountId - accountAlias\"
     */
    @ApiModelProperty(value = "Formatted \"accountId - accountAlias\"")
    @JsonProperty("desc")
    @SerializedName("desc")
    private String desc = null;

    /**
     * User customizable account alias. Refer to [Configure Account
     * Alias](https://guides.interactivebrokers.com/cp/cp.htm#am/settings/accountalias.htm) for details.
     *
     * @return accountAlias
     */
    @ApiModelProperty(value = "User customizable account alias. Refer to [Configure Account Alias](https://guides.interactivebrokers.com/cp/cp.htm#am/settings/accountalias.htm) for details.")
    @JsonProperty("accountAlias")
    public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    /**
     * The account number
     *
     * @return accountId
     */
    @ApiModelProperty(example = "U12345678 for Individual Live Accounts, DU12345678 for Individual Paper Accounts",
            value = "The account number")
    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * When the account was opened in unix time.
     *
     * @return accountStatus
     */
    @ApiModelProperty(value = "When the account was opened in unix time.")
    @JsonProperty("accountStatus")
    @Valid
    public BigDecimal getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(BigDecimal accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * Title of the account
     *
     * @return accountTitle
     */
    @ApiModelProperty(value = "Title of the account")
    @JsonProperty("accountTitle")
    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    /**
     * The accountAlias
     *
     * @return accountVan
     */
    @ApiModelProperty(value = "The accountAlias")
    @JsonProperty("accountVan")
    public String getAccountVan() {
        return accountVan;
    }

    public void setAccountVan(String accountVan) {
        this.accountVan = accountVan;
    }

    /**
     * Status of the Account   * O = Open   * P or N = Pending   * A = Abandoned   * R = Rejected   * C = Closed
     *
     * @return clearingStatus
     */
    @ApiModelProperty(value = "Status of the Account   * O = Open   * P or N = Pending   * A = Abandoned   * R = Rejected   * C = Closed ")
    @JsonProperty("clearingStatus")
    public ClearingStatusEnum getClearingStatus() {
        return clearingStatus;
    }

    public void setClearingStatus(ClearingStatusEnum clearingStatus) {
        this.clearingStatus = clearingStatus;
    }

    public String getClearingStatusStr() {
        if (clearingStatus == null) {
            return null;
        }
        return clearingStatus.value();
    }

    /**
     * Base currency of the account.
     *
     * @return currency
     */
    @ApiModelProperty(value = "Base currency of the account.")
    @JsonProperty("currency")
    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public String getCurrencyStr() {
        if (currency == null) {
            return null;
        }
        return currency.value();
    }

    /**
     * Formatted \"accountId - accountAlias\"
     *
     * @return desc
     */
    @ApiModelProperty(value = "Formatted \"accountId - accountAlias\"")
    @JsonProperty("desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Whichever value is not null in this priority
     *
     * @return displayName
     */
    @ApiModelProperty(value = "Whichever value is not null in this priority")
    @JsonProperty("displayName")
    public DisplayNameEnum getDisplayName() {
        return displayName;
    }

    public void setDisplayName(DisplayNameEnum displayName) {
        this.displayName = displayName;
    }

    public String getDisplayNameStr() {
        if (displayName == null) {
            return null;
        }
        return displayName.value();
    }

    /**
     * The account identification value
     *
     * @return id
     */
    @ApiModelProperty(value = "The account identification value")
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get parent
     *
     * @return parent
     */
    @JsonProperty("parent")
    public ParentAccount getParent() {
        return parent;
    }

    public void setParent(ParentAccount parent) {
        this.parent = parent;
    }

    /**
     * UNI - Deprecated property
     *
     * @return tradingType
     */
    @ApiModelProperty(value = "UNI - Deprecated property")
    @JsonProperty("tradingType")
    public String getTradingType() {
        return tradingType;
    }

    public void setTradingType(String tradingType) {
        this.tradingType = tradingType;
    }

    /**
     * Account Type
     *
     * @return type
     */
    @ApiModelProperty(value = "Account Type")
    @JsonProperty("type")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getTypeStr() {
        if (type == null) {
            return null;
        }
        return type.value();
    }

    public void setCovestor(Boolean covestor) {
        this.covestor = covestor;
    }

    public void setFaclient(Boolean faclient) {
        this.faclient = faclient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, accountVan, accountTitle, displayName, accountAlias, accountStatus, currency,
                type, tradingType, faclient, clearingStatus, covestor, parent, desc);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.id, account.id) && Objects.equals(this.accountId, account.accountId)
                && Objects.equals(this.accountVan, account.accountVan) && Objects.equals(this.accountTitle,
                account.accountTitle) && Objects.equals(this.displayName, account.displayName) && Objects.equals(
                this.accountAlias, account.accountAlias) && Objects.equals(this.accountStatus, account.accountStatus)
                && Objects.equals(this.currency, account.currency) && Objects.equals(this.type, account.type)
                && Objects.equals(this.tradingType, account.tradingType) && Objects.equals(this.faclient,
                account.faclient) && Objects.equals(this.clearingStatus, account.clearingStatus) && Objects.equals(
                this.covestor, account.covestor) && Objects.equals(this.parent, account.parent) && Objects.equals(
                this.desc, account.desc);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    id: ")
                .append(toIndentedString(id))
                .append("\n");
        sb.append("    accountId: ")
                .append(toIndentedString(accountId))
                .append("\n");
        sb.append("    accountVan: ")
                .append(toIndentedString(accountVan))
                .append("\n");
        sb.append("    accountTitle: ")
                .append(toIndentedString(accountTitle))
                .append("\n");
        sb.append("    displayName: ")
                .append(toIndentedString(displayName))
                .append("\n");
        sb.append("    accountAlias: ")
                .append(toIndentedString(accountAlias))
                .append("\n");
        sb.append("    accountStatus: ")
                .append(toIndentedString(accountStatus))
                .append("\n");
        sb.append("    currency: ")
                .append(toIndentedString(currency))
                .append("\n");
        sb.append("    type: ")
                .append(toIndentedString(type))
                .append("\n");
        sb.append("    tradingType: ")
                .append(toIndentedString(tradingType))
                .append("\n");
        sb.append("    faclient: ")
                .append(toIndentedString(faclient))
                .append("\n");
        sb.append("    clearingStatus: ")
                .append(toIndentedString(clearingStatus))
                .append("\n");
        sb.append("    covestor: ")
                .append(toIndentedString(covestor))
                .append("\n");
        sb.append("    parent: ")
                .append(toIndentedString(parent))
                .append("\n");
        sb.append("    desc: ")
                .append(toIndentedString(desc))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Account accountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
        return this;
    }

    public Account accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public Account accountStatus(BigDecimal accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    public Account accountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
        return this;
    }

    public Account accountVan(String accountVan) {
        this.accountVan = accountVan;
        return this;
    }

    public Account clearingStatus(ClearingStatusEnum clearingStatus) {
        this.clearingStatus = clearingStatus;
        return this;
    }

    public Account covestor(Boolean covestor) {
        this.covestor = covestor;
        return this;
    }

    public Account currency(CurrencyEnum currency) {
        this.currency = currency;
        return this;
    }

    public Account desc(String desc) {
        this.desc = desc;
        return this;
    }

    public Account displayName(DisplayNameEnum displayName) {
        this.displayName = displayName;
        return this;
    }

    public Account faclient(Boolean faclient) {
        this.faclient = faclient;
        return this;
    }

    public Account id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Is a Covestor Account
     *
     * @return covestor
     */
    @ApiModelProperty(value = "Is a Covestor Account")
    @JsonProperty("covestor")
    public Boolean isCovestor() {
        return covestor;
    }

    /**
     * If an account is a sub-account to a Financial Advisor.
     *
     * @return faclient
     */
    @ApiModelProperty(value = "If an account is a sub-account to a Financial Advisor.")
    @JsonProperty("faclient")
    public Boolean isFaclient() {
        return faclient;
    }

    public Account parent(ParentAccount parent) {
        this.parent = parent;
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

    public Account tradingType(String tradingType) {
        this.tradingType = tradingType;
        return this;
    }

    public Account type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Whichever value is not null in this priority
     */
    @XmlType(name = "DisplayNameEnum")
    @XmlEnum(String.class)
    @JsonAdapter(DisplayNameEnum.Adapter.class)
    public enum DisplayNameEnum {

        @XmlEnumValue("accountTitle") ACCOUNTTITLE(String.valueOf("accountTitle")),

        @XmlEnumValue("accountVan") ACCOUNTVAN(String.valueOf("accountVan")),

        @XmlEnumValue("accountId") ACCOUNTID(String.valueOf("accountId"));


        private String value;

        DisplayNameEnum(String value) {
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
        public static DisplayNameEnum fromValue(String text) {
            for (DisplayNameEnum b : DisplayNameEnum.values()) {
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

        public static class Adapter extends TypeAdapter<DisplayNameEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final DisplayNameEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public DisplayNameEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return DisplayNameEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Base currency of the account.
     */
    @XmlType(name = "CurrencyEnum")
    @XmlEnum(String.class)
    @JsonAdapter(CurrencyEnum.Adapter.class)
    public enum CurrencyEnum {

        @XmlEnumValue("AUD") AUD(String.valueOf("AUD")),

        @XmlEnumValue("GBP") GBP(String.valueOf("GBP")),

        @XmlEnumValue("CAD") CAD(String.valueOf("CAD")),

        @XmlEnumValue("CNH") CNH(String.valueOf("CNH")),

        @XmlEnumValue("CZK") CZK(String.valueOf("CZK")),

        @XmlEnumValue("DKK") DKK(String.valueOf("DKK")),

        @XmlEnumValue("EUR") EUR(String.valueOf("EUR")),

        @XmlEnumValue("HKD") HKD(String.valueOf("HKD")),

        @XmlEnumValue("HUF") HUF(String.valueOf("HUF")),

        @XmlEnumValue("INR") INR(String.valueOf("INR")),

        @XmlEnumValue("ILS") ILS(String.valueOf("ILS")),

        @XmlEnumValue("JPY") JPY(String.valueOf("JPY")),

        @XmlEnumValue("MXN") MXN(String.valueOf("MXN")),

        @XmlEnumValue("NOK") NOK(String.valueOf("NOK")),

        @XmlEnumValue("NZD") NZD(String.valueOf("NZD")),

        @XmlEnumValue("PLN") PLN(String.valueOf("PLN")),

        @XmlEnumValue("RUB") RUB(String.valueOf("RUB")),

        @XmlEnumValue("SGD") SGD(String.valueOf("SGD")),

        @XmlEnumValue("SEK") SEK(String.valueOf("SEK")),

        @XmlEnumValue("CHF") CHF(String.valueOf("CHF")),

        @XmlEnumValue("USD") USD(String.valueOf("USD"));


        private String value;

        CurrencyEnum(String value) {
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
        public static CurrencyEnum fromValue(String text) {
            for (CurrencyEnum b : CurrencyEnum.values()) {
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

        public static class Adapter extends TypeAdapter<CurrencyEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final CurrencyEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public CurrencyEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return CurrencyEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Account Type
     */
    @XmlType(name = "TypeEnum")
    @XmlEnum(String.class)
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {

        @XmlEnumValue("INDIVIDUAL") INDIVIDUAL(String.valueOf("INDIVIDUAL")),

        @XmlEnumValue("JOINT") JOINT(String.valueOf("JOINT")),

        @XmlEnumValue("ORG") ORG(String.valueOf("ORG")),

        @XmlEnumValue("TRUST") TRUST(String.valueOf("TRUST")),

        @XmlEnumValue("DEMO") DEMO(String.valueOf("DEMO"));


        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String text) {
            for (TypeEnum b : TypeEnum.values()) {
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

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * Status of the Account   * O = Open   * P or N = Pending   * A = Abandoned   * R = Rejected   * C = Closed
     */
    @XmlType(name = "ClearingStatusEnum")
    @XmlEnum(String.class)
    @JsonAdapter(ClearingStatusEnum.Adapter.class)
    public enum ClearingStatusEnum {

        @XmlEnumValue("O") O(String.valueOf("O")),

        @XmlEnumValue("P") P(String.valueOf("P")),

        @XmlEnumValue("N") N(String.valueOf("N")),

        @XmlEnumValue("A") A(String.valueOf("A")),

        @XmlEnumValue("R") R(String.valueOf("R")),

        @XmlEnumValue("C") C(String.valueOf("C"));


        private String value;

        ClearingStatusEnum(String value) {
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
        public static ClearingStatusEnum fromValue(String text) {
            for (ClearingStatusEnum b : ClearingStatusEnum.values()) {
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

        public static class Adapter extends TypeAdapter<ClearingStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ClearingStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ClearingStatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ClearingStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }
}

