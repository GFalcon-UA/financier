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

import ua.com.gfalcon.financier.ibkr.rest.model.scanner.RunScannerDirectReq;
import ua.com.gfalcon.financier.ibkr.rest.model.scanner.RunScannerDirectResp;
import ua.com.gfalcon.financier.ibkr.rest.model.scanner.RunScannerReq;
import ua.com.gfalcon.financier.ibkr.rest.model.scanner.RunScannerResp;
import ua.com.gfalcon.financier.ibkr.rest.model.scanner.ScannerParametersResp;

@RestController
@RequestMapping(path = "/api/v1/scanner", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScannerController {

    private RestTemplate restTemplate;

    @Autowired
    public ScannerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Using a direct connection to the market data farm, will provide results to the requested scanner.
     *
     * @param body
     * @return
     */
    @PostMapping("/run-scanner-direct")
    public ResponseEntity<RunScannerDirectResp> runScannerDirect(@RequestBody RunScannerDirectReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("hmds", "scanner")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, body, RunScannerDirectResp.class);
    }

    /**
     * Returns an object contains four lists contain all parameters for scanners.
     *
     * @return
     */
    @PostMapping("/scanner-parameters")
    public ResponseEntity<ScannerParametersResp> scannerParameters() {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "scanner", "params")
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, ScannerParametersResp.class);
    }

    /**
     * Run scanner to get a list of contracts.
     *
     * @param body
     * @return
     */
    @PostMapping("/run-scanner")
    public ResponseEntity<RunScannerResp> runScanner(@RequestBody RunScannerReq body) {
        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "scanner", "run")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, body, RunScannerResp.class);
    }
}
