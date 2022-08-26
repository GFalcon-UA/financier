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

import ua.com.gfalcon.financier.ibkr.model.BooleanConfirmed;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.factories.LogoutApiServiceFactory;

@Path("/logout")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the logout API")

public class LogoutApi {
    private final LogoutApiService delegate;

    public LogoutApi(@Context ServletConfig servletContext) {
        LogoutApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("LogoutApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (LogoutApiService) Class.forName(implClass)
                            .newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = LogoutApiServiceFactory.getLogoutApi();
        }

        this.delegate = delegate;
    }

    @POST


    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Ends the current session",
            notes = "Logs the user out of the gateway session. Any further activity requires re-authentication.",
            response = BooleanConfirmed.class,
            tags = {"Session",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returned status indicates if user is logged in",
            response = BooleanConfirmed.class)})
    public Response logoutPost(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.logoutPost(securityContext);
    }
}
