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

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.gfalcon.financier.core.exceptions.Http401YahooFinanceException;
import ua.com.gfalcon.financier.core.exceptions.YahooFinanceException;
import ua.com.gfalcon.financier.core.screener.model.Bar;
import ua.com.gfalcon.financier.core.screener.model.Period;
import ua.com.gfalcon.financier.core.screener.model.SplitEvent;
import ua.com.gfalcon.financier.core.screener.model.YahooStock;
import ua.com.gfalcon.financier.core.screener.service.YahooService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.histquotes2.HistoricalSplit;
import yahoofinance.quotes.stock.StockQuote;

/**
 * Yahoo service.
 */
@Slf4j
@Service
public class YahooServiceImpl implements YahooService {

    @Override
    public YahooStock getStock(String ticker, LocalDate since) {
        log.info("YahooFinance Start load Stock {} since {}", ticker, since);
        Instant instant = since.atStartOfDay(ZoneId.systemDefault())
                .toInstant();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Date.from(instant));

        YahooStock.YahooStockBuilder stockBuilder = YahooStock.builder();

        try {
            Stock stock = YahooFinance.get(ticker, false);
            if (stock == null) {
                throw new YahooFinanceException("YahooFinance return null for ticker ");
            }
            List<HistoricalSplit> splitList = stock.getSplitHistory(calendar);
            List<HistoricalQuote> history = stock.getHistory(calendar, Interval.DAILY);
            stockBuilder.ticker(stock.getSymbol());
            stockBuilder.name(stock.getName());
            stockBuilder.currency(stock.getCurrency());
            stockBuilder.stockExchange(stock.getStockExchange());
            stockBuilder.splitHistory(convert(splitList));
            stockBuilder.history(convertHistory(history));
            stockBuilder.timeZone(Optional.of(stock)
                    .map(Stock::getQuote)
                    .map(StockQuote::getTimeZone)
                    .orElse(TimeZone.getDefault()));
        } catch (IOException e) {
            log.error("YahooFinance ERROR load Stock {}", ticker);
            String message = "Error to load stock data for ticker " + ticker;
            if (e.getMessage().startsWith("Server returned HTTP response code: 401")) {
                throw new Http401YahooFinanceException(message, e);
            }
            throw new YahooFinanceException(message, e);
        }
        log.info("YahooFinance Complete load Stock {}", ticker);
        return stockBuilder.build();
    }

    private SortedSet<Bar> convertHistory(List<HistoricalQuote> history) {
        List<Bar> barList = history.stream()
                .map(this::convert)
                .toList();
        SortedSet<Bar> set = new TreeSet<>(Comparator.comparing(Bar::timestamp));
        set.addAll(barList);
        return set;
    }

    private Bar convert(HistoricalQuote historicalQuote) {
        return Bar.builder()
                .ticker(historicalQuote.getSymbol())
                .timestamp(convert(historicalQuote.getDate()))
                .open(historicalQuote.getOpen())
                .low(historicalQuote.getLow())
                .high(historicalQuote.getHigh())
                .close(historicalQuote.getClose())
                .volume(historicalQuote.getVolume())
                .period(Period.D)
                .build();
    }

    private Set<SplitEvent> convert(List<HistoricalSplit> splits) {
        return splits.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    private SplitEvent convert(HistoricalSplit historicalSplit) {
        return SplitEvent.builder()
                .ticker(historicalSplit.getSymbol())
                .denominator(historicalSplit.getDenominator())
                .numerator(historicalSplit.getNumerator())
                .date(convert(historicalSplit.getDate()).toLocalDate())
                .build();
    }

    private LocalDateTime convert(Calendar calendar) {
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zid);
    }

}
