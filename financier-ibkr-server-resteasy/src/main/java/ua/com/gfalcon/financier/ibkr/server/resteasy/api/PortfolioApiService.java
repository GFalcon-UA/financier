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

package ua.com.gfalcon.financier.ibkr.server.resteasy.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ua.com.gfalcon.financier.ibkr.model.Body;

public interface PortfolioApiService {
    Response portfolioAccountIdAllocationGet(String accountId,
            SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdLedgerGet(String accountId, SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdMetaGet(String accountId, SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdPositionConidGet(String accountId, Integer conid,
            SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdPositionsInvalidatePost(String accountId,
            SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdPositionsPageIdGet(String accountId, String pageId, String model, String sort,
            String direction, String period, SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountIdSummaryGet(String accountId, SecurityContext securityContext) throws NotFoundException;

    Response portfolioAccountsGet(SecurityContext securityContext) throws NotFoundException;

    Response portfolioAllocationPost(Body body, SecurityContext securityContext) throws NotFoundException;

    Response portfolioPositionsConidGet(Integer conid, SecurityContext securityContext) throws NotFoundException;

    Response portfolioSubaccountsGet(SecurityContext securityContext) throws NotFoundException;
}
