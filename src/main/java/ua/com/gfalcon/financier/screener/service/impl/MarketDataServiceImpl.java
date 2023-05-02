package ua.com.gfalcon.financier.screener.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.com.gfalcon.financier.screener.domain.Currency;
import ua.com.gfalcon.financier.screener.domain.DailyBar;
import ua.com.gfalcon.financier.screener.domain.DailyBarId;
import ua.com.gfalcon.financier.screener.domain.DataProvider;
import ua.com.gfalcon.financier.screener.domain.Geo;
import ua.com.gfalcon.financier.screener.domain.Industry;
import ua.com.gfalcon.financier.screener.domain.Instrument;
import ua.com.gfalcon.financier.screener.domain.MarketTimeZone;
import ua.com.gfalcon.financier.screener.domain.Sector;
import ua.com.gfalcon.financier.screener.domain.Split;
import ua.com.gfalcon.financier.screener.domain.StockExchange;
import ua.com.gfalcon.financier.screener.model.FinvizStock;
import ua.com.gfalcon.financier.screener.model.YahooStock;
import ua.com.gfalcon.financier.screener.repository.CurrencyRepository;
import ua.com.gfalcon.financier.screener.repository.DailyBarRepository;
import ua.com.gfalcon.financier.screener.repository.GeoRepository;
import ua.com.gfalcon.financier.screener.repository.IndustryRepository;
import ua.com.gfalcon.financier.screener.repository.InstrumentRepository;
import ua.com.gfalcon.financier.screener.repository.MarketTimeZoneRepository;
import ua.com.gfalcon.financier.screener.repository.SectorRepository;
import ua.com.gfalcon.financier.screener.repository.SplitRepository;
import ua.com.gfalcon.financier.screener.repository.StockExchangeRepository;
import static ua.com.gfalcon.financier.screener.service.FinvizPresets.FOR_TRADING_FILTER;
import ua.com.gfalcon.financier.screener.service.FinvizService;
import ua.com.gfalcon.financier.screener.service.MarketDataService;
import ua.com.gfalcon.financier.screener.service.YahooService;

/**
 * Market data service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MarketDataServiceImpl implements MarketDataService {

    private final YahooService yahoo;
    private final FinvizService finviz;
    private final InstrumentRepository instrumentRepository;
    private final CurrencyRepository currencyRepository;
    private final StockExchangeRepository stockExchangeRepository;
    private final MarketTimeZoneRepository marketTimeZoneRepository;
    private final IndustryRepository industryRepository;
    private final SectorRepository sectorRepository;
    private final GeoRepository geoRepository;
    private final SplitRepository splitRepository;
    private final DailyBarRepository dailyBarRepository;


    @Override
    @Transactional
    @Scheduled(cron = "0 30 6 * * TUE-SAT")
    public long loadMarketData() {
        log.info("Start load daily data");
        Set<String> tickers = finviz.findTickers(FOR_TRADING_FILTER);

        int i = 0;
        for (String ticker : tickers) {
            try {
                this.load(ticker);
                log.info("{} is LOADED : {} / {}", ticker, ++i, tickers.size());
                log.info("===========================================");
                Thread.sleep(5_000);
            } catch (Exception e) {
                log.error("ERROR load data for ticker " + ticker, e);
            }
        }
        log.info("End load daily data. Successful result : {} / {}", i, tickers.size());
        return tickers.size();
    }

    @Override
    @Transactional
    public void load(String ticker) {
        log.info("Start load data for {}", ticker);
        Optional<Instrument> optional = instrumentRepository.findById(ticker);
        if (optional.isPresent()) {
            updateStock(optional.get());
        } else {
            createStock(ticker);
        }
        log.info("End load data for {}", ticker);
    }

    @Override
    @Transactional
    public Instrument updateStock(Instrument instrument) {
        log.info("Start update Instrument {}", instrument.getTicker());
        YahooStock stock = yahoo.getStock(instrument.getTicker(), instrument.getLastBarDate());
        Instrument saved = saveHistory(instrument, stock);
        log.info("Instrument {} is updated v {}", instrument.getTicker(), saved.getVersion());
        return saved;
    }

    @Override
    @Transactional
    public Instrument saveHistory(Instrument instrument, YahooStock stock) {
        log.info("Start save history data for {}", stock.ticker());
        Set<Split> splits = stock.splitHistory()
                .stream()
                .map(splitEvent -> {
                    Split split = new Split();
                    split.setTicker(instrument);
                    split.setDate(splitEvent.date());
                    split.setNumerator(splitEvent.numerator());
                    split.setDenominator(splitEvent.denominator());
                    return split;
                })
                .collect(Collectors.toSet());
        if (!splits.isEmpty()) {
            List<Split> splitList = splitRepository.saveAll(splits);
            log.info("Save split list of {} with size {} is successful", instrument.getTicker(), splitList.size());
        } else {
            log.info("No splits for {}", instrument.getTicker());
        }

        Set<DailyBar> bars = stock.history()
                .stream()
                .map(bar -> {
                    DailyBarId id = new DailyBarId(instrument, bar.date());
                    DailyBar daily = new DailyBar();
                    daily.setId(id);
                    daily.setOpen(bar.open());
                    daily.setLow(bar.low());
                    daily.setHigh(bar.high());
                    daily.setClose(bar.close());
                    daily.setValue(bar.volume());
                    return daily;
                })
                .collect(Collectors.toSet());

        if (!bars.isEmpty()) {
            List<DailyBar> barList = dailyBarRepository.saveAll(bars);
            log.info("Save bar list of {} with size {} is successful", instrument.getTicker(), barList.size());

            LocalDate max = bars.stream()
                    .map(DailyBar::getId)
                    .map(DailyBarId::getDate)
                    .max(LocalDate::compareTo)
                    .orElse(LocalDate.now());

            instrument.setLastBarDate(max);
            instrument.setDailyHistoryProvider(DataProvider.YAHOO);
            Instrument save = instrumentRepository.save(instrument);
            log.info("Instrument {}; last saved bar {}",
                    save.getTicker(), save.getLastBarDate());
            return save;
        } else {
            log.info("No bars for {}", instrument.getTicker());
        }
        return instrument;
    }

    @Override
    @Transactional
    public Instrument createStock(String ticker) {
        log.info("Start create Instrument {}", ticker);
        YahooStock yhStock = yahoo.getStock(ticker, LocalDate.of(2015, Month.JANUARY, 1));

        Currency currency = createCurrency(yhStock);
        StockExchange stockExchange = createStockExchange(yhStock);
        MarketTimeZone timeZone = createMarketTimeZone(yhStock);
        FinvizStock fvStock = finviz.getStock(ticker);
        Industry industry = getIndustry(fvStock);
        Geo geo = createGeo(fvStock);

        Instrument instrument = new Instrument();
        instrument.setTicker(yhStock.ticker());
        instrument.setName(yhStock.name());
        instrument.setCurrency(currency);
        instrument.setStockExchange(stockExchange);
        instrument.setTimeZone(timeZone);
        instrument.setIndustry(industry);
        instrument.setGeo(geo);
        instrument.setOptionable(Optional.ofNullable(fvStock.optionable()).orElse("")
                .equalsIgnoreCase("yes"));
        instrument.setShortable(Optional.ofNullable(fvStock.optionable()).orElse("")
                .equalsIgnoreCase("yes"));
        instrument.setInfo(fvStock.companyInfo());

        Instrument save = instrumentRepository.save(instrument);
        log.info("Instrument {} is created v {}", ticker, save.getVersion());
        return saveHistory(save, yhStock);
    }

    @Override
    @Transactional
    public Geo createGeo(FinvizStock stock) {
        log.info("Start create geo {}", stock.geo());
        Geo geo = findGeo(stock)
                .orElseGet(() -> geoRepository.save(new Geo(stock.geo())));
        log.info("Geo {} is updated v {}", geo.getName(), geo.getVersion());
        return geo;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Geo> findGeo(FinvizStock stock) {
        log.info("Start find geo {}", stock.geo());
        Optional<Geo> geo = geoRepository.findByName(stock.geo());
        log.info("Geo {} is {}", stock.geo(), geo.isPresent());
        return geo;
    }

    private Industry getIndustry(FinvizStock stock) {
        Industry industry = findIndustry(stock)
                .orElseGet(() -> createIndustry(stock));
        return industry;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Industry> findIndustry(FinvizStock stock) {
        log.info("Start find industry {}", stock.industry());
        Optional<Industry> industry = industryRepository.findByName(stock.industry());
        log.info("Industry {} is {}", stock.industry(), industry.isPresent());
        return industry;
    }

    @Override
    @Transactional
    public MarketTimeZone createMarketTimeZone(YahooStock stock) {
        log.info("Start create timeZone {}", stock.timeZone());
        MarketTimeZone timeZone = findTimeZone(stock)
                .orElseGet(() -> marketTimeZoneRepository.save(new MarketTimeZone(stock.timeZone())));
        log.info("MarketTimeZone {} is updated v {}", timeZone.getName(), timeZone.getVersion());
        return timeZone;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MarketTimeZone> findTimeZone(YahooStock stock) {
        log.info("Start find timeZone {}", stock.timeZone());
        Optional<MarketTimeZone> timeZone = marketTimeZoneRepository.findMarketTimeZoneByName(
                stock.timeZone()
                        .getID());
        log.info("MarketTimeZone {} is {}", stock.stockExchange(), timeZone.isPresent());
        return timeZone;
    }

    @Override
    @Transactional
    public StockExchange createStockExchange(YahooStock stock) {
        log.info("Start create stockExchange {}", stock.stockExchange());
        StockExchange stockExchange = findStockExchange(stock)
                .orElseGet(() -> stockExchangeRepository.save(new StockExchange(stock.stockExchange())));
        log.info("StockExchange {} is updated v {}", stockExchange.getName(), stockExchange.getVersion());
        return stockExchange;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StockExchange> findStockExchange(YahooStock stock) {
        log.info("Start find stockExchange {}", stock.stockExchange());
        Optional<StockExchange> stockExchange = stockExchangeRepository.findByName(stock.stockExchange());
        log.info("StockExchange {} is {}", stock.stockExchange(), stockExchange.isPresent());
        return stockExchange;
    }

    @Override
    @Transactional
    public Currency createCurrency(YahooStock stock) {
        log.info("Start create currency {}", stock.currency());
        Optional<Currency> optional = findCurrency(stock);
        Currency currency = optional.orElseGet(() -> currencyRepository.save(new Currency(stock.currency())));
        log.info("Currency {} is updated v {}", currency.getCode(), currency.getVersion());
        return currency;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Currency> findCurrency(YahooStock stock) {
        log.info("Start find currency {}", stock.currency());
        Optional<Currency> currency = currencyRepository.findByCode(stock.currency());
        log.info("Currency {} is {}", stock.currency(), currency.isPresent());
        return currency;
    }

    @Override
    @Transactional
    public Industry createIndustry(FinvizStock stock) {
        log.info("Start create industry {}", stock.industry());
        Sector sector = findSector(stock)
                .orElseGet(() -> sectorRepository.save(new Sector(stock.sector())));
        Industry industry = industryRepository.save(new Industry(stock.industry(), sector));
        log.info("Industry {} is updated v {}", industry.getName(), industry.getVersion());
        return industry;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sector> findSector(FinvizStock stock) {
        log.info("Start find sector {}", stock.sector());
        Optional<Sector> sector = sectorRepository.findByName(stock.sector());
        log.info("Sector {} is {}", stock.sector(), sector.isPresent());
        return sector;
    }

}
