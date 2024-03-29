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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import ua.com.gfalcon.financier.core.screener.domain.Currency;
import ua.com.gfalcon.financier.core.screener.domain.Geo;
import ua.com.gfalcon.financier.core.screener.domain.Industry;
import ua.com.gfalcon.financier.core.screener.domain.Instrument;
import ua.com.gfalcon.financier.core.screener.domain.MarketTimeZone;
import ua.com.gfalcon.financier.core.screener.domain.Sector;
import ua.com.gfalcon.financier.core.screener.domain.StockExchange;
import ua.com.gfalcon.financier.core.screener.model.Bar;
import ua.com.gfalcon.financier.core.screener.model.FinvizStock;
import ua.com.gfalcon.financier.core.screener.model.Period;
import ua.com.gfalcon.financier.core.screener.model.SplitEvent;
import ua.com.gfalcon.financier.core.screener.model.YahooStock;
import ua.com.gfalcon.financier.core.screener.repository.CurrencyRepository;
import ua.com.gfalcon.financier.core.screener.repository.DailyBarRepository;
import ua.com.gfalcon.financier.core.screener.repository.GeoRepository;
import ua.com.gfalcon.financier.core.screener.repository.IndustryRepository;
import ua.com.gfalcon.financier.core.screener.repository.InstrumentRepository;
import ua.com.gfalcon.financier.core.screener.repository.MarketTimeZoneRepository;
import ua.com.gfalcon.financier.core.screener.repository.SectorRepository;
import ua.com.gfalcon.financier.core.screener.repository.SplitRepository;
import ua.com.gfalcon.financier.core.screener.repository.StockExchangeRepository;
import ua.com.gfalcon.financier.core.screener.service.FinvizService;
import ua.com.gfalcon.financier.core.screener.service.MarketDataService;
import ua.com.gfalcon.financier.core.screener.service.YahooService;

@SpringBootTest
@Transactional
class MarketDataServiceImplTest {

    private final YahooService yahoo = Mockito.mock(YahooService.class);
    private final FinvizService finviz = Mockito.mock(FinvizService.class);
    private final InstrumentRepository instrumentRepository;
    private final CurrencyRepository currencyRepository;
    private final StockExchangeRepository stockExchangeRepository;
    private final MarketTimeZoneRepository marketTimeZoneRepository;
    private final IndustryRepository industryRepository;
    private final SectorRepository sectorRepository;
    private final GeoRepository geoRepository;
    private final SplitRepository splitRepository;
    private final DailyBarRepository dailyBarRepository;

    private MarketDataService service;

    @Autowired
    public MarketDataServiceImplTest(ApplicationContext context) {
        this.instrumentRepository = context.getBean(InstrumentRepository.class);
        this.currencyRepository = context.getBean(CurrencyRepository.class);
        this.stockExchangeRepository = context.getBean(StockExchangeRepository.class);
        this.marketTimeZoneRepository = context.getBean(MarketTimeZoneRepository.class);
        this.industryRepository = context.getBean(IndustryRepository.class);
        this.sectorRepository = context.getBean(SectorRepository.class);
        this.geoRepository = context.getBean(GeoRepository.class);
        this.splitRepository = context.getBean(SplitRepository.class);
        this.dailyBarRepository = context.getBean(DailyBarRepository.class);
    }

    @BeforeEach
    void setUp() {
        service = new MarketDataServiceImpl(yahoo, finviz, instrumentRepository, currencyRepository,
                stockExchangeRepository, marketTimeZoneRepository, industryRepository, sectorRepository, geoRepository,
                splitRepository, dailyBarRepository);
    }

    @AfterEach
    void tearDown() {
        dailyBarRepository.deleteAll();
        splitRepository.deleteAll();
        instrumentRepository.deleteAll();
        currencyRepository.deleteAll();
        stockExchangeRepository.deleteAll();
        marketTimeZoneRepository.deleteAll();
        geoRepository.deleteAll();
        industryRepository.deleteAll();
        sectorRepository.deleteAll();
    }

    @Test
    void loadMarketData() {
    }

    @Test
    void load() {
    }

    @Test
    void updateStock() {
    }

    @Test
    void saveHistory() {
        final String ticker = "test";
        LocalDateTime lastBar = LocalDateTime.now();
        YahooStock yahooStock = YahooStock.builder()
                .ticker(ticker)
                .splitHistory(Set.of(SplitEvent.builder()
                        .ticker(ticker)
                        .date(LocalDate.now())
                        .denominator(BigDecimal.ONE)
                        .numerator(BigDecimal.ONE)
                        .build()))
                .history(new TreeSet<>(List.of(Bar.builder()
                        .ticker(ticker)
                        .timestamp(lastBar)
                        .period(Period.D)
                        .low(BigDecimal.ONE)
                        .high(BigDecimal.ONE)
                        .open(BigDecimal.ONE)
                        .close(BigDecimal.ONE)
                        .volume(2L)
                        .build(), Bar.builder()
                        .ticker(ticker)
                        .timestamp(lastBar.minusDays(1))
                        .period(Period.D)
                        .low(BigDecimal.ONE)
                        .high(BigDecimal.ONE)
                        .open(BigDecimal.ONE)
                        .close(BigDecimal.ONE)
                        .volume(2L)
                        .build(), Bar.builder()
                        .ticker(ticker)
                        .timestamp(lastBar.minusDays(2))
                        .period(Period.D)
                        .low(BigDecimal.ONE)
                        .high(BigDecimal.ONE)
                        .open(BigDecimal.ONE)
                        .close(BigDecimal.ONE)
                        .volume(2L)
                        .build())))
                .build();
        Instrument instrument = instrumentRepository.save(new Instrument(ticker));

        Instrument result = service.saveHistory(instrument, yahooStock);

        assertAll(
                () -> assertEquals(lastBar.toLocalDate(), result.getLastBarDate())
        );
    }

    @Test
    void createStock() {
    }

    @Test
    void createGeo() {
        FinvizStock test = FinvizStock.builder()
                .geo("test")
                .build();

        Geo result = service.createGeo(test);
        Assertions.assertEquals("test", geoRepository.findAll().get(0).getName());
    }

    @Test
    void findGeo() {
        final String expectedString = "test";
        Geo expect = geoRepository.save(new Geo(expectedString));

        assertEquals(1, geoRepository.findAll().size());

        Optional<Geo> result1 = service.findGeo(FinvizStock.builder()
                .geo(expectedString)
                .build());
        Optional<Geo> result2 = service.findGeo(FinvizStock.builder()
                .geo("test-no-expected")
                .build());

        assertAll(
                () -> assertTrue(result1.isPresent()),
                () -> assertFalse(result2.isPresent()),
                () -> assertEquals(1, geoRepository.count()),
                () -> assertEquals(expect.getId(), result1.orElseGet(Assertions::fail).getId()),
                () -> assertEquals(expect, result1.orElseGet(Assertions::fail))
        );
    }

    @Test
    void findIndustry() {
        final String expectedString = "test";
        Sector sector = sectorRepository.save(new Sector("test1"));
        Industry expect = industryRepository.save(new Industry(expectedString, sector));

        assertEquals(1, industryRepository.findAll().size());

        Optional<Industry> result1 = service.findIndustry(FinvizStock.builder()
                .industry(expectedString)
                .build());
        Optional<Industry> result2 = service.findIndustry(FinvizStock.builder()
                .industry("test-no-expected")
                .build());

        assertAll(
                () -> assertTrue(result1.isPresent()),
                () -> assertFalse(result2.isPresent()),
                () -> assertEquals(1, industryRepository.count()),
                () -> assertEquals(expect.getId(), result1.orElseGet(Assertions::fail).getId()),
                () -> assertEquals(expect, result1.orElseGet(Assertions::fail))
        );
    }

    @Test
    void createMarketTimeZone() {
    }

    @Test
    void findTimeZone() {
        final String id = ZoneId.systemDefault()
                .getId();
        MarketTimeZone expect = marketTimeZoneRepository.save(new MarketTimeZone(id));

        assertEquals(1, marketTimeZoneRepository.findAll().size());

        Optional<MarketTimeZone> result1 = service.findTimeZone(YahooStock.builder()
                .timeZone(TimeZone.getTimeZone(id))
                .build());

        assertAll(
                () -> assertTrue(result1.isPresent()),
                () -> assertEquals(1, marketTimeZoneRepository.count()),
                () -> assertEquals(expect.getId(), result1.orElseGet(Assertions::fail).getId()),
                () -> assertEquals(expect, result1.orElseGet(Assertions::fail))
        );
    }

    @Test
    void createStockExchange() {
        YahooStock test = YahooStock.builder()
                .stockExchange("test")
                .build();

        service.createStockExchange(test);

        StockExchange exchange = stockExchangeRepository.findAll().get(0);

        Assertions.assertEquals("test", exchange.getName());
    }

    @Test
    void findStockExchange() {
        final String expectedString = "test";
        StockExchange expect = stockExchangeRepository.save(new StockExchange(expectedString));

        assertEquals(1, stockExchangeRepository.findAll().size());

        Optional<StockExchange> result1 = service.findStockExchange(YahooStock.builder()
                .stockExchange(expectedString)
                .build());
        Optional<StockExchange> result2 = service.findStockExchange(YahooStock.builder()
                .stockExchange("test-no-expected")
                .build());

        assertAll(
                () -> assertTrue(result1.isPresent()),
                () -> assertFalse(result2.isPresent()),
                () -> assertEquals(1, stockExchangeRepository.count()),
                () -> assertEquals(expect.getId(), result1.orElseGet(Assertions::fail).getId()),
                () -> assertEquals(expect, result1.orElseGet(Assertions::fail))
        );
    }

    @Test
    @Disabled
    void createCurrency() {
        YahooStock test = YahooStock.builder()
                .currency("test")
                .build();

        service.createCurrency(test);

        Assertions.assertEquals("test", currencyRepository.findAll().get(0).getCode());
    }

    @Test
    @Disabled
    void findCurrency() {
        String expectedString = "test";
        Currency expect = currencyRepository.save(new Currency(expectedString));

        assertEquals(1, currencyRepository.findAll().size());

        Optional<Currency> result1 = service.findCurrency(YahooStock.builder()
                .currency(expectedString)
                .build());
        Optional<Currency> result2 = service.findCurrency(YahooStock.builder()
                .currency("test-no-expected")
                .build());

        assertAll(
                () -> assertTrue(result1.isPresent()),
                () -> assertFalse(result2.isPresent()),
                () -> assertEquals(1, currencyRepository.count()),
                () -> assertEquals(expect.getId(), result1.orElseGet(Assertions::fail).getId())
        );
    }

    @Test
    void createIndustry() {
        FinvizStock test = FinvizStock.builder()
                .industry("test")
                .sector("sector")
                .build();

        service.createIndustry(test);

        Assertions.assertAll(
                () -> Assertions.assertEquals("test", industryRepository.findAll().get(0).getName()),
                () -> Assertions.assertEquals("sector", sectorRepository.findAll().get(0).getName())
        );
    }

    @Test
    void findSector() {
        Sector sector = sectorRepository.save(new Sector("test1"));

        assertEquals(1, sectorRepository.count());

        Optional<Sector> sector1 = service.findSector(FinvizStock.builder()
                .sector("test1")
                .build());
        Optional<Sector> sector2 = service.findSector(FinvizStock.builder()
                .sector("test2")
                .build());

        assertAll(
                () -> assertTrue(sector1.isPresent()),
                () -> assertFalse(sector2.isPresent()),
                () -> assertEquals(1, sectorRepository.count()),
                () -> assertEquals(sector.getName(), sector1.orElse(new Sector("NPE")).getName())
        );
    }

}