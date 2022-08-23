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

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.Auth;
import ua.com.gfalcon.financier.ibkr.model.OrderData;
import ua.com.gfalcon.financier.ibkr.model.PositionData;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface CcpBetaApi {

    /**
     * Brokerage Accounts
     * <p>
     * Provides the list of tradeable accounts
     */
    @GET
    @Path("/ccp/account")
    @Produces({"application/json"})
    @ApiOperation(value = "Brokerage Accounts", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array of accounts", response = Object.class)})
    public Object ccpAccountGet();

    /**
     * Start CCP Session
     * <p>
     * Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage
     * session to iServer is running then call the endpoint /logout first. Note at this time only order management is
     * possible from CCP session, market data and scanner endpoints can&#39;t be used since they are only available from
     * iServer session. Work is in progress to provide new CCP endpoints for market data and scanners.
     */
    @POST
    @Path("/ccp/auth/init")
    @Consumes({"application/x-www-form-urlencoded"})
    @Produces({"application/json"})
    @ApiOperation(value = "Start CCP Session", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Returns challenge for connection",
            response = Object.class), @ApiResponse(code = 401, message = "Access denied"), @ApiResponse(code = 500,
            message = "System error")})
    public Object ccpAuthInitPost(@Multipart(value = "compete", required = false) Boolean compete,
            @Multipart(value = "locale", required = false) String locale,
            @Multipart(value = "mac", required = false) String mac,
            @Multipart(value = "machineId", required = false) String machineId,
            @Multipart(value = "username", required = false) String username);

    /**
     * Complete CCP Session
     * <p>
     * Session Token Authentication
     */
    @POST
    @Path("/ccp/auth/response")
    @Produces({"application/json"})
    @ApiOperation(value = "Complete CCP Session", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Valid result", response = Object.class), @ApiResponse(
            code = 401,
            message = "Access denied"), @ApiResponse(code = 500, message = "System error")})
    public Object ccpAuthResponsePost(Auth auth);

    /**
     * Delete Order
     * <p>
     * Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments
     * as GET is also supported (requires passing action&#x3D;delete) (GET is meant for development only)
     */
    @DELETE
    @Path("/ccp/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Delete Order", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An Object", response = OrderData.class), @ApiResponse(
            code = 401,
            message = "Access denied"), @ApiResponse(code = 500,
            message = "System error, for example when connection to CCP failed")})
    public OrderData ccpOrderDelete(@QueryParam("acct") String acct, @QueryParam("id") BigDecimal id);

    /**
     * Submit Order
     * <p>
     * Submits an Order.
     */
    @POST
    @Path("/ccp/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Submit Order", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An Object", response = OrderData.class), @ApiResponse(
            code = 400,
            message = "Bad Request"), @ApiResponse(code = 401, message = "Access denied"), @ApiResponse(code = 500,
            message = "System error, for example when connection to CCP failed")})
    public OrderData ccpOrderPost(@QueryParam("acct") String acct, @QueryParam("conid") BigDecimal conid,
            @QueryParam("ccy") String ccy, @QueryParam("exchange") String exchange, @QueryParam("qty") BigDecimal qty,
            @QueryParam("type") String type, @QueryParam("side") String side, @QueryParam("price") BigDecimal price,
            @QueryParam("tif") String tif);

    /**
     * Update Order
     * <p>
     * Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The
     * status of the order can be queried through GET /ccp/order.
     */
    @PUT
    @Path("/ccp/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "Update Order", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An Object", response = OrderData.class), @ApiResponse(
            code = 401,
            message = "Access denied"), @ApiResponse(code = 500,
            message = "System error, for example when connection to CCP failed")})
    public OrderData ccpOrderPut(@QueryParam("acct") String acct, @QueryParam("id") BigDecimal id);

    /**
     * Order Status
     * <p>
     * Get status for all orders
     */
    @GET
    @Path("/ccp/orders")
    @Produces({"application/json"})
    @ApiOperation(value = "Order Status", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "An Object",
            response = Object.class), @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 401,
            message = "Access denied"), @ApiResponse(code = 500, message = "System error")})
    public Object ccpOrdersGet(@QueryParam("acct") String acct, @QueryParam("cancelled") Boolean cancelled);

    /**
     * Positions
     * <p>
     * List of positions
     */
    @GET
    @Path("/ccp/positions")
    @Produces({"application/json"})
    @ApiOperation(value = "Positions", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Valid result",
            response = PositionData.class), @ApiResponse(code = 401,
            message = "Access denied"), @ApiResponse(code = 500, message = "System error")})
    public PositionData ccpPositionsGet();

    /**
     * CCP Status
     * <p>
     * Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage
     * session to CCP by sending /auth/init and response.
     */
    @GET
    @Path("/ccp/status")
    @Produces({"application/json"})
    @ApiOperation(value = "CCP Status", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Valid result", response = Object.class), @ApiResponse(
            code = 401,
            message = "Access denied"), @ApiResponse(code = 500, message = "System error")})
    public Object ccpStatusGet();

    /**
     * Trades
     * <p>
     * Get a list of Trades, by default, the list is from today midnight to Date.now().
     */
    @GET
    @Path("/ccp/trades")
    @Produces({"application/json"})
    @ApiOperation(value = "Trades", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "An Object",
            response = Object.class), @ApiResponse(code = 400, message = "Bad request"), @ApiResponse(code = 401,
            message = "Access denied"), @ApiResponse(code = 500, message = "System error")})
    public Object ccpTradesGet(@QueryParam("from") String from, @QueryParam("to") String to);
}

