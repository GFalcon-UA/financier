# SessionApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAuthStatusPost**](SessionApi.md#iserverAuthStatusPost) | **POST** /iserver/auth/status | Authentication Status
[**iserverReauthenticatePost**](SessionApi.md#iserverReauthenticatePost) | **
POST** /iserver/reauthenticate | Tries to re-authenticate to Brokerage
[**logoutPost**](SessionApi.md#logoutPost) | **POST** /logout | Ends the current session
[**ssoValidateGet**](SessionApi.md#ssoValidateGet) | **GET** /sso/validate | Validate SSO
[**ticklePost**](SessionApi.md#ticklePost) | **POST** /tickle | Ping the server to keep the session open

<a name="iserverAuthStatusPost"></a>

# **iserverAuthStatusPost**

> AuthStatus iserverAuthStatusPost()

Authentication Status

Current Authentication status to the Brokerage system. Market Data and Trading is not possible if not authenticated,
e.g. authenticated shows false

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.SessionApi;


SessionApi apiInstance = new SessionApi();
try {
    AuthStatus result = apiInstance.iserverAuthStatusPost();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#iserverAuthStatusPost");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**AuthStatus**](AuthStatus.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverReauthenticatePost"></a>

# **iserverReauthenticatePost**

> AuthStatus iserverReauthenticatePost()

Tries to re-authenticate to Brokerage

When using the CP Gateway, this endpoint provides a way to reauthenticate to the Brokerage system as long as there is a
valid SSO session, see /sso/validate.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.SessionApi;


SessionApi apiInstance = new SessionApi();
try {
    AuthStatus result = apiInstance.iserverReauthenticatePost();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#iserverReauthenticatePost");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**AuthStatus**](AuthStatus.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="logoutPost"></a>

# **logoutPost**

> Object logoutPost()

Ends the current session

Logs the user out of the gateway session. Any further activity requires re-authentication.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.SessionApi;


SessionApi apiInstance = new SessionApi();
try {
    Object result = apiInstance.logoutPost();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#logoutPost");
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

<a name="ssoValidateGet"></a>

# **ssoValidateGet**

> Object ssoValidateGet()

Validate SSO

Validates the current session for the SSO user

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.SessionApi;


SessionApi apiInstance = new SessionApi();
try {
    Object result = apiInstance.ssoValidateGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#ssoValidateGet");
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

<a name="ticklePost"></a>

# **ticklePost**

> ticklePost()

Ping the server to keep the session open

If the gateway has not received any requests for several minutes an open session will automatically timeout. The tickle
endpoint pings the server to prevent the session from ending.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.SessionApi;


SessionApi apiInstance = new SessionApi();
try {
    apiInstance.ticklePost();
} catch (ApiException e) {
    System.err.println("Exception when calling SessionApi#ticklePost");
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

