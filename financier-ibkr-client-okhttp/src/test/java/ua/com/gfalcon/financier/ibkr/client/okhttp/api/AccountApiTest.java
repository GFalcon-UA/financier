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

import org.junit.Ignore;
import org.junit.Test;

import ua.com.gfalcon.financier.ibkr.model.Account;
import ua.com.gfalcon.financier.ibkr.model.AccountLedger;
import ua.com.gfalcon.financier.ibkr.model.AccountPnL;
import ua.com.gfalcon.financier.ibkr.model.AccountSummary;
import ua.com.gfalcon.financier.ibkr.model.Accounts;
import ua.com.gfalcon.financier.ibkr.model.BrokerageAccount;
import ua.com.gfalcon.financier.ibkr.model.SetAccount;
import ua.com.gfalcon.financier.ibkr.model.SwitchAccount;

/**
 * API tests for AccountApi.
 */
@Ignore
public class AccountApiTest {

    private final AccountApi api = new AccountApi();


    /**
     * PnL for the selected account
     *<p/>
     * Returns an object containing PnL for the selected account and its models (if any). To receive streaming PnL the
     * endpoint /ws can be used. Refer to [Streaming WebSocket
     * Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void iserverAccountPnlPartitionedGetTest() throws Exception {
        AccountPnL response = api.iserverAccountPnlPartitionedGet();

        // TODO: test validations
    }

    /**
     * Switch Account
     * <p/>
     * If an user has multiple accounts, and user wants to get orders, trades, etc. of an account other than currently
     * selected account, then user can update the currently selected account using this API and then can fetch required
     * information for the newly updated account.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void iserverAccountPostTest() throws Exception {
        SetAccount body = null;
        SwitchAccount response = api.iserverAccountPost(body);

        // TODO: test validations
    }

    /**
     * Brokerage Accounts
     * <p/>
     * Returns a list of accounts the user has trading access to, their respective aliases and the currently selected
     * account. Note this endpoint must be called before modifying an order or querying open orders.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void iserverAccountsGetTest() throws Exception {
        BrokerageAccount response = api.iserverAccountsGet();

        // TODO: test validations
    }

    /**
     * Account Ledger
     * <p/>
     * Information regarding settled cash, cash balances, etc. in the account&#39;s base currency and any other cash
     * balances hold in other currencies.  /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint. The list of supported currencies is available at
     * https://www.interactivebrokers.com/en/index.php?f&#x3D;3185.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void portfolioAccountIdLedgerGetTest() throws Exception {
        String accountId = null;
        AccountLedger response = api.portfolioAccountIdLedgerGet(accountId);

        // TODO: test validations
    }

    /**
     * Account Information
     * <p/>
     * Account information related to account Id /portfolio/accounts or /portfolio/subaccounts must be called prior to
     * this endpoint.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void portfolioAccountIdMetaGetTest() throws Exception {
        String accountId = null;
        Accounts response = api.portfolioAccountIdMetaGet(accountId);

        // TODO: test validations
    }

    /**
     * Account Summary
     * <p/>
     * Returns information about margin, cash balances and other information related to specified account. See also
     * /portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void portfolioAccountIdSummaryGetTest() throws Exception {
        String accountId = null;
        AccountSummary response = api.portfolioAccountIdSummaryGet(accountId);

        // TODO: test validations
    }

    /**
     * Portfolio Accounts
     * <p/>
     * In non-tiered account structures, returns a list of accounts for which the user can view position and account
     * information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For
     * querying a list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered
     * account structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void portfolioAccountsGetTest() throws Exception {
        Accounts response = api.portfolioAccountsGet();

        // TODO: test validations
    }

    /**
     * List of Sub-Accounts
     * <p/>
     * Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100
     * sub-accounts for which the user can view position and account-related information. This endpoint must be called
     * prior to calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use
     * /portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void portfolioSubaccountsGetTest() throws Exception {
        Account response = api.portfolioSubaccountsGet();

        // TODO: test validations
    }

}
