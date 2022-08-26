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

package ua.com.gfalcon.financier.ibkr.server.spring.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.DirectScanner;
import ua.com.gfalcon.financier.ibkr.model.HistoryResult;
import ua.com.gfalcon.financier.ibkr.model.ScannerResult;


@Controller
public class HmdsApiController implements HmdsApi {

    private static final Logger log = LoggerFactory.getLogger(HmdsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HmdsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<HistoryResult> hmdsHistoryGet(
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
                    required = false) Boolean outsideRth) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<HistoryResult>(
                        objectMapper.readValue("{\"empty\": false}", HistoryResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<HistoryResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<HistoryResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ScannerResult> hmdsScannerPost(
            @ApiParam(value = "request body", required = true) @Valid @RequestBody DirectScanner body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ScannerResult>(
                        objectMapper.readValue("{\"empty\": false}", ScannerResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ScannerResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ScannerResult>(HttpStatus.NOT_IMPLEMENTED);
    }

}
