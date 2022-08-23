# AlertRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orderId** | **
Integer** | orderId is required when modifying alert. You can get it from /iserver/account/:accountId/alerts  |  [optional]
**alertName** | **String** | name of alert |  [optional]
**alertMessage** | **String** | The message you want to receive via email or text message |  [optional]
**alertRepeatable** | **
Integer** | whether alert is repeatable or not, so value can only be 0 or 1, this has to be 1 for MTA alert |  [optional]
**email** | **String** | email address to receive alert |  [optional]
**sendMessage** | **Integer** | whether allowing to send email or not, so value can only be 0 or 1,  |  [optional]
**tif** | **String** | time in force, can only be GTC or GTD |  [optional]
**expireTime** | **String** | format, YYYYMMDD-HH:mm:ss, please NOTE this will only work when tif is GTD  |  [optional]
**outsideRth** | **
Integer** | value can only be 0 or 1, set to 1 if the alert can be triggered outside regular trading hours.  |  [optional]
**iTWSOrdersOnly** | **
Integer** | value can only be 0 or 1, set to 1 to enable the alert only in IBKR mobile  |  [optional]
**showPopup** | **Integer** | value can only be 0 or 1, set to 1 to allow to show alert in pop-ups |  [optional]
**toolId** | **
Integer** | for MTA alert only, each user has a unique toolId and it will stay the same, do not send for normal alert  |  [optional]
**playAudio** | **String** | audio message to play when alert is triggered |  [optional]
**conditions** | **List&lt;Object&gt;** |  |  [optional]



