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

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ua.com.gfalcon.financier.ibkrwebapi.config.GateWayConfig;

@RestController
public class LoginController {

    private RestTemplate restTemplate;
    private GateWayConfig gateWayConfig;

    @Autowired
    public LoginController(RestTemplate restTemplate, GateWayConfig gateWayConfig) {
        this.restTemplate = restTemplate;
        this.gateWayConfig = gateWayConfig;
    }

    @GetMapping("/val")
    public ResponseEntity<String> login() throws URISyntaxException {
        String url = gateWayConfig.getApiUrl() + "sso/validate";
        return restTemplate.getForEntity(new URI(url), String.class);
    }
}
