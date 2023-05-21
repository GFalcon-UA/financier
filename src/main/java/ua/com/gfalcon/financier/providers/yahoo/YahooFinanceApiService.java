/*
 * Copyright (c) 2016-2023 Oleksii Khalikov @GFalcon-UA (http://gfalcon.com.ua)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.com.gfalcon.financier.providers.yahoo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import ua.com.gfalcon.financier.providers.ApiService;

/**
 * Yahoo Finance API.
 *
 * @see <a href="https://cryptocointracker.com/yahoo-finance/yahoo-finance-api">Blog post</a>
 */
@Generated
@Service
@RequiredArgsConstructor
public class YahooFinanceApiService implements ApiService {

    private final RestTemplate yahooRestTemplate;

    @Override
    public ResponseEntity<JSONObject> getRequest(@NotBlank String uri) {
        return yahooRestTemplate.getForEntity(uri, JSONObject.class);
    }

}
