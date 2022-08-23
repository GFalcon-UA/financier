# TradesApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAccountTradesGet**](TradesApi.md#iserverAccountTradesGet) | **
GET** /iserver/account/trades | List of Trades for the selected account

<a name="iserverAccountTradesGet"></a>

# **iserverAccountTradesGet**

> List&lt;Trade&gt; iserverAccountTradesGet()

List of Trades for the selected account

Returns a list of trades for the currently selected account for current day and six previous days. It is advised to call
this endpoint once per session.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.TradesApi;


TradesApi apiInstance = new TradesApi();
try {
    List<Trade> result = apiInstance.iserverAccountTradesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TradesApi#iserverAccountTradesGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Trade&gt;**](Trade.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

