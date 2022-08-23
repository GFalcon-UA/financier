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

package ua.com.gfalcon.financier.ibkr.server.jaxrs.api.impl;

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
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.ApiResponseMessage;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.IserverApiService;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.NotFoundException;

public class IserverApiServiceImpl extends IserverApiService {
    @Override
    public Response iserverAccountAccountIdAlertActivatePost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdAlertAlertIdDelete(String accountId, String alertId,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdAlertPost(String accountId, AlertRequest body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdAlertsGet(String accountId,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrderOrderIdDelete(String accountId, String orderId,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrderOrderIdPost(String accountId, String orderId, ModifyOrder body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrderPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrderWhatifPost(String accountId, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrdersPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAccountIdOrdersWhatifPost(String accountId, Body body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountAlertIdGet(String id, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountMtaGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountOrderStatusOrderIdGet(String orderId,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountOrdersFaGroupPost(String faGroup, OrderRequest body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountOrdersGet(Body body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountPnlPartitionedGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountPost(SetAccount body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountTradesGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAccountsGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverAuthStatusPost(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverContractConidAlgosGet(String conid, String algos, String addDescription, String addParams,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverContractConidInfoAndRulesGet(String conid, @NotNull Boolean isBuy,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverContractConidInfoGet(String conid,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverContractRulesPost(Conid conid, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverMarketdataConidUnsubscribeGet(String conid,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverMarketdataHistoryGet(@NotNull String conid, @NotNull String period, String exchange,
            String bar, Boolean outsideRth, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverMarketdataSnapshotGet(@NotNull String conids, Integer since, String fields,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverMarketdataUnsubscribeallGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverReauthenticatePost(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverReplyReplyidPost(String replyid, Body body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverScannerParamsGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverScannerRunPost(ScannerParams body,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverSecdefInfoGet(@NotNull String conid, @NotNull String sectype, String month, String exchange,
            String strike, String right, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverSecdefSearchPost(Symbol symbol, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response iserverSecdefStrikesGet(@NotNull String conid, @NotNull String sectype, @NotNull String month,
            String exchange, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }
}
