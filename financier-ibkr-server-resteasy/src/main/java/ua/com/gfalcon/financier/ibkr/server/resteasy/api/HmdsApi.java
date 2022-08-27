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
import ua.com.gfalcon.financier.ibkr.model.HistoryResult;
import ua.com.gfalcon.financier.ibkr.model.ScannerDirect;
import ua.com.gfalcon.financier.ibkr.model.ScannerDirectResult;

@Path("/hmds")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the hmds API")
public class HmdsApi {

    @Inject
    HmdsApiService service;

    @GET
    @Path("/history")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data History",
            notes = "Using direct to market data farm connection, will provide a list of historical market data for a given conid",
            response = HistoryResult.class,
            tags = {"MarketData (Beta)",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = HistoryResult.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Void.class)})
    public Response hmdsHistoryGet(@NotNull @QueryParam("conid") Integer conid,
            @NotNull @QueryParam("period") String period, @QueryParam("bar") String bar,
            @QueryParam("outsideRth") Boolean outsideRth,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.hmdsHistoryGet(conid, period, bar, outsideRth, securityContext);
    }

    @POST
    @Path("/scanner")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Run Scanner (Beta)",
            notes = "Using a direct connection to the market data farm, will provide results to the requested scanner.",
            response = ScannerDirectResult.class,
            tags = {"Scanner",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = ScannerDirectResult.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Void.class)})
    public Response hmdsScannerPost(@ApiParam(value = "request body", required = true) ScannerDirect body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.hmdsScannerPost(body, securityContext);
    }
}
