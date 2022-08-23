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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.factories.TickleApiServiceFactory;

@Path("/tickle")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the tickle API")

public class TickleApi {
    private final TickleApiService delegate;

    public TickleApi(@Context ServletConfig servletContext) {
        TickleApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("TickleApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (TickleApiService) Class.forName(implClass)
                            .newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = TickleApiServiceFactory.getTickleApi();
        }

        this.delegate = delegate;
    }

    @POST


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Ping the server to keep the session open",
            notes = "If the gateway has not received any requests for several minutes an open session will automatically timeout. The tickle endpoint pings the server to prevent the session from ending.",
            response = Void.class,
            tags = {"Session",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "confirms session is open",
            response = Void.class)})
    public Response ticklePost(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.ticklePost(securityContext);
    }
}
