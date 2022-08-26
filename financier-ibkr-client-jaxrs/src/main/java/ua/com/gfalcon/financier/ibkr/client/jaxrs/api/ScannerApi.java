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
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.DirectScanner;
import ua.com.gfalcon.financier.ibkr.model.ScannerParams;
import ua.com.gfalcon.financier.ibkr.model.ScannerResult;

/**
 * Client Portal Web API
 *
 * <p>Client Poral Web API
 */
@Path("/")
@Api(value = "/", description = "")
public interface ScannerApi {

    /**
     * Run Scanner (Beta)
     * <p/>
     * Using a direct connection to the market data farm, will provide results to the requested scanner.
     */
    @POST
    @Path("/hmds/scanner")
    @Produces({"application/json"})
    @ApiOperation(value = "Run Scanner (Beta)", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Valid result",
            response = ScannerResult.class), @ApiResponse(code = 400, message = "Bad request")})
    public ScannerResult hmdsScannerPost(DirectScanner body);

    /**
     * Scanner Parameters
     * <p>
     * Returns an object contains four lists contain all parameters for scanners
     */
    @GET
    @Path("/iserver/scanner/params")
    @Produces({"application/json"})
    @ApiOperation(value = "Scanner Parameters", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "An object contains lists", response = Object.class)})
    public Object iserverScannerParamsGet();

    /**
     * run scanner to get a list of contracts
     */
    @POST
    @Path("/iserver/scanner/run")
    @Produces({"application/json"})
    @ApiOperation(value = "run scanner to get a list of contracts", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "returns an array",
            response = Object.class,
            responseContainer = "List")})
    public List<Object> iserverScannerRunPost(ScannerParams body);
}

