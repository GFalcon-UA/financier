# OrderApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAccountAccountIdOrderOrderIdDelete**](OrderApi.md#iserverAccountAccountIdOrderOrderIdDelete) | **
DELETE** /iserver/account/{accountId}/order/{orderId} | Cancel Order
[**iserverAccountAccountIdOrderOrderIdPost**](OrderApi.md#iserverAccountAccountIdOrderOrderIdPost) | **
POST** /iserver/account/{accountId}/order/{orderId} | Modify Order
[**iserverAccountAccountIdOrderPost**](OrderApi.md#iserverAccountAccountIdOrderPost) | **
POST** /iserver/account/{accountId}/order | Place Order (Deprecated)
[**iserverAccountAccountIdOrderWhatifPost**](OrderApi.md#iserverAccountAccountIdOrderWhatifPost) | **
POST** /iserver/account/{accountId}/order/whatif | Preview Order (Deprecated)
[**iserverAccountAccountIdOrdersPost**](OrderApi.md#iserverAccountAccountIdOrdersPost) | **
POST** /iserver/account/{accountId}/orders | Place Orders
[**iserverAccountAccountIdOrdersWhatifPost**](OrderApi.md#iserverAccountAccountIdOrdersWhatifPost) | **
POST** /iserver/account/{accountId}/orders/whatif | Preview Orders
[**iserverAccountOrderStatusOrderIdGet**](OrderApi.md#iserverAccountOrderStatusOrderIdGet) | **
GET** /iserver/account/order/status/{orderId} | Order Status
[**iserverAccountOrdersFaGroupPost**](OrderApi.md#iserverAccountOrdersFaGroupPost) | **
POST** /iserver/account/orders/{faGroup} | Place Orders for FA
[**iserverAccountOrdersGet**](OrderApi.md#iserverAccountOrdersGet) | **GET** /iserver/account/orders | Live Orders
[**iserverReplyReplyidPost**](OrderApi.md#iserverReplyReplyidPost) | **
POST** /iserver/reply/{replyid} | Place Order Reply

<a name="iserverAccountAccountIdOrderOrderIdDelete"></a>

# **iserverAccountAccountIdOrderOrderIdDelete**

> Object iserverAccountAccountIdOrderOrderIdDelete(accountId, orderId)

Cancel Order

Cancels an open order. Must call /iserver/accounts endpoint prior to cancelling an order. Use /iservers/account/orders
endpoint to review open-order(s) and get latest order status.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id, or fa group if deleting a group order
String orderId = "orderId_example"; // String | Customer order id, use /iservers/account/orders endpoint to query orderId.
try {
    Object result = apiInstance.iserverAccountAccountIdOrderOrderIdDelete(accountId, orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrderOrderIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id, or fa group if deleting a group order |
**orderId** | **String**| Customer order id, use /iservers/account/orders endpoint to query orderId. |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdOrderOrderIdPost"></a>

# **iserverAccountAccountIdOrderOrderIdPost**

> List&lt;Object&gt; iserverAccountAccountIdOrderOrderIdPost(accountId, orderId, body)

Modify Order

Modifies an open order. Must call /iserver/accounts endpoint prior to modifying an order. Use /iservers/account/orders
endpoint to review open-order(s).

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id, or fa group if modifying a group order
String orderId = "orderId_example"; // String | Customer order id, use /iservers/account/orders endpoint to query orderId.
ModifyOrder body = new ModifyOrder(); // ModifyOrder | modify-order request
try {
    List<Object> result = apiInstance.iserverAccountAccountIdOrderOrderIdPost(accountId, orderId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrderOrderIdPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id, or fa group if modifying a group order |
**orderId** | **String**| Customer order id, use /iservers/account/orders endpoint to query orderId. |
**body** | [**ModifyOrder**](ModifyOrder.md)| modify-order request |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdOrderPost"></a>

# **iserverAccountAccountIdOrderPost**

> List&lt;Object&gt; iserverAccountAccountIdOrderPost(accountId, body)

Place Order (Deprecated)

This endpoint is going to be deprecated, you can use /iserver/account/{accountId}/orders, just pass one order in the
array, the order structure will be same. Please note here, sometimes this endpoint alone can&#39;t make sure you submit
the order successfully, you could receive some questions in the response, you have to to answer them in order to submit
the order successfully. You can use \&quot;/iserver/reply/{replyid}\&quot; endpoint to answer questions

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id
OrderRequest body = new OrderRequest(); // OrderRequest | order request info
try {
    List<Object> result = apiInstance.iserverAccountAccountIdOrderPost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrderPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**OrderRequest**](OrderRequest.md)| order request info |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdOrderWhatifPost"></a>

# **iserverAccountAccountIdOrderWhatifPost**

> Object iserverAccountAccountIdOrderWhatifPost(accountId, body)

Preview Order (Deprecated)

This end-point is going to be deprecated, you can use /iserver/account/{accountId}/orders/whatif, just pass one order in
the array, the order structure will be same. This endpoint allows you to preview order without actually submitting the
order and you can get commission information in the response.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id
OrderRequest body = new OrderRequest(); // OrderRequest | order info
try {
    Object result = apiInstance.iserverAccountAccountIdOrderWhatifPost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrderWhatifPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**OrderRequest**](OrderRequest.md)| order info |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdOrdersPost"></a>

# **iserverAccountAccountIdOrdersPost**

> List&lt;Object&gt; iserverAccountAccountIdOrdersPost(accountId, body)

Place Orders

When connected to an IServer Brokerage Session, this endpoint will allow you to submit orders. CP WEB API supports
various advanced orderTypes, for additional details and examples refer
to [IBKR Quant Blog](https://www.tradersinsight.news/category/ibkr-quant-news/programming_languages/rest-development/).
* Bracket - Attach additional opposite-side order(s) by using a single **cOID** sent with the parent and set the same
value for **parentId** in each child order(s). * Cash Quantity - Send orders using monetary value by specifying **
cashQty** instead of quantity, e.g. cashQty: 200. The endpoint /iserver/contract/rules returns list of valid orderTypes
in cqtTypes. * Currency Conversion - Convert cash from one currency to another by including **isCcyConv** &#x3D; **
true**. To specify the cash quantity use **fxQTY** instead of quantity, e.g. fxQTY: 100. * Fractional - Contracts that
support fractional shares can be traded by specifying **quantity** as a float, e.g. quantity: 0.001. The endpoint
/iserver/contract/rules returns a list of valid orderTypes in fraqTypes. * IB Algos - Attached user-defined settings to
your trades by using any of IBKR&#39;s Algo Orders. Use the endpoint /iserver/contract/{conid}/algos to identify the
available strategies for a contract. * One-Cancels-All (OCA) - Group multiple unrelated orders by passing order request
info in an array and including **isSingleGroup &#x3D; true** for each order. All orders will be assigned the same
oca_group_id.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id
Body body = new Body(); // Body | order request info
try {
    List<Object> result = apiInstance.iserverAccountAccountIdOrdersPost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrdersPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**Body**](.md)| order request info |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdOrdersWhatifPost"></a>

# **iserverAccountAccountIdOrdersWhatifPost**

> Object iserverAccountAccountIdOrdersWhatifPost(accountId, body)

Preview Orders

This endpoint allows you to preview order without actually submitting the order and you can get commission information
in the response. Also supports bracket orders.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String accountId = "accountId_example"; // String | account id
Body body = new Body(); // Body | order info
try {
    Object result = apiInstance.iserverAccountAccountIdOrdersWhatifPost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountAccountIdOrdersWhatifPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**Body**](.md)| order info |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountOrderStatusOrderIdGet"></a>

# **iserverAccountOrderStatusOrderIdGet**

> OrderStatus iserverAccountOrderStatusOrderIdGet(orderId)

Order Status

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String orderId = "orderId_example"; // String | Customer order id, use /iservers/account/orders endpoint to query orderId.
try {
    OrderStatus result = apiInstance.iserverAccountOrderStatusOrderIdGet(orderId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountOrderStatusOrderIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**orderId** | **String**| Customer order id, use /iservers/account/orders endpoint to query orderId. |

### Return type

[**OrderStatus**](OrderStatus.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountOrdersFaGroupPost"></a>

# **iserverAccountOrdersFaGroupPost**

> List&lt;Object&gt; iserverAccountOrdersFaGroupPost(faGroup, body)

Place Orders for FA

Financial Advisors can use this endpoint to place an order for a specified group. To place an order for a specified
account use the endpoint /iserver/account/{accountId}/order. More information about groups can be found in
the [TWS Users&#39; Guide:](https://guides.interactivebrokers.com/twsguide/twsguide.htm#usersguidebook/financialadvisors/create_an_account_group_for_share_allocation.htm)
.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String faGroup = "faGroup_example"; // String | financial advisor group
OrderRequest body = new OrderRequest(); // OrderRequest | order request info
try {
    List<Object> result = apiInstance.iserverAccountOrdersFaGroupPost(faGroup, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountOrdersFaGroupPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**faGroup** | **String**| financial advisor group |
**body** | [**OrderRequest**](OrderRequest.md)| order request info |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountOrdersGet"></a>

# **iserverAccountOrdersGet**

> Object iserverAccountOrdersGet(body)

Live Orders

The endpoint is meant to be used in polling mode, e.g. requesting every x seconds. The response will contain two
objects, one is notification, the other is orders. Orders is the list of live orders (cancelled, filled, submitted).
Notifications contains information about execute orders as they happen, see status field. To receive streaming live
orders the endpoint /ws can be used. Refer
to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
Body body = new Body(); // Body | an array of filters
try {
    Object result = apiInstance.iserverAccountOrdersGet(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverAccountOrdersGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| an array of filters | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverReplyReplyidPost"></a>

# **iserverReplyReplyidPost**

> List&lt;Object&gt; iserverReplyReplyidPost(replyid, body)

Place Order Reply

Reply to questions when placing orders and submit orders

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.OrderApi;


OrderApi apiInstance = new OrderApi();
String replyid = "replyid_example"; // String | Please use the \"id\" from the response of \"Place Order\" endpoint
Body body = new Body(); // Body | Answer to question
try {
    List<Object> result = apiInstance.iserverReplyReplyidPost(replyid, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrderApi#iserverReplyReplyidPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**replyid** | **String**| Please use the \&quot;id\&quot; from the response of \&quot;Place Order\&quot; endpoint |
**body** | [**Body**](.md)| Answer to question |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

