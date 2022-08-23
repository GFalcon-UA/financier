/*
 *   Copyright 2016-2022 Oleksii V. KHALIKOV
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.financier.ibkr.server.jaxrs.api;

import javax.servlet.ServletConfig;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.AlertRequest;
import ua.com.gfalcon.financier.ibkr.model.AlertResponse;
import ua.com.gfalcon.financier.ibkr.model.AuthStatus;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Conid;
import ua.com.gfalcon.financier.ibkr.model.Contract;
import ua.com.gfalcon.financier.ibkr.model.HistoryData;
import ua.com.gfalcon.financier.ibkr.model.ModifyOrder;
import ua.com.gfalcon.financier.ibkr.model.OrderRequest;
import ua.com.gfalcon.financier.ibkr.model.OrderStatus;
import ua.com.gfalcon.financier.ibkr.model.ScannerParams;
import ua.com.gfalcon.financier.ibkr.model.SecdefInfo;
import ua.com.gfalcon.financier.ibkr.model.SetAccount;
import ua.com.gfalcon.financier.ibkr.model.Symbol;
import ua.com.gfalcon.financier.ibkr.model.SystemError;
import ua.com.gfalcon.financier.ibkr.model.Trade;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.factories.IserverApiServiceFactory;

@Path("/iserver")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the iserver API")

public class IserverApi {
    private final IserverApiService delegate;

    public IserverApi(@Context ServletConfig servletContext) {
        IserverApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("IserverApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (IserverApiService) Class.forName(implClass)
                            .newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = IserverApiServiceFactory.getIserverApi();
        }

        this.delegate = delegate;
    }

    @POST
    @Path("/account/{accountId}/alert/activate")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Activate or deactivate an alert",
            notes = "Please note, if alertId is 0, it will activate/deactivate all alerts",
            response = Object.class,
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Object.class)})
    public Response iserverAccountAccountIdAlertActivatePost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "order request info", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdAlertActivatePost(accountId, body, securityContext);
    }

    @DELETE
    @Path("/account/{accountId}/alert/{alertId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete an alert",
            notes = "Please be careful, if alertId is 0, it will delete all alerts",
            response = Object.class,
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Object.class)})
    public Response iserverAccountAccountIdAlertAlertIdDelete(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "alert id", required = true) @PathParam("alertId") String alertId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdAlertAlertIdDelete(accountId, alertId, securityContext);
    }

    @POST
    @Path("/account/{accountId}/alert")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Create or modify alert",
            notes = "Please note here, DO NOT pass orderId when creating a new alert, toolId is only required for MTA alert ",
            response = Object.class,
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Object.class)})
    public Response iserverAccountAccountIdAlertPost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "alert info", required = true) AlertRequest body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdAlertPost(accountId, body, securityContext);
    }

    @GET
    @Path("/account/{accountId}/alerts")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get a list of available alerts",
            notes = "The response will contain both active and inactive alerts, but it won't have MTA alert",
            response = Object.class,
            responseContainer = "List",
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array of objects",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverAccountAccountIdAlertsGet(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdAlertsGet(accountId, securityContext);
    }

    @DELETE
    @Path("/account/{accountId}/order/{orderId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Cancel Order",
            notes = "Cancels an open order. Must call /iserver/accounts endpoint prior to cancelling an order. Use /iservers/account/orders endpoint to review open-order(s) and get latest order status.",
            response = Object.class,
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object with order id, message, conid and account id",
            response = Object.class)})
    public Response iserverAccountAccountIdOrderOrderIdDelete(
            @ApiParam(value = "account id, or fa group if deleting a group order", required = true) @PathParam(
                    "accountId") String accountId,
            @ApiParam(value = "Customer order id, use /iservers/account/orders endpoint to query orderId.",
                    required = true) @PathParam("orderId") String orderId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrderOrderIdDelete(accountId, orderId, securityContext);
    }

    @POST
    @Path("/account/{accountId}/order/{orderId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Modify Order",
            notes = "Modifies an open order. Must call /iserver/accounts endpoint prior to modifying an order. Use /iservers/account/orders endpoint to review open-order(s).",
            response = Object.class,
            responseContainer = "List",
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverAccountAccountIdOrderOrderIdPost(
            @ApiParam(value = "account id, or fa group if modifying a group order", required = true) @PathParam(
                    "accountId") String accountId,
            @ApiParam(value = "Customer order id, use /iservers/account/orders endpoint to query orderId.",
                    required = true) @PathParam("orderId") String orderId,
            @ApiParam(value = "modify-order request", required = true) ModifyOrder body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrderOrderIdPost(accountId, orderId, body, securityContext);
    }

    @POST
    @Path("/account/{accountId}/order")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Place Order (Deprecated)",
            notes = "This endpoint is going to be deprecated, you can use /iserver/account/{accountId}/orders, just pass one order in the array, the order structure will be same. Please note here, sometimes this endpoint alone can't make sure you submit the order successfully, you could receive some questions in the response, you have to to answer them in order to submit the order successfully. You can use \"/iserver/reply/{replyid}\" endpoint to answer questions ",
            response = Object.class,
            responseContainer = "List",
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverAccountAccountIdOrderPost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "order request info", required = true) OrderRequest body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrderPost(accountId, body, securityContext);
    }

    @POST
    @Path("/account/{accountId}/order/whatif")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Preview Order (Deprecated)",
            notes = "This end-point is going to be deprecated, you can use /iserver/account/{accountId}/orders/whatif, just pass one order in the array, the order structure will be same. This endpoint allows you to preview order without actually submitting the order and you can get commission information in the response. ",
            response = Object.class,
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Object.class)})
    public Response iserverAccountAccountIdOrderWhatifPost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "order info", required = true) OrderRequest body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrderWhatifPost(accountId, body, securityContext);
    }

    @POST
    @Path("/account/{accountId}/orders")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Place Orders",
            notes = "When connected to an IServer Brokerage Session, this endpoint will allow you to submit orders.  CP WEB API supports various advanced orderTypes, for additional details and examples refer to [IBKR Quant Blog](https://www.tradersinsight.news/category/ibkr-quant-news/programming_languages/rest-development/).   * Bracket - Attach additional opposite-side order(s) by using a single **cOID** sent with the parent and set the same value for **parentId** in each child order(s).   * Cash Quantity -  Send orders using monetary value by specifying **cashQty** instead of quantity, e.g. cashQty: 200. The endpoint /iserver/contract/rules returns list of valid orderTypes in cqtTypes.   * Currency Conversion - Convert cash from one currency to another by including **isCcyConv** = **true**. To specify the cash quantity use **fxQTY** instead of quantity, e.g. fxQTY: 100.   * Fractional - Contracts that support fractional shares can be traded by specifying **quantity** as a float, e.g. quantity: 0.001. The endpoint /iserver/contract/rules returns a list of valid orderTypes in fraqTypes.   * IB Algos - Attached user-defined settings to your trades by using any of IBKR's Algo Orders. Use the endpoint /iserver/contract/{conid}/algos to identify the available strategies for a contract.   * One-Cancels-All (OCA) - Group multiple unrelated orders by passing order request info in an array and including **isSingleGroup = true** for each order. All orders will be assigned the same oca_group_id. ",
            response = Object.class,
            responseContainer = "List",
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverAccountAccountIdOrdersPost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "order request info", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrdersPost(accountId, body, securityContext);
    }

    @POST
    @Path("/account/{accountId}/orders/whatif")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Preview Orders",
            notes = "This endpoint allows you to preview order without actually submitting the order and you can get commission information in the response. Also supports bracket orders. ",
            response = Object.class,
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Object.class)})
    public Response iserverAccountAccountIdOrdersWhatifPost(
            @ApiParam(value = "account id", required = true) @PathParam("accountId") String accountId,
            @ApiParam(value = "order info", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAccountIdOrdersWhatifPost(accountId, body, securityContext);
    }

    @GET
    @Path("/account/alert/{id}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get details of an alert",
            notes = "Use the endpoint /iserver/account/:accountId/alerts to receive the alert id. The order_id in the response is the alert id. ",
            response = AlertResponse.class,
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = AlertResponse.class)})
    public Response iserverAccountAlertIdGet(@ApiParam(value = "alert id", required = true) @PathParam("id") String id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountAlertIdGet(id, securityContext);
    }

    @GET
    @Path("/account/mta")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get MTA alert",
            notes = "Each login user only has one mobile trading assistant (MTA) alert with it's own unique tool id. The tool id cannot be changed. When modified a new order Id is generated. MTA alerts can not be created or deleted. If you call delete /iserver/account/:accountId/alert/:alertId, it will reset MTA to default. See [here](https://www.interactivebrokers.com/en/software/mobileiphonemobile/mobileiphone.htm#monitor/trading-assistant.htm) for more information on MTA alerts. ",
            response = AlertResponse.class,
            tags = {"Alert",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = AlertResponse.class)})
    public Response iserverAccountMtaGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountMtaGet(securityContext);
    }

    @GET
    @Path("/account/order/status/{orderId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Order Status",
            notes = "",
            response = OrderStatus.class,
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = OrderStatus.class)})
    public Response iserverAccountOrderStatusOrderIdGet(
            @ApiParam(value = "Customer order id, use /iservers/account/orders endpoint to query orderId.",
                    required = true) @PathParam("orderId") String orderId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountOrderStatusOrderIdGet(orderId, securityContext);
    }

    @POST
    @Path("/account/orders/{faGroup}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Place Orders for FA",
            notes = "Financial Advisors can use this endpoint to place an order for a specified group. To place an order for a specified account use the endpoint /iserver/account/{accountId}/order. More information about groups can be found in the [TWS Users' Guide:](https://guides.interactivebrokers.com/twsguide/twsguide.htm#usersguidebook/financialadvisors/create_an_account_group_for_share_allocation.htm). ",
            response = Object.class,
            responseContainer = "List",
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverAccountOrdersFaGroupPost(
            @ApiParam(value = "financial advisor group", required = true) @PathParam("faGroup") String faGroup,
            @ApiParam(value = "order request info", required = true) OrderRequest body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountOrdersFaGroupPost(faGroup, body, securityContext);
    }

    @GET
    @Path("/account/orders")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Live Orders",
            notes = "The endpoint is meant to be used in polling mode, e.g. requesting every x seconds. The response will contain two objects, one is notification, the other is orders. Orders is the list of live orders (cancelled, filled, submitted). Notifications contains information about execute orders as they happen, see status field. To receive streaming live orders the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details. ",
            response = Object.class,
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An object contains two arrays",
            response = Object.class)})
    public Response iserverAccountOrdersGet(@ApiParam(value = "an array of filters") Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountOrdersGet(body, securityContext);
    }

    @GET
    @Path("/account/pnl/partitioned")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "PnL for the selected account",
            notes = "Returns an object containing PnL for the selected account and its models (if any). To receive streaming PnL the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details. ",
            response = Object.class,
            tags = {"PnL", "Account",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An object containing account and model(s) pnl",
            response = Object.class)})
    public Response iserverAccountPnlPartitionedGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountPnlPartitionedGet(securityContext);
    }

    @POST
    @Path("/account")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Switch Account",
            notes = "If an user has multiple accounts, and user wants to get orders, trades, etc. of an account other than currently selected account, then user can update the currently selected account using this API and then can fetch required information for the newly updated account.",
            response = Object.class,
            tags = {"Account",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "an object containing updated account ID",
            response = Object.class)})
    public Response iserverAccountPost(@ApiParam(value = "account id", required = true) SetAccount body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountPost(body, securityContext);
    }

    @GET
    @Path("/account/trades")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "List of Trades for the selected account",
            notes = "Returns a list of trades for the currently selected account for current day and six previous days. It is advised to call this endpoint once per session. ",
            response = Trade.class,
            responseContainer = "List",
            tags = {"Trades",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array of trades",
            response = Trade.class,
            responseContainer = "List")})
    public Response iserverAccountTradesGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountTradesGet(securityContext);
    }

    @GET
    @Path("/accounts")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Brokerage Accounts",
            notes = "Returns a list of accounts the user has trading access to, their respective aliases and the currently selected account. Note this endpoint must be called before modifying an order or querying open orders.",
            response = Object.class,
            tags = {"Account",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array of accounts",
            response = Object.class)})
    public Response iserverAccountsGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAccountsGet(securityContext);
    }

    @POST
    @Path("/auth/status")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Authentication Status",
            notes = "Current Authentication status to the Brokerage system. Market Data and Trading is not possible if not authenticated, e.g. authenticated shows false",
            response = AuthStatus.class,
            tags = {"Session",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Authentication Status",
            response = AuthStatus.class)})
    public Response iserverAuthStatusPost(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverAuthStatusPost(securityContext);
    }

    @GET
    @Path("/contract/{conid}/algos")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "IB Algo Params",
            notes = "Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters.",
            response = Object.class,
            responseContainer = "List",
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array of algos",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverContractConidAlgosGet(
            @ApiParam(value = "IBKR contract identifier", required = true) @PathParam("conid") String conid,
            @ApiParam(value = "List of algo ids delimited by \";\" to filter by. Max of 8 algos ids can be specified.") @QueryParam(
                    "algos") String algos,
            @ApiParam(value = "Whether or not to add algo descriptions to response. Set to 1 for yes, 0 for no.") @QueryParam(
                    "addDescription") String addDescription,
            @ApiParam(value = "Whether or not to show algo parameters.  Set to 1 for yes, 0 for no.") @QueryParam(
                    "addParams") String addParams, @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverContractConidAlgosGet(conid, algos, addDescription, addParams, securityContext);
    }

    @GET
    @Path("/contract/{conid}/info-and-rules")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Info and Rules",
            notes = "Returns both contract info and rules from a single endpoint. For only contract rules, use the endpoint /iserver/contract/rules. For only contract info, use the endpoint /iserver/contract/{conid}/info.  ",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class)})
    public Response iserverContractConidInfoAndRulesGet(
            @ApiParam(value = "IBKR contract identifier", required = true) @PathParam("conid") String conid, @ApiParam(
            value = "Side of the market rules apply too. Set to **true** for Buy Orders, set to **false** for Sell Orders",
            required = true) @QueryParam("isBuy") Boolean isBuy,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverContractConidInfoAndRulesGet(conid, isBuy, securityContext);
    }

    @GET
    @Path("/contract/{conid}/info")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Contract Details",
            notes = "Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an order",
            response = Contract.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Contract.class)})
    public Response iserverContractConidInfoGet(
            @ApiParam(value = "contract id", required = true) @PathParam("conid") String conid,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverContractConidInfoGet(conid, securityContext);
    }

    @POST
    @Path("/contract/rules")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Contract Rules",
            notes = "Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint /iserver/contract/{conid}/info-and-rules.",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class)})
    public Response iserverContractRulesPost(@ApiParam(value = "", required = true) Conid conid,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverContractRulesPost(conid, securityContext);
    }

    @GET
    @Path("/marketdata/{conid}/unsubscribe")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data Cancel (Single)",
            notes = "Cancel market data for given conid. To cancel all market data request(s), see /iserver/marketdata/unsubscribeall. ",
            response = Object.class,
            tags = {"Market Data",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "confirms market data for conid is cancelled",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "cancel failed", response = Void.class)})
    public Response iserverMarketdataConidUnsubscribeGet(
            @ApiParam(value = "contract id", required = true) @PathParam("conid") String conid,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverMarketdataConidUnsubscribeGet(conid, securityContext);
    }

    @GET
    @Path("/marketdata/history")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data History",
            notes = "Get historical market Data for given conid, length of data is controlled by 'period' and 'bar'. Formatted as: min=minute, h=hour, d=day, w=week, m=month, y=year e.g. period =1y with bar =1w returns 52 data points (Max of 1000 data points supported). **Note**: There's a limit of 5 concurrent requests. Excessive requests will return a 'Too many requests' status 429 response. ",
            response = HistoryData.class,
            tags = {"Market Data",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Returns an object",
            response = HistoryData.class),

            @io.swagger.annotations.ApiResponse(code = 429, message = "Too many requests", response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System Error", response = SystemError.class)})
    public Response iserverMarketdataHistoryGet(
            @ApiParam(value = "contract id", required = true) @QueryParam("conid") String conid,
            @ApiParam(value = "available time period-- {1-30}min, {1-8}h, {1-1000}d, {1-792}w, {1-182}m, {1-15}y",
                    required = true) @QueryParam("period") String period,
            @ApiParam(value = "Exchange of the conid (e.g. ISLAND, NYSE, etc.). Default value is empty which corresponds to primary exchange of the conid.") @QueryParam(
                    "exchange") String exchange,
            @ApiParam(value = "possible value-- 1min, 2min, 3min, 5min, 10min, 15min, 30min, 1h, 2h, 3h, 4h, 8h, 1d, 1w, 1m") @QueryParam(
                    "bar") String bar,
            @ApiParam(value = "For contracts that support it, will determine if historical data includes outside of regular trading hours.") @QueryParam(
                    "outsideRth") Boolean outsideRth,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverMarketdataHistoryGet(conid, period, exchange, bar, outsideRth, securityContext);
    }

    @GET
    @Path("/marketdata/snapshot")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data",
            notes = "Get Market Data for the given conid(s). The endpoint will return by default bid, ask, last, change, change pct, close, listing exchange. See response fields for a list of available fields that can be request via fields argument. The endpoint /iserver/accounts must be called prior to /iserver/marketdata/snapshot. For derivative contracts the endpoint /iserver/secdef/search must be called first.  If you call any other endpoints that relays back market data for the same contract, such as /iserver/contract/rules then you must query market data again to ensure all fields are properly returned.  First /snapshot endpoint call for given conid will initiate the market data request.  To receive all available fields the /snapshot endpoint will need to be called several times. To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details. ",
            response = Object.class,
            responseContainer = "List",
            tags = {"Market Data",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Returns an array of objects",
            response = Object.class,
            responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 400,
                    message = "sent when accounts are not queried before sending this request",
                    response = Object.class)})
    public Response iserverMarketdataSnapshotGet(
            @ApiParam(value = "list of conids separated by comma", required = true) @QueryParam("conids") String conids,
            @ApiParam(value = "time period since which updates are required. uses epoch time with milliseconds.") @QueryParam(
                    "since") Integer since,
            @ApiParam(value = "list of fields separated by comma") @QueryParam("fields") String fields,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverMarketdataSnapshotGet(conids, since, fields, securityContext);
    }

    @GET
    @Path("/marketdata/unsubscribeall")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data Cancel (All)",
            notes = "Cancel all market data request(s). To cancel market data for given conid, see /iserver/marketdata/{conid}/unsubscribe. ",
            response = Object.class,
            tags = {"Market Data",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "confirms market data is cancelled",
            response = Object.class)})
    public Response iserverMarketdataUnsubscribeallGet(
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverMarketdataUnsubscribeallGet(securityContext);
    }

    @POST
    @Path("/reauthenticate")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Tries to re-authenticate to Brokerage",
            notes = "When using the CP Gateway, this endpoint provides a way to reauthenticate to the Brokerage system as long as there is a valid SSO session, see /sso/validate. ",
            response = AuthStatus.class,
            tags = {"Session",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Authentication Status",
            response = AuthStatus.class)})
    public Response iserverReauthenticatePost(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverReauthenticatePost(securityContext);
    }

    @POST
    @Path("/reply/{replyid}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Place Order Reply",
            notes = "Reply to questions when placing orders and submit orders",
            response = Object.class,
            responseContainer = "List",
            tags = {"Order",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Order is submitted successfully, returns an array contains one object",
            response = Object.class,
            responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 400,
                    message = "When you send \"confirmed-false\" in the request, you will receive this",
                    response = Object.class)})
    public Response iserverReplyReplyidPost(
            @ApiParam(value = "Please use the \"id\" from the response of \"Place Order\" endpoint",
                    required = true) @PathParam("replyid") String replyid,
            @ApiParam(value = "Answer to question", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverReplyReplyidPost(replyid, body, securityContext);
    }

    @GET
    @Path("/scanner/params")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Scanner Parameters",
            notes = "Returns an object contains four lists contain all parameters for scanners",
            response = Object.class,
            tags = {"Scanner",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An object contains lists",
            response = Object.class)})
    public Response iserverScannerParamsGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverScannerParamsGet(securityContext);
    }

    @POST
    @Path("/scanner/run")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "run scanner to get a list of contracts",
            notes = "",
            response = Object.class,
            responseContainer = "List",
            tags = {"Scanner",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public Response iserverScannerRunPost(
            @ApiParam(value = "scanner-params request", required = true) ScannerParams body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverScannerRunPost(body, securityContext);
    }

    @GET
    @Path("/secdef/info")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Secdef Info",
            notes = "Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price for Options/Warrants use \"/iserver/secdef/strikes\" endpoint. Must call /secdef/search for the underlying contract first.",
            response = SecdefInfo.class,
            responseContainer = "List",
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array of objects",
            response = SecdefInfo.class,
            responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "error while processing the request",
                    response = Object.class)})
    public Response iserverSecdefInfoGet(
            @ApiParam(value = "underlying contract id", required = true) @QueryParam("conid") String conid,
            @ApiParam(value = "FUT/OPT/WAR/CASH/CFD", required = true) @QueryParam("sectype") String sectype,
            @ApiParam(value = "contract month, only required for FUT/OPT/WAR in the format MMMYY, example JAN00") @QueryParam(
                    "month") String month,
            @ApiParam(value = "optional, default is SMART") @QueryParam("exchange") String exchange,
            @ApiParam(value = "optional, only required for OPT/WAR") @QueryParam("strike") String strike,
            @ApiParam(value = "C for call, P for put") @QueryParam("right") String right,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverSecdefInfoGet(conid, sectype, month, exchange, strike, right, securityContext);
    }

    @POST
    @Path("/secdef/search")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Search by Symbol or Name",
            notes = "Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must be called before using /secdef/info. If company name is specified will only receive limited response: conid, companyName, companyHeader and symbol. ",
            response = Object.class,
            responseContainer = "List",
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array of results",
            response = Object.class,
            responseContainer = "List"),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "error while processing the request",
                    response = Object.class)})
    public Response iserverSecdefSearchPost(
            @ApiParam(value = "Symbol or Company Name to be searched", required = true) Symbol symbol,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverSecdefSearchPost(symbol, securityContext);
    }

    @GET
    @Path("/secdef/strikes")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Search Strikes",
            notes = "Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and exchanges use \"/iserver/secdef/search\"",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object contains call/put strike prices",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "error while processing the request",
                    response = Object.class)})
    public Response iserverSecdefStrikesGet(@ApiParam(value = "contract id of the underlying contract",
            required = true) @QueryParam("conid") String conid,
            @ApiParam(value = "OPT/WAR", required = true) @QueryParam("sectype") String sectype,
            @ApiParam(value = "contract month", required = true) @QueryParam("month") String month,
            @ApiParam(value = "optional, default is SMART") @QueryParam("exchange") String exchange,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.iserverSecdefStrikesGet(conid, sectype, month, exchange, securityContext);
    }
}
