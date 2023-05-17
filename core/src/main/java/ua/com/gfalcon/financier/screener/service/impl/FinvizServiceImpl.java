package ua.com.gfalcon.financier.screener.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ua.com.gfalcon.financier.screener.model.FinvizStock;
import ua.com.gfalcon.financier.screener.service.FinvizService;
import ua.com.gfalcon.finviz.overview.Stock;
import ua.com.gfalcon.finviz.screener.FinvizScreener;
import ua.com.gfalcon.finviz.screener.Screener;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

/**
 * Finviz screener Service.
 */
@Slf4j
@Service
public class FinvizServiceImpl implements FinvizService {

    @Override
    public Set<String> findTickers(List<FilterParameter> filter) {
        log.info("Run Finviz screener with filter: {}", filter);
        Screener screener = new FinvizScreener(filter, null);
        Set<String> tickers = screener.getTickers();
        log.info("Finviz screener result: {} tickers", tickers.size());
        return tickers;
    }

    @Override
    public FinvizStock getStock(String ticker) {
        log.info("Request stock data from Finviz for ticker {}", ticker);
        Stock stock = new Stock(ticker);
        log.info("Received stock data from Finviz for ticker {}", ticker);
        return FinvizStock.builder()
                .ticker(stock.getTicker())
                .name(stock.getCompanyName())
                .sector(stock.getSector())
                .industry(stock.getIndustry())
                .geo(stock.getGeo())
                .index(stock.getIndex())
                .pe(stock.getPe())
                .eps(stock.getEps())
                .insiderOwn(stock.getInsiderOwn())
                .shsOutstand(stock.getShsOutstand())
                .perfWeek(stock.getPerfWeek())
                .marketCap(stock.getMarketCap())
                .forwardPE(stock.getForwardPE())
                .epsNextY(stock.getEpsNextY())
                .insiderTrans(stock.getInsiderTrans())
                .shsFloat(stock.getShsFloat())
                .perfMonth(stock.getPerfMonth())
                .income(stock.getIncome())
                .peg(stock.getPeg())
                .epsNextQ(stock.getEpsNextQ())
                .instOwn(stock.getInstOwn())
                .shortFloat(stock.getShortFloat())
                .perfQuarter(stock.getPerfQuarter())
                .sales(stock.getSales())
                .ps(stock.getPs())
                .epsThisYPercent(stock.getEpsThisYPercent())
                .instTrans(stock.getInstTrans())
                .shortInterest(stock.getShortInterest())
                .perfHalfY(stock.getPerfHalfY())
                .bookSh(stock.getBookSh())
                .pb(stock.getPb())
                .epsNextYPercent(stock.getEpsNextYPercent())
                .roa(stock.getRoa())
                .targetPrice(stock.getTargetPrice())
                .perfYear(stock.getPerfYear())
                .cashSh(stock.getCashSh())
                .pc(stock.getPc())
                .epsNext5YPercent(stock.getEpsNext5YPercent())
                .roe(stock.getRoe())
                .w52Range(stock.getW52Range())
                .perfYTD(stock.getPerfYTD())
                .dividend(stock.getDividend())
                .pfcf(stock.getPfcf())
                .epsPast5YPercent(stock.getEpsPast5YPercent())
                .roi(stock.getRoi())
                .w52High(stock.getW52High())
                .beta(stock.getBeta())
                .dividendPercent(stock.getDividendPercent())
                .quickRatio(stock.getQuickRatio())
                .salesPast5Y(stock.getSalesPast5Y())
                .grossMargin(stock.getGrossMargin())
                .w52Low(stock.getW52Low())
                .atr(stock.getAtr())
                .employees(stock.getEmployees())
                .currentRatio(stock.getCurrentRatio())
                .salesQQ(stock.getSalesQQ())
                .operMargin(stock.getOperMargin())
                .rsi14(stock.getRsi14())
                .volatility(stock.getVolatility())
                .optionable(stock.getOptionable())
                .debtEq(stock.getDebtEq())
                .epsQQ(stock.getEpsQQ())
                .profitMargin(stock.getProfitMargin())
                .relVolume(stock.getRelVolume())
                .prevClose(stock.getPrevClose())
                .shortable(stock.getShortable())
                .ltDebtEq(stock.getLtDebtEq())
                .earnings(stock.getEarnings())
                .payout(stock.getPayout())
                .avgVolume(stock.getAvgVolume())
                .price(stock.getPrice())
                .recom(stock.getRecom())
                .sma20(stock.getSma20())
                .sma50(stock.getSma50())
                .sma200(stock.getSma200())
                .volume(stock.getVolume())
                .change(stock.getChange())
                .companyInfo(stock.getCompanyInfo())
                .build();
    }

}
