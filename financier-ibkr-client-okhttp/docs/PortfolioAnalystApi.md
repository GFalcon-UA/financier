# PortfolioAnalystApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**paPerformancePost**](PortfolioAnalystApi.md#paPerformancePost) | **POST** /pa/performance | Account Performance
[**paSummaryPost**](PortfolioAnalystApi.md#paSummaryPost) | **POST** /pa/summary | Account Balance&#39;s Summary
[**paTransactionsPost**](PortfolioAnalystApi.md#paTransactionsPost) | **
POST** /pa/transactions | Position&#39;s Transaction History

<a name="paPerformancePost"></a>

# **paPerformancePost**

> Performance paPerformancePost(body)

Account Performance

Returns the performance (MTM) for the given accounts, if more than one account is passed, the result is consolidated.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioAnalystApi;


PortfolioAnalystApi apiInstance = new PortfolioAnalystApi();
Body body = new Body(); // Body | an array of account ids
try {
    Performance result = apiInstance.paPerformancePost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioAnalystApi#paPerformancePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| an array of account ids |

### Return type

[**Performance**](Performance.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="paSummaryPost"></a>

# **paSummaryPost**

> Summary paSummaryPost(body)

Account Balance&#39;s Summary

Returns a summary of all account balances for the given accounts, if more than one account is passed, the result is
consolidated.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioAnalystApi;


PortfolioAnalystApi apiInstance = new PortfolioAnalystApi();
Body body = new Body(); // Body | an array of account ids
try {
    Summary result = apiInstance.paSummaryPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioAnalystApi#paSummaryPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| an array of account ids |

### Return type

[**Summary**](Summary.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="paTransactionsPost"></a>

# **paTransactionsPost**

> Transactions paTransactionsPost(body)

Position&#39;s Transaction History

transaction history for a given number of conids and accounts. Types of transactions include dividend payments, buy and
sell transactions, transfers.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.PortfolioAnalystApi;


PortfolioAnalystApi apiInstance = new PortfolioAnalystApi();
Body body = new Body(); // Body | 
try {
    Transactions result = apiInstance.paTransactionsPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PortfolioAnalystApi#paTransactionsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)|  |

### Return type

[**Transactions**](Transactions.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

