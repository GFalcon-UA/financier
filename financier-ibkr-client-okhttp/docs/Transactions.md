# Transactions

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | will always be getTransactions |  [optional]
**currency** | **String** | same as request |  [optional]
**includesRealTime** | **
Boolean** | Indicates whether current day and realtime data is included in the result |  [optional]
**from** | [**BigDecimal**](BigDecimal.md) | Period start date. Epoch time, GMT |  [optional]
**to** | [**BigDecimal**](BigDecimal.md) | Period end date. Epoch time, GMT |  [optional]
**transactions** | **List&lt;Object&gt;** | Sorted by date descending |  [optional]



