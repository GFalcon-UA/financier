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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.AuthStatus;
import ua.com.gfalcon.financier.ibkr.model.BooleanConfirmed;
import ua.com.gfalcon.financier.ibkr.model.ValidateSso;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface SessionApi {

    /**
     * Authentication Status
     * <p>
     * Current Authentication status to the Brokerage system. Market Data and Trading is not possible if not
     * authenticated, e.g. authenticated shows false
     */
    @POST
    @Path("/iserver/auth/status")
    @Produces({"application/json"})
    @ApiOperation(value = "Authentication Status", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Authentication Status", response = AuthStatus.class)})
    public AuthStatus iserverAuthStatusPost();

    /**
     * Tries to re-authenticate to Brokerage
     * <p/>
     * When using the CP Gateway, this endpoint provides a way to reauthenticate to the Brokerage system as long as
     * there is a valid SSO session, see /sso/validate.
     */
    @POST
    @Path("/iserver/reauthenticate")
    @Produces({"application/json"})
    @ApiOperation(value = "Tries to re-authenticate to Brokerage", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Authentication Status", response = AuthStatus.class)})
    public AuthStatus iserverReauthenticatePost();

    /**
     * Ends the current session
     * <p/>
     * Logs the user out of the gateway session. Any further activity requires re-authentication.
     */
    @POST
    @Path("/logout")
    @Produces({"application/json"})
    @ApiOperation(value = "Ends the current session", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returned status indicates if user is logged in",
            response = BooleanConfirmed.class)})
    public BooleanConfirmed logoutPost();

    /**
     * Validate SSO
     * <p/>
     * Validates the current session for the SSO user
     */
    @GET
    @Path("/sso/validate")
    @Produces({"application/json"})
    @ApiOperation(value = "Validate SSO", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "An Object",
            response = ValidateSso.class), @ApiResponse(code = 401,
            message = "Authentication failed"), @ApiResponse(code = 500, message = "System failed")})
    public ValidateSso ssoValidateGet();

    /**
     * Ping the server to keep the session open
     * <p>
     * If the gateway has not received any requests for several minutes an open session will automatically timeout. The
     * tickle endpoint pings the server to prevent the session from ending.
     */
    @POST
    @Path("/tickle")
    @Produces({"application/json"})
    @ApiOperation(value = "Ping the server to keep the session open", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "confirms session is open")})
    public void ticklePost();
}

