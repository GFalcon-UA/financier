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

import ua.com.gfalcon.financier.ibkr.model.AlertRequest;
import ua.com.gfalcon.financier.ibkr.model.Body;
import ua.com.gfalcon.financier.ibkr.model.Conid;
import ua.com.gfalcon.financier.ibkr.model.ModifyOrder;
import ua.com.gfalcon.financier.ibkr.model.OrderRequest;
import ua.com.gfalcon.financier.ibkr.model.ScannerParams;
import ua.com.gfalcon.financier.ibkr.model.SetAccount;
import ua.com.gfalcon.financier.ibkr.model.Symbol;

public interface IserverApiService {
    Response iserverAccountAccountIdAlertActivatePost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdAlertAlertIdDelete(String accountId, String alertId,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdAlertPost(String accountId, AlertRequest body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdAlertsGet(String accountId,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrderOrderIdDelete(String accountId, String orderId,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrderOrderIdPost(String accountId, String orderId, ModifyOrder body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrderPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrderWhatifPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrdersPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAccountIdOrdersWhatifPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountAlertIdGet(String id, SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountMtaGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountOrderStatusOrderIdGet(String orderId,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountOrdersFaGroupPost(String faGroup, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountOrdersGet(Body body, SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountPnlPartitionedGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountPost(SetAccount body, SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountTradesGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverAccountsGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverAuthStatusPost(SecurityContext securityContext) throws NotFoundException;

    Response iserverContractConidAlgosGet(String conid, String algos, String addDescription, String addParams,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverContractConidInfoAndRulesGet(String conid, Boolean isBuy,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverContractConidInfoGet(String conid, SecurityContext securityContext) throws NotFoundException;

    Response iserverContractRulesPost(Conid conid, SecurityContext securityContext) throws NotFoundException;

    Response iserverMarketdataConidUnsubscribeGet(String conid,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverMarketdataHistoryGet(String conid, String period, String exchange, String bar, Boolean outsideRth,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverMarketdataSnapshotGet(String conids, Integer since, String fields,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverMarketdataUnsubscribeallGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverReauthenticatePost(SecurityContext securityContext) throws NotFoundException;

    Response iserverReplyReplyidPost(String replyid, Body body,
            SecurityContext securityContext) throws NotFoundException;

    Response iserverScannerParamsGet(SecurityContext securityContext) throws NotFoundException;

    Response iserverScannerRunPost(ScannerParams body, SecurityContext securityContext) throws NotFoundException;

    Response iserverSecdefInfoGet(String conid, String sectype, String month, String exchange, String strike,
            String right, SecurityContext securityContext) throws NotFoundException;

    Response iserverSecdefSearchPost(Symbol symbol, SecurityContext securityContext) throws NotFoundException;

    Response iserverSecdefStrikesGet(String conid, String sectype, String month, String exchange,
            SecurityContext securityContext) throws NotFoundException;
}
