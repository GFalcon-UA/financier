# ModifyOrder

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acctId** | **String** |  |  [optional]
**conid** | **Integer** |  |  [optional]
**orderType** | **String** | for example LMT |  [optional]
**outsideRTH** | **Boolean** |  |  [optional]
**price** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**auxPrice** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**side** | **String** | SELL or BUY |  [optional]
**listingExchange** | **String** | optional, not required |  [optional]
**ticker** | **String** | The ticker symbol of the original place order |  [optional]
**tif** | **
String** | Specify a time in force to change how long your order will continue to work in the market |  [optional]
**quantity** | [**
BigDecimal**](BigDecimal.md) | usually integer, for some special cases can be float numbers |  [optional]
**deactivated** | **
Boolean** | Set to true if you want to pause a working order. For details refer to the [TWS Users&#39; Guide:](https://guides.interactivebrokers.com/tws/twsguide.html#usersguidebook/getstarted/pause_execution.htm)  |  [optional]



