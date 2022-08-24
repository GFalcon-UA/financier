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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static ua.com.gfalcon.financier.ibkrwebapi.util.StringUtil.getOptional;
import ua.com.gfalcon.financier.ibkr.rest.model.market.MarketDataDirectReq;
import ua.com.gfalcon.financier.ibkr.rest.model.market.MarketDataDirectResp;
import ua.com.gfalcon.financier.ibkr.rest.model.market.MarketDataHistoryReq;
import ua.com.gfalcon.financier.ibkr.rest.model.market.MarketDataHistoryResp;

@RestController
@RequestMapping(path = "/api/v1/market-data", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarketDataController {

    private final RestTemplate restTemplate;

    @Autowired
    public MarketDataController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Using direct to market data farm connection, will provide a list of historical market data for a given conid.
     *
     * @param body
     * @return
     */
    @PostMapping("/direct")
    public ResponseEntity<MarketDataDirectResp> marketDataDirect(@RequestBody MarketDataDirectReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("hmds", "history")
                .queryParam("conid", body.getConid())
                .queryParam("period", body.getPeriod())
                .queryParamIfPresent("bar", getOptional(body.getBar()))
                .queryParamIfPresent("outsideRth", getOptional(body.getOutsideRth()))
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, MarketDataDirectResp.class);
    }

    /**
     * Market Data History.
     * Get historical market Data for given conid, length of data is controlled by 'period' and 'bar'. Formatted as:
     * min=minute, h=hour, d=day, w=week, m=month, y=year e.g. period =1y with bar =1w returns 52 data points (Max of
     * 1000 data points supported). Note: There's a limit of 5 concurrent requests. Excessive requests will return a
     * 'Too many requests' status 429 response.
     *
     * @param body
     * @return
     */
    @PostMapping("/history")
    public ResponseEntity<MarketDataHistoryResp> marketDataHistory(@RequestBody MarketDataHistoryReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "marketdata", "history")
                .queryParam("conid", body.getConid())
                .queryParamIfPresent("exchange", getOptional(body.getExchange()))
                .queryParam("period", body.getPeriod())
                .queryParamIfPresent("bar", getOptional(body.getBar()))
                .queryParamIfPresent("outsideRth", getOptional(body.getOutsideRth()))
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, MarketDataHistoryResp.class);
    }
}
