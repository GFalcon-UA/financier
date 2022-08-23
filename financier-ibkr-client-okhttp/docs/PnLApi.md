# PnLApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAccountPnlPartitionedGet**](PnLApi.md#iserverAccountPnlPartitionedGet) | **
GET** /iserver/account/pnl/partitioned | PnL for the selected account

<a name="iserverAccountPnlPartitionedGet"></a>

# **iserverAccountPnlPartitionedGet**

> Object iserverAccountPnlPartitionedGet()

PnL for the selected account

Returns an object containing PnL for the selected account and its models (if any). To receive streaming PnL the endpoint
/ws can be used. Refer
to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PnLApi;


PnLApi apiInstance = new PnLApi();
try {
    Object result = apiInstance.iserverAccountPnlPartitionedGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PnLApi#iserverAccountPnlPartitionedGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

