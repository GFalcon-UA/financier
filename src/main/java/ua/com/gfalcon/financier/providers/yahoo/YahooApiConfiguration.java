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

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.Generated;

/**
 * Configuration for Yahoo Finance downstream.
 */
@Generated
@Configuration
public class YahooApiConfiguration {

    public static final String URL_QUERY_1 = "https://query1.finance.yahoo.com";

    /**
     * RestTemplate bean.
     */
    @Bean
    public RestTemplate yahooRestTemplate() {
        return new RestTemplateBuilder()
                .rootUri(URL_QUERY_1)
                .setConnectTimeout(Duration.ofSeconds(2))
                .build();
    }
}
