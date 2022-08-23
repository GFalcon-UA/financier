# CcpBetaApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ccpAccountGet**](CcpBetaApi.md#ccpAccountGet) | **GET** /ccp/account | Brokerage Accounts
[**ccpAuthInitPost**](CcpBetaApi.md#ccpAuthInitPost) | **POST** /ccp/auth/init | Start CCP Session
[**ccpAuthResponsePost**](CcpBetaApi.md#ccpAuthResponsePost) | **POST** /ccp/auth/response | Complete CCP Session
[**ccpOrderDelete**](CcpBetaApi.md#ccpOrderDelete) | **DELETE** /ccp/order | Delete Order
[**ccpOrderPost**](CcpBetaApi.md#ccpOrderPost) | **POST** /ccp/order | Submit Order
[**ccpOrderPut**](CcpBetaApi.md#ccpOrderPut) | **PUT** /ccp/order | Update Order
[**ccpOrdersGet**](CcpBetaApi.md#ccpOrdersGet) | **GET** /ccp/orders | Order Status
[**ccpPositionsGet**](CcpBetaApi.md#ccpPositionsGet) | **GET** /ccp/positions | Positions
[**ccpStatusGet**](CcpBetaApi.md#ccpStatusGet) | **GET** /ccp/status | CCP Status
[**ccpTradesGet**](CcpBetaApi.md#ccpTradesGet) | **GET** /ccp/trades | Trades

<a name="ccpAccountGet"></a>

# **ccpAccountGet**

> Object ccpAccountGet()

Brokerage Accounts

Provides the list of tradeable accounts

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
try {
    Object result = apiInstance.ccpAccountGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpAccountGet");
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

<a name="ccpAuthInitPost"></a>

# **ccpAuthInitPost**

> Object ccpAuthInitPost(compete, locale, mac, machineId, username)

Start CCP Session

Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage session
to iServer is running then call the endpoint /logout first. Note at this time only order management is possible from CCP
session, market data and scanner endpoints can&#39;t be used since they are only available from iServer session. Work is
in progress to provide new CCP endpoints for market data and scanners.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
Boolean compete = true; // Boolean | Allow competing CCP session to run
String locale = "locale_example"; // String | Concatenate value for language and region, set to \"en_US\"
String mac = "mac_example"; // String | Local MAC Address
String machineId = "machineId_example"; // String | Local machine ID
String username = "username_example"; // String | Login user, set to dash \"-\"
try {
    Object result = apiInstance.ccpAuthInitPost(compete, locale, mac, machineId, username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpAuthInitPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**compete** | **Boolean**| Allow competing CCP session to run | [optional]
**locale** | **String**| Concatenate value for language and region, set to \&quot;en_US\&quot; | [optional]
**mac** | **String**| Local MAC Address | [optional]
**machineId** | **String**| Local machine ID | [optional]
**username** | **String**| Login user, set to dash \&quot;-\&quot; | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json

<a name="ccpAuthResponsePost"></a>

# **ccpAuthResponsePost**

> Object ccpAuthResponsePost(auth)

Complete CCP Session

Session Token Authentication

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
Auth auth = new Auth(); // Auth | 
try {
    Object result = apiInstance.ccpAuthResponsePost(auth);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpAuthResponsePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**auth** | [**Auth**](.md)|  | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="ccpOrderDelete"></a>

# **ccpOrderDelete**

> OrderData ccpOrderDelete(acct, id)

Delete Order

Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments as GET
is also supported (requires passing action&#x3D;delete) (GET is meant for development only)

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
String acct = "acct_example"; // String | Account Number
BigDecimal id = new BigDecimal(); // BigDecimal | Order Identifier of original submit order
try {
    OrderData result = apiInstance.ccpOrderDelete(acct, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpOrderDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**acct** | **String**| Account Number |
**id** | **BigDecimal**| Order Identifier of original submit order |

### Return type

[**OrderData**](OrderData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="ccpOrderPost"></a>

# **ccpOrderPost**

> OrderData ccpOrderPost(acct, conid, ccy, exchange, qty, type, side, price, tif)

Submit Order

Submits an Order.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
String acct = "acct_example"; // String | User Account
BigDecimal conid = new BigDecimal(); // BigDecimal | Contract identifier from IBKR's database.
String ccy = "ccy_example"; // String | Contract Currency
String exchange = "exchange_example"; // String | Exchange
BigDecimal qty = new BigDecimal(); // BigDecimal | Order Quantity
String type = "type_example"; // String | Order Price; required if order type is limit
String side = "side_example"; // String | Side
BigDecimal price = new BigDecimal(); // BigDecimal | Order Price; required if order type is limit
String tif = "tif_example"; // String | Time in Force
try {
    OrderData result = apiInstance.ccpOrderPost(acct, conid, ccy, exchange, qty, type, side, price, tif);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpOrderPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**acct** | **String**| User Account |
**conid** | **BigDecimal**| Contract identifier from IBKR&#39;s database. |
**ccy** | **String**| Contract Currency | [enum: USD, GBP, EUR]
**exchange** | **String**| Exchange | [enum: NYSE, CBOE, NYMEX]
**qty** | **BigDecimal**| Order Quantity |
**type** | **String**| Order Price; required if order type is limit | [optional] [enum: limit, market]
**side** | **String**| Side | [optional] [enum: sell, buy]
**price** | **BigDecimal**| Order Price; required if order type is limit | [optional]
**tif** | **String**| Time in Force | [optional] [enum: IOC, GTC]

### Return type

[**OrderData**](OrderData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="ccpOrderPut"></a>

# **ccpOrderPut**

> OrderData ccpOrderPut(acct, id)

Update Order

Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The status
of the order can be queried through GET /ccp/order.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
String acct = "acct_example"; // String | User Account
BigDecimal id = new BigDecimal(); // BigDecimal | Order ID to be modified
try {
    OrderData result = apiInstance.ccpOrderPut(acct, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpOrderPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**acct** | **String**| User Account |
**id** | **BigDecimal**| Order ID to be modified |

### Return type

[**OrderData**](OrderData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="ccpOrdersGet"></a>

# **ccpOrdersGet**

> Object ccpOrdersGet(acct, cancelled)

Order Status

Get status for all orders

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
String acct = "acct_example"; // String | User Account
Boolean cancelled = true; // Boolean | Return only Rejected or Cancelled orders since today midnight
try {
    Object result = apiInstance.ccpOrdersGet(acct, cancelled);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpOrdersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**acct** | **String**| User Account |
**cancelled** | **Boolean**| Return only Rejected or Cancelled orders since today midnight | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="ccpPositionsGet"></a>

# **ccpPositionsGet**

> PositionData ccpPositionsGet()

Positions

List of positions

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
try {
    PositionData result = apiInstance.ccpPositionsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpPositionsGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**PositionData**](PositionData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="ccpStatusGet"></a>

# **ccpStatusGet**

> Object ccpStatusGet()

CCP Status

Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage session to
CCP by sending /auth/init and response.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
try {
    Object result = apiInstance.ccpStatusGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpStatusGet");
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

<a name="ccpTradesGet"></a>

# **ccpTradesGet**

> Object ccpTradesGet(from, to)

Trades

Get a list of Trades, by default, the list is from today midnight to Date.now().

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.CcpBetaApi;


CcpBetaApi apiInstance = new CcpBetaApi();
String from = "from_example"; // String | From Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..)
String to = "to_example"; // String | To Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..). To value should be bigger than from value. 
try {
    Object result = apiInstance.ccpTradesGet(from, to);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CcpBetaApi#ccpTradesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**from** | **String**| From Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..) | [optional]
**to** | **
String**| To Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..). To value should be bigger than from value.  | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

