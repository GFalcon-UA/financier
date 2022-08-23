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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.Account;
import ua.com.gfalcon.financier.ibkr.model.Accounts;
import ua.com.gfalcon.financier.ibkr.model.Allocation;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Position;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface PortfolioApi {

    /**
     * Account Allocation
     * <p>
     * Information about the account&#39;s portfolio allocation by Asset Class, Industry and Category.
     * /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.
     */
    @GET
    @Path("/portfolio/{accountId}/allocation")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Allocation", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object of three different allocations",
            response = Allocation.class)})
    public Allocation portfolioAccountIdAllocationGet(@PathParam("accountId") String accountId);

    /**
     * Account Ledger
     * <p>
     * Information regarding settled cash, cash balances, etc. in the account&#39;s base currency and any other cash
     * balances hold in other currencies.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint. The list of supported currencies is available at
     * https://www.interactivebrokers.com/en/index.php?f&#x3D;3185.
     */
    @GET
    @Path("/portfolio/{accountId}/ledger")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Ledger", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "200 means successful", response = Object.class)})
    public Object portfolioAccountIdLedgerGet(@PathParam("accountId") String accountId);

    /**
     * Account Information
     * <p>
     * Account information related to account Id /portfolio/accounts or /portfolio/subaccounts must be called prior to
     * this endpoint.
     */
    @GET
    @Path("/portfolio/{accountId}/meta")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Information", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An object", response = Accounts.class)})
    public Accounts portfolioAccountIdMetaGet(@PathParam("accountId") String accountId);

    /**
     * Position by Conid
     * <p>
     * Returns a list of all positions matching the conid. For portfolio models the conid could be in more than one
     * model, returning an array with the name of the model it belongs to.  /portfolio/accounts or
     * /portfolio/subaccounts must be called prior to this endpoint.
     */
    @GET
    @Path("/portfolio/{accountId}/position/{conid}")
    @Produces({"application/json"})
    @ApiOperation(value = "Position by Conid", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns a list containing only one position for the conid",
            response = Position.class)})
    public Position portfolioAccountIdPositionConidGet(@PathParam("accountId") String accountId,
            @PathParam("conid") Integer conid);

    /**
     * Invalidates the backend cache of the Portfolio
     */
    @POST
    @Path("/portfolio/{accountId}/positions/invalidate")
    @Produces({"application/json"})
    @ApiOperation(value = "Invalidates the backend cache of the Portfolio", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Means successful", response = Object.class)})
    public Object portfolioAccountIdPositionsInvalidatePost(@PathParam("accountId") String accountId);

    /**
     * Portfolio Positions
     * <p>
     * Returns a list of positions for the given account. The endpoint supports paging, page&#39;s default size is 30
     * positions. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.
     */
    @GET
    @Path("/portfolio/{accountId}/positions/{pageId}")
    @Produces({"application/json"})
    @ApiOperation(value = "Portfolio Positions", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns a list of positions in the portfolio",
            response = Position.class)})
    public Position portfolioAccountIdPositionsPageIdGet(@PathParam("accountId") String accountId,
            @PathParam("pageId") String pageId, @QueryParam("model") String model, @QueryParam("sort") String sort,
            @QueryParam("direction") String direction, @QueryParam("period") String period);

    /**
     * Account Summary
     * <p>
     * Returns information about margin, cash balances and other information related to specified account. See also
     * /portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint.
     */
    @GET
    @Path("/portfolio/{accountId}/summary")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Summary", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object containing account summary. The object contains multiple properties. A property is sufficed with -c if its provides commodity value, -s if it provides security value and -c if its UKL segment value",
            response = Object.class)})
    public Object portfolioAccountIdSummaryGet(@PathParam("accountId") String accountId);

    /**
     * Portfolio Accounts
     * <p>
     * In non-tiered account structures, returns a list of accounts for which the user can view position and account
     * information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For
     * querying a list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered
     * account structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts.
     */
    @GET
    @Path("/portfolio/accounts")
    @Produces({"application/json"})
    @ApiOperation(value = "Portfolio Accounts", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array", response = Accounts.class)})
    public Accounts portfolioAccountsGet();

    /**
     * Account Alloction (All Accounts)
     * <p>
     * Similar to /portfolio/{accountId}/allocation but returns a consolidated view of of all the accounts returned by
     * /portfolio/accounts. /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.
     */
    @POST
    @Path("/portfolio/allocation")
    @Produces({"application/json"})
    @ApiOperation(value = "Account Alloction (All Accounts)", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object of three different allocations",
            response = Allocation.class)})
    public Allocation portfolioAllocationPost(Body body);

    /**
     * Positions by Conid
     * <p>
     * Returns an object of all positions matching the conid for all the selected accounts. For portfolio models the
     * conid could be in more than one model, returning an array with the name of the model it belongs to.
     * /portfolio/accounts or /portfolio/subaccounts must be called prior to this endpoint.
     */
    @GET
    @Path("/portfolio/positions/{conid}")
    @Produces({"application/json"})
    @ApiOperation(value = "Positions by Conid", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object containing account and its position information",
            response = Object.class)})
    public Object portfolioPositionsConidGet(@PathParam("conid") Integer conid);

    /**
     * List of Sub-Accounts
     * <p>
     * Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100
     * sub-accounts for which the user can view position and account-related information. This endpoint must be called
     * prior to calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use
     * /portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts.
     */
    @GET
    @Path("/portfolio/subaccounts")
    @Produces({"application/json"})
    @ApiOperation(value = "List of Sub-Accounts", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An array", response = Account.class)})
    public Account portfolioSubaccountsGet();
}

