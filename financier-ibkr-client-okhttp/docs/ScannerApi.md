# ScannerApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**hmdsScannerPost**](ScannerApi.md#hmdsScannerPost) | **POST** /hmds/scanner | Run Scanner (Beta)
[**iserverScannerParamsGet**](ScannerApi.md#iserverScannerParamsGet) | **
GET** /iserver/scanner/params | Scanner Parameters
[**iserverScannerRunPost**](ScannerApi.md#iserverScannerRunPost) | **
POST** /iserver/scanner/run | run scanner to get a list of contracts

<a name="hmdsScannerPost"></a>

# **hmdsScannerPost**

> ScannerResult hmdsScannerPost(body)

Run Scanner (Beta)

Using a direct connection to the market data farm, will provide results to the requested scanner.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ScannerApi;


ScannerApi apiInstance = new ScannerApi();
Body body = new Body(); // Body | request body
try {
    ScannerResult result = apiInstance.hmdsScannerPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScannerApi#hmdsScannerPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| request body |

### Return type

[**ScannerResult**](ScannerResult.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverScannerParamsGet"></a>

# **iserverScannerParamsGet**

> Object iserverScannerParamsGet()

Scanner Parameters

Returns an object contains four lists contain all parameters for scanners

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ScannerApi;


ScannerApi apiInstance = new ScannerApi();
try {
    Object result = apiInstance.iserverScannerParamsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScannerApi#iserverScannerParamsGet");
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

<a name="iserverScannerRunPost"></a>

# **iserverScannerRunPost**

> List&lt;Object&gt; iserverScannerRunPost(body)

run scanner to get a list of contracts

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ScannerApi;


ScannerApi apiInstance = new ScannerApi();
ScannerParams body = new ScannerParams(); // ScannerParams | scanner-params request
try {
    List<Object> result = apiInstance.iserverScannerRunPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScannerApi#iserverScannerRunPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**ScannerParams**](ScannerParams.md)| scanner-params request |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

