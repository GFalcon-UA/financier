package ua.com.gfalcon.financier.screener.service;

import java.util.List;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.params.AverageTrueRange;
import ua.com.gfalcon.finviz.screener.filter.params.AverageVolume;
import ua.com.gfalcon.finviz.screener.filter.params.IPOdate;
import ua.com.gfalcon.finviz.screener.filter.params.Industry;
import ua.com.gfalcon.finviz.screener.filter.params.MarketCap;
import ua.com.gfalcon.finviz.screener.filter.params.Price;

/**
 * Finviz screener preset configurations.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FinvizPresets {

    public static final List<FilterParameter> FOR_TRADING_FILTER = List.of(Industry.STOCK, AverageVolume.OVER_300_K,
            IPOdate.MORE_THAN_5_YEARS_AGO, Price.FROM_1_TO_20, AverageTrueRange.OVER_0_25, MarketCap.SMALL_PLUS);

}
