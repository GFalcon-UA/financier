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

package ua.com.gfalcon.financier.screener.service.impl;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.gfalcon.financier.screener.model.YahooStock;
import ua.com.gfalcon.financier.screener.service.YahooService;

class YahooServiceImplTest {

    private YahooService self;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("yahoofinance.baseurl.quotesquery1v7", "https://query1.finance.yahoo.com/v6/finance/quote");
    }

    @BeforeEach
    void setUp() {
        self = new YahooServiceImpl();
    }

    @Test
    void getStock() throws IOException {
        final LocalDate startDate = LocalDate.now()
                .minusDays(10);
        final String symbol = "SPY";

        YahooStock stock = self.getStock(symbol, startDate);

        assertNotNull(stock, "YahooFinance doesnt return response");
        assertEquals(symbol, stock.ticker(), "The ticker is not matched");
    }
}