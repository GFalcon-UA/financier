package ua.com.gfalcon.financier.screener.model;

import lombok.Builder;

@Builder
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
