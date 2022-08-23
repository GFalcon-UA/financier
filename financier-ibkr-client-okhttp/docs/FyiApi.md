# FyiApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fyiDeliveryoptionsDeviceIdDelete**](FyiApi.md#fyiDeliveryoptionsDeviceIdDelete) | **
DELETE** /fyi/deliveryoptions/{deviceId} | Delete a device
[**fyiDeliveryoptionsDevicePost**](FyiApi.md#fyiDeliveryoptionsDevicePost) | **
POST** /fyi/deliveryoptions/device | Enable/Disable device option
[**fyiDeliveryoptionsEmailPut**](FyiApi.md#fyiDeliveryoptionsEmailPut) | **
PUT** /fyi/deliveryoptions/email | Enable/Disable email option
[**fyiDeliveryoptionsGet**](FyiApi.md#fyiDeliveryoptionsGet) | **GET** /fyi/deliveryoptions | Get delivery options
[**fyiDisclaimerTypecodeGet**](FyiApi.md#fyiDisclaimerTypecodeGet) | **
GET** /fyi/disclaimer/{typecode} | Get disclaimer for a certain kind of fyi
[**fyiDisclaimerTypecodePut**](FyiApi.md#fyiDisclaimerTypecodePut) | **
PUT** /fyi/disclaimer/{typecode} | Mark disclaimer read
[**fyiNotificationsGet**](FyiApi.md#fyiNotificationsGet) | **GET** /fyi/notifications | Get a list of notifications
[**fyiNotificationsMoreGet**](FyiApi.md#fyiNotificationsMoreGet) | **
GET** /fyi/notifications/more | Get more notifications based on a certain one
[**fyiNotificationsNotificationIdPut**](FyiApi.md#fyiNotificationsNotificationIdPut) | **
PUT** /fyi/notifications/{notificationId} | Get a list of notifications
[**fyiSettingsGet**](FyiApi.md#fyiSettingsGet) | **GET** /fyi/settings | Get a list of subscriptions
[**fyiSettingsTypecodePost**](FyiApi.md#fyiSettingsTypecodePost) | **
POST** /fyi/settings/{typecode} | Enable/Disable certain subscription
[**fyiUnreadnumberGet**](FyiApi.md#fyiUnreadnumberGet) | **
GET** /fyi/unreadnumber | Get unread number of fyis. The HTTP method POST is also supported.

<a name="fyiDeliveryoptionsDeviceIdDelete"></a>

# **fyiDeliveryoptionsDeviceIdDelete**

> Object fyiDeliveryoptionsDeviceIdDelete(deviceId)

Delete a device

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String deviceId = "deviceId_example"; // String | device ID
try {
    Object result = apiInstance.fyiDeliveryoptionsDeviceIdDelete(deviceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDeliveryoptionsDeviceIdDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**deviceId** | **String**| device ID |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiDeliveryoptionsDevicePost"></a>

# **fyiDeliveryoptionsDevicePost**

> Object fyiDeliveryoptionsDevicePost(body)

Enable/Disable device option

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
Body body = new Body(); // Body | device info
try {
    Object result = apiInstance.fyiDeliveryoptionsDevicePost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDeliveryoptionsDevicePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| device info |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiDeliveryoptionsEmailPut"></a>

# **fyiDeliveryoptionsEmailPut**

> Object fyiDeliveryoptionsEmailPut(enabled)

Enable/Disable email option

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String enabled = "enabled_example"; // String | true/false
try {
    Object result = apiInstance.fyiDeliveryoptionsEmailPut(enabled);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDeliveryoptionsEmailPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**enabled** | **String**| true/false |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiDeliveryoptionsGet"></a>

# **fyiDeliveryoptionsGet**

> Object fyiDeliveryoptionsGet()

Get delivery options

options for sending fyis to email and other devices

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
try {
    Object result = apiInstance.fyiDeliveryoptionsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDeliveryoptionsGet");
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

<a name="fyiDisclaimerTypecodeGet"></a>

# **fyiDisclaimerTypecodeGet**

> Object fyiDisclaimerTypecodeGet(typecode)

Get disclaimer for a certain kind of fyi

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String typecode = "typecode_example"; // String | fyi code, for example --M8, EA
try {
    Object result = apiInstance.fyiDisclaimerTypecodeGet(typecode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDisclaimerTypecodeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**typecode** | **String**| fyi code, for example --M8, EA |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiDisclaimerTypecodePut"></a>

# **fyiDisclaimerTypecodePut**

> Object fyiDisclaimerTypecodePut(typecode)

Mark disclaimer read

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String typecode = "typecode_example"; // String | fyi code, for example --M8, EA
try {
    Object result = apiInstance.fyiDisclaimerTypecodePut(typecode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiDisclaimerTypecodePut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**typecode** | **String**| fyi code, for example --M8, EA |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiNotificationsGet"></a>

# **fyiNotificationsGet**

> Notifications fyiNotificationsGet(max, exclude, include)

Get a list of notifications

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String max = "max_example"; // String | max number of fyis in response
String exclude = "exclude_example"; // String | if set, don't set include
String include = "include_example"; // String | if set, don't set exclude
try {
    Notifications result = apiInstance.fyiNotificationsGet(max, exclude, include);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiNotificationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**max** | **String**| max number of fyis in response |
**exclude** | **String**| if set, don&#39;t set include | [optional]
**include** | **String**| if set, don&#39;t set exclude | [optional]

### Return type

[**Notifications**](Notifications.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiNotificationsMoreGet"></a>

# **fyiNotificationsMoreGet**

> Notifications fyiNotificationsMoreGet(id)

Get more notifications based on a certain one

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String id = "id_example"; // String | id of last notification in the list
try {
    Notifications result = apiInstance.fyiNotificationsMoreGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiNotificationsMoreGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | **String**| id of last notification in the list |

### Return type

[**Notifications**](Notifications.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiNotificationsNotificationIdPut"></a>

# **fyiNotificationsNotificationIdPut**

> Object fyiNotificationsNotificationIdPut(notificationId)

Get a list of notifications

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String notificationId = "notificationId_example"; // String | mark a notification read
try {
    Object result = apiInstance.fyiNotificationsNotificationIdPut(notificationId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiNotificationsNotificationIdPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**notificationId** | **String**| mark a notification read |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiSettingsGet"></a>

# **fyiSettingsGet**

> List&lt;Object&gt; fyiSettingsGet()

Get a list of subscriptions

Return the current choices of subscriptions, we can toggle the option

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
try {
    List<Object> result = apiInstance.fyiSettingsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiSettingsGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiSettingsTypecodePost"></a>

# **fyiSettingsTypecodePost**

> Object fyiSettingsTypecodePost(typecode, body)

Enable/Disable certain subscription

Configure which typecode you would like to enable/disable.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
String typecode = "typecode_example"; // String | fyi code
Body body = new Body(); // Body | 
try {
    Object result = apiInstance.fyiSettingsTypecodePost(typecode, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiSettingsTypecodePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**typecode** | **String**| fyi code |
**body** | [**Body**](.md)|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="fyiUnreadnumberGet"></a>

# **fyiUnreadnumberGet**

> Object fyiUnreadnumberGet()

Get unread number of fyis. The HTTP method POST is also supported.

Returns the total number of unread fyis

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.FyiApi;


FyiApi apiInstance = new FyiApi();
try {
    Object result = apiInstance.fyiUnreadnumberGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FyiApi#fyiUnreadnumberGet");
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

