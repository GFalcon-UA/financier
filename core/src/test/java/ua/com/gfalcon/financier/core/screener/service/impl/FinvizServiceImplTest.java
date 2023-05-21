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

package ua.com.gfalcon.financier.core.screener.service.impl;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.gfalcon.financier.core.screener.model.FinvizStock;
import ua.com.gfalcon.financier.core.screener.service.FinvizPresets;
import ua.com.gfalcon.financier.core.screener.service.FinvizService;
import ua.com.gfalcon.financier.core.screener.service.impl.FinvizServiceImpl;

class FinvizServiceImplTest {

    private FinvizService service;

    @BeforeEach
    void setUp() {
        service = new FinvizServiceImpl();
    }

    @Test
    void findTickers() {
        Set<String> tickers = service.findTickers(FinvizPresets.FOR_TRADING_FILTER);

        Assertions.assertNotNull(tickers, "Finviz does not return screener result");
    }

    @Test
    void getStock() {
        final String ticker = "TSLA";

        FinvizStock stock = service.getStock(ticker);

        Assertions.assertNotNull(stock, "Finviz does not return stock overview for ticker " + ticker);
        Assertions.assertEquals(ticker, stock.ticker(), "The ticker is not matched");
    }

}