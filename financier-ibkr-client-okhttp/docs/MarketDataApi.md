# MarketDataApi

All URIs are relative to *https://localhost:5000/v1/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**iserverMarketdataConidUnsubscribeGet**](MarketDataApi.md#iserverMarketdataConidUnsubscribeGet) | **
GET** /iserver/marketdata/{conid}/unsubscribe | Market Data Cancel (Single)
[**iserverMarketdataHistoryGet**](MarketDataApi.md#iserverMarketdataHistoryGet) | **
GET** /iserver/marketdata/history | Market Data History
[**iserverMarketdataSnapshotGet**](MarketDataApi.md#iserverMarketdataSnapshotGet) | **
GET** /iserver/marketdata/snapshot | Market Data
[**iserverMarketdataUnsubscribeallGet**](MarketDataApi.md#iserverMarketdataUnsubscribeallGet) | **
GET** /iserver/marketdata/unsubscribeall | Market Data Cancel (All)
[**mdSnapshotGet**](MarketDataApi.md#mdSnapshotGet) | **GET** /md/snapshot | Market Data Snapshot (Beta)

<a name="iserverMarketdataConidUnsubscribeGet"></a>

# **iserverMarketdataConidUnsubscribeGet**

> Object iserverMarketdataConidUnsubscribeGet(conid)

Market Data Cancel (Single)

Cancel market data for given conid. To cancel all market data request(s), see /iserver/marketdata/unsubscribeall.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataApi;


MarketDataApi apiInstance = new MarketDataApi();
String conid = "conid_example"; // String | contract id
try {
    Object result = apiInstance.iserverMarketdataConidUnsubscribeGet(conid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataApi#iserverMarketdataConidUnsubscribeGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| contract id |

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverMarketdataHistoryGet"></a>

# **iserverMarketdataHistoryGet**

> HistoryData iserverMarketdataHistoryGet(conid, period, exchange, bar, outsideRth)

Market Data History

Get historical market Data for given conid, length of data is controlled by &#39;period&#39; and &#39;bar&#39;.
Formatted as: min&#x3D;minute, h&#x3D;hour, d&#x3D;day, w&#x3D;week, m&#x3D;month, y&#x3D;year e.g. period &#x3D;1y with
bar &#x3D;1w returns 52 data points (Max of 1000 data points supported). **Note**: There&#39;s a limit of 5 concurrent
requests. Excessive requests will return a &#39;Too many requests&#39; status 429 response.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataApi;


MarketDataApi apiInstance = new MarketDataApi();
String conid = "conid_example"; // String | contract id
String period = "period_example"; // String | available time period-- {1-30}min, {1-8}h, {1-1000}d, {1-792}w, {1-182}m, {1-15}y
String exchange = "exchange_example"; // String | Exchange of the conid (e.g. ISLAND, NYSE, etc.). Default value is empty which corresponds to primary exchange of the conid.
String bar = "bar_example"; // String | possible value-- 1min, 2min, 3min, 5min, 10min, 15min, 30min, 1h, 2h, 3h, 4h, 8h, 1d, 1w, 1m
Boolean outsideRth = true; // Boolean | For contracts that support it, will determine if historical data includes outside of regular trading hours.
try {
    HistoryData result = apiInstance.iserverMarketdataHistoryGet(conid, period, exchange, bar, outsideRth);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataApi#iserverMarketdataHistoryGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conid** | **String**| contract id |
**period** | **String**| available time period-- {1-30}min, {1-8}h, {1-1000}d, {1-792}w, {1-182}m, {1-15}y |
**exchange** | **
String**| Exchange of the conid (e.g. ISLAND, NYSE, etc.). Default value is empty which corresponds to primary exchange of the conid. | [optional]
**bar** | **
String**| possible value-- 1min, 2min, 3min, 5min, 10min, 15min, 30min, 1h, 2h, 3h, 4h, 8h, 1d, 1w, 1m | [optional]
**outsideRth** | **
Boolean**| For contracts that support it, will determine if historical data includes outside of regular trading hours. | [optional]

### Return type

[**HistoryData**](HistoryData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverMarketdataSnapshotGet"></a>

# **iserverMarketdataSnapshotGet**

> List&lt;Object&gt; iserverMarketdataSnapshotGet(conids, since, fields)

Market Data

Get Market Data for the given conid(s). The endpoint will return by default bid, ask, last, change, change pct, close,
listing exchange. See response fields for a list of available fields that can be request via fields argument. The
endpoint /iserver/accounts must be called prior to /iserver/marketdata/snapshot. For derivative contracts the endpoint
/iserver/secdef/search must be called first. If you call any other endpoints that relays back market data for the same
contract, such as /iserver/contract/rules then you must query market data again to ensure all fields are properly
returned. First /snapshot endpoint call for given conid will initiate the market data request. To receive all available
fields the /snapshot endpoint will need to be called several times. To receive streaming market data the endpoint /ws
can be used. Refer
to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataApi;


MarketDataApi apiInstance = new MarketDataApi();
String conids = "conids_example"; // String | list of conids separated by comma
Integer since = 56; // Integer | time period since which updates are required. uses epoch time with milliseconds.
String fields = "fields_example"; // String | list of fields separated by comma
try {
    List<Object> result = apiInstance.iserverMarketdataSnapshotGet(conids, since, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataApi#iserverMarketdataSnapshotGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conids** | **String**| list of conids separated by comma |
**since** | **Integer**| time period since which updates are required. uses epoch time with milliseconds. | [optional]
**fields** | **String**| list of fields separated by comma | [optional]

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="iserverMarketdataUnsubscribeallGet"></a>

# **iserverMarketdataUnsubscribeallGet**

> Object iserverMarketdataUnsubscribeallGet()

Market Data Cancel (All)

Cancel all market data request(s). To cancel market data for given conid, see /iserver/marketdata/{conid}/unsubscribe.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataApi;


MarketDataApi apiInstance = new MarketDataApi();
try {
    Object result = apiInstance.iserverMarketdataUnsubscribeallGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataApi#iserverMarketdataUnsubscribeallGet");
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

<a name="mdSnapshotGet"></a>

# **mdSnapshotGet**

> MarketData mdSnapshotGet(conids, fields)

Market Data Snapshot (Beta)

Get a snapshot of Market Data for the given conid(s).See response for a list of available fields that can be requested
from the fields argument. Must be connected to a brokerage session before can query snapshot data. First /snapshot
endpoint call for given conid(s) will initiate the market data request, make an additional request to receive field
values back. To receive all available fields the /snapshot endpoint will need to be called several times. To receive
streaming market data the endpoint /ws can be used. Refer
to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.

### Example

```java
// Import classes:
//import ua.com.gfalcon.financier.ibkr.client.okhttp.ApiException;
//import io.swagger.client.api.MarketDataApi;


MarketDataApi apiInstance = new MarketDataApi();
String conids = "conids_example"; // String | List of conids comma separated. Optional exchange and instrument type can be specified.   * conid: IBKR Contract Identifier   * exchange: Exchange or venue   * instrType: Instrument Type supported values: CS (Stocks), OPT (Options), FUT (Futures), FOP (Future Options), WAR (Warrants), BOND (Bonds), FUND (Mutual Funds), CASH (Forex), CFD (Contract for difference), IND (Index) 
String fields = "fields_example"; // String | list of fields separated by comma 31,84,85,86,88
try {
    MarketData result = apiInstance.mdSnapshotGet(conids, fields);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MarketDataApi#mdSnapshotGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**conids** | **
String**| List of conids comma separated. Optional exchange and instrument type can be specified.   * conid: IBKR Contract Identifier   * exchange: Exchange or venue   * instrType: Instrument Type supported values: CS (Stocks), OPT (Options), FUT (Futures), FOP (Future Options), WAR (Warrants), BOND (Bonds), FUND (Mutual Funds), CASH (Forex), CFD (Contract for difference), IND (Index)  | [enum: conid@exchange:instrType]
**fields** | **String**| list of fields separated by comma 31,84,85,86,88 | [optional]

### Return type

[**MarketData**](MarketData.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

