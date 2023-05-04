package ua.com.gfalcon.financier.screener.service.impl;

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
import ua.com.gfalcon.financier.exceptions.YahooFinanceException;
import ua.com.gfalcon.financier.screener.model.Bar;
import ua.com.gfalcon.financier.screener.model.Period;
import ua.com.gfalcon.financier.screener.model.SplitEvent;
import ua.com.gfalcon.financier.screener.model.YahooStock;
import ua.com.gfalcon.financier.screener.service.YahooService;
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
            throw new YahooFinanceException("Error to load stock data for ticker " + ticker, e);
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
