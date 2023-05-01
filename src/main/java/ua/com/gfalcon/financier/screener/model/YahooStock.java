package ua.com.gfalcon.financier.screener.model;

import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;

import lombok.Builder;

@Builder
public record YahooStock(String ticker, String name, String currency, Set<SplitEvent> splitHistory,
                         SortedSet<Bar> history, String stockExchange, TimeZone timeZone) implements Stock,
        SplitHistory, MarketHistory {

}
