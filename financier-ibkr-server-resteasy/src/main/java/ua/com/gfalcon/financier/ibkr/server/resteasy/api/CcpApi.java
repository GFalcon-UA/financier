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

package ua.com.gfalcon.financier.ibkr.server.resteasy.api;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Auth;
import ua.com.gfalcon.financier.ibkr.model.OrderData;
import ua.com.gfalcon.financier.ibkr.model.PositionData;

@Path("/ccp")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the ccp API")
public class CcpApi {

    @Inject
    CcpApiService service;

    @GET
    @Path("/account")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Brokerage Accounts",
            notes = "Provides the list of tradeable accounts",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array of accounts",
            response = Object.class)})
    public Response ccpAccountGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpAccountGet(securityContext);
    }

    @POST
    @Path("/auth/init")
    @Consumes({"application/x-www-form-urlencoded"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Start CCP Session",
            notes = "Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage session to iServer is running then call the endpoint /logout first. Note at this time only order management is possible from CCP session, market data and scanner endpoints can't be used since they are only available from iServer session. Work is in progress to provide new CCP endpoints for market data and scanners.",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Returns challenge for connection",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpAuthInitPost(
            @ApiParam(value = "Allow competing CCP session to run") @FormParam("compete") Boolean compete,
            @ApiParam(value = "Concatenate value for language and region, set to \"en_US\"") @FormParam("locale") String locale,
            @ApiParam(value = "Local MAC Address") @FormParam("mac") String mac,
            @ApiParam(value = "Local machine ID") @FormParam("machineId") String machineId,
            @ApiParam(value = "Login user, set to dash \"-\"") @FormParam("username") String username,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpAuthInitPost(compete, locale, mac, machineId, username, securityContext);
    }

    @POST
    @Path("/auth/response")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Complete CCP Session",
            notes = "Session Token Authentication",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpAuthResponsePost(@ApiParam(value = "") Auth auth,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpAuthResponsePost(auth, securityContext);
    }

    @DELETE
    @Path("/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete Order",
            notes = "Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments as GET is also supported (requires passing action=delete) (GET is meant for development only) ",
            response = OrderData.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = OrderData.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "System error, for example when connection to CCP failed",
                    response = Void.class)})
    public Response ccpOrderDelete(@NotNull @QueryParam("acct") String acct, @NotNull @QueryParam("id") BigDecimal id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpOrderDelete(acct, id, securityContext);
    }

    @POST
    @Path("/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Submit Order",
            notes = "Submits an Order. ",
            response = OrderData.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = OrderData.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "System error, for example when connection to CCP failed",
                    response = Void.class)})
    public Response ccpOrderPost(@NotNull @QueryParam("acct") String acct,
            @NotNull @QueryParam("conid") BigDecimal conid, @NotNull @QueryParam("ccy") String ccy,
            @NotNull @QueryParam("exchange") String exchange, @NotNull @QueryParam("qty") BigDecimal qty,
            @QueryParam("type") String type, @QueryParam("side") String side, @QueryParam("price") BigDecimal price,
            @QueryParam("tif") String tif, @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpOrderPost(acct, conid, ccy, exchange, qty, type, side, price, tif, securityContext);
    }

    @PUT
    @Path("/order")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Update Order",
            notes = "Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The status of the order can be queried through GET /ccp/order. ",
            response = OrderData.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = OrderData.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "System error, for example when connection to CCP failed",
                    response = Void.class)})
    public Response ccpOrderPut(@NotNull @QueryParam("acct") String acct, @NotNull @QueryParam("id") BigDecimal id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpOrderPut(acct, id, securityContext);
    }

    @GET
    @Path("/orders")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Order Status",
            notes = "Get status for all orders",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpOrdersGet(@NotNull @QueryParam("acct") String acct, @QueryParam("cancelled") Boolean cancelled,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpOrdersGet(acct, cancelled, securityContext);
    }

    @GET
    @Path("/positions")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Positions",
            notes = "List of positions",
            response = PositionData.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = PositionData.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpPositionsGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpPositionsGet(securityContext);
    }

    @GET
    @Path("/status")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "CCP Status",
            notes = "Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage session to CCP by sending /auth/init and response.",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpStatusGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpStatusGet(securityContext);
    }

    @GET
    @Path("/trades")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Trades",
            notes = "Get a list of Trades, by default, the list is from today midnight to Date.now(). ",
            response = Object.class,
            tags = {"CCP (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Access denied", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System error", response = Void.class)})
    public Response ccpTradesGet(@QueryParam("from") String from, @QueryParam("to") String to,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.ccpTradesGet(from, to, securityContext);
    }
}
