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

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Performance;
import ua.com.gfalcon.financier.ibkr.model.Summary;
import ua.com.gfalcon.financier.ibkr.model.Transactions;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface PortfolioAnalystApi {

    /**
     * Account Performance
     * <p>
     * Returns the performance (MTM) for the given accounts, if more than one account is passed, the result is
     * consolidated.
     */
    @POST
    @Path("/pa/performance")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Performance", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Performance.class)})
    public Performance paPerformancePost(Body body);

    /**
     * Account Balance&#39;s Summary
     * <p>
     * Returns a summary of all account balances for the given accounts, if more than one account is passed, the result
     * is consolidated.
     */
    @POST
    @Path("/pa/summary")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Balance's Summary", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Summary.class)})
    public Summary paSummaryPost(Body body);

    /**
     * Position&#39;s Transaction History
     * <p>
     * transaction history for a given number of conids and accounts. Types of transactions include dividend payments,
     * buy and sell transactions, transfers.
     */
    @POST
    @Path("/pa/transactions")
    @Produces({"application/json"})
    @ApiOperation(value = "Position's Transaction History", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Transactions.class)})
    public Transactions paTransactionsPost(Body body);
}

