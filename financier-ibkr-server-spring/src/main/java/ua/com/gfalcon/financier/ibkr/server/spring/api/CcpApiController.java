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
import java.math.BigDecimal;

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
import ua.com.gfalcon.financier.ibkr.model.Auth;
import ua.com.gfalcon.financier.ibkr.model.OrderData;
import ua.com.gfalcon.financier.ibkr.model.PositionData;


@Controller
public class CcpApiController implements CcpApi {

    private static final Logger log = LoggerFactory.getLogger(CcpApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CcpApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Object> ccpAccountGet() {
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

    public ResponseEntity<Object> ccpAuthInitPost(@ApiParam(value = "Allow competing CCP session to run") @RequestParam(
            value = "compete",
            required = false) Boolean compete,
            @ApiParam(value = "Concatenate value for language and region, set to \"en_US\"") @RequestParam(value = "locale",
                    required = false) String locale,
            @ApiParam(value = "Local MAC Address") @RequestParam(value = "mac", required = false) String mac,
            @ApiParam(value = "Local machine ID") @RequestParam(value = "machineId", required = false) String machineId,
            @ApiParam(value = "Login user, set to dash \"-\"") @RequestParam(value = "username",
                    required = false) String username) {
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

    public ResponseEntity<Object> ccpAuthResponsePost(@ApiParam(value = "") @Valid @RequestBody Auth auth) {
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

    public ResponseEntity<OrderData> ccpOrderDelete(
            @NotNull @ApiParam(value = "Account Number", required = true) @Valid @RequestParam(value = "acct",
                    required = true) String acct,
            @NotNull @ApiParam(value = "Order Identifier of original submit order",
                    required = true) @Valid @RequestParam(value = "id", required = true) BigDecimal id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrderData>(objectMapper.readValue("{\"empty\": false}", OrderData.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OrderData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrderData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OrderData> ccpOrderPost(
            @NotNull @ApiParam(value = "User Account", required = true) @Valid @RequestParam(value = "acct",
                    required = true) String acct,
            @NotNull @ApiParam(value = "Contract identifier from IBKR's database.",
                    required = true) @Valid @RequestParam(value = "conid", required = true) BigDecimal conid,
            @NotNull @ApiParam(value = "Contract Currency",
                    required = true,
                    allowableValues = "USD, GBP, EUR") @Valid @RequestParam(value = "ccy", required = true) String ccy,
            @NotNull @ApiParam(value = "Exchange",
                    required = true,
                    allowableValues = "NYSE, CBOE, NYMEX") @Valid @RequestParam(value = "exchange",
                    required = true) String exchange,
            @NotNull @ApiParam(value = "Order Quantity", required = true) @Valid @RequestParam(value = "qty",
                    required = true) BigDecimal qty, @ApiParam(value = "Order Price; required if order type is limit",
            allowableValues = "limit, market") @Valid @RequestParam(value = "type", required = false) String type,
            @ApiParam(value = "Side", allowableValues = "sell, buy") @Valid @RequestParam(value = "side",
                    required = false) String side,
            @ApiParam(value = "Order Price; required if order type is limit") @Valid @RequestParam(value = "price",
                    required = false) BigDecimal price,
            @ApiParam(value = "Time in Force", allowableValues = "IOC, GTC") @Valid @RequestParam(value = "tif",
                    required = false) String tif) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrderData>(objectMapper.readValue("{\"empty\": false}", OrderData.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OrderData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrderData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OrderData> ccpOrderPut(
            @NotNull @ApiParam(value = "User Account", required = true) @Valid @RequestParam(value = "acct",
                    required = true) String acct,
            @NotNull @ApiParam(value = "Order ID to be modified", required = true) @Valid @RequestParam(value = "id",
                    required = true) BigDecimal id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrderData>(objectMapper.readValue("{\"empty\": false}", OrderData.class),
                        HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OrderData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrderData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> ccpOrdersGet(
            @NotNull @ApiParam(value = "User Account", required = true) @Valid @RequestParam(value = "acct",
                    required = true) String acct,
            @ApiParam(value = "Return only Rejected or Cancelled orders since today midnight") @Valid @RequestParam(
                    value = "cancelled",
                    required = false) Boolean cancelled) {
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

    public ResponseEntity<PositionData> ccpPositionsGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PositionData>(
                        objectMapper.readValue("{\"empty\": false}", PositionData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PositionData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PositionData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> ccpStatusGet() {
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

    public ResponseEntity<Object> ccpTradesGet(
            @ApiParam(value = "From Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..)") @Valid @RequestParam(value = "from",
                    required = false) String from,
            @ApiParam(value = "To Date (YYYYMMDD-HH:mm:ss) or offset (-1,-2,-3..). To value should be bigger than from value. ") @Valid @RequestParam(
                    value = "to",
                    required = false) String to) {
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

}
