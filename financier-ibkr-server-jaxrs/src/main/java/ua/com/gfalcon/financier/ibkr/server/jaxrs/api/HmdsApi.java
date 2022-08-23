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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.HistoryResult;
import ua.com.gfalcon.financier.ibkr.model.ScannerResult;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.factories.HmdsApiServiceFactory;

@Path("/hmds")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the hmds API")

public class HmdsApi {
    private final HmdsApiService delegate;

    public HmdsApi(@Context ServletConfig servletContext) {
        HmdsApiService delegate = null;

        if (servletContext != null) {
            String implClass = servletContext.getInitParameter("HmdsApi.implementation");
            if (implClass != null && !"".equals(implClass.trim())) {
                try {
                    delegate = (HmdsApiService) Class.forName(implClass)
                            .newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (delegate == null) {
            delegate = HmdsApiServiceFactory.getHmdsApi();
        }

        this.delegate = delegate;
    }

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
    public Response hmdsHistoryGet(@ApiParam(value = "contract id", required = true) @QueryParam("conid") Integer conid,
            @ApiParam(value = "Time period for history request.    * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months   * y: Years ",
                    required = true,
                    allowableValues = "min, h, d, w, m, y") @QueryParam("period") String period,
            @ApiParam(value = "Duration of time for each candlestick bar.   * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months ",
                    allowableValues = "min, h, d, w, m") @QueryParam("bar") String bar,
            @ApiParam(value = "For contracts that support it, will determine if history data includes outside of regular trading hours.") @QueryParam(
                    "outsideRth") Boolean outsideRth,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.hmdsHistoryGet(conid, period, bar, outsideRth, securityContext);
    }

    @POST
    @Path("/scanner")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Run Scanner (Beta)",
            notes = "Using a direct connection to the market data farm, will provide results to the requested scanner.",
            response = ScannerResult.class,
            tags = {"Scanner",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "Valid result",
            response = ScannerResult.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Void.class)})
    public Response hmdsScannerPost(@ApiParam(value = "request body", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.hmdsScannerPost(body, securityContext);
    }
}
