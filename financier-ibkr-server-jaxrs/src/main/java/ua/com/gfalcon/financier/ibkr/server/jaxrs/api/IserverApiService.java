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

package ua.com.gfalcon.financier.ibkr.server.jaxrs.api;

import javax.validation.constraints.NotNull;
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

public abstract class IserverApiService {
    public abstract Response iserverAccountAccountIdAlertActivatePost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdAlertAlertIdDelete(String accountId, String alertId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdAlertPost(String accountId, AlertRequest body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdAlertsGet(String accountId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrderOrderIdDelete(String accountId, String orderId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrderOrderIdPost(String accountId, String orderId, ModifyOrder body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrderPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrderWhatifPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrdersPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAccountIdOrdersWhatifPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountAlertIdGet(String id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountMtaGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountOrderStatusOrderIdGet(String orderId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountOrdersFaGroupPost(String faGroup, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountOrdersGet(Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountPnlPartitionedGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountPost(SetAccount body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountTradesGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAccountsGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverAuthStatusPost(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverContractConidAlgosGet(String conid, String algos, String addDescription,
            String addParams, SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverContractConidInfoAndRulesGet(String conid, @NotNull Boolean isBuy,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverContractConidInfoGet(String conid,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverContractRulesPost(Conid conid,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverMarketdataConidUnsubscribeGet(String conid,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverMarketdataHistoryGet(@NotNull String conid, @NotNull String period, String exchange,
            String bar, Boolean outsideRth, SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverMarketdataSnapshotGet(@NotNull String conids, Integer since, String fields,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverMarketdataUnsubscribeallGet(
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverReauthenticatePost(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverReplyReplyidPost(String replyid, Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverScannerParamsGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverScannerRunPost(ScannerParams body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverSecdefInfoGet(@NotNull String conid, @NotNull String sectype, String month,
            String exchange, String strike, String right, SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverSecdefSearchPost(Symbol symbol,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response iserverSecdefStrikesGet(@NotNull String conid, @NotNull String sectype,
            @NotNull String month, String exchange, SecurityContext securityContext) throws NotFoundException;
}
