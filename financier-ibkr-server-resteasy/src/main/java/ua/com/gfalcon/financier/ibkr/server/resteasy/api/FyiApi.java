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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Notifications;

@Path("/fyi")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the fyi API")
public class FyiApi {

    @Inject
    FyiApiService service;

    @DELETE
    @Path("/deliveryoptions/{deviceId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Delete a device",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "200 means successful",
            response = Object.class)})
    public Response fyiDeliveryoptionsDeviceIdDelete(@PathParam("deviceId") String deviceId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDeliveryoptionsDeviceIdDelete(deviceId, securityContext);
    }

    @POST
    @Path("/deliveryoptions/device")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Enable/Disable device option",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "200 means successful",
            response = Object.class)})
    public Response fyiDeliveryoptionsDevicePost(@ApiParam(value = "device info", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDeliveryoptionsDevicePost(body, securityContext);
    }

    @PUT
    @Path("/deliveryoptions/email")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Enable/Disable email option",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "200 means successful",
            response = Object.class)})
    public Response fyiDeliveryoptionsEmailPut(@NotNull @QueryParam("enabled") String enabled,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDeliveryoptionsEmailPut(enabled, securityContext);
    }

    @GET
    @Path("/deliveryoptions")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get delivery options",
            notes = "options for sending fyis to email and other devices ",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An object",
            response = Object.class)})
    public Response fyiDeliveryoptionsGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDeliveryoptionsGet(securityContext);
    }

    @GET
    @Path("/disclaimer/{typecode}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get disclaimer for a certain kind of fyi",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "receives the disclaimer message",
            response = Object.class)})
    public Response fyiDisclaimerTypecodeGet(@PathParam("typecode") String typecode,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDisclaimerTypecodeGet(typecode, securityContext);
    }

    @PUT
    @Path("/disclaimer/{typecode}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Mark disclaimer read",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "200 means successful",
            response = Object.class)})
    public Response fyiDisclaimerTypecodePut(@PathParam("typecode") String typecode,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiDisclaimerTypecodePut(typecode, securityContext);
    }

    @GET
    @Path("/notifications")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get a list of notifications",
            notes = "",
            response = Notifications.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array",
            response = Notifications.class)})
    public Response fyiNotificationsGet(@NotNull @QueryParam("max") String max, @QueryParam("exclude") String exclude,
            @QueryParam("include") String include, @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiNotificationsGet(max, exclude, include, securityContext);
    }

    @GET
    @Path("/notifications/more")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get more notifications based on a certain one",
            notes = "",
            response = Notifications.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array",
            response = Notifications.class)})
    public Response fyiNotificationsMoreGet(@NotNull @QueryParam("id") String id,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiNotificationsMoreGet(id, securityContext);
    }

    @PUT
    @Path("/notifications/{notificationId}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get a list of notifications",
            notes = "",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "when 200 receives, it means successful",
            response = Object.class)})
    public Response fyiNotificationsNotificationIdPut(@PathParam("notificationId") String notificationId,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiNotificationsNotificationIdPut(notificationId, securityContext);
    }

    @GET
    @Path("/settings")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get a list of subscriptions",
            notes = "Return the current choices of subscriptions, we can toggle the option ",
            response = Object.class,
            responseContainer = "List",
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An array",
            response = Object.class,
            responseContainer = "List")})
    public Response fyiSettingsGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiSettingsGet(securityContext);
    }

    @POST
    @Path("/settings/{typecode}")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Enable/Disable certain subscription",
            notes = "Configure which typecode you would like to enable/disable. ",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "200 means successful",
            response = Object.class)})
    public Response fyiSettingsTypecodePost(@PathParam("typecode") String typecode,
            @ApiParam(value = "", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiSettingsTypecodePost(typecode, body, securityContext);
    }

    @GET
    @Path("/unreadnumber")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Get unread number of fyis. The HTTP method POST is also supported.",
            notes = "Returns the total number of unread fyis ",
            response = Object.class,
            tags = {"FYI",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "An object",
            response = Object.class)})
    public Response fyiUnreadnumberGet(@Context SecurityContext securityContext) throws NotFoundException {
        return service.fyiUnreadnumberGet(securityContext);
    }
}
