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

package ua.com.gfalcon.financier.core.screener.service;

import java.util.Optional;

import ua.com.gfalcon.financier.core.screener.domain.Currency;
import ua.com.gfalcon.financier.core.screener.domain.Geo;
import ua.com.gfalcon.financier.core.screener.domain.Industry;
import ua.com.gfalcon.financier.core.screener.domain.Instrument;
import ua.com.gfalcon.financier.core.screener.domain.MarketTimeZone;
import ua.com.gfalcon.financier.core.screener.domain.Sector;
import ua.com.gfalcon.financier.core.screener.domain.StockExchange;
import ua.com.gfalcon.financier.core.screener.model.FinvizStock;
import ua.com.gfalcon.financier.core.screener.model.YahooStock;

/**
 * Market data service.
 */
public interface MarketDataService {

    long loadMarketData();

    void load(String ticker);

    Instrument updateStock(Instrument instrument);

    Instrument saveHistory(Instrument instrument, YahooStock stock);

    Instrument createStock(String ticker);

    Geo createGeo(FinvizStock fvStock);

    Optional<Geo> findGeo(FinvizStock stock);

    Optional<Industry> findIndustry(FinvizStock stock);

    MarketTimeZone createMarketTimeZone(YahooStock stock);

    Optional<MarketTimeZone> findTimeZone(YahooStock stock);

    StockExchange createStockExchange(YahooStock stock);

    Optional<StockExchange> findStockExchange(YahooStock stock);

    Currency createCurrency(YahooStock stock);

    Optional<Currency> findCurrency(YahooStock stock);

    Industry createIndustry(FinvizStock stock);

    Optional<Sector> findSector(FinvizStock stock);

}
