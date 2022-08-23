# AccountApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverAccountPnlPartitionedGet**](AccountApi.md#iserverAccountPnlPartitionedGet) | **
GET** /iserver/account/pnl/partitioned | PnL for the selected account
[**iserverAccountPost**](AccountApi.md#iserverAccountPost) | **POST** /iserver/account | Switch Account
[**iserverAccountsGet**](AccountApi.md#iserverAccountsGet) | **GET** /iserver/accounts | Brokerage Accounts
[**portfolioAccountIdLedgerGet**](AccountApi.md#portfolioAccountIdLedgerGet) | **
GET** /portfolio/{accountId}/ledger | Account Ledger
[**portfolioAccountIdMetaGet**](AccountApi.md#portfolioAccountIdMetaGet) | **
GET** /portfolio/{accountId}/meta | Account Information
[**portfolioAccountIdSummaryGet**](AccountApi.md#portfolioAccountIdSummaryGet) | **
GET** /portfolio/{accountId}/summary | Account Summary
[**portfolioAccountsGet**](AccountApi.md#portfolioAccountsGet) | **GET** /portfolio/accounts | Portfolio Accounts
[**portfolioSubaccountsGet**](AccountApi.md#portfolioSubaccountsGet) | **
GET** /portfolio/subaccounts | List of Sub-Accounts

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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
try {
    Object result = apiInstance.iserverAccountPnlPartitionedGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#iserverAccountPnlPartitionedGet");
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

<a name="iserverAccountPost"></a>

# **iserverAccountPost**

> Object iserverAccountPost(body)

Switch Account

If an user has multiple accounts, and user wants to get orders, trades, etc. of an account other than currently selected
account, then user can update the currently selected account using this API and then can fetch required information for
the newly updated account.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
SetAccount body = new SetAccount(); // SetAccount | account id
try {
    Object result = apiInstance.iserverAccountPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#iserverAccountPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**SetAccount**](SetAccount.md)| account id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverAccountsGet"></a>

# **iserverAccountsGet**

> Object iserverAccountsGet()

Brokerage Accounts

Returns a list of accounts the user has trading access to, their respective aliases and the currently selected account.
Note this endpoint must be called before modifying an order or querying open orders.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
try {
    Object result = apiInstance.iserverAccountsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#iserverAccountsGet");
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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
String accountId = "accountId_example"; // String | account id
try {
    Object result = apiInstance.portfolioAccountIdLedgerGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#portfolioAccountIdLedgerGet");
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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
String accountId = "accountId_example"; // String | account id
try {
    Accounts result = apiInstance.portfolioAccountIdMetaGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#portfolioAccountIdMetaGet");
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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
String accountId = "accountId_example"; // String | account id
try {
    Object result = apiInstance.portfolioAccountIdSummaryGet(accountId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#portfolioAccountIdSummaryGet");
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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
try {
    Accounts result = apiInstance.portfolioAccountsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#portfolioAccountsGet");
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
//import io.swagger.client.api.AccountApi;


AccountApi apiInstance = new AccountApi();
try {
    Account result = apiInstance.portfolioSubaccountsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AccountApi#portfolioSubaccountsGet");
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

