# OrderData

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clientOrderId** | **String** |  |  [optional]
**execId** | **String** |  |  [optional]
**execType** | [**ExecTypeEnum**](#ExecTypeEnum) |  |  [optional]
**orderType** | [**OrderTypeEnum**](#OrderTypeEnum) |  |  [optional]
**orderStatus** | [**OrderStatusEnum**](#OrderStatusEnum) |  |  [optional]
**symbol** | **String** | Underlying symbol for contract |  [optional]
**orderQty** | **String** | Quantity of active order |  [optional]
**price** | **String** | Price of active order |  [optional]
**lastShares** | **String** | Quantity of the last partial fill |  [optional]
**lastPrice** | **String** | Price of the last partial fill |  [optional]
**cumQty** | **String** | Cumulative fill quantity |  [optional]
**leavesQty** | **String** | Remaining quantity to be filled |  [optional]
**avgPrice** | **String** | Average fill price |  [optional]
**side** | [**SideEnum**](#SideEnum) |  |  [optional]
**orderId** | **String** | Order identifier |  [optional]
**account** | **String** | Account number |  [optional]
**secType** | [**SecTypeEnum**](#SecTypeEnum) | Contracts asset class |  [optional]
**txTime** | **String** | Time of transaction in GMT, format YYYYMMDD-hh:m:ss |  [optional]
**rcptTime** | **String** | Time of receipt in GMT, format YYYYMMDD-hh:mm:ss |  [optional]
**tif** | [**TifEnum**](#TifEnum) | Time in Force |  [optional]
**conid** | **String** | Contract identifier from IBKR&#39;s database. |  [optional]
**currency** | **String** | Trading currency |  [optional]
**exchange** | **String** | Exchange or venue |  [optional]
**listingExchange** | **String** | Listing Exchange |  [optional]
**text** | [**BigDecimal**](BigDecimal.md) | error message |  [optional]
**warnings** | **Object** |  |  [optional]
**commCurr** | **String** | Commission currency |  [optional]
**comms** | **String** | Commissions |  [optional]
**realizedPnl** | **String** | Realized PnL |  [optional]

<a name="ExecTypeEnum"></a>

## Enum: ExecTypeEnum

Name | Value
---- | -----
_1_INVALID_ | &quot;-1 \&quot;Invalid\&quot;&quot;
_0_NEW_ | &quot;0 \&quot;New\&quot;&quot;
_1_PARTIALLY_FILLED_ | &quot;1 \&quot;Partially Filled\&quot;&quot;
_2_FILLED_ | &quot;2 \&quot;Filled\&quot;&quot;
_3_DONE_FOR_THE_DAY_ | &quot;3 \&quot;Done for the Day\&quot;&quot;
_4_CANCELED_ | &quot;4 \&quot;Canceled\&quot;&quot;
_5_REPLACED_ | &quot;5 \&quot;Replaced\&quot;&quot;
_6_PENDING_CANCEL_ | &quot;6 \&quot;Pending Cancel\&quot;&quot;
_7_STOPPED_ | &quot;7 \&quot;Stopped\&quot;&quot;
_8_REJECTED_ | &quot;8 \&quot;Rejected\&quot;&quot;
_9_SUSPENDED_ | &quot;9 \&quot;Suspended\&quot;&quot;
A_PENDING_NEW_ | &quot;A \&quot;Pending New\&quot;&quot;
B_CALCULATED_ | &quot;B \&quot;Calculated\&quot;&quot;
C_EXPIRED_ | &quot;C \&quot;Expired\&quot;&quot;
D_RESTATED_ | &quot;D \&quot;Restated\&quot;&quot;
E_PENDING_REPLACE_ | &quot;E \&quot;Pending Replace\&quot;&quot;
F_TRADE_ | &quot;F \&quot;Trade\&quot;&quot;
G_TRADE_CORRECT_ | &quot;G \&quot;Trade Correct\&quot;&quot;
H_TRADE_CANCEL_ | &quot;H \&quot;Trade Cancel\&quot;&quot;
I_ORDER_STATUS_ | &quot;I \&quot;Order Status\&quot;&quot;

<a name="OrderTypeEnum"></a>

## Enum: OrderTypeEnum

Name | Value
---- | -----
_1_MARKET_ | &quot;1 \&quot;Market\&quot;&quot;
_2_LIMIT_ | &quot;2 \&quot;Limit\&quot;&quot;
_3_STOP_ | &quot;3 \&quot;Stop\&quot;&quot;
_4_STOP_LIMIT_ | &quot;4 \&quot;Stop Limit\&quot;&quot;
_5_MARKET_ON_CLOSE_ | &quot;5 \&quot;Market on Close\&quot;&quot;
_6_WITH_OR_WITHOUT_ | &quot;6 \&quot;With or Without\&quot;&quot;
_7_LIMIT_OR_BETTER_ | &quot;7 \&quot;Limit or Better\&quot;&quot;
_8_LIMIT_WITH_OR_WITHOUT_ | &quot;8 \&quot;Limit With or Without\&quot;&quot;
_9_ON_BASIS_ | &quot;9 \&quot;On Basis\&quot;&quot;
A_ON_CLOSE_ | &quot;A \&quot;On Close\&quot;&quot;
B_LIMIT_ON_CLOSE_ | &quot;B \&quot;Limit On Close\&quot;&quot;
C_FOREX_MARKET_ | &quot;C \&quot;Forex Market\&quot;&quot;
D_PREVIOUSLY_QUOTED_ | &quot;D \&quot;Previously Quoted\&quot;&quot;
E_PREVIOUSLY_INDICATED_ | &quot;E \&quot;Previously Indicated\&quot;&quot;
F_FOREX_LIMIT_ | &quot;F \&quot;Forex Limit\&quot;&quot;
G_FOREX_SWAP_ | &quot;G \&quot;Forex Swap\&quot;&quot;
H_FOREX_PREVIOUSLY_QUOTED_ | &quot;H \&quot;Forex Previously Quoted\&quot;&quot;
I_FUNARI_ | &quot;I \&quot;Funari\&quot;&quot;
K_MARKET_TO_LIMIT_ | &quot;K \&quot;Market To Limit\&quot;&quot;
P_PEGGED_ | &quot;P \&quot;Pegged\&quot;&quot;

<a name="OrderStatusEnum"></a>

## Enum: OrderStatusEnum

Name | Value
---- | -----
_1_INVALID_ORDER_STATUS_ | &quot;-1 \&quot;Invalid Order Status\&quot;&quot;
_0_NEW_ | &quot;0 \&quot;New\&quot;&quot;
_1_PARTIALLY_FILLED_ | &quot;1 \&quot;Partially Filled\&quot;&quot;
_2_FILLED_ | &quot;2 \&quot;Filled\&quot;&quot;
_3_DONE_FOR_THE_DAY_ | &quot;3 \&quot;Done for the Day\&quot;&quot;
_4_CANCELED_ | &quot;4 \&quot;Canceled\&quot;&quot;
_5_REPLACED_ | &quot;5 \&quot;Replaced\&quot;&quot;
_6_PENDING_CANCEL_ | &quot;6 \&quot;Pending Cancel\&quot;&quot;
_7_STOPPED_ | &quot;7 \&quot;Stopped\&quot;&quot;
_8_REJECTED_ | &quot;8 \&quot;Rejected\&quot;&quot;
_9_SUSPENDED_ | &quot;9 \&quot;Suspended\&quot;&quot;
A_PENDING_NEW_ | &quot;A \&quot;Pending New\&quot;&quot;
B_CALCULATED_ | &quot;B \&quot;Calculated\&quot;&quot;
C_EXPIRED_ | &quot;C \&quot;Expired\&quot;&quot;
D_RESTATED_ | &quot;D \&quot;Restated\&quot;&quot;
E_PENDING_REPLACE_ | &quot;E \&quot;Pending Replace\&quot;&quot;

<a name="SideEnum"></a>

## Enum: SideEnum

Name | Value
---- | -----
_1_BUY_ | &quot;1 \&quot;Buy\&quot;&quot;
_2_SELL_ | &quot;2 \&quot;Sell\&quot;&quot;
_3_BUY_MINUS_ | &quot;3 \&quot;Buy Minus\&quot;&quot;
_4_SELL_PLUS_ | &quot;4 \&quot;Sell Plus\&quot;&quot;
_5_SELL_SHORT_ | &quot;5 \&quot;Sell Short\&quot;&quot;
_6_SELL_SHORT_EXEMPT_ | &quot;6 \&quot;Sell Short Exempt\&quot;&quot;

<a name="SecTypeEnum"></a>

## Enum: SecTypeEnum

Name | Value
---- | -----
CS_STOCK_ | &quot;CS \&quot;Stock\&quot;&quot;
CASH_FOREX_ | &quot;CASH \&quot;Forex\&quot;&quot;
CFD_CONTRACT_FOR_DIFFERENCE_ | &quot;CFD \&quot;Contract for Difference\&quot;&quot;
FUT_FUTURE_ | &quot;FUT \&quot;Future\&quot;&quot;
OPT_OPTION_ | &quot;OPT \&quot;Option\&quot;&quot;

<a name="TifEnum"></a>

## Enum: TifEnum

Name | Value
---- | -----
_0_DAY_ | &quot;0 \&quot;Day\&quot;&quot;
_1_GTC_ | &quot;1 \&quot;GTC\&quot;&quot;
_2_AT_THE_OPENING_ | &quot;2 \&quot;At the Opening\&quot;&quot;



