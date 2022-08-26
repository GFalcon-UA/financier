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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ua.com.gfalcon.financier.ibkr.model.ValidateSso;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.factories.SsoApiServiceFactory;

@Path("/sso")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the sso API")

public class SsoApi {
    private final SsoApiService delegate;

    public SsoApi(@Context ServletConfig servletContext) {
        SsoApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("SsoApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (SsoApiService) Class.forName(implClass)
                            .newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = SsoApiServiceFactory.getSsoApi();
        }

        this.delegate = delegate;
    }

    @GET
    @Path("/validate")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Validate SSO",
            notes = "Validates the current session for the SSO user",
            response = ValidateSso.class,
            tags = {"Session",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An Object",
            response = ValidateSso.class),

            @io.swagger.annotations.ApiResponse(code = 401, message = "Authentication failed", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "System failed", response = Void.class)})
    public Response ssoValidateGet(@Context SecurityContext securityContext) throws NotFoundException {
        return delegate.ssoValidateGet(securityContext);
    }
}
