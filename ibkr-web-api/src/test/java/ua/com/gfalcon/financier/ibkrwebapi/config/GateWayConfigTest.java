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

package ua.com.gfalcon.financier.ibkrwebapi.config;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

class GateWayConfigTest {

    @Test
    void parseConfiguration() {
        GateWayConfig config = new GateWayConfig();

        String url = config.getApiUrl() + String.format("iserver/contract/%s/info-and-rules", 888);

        String uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("isBuy", true)
                .build()
                .encode()
                .toUriString();

        System.out.println(uri);

        String uri2 = UriComponentsBuilder
                .newInstance()
//                .fromUriString(config.getApiUrl())
                .path("iserver/contract")
                .pathSegment("iserver/contract", "888")
                .path("info-and-rules")
                .queryParam("isBuy", true)
                .build()
                .encode()
                .toUriString();

        System.out.println(uri2);

    }
}