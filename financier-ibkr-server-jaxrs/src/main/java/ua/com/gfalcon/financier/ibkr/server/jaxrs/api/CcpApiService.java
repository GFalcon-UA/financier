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

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import ua.com.gfalcon.financier.ibkr.model.Auth;

public abstract class CcpApiService {
    public abstract Response ccpAccountGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpAuthInitPost(Boolean compete, String locale, String mac, String machineId,
            String username, SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpAuthResponsePost(Auth auth, SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpOrderDelete(@NotNull String acct, @NotNull BigDecimal id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpOrderPost(@NotNull String acct, @NotNull BigDecimal conid, @NotNull String ccy,
            @NotNull String exchange, @NotNull BigDecimal qty, String type, String side, BigDecimal price, String tif,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpOrderPut(@NotNull String acct, @NotNull BigDecimal id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpOrdersGet(@NotNull String acct, Boolean cancelled,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpPositionsGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpStatusGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response ccpTradesGet(String from, String to,
            SecurityContext securityContext) throws NotFoundException;
}
