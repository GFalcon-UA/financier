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
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.MarketData;


@Controller
public class MdApiController implements MdApi {

    private static final Logger log = LoggerFactory.getLogger(MdApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MdApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<MarketData> mdSnapshotGet(
            @NotNull @ApiParam(value = "List of conids comma separated. Optional exchange and instrument type can be specified.   * conid: IBKR Contract Identifier   * exchange: Exchange or venue   * instrType: Instrument Type supported values: CS (Stocks), OPT (Options), FUT (Futures), FOP (Future Options), WAR (Warrants), BOND (Bonds), FUND (Mutual Funds), CASH (Forex), CFD (Contract for difference), IND (Index) ",
                    required = true,
                    allowableValues = "conid@exchange:instrType") @Valid @RequestParam(value = "conids",
                    required = true) String conids,
            @ApiParam(value = "list of fields separated by comma 31,84,85,86,88") @Valid @RequestParam(value = "fields",
                    required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<MarketData>(objectMapper.readValue("{\"empty\": false}", MarketData.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<MarketData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<MarketData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
