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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/ws")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the ws API")
public class WsApi {

    @Inject
    WsApiService service;

    @POST


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Websocket Endpoint",
            notes = "The streaming API is documented under [Streaming WebSocket Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.",
            response = Void.class,
            tags = {"Streaming",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "confirms session is open",
            response = Void.class)})
    public Response wsPost(@Context SecurityContext securityContext) throws NotFoundException {
        return service.wsPost(securityContext);
    }
}
