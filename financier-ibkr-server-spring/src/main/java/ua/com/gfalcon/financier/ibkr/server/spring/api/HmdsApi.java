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

/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package ua.com.gfalcon.financier.ibkr.server.spring.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.gfalcon.financier.ibkr.model.HistoryResult;
import ua.com.gfalcon.financier.ibkr.model.ScannerDirect;
import ua.com.gfalcon.financier.ibkr.model.ScannerDirectResult;


@Validated
@Api(value = "hmds", description = "the hmds API")
@RequestMapping(value = "/v1/api")
public interface HmdsApi {

    @ApiOperation(value = "Market Data History",
            nickname = "hmdsHistoryGet",
            notes = "Using direct to market data farm connection, will provide a list of historical market data for a given conid",
            response = HistoryResult.class,
            tags = {"MarketData (Beta)",})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Valid result",
            response = HistoryResult.class), @ApiResponse(code = 400, message = "Bad request")})
    @RequestMapping(value = "/hmds/history", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<HistoryResult> hmdsHistoryGet(
            @NotNull @ApiParam(value = "contract id", required = true) @Valid @RequestParam(value = "conid",
                    required = true) Integer conid,
            @NotNull @ApiParam(value = "Time period for history request.    * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months   * y: Years ",
                    required = true,
                    allowableValues = "min, h, d, w, m, y") @Valid @RequestParam(value = "period",
                    required = true) String period,
            @ApiParam(value = "Duration of time for each candlestick bar.   * min: Minutes   * h: Hours   * d: Days   * w: Weeks   * m: Months ",
                    allowableValues = "min, h, d, w, m") @Valid @RequestParam(value = "bar",
                    required = false) String bar,
            @ApiParam(value = "For contracts that support it, will determine if history data includes outside of regular trading hours.") @Valid @RequestParam(
                    value = "outsideRth",
                    required = false) Boolean outsideRth);


    @ApiOperation(value = "Run Scanner (Beta)",
            nickname = "hmdsScannerPost",
            notes = "Using a direct connection to the market data farm, will provide results to the requested scanner.",
            response = ScannerDirectResult.class,
            tags = {"Scanner",})
    @ApiResponses(value = {@ApiResponse(code = 200,
            message = "Valid result",
            response = ScannerDirectResult.class), @ApiResponse(code = 400, message = "Bad request")})
    @RequestMapping(value = "/hmds/scanner", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<ScannerDirectResult> hmdsScannerPost(
            @ApiParam(value = "request body", required = true) @Valid @RequestBody ScannerDirect body);

}
