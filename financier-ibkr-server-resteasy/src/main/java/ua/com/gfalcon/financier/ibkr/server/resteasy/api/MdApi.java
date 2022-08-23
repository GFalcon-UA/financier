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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ua.com.gfalcon.financier.ibkr.model.MarketData;

@Path("/md")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the md API")
public class MdApi {

    @Inject
    MdApiService service;

    @GET
    @Path("/snapshot")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Market Data Snapshot (Beta)",
            notes = "Get a snapshot of Market Data for the given conid(s).See response for a list of available fields that can be requested from the fields argument. Must be connected to a brokerage session before can query snapshot data. First /snapshot endpoint call for given conid(s) will initiate the market data request, make an additional request to receive field values back. To receive all available fields the /snapshot endpoint will need to be called several times. To receive streaming market data the endpoint /ws can be used. Refer to [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details. ",
            response = MarketData.class,
            tags = {"Market Data",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = MarketData.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System failed", response = Void.class)})
    public Response mdSnapshotGet(@NotNull @QueryParam("conids") String conids, @QueryParam("fields") String fields,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.mdSnapshotGet(conids, fields, securityContext);
    }
}
