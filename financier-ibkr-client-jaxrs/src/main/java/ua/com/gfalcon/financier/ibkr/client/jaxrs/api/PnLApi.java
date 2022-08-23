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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface PnLApi {

    /**
     * PnL for the selected account
     * <p>
     * Returns an object containing PnL for the selected account and its models (if any). To receive streaming PnL the
     * endpoint /ws can be used. Refer to [Streaming WebSocket
     * Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.
     */
    @GET
    @Path("/iserver/account/pnl/partitioned")
    @Produces({"application/json"})
    @ApiOperation(value = "PnL for the selected account", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "An object containing account and model(s) pnl",
            response = Object.class)})
    public Object iserverAccountPnlPartitionedGet();
}

