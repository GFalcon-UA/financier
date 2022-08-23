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

/*
 * Client Portal Web API
 * Client Poral Web API
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ua.com.gfalcon.financier.ibkr.client.okhttp.api;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import ua.com.gfalcon.financier.ibkr.model.Auth;
import ua.com.gfalcon.financier.ibkr.model.OrderData;
import ua.com.gfalcon.financier.ibkr.model.PositionData;

/**
 * API tests for CcpBetaApi
 */
@Ignore
public class CcpBetaApiTest {

    private final CcpBetaApi api = new CcpBetaApi();


    /**
     * Brokerage Accounts
     * <p>
     * Provides the list of tradeable accounts
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpAccountGetTest() throws Exception {
        Object response = api.ccpAccountGet();

        // TODO: test validations
    }

    /**
     * Start CCP Session
     * <p>
     * Initiate a brokerage session to CCP. Only one brokerage session type can run at a time. If an existing brokerage
     * session to iServer is running then call the endpoint /logout first. Note at this time only order management is
     * possible from CCP session, market data and scanner endpoints can&#39;t be used since they are only available from
     * iServer session. Work is in progress to provide new CCP endpoints for market data and scanners.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpAuthInitPostTest() throws Exception {
        Boolean compete = null;
        String locale = null;
        String mac = null;
        String machineId = null;
        String username = null;
        Object response = api.ccpAuthInitPost(compete, locale, mac, machineId, username);

        // TODO: test validations
    }

    /**
     * Complete CCP Session
     * <p>
     * Session Token Authentication
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpAuthResponsePostTest() throws Exception {
        Auth auth = null;
        Object response = api.ccpAuthResponsePost(auth);

        // TODO: test validations
    }

    /**
     * Delete Order
     * <p>
     * Sends an Order cancellation request. The status of the order can be queried through /ccp/order. Passing arguments
     * as GET is also supported (requires passing action&#x3D;delete) (GET is meant for development only)
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpOrderDeleteTest() throws Exception {
        String acct = null;
        BigDecimal id = null;
        OrderData response = api.ccpOrderDelete(acct, id);

        // TODO: test validations
    }

    /**
     * Submit Order
     * <p>
     * Submits an Order.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpOrderPostTest() throws Exception {
        String acct = null;
        BigDecimal conid = null;
        String ccy = null;
        String exchange = null;
        BigDecimal qty = null;
        String type = null;
        String side = null;
        BigDecimal price = null;
        String tif = null;
        OrderData response = api.ccpOrderPost(acct, conid, ccy, exchange, qty, type, side, price, tif);

        // TODO: test validations
    }

    /**
     * Update Order
     * <p>
     * Updates an Order. Updating an order requires the same arguments as placing an order besides the conid. Note: The
     * status of the order can be queried through GET /ccp/order.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpOrderPutTest() throws Exception {
        String acct = null;
        BigDecimal id = null;
        OrderData response = api.ccpOrderPut(acct, id);

        // TODO: test validations
    }

    /**
     * Order Status
     * <p>
     * Get status for all orders
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpOrdersGetTest() throws Exception {
        String acct = null;
        Boolean cancelled = null;
        Object response = api.ccpOrdersGet(acct, cancelled);

        // TODO: test validations
    }

    /**
     * Positions
     * <p>
     * List of positions
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpPositionsGetTest() throws Exception {
        PositionData response = api.ccpPositionsGet();

        // TODO: test validations
    }

    /**
     * CCP Status
     * <p>
     * Provide the current CCP session status. When using the Gateway this endpoint will also initiate a brokerage
     * session to CCP by sending /auth/init and response.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpStatusGetTest() throws Exception {
        Object response = api.ccpStatusGet();

        // TODO: test validations
    }

    /**
     * Trades
     * <p>
     * Get a list of Trades, by default, the list is from today midnight to Date.now().
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void ccpTradesGetTest() throws Exception {
        String from = null;
        String to = null;
        Object response = api.ccpTradesGet(from, to);

        // TODO: test validations
    }

}
