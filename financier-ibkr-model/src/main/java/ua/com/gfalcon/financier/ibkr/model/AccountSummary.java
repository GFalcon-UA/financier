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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class AccountSummary {

    @JsonProperty("accountready")
    @SerializedName("accountready")
    private Summary accountReady;

    @JsonProperty("accounttype")
    @SerializedName("accounttype")
    private Summary accountType;

    @JsonProperty("accruedcash")
    @SerializedName("accruedcash")
    private Summary accruedCash;

    @JsonProperty("accruedcash-c")
    @SerializedName("accruedcash-c")
    private Summary accruedCashC;

    @JsonProperty("accruedcash-f")
    @SerializedName("accruedcash-f")
    private Summary accruedCashF;

    @JsonProperty("accruedcash-s")
    @SerializedName("accruedcash-s")
    private Summary accruedCashS;

    @JsonProperty("accrueddividend")
    @SerializedName("accrueddividend")
    private Summary accruedDividend;

    @JsonProperty("accrueddividend-c")
    @SerializedName("accrueddividend-c")
    private Summary accruedDividendC;

    @JsonProperty("accrueddividend-f")
    @SerializedName("accrueddividend-f")
    private Summary accruedDividendF;

    @JsonProperty("accrueddividend-s")
    @SerializedName("accrueddividend-s")
    private Summary accruedDividendS;

    @JsonProperty("availablefunds")
    @SerializedName("availablefunds")
    private Summary availableFunds;

    @JsonProperty("availablefunds-c")
    @SerializedName("availablefunds-c")
    private Summary availableFundsC;

    @JsonProperty("availablefunds-f")
    @SerializedName("availablefunds-f")
    private Summary availableFundsF;

    @JsonProperty("availablefunds-s")
    @SerializedName("availablefunds-s")
    private Summary availableFundsS;

    @JsonProperty("billable")
    @SerializedName("billable")
    private Summary billable;

    @JsonProperty("billable-c")
    @SerializedName("billable-c")
    private Summary billableC;

    @JsonProperty("billable-f")
    @SerializedName("billable-f")
    private Summary billableF;

    @JsonProperty("billable-s")
    @SerializedName("billable-s")
    private Summary billableS;

    @JsonProperty("buyingpower")
    @SerializedName("buyingpower")
    private Summary buyingPower;

    @JsonProperty("cushion")
    @SerializedName("cushion")
    private Summary cushion;

    @JsonProperty("daytradesremaining")
    @SerializedName("daytradesremaining")
    private Summary dayTradesRemaining;

    @JsonProperty("daytradesremainingt+1")
    @SerializedName("daytradesremainingt+1")
    private Summary dayTradesRemainingTplus1;

    @JsonProperty("daytradesremainingt+2")
    @SerializedName("daytradesremainingt+2")
    private Summary dayTradesRemainingTplus2;

    @JsonProperty("daytradesremainingt+3")
    @SerializedName("daytradesremainingt+3")
    private Summary dayTradesRemainingTplus3;

    @JsonProperty("daytradesremainingt+4")
    @SerializedName("daytradesremainingt+4")
    private Summary dayTradesRemainingTplus4;

    @JsonProperty("equitywithloanvalue")
    @SerializedName("equitywithloanvalue")
    private Summary equityWithLoanValue;

    @JsonProperty("equitywithloanvalue-c")
    @SerializedName("equitywithloanvalue-c")
    private Summary equityWithLoanValueC;

    @JsonProperty("equitywithloanvalue-f")
    @SerializedName("equitywithloanvalue-f")
    private Summary eequityWithLoanValueF;

    @JsonProperty("equitywithloanvalue-s")
    @SerializedName("equitywithloanvalue-s")
    private Summary equityWithLoanValueS;

    @JsonProperty("excessliquidity")
    @SerializedName("excessliquidity")
    private Summary excessLiquidity;

    @JsonProperty("excessliquidity-c")
    @SerializedName("excessliquidity-c")
    private Summary excessLiquidityC;

    @JsonProperty("excessliquidity-f")
    @SerializedName("excessliquidity-f")
    private Summary excessLiquidityF;

    @JsonProperty("excessliquidity-s")
    @SerializedName("excessliquidity-s")
    private Summary excessLiquidityS;

    @JsonProperty("fullavailablefunds")
    @SerializedName("fullavailablefunds")
    private Summary fullAvailableFunds;

    @JsonProperty("fullavailablefunds-c")
    @SerializedName("fullavailablefunds-c")
    private Summary fullAvailableFundsC;

    @JsonProperty("fullavailablefunds-f")
    @SerializedName("fullavailablefunds-f")
    private Summary fullAvailableFundsF;

    @JsonProperty("fullavailablefunds-s")
    @SerializedName("fullavailablefunds-s")
    private Summary fullAvailableFundsS;

    @JsonProperty("fullexcessliquidity")
    @SerializedName("fullexcessliquidity")
    private Summary fullExcessLiquidity;

    @JsonProperty("fullexcessliquidity-c")
    @SerializedName("fullexcessliquidity-c")
    private Summary fullExcessLiquidityC;

    @JsonProperty("fullexcessliquidity-f")
    @SerializedName("fullexcessliquidity-f")
    private Summary fullExcessLiquidityF;

    @JsonProperty("fullexcessliquidity-s")
    @SerializedName("fullexcessliquidity-s")
    private Summary fullExcessLiquidityS;

    @JsonProperty("fullinitmarginreq")
    @SerializedName("fullinitmarginreq")
    private Summary fullInitMarginReq;

    @JsonProperty("fullinitmarginreq-c")
    @SerializedName("fullinitmarginreq-c")
    private Summary fullInitMarginReqC;

    @JsonProperty("fullinitmarginreq-f")
    @SerializedName("fullinitmarginreq-f")
    private Summary fullInitMarginReqF;

    @JsonProperty("fullinitmarginreq-s")
    @SerializedName("fullinitmarginreq-s")
    private Summary fullInitMarginReqS;

    @JsonProperty("fullmaintmarginreq")
    @SerializedName("fullmaintmarginreq")
    private Summary fullMaintMarginReq;

    @JsonProperty("fullmaintmarginreq-c")
    @SerializedName("fullmaintmarginreq-c")
    private Summary fullMaintMarginReqC;

    @JsonProperty("fullmaintmarginreq-f")
    @SerializedName("fullmaintmarginreq-f")
    private Summary fullMaintMarginReqF;

    @JsonProperty("fullmaintmarginreq-s")
    @SerializedName("fullmaintmarginreq-s")
    private Summary fullMaintMarginReqS;

    @JsonProperty("grosspositionvalue")
    @SerializedName("grosspositionvalue")
    private Summary grossPositionValue;

    @JsonProperty("grosspositionvalue-c")
    @SerializedName("grosspositionvalue-c")
    private Summary grossPositionValueC;

    @JsonProperty("grosspositionvalue-f")
    @SerializedName("grosspositionvalue-f")
    private Summary grossPositionValueF;

    @JsonProperty("grosspositionvalue-s")
    @SerializedName("grosspositionvalue-s")
    private Summary grossPositionValueS;

    @JsonProperty("guarantee")
    @SerializedName("guarantee")
    private Summary guarantee;

    @JsonProperty("guarantee-c")
    @SerializedName("guarantee-c")
    private Summary guaranteeC;

    @JsonProperty("guarantee-f")
    @SerializedName("guarantee-f")
    private Summary guaranteeF;

    @JsonProperty("guarantee-s")
    @SerializedName("guarantee-s")
    private Summary guaranteeS;

    @JsonProperty("highestseverity")
    @SerializedName("highestseverity")
    private Summary highestSeverity;

    @JsonProperty("highestseverity-c")
    @SerializedName("highestseverity-c")
    private Summary highestSeverityC;

    @JsonProperty("highestseverity-f")
    @SerializedName("highestseverity-f")
    private Summary highestSeverityF;

    @JsonProperty("highestseverity-s")
    @SerializedName("highestseverity-s")
    private Summary highestSeverityS;

    @JsonProperty("indianstockhaircut")
    @SerializedName("indianstockhaircut")
    private Summary indianStockHaircut;

    @JsonProperty("indianstockhaircut-c")
    @SerializedName("indianstockhaircut-c")
    private Summary indianStockHaircutC;

    @JsonProperty("indianstockhaircut-f")
    @SerializedName("indianstockhaircut-f")
    private Summary indianStockHaircutF;

    @JsonProperty("indianstockhaircut-s")
    @SerializedName("indianstockhaircut-s")
    private Summary indianStockHaircutS;

    @JsonProperty("initmarginreq")
    @SerializedName("initmarginreq")
    private Summary initMarginReq;

    @JsonProperty("initmarginreq-c")
    @SerializedName("initmarginreq-c")
    private Summary initMarginReqC;

    @JsonProperty("initmarginreq-f")
    @SerializedName("initmarginreq-f")
    private Summary initMarginReqF;

    @JsonProperty("initmarginreq-s")
    @SerializedName("initmarginreq-s")
    private Summary initMarginReqS;

    @JsonProperty("leverage")
    @SerializedName("leverage")
    private Summary leverage;

    @JsonProperty("leverage-c")
    @SerializedName("leverage-c")
    private Summary leverageC;

    @JsonProperty("leverage-f")
    @SerializedName("leverage-f")
    private Summary leverageF;

    @JsonProperty("leverage-s")
    @SerializedName("leverage-s")
    private Summary leverageS;

    @JsonProperty("lookaheadavailablefunds")
    @SerializedName("lookaheadavailablefunds")
    private Summary lookAheadAvailableFunds;

    @JsonProperty("lookaheadavailablefunds-c")
    @SerializedName("lookaheadavailablefunds-c")
    private Summary lookAheadAvailableFundsC;

    @JsonProperty("lookaheadavailablefunds-f")
    @SerializedName("lookaheadavailablefunds-f")
    private Summary lookAheadAvailableFundsF;

    @JsonProperty("lookaheadavailablefunds-s")
    @SerializedName("lookaheadavailablefunds-s")
    private Summary lookAheadAvailableFundsS;

    @JsonProperty("lookaheadexcessliquidity")
    @SerializedName("lookaheadexcessliquidity")
    private Summary lookAheadExcessLiquidity;

    @JsonProperty("lookaheadexcessliquidity-c")
    @SerializedName("lookaheadexcessliquidity-c")
    private Summary lookAheadExcessLiquidityC;

    @JsonProperty("lookaheadexcessliquidity-f")
    @SerializedName("lookaheadexcessliquidity-f")
    private Summary lookAheadExcessLiquidityF;

    @JsonProperty("lookaheadexcessliquidity-s")
    @SerializedName("lookaheadexcessliquidity-s")
    private Summary lookAheadExcessLiquidityS;

    @JsonProperty("lookaheadinitmarginreq")
    @SerializedName("lookaheadinitmarginreq")
    private Summary lookAheadInitMarginReq;

    @JsonProperty("lookaheadinitmarginreq-c")
    @SerializedName("lookaheadinitmarginreq-c")
    private Summary lookAheadInitMarginReqC;

    @JsonProperty("lookaheadinitmarginreq-f")
    @SerializedName("lookaheadinitmarginreq-f")
    private Summary lookAheadInitMarginReqF;

    @JsonProperty("lookaheadinitmarginreq-s")
    @SerializedName("lookaheadinitmarginreq-s")
    private Summary lookAheadInitMarginReqS;

    @JsonProperty("lookaheadmaintmarginreq")
    @SerializedName("lookaheadmaintmarginreq")
    private Summary lookAheadMaintMarginReq;

    @JsonProperty("lookaheadmaintmarginreq-c")
    @SerializedName("lookaheadmaintmarginreq-c")
    private Summary lookAheadMaintMarginReqC;

    @JsonProperty("lookaheadmaintmarginreq-f")
    @SerializedName("lookaheadmaintmarginreq-f")
    private Summary lookAheadMaintMarginReqF;

    @JsonProperty("lookaheadmaintmarginreq-s")
    @SerializedName("lookaheadmaintmarginreq-s")
    private Summary lookAheadMaintMarginReqS;

    @JsonProperty("lookaheadnextchange")
    @SerializedName("lookaheadnextchange")
    private Summary lookAheadNextChange;

    @JsonProperty("maintmarginreq")
    @SerializedName("maintmarginreq")
    private Summary maintMarginReq;

    @JsonProperty("maintmarginreq-c")
    @SerializedName("maintmarginreq-c")
    private Summary maintMarginReqC;

    @JsonProperty("maintmarginreq-f")
    @SerializedName("maintmarginreq-f")
    private Summary maintMarginReqF;

    @JsonProperty("maintmarginreq-s")
    @SerializedName("maintmarginreq-s")
    private Summary maintMarginReqS;

    @JsonProperty("netliquidation")
    @SerializedName("netliquidation")
    private Summary netLiquidation;

    @JsonProperty("netliquidation-c")
    @SerializedName("netliquidation-c")
    private Summary netLiquidationC;

    @JsonProperty("netliquidation-f")
    @SerializedName("netliquidation-f")
    private Summary netLiquidationF;

    @JsonProperty("netliquidation-s")
    @SerializedName("netliquidation-s")
    private Summary netLiquidationS;

    @JsonProperty("netliquidationuncertainty")
    @SerializedName("netliquidationuncertainty")
    private Summary netLiquidationUncertainty;

    @JsonProperty("nlvandmargininreview")
    @SerializedName("nlvandmargininreview")
    private Summary nlvandMarginInReview;

    @JsonProperty("pasharesvalue")
    @SerializedName("pasharesvalue")
    private Summary paSharesValue;

    @JsonProperty("pasharesvalue-c")
    @SerializedName("pasharesvalue-c")
    private Summary paSharesValueC;

    @JsonProperty("pasharesvalue-f")
    @SerializedName("pasharesvalue-f")
    private Summary paSharesValueF;

    @JsonProperty("pasharesvalue-s")
    @SerializedName("pasharesvalue-s")
    private Summary paSharesValueS;

    @JsonProperty("postexpirationexcess")
    @SerializedName("postexpirationexcess")
    private Summary postExpirationExcess;

    @JsonProperty("postexpirationexcess-c")
    @SerializedName("postexpirationexcess-c")
    private Summary postExpirationExcessC;

    @JsonProperty("postexpirationexcess-f")
    @SerializedName("postexpirationexcess-f")
    private Summary postExpirationExcessF;

    @JsonProperty("postexpirationexcess-s")
    @SerializedName("postexpirationexcess-s")
    private Summary postExpirationExcessS;

    @JsonProperty("postexpirationmargin")
    @SerializedName("postexpirationmargin")
    private Summary postExpirationMargin;

    @JsonProperty("postexpirationmargin-c")
    @SerializedName("postexpirationmargin-c")
    private Summary postExpirationMarginC;

    @JsonProperty("postexpirationmargin-f")
    @SerializedName("postexpirationmargin-f")
    private Summary postExpirationMarginF;

    @JsonProperty("postexpirationmargin-s")
    @SerializedName("postexpirationmargin-s")
    private Summary postExpirationMarginS;

    @JsonProperty("previousdayequitywithloanvalue")
    @SerializedName("previousdayequitywithloanvalue")
    private Summary previousDayEquityWithLoanValue;

    @JsonProperty("previousdayequitywithloanvalue-c")
    @SerializedName("previousdayequitywithloanvalue-c")
    private Summary previousDayEquityWithLoanValueC;

    @JsonProperty("previousdayequitywithloanvalue-f")
    @SerializedName("previousdayequitywithloanvalue-f")
    private Summary previousDayEquityWithLoanValueF;

    @JsonProperty("previousdayequitywithloanvalue-s")
    @SerializedName("previousdayequitywithloanvalue-s")
    private Summary previousDayEquityWithLoanValueS;

    @JsonProperty("segmenttitle-c")
    @SerializedName("segmenttitle-c")
    private Summary segmentTitleC;

    @JsonProperty("segmenttitle-f")
    @SerializedName("segmenttitle-f")
    private Summary segmentTitleF;

    @JsonProperty("segmenttitle-s")
    @SerializedName("segmenttitle-s")
    private Summary segmentTitleS;

    @JsonProperty("totalcashvalue")
    @SerializedName("totalcashvalue")
    private Summary totalCashValue;

    @JsonProperty("totalcashvalue-c")
    @SerializedName("totalcashvalue-c")
    private Summary totalCashValueC;

    @JsonProperty("totalcashvalue-f")
    @SerializedName("totalcashvalue-f")
    private Summary totalCashValueF;

    @JsonProperty("totalcashvalue-s")
    @SerializedName("totalcashvalue-s")
    private Summary totalCashValueS;

    @JsonProperty("totaldebitcardpendingcharges")
    @SerializedName("totaldebitcardpendingcharges")
    private Summary totalDebitCardPendingCharges;

    @JsonProperty("totaldebitcardpendingcharges-c")
    @SerializedName("totaldebitcardpendingcharges-c")
    private Summary totalDebitCardPendingChargesC;

    @JsonProperty("totaldebitcardpendingcharges-f")
    @SerializedName("totaldebitcardpendingcharges-f")
    private Summary totalDebitCardPendingChargesF;

    @JsonProperty("totaldebitcardpendingcharges-s")
    @SerializedName("totaldebitcardpendingcharges-s")
    private Summary totalDebitCardPendingChargesS;

    @JsonProperty("tradingtype-f")
    @SerializedName("tradingtype-f")
    private Summary tradingTypeF;

    @JsonProperty("tradingtype-s")
    @SerializedName("tradingtype-s")
    private Summary tradingTypeS;
}
