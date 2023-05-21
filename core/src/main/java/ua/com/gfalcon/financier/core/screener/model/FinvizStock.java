/*
 * Copyright (c) 2016-2023 Oleksii Khalikov @GFalcon-UA (http://gfalcon.com.ua)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.com.gfalcon.financier.core.screener.model;

import lombok.Builder;
import lombok.Generated;

@Builder
@Generated
public record FinvizStock(String ticker, String name, String sector, String industry, String geo, String index,
                          String pe, String eps, String insiderOwn, String shsOutstand, String perfWeek,
                          String marketCap, String forwardPE, String epsNextY, String insiderTrans, String shsFloat,
                          String perfMonth, String income, String peg, String epsNextQ, String instOwn,
                          String shortFloat, String perfQuarter, String sales, String ps, String epsThisYPercent,
                          String instTrans, String shortInterest, String perfHalfY, String bookSh, String pb,
                          String epsNextYPercent, String roa, String targetPrice, String perfYear, String cashSh,
                          String pc, String epsNext5YPercent, String roe, String w52Range, String perfYTD,
                          String dividend, String pfcf, String epsPast5YPercent, String roi, String w52High,
                          String beta, String dividendPercent, String quickRatio, String salesPast5Y,
                          String grossMargin, String w52Low, String atr, String employees, String currentRatio,
                          String salesQQ, String operMargin, String rsi14, String volatility, String optionable,
                          String debtEq, String epsQQ, String profitMargin, String relVolume, String prevClose,
                          String shortable, String ltDebtEq, String earnings, String payout, String avgVolume,
                          String price, String recom, String sma20, String sma50, String sma200, String volume,
                          String change, String companyInfo) implements Stock {

}
