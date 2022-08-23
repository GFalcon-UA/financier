# Trade

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**executionId** | **String** | execution identifier for the order |  [optional]
**symbol** | **String** | Underlying Symbol |  [optional]
**side** | [**
SideEnum**](#SideEnum) | The side of the market of the order.   * B - Buy contract near posted ask price   * S - Sell contract near posted bid price   * X - Option expired  |  [optional]
**orderDescription** | **
String** | Formatted description of the order \&quot;%side% %size% @ %price% on %exchange%\&quot;. |  [optional]
**tradeTime** | **String** | Time of Status update in format \&quot;YYYYMMDD-hh:mm:ss\&quot;. |  [optional]
**tradeTimeR** | [**BigDecimal**](BigDecimal.md) | Time of status update in format unix time. |  [optional]
**size** | **String** | Quantity of the order |  [optional]
**price** | **String** | Average Price |  [optional]
**orderRef** | **
String** | User defined string used to identify the order. Value is set using \&quot;cOID\&quot; field while placing an order. |  [optional]
**submitter** | **String** | User that submitted order |  [optional]
**exchange** | **String** | Exchange or venue of order |  [optional]
**commission** | [**BigDecimal**](BigDecimal.md) | Commission of the order |  [optional]
**netAmount** | [**
BigDecimal**](BigDecimal.md) | Net cost of the order, including contract multiplier and quantity. |  [optional]
**account** | **String** | accountCode |  [optional]
**acountCode** | **String** | Account Number |  [optional]
**companyName** | **String** | Contracts company name |  [optional]
**contractDescription1** | **String** | Format contract name |  [optional]
**secType** | **String** | Asset class |  [optional]
**conid** | **String** | IBKR&#39;s contract identifier |  [optional]
**conidex** | **String** | conid and exchange. Format supports conid or conid@exchange |  [optional]
**position** | **String** | Total quantity owned for this contract |  [optional]
**clearingId** | **String** | Firm which will settle the trade. For IBExecution customers only. |  [optional]
**clearingName** | **
String** | Specifies the true beneficiary of the order. For IBExecution customers only. |  [optional]
**liquidationTrade** | [**BigDecimal**](BigDecimal.md) | If order adds liquidity to the market. |  [optional]

<a name="SideEnum"></a>

## Enum: SideEnum

Name | Value
---- | -----
B | &quot;B&quot;
S | &quot;S&quot;
X | &quot;X&quot;



