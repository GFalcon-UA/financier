# OrderStatus

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subType** | **String** | order sub-type |  [optional]
**requestId** | **String** | order request id |  [optional]
**orderId** | **Integer** | system generated order id, unique per account |  [optional]
**conidex** | **String** | conid and exchange. Format supports conid or conid@exchange |  [optional]
**symbol** | **String** | Underlying symbol |  [optional]
**side** | [**
SideEnum**](#SideEnum) | The side of the market of the order.   * B - Buy contract near posted ask price   * S - Sell contract near posted bid price   * X - Option expired  |  [optional]
**contractDescription1** | **String** | Format contract name |  [optional]
**listingExchange** | **String** | Trading Exchange or Venue |  [optional]
**optionAcct** | **String** |  |  [optional]
**companyName** | **String** | Contracts company name |  [optional]
**size** | **String** | Quantity updated |  [optional]
**totalSize** | **String** | Total quantity |  [optional]
**currency** | **String** | Contract traded currency |  [optional]
**account** | **String** | account id |  [optional]
**orderType** | **String** | Types of orders |  [optional]
**limitPrice** | **String** | Limit price |  [optional]
**stopPrice** | **String** | Stop price |  [optional]
**cumFill** | **String** | Cumulative fill |  [optional]
**orderStatus** | **
String** | *  PendingSubmit - Indicates the order was sent, but confirmation has not been received that it has been received by the destination. Occurs most commonly if an exchange is closed. *  PendingCancel - Indicates that a request has been sent to cancel an order but confirmation has not been received of its cancellation. *  PreSubmitted - Indicates that a simulated order type has been accepted by the IBKR system and that this order has yet to be elected. The order is held in the IBKR system until the election criteria are met. At that time the order is transmitted to the order destination as specified. *  Submitted - Indicates that the order has been accepted at the order destination and is working. *  Cancelled - Indicates that the balance of the order has been confirmed cancelled by the IB system. This could occur unexpectedly when IB or the destination has rejected the order. *  Filled - Indicates that the order has been completely filled. *  Inactive - Indicates the order is not working, for instance if the order was invalid and triggered an error message, or if the order was to short a security and shares have not yet been located.  |  [optional]
**orderStatusDescription** | **String** | Description of the order status |  [optional]
**tif** | **String** | Time-in-Force - length of time order will continue working before it is canceled. |  [optional]
**fgColor** | **String** | Foreground color in hex format |  [optional]
**bgColor** | **String** | Background color in hex format |  [optional]
**orderNotEditable** | **Boolean** | If true not allowed to modify order |  [optional]
**editableFields** | **String** | Fields that can be edited in escaped unicode characters |  [optional]
**cannotCancelOrder** | **Boolean** | If true not allowed to cancel order |  [optional]
**outsideRth** | **Boolean** | If true order trades outside regular trading hours |  [optional]
**deactivateOrder** | **Boolean** | If true order is de-activated |  [optional]
**usePriceMgmtAlgo** | **
Boolean** | If true price management algo is enabled, refer to https://www.interactivebrokers.com/en/index.php?f&#x3D;43423 |  [optional]
**secType** | **String** | Asset class |  [optional]
**availableChartPeriods** | **String** | List of available chart periods |  [optional]
**orderDescription** | **String** | Format description of order |  [optional]
**orderDescriptionWithContract** | **String** | order_description with the symbol |  [optional]
**alertActive** | **Integer** |  |  [optional]
**childOrderType** | **String** | type of the child order |  [optional]
**sizeAndFills** | **String** | Format fillQuantity\\totalQuantity |  [optional]
**exitStrategyDisplayPrice** | **String** | Position display price |  [optional]
**exitStrategyChartDescription** | **String** | Position description to display on chart |  [optional]
**exitStrategyToolAvailability** | [**
ExitStrategyToolAvailabilityEnum**](#ExitStrategyToolAvailabilityEnum) | * 1: If your account has position or order for contract * 0: If your account has no position or order for contract  |  [optional]
**allowedDuplicateOpposite** | **
Boolean** | Returns true if contract supports duplicate/opposite side order. |  [optional]
**orderTime** | **String** | Time of status update in unix time |  [optional]
**ocaGroupId** | **String** | only exists for oca orders, oca orders in same group will have same id |  [optional]

<a name="SideEnum"></a>

## Enum: SideEnum

Name | Value
---- | -----
B | &quot;B&quot;
S | &quot;S&quot;
X | &quot;X&quot;

<a name="ExitStrategyToolAvailabilityEnum"></a>

## Enum: ExitStrategyToolAvailabilityEnum

Name | Value
---- | -----
_1 | &quot;1&quot;
_0 | &quot;0&quot;



