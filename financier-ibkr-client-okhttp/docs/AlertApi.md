# AlertApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAccountAccountIdAlertActivatePost**](AlertApi.md#iserverAccountAccountIdAlertActivatePost) | **
POST** /iserver/account/{accountId}/alert/activate | Activate or deactivate an alert
[**iserverAccountAccountIdAlertAlertIdDelete**](AlertApi.md#iserverAccountAccountIdAlertAlertIdDelete) | **
DELETE** /iserver/account/{accountId}/alert/{alertId} | Delete an alert
[**iserverAccountAccountIdAlertPost**](AlertApi.md#iserverAccountAccountIdAlertPost) | **
POST** /iserver/account/{accountId}/alert | Create or modify alert
[**iserverAccountAccountIdAlertsGet**](AlertApi.md#iserverAccountAccountIdAlertsGet) | **
GET** /iserver/account/{accountId}/alerts | Get a list of available alerts
[**iserverAccountAlertIdGet**](AlertApi.md#iserverAccountAlertIdGet) | **
GET** /iserver/account/alert/{id} | Get details of an alert
[**iserverAccountMtaGet**](AlertApi.md#iserverAccountMtaGet) | **GET** /iserver/account/mta | Get MTA alert

<a name="iserverAccountAccountIdAlertActivatePost"></a>

# **iserverAccountAccountIdAlertActivatePost**

> Object iserverAccountAccountIdAlertActivatePost(accountId, body)

Activate or deactivate an alert

Please note, if alertId is 0, it will activate/deactivate all alerts

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
String accountId = "accountId_example"; // String | account id
Body body = new Body(); // Body | order request info
try {
    Object result = apiInstance.iserverAccountAccountIdAlertActivatePost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountAccountIdAlertActivatePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**Body**](.md)| order request info |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdAlertAlertIdDelete"></a>

# **iserverAccountAccountIdAlertAlertIdDelete**

> Object iserverAccountAccountIdAlertAlertIdDelete(accountId, alertId)

Delete an alert

Please be careful, if alertId is 0, it will delete all alerts

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
String accountId = "accountId_example"; // String | account id
String alertId = "alertId_example"; // String | alert id
try {
    Object result = apiInstance.iserverAccountAccountIdAlertAlertIdDelete(accountId, alertId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountAccountIdAlertAlertIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**alertId** | **String**| alert id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdAlertPost"></a>

# **iserverAccountAccountIdAlertPost**

> Object iserverAccountAccountIdAlertPost(accountId, body)

Create or modify alert

Please note here, DO NOT pass orderId when creating a new alert, toolId is only required for MTA alert

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
String accountId = "accountId_example"; // String | account id
AlertRequest body = new AlertRequest(); // AlertRequest | alert info
try {
    Object result = apiInstance.iserverAccountAccountIdAlertPost(accountId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountAccountIdAlertPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**body** | [**AlertRequest**](AlertRequest.md)| alert info |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAccountIdAlertsGet"></a>

# **iserverAccountAccountIdAlertsGet**

> List&lt;Object&gt; iserverAccountAccountIdAlertsGet(accountId)

Get a list of available alerts

The response will contain both active and inactive alerts, but it won&#39;t have MTA alert

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
String accountId = "accountId_example"; // String | account id
try {
    List<Object> result = apiInstance.iserverAccountAccountIdAlertsGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountAccountIdAlertsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountAlertIdGet"></a>

# **iserverAccountAlertIdGet**

> AlertResponse iserverAccountAlertIdGet(id)

Get details of an alert

Use the endpoint /iserver/account/:accountId/alerts to receive the alert id. The order_id in the response is the alert
id.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
String id = "id_example"; // String | alert id
try {
    AlertResponse result = apiInstance.iserverAccountAlertIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountAlertIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **String**| alert id |

### Return type

[**AlertResponse**](AlertResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountMtaGet"></a>

# **iserverAccountMtaGet**

> AlertResponse iserverAccountMtaGet()

Get MTA alert

Each login user only has one mobile trading assistant (MTA) alert with it&#39;s own unique tool id. The tool id cannot
be changed. When modified a new order Id is generated. MTA alerts can not be created or deleted. If you call delete
/iserver/account/:accountId/alert/:alertId, it will reset MTA to default.
See [here](https://www.interactivebrokers.com/en/software/mobileiphonemobile/mobileiphone.htm#monitor/trading-assistant.htm)
for more information on MTA alerts.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AlertApi;


AlertApi apiInstance = new AlertApi();
try {
    AlertResponse result = apiInstance.iserverAccountMtaGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlertApi#iserverAccountMtaGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**AlertResponse**](AlertResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

