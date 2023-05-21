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

package ua.com.gfalcon.financier.core.providers.yahoo;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Generated;
import ua.com.gfalcon.financier.core.providers.yahoo.query.Adjust;
import ua.com.gfalcon.financier.core.providers.yahoo.query.ChartQueryParameters;
import ua.com.gfalcon.financier.core.providers.yahoo.query.HistoryQueryParameters;
import ua.com.gfalcon.financier.core.providers.yahoo.query.Interval;
import ua.com.gfalcon.financier.core.providers.yahoo.query.Range;
import ua.com.gfalcon.financier.core.providers.yahoo.query.YahooModule;

/**
 * Builder of Yahoo Finance requests.
 */
@Generated
public class YahooQueryBuilder {

    /**
     * Retrieving stock details.
     */
    public static String getQuoteSummary(@NotBlank String symbol, @Size(min = 1) YahooModule... modules) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v11", "finance", "quoteSummary") // v10 or v11
                .path(symbol)
                .queryParam("modules", joinString(modules))
                .build()
                .encode()
                .toUriString();
    }

    public static String getQuoteSummary(@NotBlank String symbol, @Size(min = 1) String... modules) {
        return getQuoteSummary(symbol, (YahooModule[]) Arrays.stream(modules).map(YahooModule::valueOf).toArray());
    }

    /**
     * Get option contracts for a Ticker. Returns the table of option contracts for the underlying asset for the
     * specified ticker (via the path param {symbol}:<br/> The underlying asset's price<br/> Implied volatility<br/>
     * Strike price<br/> Expiration date<br/> fOpen interest<br/> Volume<<br/> Percent change in volume<br/> Bid<br/>
     * Ask<br/> Last trade price<br/>
     */
    public static String getOptions(@NotBlank String symbol) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v7", "finance", "options") //
                .path(symbol)
                .build()
                .encode()
                .toUriString();
    }

    /**
     * Get a list of securities that match a search.
     */
    public static String search(@NotBlank String query) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v1", "finance", "search") // v10 or v11
                .queryParam("q", joinString(query))
                .build()
                .encode()
                .toUriString();
    }

    /**
     * Getting Historical Prices.<br/> The metrics returned include:<br/> Date - The date metric returns the date of the
     * stock price. This is used for indexing the DataFrame.<br/> High - The high metric returns the highest price of
     * the stock for that day. This is used for computing the percent change.<br/> Low - The low metric returns the
     * lowest price of the stock for that day. This is used for computing the percent change.<br/> Open - The open
     * metric returns the opening price of the stock for that day. This is used for computing the percent change<br/>
     * Close - The close metric returns the closing price of the stock for that day. This is used for computing the
     * percent change.<br/> Volume - The volume metric returns the number of shares traded for that day. This is used
     * for computing the average daily trading volume.<br/> Adj Close - The adjusted close metric returns the closing
     * price of the stock for that day, adjusted for splits and dividends. This is used for computing the percent
     * change.<br/> Currency - The currency metric returns the stock price in US dollars. This is used for computing the
     * percent change.<br/> InstrumentType - instrumentType shows whether the stock is equity, index, currency, or
     * commodity. This is used for filtering the data.<br/>
     */
    public static String getChart(@NotBlank String symbol, ChartQueryParameters params) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v8", "finance", "chart") // v8
                .path(symbol)
                .queryParamIfPresent("interval", Optional.ofNullable(params)
                        .map(ChartQueryParameters::getInterval)
                        .map(Interval::getValue))
                .queryParamIfPresent("range", Optional.ofNullable(params)
                        .map(ChartQueryParameters::getRange)
                        .map(Range::getValue))
                .queryParamIfPresent("period1", Optional.ofNullable(params).map(ChartQueryParameters::getFrom))
                .queryParamIfPresent("period2", Optional.ofNullable(params).map(ChartQueryParameters::getTo))
                .queryParamIfPresent("close", Optional.ofNullable(params)
                        .map(ChartQueryParameters::getClose)
                        .map(Adjust::getValue))
                .queryParamIfPresent("events", Optional.ofNullable(params)
                        .map(p -> {
                            if (p.getSplitEvents() && p.getDividendsEvents()) {
                                return "div%7Csplit";
                            } else if (p.getSplitEvents()) {
                                return "split";
                            } else if (p.getDividendsEvents()) {
                                return "div";
                            }
                            return null;
                        })
                )
                .queryParamIfPresent("includePrePost", Optional.ofNullable(params)
                        .map(ChartQueryParameters::getIncludePrePost)
                        .map(Object::toString))
                .build()
                .encode()
                .toUriString();
    }

    /**
     * Historic data for a stock ticker.<br/> <br/> The full list of columns is:<br/> Date - The date of the
     * observation<br/> Open - The opening price of the stock for the day<br/> High - The highest price of the stock for
     * the day<br/> Low - The lowest price of the stock for the day<br/> Close - The closing price of the stock for the
     * day<br/> Adj Close - An adjusted close. Prices are already adjusted for splits, the "Adjusted Close" price is
     * further adjusted for dividends.<br/> Volume - How many shares traded hands during the interval<br/>
     *
     */
    public static String getHistory(@NotBlank String symbol, HistoryQueryParameters params) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v7", "finance", "download") // v7
                .path(symbol)
                .queryParamIfPresent("interval", Optional.ofNullable(params)
                        .map(HistoryQueryParameters::getInterval)
                        .map(Interval::getValue))
                .queryParamIfPresent("period1", Optional.ofNullable(params).map(HistoryQueryParameters::getFrom))
                .queryParamIfPresent("period2", Optional.ofNullable(params).map(HistoryQueryParameters::getTo))
                .queryParamIfPresent("close", Optional.ofNullable(params)
                        .map(HistoryQueryParameters::getClose)
                        .map(Adjust::getValue))
                .build()
                .encode()
                .toUriString();
    }

    /**
     * Get key details about multiple tickers at once.<br/> Yahoo Finance will return data for all of the specified
     * tickers in one call, which can then be easily compared.<br/> This is a powerful way to quickly get an overview of
     * how different stocks are performing.<br/> The metrics returned from this query include:<br/> *
     * trailingAnnualDividendRate - The trailing annual dividend rate, expressed as a percentage of the current stock
     * price.<br/> * dividendDate - The date of the most recent dividend payment.<br/> * trailingAnnualDividendYield -
     * The trailing annual dividend yield, expressed as a percentage of the current stock price.<br/> * priceHint - A
     * hint for the number of digits to display after the decimal point when formatting prices.<br/> *
     * firstTradeDateMilliseconds - The date of the first trade for this stock.<br/> * shortName - A short name for the
     * company or security.<br/> * marketState - The market state of the security.<br/> * esgPopulated - True if this
     * security has ESG data.<br/> * market - The market of the security.<br/> * gmtOffSetMilliseconds - The difference,
     * in milliseconds, between Greenwich Mean Time (GMT) and the market's primary exchange's local time.<br/>
     */
    public static String getQuote(@NotBlank String... symbols) {
        return UriComponentsBuilder.newInstance()
                .pathSegment("v7", "finance", "quote") // v7 or v6
                .queryParam("symbols", joinString(symbols))
                .build()
                .encode()
                .toUriString();
    }

    private static String joinString(YahooModule... modules) {
        return joinString((String[]) Arrays.stream(modules).map(YahooModule::getValue).distinct().toArray());
    }

    private static String joinString(String... str) {
        if (str.length == 0) {
            return "";
        }
        if (str.length == 1) {
            return str[0];
        }
        StringBuilder builder = new StringBuilder(str[0]);
        for (int i = 1; i < str.length; i++) {
            builder.append(",");
            builder.append(str[i]);
        }
        return builder.toString();
    }
}
