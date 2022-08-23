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

import java.util.List;

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
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Conid;
import ua.com.gfalcon.financier.ibkr.model.Contract;
import ua.com.gfalcon.financier.ibkr.model.Secdef;
import ua.com.gfalcon.financier.ibkr.model.SecdefInfo;
import ua.com.gfalcon.financier.ibkr.model.Symbol;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface ContractApi {

    /**
     * IB Algo Params
     * <p>
     * Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters.
     */
    @GET
    @Path("/iserver/contract/{conid}/algos")
    @Produces({"application/json"})
    @ApiOperation(value = "IB Algo Params", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array of algos",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverContractConidAlgosGet(@PathParam("conid") String conid,
            @QueryParam("algos") String algos, @QueryParam("addDescription") String addDescription,
            @QueryParam("addParams") String addParams);

    /**
     * Info and Rules
     * <p>
     * Returns both contract info and rules from a single endpoint. For only contract rules, use the endpoint
     * /iserver/contract/rules. For only contract info, use the endpoint /iserver/contract/{conid}/info.
     */
    @GET
    @Path("/iserver/contract/{conid}/info-and-rules")
    @Produces({"application/json"})
    @ApiOperation(value = "Info and Rules", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an array", response = Object.class)})
    public Object iserverContractConidInfoAndRulesGet(@PathParam("conid") String conid,
            @QueryParam("isBuy") Boolean isBuy);

    /**
     * Contract Details
     * <p>
     * Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an
     * order
     */
    @GET
    @Path("/iserver/contract/{conid}/info")
    @Produces({"application/json"})
    @ApiOperation(value = "Contract Details", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an object", response = Contract.class)})
    public Contract iserverContractConidInfoGet(@PathParam("conid") String conid);

    /**
     * Contract Rules
     * <p>
     * Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint
     * /iserver/contract/{conid}/info-and-rules.
     */
    @POST
    @Path("/iserver/contract/rules")
    @Produces({"application/json"})
    @ApiOperation(value = "Contract Rules", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "returns an array", response = Object.class)})
    public Object iserverContractRulesPost(Conid conid);

    /**
     * Secdef Info
     * <p>
     * Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price
     * for Options/Warrants use \&quot;/iserver/secdef/strikes\&quot; endpoint. Must call /secdef/search for the
     * underlying contract first.
     */
    @GET
    @Path("/iserver/secdef/info")
    @Produces({"application/json"})
    @ApiOperation(value = "Secdef Info", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array of objects",
            response = SecdefInfo.class,
            responseContainer = "List"), @ApiResponse(code = 500,
            message = "error while processing the request",
            response = Object.class)})
    public List<SecdefInfo> iserverSecdefInfoGet(@QueryParam("conid") String conid,
            @QueryParam("sectype") String sectype, @QueryParam("month") String month,
            @QueryParam("exchange") String exchange, @QueryParam("strike") String strike,
            @QueryParam("right") String right);

    /**
     * Search by Symbol or Name
     * <p>
     * Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must
     * be called before using /secdef/info. If company name is specified will only receive limited response: conid,
     * companyName, companyHeader and symbol.
     */
    @POST
    @Path("/iserver/secdef/search")
    @Produces({"application/json"})
    @ApiOperation(value = "Search by Symbol or Name", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array of results",
            response = Object.class,
            responseContainer = "List"), @ApiResponse(code = 500,
            message = "error while processing the request",
            response = Object.class)})
    public List<Object> iserverSecdefSearchPost(Symbol symbol);

    /**
     * Search Strikes
     * <p>
     * Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and
     * exchanges use \&quot;/iserver/secdef/search\&quot;
     */
    @GET
    @Path("/iserver/secdef/strikes")
    @Produces({"application/json"})
    @ApiOperation(value = "Search Strikes", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object contains call/put strike prices",
            response = Object.class), @ApiResponse(code = 500,
            message = "error while processing the request",
            response = Object.class)})
    public Object iserverSecdefStrikesGet(@QueryParam("conid") String conid, @QueryParam("sectype") String sectype,
            @QueryParam("month") String month, @QueryParam("exchange") String exchange);

    /**
     * Security Futures by Symbol
     * <p>
     * Returns a list of non-expired future contracts for given symbol(s)
     */
    @GET
    @Path("/trsrv/futures")
    @Produces({"application/json"})
    @ApiOperation(value = "Security Futures by Symbol", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object with symbol and and array of its future contracts",
            response = Object.class), @ApiResponse(code = 500,
            message = "error while processing the request",
            response = Object.class)})
    public Object trsrvFuturesGet(@QueryParam("symbols") String symbols);

    /**
     * Secdef by Conid
     * <p>
     * Returns a list of security definitions for the given conids
     */
    @POST
    @Path("/trsrv/secdef")
    @Produces({"application/json"})
    @ApiOperation(value = "Secdef by Conid", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array of secdef info",
            response = Secdef.class)})
    public Secdef trsrvSecdefPost(Body body);

    /**
     * Get trading schedule for symbol
     * <p>
     * Returns the trading schedule up to a month for the requested contract
     */
    @GET
    @Path("/trsrv/secdef/schedule")
    @Produces({"application/json"})
    @ApiOperation(value = "Get trading schedule for symbol", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Returns an object", response = Object.class)})
    public Object trsrvSecdefScheduleGet(@QueryParam("assetClass") String assetClass,
            @QueryParam("symbol") String symbol, @QueryParam("exchange") String exchange,
            @QueryParam("exchangeFilter") String exchangeFilter);

    /**
     * Security Stocks by Symbol
     * <p>
     * Returns an object contains all stock contracts for given symbol(s)
     */
    @GET
    @Path("/trsrv/stocks")
    @Produces({"application/json"})
    @ApiOperation(value = "Security Stocks by Symbol", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an object with symbols",
            response = Object.class), @ApiResponse(code = 500,
            message = "error while processing the request",
            response = Object.class)})
    public Object trsrvStocksGet(@QueryParam("symbols") String symbols);
}

