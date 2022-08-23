# StreamingApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**wsPost**](StreamingApi.md#wsPost) | **POST** /ws | Websocket Endpoint

<a name="wsPost"></a>

# **wsPost**

> wsPost()

Websocket Endpoint

The streaming API is documented
under [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.StreamingApi;


StreamingApi apiInstance = new StreamingApi();
try {
    apiInstance.wsPost();
} catch (ApiException e) {
    System.err.println("Exception when calling StreamingApi#wsPost");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

