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

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Performance;
import ua.com.gfalcon.financier.ibkr.model.Summary;
import ua.com.gfalcon.financier.ibkr.model.Transactions;

@Path("/pa")

@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the pa API")
public class PaApi {

    @Inject
    PaApiService service;

    @POST
    @Path("/performance")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Account Performance",
            notes = "Returns the performance (MTM) for the given accounts, if more than one account is passed, the result is consolidated.",
            response = Performance.class,
            tags = {"PortfolioAnalyst",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Performance.class)})
    public Response paPerformancePost(@ApiParam(value = "an array of account ids", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.paPerformancePost(body, securityContext);
    }

    @POST
    @Path("/summary")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Account Balance's Summary",
            notes = "Returns a summary of all account balances for the given accounts, if more than one account is passed, the result is consolidated.",
            response = Summary.class,
            tags = {"PortfolioAnalyst",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Summary.class)})
    public Response paSummaryPost(@ApiParam(value = "an array of account ids", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.paSummaryPost(body, securityContext);
    }

    @POST
    @Path("/transactions")

    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Position's Transaction History",
            notes = "transaction history for a given number of conids and accounts. Types of transactions include dividend payments, buy and sell transactions, transfers. ",
            response = Transactions.class,
            tags = {"PortfolioAnalyst",})
    @io.swagger.annotations.ApiResponses(value = {@io.swagger.annotations.ApiResponse(code = 200,
            message = "returns an object",
            response = Transactions.class)})
    public Response paTransactionsPost(@ApiParam(value = "", required = true) Body body,
            @Context SecurityContext securityContext) throws NotFoundException {
        return service.paTransactionsPost(body, securityContext);
    }
}
