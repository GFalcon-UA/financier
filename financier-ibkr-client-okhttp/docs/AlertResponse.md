# AlertResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | **String** | account id |  [optional]
**orderId** | **Integer** |  |  [optional]
**alertName** | **String** | name of alert |  [optional]
**alertMessage** | **String** | The message you want to receive via email or text message |  [optional]
**alertActive** | **Integer** | whether alert is active or not, so value can only be 0 or 1 |  [optional]
**alertRepeatable** | **Integer** | whether alert is repeatable or not, so value can only be 0 or 1 |  [optional]
**alertEmail** | **String** | email address to receive alert |  [optional]
**alertSendMessage** | **Integer** | whether allowing to send email or not, so value can only be 0 or 1,  |  [optional]
**tif** | **String** | time in force, can only be GTC or GTD |  [optional]
**expireTime** | **String** | format, YYYYMMDD-HH:mm:ss  |  [optional]
**orderStatus** | **String** | status of alert |  [optional]
**outsideRth** | **
Integer** | value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours.  |  [optional]
**itwsOrdersOnly** | **
Integer** | value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile  |  [optional]
**alertShowPopup** | **Integer** | value can only be 0 or 1, set to 1 to allow to show alert in pop-ups |  [optional]
**alertTriggered** | **Boolean** | whether the alert has been triggered |  [optional]
**orderNotEditable** | **Boolean** | whether the alert can be edited |  [optional]
**toolId** | **
Integer** | for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert  |  [optional]
**alertPlayAudio** | **String** | audio message to play when alert is triggered |  [optional]
**alertMtaCurrency** | **String** | MTA alert only |  [optional]
**alertMtaDefaults** | **String** | MTA alert only |  [optional]
**timeZone** | **String** | MTA alert only |  [optional]
**alertDefaultType** | **String** | MTA alert only |  [optional]
**conditionSize** | **Integer** | size of conditions array |  [optional]
**conditionOutsideRth** | **
Integer** | whether allowing the condition can be triggered outside of regular trading hours, 1 means allow |  [optional]
**conditions** | **List&lt;Object&gt;** |  |  [optional]



