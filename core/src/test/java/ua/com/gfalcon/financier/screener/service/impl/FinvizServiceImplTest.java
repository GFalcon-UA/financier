package ua.com.gfalcon.financier.screener.service.impl;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.gfalcon.financier.screener.model.FinvizStock;
import ua.com.gfalcon.financier.screener.service.FinvizPresets;
import ua.com.gfalcon.financier.screener.service.FinvizService;

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