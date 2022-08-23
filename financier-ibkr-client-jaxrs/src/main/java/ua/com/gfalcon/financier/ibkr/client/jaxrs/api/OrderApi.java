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

package ua.com.gfalcon.financier.ibkr.client.jaxrs.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.ModifyOrder;
import ua.com.gfalcon.financier.ibkr.model.OrderRequest;
import ua.com.gfalcon.financier.ibkr.model.OrderStatus;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface OrderApi {

    /**
     * Cancel Order
     * <p>
     * Cancels an open order. Must call /iserver/accounts endpoint prior to cancelling an order. Use
     * /iservers/account/orders endpoint to review open-order(s) and get latest order status.
     */
    @DELETE
    @Path("/iserver/account/{accountId}/order/{orderId}")
    @Produces({"application/json"})
    @ApiOperation(value = "Cancel Order", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object with order id, message, conid and account id",
            response = Object.class)})
    public Object iserverAccountAccountIdOrderOrderIdDelete(@PathParam("accountId") String accountId,
            @PathParam("orderId") String orderId);

    /**
     * Modify Order
     * <p>
     * Modifies an open order. Must call /iserver/accounts endpoint prior to modifying an order. Use
     * /iservers/account/orders endpoint to review open-order(s).
     */
    @POST
    @Path("/iserver/account/{accountId}/order/{orderId}")
    @Produces({"application/json"})
    @ApiOperation(value = "Modify Order", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverAccountAccountIdOrderOrderIdPost(@PathParam("accountId") String accountId,
            @PathParam("orderId") String orderId, ModifyOrder body);

    /**
     * Place Order (Deprecated)
     * <p>
     * This endpoint is going to be deprecated, you can use /iserver/account/{accountId}/orders, just pass one order in
     * the array, the order structure will be same. Please note here, sometimes this endpoint alone can&#39;t make sure
     * you submit the order successfully, you could receive some questions in the response, you have to to answer them
     * in order to submit the order successfully. You can use \&quot;/iserver/reply/{replyid}\&quot; endpoint to answer
     * questions
     */
    @POST
    @Path("/iserver/account/{accountId}/order")
    @Produces({"application/json"})
    @ApiOperation(value = "Place Order (Deprecated)", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverAccountAccountIdOrderPost(@PathParam("accountId") String accountId, OrderRequest body);

    /**
     * Preview Order (Deprecated)
     * <p>
     * This end-point is going to be deprecated, you can use /iserver/account/{accountId}/orders/whatif, just pass one
     * order in the array, the order structure will be same. This endpoint allows you to preview order without actually
     * submitting the order and you can get commission information in the response.
     */
    @POST
    @Path("/iserver/account/{accountId}/order/whatif")
    @Produces({"application/json"})
    @ApiOperation(value = "Preview Order (Deprecated)", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Object.class)})
    public Object iserverAccountAccountIdOrderWhatifPost(@PathParam("accountId") String accountId, OrderRequest body);

    /**
     * Place Orders
     * <p>
     * When connected to an IServer Brokerage Session, this endpoint will allow you to submit orders.  CP WEB API
     * supports various advanced orderTypes, for additional details and examples refer to [IBKR Quant
     * Blog](https://www.tradersinsight.news/category/ibkr-quant-news/programming_languages/rest-development/).   *
     * Bracket - Attach additional opposite-side order(s) by using a single **cOID** sent with the parent and set the
     * same value for **parentId** in each child order(s).   * Cash Quantity -  Send orders using monetary value by
     * specifying **cashQty** instead of quantity, e.g. cashQty: 200. The endpoint /iserver/contract/rules returns list
     * of valid orderTypes in cqtTypes.   * Currency Conversion - Convert cash from one currency to another by including
     * **isCcyConv** &#x3D; **true**. To specify the cash quantity use **fxQTY** instead of quantity, e.g. fxQTY: 100.
     * * Fractional - Contracts that support fractional shares can be traded by specifying **quantity** as a float, e.g.
     * quantity: 0.001. The endpoint /iserver/contract/rules returns a list of valid orderTypes in fraqTypes.   * IB
     * Algos - Attached user-defined settings to your trades by using any of IBKR&#39;s Algo Orders. Use the endpoint
     * /iserver/contract/{conid}/algos to identify the available strategies for a contract.   * One-Cancels-All (OCA) -
     * Group multiple unrelated orders by passing order request info in an array and including **isSingleGroup &#x3D;
     * true** for each order. All orders will be assigned the same oca_group_id.
     */
    @POST
    @Path("/iserver/account/{accountId}/orders")
    @Produces({"application/json"})
    @ApiOperation(value = "Place Orders", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverAccountAccountIdOrdersPost(@PathParam("accountId") String accountId, Body body);

    /**
     * Preview Orders
     * <p>
     * This endpoint allows you to preview order without actually submitting the order and you can get commission
     * information in the response. Also supports bracket orders.
     */
    @POST
    @Path("/iserver/account/{accountId}/orders/whatif")
    @Produces({"application/json"})
    @ApiOperation(value = "Preview Orders", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Object.class)})
    public Object iserverAccountAccountIdOrdersWhatifPost(@PathParam("accountId") String accountId, Body body);

    /**
     * Order Status
     */
    @GET
    @Path("/iserver/account/order/status/{orderId}")
    @Produces({"application/json"})
    @ApiOperation(value = "Order Status", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = OrderStatus.class)})
    public OrderStatus iserverAccountOrderStatusOrderIdGet(@PathParam("orderId") String orderId);

    /**
     * Place Orders for FA
     * <p>
     * Financial Advisors can use this endpoint to place an order for a specified group. To place an order for a
     * specified account use the endpoint /iserver/account/{accountId}/order. More information about groups can be found
     * in the [TWS Users&#39;
     * Guide:](https://guides.interactivebrokers.com/twsguide/twsguide.htm#usersguidebook/financialadvisors/create_an_account_group_for_share_allocation.htm).
     */
    @POST
    @Path("/iserver/account/orders/{faGroup}")
    @Produces({"application/json"})
    @ApiOperation(value = "Place Orders for FA", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverAccountOrdersFaGroupPost(@PathParam("faGroup") String faGroup, OrderRequest body);

    /**
     * Live Orders
     * <p>
     * The endpoint is meant to be used in polling mode, e.g. requesting every x seconds. The response will contain two
     * objects, one is notification, the other is orders. Orders is the list of live orders (cancelled, filled,
     * submitted). Notifications contains information about execute orders as they happen, see status field. To receive
     * streaming live orders the endpoint /ws can be used. Refer to [Streaming WebSocket
     * Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.
     */
    @GET
    @Path("/iserver/account/orders")
    @Produces({"application/json"})
    @ApiOperation(value = "Live Orders", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "An object contains two arrays",
            response = Object.class)})
    public Object iserverAccountOrdersGet(Body body);

    /**
     * Place Order Reply
     * <p>
     * Reply to questions when placing orders and submit orders
     */
    @POST
    @Path("/iserver/reply/{replyid}")
    @Produces({"application/json"})
    @ApiOperation(value = "Place Order Reply", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Order is submitted successfully, returns an array contains one object",
            response = Object.class,
            responseContainer = "List"), @ApiResponse(code = 400,
            message = "When you send \"confirmed-false\" in the request, you will receive this",
            response = Object.class)})
    public List<Object> iserverReplyReplyidPost(@PathParam("replyid") String replyid, Body body);
}

