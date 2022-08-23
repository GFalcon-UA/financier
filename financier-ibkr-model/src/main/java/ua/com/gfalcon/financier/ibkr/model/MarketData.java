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
 * MarketData
 */
@Validated
public class MarketData {

    @ApiModelProperty(value = "Last Price - The last price at which the contract traded. May contain one of the following prefixes:   * C - Previous day's closing price.   * H - Trading has halted. ")
    /**
     * Last Price - The last price at which the contract traded. May contain one of the following prefixes:   * C - Previous day's closing price.   * H - Trading has halted.
     **/
    @JsonProperty("31")
    @SerializedName("31")
    private String _31 = null;

    @ApiModelProperty(value = "High - Current day high price")
    /**
     * High - Current day high price
     **/
    @JsonProperty("70")
    @SerializedName("70")
    private BigDecimal _70 = null;

    @ApiModelProperty(value = "Low - Current day low price")
    /**
     * Low - Current day low price
     **/
    @JsonProperty("71")
    @SerializedName("71")
    private BigDecimal _71 = null;

    @ApiModelProperty(value = "Change - The difference between the last price and the close on the previous trading day")
    /**
     * Change - The difference between the last price and the close on the previous trading day
     **/
    @JsonProperty("82")
    @SerializedName("82")
    private String _82 = null;

    @ApiModelProperty(value = "Change % - The difference between the last price and the close on the previous trading day in percentage.")
    /**
     * Change % - The difference between the last price and the close on the previous trading day in percentage.
     **/
    @JsonProperty("83")
    @SerializedName("83")
    private BigDecimal _83 = null;

    @ApiModelProperty(value = "Bid Price - The highest-priced bid on the contract.")
    /**
     * Bid Price - The highest-priced bid on the contract.
     **/
    @JsonProperty("84")
    @SerializedName("84")
    private String _84 = null;

    @ApiModelProperty(value = "Ask Size - The number of contracts or shares offered at the ask price. For US stocks, the number displayed is divided by 100.")
    /**
     * Ask Size - The number of contracts or shares offered at the ask price. For US stocks, the number displayed is divided by 100.
     **/
    @JsonProperty("85")
    @SerializedName("85")
    private String _85 = null;

    @ApiModelProperty(value = "Ask Price - The lowest-priced offer on the contract.")
    /**
     * Ask Price - The lowest-priced offer on the contract.
     **/
    @JsonProperty("86")
    @SerializedName("86")
    private String _86 = null;

    @ApiModelProperty(value = "Volume - Volume for the day, formatted with 'K' for thousands or 'M' for millions. For higher precision volume refer to field 7762.")
    /**
     * Volume - Volume for the day, formatted with 'K' for thousands or 'M' for millions. For higher precision volume refer to field 7762.
     **/
    @JsonProperty("87")
    @SerializedName("87")
    private String _87 = null;

    @ApiModelProperty(value = "Bid Size - The number of contracts or shares bid for at the bid price. For US stocks, the number displayed is divided by 100.")
    /**
     * Bid Size - The number of contracts or shares bid for at the bid price. For US stocks, the number displayed is divided by 100.
     **/
    @JsonProperty("88")
    @SerializedName("88")
    private String _88 = null;

    @ApiModelProperty(value = "Market Data Availability. The field may contain three chars. First char defines: R = RealTime, D = Delayed, Z = Frozen, Y = Frozen Delayed, N = Not Subscribed. Second char defines: P = Snapshot, p = Consolidated. Third char defines: B = Book   * RealTime - Data is relayed back in real time without delay, market data subscription(s) are required.   * Delayed - Data is relayed back 15-20 min delayed.   * Frozen - Last recorded data at market close, relayed back in real time.   * Frozen Delayed - Last recorded data at market close, relayed back delayed.   * Not Subscribed - User does not have the required market data subscription(s) to relay back either real time or delayed data.   * Snapshot - Snapshot request is available for contract.   * Consolidated - Market data is aggregated across multiple exchanges or venues.   * Book - Top of the book data is available for contract. ")
    /**
     * Market Data Availability. The field may contain three chars. First char defines: R = RealTime, D = Delayed, Z = Frozen, Y = Frozen Delayed, N = Not Subscribed. Second char defines: P = Snapshot, p = Consolidated. Third char defines: B = Book   * RealTime - Data is relayed back in real time without delay, market data subscription(s) are required.   * Delayed - Data is relayed back 15-20 min delayed.   * Frozen - Last recorded data at market close, relayed back in real time.   * Frozen Delayed - Last recorded data at market close, relayed back delayed.   * Not Subscribed - User does not have the required market data subscription(s) to relay back either real time or delayed data.   * Snapshot - Snapshot request is available for contract.   * Consolidated - Market data is aggregated across multiple exchanges or venues.   * Book - Top of the book data is available for contract.
     **/
    @JsonProperty("6509")
    @SerializedName("6509")
    private String _6509 = null;

    @ApiModelProperty(value = "Ask Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    /**
     * Ask Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     **/
    @JsonProperty("7057")
    @SerializedName("7057")
    private String _7057 = null;

    @ApiModelProperty(value = "Last Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    /**
     * Last Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     **/
    @JsonProperty("7058")
    @SerializedName("7058")
    private String _7058 = null;

    @ApiModelProperty(value = "Last Size - The number of unites traded at the last price")
    /**
     * Last Size - The number of unites traded at the last price
     **/
    @JsonProperty("7059")
    @SerializedName("7059")
    private BigDecimal _7059 = null;

    @ApiModelProperty(value = "Bid Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    /**
     * Bid Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     **/
    @JsonProperty("7068")
    @SerializedName("7068")
    private String _7068 = null;

    @ApiModelProperty(value = "IV Rank")
    /**
     * IV Rank
     **/
    @JsonProperty("7195")
    @SerializedName("7195")
    private String _7195 = null;

    @ApiModelProperty(value = "IV Rank")
    /**
     * IV Rank
     **/
    @JsonProperty("7196")
    @SerializedName("7196")
    private String _7196 = null;

    @ApiModelProperty(value = "IV Rank")
    /**
     * IV Rank
     **/
    @JsonProperty("7197")
    @SerializedName("7197")
    private String _7197 = null;

    @ApiModelProperty(value = "IV Percentile")
    /**
     * IV Percentile
     **/
    @JsonProperty("7198")
    @SerializedName("7198")
    private String _7198 = null;

    @ApiModelProperty(value = "IV Percentile")
    /**
     * IV Percentile
     **/
    @JsonProperty("7199")
    @SerializedName("7199")
    private String _7199 = null;

    @ApiModelProperty(value = "IV Percentile")
    /**
     * IV Percentile
     **/
    @JsonProperty("7200")
    @SerializedName("7200")
    private String _7200 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7201")
    @SerializedName("7201")
    private String _7201 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7202")
    @SerializedName("7202")
    private String _7202 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7203")
    @SerializedName("7203")
    private String _7203 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7204")
    @SerializedName("7204")
    private String _7204 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7205")
    @SerializedName("7205")
    private String _7205 = null;

    @ApiModelProperty(value = "IV High Low")
    /**
     * IV High Low
     **/
    @JsonProperty("7206")
    @SerializedName("7206")
    private String _7206 = null;

    @ApiModelProperty(value = "HV Rank")
    /**
     * HV Rank
     **/
    @JsonProperty("7207")
    @SerializedName("7207")
    private String _7207 = null;

    @ApiModelProperty(value = "HV Rank")
    /**
     * HV Rank
     **/
    @JsonProperty("7208")
    @SerializedName("7208")
    private String _7208 = null;

    @ApiModelProperty(value = "HV Rank")
    /**
     * HV Rank
     **/
    @JsonProperty("7209")
    @SerializedName("7209")
    private String _7209 = null;

    @ApiModelProperty(value = "HV Percentile")
    /**
     * HV Percentile
     **/
    @JsonProperty("7210")
    @SerializedName("7210")
    private String _7210 = null;

    @ApiModelProperty(value = "HV Percentile")
    /**
     * HV Percentile
     **/
    @JsonProperty("7211")
    @SerializedName("7211")
    private String _7211 = null;

    @ApiModelProperty(value = "HV Percentile")
    /**
     * HV Percentile
     **/
    @JsonProperty("7212")
    @SerializedName("7212")
    private String _7212 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7245")
    @SerializedName("7245")
    private String _7245 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7246")
    @SerializedName("7246")
    private String _7246 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7247")
    @SerializedName("7247")
    private String _7247 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7248")
    @SerializedName("7248")
    private String _7248 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7249")
    @SerializedName("7249")
    private String _7249 = null;

    @ApiModelProperty(value = "HV High Low")
    /**
     * HV High Low
     **/
    @JsonProperty("7263")
    @SerializedName("7263")
    private String _7263 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7264")
    @SerializedName("7264")
    private String _7264 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7265")
    @SerializedName("7265")
    private String _7265 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7266")
    @SerializedName("7266")
    private String _7266 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7267")
    @SerializedName("7267")
    private String _7267 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7268")
    @SerializedName("7268")
    private String _7268 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7269")
    @SerializedName("7269")
    private String _7269 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7271")
    @SerializedName("7271")
    private String _7271 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7272")
    @SerializedName("7272")
    private String _7272 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7273")
    @SerializedName("7273")
    private String _7273 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7274")
    @SerializedName("7274")
    private String _7274 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7275")
    @SerializedName("7275")
    private String _7275 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7276")
    @SerializedName("7276")
    private String _7276 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7277")
    @SerializedName("7277")
    private String _7277 = null;

    @ApiModelProperty(value = "Average Volume - The average daily trading volume over 90 days.")
    /**
     * Average Volume - The average daily trading volume over 90 days.
     **/
    @JsonProperty("7282")
    @SerializedName("7282")
    private String _7282 = null;

    @ApiModelProperty(value = "Option Implied Vol. % - A prediction of how volatile an underlying will be in the future. At the market volatility estimated for a maturity thirty calendar days forward of the current trading day, and based on option prices from two consecutive expiration months.      ")
    /**
     * Option Implied Vol. % - A prediction of how volatile an underlying will be in the future. At the market volatility estimated for a maturity thirty calendar days forward of the current trading day, and based on option prices from two consecutive expiration months.
     **/
    @JsonProperty("7283")
    @SerializedName("7283")
    private String _7283 = null;

    @ApiModelProperty(value = "Historic Volume (30d)")
    /**
     * Historic Volume (30d)
     **/
    @JsonProperty("7284")
    @SerializedName("7284")
    private String _7284 = null;

    @ApiModelProperty(value = "Dividend Amount - Displays the amount of the next dividend.")
    /**
     * Dividend Amount - Displays the amount of the next dividend.
     **/
    @JsonProperty("7286")
    @SerializedName("7286")
    private BigDecimal _7286 = null;

    @ApiModelProperty(value = "Dividend Yield % - This value is the toal of the expected dividend payments over the next twelve months per share divided by the Current Price and is expressed as a percentage. For derivatives, this displays the total of the expected dividend payments over the expiry date. ")
    /**
     * Dividend Yield % - This value is the toal of the expected dividend payments over the next twelve months per share divided by the Current Price and is expressed as a percentage. For derivatives, this displays the total of the expected dividend payments over the expiry date.
     **/
    @JsonProperty("7287")
    @SerializedName("7287")
    private String _7287 = null;

    @ApiModelProperty(value = "Ex-date of the dividend")
    /**
     * Ex-date of the dividend
     **/
    @JsonProperty("7288")
    @SerializedName("7288")
    private String _7288 = null;

    @ApiModelProperty(value = "Market Cap")
    /**
     * Market Cap
     **/
    @JsonProperty("7289")
    @SerializedName("7289")
    private String _7289 = null;

    @ApiModelProperty(value = "P/E")
    /**
     * P/E
     **/
    @JsonProperty("7290")
    @SerializedName("7290")
    private String _7290 = null;

    @ApiModelProperty(value = "52 Week High - The highest price for the past 52 weeks.")
    /**
     * 52 Week High - The highest price for the past 52 weeks.
     **/
    @JsonProperty("7293")
    @SerializedName("7293")
    private String _7293 = null;

    @ApiModelProperty(value = "52 Week Low - The lowest price for the past 52 weeks.")
    /**
     * 52 Week Low - The lowest price for the past 52 weeks.
     **/
    @JsonProperty("7294")
    @SerializedName("7294")
    private String _7294 = null;

    @ApiModelProperty(value = "Open - Today's opening price.")
    /**
     * Open - Today's opening price.
     **/
    @JsonProperty("7295")
    @SerializedName("7295")
    private BigDecimal _7295 = null;

    @ApiModelProperty(value = "Close - Today's closing price.")
    /**
     * Close - Today's closing price.
     **/
    @JsonProperty("7296")
    @SerializedName("7296")
    private BigDecimal _7296 = null;

    @ApiModelProperty(value = "Reuters Fundamentals")
    /**
     * Reuters Fundamentals
     **/
    @JsonProperty("7331")
    @SerializedName("7331")
    private String _7331 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7370")
    @SerializedName("7370")
    private String _7370 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7371")
    @SerializedName("7371")
    private String _7371 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7372")
    @SerializedName("7372")
    private String _7372 = null;

    @ApiModelProperty(value = "Mark - The mark price is, the ask price if ask is less than last price, the bid price if bid is more than the last price, otherwise it's equal to last price")
    /**
     * Mark - The mark price is, the ask price if ask is less than last price, the bid price if bid is more than the last price, otherwise it's equal to last price
     **/
    @JsonProperty("7635")
    @SerializedName("7635")
    private String _7635 = null;

    @ApiModelProperty(value = "shortable invetory")
    /**
     * shortable invetory
     **/
    @JsonProperty("7636")
    @SerializedName("7636")
    private BigDecimal _7636 = null;

    @ApiModelProperty(value = "Fee rebate rate")
    /**
     * Fee rebate rate
     **/
    @JsonProperty("7637")
    @SerializedName("7637")
    private String _7637 = null;

    @ApiModelProperty(value = "Shortable - Describes the level of difficulty with which the security can be sold short.")
    /**
     * Shortable - Describes the level of difficulty with which the security can be sold short.
     **/
    @JsonProperty("7644")
    @SerializedName("7644")
    private String _7644 = null;

    @ApiModelProperty(value = "EMA(200) - Exponential moving average (N=200).")
    /**
     * EMA(200) - Exponential moving average (N=200).
     **/
    @JsonProperty("7674")
    @SerializedName("7674")
    private String _7674 = null;

    @ApiModelProperty(value = "EMA(100) - Exponential moving average (N=100).")
    /**
     * EMA(100) - Exponential moving average (N=100).
     **/
    @JsonProperty("7675")
    @SerializedName("7675")
    private String _7675 = null;

    @ApiModelProperty(value = "EMA(50) - Exponential moving average (N=50).")
    /**
     * EMA(50) - Exponential moving average (N=50).
     **/
    @JsonProperty("7676")
    @SerializedName("7676")
    private String _7676 = null;

    @ApiModelProperty(value = "EMA(20) - Exponential moving average (N=20).")
    /**
     * EMA(20) - Exponential moving average (N=20).
     **/
    @JsonProperty("7677")
    @SerializedName("7677")
    private String _7677 = null;

    @ApiModelProperty(value = "Price/EMA(20) - Price to Exponential moving average (N=20) ratio -1, displayed in percents.")
    /**
     * Price/EMA(20) - Price to Exponential moving average (N=20) ratio -1, displayed in percents.
     **/
    @JsonProperty("7681")
    @SerializedName("7681")
    private String _7681 = null;

    @ApiModelProperty(value = "Last Yield - Implied yield of the bond if it is purchased at the current last price. Last yield is calculated using the Last price on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    /**
     * Last Yield - Implied yield of the bond if it is purchased at the current last price. Last yield is calculated using the Last price on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.
     **/
    @JsonProperty("7698")
    @SerializedName("7698")
    private String _7698 = null;

    @ApiModelProperty(value = "Bid Yield - Implied yield of the bond if it is purchased at the current bid price. Bid yield is calculated using the Ask on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    /**
     * Bid Yield - Implied yield of the bond if it is purchased at the current bid price. Bid yield is calculated using the Ask on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.
     **/
    @JsonProperty("7699")
    @SerializedName("7699")
    private String _7699 = null;

    @ApiModelProperty(value = "Beta - Beta is against standard index.")
    /**
     * Beta - Beta is against standard index.
     **/
    @JsonProperty("7718")
    @SerializedName("7718")
    private String _7718 = null;

    @ApiModelProperty(value = "Ask Yield - Implied yield of the bond if it is purchased at the current offer. Ask yield is calculated using the Bid on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    /**
     * Ask Yield - Implied yield of the bond if it is purchased at the current offer. Ask yield is calculated using the Bid on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.
     **/
    @JsonProperty("7720")
    @SerializedName("7720")
    private String _7720 = null;

    @ApiModelProperty(value = "Reuters Fundamentals")
    /**
     * Reuters Fundamentals
     **/
    @JsonProperty("7743")
    @SerializedName("7743")
    private String _7743 = null;

    @ApiModelProperty(value = "ESG")
    /**
     * ESG
     **/
    @JsonProperty("7761")
    @SerializedName("7761")
    private String _7761 = null;

    @ApiModelProperty(value = "26 Week High - The highest price for the past 26 weeks.")
    /**
     * 26 Week High - The highest price for the past 26 weeks.
     **/
    @JsonProperty("7992")
    @SerializedName("7992")
    private String _7992 = null;

    @ApiModelProperty(value = "26 Week Low - The lowest price for the past 26 weeks.")
    /**
     * 26 Week Low - The lowest price for the past 26 weeks.
     **/
    @JsonProperty("7993")
    @SerializedName("7993")
    private String _7993 = null;

    @ApiModelProperty(value = "13 Week High - The highest price for the past 13 weeks.")
    /**
     * 13 Week High - The highest price for the past 13 weeks.
     **/
    @JsonProperty("7994")
    @SerializedName("7994")
    private String _7994 = null;

    @ApiModelProperty(value = "13 Week Low - The lowest price for the past 13 weeks.")
    /**
     * 13 Week Low - The lowest price for the past 13 weeks.
     **/
    @JsonProperty("7995")
    @SerializedName("7995")
    private String _7995 = null;

    @ApiModelProperty(value = "IBKR Contract identifier")
    /**
     * IBKR Contract identifier
     **/
    @JsonProperty("conid")
    @SerializedName("conid")
    private Integer conid = null;

    @ApiModelProperty(value = "minimum price increment")
    /**
     * minimum price increment
     **/
    @JsonProperty("minTick")
    @SerializedName("minTick")
    private BigDecimal minTick = null;

    @ApiModelProperty(value = "Color for Best Bid/Offer Exchange in hex code")
    /**
     * Color for Best Bid/Offer Exchange in hex code
     **/
    @JsonProperty("BboExchange")
    @SerializedName("BboExchange")
    private String bboExchange = null;

    @ApiModelProperty(value = "If market data field values return delayed")
    /**
     * If market data field values return delayed
     **/
    @JsonProperty("HasDelayed")
    @SerializedName("HasDelayed")
    private Boolean hasDelayed = null;

    @ApiModelProperty(value = "minimum size increment")
    /**
     * minimum size increment
     **/
    @JsonProperty("sizeMinTick")
    @SerializedName("sizeMinTick")
    private Integer sizeMinTick = null;

    @ApiModelProperty(value = "")
    @JsonProperty("BestEligible")
    @SerializedName("BestEligible")
    private Integer bestEligible = null;

    @ApiModelProperty(value = "")
    @JsonProperty("BestBidExch")
    @SerializedName("BestBidExch")
    private Integer bestBidExch = null;

    @ApiModelProperty(value = "")
    @JsonProperty("BestAskExch")
    @SerializedName("BestAskExch")
    private Integer bestAskExch = null;

    @ApiModelProperty(value = "")
    @JsonProperty("PreOpenBid")
    @SerializedName("PreOpenBid")
    private Integer preOpenBid = null;

    @ApiModelProperty(value = "")
    @JsonProperty("LastAttribs")
    @SerializedName("LastAttribs")
    private Integer lastAttribs = null;

    @ApiModelProperty(value = "Base time stamp for last update in format YYYYMMDD")
    /**
     * Base time stamp for last update in format YYYYMMDD
     **/
    @JsonProperty("TimestampBase")
    @SerializedName("TimestampBase")
    private Integer timestampBase = null;

    @ApiModelProperty(value = "")
    @JsonProperty("TimestampDelta")
    @SerializedName("TimestampDelta")
    private Integer timestampDelta = null;

    @ApiModelProperty(value = "")
    @JsonProperty("LastExch")
    @SerializedName("LastExch")
    private Integer lastExch = null;

    @ApiModelProperty(value = "")
    @JsonProperty("CloseAttribs")
    @SerializedName("CloseAttribs")
    private Integer closeAttribs = null;

    /**
     * Last Price - The last price at which the contract traded. May contain one of the following prefixes:   * C -
     * Previous day's closing price.   * H - Trading has halted.
     *
     * @return _31
     **/
    @JsonProperty("31")
    @ApiModelProperty(value = "Last Price - The last price at which the contract traded. May contain one of the following prefixes:   * C - Previous day's closing price.   * H - Trading has halted. ")
    public String get31() {
        return _31;
    }

    public void set31(String _31) {
        this._31 = _31;
    }

    /**
     * Market Data Availability. The field may contain three chars. First char defines: R = RealTime, D = Delayed, Z =
     * Frozen, Y = Frozen Delayed, N = Not Subscribed. Second char defines: P = Snapshot, p = Consolidated. Third char
     * defines: B = Book   * RealTime - Data is relayed back in real time without delay, market data subscription(s) are
     * required.   * Delayed - Data is relayed back 15-20 min delayed.   * Frozen - Last recorded data at market close,
     * relayed back in real time.   * Frozen Delayed - Last recorded data at market close, relayed back delayed.   * Not
     * Subscribed - User does not have the required market data subscription(s) to relay back either real time or
     * delayed data.   * Snapshot - Snapshot request is available for contract.   * Consolidated - Market data is
     * aggregated across multiple exchanges or venues.   * Book - Top of the book data is available for contract.
     *
     * @return _6509
     **/
    @JsonProperty("6509")
    @ApiModelProperty(value = "Market Data Availability. The field may contain three chars. First char defines: R = RealTime, D = Delayed, Z = Frozen, Y = Frozen Delayed, N = Not Subscribed. Second char defines: P = Snapshot, p = Consolidated. Third char defines: B = Book   * RealTime - Data is relayed back in real time without delay, market data subscription(s) are required.   * Delayed - Data is relayed back 15-20 min delayed.   * Frozen - Last recorded data at market close, relayed back in real time.   * Frozen Delayed - Last recorded data at market close, relayed back delayed.   * Not Subscribed - User does not have the required market data subscription(s) to relay back either real time or delayed data.   * Snapshot - Snapshot request is available for contract.   * Consolidated - Market data is aggregated across multiple exchanges or venues.   * Book - Top of the book data is available for contract. ")
    public String get6509() {
        return _6509;
    }

    public void set6509(String _6509) {
        this._6509 = _6509;
    }

    /**
     * High - Current day high price
     *
     * @return _70
     **/
    @JsonProperty("70")
    @ApiModelProperty(value = "High - Current day high price")
    @Valid
    public BigDecimal get70() {
        return _70;
    }

    public void set70(BigDecimal _70) {
        this._70 = _70;
    }

    /**
     * Ask Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX,
     * Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     *
     * @return _7057
     **/
    @JsonProperty("7057")
    @ApiModelProperty(value = "Ask Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    public String get7057() {
        return _7057;
    }

    public void set7057(String _7057) {
        this._7057 = _7057;
    }

    /**
     * Last Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX,
     * Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     *
     * @return _7058
     **/
    @JsonProperty("7058")
    @ApiModelProperty(value = "Last Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    public String get7058() {
        return _7058;
    }

    public void set7058(String _7058) {
        this._7058 = _7058;
    }

    /**
     * Last Size - The number of unites traded at the last price
     *
     * @return _7059
     **/
    @JsonProperty("7059")
    @ApiModelProperty(value = "Last Size - The number of unites traded at the last price")
    @Valid
    public BigDecimal get7059() {
        return _7059;
    }

    public void set7059(BigDecimal _7059) {
        this._7059 = _7059;
    }

    /**
     * Bid Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX,
     * Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY
     *
     * @return _7068
     **/
    @JsonProperty("7068")
    @ApiModelProperty(value = "Bid Exch - Displays the exchange(s) offering the SMART price. A=AMEX, C=CBOE, I=ISE, X=PHLX, N=PSE, B=BOX, Q=NASDAQOM, Z=BATS, W=CBOE2, T=NASDAQBX, M=MIAX, H=GEMINI, E=EDGX, J=MERCURY")
    public String get7068() {
        return _7068;
    }

    public void set7068(String _7068) {
        this._7068 = _7068;
    }

    /**
     * Low - Current day low price
     *
     * @return _71
     **/
    @JsonProperty("71")
    @ApiModelProperty(value = "Low - Current day low price")
    @Valid
    public BigDecimal get71() {
        return _71;
    }

    public void set71(BigDecimal _71) {
        this._71 = _71;
    }

    /**
     * IV Rank
     *
     * @return _7195
     **/
    @JsonProperty("7195")
    @ApiModelProperty(value = "IV Rank")
    public String get7195() {
        return _7195;
    }

    public void set7195(String _7195) {
        this._7195 = _7195;
    }

    /**
     * IV Rank
     *
     * @return _7196
     **/
    @JsonProperty("7196")
    @ApiModelProperty(value = "IV Rank")
    public String get7196() {
        return _7196;
    }

    public void set7196(String _7196) {
        this._7196 = _7196;
    }

    /**
     * IV Rank
     *
     * @return _7197
     **/
    @JsonProperty("7197")
    @ApiModelProperty(value = "IV Rank")
    public String get7197() {
        return _7197;
    }

    public void set7197(String _7197) {
        this._7197 = _7197;
    }

    /**
     * IV Percentile
     *
     * @return _7198
     **/
    @JsonProperty("7198")
    @ApiModelProperty(value = "IV Percentile")
    public String get7198() {
        return _7198;
    }

    public void set7198(String _7198) {
        this._7198 = _7198;
    }

    /**
     * IV Percentile
     *
     * @return _7199
     **/
    @JsonProperty("7199")
    @ApiModelProperty(value = "IV Percentile")
    public String get7199() {
        return _7199;
    }

    public void set7199(String _7199) {
        this._7199 = _7199;
    }

    /**
     * IV Percentile
     *
     * @return _7200
     **/
    @JsonProperty("7200")
    @ApiModelProperty(value = "IV Percentile")
    public String get7200() {
        return _7200;
    }

    public void set7200(String _7200) {
        this._7200 = _7200;
    }

    /**
     * IV High Low
     *
     * @return _7201
     **/
    @JsonProperty("7201")
    @ApiModelProperty(value = "IV High Low")
    public String get7201() {
        return _7201;
    }

    public void set7201(String _7201) {
        this._7201 = _7201;
    }

    /**
     * IV High Low
     *
     * @return _7202
     **/
    @JsonProperty("7202")
    @ApiModelProperty(value = "IV High Low")
    public String get7202() {
        return _7202;
    }

    public void set7202(String _7202) {
        this._7202 = _7202;
    }

    /**
     * IV High Low
     *
     * @return _7203
     **/
    @JsonProperty("7203")
    @ApiModelProperty(value = "IV High Low")
    public String get7203() {
        return _7203;
    }

    public void set7203(String _7203) {
        this._7203 = _7203;
    }

    /**
     * IV High Low
     *
     * @return _7204
     **/
    @JsonProperty("7204")
    @ApiModelProperty(value = "IV High Low")
    public String get7204() {
        return _7204;
    }

    public void set7204(String _7204) {
        this._7204 = _7204;
    }

    /**
     * IV High Low
     *
     * @return _7205
     **/
    @JsonProperty("7205")
    @ApiModelProperty(value = "IV High Low")
    public String get7205() {
        return _7205;
    }

    public void set7205(String _7205) {
        this._7205 = _7205;
    }

    /**
     * IV High Low
     *
     * @return _7206
     **/
    @JsonProperty("7206")
    @ApiModelProperty(value = "IV High Low")
    public String get7206() {
        return _7206;
    }

    public void set7206(String _7206) {
        this._7206 = _7206;
    }

    /**
     * HV Rank
     *
     * @return _7207
     **/
    @JsonProperty("7207")
    @ApiModelProperty(value = "HV Rank")
    public String get7207() {
        return _7207;
    }

    public void set7207(String _7207) {
        this._7207 = _7207;
    }

    /**
     * HV Rank
     *
     * @return _7208
     **/
    @JsonProperty("7208")
    @ApiModelProperty(value = "HV Rank")
    public String get7208() {
        return _7208;
    }

    public void set7208(String _7208) {
        this._7208 = _7208;
    }

    /**
     * HV Rank
     *
     * @return _7209
     **/
    @JsonProperty("7209")
    @ApiModelProperty(value = "HV Rank")
    public String get7209() {
        return _7209;
    }

    public void set7209(String _7209) {
        this._7209 = _7209;
    }

    /**
     * HV Percentile
     *
     * @return _7210
     **/
    @JsonProperty("7210")
    @ApiModelProperty(value = "HV Percentile")
    public String get7210() {
        return _7210;
    }

    public void set7210(String _7210) {
        this._7210 = _7210;
    }

    /**
     * HV Percentile
     *
     * @return _7211
     **/
    @JsonProperty("7211")
    @ApiModelProperty(value = "HV Percentile")
    public String get7211() {
        return _7211;
    }

    public void set7211(String _7211) {
        this._7211 = _7211;
    }

    /**
     * HV Percentile
     *
     * @return _7212
     **/
    @JsonProperty("7212")
    @ApiModelProperty(value = "HV Percentile")
    public String get7212() {
        return _7212;
    }

    public void set7212(String _7212) {
        this._7212 = _7212;
    }

    /**
     * HV High Low
     *
     * @return _7245
     **/
    @JsonProperty("7245")
    @ApiModelProperty(value = "HV High Low")
    public String get7245() {
        return _7245;
    }

    public void set7245(String _7245) {
        this._7245 = _7245;
    }

    /**
     * HV High Low
     *
     * @return _7246
     **/
    @JsonProperty("7246")
    @ApiModelProperty(value = "HV High Low")
    public String get7246() {
        return _7246;
    }

    public void set7246(String _7246) {
        this._7246 = _7246;
    }

    /**
     * HV High Low
     *
     * @return _7247
     **/
    @JsonProperty("7247")
    @ApiModelProperty(value = "HV High Low")
    public String get7247() {
        return _7247;
    }

    public void set7247(String _7247) {
        this._7247 = _7247;
    }

    /**
     * HV High Low
     *
     * @return _7248
     **/
    @JsonProperty("7248")
    @ApiModelProperty(value = "HV High Low")
    public String get7248() {
        return _7248;
    }

    public void set7248(String _7248) {
        this._7248 = _7248;
    }

    /**
     * HV High Low
     *
     * @return _7249
     **/
    @JsonProperty("7249")
    @ApiModelProperty(value = "HV High Low")
    public String get7249() {
        return _7249;
    }

    public void set7249(String _7249) {
        this._7249 = _7249;
    }

    /**
     * HV High Low
     *
     * @return _7263
     **/
    @JsonProperty("7263")
    @ApiModelProperty(value = "HV High Low")
    public String get7263() {
        return _7263;
    }

    public void set7263(String _7263) {
        this._7263 = _7263;
    }

    /**
     * ESG
     *
     * @return _7264
     **/
    @JsonProperty("7264")
    @ApiModelProperty(value = "ESG")
    public String get7264() {
        return _7264;
    }

    public void set7264(String _7264) {
        this._7264 = _7264;
    }

    /**
     * ESG
     *
     * @return _7265
     **/
    @JsonProperty("7265")
    @ApiModelProperty(value = "ESG")
    public String get7265() {
        return _7265;
    }

    public void set7265(String _7265) {
        this._7265 = _7265;
    }

    /**
     * ESG
     *
     * @return _7266
     **/
    @JsonProperty("7266")
    @ApiModelProperty(value = "ESG")
    public String get7266() {
        return _7266;
    }

    public void set7266(String _7266) {
        this._7266 = _7266;
    }

    /**
     * ESG
     *
     * @return _7267
     **/
    @JsonProperty("7267")
    @ApiModelProperty(value = "ESG")
    public String get7267() {
        return _7267;
    }

    public void set7267(String _7267) {
        this._7267 = _7267;
    }

    /**
     * ESG
     *
     * @return _7268
     **/
    @JsonProperty("7268")
    @ApiModelProperty(value = "ESG")
    public String get7268() {
        return _7268;
    }

    public void set7268(String _7268) {
        this._7268 = _7268;
    }

    /**
     * ESG
     *
     * @return _7269
     **/
    @JsonProperty("7269")
    @ApiModelProperty(value = "ESG")
    public String get7269() {
        return _7269;
    }

    public void set7269(String _7269) {
        this._7269 = _7269;
    }

    /**
     * ESG
     *
     * @return _7271
     **/
    @JsonProperty("7271")
    @ApiModelProperty(value = "ESG")
    public String get7271() {
        return _7271;
    }

    public void set7271(String _7271) {
        this._7271 = _7271;
    }

    /**
     * ESG
     *
     * @return _7272
     **/
    @JsonProperty("7272")
    @ApiModelProperty(value = "ESG")
    public String get7272() {
        return _7272;
    }

    public void set7272(String _7272) {
        this._7272 = _7272;
    }

    /**
     * ESG
     *
     * @return _7273
     **/
    @JsonProperty("7273")
    @ApiModelProperty(value = "ESG")
    public String get7273() {
        return _7273;
    }

    public void set7273(String _7273) {
        this._7273 = _7273;
    }

    /**
     * ESG
     *
     * @return _7274
     **/
    @JsonProperty("7274")
    @ApiModelProperty(value = "ESG")
    public String get7274() {
        return _7274;
    }

    public void set7274(String _7274) {
        this._7274 = _7274;
    }

    /**
     * ESG
     *
     * @return _7275
     **/
    @JsonProperty("7275")
    @ApiModelProperty(value = "ESG")
    public String get7275() {
        return _7275;
    }

    public void set7275(String _7275) {
        this._7275 = _7275;
    }

    /**
     * ESG
     *
     * @return _7276
     **/
    @JsonProperty("7276")
    @ApiModelProperty(value = "ESG")
    public String get7276() {
        return _7276;
    }

    public void set7276(String _7276) {
        this._7276 = _7276;
    }

    /**
     * ESG
     *
     * @return _7277
     **/
    @JsonProperty("7277")
    @ApiModelProperty(value = "ESG")
    public String get7277() {
        return _7277;
    }

    public void set7277(String _7277) {
        this._7277 = _7277;
    }

    /**
     * Average Volume - The average daily trading volume over 90 days.
     *
     * @return _7282
     **/
    @JsonProperty("7282")
    @ApiModelProperty(value = "Average Volume - The average daily trading volume over 90 days.")
    public String get7282() {
        return _7282;
    }

    public void set7282(String _7282) {
        this._7282 = _7282;
    }

    /**
     * Option Implied Vol. % - A prediction of how volatile an underlying will be in the future. At the market
     * volatility estimated for a maturity thirty calendar days forward of the current trading day, and based on option
     * prices from two consecutive expiration months.
     *
     * @return _7283
     **/
    @JsonProperty("7283")
    @ApiModelProperty(value = "Option Implied Vol. % - A prediction of how volatile an underlying will be in the future. At the market volatility estimated for a maturity thirty calendar days forward of the current trading day, and based on option prices from two consecutive expiration months.      ")
    public String get7283() {
        return _7283;
    }

    public void set7283(String _7283) {
        this._7283 = _7283;
    }

    /**
     * Historic Volume (30d)
     *
     * @return _7284
     **/
    @JsonProperty("7284")
    @ApiModelProperty(value = "Historic Volume (30d)")
    public String get7284() {
        return _7284;
    }

    public void set7284(String _7284) {
        this._7284 = _7284;
    }

    /**
     * Dividend Amount - Displays the amount of the next dividend.
     *
     * @return _7286
     **/
    @JsonProperty("7286")
    @ApiModelProperty(value = "Dividend Amount - Displays the amount of the next dividend.")
    @Valid
    public BigDecimal get7286() {
        return _7286;
    }

    public void set7286(BigDecimal _7286) {
        this._7286 = _7286;
    }

    /**
     * Dividend Yield % - This value is the toal of the expected dividend payments over the next twelve months per share
     * divided by the Current Price and is expressed as a percentage. For derivatives, this displays the total of the
     * expected dividend payments over the expiry date.
     *
     * @return _7287
     **/
    @JsonProperty("7287")
    @ApiModelProperty(value = "Dividend Yield % - This value is the toal of the expected dividend payments over the next twelve months per share divided by the Current Price and is expressed as a percentage. For derivatives, this displays the total of the expected dividend payments over the expiry date. ")
    public String get7287() {
        return _7287;
    }

    public void set7287(String _7287) {
        this._7287 = _7287;
    }

    /**
     * Ex-date of the dividend
     *
     * @return _7288
     **/
    @JsonProperty("7288")
    @ApiModelProperty(value = "Ex-date of the dividend")
    public String get7288() {
        return _7288;
    }

    public void set7288(String _7288) {
        this._7288 = _7288;
    }

    /**
     * Market Cap
     *
     * @return _7289
     **/
    @JsonProperty("7289")
    @ApiModelProperty(value = "Market Cap")
    public String get7289() {
        return _7289;
    }

    public void set7289(String _7289) {
        this._7289 = _7289;
    }

    /**
     * P/E
     *
     * @return _7290
     **/
    @JsonProperty("7290")
    @ApiModelProperty(value = "P/E")
    public String get7290() {
        return _7290;
    }

    public void set7290(String _7290) {
        this._7290 = _7290;
    }

    /**
     * 52 Week High - The highest price for the past 52 weeks.
     *
     * @return _7293
     **/
    @JsonProperty("7293")
    @ApiModelProperty(value = "52 Week High - The highest price for the past 52 weeks.")
    public String get7293() {
        return _7293;
    }

    public void set7293(String _7293) {
        this._7293 = _7293;
    }

    /**
     * 52 Week Low - The lowest price for the past 52 weeks.
     *
     * @return _7294
     **/
    @JsonProperty("7294")
    @ApiModelProperty(value = "52 Week Low - The lowest price for the past 52 weeks.")
    public String get7294() {
        return _7294;
    }

    public void set7294(String _7294) {
        this._7294 = _7294;
    }

    /**
     * Open - Today's opening price.
     *
     * @return _7295
     **/
    @JsonProperty("7295")
    @ApiModelProperty(value = "Open - Today's opening price.")
    @Valid
    public BigDecimal get7295() {
        return _7295;
    }

    public void set7295(BigDecimal _7295) {
        this._7295 = _7295;
    }

    /**
     * Close - Today's closing price.
     *
     * @return _7296
     **/
    @JsonProperty("7296")
    @ApiModelProperty(value = "Close - Today's closing price.")
    @Valid
    public BigDecimal get7296() {
        return _7296;
    }

    public void set7296(BigDecimal _7296) {
        this._7296 = _7296;
    }

    /**
     * Reuters Fundamentals
     *
     * @return _7331
     **/
    @JsonProperty("7331")
    @ApiModelProperty(value = "Reuters Fundamentals")
    public String get7331() {
        return _7331;
    }

    public void set7331(String _7331) {
        this._7331 = _7331;
    }

    /**
     * ESG
     *
     * @return _7370
     **/
    @JsonProperty("7370")
    @ApiModelProperty(value = "ESG")
    public String get7370() {
        return _7370;
    }

    public void set7370(String _7370) {
        this._7370 = _7370;
    }

    /**
     * ESG
     *
     * @return _7371
     **/
    @JsonProperty("7371")
    @ApiModelProperty(value = "ESG")
    public String get7371() {
        return _7371;
    }

    public void set7371(String _7371) {
        this._7371 = _7371;
    }

    /**
     * ESG
     *
     * @return _7372
     **/
    @JsonProperty("7372")
    @ApiModelProperty(value = "ESG")
    public String get7372() {
        return _7372;
    }

    public void set7372(String _7372) {
        this._7372 = _7372;
    }

    /**
     * Mark - The mark price is, the ask price if ask is less than last price, the bid price if bid is more than the
     * last price, otherwise it's equal to last price
     *
     * @return _7635
     **/
    @JsonProperty("7635")
    @ApiModelProperty(value = "Mark - The mark price is, the ask price if ask is less than last price, the bid price if bid is more than the last price, otherwise it's equal to last price")
    public String get7635() {
        return _7635;
    }

    public void set7635(String _7635) {
        this._7635 = _7635;
    }

    /**
     * shortable invetory
     *
     * @return _7636
     **/
    @JsonProperty("7636")
    @ApiModelProperty(value = "shortable invetory")
    @Valid
    public BigDecimal get7636() {
        return _7636;
    }

    public void set7636(BigDecimal _7636) {
        this._7636 = _7636;
    }

    /**
     * Fee rebate rate
     *
     * @return _7637
     **/
    @JsonProperty("7637")
    @ApiModelProperty(value = "Fee rebate rate")
    public String get7637() {
        return _7637;
    }

    public void set7637(String _7637) {
        this._7637 = _7637;
    }

    /**
     * Shortable - Describes the level of difficulty with which the security can be sold short.
     *
     * @return _7644
     **/
    @JsonProperty("7644")
    @ApiModelProperty(value = "Shortable - Describes the level of difficulty with which the security can be sold short.")
    public String get7644() {
        return _7644;
    }

    public void set7644(String _7644) {
        this._7644 = _7644;
    }

    /**
     * EMA(200) - Exponential moving average (N=200).
     *
     * @return _7674
     **/
    @JsonProperty("7674")
    @ApiModelProperty(value = "EMA(200) - Exponential moving average (N=200).")
    public String get7674() {
        return _7674;
    }

    public void set7674(String _7674) {
        this._7674 = _7674;
    }

    /**
     * EMA(100) - Exponential moving average (N=100).
     *
     * @return _7675
     **/
    @JsonProperty("7675")
    @ApiModelProperty(value = "EMA(100) - Exponential moving average (N=100).")
    public String get7675() {
        return _7675;
    }

    public void set7675(String _7675) {
        this._7675 = _7675;
    }

    /**
     * EMA(50) - Exponential moving average (N=50).
     *
     * @return _7676
     **/
    @JsonProperty("7676")
    @ApiModelProperty(value = "EMA(50) - Exponential moving average (N=50).")
    public String get7676() {
        return _7676;
    }

    public void set7676(String _7676) {
        this._7676 = _7676;
    }

    /**
     * EMA(20) - Exponential moving average (N=20).
     *
     * @return _7677
     **/
    @JsonProperty("7677")
    @ApiModelProperty(value = "EMA(20) - Exponential moving average (N=20).")
    public String get7677() {
        return _7677;
    }

    public void set7677(String _7677) {
        this._7677 = _7677;
    }

    /**
     * Price/EMA(20) - Price to Exponential moving average (N=20) ratio -1, displayed in percents.
     *
     * @return _7681
     **/
    @JsonProperty("7681")
    @ApiModelProperty(value = "Price/EMA(20) - Price to Exponential moving average (N=20) ratio -1, displayed in percents.")
    public String get7681() {
        return _7681;
    }

    public void set7681(String _7681) {
        this._7681 = _7681;
    }

    /**
     * Last Yield - Implied yield of the bond if it is purchased at the current last price. Last yield is calculated
     * using the Last price on all possible call dates. It is assumed that prepayment occurs if the bond has call or put
     * provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be
     * the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may
     * be the same as yield to maturity but never higher.
     *
     * @return _7698
     **/
    @JsonProperty("7698")
    @ApiModelProperty(value = "Last Yield - Implied yield of the bond if it is purchased at the current last price. Last yield is calculated using the Last price on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    public String get7698() {
        return _7698;
    }

    public void set7698(String _7698) {
        this._7698 = _7698;
    }

    /**
     * Bid Yield - Implied yield of the bond if it is purchased at the current bid price. Bid yield is calculated using
     * the Ask on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions
     * and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest
     * of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same
     * as yield to maturity but never higher.
     *
     * @return _7699
     **/
    @JsonProperty("7699")
    @ApiModelProperty(value = "Bid Yield - Implied yield of the bond if it is purchased at the current bid price. Bid yield is calculated using the Ask on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    public String get7699() {
        return _7699;
    }

    public void set7699(String _7699) {
        this._7699 = _7699;
    }

    /**
     * Beta - Beta is against standard index.
     *
     * @return _7718
     **/
    @JsonProperty("7718")
    @ApiModelProperty(value = "Beta - Beta is against standard index.")
    public String get7718() {
        return _7718;
    }

    public void set7718(String _7718) {
        this._7718 = _7718;
    }

    /**
     * Ask Yield - Implied yield of the bond if it is purchased at the current offer. Ask yield is calculated using the
     * Bid on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and
     * the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of
     * the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as
     * yield to maturity but never higher.
     *
     * @return _7720
     **/
    @JsonProperty("7720")
    @ApiModelProperty(value = "Ask Yield - Implied yield of the bond if it is purchased at the current offer. Ask yield is calculated using the Bid on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher. ")
    public String get7720() {
        return _7720;
    }

    public void set7720(String _7720) {
        this._7720 = _7720;
    }

    /**
     * Reuters Fundamentals
     *
     * @return _7743
     **/
    @JsonProperty("7743")
    @ApiModelProperty(value = "Reuters Fundamentals")
    public String get7743() {
        return _7743;
    }

    public void set7743(String _7743) {
        this._7743 = _7743;
    }

    /**
     * ESG
     *
     * @return _7761
     **/
    @JsonProperty("7761")
    @ApiModelProperty(value = "ESG")
    public String get7761() {
        return _7761;
    }

    public void set7761(String _7761) {
        this._7761 = _7761;
    }

    /**
     * 26 Week High - The highest price for the past 26 weeks.
     *
     * @return _7992
     **/
    @JsonProperty("7992")
    @ApiModelProperty(value = "26 Week High - The highest price for the past 26 weeks.")
    public String get7992() {
        return _7992;
    }

    public void set7992(String _7992) {
        this._7992 = _7992;
    }

    /**
     * 26 Week Low - The lowest price for the past 26 weeks.
     *
     * @return _7993
     **/
    @JsonProperty("7993")
    @ApiModelProperty(value = "26 Week Low - The lowest price for the past 26 weeks.")
    public String get7993() {
        return _7993;
    }

    public void set7993(String _7993) {
        this._7993 = _7993;
    }

    /**
     * 13 Week High - The highest price for the past 13 weeks.
     *
     * @return _7994
     **/
    @JsonProperty("7994")
    @ApiModelProperty(value = "13 Week High - The highest price for the past 13 weeks.")
    public String get7994() {
        return _7994;
    }

    public void set7994(String _7994) {
        this._7994 = _7994;
    }

    /**
     * 13 Week Low - The lowest price for the past 13 weeks.
     *
     * @return _7995
     **/
    @JsonProperty("7995")
    @ApiModelProperty(value = "13 Week Low - The lowest price for the past 13 weeks.")
    public String get7995() {
        return _7995;
    }

    public void set7995(String _7995) {
        this._7995 = _7995;
    }

    /**
     * Change - The difference between the last price and the close on the previous trading day
     *
     * @return _82
     **/
    @JsonProperty("82")
    @ApiModelProperty(value = "Change - The difference between the last price and the close on the previous trading day")
    public String get82() {
        return _82;
    }

    public void set82(String _82) {
        this._82 = _82;
    }

    /**
     * Change % - The difference between the last price and the close on the previous trading day in percentage.
     *
     * @return _83
     **/
    @JsonProperty("83")
    @ApiModelProperty(value = "Change % - The difference between the last price and the close on the previous trading day in percentage.")
    @Valid
    public BigDecimal get83() {
        return _83;
    }

    public void set83(BigDecimal _83) {
        this._83 = _83;
    }

    /**
     * Bid Price - The highest-priced bid on the contract.
     *
     * @return _84
     **/
    @JsonProperty("84")
    @ApiModelProperty(value = "Bid Price - The highest-priced bid on the contract.")
    public String get84() {
        return _84;
    }

    public void set84(String _84) {
        this._84 = _84;
    }

    /**
     * Ask Size - The number of contracts or shares offered at the ask price. For US stocks, the number displayed is
     * divided by 100.
     *
     * @return _85
     **/
    @JsonProperty("85")
    @ApiModelProperty(value = "Ask Size - The number of contracts or shares offered at the ask price. For US stocks, the number displayed is divided by 100.")
    public String get85() {
        return _85;
    }

    public void set85(String _85) {
        this._85 = _85;
    }

    /**
     * Ask Price - The lowest-priced offer on the contract.
     *
     * @return _86
     **/
    @JsonProperty("86")
    @ApiModelProperty(value = "Ask Price - The lowest-priced offer on the contract.")
    public String get86() {
        return _86;
    }

    public void set86(String _86) {
        this._86 = _86;
    }

    /**
     * Volume - Volume for the day, formatted with 'K' for thousands or 'M' for millions. For higher precision volume
     * refer to field 7762.
     *
     * @return _87
     **/
    @JsonProperty("87")
    @ApiModelProperty(value = "Volume - Volume for the day, formatted with 'K' for thousands or 'M' for millions. For higher precision volume refer to field 7762.")
    public String get87() {
        return _87;
    }

    public void set87(String _87) {
        this._87 = _87;
    }

    /**
     * Bid Size - The number of contracts or shares bid for at the bid price. For US stocks, the number displayed is
     * divided by 100.
     *
     * @return _88
     **/
    @JsonProperty("88")
    @ApiModelProperty(value = "Bid Size - The number of contracts or shares bid for at the bid price. For US stocks, the number displayed is divided by 100.")
    public String get88() {
        return _88;
    }

    public void set88(String _88) {
        this._88 = _88;
    }

    /**
     * Color for Best Bid/Offer Exchange in hex code
     *
     * @return bboExchange
     **/
    @JsonProperty("BboExchange")
    @ApiModelProperty(value = "Color for Best Bid/Offer Exchange in hex code")
    public String getBboExchange() {
        return bboExchange;
    }

    public void setBboExchange(String bboExchange) {
        this.bboExchange = bboExchange;
    }

    /**
     * Get bestAskExch
     *
     * @return bestAskExch
     **/
    @JsonProperty("BestAskExch")
    @ApiModelProperty(value = "")
    public Integer getBestAskExch() {
        return bestAskExch;
    }

    public void setBestAskExch(Integer bestAskExch) {
        this.bestAskExch = bestAskExch;
    }

    /**
     * Get bestBidExch
     *
     * @return bestBidExch
     **/
    @JsonProperty("BestBidExch")
    @ApiModelProperty(value = "")
    public Integer getBestBidExch() {
        return bestBidExch;
    }

    public void setBestBidExch(Integer bestBidExch) {
        this.bestBidExch = bestBidExch;
    }

    /**
     * Get bestEligible
     *
     * @return bestEligible
     **/
    @JsonProperty("BestEligible")
    @ApiModelProperty(value = "")
    public Integer getBestEligible() {
        return bestEligible;
    }

    public void setBestEligible(Integer bestEligible) {
        this.bestEligible = bestEligible;
    }

    /**
     * Get closeAttribs
     *
     * @return closeAttribs
     **/
    @JsonProperty("CloseAttribs")
    @ApiModelProperty(value = "")
    public Integer getCloseAttribs() {
        return closeAttribs;
    }

    public void setCloseAttribs(Integer closeAttribs) {
        this.closeAttribs = closeAttribs;
    }

    /**
     * IBKR Contract identifier
     *
     * @return conid
     **/
    @JsonProperty("conid")
    @ApiModelProperty(value = "IBKR Contract identifier")
    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }

    /**
     * Get lastAttribs
     *
     * @return lastAttribs
     **/
    @JsonProperty("LastAttribs")
    @ApiModelProperty(value = "")
    public Integer getLastAttribs() {
        return lastAttribs;
    }

    public void setLastAttribs(Integer lastAttribs) {
        this.lastAttribs = lastAttribs;
    }

    /**
     * Get lastExch
     *
     * @return lastExch
     **/
    @JsonProperty("LastExch")
    @ApiModelProperty(value = "")
    public Integer getLastExch() {
        return lastExch;
    }

    public void setLastExch(Integer lastExch) {
        this.lastExch = lastExch;
    }

    /**
     * minimum price increment
     *
     * @return minTick
     **/
    @JsonProperty("minTick")
    @ApiModelProperty(value = "minimum price increment")
    @Valid
    public BigDecimal getMinTick() {
        return minTick;
    }

    public void setMinTick(BigDecimal minTick) {
        this.minTick = minTick;
    }

    /**
     * Get preOpenBid
     *
     * @return preOpenBid
     **/
    @JsonProperty("PreOpenBid")
    @ApiModelProperty(value = "")
    public Integer getPreOpenBid() {
        return preOpenBid;
    }

    public void setPreOpenBid(Integer preOpenBid) {
        this.preOpenBid = preOpenBid;
    }

    /**
     * minimum size increment
     *
     * @return sizeMinTick
     **/
    @JsonProperty("sizeMinTick")
    @ApiModelProperty(value = "minimum size increment")
    public Integer getSizeMinTick() {
        return sizeMinTick;
    }

    public void setSizeMinTick(Integer sizeMinTick) {
        this.sizeMinTick = sizeMinTick;
    }

    /**
     * Base time stamp for last update in format YYYYMMDD
     *
     * @return timestampBase
     **/
    @JsonProperty("TimestampBase")
    @ApiModelProperty(value = "Base time stamp for last update in format YYYYMMDD")
    public Integer getTimestampBase() {
        return timestampBase;
    }

    public void setTimestampBase(Integer timestampBase) {
        this.timestampBase = timestampBase;
    }

    /**
     * Get timestampDelta
     *
     * @return timestampDelta
     **/
    @JsonProperty("TimestampDelta")
    @ApiModelProperty(value = "")
    public Integer getTimestampDelta() {
        return timestampDelta;
    }

    public void setTimestampDelta(Integer timestampDelta) {
        this.timestampDelta = timestampDelta;
    }

    public void setHasDelayed(Boolean hasDelayed) {
        this.hasDelayed = hasDelayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_31, _70, _71, _82, _83, _84, _85, _86, _87, _88, _6509, _7057, _7058, _7059, _7068, _7195,
                _7196, _7197, _7198, _7199, _7200, _7201, _7202, _7203, _7204, _7205, _7206, _7207, _7208, _7209, _7210,
                _7211, _7212, _7245, _7246, _7247, _7248, _7249, _7263, _7264, _7265, _7266, _7267, _7268, _7269, _7271,
                _7272, _7273, _7274, _7275, _7276, _7277, _7282, _7283, _7284, _7286, _7287, _7288, _7289, _7290, _7293,
                _7294, _7295, _7296, _7331, _7370, _7371, _7372, _7635, _7636, _7637, _7644, _7674, _7675, _7676, _7677,
                _7681, _7698, _7699, _7718, _7720, _7743, _7761, _7992, _7993, _7994, _7995, conid, minTick,
                bboExchange, hasDelayed, sizeMinTick, bestEligible, bestBidExch, bestAskExch, preOpenBid, lastAttribs,
                timestampBase, timestampDelta, lastExch, closeAttribs);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarketData marketData = (MarketData) o;
        return Objects.equals(this._31, marketData._31) && Objects.equals(this._70, marketData._70) && Objects.equals(
                this._71, marketData._71) && Objects.equals(this._82, marketData._82) && Objects.equals(this._83,
                marketData._83) && Objects.equals(this._84, marketData._84) && Objects.equals(this._85, marketData._85)
                && Objects.equals(this._86, marketData._86) && Objects.equals(this._87, marketData._87)
                && Objects.equals(this._88, marketData._88) && Objects.equals(this._6509, marketData._6509)
                && Objects.equals(this._7057, marketData._7057) && Objects.equals(this._7058, marketData._7058)
                && Objects.equals(this._7059, marketData._7059) && Objects.equals(this._7068, marketData._7068)
                && Objects.equals(this._7195, marketData._7195) && Objects.equals(this._7196, marketData._7196)
                && Objects.equals(this._7197, marketData._7197) && Objects.equals(this._7198, marketData._7198)
                && Objects.equals(this._7199, marketData._7199) && Objects.equals(this._7200, marketData._7200)
                && Objects.equals(this._7201, marketData._7201) && Objects.equals(this._7202, marketData._7202)
                && Objects.equals(this._7203, marketData._7203) && Objects.equals(this._7204, marketData._7204)
                && Objects.equals(this._7205, marketData._7205) && Objects.equals(this._7206, marketData._7206)
                && Objects.equals(this._7207, marketData._7207) && Objects.equals(this._7208, marketData._7208)
                && Objects.equals(this._7209, marketData._7209) && Objects.equals(this._7210, marketData._7210)
                && Objects.equals(this._7211, marketData._7211) && Objects.equals(this._7212, marketData._7212)
                && Objects.equals(this._7245, marketData._7245) && Objects.equals(this._7246, marketData._7246)
                && Objects.equals(this._7247, marketData._7247) && Objects.equals(this._7248, marketData._7248)
                && Objects.equals(this._7249, marketData._7249) && Objects.equals(this._7263, marketData._7263)
                && Objects.equals(this._7264, marketData._7264) && Objects.equals(this._7265, marketData._7265)
                && Objects.equals(this._7266, marketData._7266) && Objects.equals(this._7267, marketData._7267)
                && Objects.equals(this._7268, marketData._7268) && Objects.equals(this._7269, marketData._7269)
                && Objects.equals(this._7271, marketData._7271) && Objects.equals(this._7272, marketData._7272)
                && Objects.equals(this._7273, marketData._7273) && Objects.equals(this._7274, marketData._7274)
                && Objects.equals(this._7275, marketData._7275) && Objects.equals(this._7276, marketData._7276)
                && Objects.equals(this._7277, marketData._7277) && Objects.equals(this._7282, marketData._7282)
                && Objects.equals(this._7283, marketData._7283) && Objects.equals(this._7284, marketData._7284)
                && Objects.equals(this._7286, marketData._7286) && Objects.equals(this._7287, marketData._7287)
                && Objects.equals(this._7288, marketData._7288) && Objects.equals(this._7289, marketData._7289)
                && Objects.equals(this._7290, marketData._7290) && Objects.equals(this._7293, marketData._7293)
                && Objects.equals(this._7294, marketData._7294) && Objects.equals(this._7295, marketData._7295)
                && Objects.equals(this._7296, marketData._7296) && Objects.equals(this._7331, marketData._7331)
                && Objects.equals(this._7370, marketData._7370) && Objects.equals(this._7371, marketData._7371)
                && Objects.equals(this._7372, marketData._7372) && Objects.equals(this._7635, marketData._7635)
                && Objects.equals(this._7636, marketData._7636) && Objects.equals(this._7637, marketData._7637)
                && Objects.equals(this._7644, marketData._7644) && Objects.equals(this._7674, marketData._7674)
                && Objects.equals(this._7675, marketData._7675) && Objects.equals(this._7676, marketData._7676)
                && Objects.equals(this._7677, marketData._7677) && Objects.equals(this._7681, marketData._7681)
                && Objects.equals(this._7698, marketData._7698) && Objects.equals(this._7699, marketData._7699)
                && Objects.equals(this._7718, marketData._7718) && Objects.equals(this._7720, marketData._7720)
                && Objects.equals(this._7743, marketData._7743) && Objects.equals(this._7761, marketData._7761)
                && Objects.equals(this._7992, marketData._7992) && Objects.equals(this._7993, marketData._7993)
                && Objects.equals(this._7994, marketData._7994) && Objects.equals(this._7995, marketData._7995)
                && Objects.equals(this.conid, marketData.conid) && Objects.equals(this.minTick, marketData.minTick)
                && Objects.equals(this.bboExchange, marketData.bboExchange) && Objects.equals(this.hasDelayed,
                marketData.hasDelayed) && Objects.equals(this.sizeMinTick, marketData.sizeMinTick) && Objects.equals(
                this.bestEligible, marketData.bestEligible) && Objects.equals(this.bestBidExch, marketData.bestBidExch)
                && Objects.equals(this.bestAskExch, marketData.bestAskExch) && Objects.equals(this.preOpenBid,
                marketData.preOpenBid) && Objects.equals(this.lastAttribs, marketData.lastAttribs) && Objects.equals(
                this.timestampBase, marketData.timestampBase) && Objects.equals(this.timestampDelta,
                marketData.timestampDelta) && Objects.equals(this.lastExch, marketData.lastExch) && Objects.equals(
                this.closeAttribs, marketData.closeAttribs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MarketData {\n");

        sb.append("    _31: ")
                .append(toIndentedString(_31))
                .append("\n");
        sb.append("    _70: ")
                .append(toIndentedString(_70))
                .append("\n");
        sb.append("    _71: ")
                .append(toIndentedString(_71))
                .append("\n");
        sb.append("    _82: ")
                .append(toIndentedString(_82))
                .append("\n");
        sb.append("    _83: ")
                .append(toIndentedString(_83))
                .append("\n");
        sb.append("    _84: ")
                .append(toIndentedString(_84))
                .append("\n");
        sb.append("    _85: ")
                .append(toIndentedString(_85))
                .append("\n");
        sb.append("    _86: ")
                .append(toIndentedString(_86))
                .append("\n");
        sb.append("    _87: ")
                .append(toIndentedString(_87))
                .append("\n");
        sb.append("    _88: ")
                .append(toIndentedString(_88))
                .append("\n");
        sb.append("    _6509: ")
                .append(toIndentedString(_6509))
                .append("\n");
        sb.append("    _7057: ")
                .append(toIndentedString(_7057))
                .append("\n");
        sb.append("    _7058: ")
                .append(toIndentedString(_7058))
                .append("\n");
        sb.append("    _7059: ")
                .append(toIndentedString(_7059))
                .append("\n");
        sb.append("    _7068: ")
                .append(toIndentedString(_7068))
                .append("\n");
        sb.append("    _7195: ")
                .append(toIndentedString(_7195))
                .append("\n");
        sb.append("    _7196: ")
                .append(toIndentedString(_7196))
                .append("\n");
        sb.append("    _7197: ")
                .append(toIndentedString(_7197))
                .append("\n");
        sb.append("    _7198: ")
                .append(toIndentedString(_7198))
                .append("\n");
        sb.append("    _7199: ")
                .append(toIndentedString(_7199))
                .append("\n");
        sb.append("    _7200: ")
                .append(toIndentedString(_7200))
                .append("\n");
        sb.append("    _7201: ")
                .append(toIndentedString(_7201))
                .append("\n");
        sb.append("    _7202: ")
                .append(toIndentedString(_7202))
                .append("\n");
        sb.append("    _7203: ")
                .append(toIndentedString(_7203))
                .append("\n");
        sb.append("    _7204: ")
                .append(toIndentedString(_7204))
                .append("\n");
        sb.append("    _7205: ")
                .append(toIndentedString(_7205))
                .append("\n");
        sb.append("    _7206: ")
                .append(toIndentedString(_7206))
                .append("\n");
        sb.append("    _7207: ")
                .append(toIndentedString(_7207))
                .append("\n");
        sb.append("    _7208: ")
                .append(toIndentedString(_7208))
                .append("\n");
        sb.append("    _7209: ")
                .append(toIndentedString(_7209))
                .append("\n");
        sb.append("    _7210: ")
                .append(toIndentedString(_7210))
                .append("\n");
        sb.append("    _7211: ")
                .append(toIndentedString(_7211))
                .append("\n");
        sb.append("    _7212: ")
                .append(toIndentedString(_7212))
                .append("\n");
        sb.append("    _7245: ")
                .append(toIndentedString(_7245))
                .append("\n");
        sb.append("    _7246: ")
                .append(toIndentedString(_7246))
                .append("\n");
        sb.append("    _7247: ")
                .append(toIndentedString(_7247))
                .append("\n");
        sb.append("    _7248: ")
                .append(toIndentedString(_7248))
                .append("\n");
        sb.append("    _7249: ")
                .append(toIndentedString(_7249))
                .append("\n");
        sb.append("    _7263: ")
                .append(toIndentedString(_7263))
                .append("\n");
        sb.append("    _7264: ")
                .append(toIndentedString(_7264))
                .append("\n");
        sb.append("    _7265: ")
                .append(toIndentedString(_7265))
                .append("\n");
        sb.append("    _7266: ")
                .append(toIndentedString(_7266))
                .append("\n");
        sb.append("    _7267: ")
                .append(toIndentedString(_7267))
                .append("\n");
        sb.append("    _7268: ")
                .append(toIndentedString(_7268))
                .append("\n");
        sb.append("    _7269: ")
                .append(toIndentedString(_7269))
                .append("\n");
        sb.append("    _7271: ")
                .append(toIndentedString(_7271))
                .append("\n");
        sb.append("    _7272: ")
                .append(toIndentedString(_7272))
                .append("\n");
        sb.append("    _7273: ")
                .append(toIndentedString(_7273))
                .append("\n");
        sb.append("    _7274: ")
                .append(toIndentedString(_7274))
                .append("\n");
        sb.append("    _7275: ")
                .append(toIndentedString(_7275))
                .append("\n");
        sb.append("    _7276: ")
                .append(toIndentedString(_7276))
                .append("\n");
        sb.append("    _7277: ")
                .append(toIndentedString(_7277))
                .append("\n");
        sb.append("    _7282: ")
                .append(toIndentedString(_7282))
                .append("\n");
        sb.append("    _7283: ")
                .append(toIndentedString(_7283))
                .append("\n");
        sb.append("    _7284: ")
                .append(toIndentedString(_7284))
                .append("\n");
        sb.append("    _7286: ")
                .append(toIndentedString(_7286))
                .append("\n");
        sb.append("    _7287: ")
                .append(toIndentedString(_7287))
                .append("\n");
        sb.append("    _7288: ")
                .append(toIndentedString(_7288))
                .append("\n");
        sb.append("    _7289: ")
                .append(toIndentedString(_7289))
                .append("\n");
        sb.append("    _7290: ")
                .append(toIndentedString(_7290))
                .append("\n");
        sb.append("    _7293: ")
                .append(toIndentedString(_7293))
                .append("\n");
        sb.append("    _7294: ")
                .append(toIndentedString(_7294))
                .append("\n");
        sb.append("    _7295: ")
                .append(toIndentedString(_7295))
                .append("\n");
        sb.append("    _7296: ")
                .append(toIndentedString(_7296))
                .append("\n");
        sb.append("    _7331: ")
                .append(toIndentedString(_7331))
                .append("\n");
        sb.append("    _7370: ")
                .append(toIndentedString(_7370))
                .append("\n");
        sb.append("    _7371: ")
                .append(toIndentedString(_7371))
                .append("\n");
        sb.append("    _7372: ")
                .append(toIndentedString(_7372))
                .append("\n");
        sb.append("    _7635: ")
                .append(toIndentedString(_7635))
                .append("\n");
        sb.append("    _7636: ")
                .append(toIndentedString(_7636))
                .append("\n");
        sb.append("    _7637: ")
                .append(toIndentedString(_7637))
                .append("\n");
        sb.append("    _7644: ")
                .append(toIndentedString(_7644))
                .append("\n");
        sb.append("    _7674: ")
                .append(toIndentedString(_7674))
                .append("\n");
        sb.append("    _7675: ")
                .append(toIndentedString(_7675))
                .append("\n");
        sb.append("    _7676: ")
                .append(toIndentedString(_7676))
                .append("\n");
        sb.append("    _7677: ")
                .append(toIndentedString(_7677))
                .append("\n");
        sb.append("    _7681: ")
                .append(toIndentedString(_7681))
                .append("\n");
        sb.append("    _7698: ")
                .append(toIndentedString(_7698))
                .append("\n");
        sb.append("    _7699: ")
                .append(toIndentedString(_7699))
                .append("\n");
        sb.append("    _7718: ")
                .append(toIndentedString(_7718))
                .append("\n");
        sb.append("    _7720: ")
                .append(toIndentedString(_7720))
                .append("\n");
        sb.append("    _7743: ")
                .append(toIndentedString(_7743))
                .append("\n");
        sb.append("    _7761: ")
                .append(toIndentedString(_7761))
                .append("\n");
        sb.append("    _7992: ")
                .append(toIndentedString(_7992))
                .append("\n");
        sb.append("    _7993: ")
                .append(toIndentedString(_7993))
                .append("\n");
        sb.append("    _7994: ")
                .append(toIndentedString(_7994))
                .append("\n");
        sb.append("    _7995: ")
                .append(toIndentedString(_7995))
                .append("\n");
        sb.append("    conid: ")
                .append(toIndentedString(conid))
                .append("\n");
        sb.append("    minTick: ")
                .append(toIndentedString(minTick))
                .append("\n");
        sb.append("    bboExchange: ")
                .append(toIndentedString(bboExchange))
                .append("\n");
        sb.append("    hasDelayed: ")
                .append(toIndentedString(hasDelayed))
                .append("\n");
        sb.append("    sizeMinTick: ")
                .append(toIndentedString(sizeMinTick))
                .append("\n");
        sb.append("    bestEligible: ")
                .append(toIndentedString(bestEligible))
                .append("\n");
        sb.append("    bestBidExch: ")
                .append(toIndentedString(bestBidExch))
                .append("\n");
        sb.append("    bestAskExch: ")
                .append(toIndentedString(bestAskExch))
                .append("\n");
        sb.append("    preOpenBid: ")
                .append(toIndentedString(preOpenBid))
                .append("\n");
        sb.append("    lastAttribs: ")
                .append(toIndentedString(lastAttribs))
                .append("\n");
        sb.append("    timestampBase: ")
                .append(toIndentedString(timestampBase))
                .append("\n");
        sb.append("    timestampDelta: ")
                .append(toIndentedString(timestampDelta))
                .append("\n");
        sb.append("    lastExch: ")
                .append(toIndentedString(lastExch))
                .append("\n");
        sb.append("    closeAttribs: ")
                .append(toIndentedString(closeAttribs))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    public MarketData _31(String _31) {
        this._31 = _31;
        return this;
    }

    public MarketData _6509(String _6509) {
        this._6509 = _6509;
        return this;
    }

    public MarketData _70(BigDecimal _70) {
        this._70 = _70;
        return this;
    }

    public MarketData _7057(String _7057) {
        this._7057 = _7057;
        return this;
    }

    public MarketData _7058(String _7058) {
        this._7058 = _7058;
        return this;
    }

    public MarketData _7059(BigDecimal _7059) {
        this._7059 = _7059;
        return this;
    }

    public MarketData _7068(String _7068) {
        this._7068 = _7068;
        return this;
    }

    public MarketData _71(BigDecimal _71) {
        this._71 = _71;
        return this;
    }

    public MarketData _7195(String _7195) {
        this._7195 = _7195;
        return this;
    }

    public MarketData _7196(String _7196) {
        this._7196 = _7196;
        return this;
    }

    public MarketData _7197(String _7197) {
        this._7197 = _7197;
        return this;
    }

    public MarketData _7198(String _7198) {
        this._7198 = _7198;
        return this;
    }

    public MarketData _7199(String _7199) {
        this._7199 = _7199;
        return this;
    }

    public MarketData _7200(String _7200) {
        this._7200 = _7200;
        return this;
    }

    public MarketData _7201(String _7201) {
        this._7201 = _7201;
        return this;
    }

    public MarketData _7202(String _7202) {
        this._7202 = _7202;
        return this;
    }

    public MarketData _7203(String _7203) {
        this._7203 = _7203;
        return this;
    }

    public MarketData _7204(String _7204) {
        this._7204 = _7204;
        return this;
    }

    public MarketData _7205(String _7205) {
        this._7205 = _7205;
        return this;
    }

    public MarketData _7206(String _7206) {
        this._7206 = _7206;
        return this;
    }

    public MarketData _7207(String _7207) {
        this._7207 = _7207;
        return this;
    }

    public MarketData _7208(String _7208) {
        this._7208 = _7208;
        return this;
    }

    public MarketData _7209(String _7209) {
        this._7209 = _7209;
        return this;
    }

    public MarketData _7210(String _7210) {
        this._7210 = _7210;
        return this;
    }

    public MarketData _7211(String _7211) {
        this._7211 = _7211;
        return this;
    }

    public MarketData _7212(String _7212) {
        this._7212 = _7212;
        return this;
    }

    public MarketData _7245(String _7245) {
        this._7245 = _7245;
        return this;
    }

    public MarketData _7246(String _7246) {
        this._7246 = _7246;
        return this;
    }

    public MarketData _7247(String _7247) {
        this._7247 = _7247;
        return this;
    }

    public MarketData _7248(String _7248) {
        this._7248 = _7248;
        return this;
    }

    public MarketData _7249(String _7249) {
        this._7249 = _7249;
        return this;
    }

    public MarketData _7263(String _7263) {
        this._7263 = _7263;
        return this;
    }

    public MarketData _7264(String _7264) {
        this._7264 = _7264;
        return this;
    }

    public MarketData _7265(String _7265) {
        this._7265 = _7265;
        return this;
    }

    public MarketData _7266(String _7266) {
        this._7266 = _7266;
        return this;
    }

    public MarketData _7267(String _7267) {
        this._7267 = _7267;
        return this;
    }

    public MarketData _7268(String _7268) {
        this._7268 = _7268;
        return this;
    }

    public MarketData _7269(String _7269) {
        this._7269 = _7269;
        return this;
    }

    public MarketData _7271(String _7271) {
        this._7271 = _7271;
        return this;
    }

    public MarketData _7272(String _7272) {
        this._7272 = _7272;
        return this;
    }

    public MarketData _7273(String _7273) {
        this._7273 = _7273;
        return this;
    }

    public MarketData _7274(String _7274) {
        this._7274 = _7274;
        return this;
    }

    public MarketData _7275(String _7275) {
        this._7275 = _7275;
        return this;
    }

    public MarketData _7276(String _7276) {
        this._7276 = _7276;
        return this;
    }

    public MarketData _7277(String _7277) {
        this._7277 = _7277;
        return this;
    }

    public MarketData _7282(String _7282) {
        this._7282 = _7282;
        return this;
    }

    public MarketData _7283(String _7283) {
        this._7283 = _7283;
        return this;
    }

    public MarketData _7284(String _7284) {
        this._7284 = _7284;
        return this;
    }

    public MarketData _7286(BigDecimal _7286) {
        this._7286 = _7286;
        return this;
    }

    public MarketData _7287(String _7287) {
        this._7287 = _7287;
        return this;
    }

    public MarketData _7288(String _7288) {
        this._7288 = _7288;
        return this;
    }

    public MarketData _7289(String _7289) {
        this._7289 = _7289;
        return this;
    }

    public MarketData _7290(String _7290) {
        this._7290 = _7290;
        return this;
    }

    public MarketData _7293(String _7293) {
        this._7293 = _7293;
        return this;
    }

    public MarketData _7294(String _7294) {
        this._7294 = _7294;
        return this;
    }

    public MarketData _7295(BigDecimal _7295) {
        this._7295 = _7295;
        return this;
    }

    public MarketData _7296(BigDecimal _7296) {
        this._7296 = _7296;
        return this;
    }

    public MarketData _7331(String _7331) {
        this._7331 = _7331;
        return this;
    }

    public MarketData _7370(String _7370) {
        this._7370 = _7370;
        return this;
    }

    public MarketData _7371(String _7371) {
        this._7371 = _7371;
        return this;
    }

    public MarketData _7372(String _7372) {
        this._7372 = _7372;
        return this;
    }

    public MarketData _7635(String _7635) {
        this._7635 = _7635;
        return this;
    }

    public MarketData _7636(BigDecimal _7636) {
        this._7636 = _7636;
        return this;
    }

    public MarketData _7637(String _7637) {
        this._7637 = _7637;
        return this;
    }

    public MarketData _7644(String _7644) {
        this._7644 = _7644;
        return this;
    }

    public MarketData _7674(String _7674) {
        this._7674 = _7674;
        return this;
    }

    public MarketData _7675(String _7675) {
        this._7675 = _7675;
        return this;
    }

    public MarketData _7676(String _7676) {
        this._7676 = _7676;
        return this;
    }

    public MarketData _7677(String _7677) {
        this._7677 = _7677;
        return this;
    }

    public MarketData _7681(String _7681) {
        this._7681 = _7681;
        return this;
    }

    public MarketData _7698(String _7698) {
        this._7698 = _7698;
        return this;
    }

    public MarketData _7699(String _7699) {
        this._7699 = _7699;
        return this;
    }

    public MarketData _7718(String _7718) {
        this._7718 = _7718;
        return this;
    }

    public MarketData _7720(String _7720) {
        this._7720 = _7720;
        return this;
    }

    public MarketData _7743(String _7743) {
        this._7743 = _7743;
        return this;
    }

    public MarketData _7761(String _7761) {
        this._7761 = _7761;
        return this;
    }

    public MarketData _7992(String _7992) {
        this._7992 = _7992;
        return this;
    }

    public MarketData _7993(String _7993) {
        this._7993 = _7993;
        return this;
    }

    public MarketData _7994(String _7994) {
        this._7994 = _7994;
        return this;
    }

    public MarketData _7995(String _7995) {
        this._7995 = _7995;
        return this;
    }

    public MarketData _82(String _82) {
        this._82 = _82;
        return this;
    }

    public MarketData _83(BigDecimal _83) {
        this._83 = _83;
        return this;
    }

    public MarketData _84(String _84) {
        this._84 = _84;
        return this;
    }

    public MarketData _85(String _85) {
        this._85 = _85;
        return this;
    }

    public MarketData _86(String _86) {
        this._86 = _86;
        return this;
    }

    public MarketData _87(String _87) {
        this._87 = _87;
        return this;
    }

    public MarketData _88(String _88) {
        this._88 = _88;
        return this;
    }

    public MarketData bboExchange(String bboExchange) {
        this.bboExchange = bboExchange;
        return this;
    }

    public MarketData bestAskExch(Integer bestAskExch) {
        this.bestAskExch = bestAskExch;
        return this;
    }

    public MarketData bestBidExch(Integer bestBidExch) {
        this.bestBidExch = bestBidExch;
        return this;
    }

    public MarketData bestEligible(Integer bestEligible) {
        this.bestEligible = bestEligible;
        return this;
    }

    public MarketData closeAttribs(Integer closeAttribs) {
        this.closeAttribs = closeAttribs;
        return this;
    }

    public MarketData conid(Integer conid) {
        this.conid = conid;
        return this;
    }

    public MarketData hasDelayed(Boolean hasDelayed) {
        this.hasDelayed = hasDelayed;
        return this;
    }

    /**
     * If market data field values return delayed
     *
     * @return hasDelayed
     **/
    @JsonProperty("HasDelayed")
    @ApiModelProperty(value = "If market data field values return delayed")
    public Boolean isHasDelayed() {
        return hasDelayed;
    }

    public MarketData lastAttribs(Integer lastAttribs) {
        this.lastAttribs = lastAttribs;
        return this;
    }

    public MarketData lastExch(Integer lastExch) {
        this.lastExch = lastExch;
        return this;
    }

    public MarketData minTick(BigDecimal minTick) {
        this.minTick = minTick;
        return this;
    }

    public MarketData preOpenBid(Integer preOpenBid) {
        this.preOpenBid = preOpenBid;
        return this;
    }

    public MarketData sizeMinTick(Integer sizeMinTick) {
        this.sizeMinTick = sizeMinTick;
        return this;
    }

    public MarketData timestampBase(Integer timestampBase) {
        this.timestampBase = timestampBase;
        return this;
    }

    public MarketData timestampDelta(Integer timestampDelta) {
        this.timestampDelta = timestampDelta;
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

