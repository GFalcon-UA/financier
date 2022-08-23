# ContractApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverContractConidAlgosGet**](ContractApi.md#iserverContractConidAlgosGet) | **
GET** /iserver/contract/{conid}/algos | IB Algo Params
[**iserverContractConidInfoAndRulesGet**](ContractApi.md#iserverContractConidInfoAndRulesGet) | **
GET** /iserver/contract/{conid}/info-and-rules | Info and Rules
[**iserverContractConidInfoGet**](ContractApi.md#iserverContractConidInfoGet) | **
GET** /iserver/contract/{conid}/info | Contract Details
[**iserverContractRulesPost**](ContractApi.md#iserverContractRulesPost) | **
POST** /iserver/contract/rules | Contract Rules
[**iserverSecdefInfoGet**](ContractApi.md#iserverSecdefInfoGet) | **GET** /iserver/secdef/info | Secdef Info
[**iserverSecdefSearchPost**](ContractApi.md#iserverSecdefSearchPost) | **
POST** /iserver/secdef/search | Search by Symbol or Name
[**iserverSecdefStrikesGet**](ContractApi.md#iserverSecdefStrikesGet) | **GET** /iserver/secdef/strikes | Search Strikes
[**trsrvFuturesGet**](ContractApi.md#trsrvFuturesGet) | **GET** /trsrv/futures | Security Futures by Symbol
[**trsrvSecdefPost**](ContractApi.md#trsrvSecdefPost) | **POST** /trsrv/secdef | Secdef by Conid
[**trsrvSecdefScheduleGet**](ContractApi.md#trsrvSecdefScheduleGet) | **
GET** /trsrv/secdef/schedule | Get trading schedule for symbol
[**trsrvStocksGet**](ContractApi.md#trsrvStocksGet) | **GET** /trsrv/stocks | Security Stocks by Symbol

<a name="iserverContractConidAlgosGet"></a>

# **iserverContractConidAlgosGet**

> List&lt;Object&gt; iserverContractConidAlgosGet(conid, algos, addDescription, addParams)

IB Algo Params

Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String conid = "conid_example"; // String | IBKR contract identifier
String algos = "algos_example"; // String | List of algo ids delimited by \";\" to filter by. Max of 8 algos ids can be specified.
String addDescription = "addDescription_example"; // String | Whether or not to add algo descriptions to response. Set to 1 for yes, 0 for no.
String addParams = "addParams_example"; // String | Whether or not to show algo parameters.  Set to 1 for yes, 0 for no.
try {
    List<Object> result = apiInstance.iserverContractConidAlgosGet(conid, algos, addDescription, addParams);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverContractConidAlgosGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| IBKR contract identifier |
**algos** | **
String**| List of algo ids delimited by \&quot;;\&quot; to filter by. Max of 8 algos ids can be specified. | [optional]
**addDescription** | **
String**| Whether or not to add algo descriptions to response. Set to 1 for yes, 0 for no. | [optional]
**addParams** | **String**| Whether or not to show algo parameters. Set to 1 for yes, 0 for no. | [optional]

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverContractConidInfoAndRulesGet"></a>

# **iserverContractConidInfoAndRulesGet**

> Object iserverContractConidInfoAndRulesGet(conid, isBuy)

Info and Rules

Returns both contract info and rules from a single endpoint. For only contract rules, use the endpoint
/iserver/contract/rules. For only contract info, use the endpoint /iserver/contract/{conid}/info.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String conid = "conid_example"; // String | IBKR contract identifier
Boolean isBuy = true; // Boolean | Side of the market rules apply too. Set to **true** for Buy Orders, set to **false** for Sell Orders
try {
    Object result = apiInstance.iserverContractConidInfoAndRulesGet(conid, isBuy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverContractConidInfoAndRulesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| IBKR contract identifier |
**isBuy** | **Boolean**| Side of the market rules apply too. Set to **true** for Buy Orders, set to **
false** for Sell Orders |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverContractConidInfoGet"></a>

# **iserverContractConidInfoGet**

> Contract iserverContractConidInfoGet(conid)

Contract Details

Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an order

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String conid = "conid_example"; // String | contract id
try {
    Contract result = apiInstance.iserverContractConidInfoGet(conid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverContractConidInfoGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| contract id |

### Return type

[**Contract**](Contract.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverContractRulesPost"></a>

# **iserverContractRulesPost**

> Object iserverContractRulesPost(conid)

Contract Rules

Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint
/iserver/contract/{conid}/info-and-rules.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
Conid conid = new Conid(); // Conid | 
try {
    Object result = apiInstance.iserverContractRulesPost(conid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverContractRulesPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | [**Conid**](.md)|  |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverSecdefInfoGet"></a>

# **iserverSecdefInfoGet**

> List&lt;SecdefInfo&gt; iserverSecdefInfoGet(conid, sectype, month, exchange, strike, right)

Secdef Info

Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price for
Options/Warrants use \&quot;/iserver/secdef/strikes\&quot; endpoint. Must call /secdef/search for the underlying
contract first.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String conid = "conid_example"; // String | underlying contract id
String sectype = "sectype_example"; // String | FUT/OPT/WAR/CASH/CFD
String month = "month_example"; // String | contract month, only required for FUT/OPT/WAR in the format MMMYY, example JAN00
String exchange = "exchange_example"; // String | optional, default is SMART
String strike = "strike_example"; // String | optional, only required for OPT/WAR
String right = "right_example"; // String | C for call, P for put
try {
    List<SecdefInfo> result = apiInstance.iserverSecdefInfoGet(conid, sectype, month, exchange, strike, right);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverSecdefInfoGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| underlying contract id |
**sectype** | **String**| FUT/OPT/WAR/CASH/CFD |
**month** | **String**| contract month, only required for FUT/OPT/WAR in the format MMMYY, example JAN00 | [optional]
**exchange** | **String**| optional, default is SMART | [optional]
**strike** | **String**| optional, only required for OPT/WAR | [optional]
**right** | **String**| C for call, P for put | [optional]

### Return type

[**List&lt;SecdefInfo&gt;**](SecdefInfo.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverSecdefSearchPost"></a>

# **iserverSecdefSearchPost**

> List&lt;Object&gt; iserverSecdefSearchPost(symbol)

Search by Symbol or Name

Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must be
called before using /secdef/info. If company name is specified will only receive limited response: conid, companyName,
companyHeader and symbol.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
Symbol symbol = new Symbol(); // Symbol | Symbol or Company Name to be searched
try {
    List<Object> result = apiInstance.iserverSecdefSearchPost(symbol);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverSecdefSearchPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**symbol** | [**Symbol**](.md)| Symbol or Company Name to be searched |

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverSecdefStrikesGet"></a>

# **iserverSecdefStrikesGet**

> Object iserverSecdefStrikesGet(conid, sectype, month, exchange)

Search Strikes

Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and exchanges
use \&quot;/iserver/secdef/search\&quot;

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String conid = "conid_example"; // String | contract id of the underlying contract
String sectype = "sectype_example"; // String | OPT/WAR
String month = "month_example"; // String | contract month
String exchange = "exchange_example"; // String | optional, default is SMART
try {
    Object result = apiInstance.iserverSecdefStrikesGet(conid, sectype, month, exchange);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#iserverSecdefStrikesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| contract id of the underlying contract |
**sectype** | **String**| OPT/WAR |
**month** | **String**| contract month |
**exchange** | **String**| optional, default is SMART | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="trsrvFuturesGet"></a>

# **trsrvFuturesGet**

> Object trsrvFuturesGet(symbols)

Security Futures by Symbol

Returns a list of non-expired future contracts for given symbol(s)

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String symbols = "symbols_example"; // String | list of case-sensitive symbols separated by comma
try {
    Object result = apiInstance.trsrvFuturesGet(symbols);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#trsrvFuturesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**symbols** | **String**| list of case-sensitive symbols separated by comma |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="trsrvSecdefPost"></a>

# **trsrvSecdefPost**

> Secdef trsrvSecdefPost(body)

Secdef by Conid

Returns a list of security definitions for the given conids

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
Body body = new Body(); // Body | request body
try {
    Secdef result = apiInstance.trsrvSecdefPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#trsrvSecdefPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**body** | [**Body**](.md)| request body |

### Return type

[**Secdef**](Secdef.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="trsrvSecdefScheduleGet"></a>

# **trsrvSecdefScheduleGet**

> Object trsrvSecdefScheduleGet(assetClass, symbol, exchange, exchangeFilter)

Get trading schedule for symbol

Returns the trading schedule up to a month for the requested contract

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String assetClass = "assetClass_example"; // String | specify the asset class of the contract. Available values-- Stock: STK, Option: OPT, Future: FUT, Contract For Difference: CFD, Warrant: WAR, Forex: SWP, Mutual Fund: FND, Bond: BND, Inter-Commodity Spreads: ICS 
String symbol = "symbol_example"; // String | Underlying Symbol for specified contract, for example 'AAPL' for US Stock - Apple Inc.
String exchange = "exchange_example"; // String | Native exchange for contract, for example 'NASDAQ' for US Stock - Apple Inc.
String exchangeFilter = "exchangeFilter_example"; // String | Response only returns trading schedule for specified exchange
try {
    Object result = apiInstance.trsrvSecdefScheduleGet(assetClass, symbol, exchange, exchangeFilter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#trsrvSecdefScheduleGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**assetClass** | **
String**| specify the asset class of the contract. Available values-- Stock: STK, Option: OPT, Future: FUT, Contract For Difference: CFD, Warrant: WAR, Forex: SWP, Mutual Fund: FND, Bond: BND, Inter-Commodity Spreads: ICS  |
**symbol** | **
String**| Underlying Symbol for specified contract, for example &#39;AAPL&#39; for US Stock - Apple Inc. |
**exchange** | **
String**| Native exchange for contract, for example &#39;NASDAQ&#39; for US Stock - Apple Inc. | [optional]
**exchangeFilter** | **String**| Response only returns trading schedule for specified exchange | [optional]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="trsrvStocksGet"></a>

# **trsrvStocksGet**

> Object trsrvStocksGet(symbols)

Security Stocks by Symbol

Returns an object contains all stock contracts for given symbol(s)

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.ContractApi;


ContractApi apiInstance = new ContractApi();
String symbols = "symbols_example"; // String | list of upper-sensitive symbols separated by comma
try {
    Object result = apiInstance.trsrvStocksGet(symbols);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractApi#trsrvStocksGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**symbols** | **String**| list of upper-sensitive symbols separated by comma |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

