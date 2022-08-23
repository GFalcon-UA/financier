# PortfolioApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**portfolioAccountIdAllocationGet**](PortfolioApi.md#portfolioAccountIdAllocationGet) | **
GET** /portfolio/{accountId}/allocation | Account Allocation
[**portfolioAccountIdLedgerGet**](PortfolioApi.md#portfolioAccountIdLedgerGet) | **
GET** /portfolio/{accountId}/ledger | Account Ledger
[**portfolioAccountIdMetaGet**](PortfolioApi.md#portfolioAccountIdMetaGet) | **
GET** /portfolio/{accountId}/meta | Account Information
[**portfolioAccountIdPositionConidGet**](PortfolioApi.md#portfolioAccountIdPositionConidGet) | **
GET** /portfolio/{accountId}/position/{conid} | Position by Conid
[**portfolioAccountIdPositionsInvalidatePost**](PortfolioApi.md#portfolioAccountIdPositionsInvalidatePost) | **
POST** /portfolio/{accountId}/positions/invalidate | Invalidates the backend cache of the Portfolio
[**portfolioAccountIdPositionsPageIdGet**](PortfolioApi.md#portfolioAccountIdPositionsPageIdGet) | **
GET** /portfolio/{accountId}/positions/{pageId} | Portfolio Positions
[**portfolioAccountIdSummaryGet**](PortfolioApi.md#portfolioAccountIdSummaryGet) | **
GET** /portfolio/{accountId}/summary | Account Summary
[**portfolioAccountsGet**](PortfolioApi.md#portfolioAccountsGet) | **GET** /portfolio/accounts | Portfolio Accounts
[**portfolioAllocationPost**](PortfolioApi.md#portfolioAllocationPost) | **
POST** /portfolio/allocation | Account Alloction (All Accounts)
[**portfolioPositionsConidGet**](PortfolioApi.md#portfolioPositionsConidGet) | **
GET** /portfolio/positions/{conid} | Positions by Conid
[**portfolioSubaccountsGet**](PortfolioApi.md#portfolioSubaccountsGet) | **
GET** /portfolio/subaccounts | List of Sub-Accounts

<a name="portfolioAccountIdAllocationGet"></a>

# **portfolioAccountIdAllocationGet**

> Allocation portfolioAccountIdAllocationGet(accountId)

Account Allocation

Information about the account&#39;s portfolio allocation by Asset Class, Industry and Category. /portfolio/accounts or
/portfolio/subaccounts must be called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
try {
    Allocation result = apiInstance.portfolioAccountIdAllocationGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdAllocationGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

[**Allocation**](Allocation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdLedgerGet"></a>

# **portfolioAccountIdLedgerGet**

> Object portfolioAccountIdLedgerGet(accountId)

Account Ledger

Information regarding settled cash, cash balances, etc. in the account&#39;s base currency and any other cash balances
hold in other currencies. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint. The list
of supported currencies is available at https://www.interactivebrokers.com/en/index.php?f&#x3D;3185.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
try {
    Object result = apiInstance.portfolioAccountIdLedgerGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdLedgerGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdMetaGet"></a>

# **portfolioAccountIdMetaGet**

> Accounts portfolioAccountIdMetaGet(accountId)

Account Information

Account information related to account Id /portfolio/accounts or /portfolio/subaccounts must be called prior to this
endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
try {
    Accounts result = apiInstance.portfolioAccountIdMetaGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdMetaGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

[**Accounts**](Accounts.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdPositionConidGet"></a>

# **portfolioAccountIdPositionConidGet**

> Position portfolioAccountIdPositionConidGet(accountId, conid)

Position by Conid

Returns a list of all positions matching the conid. For portfolio models the conid could be in more than one model,
returning an array with the name of the model it belongs to. /portfolio/accounts or /portfolio/subaccounts must be
called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
Integer conid = 56; // Integer | contract id
try {
    Position result = apiInstance.portfolioAccountIdPositionConidGet(accountId, conid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdPositionConidGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**conid** | **Integer**| contract id |

### Return type

[**Position**](Position.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdPositionsInvalidatePost"></a>

# **portfolioAccountIdPositionsInvalidatePost**

> Object portfolioAccountIdPositionsInvalidatePost(accountId)

Invalidates the backend cache of the Portfolio

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
try {
    Object result = apiInstance.portfolioAccountIdPositionsInvalidatePost(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdPositionsInvalidatePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdPositionsPageIdGet"></a>

# **portfolioAccountIdPositionsPageIdGet**

> Position portfolioAccountIdPositionsPageIdGet(accountId, pageId, model, sort, direction, period)

Portfolio Positions

Returns a list of positions for the given account. The endpoint supports paging, page&#39;s default size is 30
positions. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
String pageId = "pageId_example"; // String | page id
String model = "model_example"; // String | optional
String sort = "sort_example"; // String | declare the table to be sorted by which column
String direction = "direction_example"; // String | in which order, a means ascending - d means descending
String period = "period_example"; // String | period for pnl column, can be 1D, 7D, 1M...
try {
    Position result = apiInstance.portfolioAccountIdPositionsPageIdGet(accountId, pageId, model, sort, direction, period);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdPositionsPageIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |
**pageId** | **String**| page id |
**model** | **String**| optional | [optional]
**sort** | **String**| declare the table to be sorted by which column | [optional]
**direction** | **String**| in which order, a means ascending - d means descending | [optional]
**period** | **String**| period for pnl column, can be 1D, 7D, 1M... | [optional]

### Return type

[**Position**](Position.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountIdSummaryGet"></a>

# **portfolioAccountIdSummaryGet**

> Object portfolioAccountIdSummaryGet(accountId)

Account Summary

Returns information about margin, cash balances and other information related to specified account. See also
/portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
String accountId = "accountId_example"; // String | account id
try {
    Object result = apiInstance.portfolioAccountIdSummaryGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountIdSummaryGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**accountId** | **String**| account id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAccountsGet"></a>

# **portfolioAccountsGet**

> Accounts portfolioAccountsGet()

Portfolio Accounts

In non-tiered account structures, returns a list of accounts for which the user can view position and account
information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For querying a
list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered account
structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
try {
    Accounts result = apiInstance.portfolioAccountsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAccountsGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Accounts**](Accounts.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioAllocationPost"></a>

# **portfolioAllocationPost**

> Allocation portfolioAllocationPost(body)

Account Alloction (All Accounts)

Similar to /portfolio/{accountId}/allocation but returns a consolidated view of of all the accounts returned by
/portfolio/accounts. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
Body body = new Body(); // Body | accounts info
try {
    Allocation result = apiInstance.portfolioAllocationPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioAllocationPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| accounts info |

### Return type

[**Allocation**](Allocation.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioPositionsConidGet"></a>

# **portfolioPositionsConidGet**

> Object portfolioPositionsConidGet(conid)

Positions by Conid

Returns an object of all positions matching the conid for all the selected accounts. For portfolio models the conid
could be in more than one model, returning an array with the name of the model it belongs to. /portfolio/accounts or
/portfolio/subaccounts must be called prior to this endpoint.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
Integer conid = 56; // Integer | contract id
try {
    Object result = apiInstance.portfolioPositionsConidGet(conid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioPositionsConidGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **Integer**| contract id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="portfolioSubaccountsGet"></a>

# **portfolioSubaccountsGet**

> Account portfolioSubaccountsGet()

List of Sub-Accounts

Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100
sub-accounts for which the user can view position and account-related information. This endpoint must be called prior to
calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use
/portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioApi;


PortfolioApi apiInstance = new PortfolioApi();
try {
    Account result = apiInstance.portfolioSubaccountsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioApi#portfolioSubaccountsGet");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Account**](Account.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

