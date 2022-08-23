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

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Secdef;

@Path("/trsrv")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the trsrv API")
public class TrsrvApi {

    @Inject
    TrsrvApiService service;

    @GET
    @Path("/futures")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Security Futures by Symbol",
            notes = "Returns a list of non-expired future contracts for given symbol(s)",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object with symbol and and array of its future contracts",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "error while processing the request",
                    response = Object.class)})
    public Response trsrvFuturesGet(@NotNull @QueryParam("symbols") String symbols,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.trsrvFuturesGet(symbols, securityContext);
    }

    @POST
    @Path("/secdef")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Secdef by Conid",
            notes = "Returns a list of security definitions for the given conids",
            response = Secdef.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an array of secdef info",
            response = Secdef.class)})
    public Response trsrvSecdefPost(@ApiParam(value = "request body", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.trsrvSecdefPost(body, securityContext);
    }

    @GET
    @Path("/secdef/schedule")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get trading schedule for symbol",
            notes = "Returns the trading schedule up to a month for the requested contract",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Returns an object",
            response = Object.class)})
    public Response trsrvSecdefScheduleGet(@NotNull @QueryParam("assetClass") String assetClass,
            @NotNull @QueryParam("symbol") String symbol, @QueryParam("exchange") String exchange,
            @QueryParam("exchangeFilter") String exchangeFilter,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.trsrvSecdefScheduleGet(assetClass, symbol, exchange, exchangeFilter, securityContext);
    }

    @GET
    @Path("/stocks")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Security Stocks by Symbol",
            notes = "Returns an object contains all stock contracts for given symbol(s)",
            response = Object.class,
            tags = {"Contract",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object with symbols",
            response = Object.class),

            @io.swagger.annotations.ApiResponse(code = 500,
                    message = "error while processing the request",
                    response = Object.class)})
    public Response trsrvStocksGet(@NotNull @QueryParam("symbols") String symbols,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.trsrvStocksGet(symbols, securityContext);
    }
}
