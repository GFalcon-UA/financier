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


import java.util.Arrays;
import java.util.Collections;

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
import ua.com.gfalcon.financier.ibkr.rest.model.base.ContractExt;
import ua.com.gfalcon.financier.ibkr.rest.model.base.IbAlgoParam;
import ua.com.gfalcon.financier.ibkr.rest.model.base.SecdefInfo;
import ua.com.gfalcon.financier.ibkr.rest.model.base.SecurityDefinition;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.ContractDetailsReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.ContractDetailsResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.ContractRulesReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.ContractRulesResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.IbAlgoParamsReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.IbAlgoParamsResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.InfoAndRulesReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.InfoAndRulesResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SearchBySymbolOrNameReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SearchBySymbolOrNameResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SearchStrikesReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SearchStrikesResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecdefByConidReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecdefByConidResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecdefInfoReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecdefInfoResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecurityFuturesBySymbolReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecurityFuturesBySymbolGetResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecurityStocksBySymbolReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.SecurityStocksBySymbolResp;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.TradingScheduleForSymbolReq;
import ua.com.gfalcon.financier.ibkr.rest.model.contract.TradingScheduleForSymbolResp;

@RestController
@RequestMapping(path = "/api/v1/contract", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController {

    private RestTemplate restTemplate;

    @Autowired
    public ContractController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     * Returns a list of security definitions for the given conids.
     *
     * @param body
     * @return
     */
    @PostMapping("/secdef-by-conid")
    public ResponseEntity<SecdefByConidResp> getSecdefByConid(@RequestBody SecdefByConidReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("trsrv", "secdef")
                .build()
                .encode()
                .toUriString();

        ResponseEntity<SecurityDefinition[]> response = restTemplate.postForEntity(uri, body,
                SecurityDefinition[].class);
        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        SecurityDefinition[] infos = response.getBody();
        if (infos == null || infos.length == 0) {
            return ResponseEntity.ok(new SecdefByConidResp(Collections.emptyList()));
        }
        return ResponseEntity.ok(new SecdefByConidResp(Arrays.asList(infos)));
    }

    /**
     * Returns the trading schedule up to a month for the requested contract.
     *
     * @param body
     * @return
     */
    @PostMapping("/trading-schedule-for-symbol")
    public ResponseEntity<TradingScheduleForSymbolResp> getTradingScheduleForSymbol(
            @RequestBody TradingScheduleForSymbolReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("trsrv", "secdef", "schedule")
                .queryParam("symbol", body.getSymbol())
                .queryParam("assetClass", body.getAssetClass())
                .queryParamIfPresent("exchange", getOptional(body.getExchange()))
                .queryParamIfPresent("exchangeFilter", getOptional(body.getExchangeFilter()))
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, TradingScheduleForSymbolResp.class);
    }

    /**
     * Returns a list of non-expired future contracts for given symbol(s).
     *
     * @param body
     * @return
     */
    @PostMapping("/security-futures-by-symbol")
    public ResponseEntity<SecurityFuturesBySymbolGetResp> getSecurityFuturesBySymbol(
            @RequestBody SecurityFuturesBySymbolReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("trsrv", "futures")
                .queryParam("symbols", body.getSymbols())
                .build()
                .encode()
                .toUriString();

        return restTemplate.getForEntity(uri, SecurityFuturesBySymbolGetResp.class);
    }

    /**
     * Returns an object contains all stock contracts for given symbol(s).
     *
     * @param body
     * @return
     */
    @PostMapping("/security-stocks-by-symbol")
    public ResponseEntity<SecurityStocksBySymbolResp> getSecurityStocksBySymbol(
            @RequestBody SecurityStocksBySymbolReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("trsrv", "stocks")
                .queryParam("symbols", body.getSymbols())
                .build()
                .encode()
                .toUriString();

        return restTemplate.getForEntity(uri, SecurityStocksBySymbolResp.class);
    }

    /**
     * Using the Contract Identifier get contract info. You can use this to prefill your order before you submit an
     * order.
     *
     * @param body
     * @return
     */
    @PostMapping("/contract-details")
    public ResponseEntity<ContractDetailsResp> getContractDetails(@RequestBody ContractDetailsReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "contract")
                .path(body.getConid())
                .path("info")
                .build()
                .encode()
                .toUriString();

        return restTemplate.getForEntity(uri, ContractDetailsResp.class);
    }

    /**
     * Search by underlying symbol or company name. Relays back what derivative contract(s) it has. This endpoint must
     * be called before using /secdef/info. If company name is specified will only receive limited response: conid,
     * companyName, companyHeader and symbol.
     *
     * @param body
     * @return
     */
    @PostMapping("/search-by-symbol-or-name")
    public ResponseEntity<SearchBySymbolOrNameResp> searchBySymbolOrName(
            @RequestBody SearchBySymbolOrNameReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "secdef", "search")
                .build()
                .encode()
                .toUriString();

        ResponseEntity<ContractExt[]> response = restTemplate.postForEntity(uri, body, ContractExt[].class);
        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        ContractExt[] infos = response.getBody();
        if (infos == null || infos.length == 0) {
            return ResponseEntity.ok(new SearchBySymbolOrNameResp(Collections.emptyList()));
        }
        return ResponseEntity.ok(new SearchBySymbolOrNameResp(Arrays.asList(infos)));
    }

    /**
     * Query strikes for Options/Warrants. For the conid of the underlying contract, available contract months and
     * exchanges use "/iserver/secdef/search".
     *
     * @param body
     * @return
     */
    @PostMapping("/search-strikes")
    public ResponseEntity<SearchStrikesResp> searchStrikes(@RequestBody SearchStrikesReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "secdef", "strikes")
                .queryParam("conid", body.getConid())
                .queryParam("sectype", body.getSectype())
                .queryParam("month", body.getMonth())
                .queryParamIfPresent("exchange", getOptional(body.getExchange()))
                .build()
                .encode()
                .toUriString();

        return restTemplate.getForEntity(uri, SearchStrikesResp.class);
    }

    /**
     * Provides Contract Details of Futures, Options, Warrants, Cash and CFDs based on conid. To get the strike price
     * for Options/Warrants use "/iserver/secdef/strikes" endpoint. Must call /secdef/search for the underlying contract
     * first.
     *
     * @param body
     * @return
     */
    @PostMapping("/secdef-info")
    public ResponseEntity<SecdefInfoResp> getSecdefInfo(@RequestBody SecdefInfoReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "secdef", "info")
                .queryParam("conid", body.getConid())
                .queryParam("sectype", body.getSectype())
                .queryParamIfPresent("month", getOptional(body.getMonth()))
                .queryParamIfPresent("exchange", getOptional(body.getExchange()))
                .queryParamIfPresent("strike", getOptional(body.getStrike()))
                .queryParamIfPresent("right", getOptional(body.getRight()))
                .build()
                .encode()
                .toUriString();

        ResponseEntity<SecdefInfo[]> response = restTemplate.getForEntity(uri, SecdefInfo[].class);

        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        SecdefInfo[] infos = response.getBody();
        if (infos == null || infos.length == 0) {
            return ResponseEntity.ok(new SecdefInfoResp(Collections.emptyList()));
        }
        return ResponseEntity.ok(new SecdefInfoResp(Arrays.asList(infos)));
    }

    /**
     * Returns supported IB Algos for contract. Must be called a second time to query the list of available parameters.
     *
     * @param body
     * @return
     */
    @PostMapping("/ib-algo-params")
    public ResponseEntity<IbAlgoParamsResp> getIbAlgoParams(@RequestBody IbAlgoParamsReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "contract")
                .path(body.getConid())
                .path("algos")
                .queryParamIfPresent("algos", getOptional(body.getAlgos()))
                .queryParamIfPresent("addDescription", getOptional(body.getAddDescription()))
                .queryParamIfPresent("addParams", getOptional(body.getAddParams()))
                .build()
                .encode()
                .toUriString();

        ResponseEntity<IbAlgoParam[]> response = restTemplate.getForEntity(uri, IbAlgoParam[].class);
        if (response.getStatusCode()
                .isError()) {
            return ResponseEntity.internalServerError()
                    .build();
        }
        IbAlgoParam[] infos = response.getBody();
        if (infos == null || infos.length == 0) {
            return ResponseEntity.ok(new IbAlgoParamsResp(Collections.emptyList()));
        }
        return ResponseEntity.ok(new IbAlgoParamsResp(Arrays.asList(infos)));
    }

    /**
     * Returns trading related rules for a specific contract and side. For both contract info and rules use the endpoint
     * /iserver/contract/{conid}/info-and-rules.
     *
     * @param body
     * @return
     */
    @PostMapping("/contract-rules")
    public ResponseEntity<ContractRulesResp> getContractRules(@RequestBody ContractRulesReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "contract", "rules")
                .build()
                .encode()
                .toUriString();
        return restTemplate.postForEntity(uri, body, ContractRulesResp.class);
    }

    /**
     * Returns both contract info and rules from a single endpoint. For only contract rules, use the endpoint
     * /iserver/contract/rules. For only contract info, use the endpoint /iserver/contract/{conid}/info.
     *
     * @param body
     * @return
     */
    @PostMapping("/info-and-rules")
    public ResponseEntity<InfoAndRulesResp> getInfoAndRules(@RequestBody InfoAndRulesReq body) {

        String uri = UriComponentsBuilder.newInstance()
                .pathSegment("iserver", "contract")
                .path(body.getConid())
                .path("info-and-rules")
                .queryParam("isBuy", body.getIsBuy())
                .build()
                .encode()
                .toUriString();
        return restTemplate.getForEntity(uri, InfoAndRulesResp.class);
    }


}
