package ua.com.gfalcon.financier.screener.service;

import java.util.List;
import java.util.Set;

import ua.com.gfalcon.financier.screener.model.FinvizStock;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;

/**
 * Finviz screener service.
 */
public interface FinvizService {

    Set<String> findTickers(List<FilterParameter> filters);

    FinvizStock getStock(String ticker);

}
