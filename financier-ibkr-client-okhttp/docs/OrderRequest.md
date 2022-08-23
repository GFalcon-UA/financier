# OrderRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acctId** | **
String** | acctId is optional. It should be one of the accounts returned by /iserver/accounts. If not passed, the first one in the list is selected.  |  [optional]
**conid** | **
Integer** | conid is the identifier of the security you want to trade, you can find the conid with /iserver/secdef/search.  |  [optional]
**conidex** | **
String** | Conid and Exchange - Can be used instead of conid when specifying the contract identifier of a security.  |  [optional]
**secType** | **
String** | The contract-identifier (conid) and security type (type) specified as a concatenated value, conid:type |  [optional]
**cOID** | **
String** | Customer Order ID. An arbitrary string that can be used to identify the order, e.g \&quot;my-fb-order\&quot;. The value must be unique for a 24h span. Please do not set this value for child orders when placing a bracket order.  |  [optional]
**parentId** | **
String** | Only specify for child orders when placing bracket orders. The parentId for the child order(s) must be equal to the cOId (customer order id) of the parent.  |  [optional]
**orderType** | **
String** | The order-type determines what type of order you want to send.   * LMT - A limit order is an order to buy or sell at the specified price or better.   * MKT - A market order is an order to buy or sell at the markets current NBBO.   * STP - A stop order becomes a market order once the specified stop price is attained or penetrated.   * STOP_LIMIT - A stop limit order becomes a limit order once the specified stop price is attained or penetrated.   * MIDPRICE - A MidPrice order attempts to fill at the current midpoint of the NBBO or better.  |  [optional]
**listingExchange** | **
String** | listingExchange is optional. By default we use \&quot;SMART\&quot; routing. Possible values are available via the endpoint: /iserver/contract/{conid}/info, see **
valid_exchange** e.g: SMART,AMEX,NYSE,CBOE,ISE,CHX,ARCA,ISLAND,DRCTEDGE,BEX,BATS,EDGEA,CSFBALGO,JE FFALGO,BYX,IEX,FOXRIVER,TPLUS1,NYSENAT,PSX  |  [optional]
**isSingleGroup** | **Boolean** | set to true if you want to place a single group orders(OCA)  |  [optional]
**outsideRTH** | **Boolean** | set to true if the order can be executed outside regular trading hours.  |  [optional]
**price** | [**
BigDecimal**](BigDecimal.md) | optional if order is LMT, or STOP_LIMIT, this is the limit price. For STP this is the stop price. For MIDPRICE this is the option price cap.  |  [optional]
**auxPrice** | **
Object** | optional if order is STOP_LIMIT, this is the stop price. You must specify both price and auxPrice for STOP_LIMIT orders.  |  [optional]
**side** | **String** | SELL or BUY |  [optional]
**ticker** | **String** | This is the  underlying symbol for the contract.  |  [optional]
**tif** | **
String** | The Time-In-Force determines how long the order remains active on the market.   * GTC - use Good-Till-Cancel for orders to remain active until it executes or cancelled.   * OPG - use Open-Price-Guarantee for Limit-On-Open (LOO) or Market-On-Open (MOO) orders.   * DAY - if not executed a Day order will automatically cancel at the end of the markets regular trading hours.   * IOC - any portion of an Immediate-or-Cancel order that is not filled as soon as it becomes available in the market is cancelled.  |  [optional]
**referrer** | **String** | Custom order reference  |  [optional]
**quantity** | [**
BigDecimal**](BigDecimal.md) | Usually integer, for some special cases such as fractional orders can specify as a float, e.g. quantity &#x3D; 0.001. In some special cases quantity is not specified, such as when using &#39;cashQty&#39; or &#39;fxQty&#39;.  |  [optional]
**cashQty** | [**
BigDecimal**](BigDecimal.md) | Cash Quantity - used to specify the monetary value of an order instead of the number of shares. When using &#39;cashQty&#39; don&#39;t specify &#39;quantity&#39; Orders that express size using a monetary value, e.g. cash quantity can result in fractional shares and are provided on a non-guaranteed basis. The system simulates the order by canceling it once the specified amount is spent (for buy orders) or collected (for sell orders). In addition to the monetary value, the order uses a maximum size that is calculated using the Cash Quantity Estimated Factor, which can be modified in Order Presets.    |  [optional]
**fxQty** | [**
BigDecimal**](BigDecimal.md) | double number, this is the cash quantity field which can only be used for Currency Conversion Orders. When using &#39;fxQty&#39; don&#39;t specify &#39;quantity&#39;.  |  [optional]
**useAdaptive** | **
Boolean** | If true, the system will use the Price Management Algo to submit the order. https://www.interactivebrokers.com/en/index.php?f&#x3D;43423  |  [optional]
**isCcyConv** | **Boolean** | set to true if the order is a FX conversion order  |  [optional]
**allocationMethod** | **
String** | Set the allocation method when placing an order using an FA account for a group Possible allocation methods are \&quot;NetLiquidity\&quot;, \&quot;AvailableEquity\&quot;, \&quot;EqualQuantity\&quot; and \&quot;PctChange\&quot;.  |  [optional]
**strategy** | **String** | Specify which IB Algo algorithm to use for this order.  |  [optional]
**strategyParameters** | **Object** | The IB Algo parameters for the specified algorithm.  |  [optional]



