# MarketDataBetaApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**hmdsHistoryGet**](MarketDataBetaApi.md#hmdsHistoryGet) | **GET** /hmds/history | Market Data History

<a name="hmdsHistoryGet"></a>

# **hmdsHistoryGet**

> HistoryResult hmdsHistoryGet(conid, period, bar, outsideRth)

Market Data History

Using direct to market data farm connection, will provide a list of historical market data for a given conid

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataBetaApi;


MarketDataBetaApi apiInstance = new MarketDataBetaApi();
Integer conid = 56; // Integer | contract id
String period = "period_example"; // String | Time period for history request.    * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months   * y: Years 
String bar = "bar_example"; // String | Duration of time for each candlestick bar.   * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months 
Boolean outsideRth = true; // Boolean | For contracts that support it, will determine if history data includes outside of regular trading hours.
try {
    HistoryResult result = apiInstance.hmdsHistoryGet(conid, period, bar, outsideRth);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataBetaApi#hmdsHistoryGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **Integer**| contract id |
**period** | **
String**| Time period for history request.    * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months   * y: Years  | [enum: min, h, d, w, m, y]
**bar** | **
String**| Duration of time for each candlestick bar.   * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months  | [optional] [enum: min, h, d, w, m]
**outsideRth** | **
Boolean**| For contracts that support it, will determine if history data includes outside of regular trading hours. | [optional]

### Return type

[**HistoryResult**](HistoryResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

