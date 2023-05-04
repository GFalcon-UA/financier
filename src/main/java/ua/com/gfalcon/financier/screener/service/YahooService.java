package ua.com.gfalcon.financier.screener.service;

import java.time.LocalDate;

import ua.com.gfalcon.financier.screener.model.YahooStock;

/**
 * Yahoo service.
 */
public interface YahooService {

    YahooStock getStock(String ticker, LocalDate since);

}
