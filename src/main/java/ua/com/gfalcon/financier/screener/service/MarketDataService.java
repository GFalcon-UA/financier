package ua.com.gfalcon.financier.screener.service;

import java.util.Optional;

import ua.com.gfalcon.financier.screener.domain.Currency;
import ua.com.gfalcon.financier.screener.domain.Geo;
import ua.com.gfalcon.financier.screener.domain.Industry;
import ua.com.gfalcon.financier.screener.domain.Instrument;
import ua.com.gfalcon.financier.screener.domain.MarketTimeZone;
import ua.com.gfalcon.financier.screener.domain.Sector;
import ua.com.gfalcon.financier.screener.domain.StockExchange;
import ua.com.gfalcon.financier.screener.model.FinvizStock;
import ua.com.gfalcon.financier.screener.model.YahooStock;

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
