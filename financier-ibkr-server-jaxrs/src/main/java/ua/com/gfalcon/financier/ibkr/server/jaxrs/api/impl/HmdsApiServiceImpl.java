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

import ua.com.gfalcon.financier.ibkr.model.DirectScanner;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.ApiResponseMessage;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.HmdsApiService;
import ua.com.gfalcon.financier.ibkr.server.jaxrs.api.NotFoundException;

public class HmdsApiServiceImpl extends HmdsApiService {
    @Override
    public Response hmdsHistoryGet(@NotNull Integer conid, @NotNull String period, String bar, Boolean outsideRth,
            SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }

    @Override
    public Response hmdsScannerPost(DirectScanner body, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok()
                .entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!"))
                .build();
    }
}
