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

package ua.com.gfalcon.financier.ibkrwebapi.controller;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ua.com.gfalcon.financier.ibkr.rest.model.account.AccountIdReq;
import ua.com.gfalcon.financier.ibkr.rest.model.account.AccountLedgerResp;
import ua.com.gfalcon.financier.ibkr.rest.model.account.AccountSummaryResp;
import ua.com.gfalcon.financier.ibkr.rest.model.account.BrokerageAccountsResp;
import ua.com.gfalcon.financier.ibkr.rest.model.account.ListOfSubAccountsResp;
import ua.com.gfalcon.financier.ibkr.rest.model.account.PortfolioAccountsResp;
import ua.com.gfalcon.financier.ibkr.rest.model.account.SwitchAccountResp;
import ua.com.gfalcon.financier.ibkr.rest.model.base.PortfolioAccount;

@RestController
@RequestMapping(path = "/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final RestTemplate restTemplate;

    @Autowired
    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * In non-tiered account structures, returns a list of accounts for which the user can view position and account
     * information. This endpoint must be called prior to calling other /portfolio endpoints for those accounts. For
     * querying a list of accounts which the user can trade, see /iserver/accounts. For a list of subaccounts in tiered
     * account structures (e.g. financial advisor or ibroker accounts) see /portfolio/subaccounts.
     *
     * @return
     */
    @PostMapping("/portfolio-accounts")
    public ResponseEntity<PortfolioAccountsResp> portfolioAccounts() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("portfolio", "accounts")
                .build()
                .encode()
                .toUriString();

        ResponseEntity<PortfolioAccount[]> response = restTemplate.getForEntity(uri, PortfolioAccount[].class);
        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        PortfolioAccount[] infos = response.getBody();
        if (infos == null || infos.length == 0) {
            return ResponseEntity.ok(new PortfolioAccountsResp(Collections.emptyList()));
        }
        return ResponseEntity.ok(new PortfolioAccountsResp(Arrays.asList(infos)));
    }

    /**
     * List of Sub-Accounts.
     * Used in tiered account structures (such as Financial Advisor and IBroker Accounts) to return a list of up to 100
     * sub-accounts for which the user can view position and account-related information. This endpoint must be called
     * prior to calling other /portfolio endpoints for those sub-accounts. If you have more than 100 sub-accounts use
     * /portfolio/subaccounts2. To query a list of accounts the user can trade, see /iserver/accounts.
     *
     * @return
     */
    @PostMapping("/sub-accounts")
    public ResponseEntity<ListOfSubAccountsResp> subAccounts() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("portfolio", "subaccounts")
                .build()
                .encode()
                .toUriString();

        ResponseEntity<PortfolioAccount> response = restTemplate.getForEntity(uri, PortfolioAccount.class);
        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        return ResponseEntity.ok(new ListOfSubAccountsResp(response.getBody()));
    }

    /**
     * Returns information about margin, cash balances and other information related to specified account. See also
     * /portfolio/{accountId}/ledger. /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint.
     *
     * @param body
     * @return
     */
    @PostMapping("/summary")
    public ResponseEntity<AccountSummaryResp> accountSummary(@RequestBody AccountIdReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .path("portfolio")
                .path(body.getAccountId())
                .path("summary")
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, AccountSummaryResp.class);
    }

    /**
     * Information regarding settled cash, cash balances, etc. in the account's base currency and any other cash
     * balances hold in other currencies. /portfolio/accounts or /portfolio/subaccounts must be called prior to this
     * endpoint. The <a href="https://www.interactivebrokers.com/en/index.php?f=3185">list of supported currencies</a>.
     *
     * @param body
     * @return
     */
    @PostMapping("/ledger")
    public ResponseEntity<AccountLedgerResp> accountLedger(@RequestBody AccountIdReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .path("portfolio")
                .path(body.getAccountId())
                .path("ledger")
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, AccountLedgerResp.class);
    }

    /**
     * Switch Account
     * If an user has multiple accounts, and user wants to get orders, trades, etc. of an account other than currently
     * selected account, then user can update the currently selected account using this API and then can fetch required
     * information for the newly updated account.
     *
     * @param body
     * @return
     */
    @PostMapping("/switch")
    public ResponseEntity<SwitchAccountResp> switchAccount(@RequestBody AccountIdReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "account")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, body, SwitchAccountResp.class);
    }

    /**
     * Brokerage Accounts
     * Returns a list of accounts the user has trading access to, their respective aliases and the currently selected
     * account. Note this endpoint must be called before modifying an order or querying open orders.
     *
     * @return
     */
    @PostMapping("/brokerage")
    public ResponseEntity<BrokerageAccountsResp> brokerageAccounts() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "accounts")
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, BrokerageAccountsResp.class);
    }
}
