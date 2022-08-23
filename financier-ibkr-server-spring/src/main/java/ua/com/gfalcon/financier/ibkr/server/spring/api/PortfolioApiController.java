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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import ua.com.gfalcon.financier.ibkr.model.Account;
import ua.com.gfalcon.financier.ibkr.model.Accounts;
import ua.com.gfalcon.financier.ibkr.model.Allocation;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Position;


@Controller
public class PortfolioApiController implements PortfolioApi {

    private static final Logger log = LoggerFactory.getLogger(PortfolioApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PortfolioApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Allocation> portfolioAccountIdAllocationGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Allocation>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Allocation.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Allocation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Allocation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> portfolioAccountIdLedgerGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Object>(
                        objectMapper.readValue("{  \"bytes\": [    123,    125  ],  \"empty\": false}", Object.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Accounts> portfolioAccountIdMetaGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Accounts>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Accounts.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Accounts>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Accounts>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Position> portfolioAccountIdPositionConidGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "contract id", required = true) @PathVariable("conid") Integer conid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Position>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Position.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Position>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Position>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> portfolioAccountIdPositionsInvalidatePost(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Object>(
                        objectMapper.readValue("{  \"bytes\": [    123,    125  ],  \"empty\": false}", Object.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Position> portfolioAccountIdPositionsPageIdGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId,
            @ApiParam(value = "page id", required = true) @PathVariable("pageId") String pageId,
            @ApiParam(value = "optional") @Valid @RequestParam(value = "model", required = false) String model,
            @ApiParam(value = "declare the table to be sorted by which column") @Valid @RequestParam(value = "sort",
                    required = false) String sort,
            @ApiParam(value = "in which order, a means ascending - d means descending") @Valid @RequestParam(value = "direction",
                    required = false) String direction,
            @ApiParam(value = "period for pnl column, can be 1D, 7D, 1M...") @Valid @RequestParam(value = "period",
                    required = false) String period) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Position>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Position.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Position>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Position>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> portfolioAccountIdSummaryGet(
            @ApiParam(value = "account id", required = true) @PathVariable("accountId") String accountId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Object>(
                        objectMapper.readValue("{  \"bytes\": [    123,    125  ],  \"empty\": false}", Object.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Accounts> portfolioAccountsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Accounts>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Accounts.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Accounts>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Accounts>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Allocation> portfolioAllocationPost(
            @ApiParam(value = "accounts info", required = true) @Valid @RequestBody Body body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Allocation>(
                        objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Allocation.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Allocation>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Allocation>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> portfolioPositionsConidGet(
            @ApiParam(value = "contract id", required = true) @PathVariable("conid") Integer conid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Object>(
                        objectMapper.readValue("{  \"bytes\": [    123,    125  ],  \"empty\": false}", Object.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Account> portfolioSubaccountsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Account>(objectMapper.readValue("{\"empty\": false}", Account.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }

}
