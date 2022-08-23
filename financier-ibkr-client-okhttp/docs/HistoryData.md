# HistoryData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**symbol** | **String** | Underlying symbol |  [optional]
**text** | **String** | companyName |  [optional]
**priceFactor** | **Integer** | priceFactor is price increment obtained from display rule |  [optional]
**startTime** | **String** | start date time in the format YYYYMMDD-HH:mm:ss |  [optional]
**high** | **
String** | High value during this time series with format %h/%v/%t. %h is the high price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume &#x3D; actual volume/100)) and %t is minutes from start time of the chart  |  [optional]
**low** | **
String** | Low value during this time series with format %l/%v/%t. %l is the low price (scaled by priceFactor), %v is volume (volume factor will always be 100 (reported volume &#x3D; actual volume/100)) and %t is minutes from start time of the chart  |  [optional]
**timePeriod** | **String** | The duration for the historical data request |  [optional]
**barLength** | **Integer** | The number of seconds in a bar |  [optional]
**mdAvailability** | **
String** | Market Data Availability. The field may contain two chars. The first char is the primary code: S &#x3D; Streaming, R &#x3D; Realtime, D &#x3D; Delayed, Z &#x3D; Frozen, Y &#x3D; Frozen Delayed. The second char is the secondary code: P &#x3D; Snapshot Available, p &#x3D; Consolidated.  |  [optional]
**mktDataDelay** | **
Integer** | The time it takes, in milliseconds, to process the historical data request |  [optional]
**outsideRth** | **Boolean** | The historical data returned includes outside of regular trading hours  |  [optional]
**tradingDayDuration** | **Integer** | The number of seconds in the trading day |  [optional]
**volumeFactor** | **Integer** |  |  [optional]
**priceDisplayRule** | **Integer** |  |  [optional]
**priceDisplayValue** | **String** |  |  [optional]
**negativeCapable** | **Boolean** |  |  [optional]
**messageVersion** | **Integer** |  |  [optional]
**data** | **List&lt;Object&gt;** |  |  [optional]
**points** | **Integer** | total number of points |  [optional]
**travelTime** | **Integer** |  |  [optional]



