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

import ua.com.gfalcon.financier.ibkr.model.Body;

public abstract class FyiApiService {
    public abstract Response fyiDeliveryoptionsDeviceIdDelete(String deviceId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiDeliveryoptionsDevicePost(Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiDeliveryoptionsEmailPut(@NotNull String enabled,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiDeliveryoptionsGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiDisclaimerTypecodeGet(String typecode,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiDisclaimerTypecodePut(String typecode,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiNotificationsGet(@NotNull String max, String exclude, String include,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiNotificationsMoreGet(@NotNull String id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiNotificationsNotificationIdPut(String notificationId,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiSettingsGet(SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiSettingsTypecodePost(String typecode, Body body,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response fyiUnreadnumberGet(SecurityContext securityContext) throws NotFoundException;
}
