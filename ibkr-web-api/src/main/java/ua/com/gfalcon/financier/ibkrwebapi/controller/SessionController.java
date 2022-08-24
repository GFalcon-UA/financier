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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import ua.com.gfalcon.financier.ibkr.rest.model.session.AuthenticationStatusResp;
import ua.com.gfalcon.financier.ibkr.rest.model.session.LogoutResp;
import ua.com.gfalcon.financier.ibkr.rest.model.session.ValidateSsoResp;

@RestController
@RequestMapping(path = "/api/v1/session", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {

    private RestTemplate restTemplate;

    @Autowired
    public SessionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Validates the current session for the SSO user.
     *
     * @return
     */
    @PostMapping("/validate-sso")
    public ResponseEntity<ValidateSsoResp> validateSso() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("sso", "validate")
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, ValidateSsoResp.class);
    }

    /**
     * Current Authentication status to the Brokerage system. Market Data and Trading is not possible if not authenticated, e.g. authenticated shows false.
     *
     * @return
     */
    @PostMapping("/authentication-status")
    public ResponseEntity<AuthenticationStatusResp> authenticationStatus() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "auth", "status")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, null, AuthenticationStatusResp.class);
    }

    /**
     * When using the CP Gateway, this endpoint provides a way to reauthenticate to the Brokerage system as long as there is a valid SSO session, see /sso/validate.
     *
     * @return
     */
    @PostMapping("/reauthenticate")
    public ResponseEntity<AuthenticationStatusResp> reauthenticate() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "reauthenticate")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, null, AuthenticationStatusResp.class);
    }

    /**
     * Ping the server to keep the session open.
     * If the gateway has not received any requests for several minutes an open session will automatically timeout. The tickle endpoint pings the server to prevent the session from ending.
     *
     * @return
     */
    @PostMapping("/tickle")
    public ResponseEntity<String> tickle() {
        String uri = UriComponentsBuilder.newInstance()
                .path("tickle")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, null, String.class);
    }

    /**
     * Ends the current session.
     * Logs the user out of the gateway session. Any further activity requires re-authentication.
     *
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<LogoutResp> logout() {
        String uri = UriComponentsBuilder.newInstance()
                .path("logout")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, null, LogoutResp.class);
    }
}
