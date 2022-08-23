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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.HistoryResult;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface MarketDataBetaApi {

    /**
     * Market Data History
     * <p>
     * Using direct to market data farm connection, will provide a list of historical market data for a given conid
     */
    @GET
    @Path("/hmds/history")
    @Produces({"application/json"})
    @ApiOperation(value = "Market Data History", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Valid result",
            response = HistoryResult.class), @ApiResponse(code = 400, message = "Bad request")})
    public HistoryResult hmdsHistoryGet(@QueryParam("conid") Integer conid, @QueryParam("period") String period,
            @QueryParam("bar") String bar, @QueryParam("outsideRth") Boolean outsideRth);
}

