package ua.com.gfalcon.financier.screener.service.impl;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.com.gfalcon.financier.screener.model.YahooStock;
import ua.com.gfalcon.financier.screener.service.YahooService;

class YahooServiceImplTest {

    private YahooService self;

    @BeforeEach
    void setUp() {
        self = new YahooServiceImpl();
    }

    @Test
    void getStock() throws IOException {
        final LocalDate startDate = LocalDate.now()
                .minusDays(10);
        final String symbol = "SPY";

        YahooStock stock = self.getStock(symbol, startDate);

        assertNotNull(stock, "YahooFinance doesnt return response");
        assertEquals(symbol, stock.ticker(), "The ticker is not matched");
    }
}