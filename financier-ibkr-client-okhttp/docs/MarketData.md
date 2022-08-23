# MarketData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_31** | **
String** | Last Price - The last price at which the contract traded. May contain one of the following prefixes:   * C - Previous day&#39;s closing price.   * H - Trading has halted.  |  [optional]
**_70** | [**BigDecimal**](BigDecimal.md) | High - Current day high price |  [optional]
**_71** | [**BigDecimal**](BigDecimal.md) | Low - Current day low price |  [optional]
**_82** | **
String** | Change - The difference between the last price and the close on the previous trading day |  [optional]
**_83** | [**
BigDecimal**](BigDecimal.md) | Change % - The difference between the last price and the close on the previous trading day in percentage. |  [optional]
**_84** | **String** | Bid Price - The highest-priced bid on the contract. |  [optional]
**_85** | **
String** | Ask Size - The number of contracts or shares offered at the ask price. For US stocks, the number displayed is divided by 100. |  [optional]
**_86** | **String** | Ask Price - The lowest-priced offer on the contract. |  [optional]
**_87** | **
String** | Volume - Volume for the day, formatted with &#39;K&#39; for thousands or &#39;M&#39; for millions. For higher precision volume refer to field 7762. |  [optional]
**_88** | **
String** | Bid Size - The number of contracts or shares bid for at the bid price. For US stocks, the number displayed is divided by 100. |  [optional]
**_6509** | **
String** | Market Data Availability. The field may contain three chars. First char defines: R &#x3D; RealTime, D &#x3D; Delayed, Z &#x3D; Frozen, Y &#x3D; Frozen Delayed, N &#x3D; Not Subscribed. Second char defines: P &#x3D; Snapshot, p &#x3D; Consolidated. Third char defines: B &#x3D; Book   * RealTime - Data is relayed back in real time without delay, market data subscription(s) are required.   * Delayed - Data is relayed back 15-20 min delayed.   * Frozen - Last recorded data at market close, relayed back in real time.   * Frozen Delayed - Last recorded data at market close, relayed back delayed.   * Not Subscribed - User does not have the required market data subscription(s) to relay back either real time or delayed data.   * Snapshot - Snapshot request is available for contract.   * Consolidated - Market data is aggregated across multiple exchanges or venues.   * Book - Top of the book data is available for contract.  |  [optional]
**_7057** | **
String** | Ask Exch - Displays the exchange(s) offering the SMART price. A&#x3D;AMEX, C&#x3D;CBOE, I&#x3D;ISE, X&#x3D;PHLX, N&#x3D;PSE, B&#x3D;BOX, Q&#x3D;NASDAQOM, Z&#x3D;BATS, W&#x3D;CBOE2, T&#x3D;NASDAQBX, M&#x3D;MIAX, H&#x3D;GEMINI, E&#x3D;EDGX, J&#x3D;MERCURY |  [optional]
**_7058** | **
String** | Last Exch - Displays the exchange(s) offering the SMART price. A&#x3D;AMEX, C&#x3D;CBOE, I&#x3D;ISE, X&#x3D;PHLX, N&#x3D;PSE, B&#x3D;BOX, Q&#x3D;NASDAQOM, Z&#x3D;BATS, W&#x3D;CBOE2, T&#x3D;NASDAQBX, M&#x3D;MIAX, H&#x3D;GEMINI, E&#x3D;EDGX, J&#x3D;MERCURY |  [optional]
**_7059** | [**BigDecimal**](BigDecimal.md) | Last Size - The number of unites traded at the last price |  [optional]
**_7068** | **
String** | Bid Exch - Displays the exchange(s) offering the SMART price. A&#x3D;AMEX, C&#x3D;CBOE, I&#x3D;ISE, X&#x3D;PHLX, N&#x3D;PSE, B&#x3D;BOX, Q&#x3D;NASDAQOM, Z&#x3D;BATS, W&#x3D;CBOE2, T&#x3D;NASDAQBX, M&#x3D;MIAX, H&#x3D;GEMINI, E&#x3D;EDGX, J&#x3D;MERCURY |  [optional]
**_7195** | **String** | IV Rank |  [optional]
**_7196** | **String** | IV Rank |  [optional]
**_7197** | **String** | IV Rank |  [optional]
**_7198** | **String** | IV Percentile |  [optional]
**_7199** | **String** | IV Percentile |  [optional]
**_7200** | **String** | IV Percentile |  [optional]
**_7201** | **String** | IV High Low |  [optional]
**_7202** | **String** | IV High Low |  [optional]
**_7203** | **String** | IV High Low |  [optional]
**_7204** | **String** | IV High Low |  [optional]
**_7205** | **String** | IV High Low |  [optional]
**_7206** | **String** | IV High Low |  [optional]
**_7207** | **String** | HV Rank |  [optional]
**_7208** | **String** | HV Rank |  [optional]
**_7209** | **String** | HV Rank |  [optional]
**_7210** | **String** | HV Percentile |  [optional]
**_7211** | **String** | HV Percentile |  [optional]
**_7212** | **String** | HV Percentile |  [optional]
**_7245** | **String** | HV High Low |  [optional]
**_7246** | **String** | HV High Low |  [optional]
**_7247** | **String** | HV High Low |  [optional]
**_7248** | **String** | HV High Low |  [optional]
**_7249** | **String** | HV High Low |  [optional]
**_7263** | **String** | HV High Low |  [optional]
**_7264** | **String** | ESG |  [optional]
**_7265** | **String** | ESG |  [optional]
**_7266** | **String** | ESG |  [optional]
**_7267** | **String** | ESG |  [optional]
**_7268** | **String** | ESG |  [optional]
**_7269** | **String** | ESG |  [optional]
**_7271** | **String** | ESG |  [optional]
**_7272** | **String** | ESG |  [optional]
**_7273** | **String** | ESG |  [optional]
**_7274** | **String** | ESG |  [optional]
**_7275** | **String** | ESG |  [optional]
**_7276** | **String** | ESG |  [optional]
**_7277** | **String** | ESG |  [optional]
**_7282** | **String** | Average Volume - The average daily trading volume over 90 days. |  [optional]
**_7283** | **
String** | Option Implied Vol. % - A prediction of how volatile an underlying will be in the future. At the market volatility estimated for a maturity thirty calendar days forward of the current trading day, and based on option prices from two consecutive expiration months.       |  [optional]
**_7284** | **String** | Historic Volume (30d) |  [optional]
**_7286** | [**BigDecimal**](BigDecimal.md) | Dividend Amount - Displays the amount of the next dividend. |  [optional]
**_7287** | **
String** | Dividend Yield % - This value is the toal of the expected dividend payments over the next twelve months per share divided by the Current Price and is expressed as a percentage. For derivatives, this displays the total of the expected dividend payments over the expiry date.  |  [optional]
**_7288** | **String** | Ex-date of the dividend |  [optional]
**_7289** | **String** | Market Cap |  [optional]
**_7290** | **String** | P/E |  [optional]
**_7293** | **String** | 52 Week High - The highest price for the past 52 weeks. |  [optional]
**_7294** | **String** | 52 Week Low - The lowest price for the past 52 weeks. |  [optional]
**_7295** | [**BigDecimal**](BigDecimal.md) | Open - Today&#39;s opening price. |  [optional]
**_7296** | [**BigDecimal**](BigDecimal.md) | Close - Today&#39;s closing price. |  [optional]
**_7331** | **String** | Reuters Fundamentals |  [optional]
**_7370** | **String** | ESG |  [optional]
**_7371** | **String** | ESG |  [optional]
**_7372** | **String** | ESG |  [optional]
**_7635** | **
String** | Mark - The mark price is, the ask price if ask is less than last price, the bid price if bid is more than the last price, otherwise it&#39;s equal to last price |  [optional]
**_7636** | [**BigDecimal**](BigDecimal.md) | shortable invetory |  [optional]
**_7637** | **String** | Fee rebate rate |  [optional]
**_7644** | **
String** | Shortable - Describes the level of difficulty with which the security can be sold short. |  [optional]
**_7674** | **String** | EMA(200) - Exponential moving average (N&#x3D;200). |  [optional]
**_7675** | **String** | EMA(100) - Exponential moving average (N&#x3D;100). |  [optional]
**_7676** | **String** | EMA(50) - Exponential moving average (N&#x3D;50). |  [optional]
**_7677** | **String** | EMA(20) - Exponential moving average (N&#x3D;20). |  [optional]
**_7681** | **
String** | Price/EMA(20) - Price to Exponential moving average (N&#x3D;20) ratio -1, displayed in percents. |  [optional]
**_7698** | **
String** | Last Yield - Implied yield of the bond if it is purchased at the current last price. Last yield is calculated using the Last price on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.  |  [optional]
**_7699** | **
String** | Bid Yield - Implied yield of the bond if it is purchased at the current bid price. Bid yield is calculated using the Ask on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.  |  [optional]
**_7718** | **String** | Beta - Beta is against standard index. |  [optional]
**_7720** | **
String** | Ask Yield - Implied yield of the bond if it is purchased at the current offer. Ask yield is calculated using the Bid on all possible call dates. It is assumed that prepayment occurs if the bond has call or put provisions and the issuer can offer a lower coupon rate based on current market rates. The yield to worst will be the lowest of the yield to maturity or yield to call (if the bond has prepayment provisions). Yield to worse may be the same as yield to maturity but never higher.  |  [optional]
**_7743** | **String** | Reuters Fundamentals |  [optional]
**_7761** | **String** | ESG |  [optional]
**_7992** | **String** | 26 Week High - The highest price for the past 26 weeks. |  [optional]
**_7993** | **String** | 26 Week Low - The lowest price for the past 26 weeks. |  [optional]
**_7994** | **String** | 13 Week High - The highest price for the past 13 weeks. |  [optional]
**_7995** | **String** | 13 Week Low - The lowest price for the past 13 weeks. |  [optional]
**conid** | **Integer** | IBKR Contract identifier |  [optional]
**minTick** | [**BigDecimal**](BigDecimal.md) | minimum price increment |  [optional]
**bboExchange** | **String** | Color for Best Bid/Offer Exchange in hex code |  [optional]
**hasDelayed** | **Boolean** | If market data field values return delayed |  [optional]
**sizeMinTick** | **Integer** | minimum size increment |  [optional]
**bestEligible** | **Integer** |  |  [optional]
**bestBidExch** | **Integer** |  |  [optional]
**bestAskExch** | **Integer** |  |  [optional]
**preOpenBid** | **Integer** |  |  [optional]
**lastAttribs** | **Integer** |  |  [optional]
**timestampBase** | **Integer** | Base time stamp for last update in format YYYYMMDD |  [optional]
**timestampDelta** | **Integer** |  |  [optional]
**lastExch** | **Integer** |  |  [optional]
**closeAttribs** | **Integer** |  |  [optional]



