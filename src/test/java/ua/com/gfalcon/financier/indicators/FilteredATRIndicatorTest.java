package ua.com.gfalcon.financier.indicators;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

class FilteredATRIndicatorTest {

    private BarSeries series = new BaseBarSeriesBuilder().withName("test").build();

    @BeforeEach
    void setUp() {
        ZonedDateTime endTime = ZonedDateTime.now();
        series.addBar(endTime, 104.0, 110.0, 100.0, 106.0, 1);
        series.addBar(endTime.plusDays(1), 104.0, 110.0, 100.0, 105.0, 2);
        series.addBar(endTime.plusDays(2), 104.0, 110.0, 100.0, 105.0, 3);
        series.addBar(endTime.plusDays(3), 104.0, 110.0, 100.0, 105.0, 4);
        series.addBar(endTime.plusDays(4), 104.0, 110.0, 100.0, 105.0, 5);
        series.addBar(endTime.plusDays(5), 104.0, 110.0, 100.0, 105.0, 6);
        series.addBar(endTime.plusDays(6), 105.0, 104.0, 106.0, 105.0, 7);
        series.addBar(endTime.plusDays(7), 104.0, 110.0, 100.0, 105.0, 8);
        series.addBar(endTime.plusDays(8), 104.0, 130.0, 90.0, 105.0, 9);
        series.addBar(endTime.plusDays(9), 104.0, 110.0, 100.0, 105.0, 10);
        series.addBar(endTime.plusDays(10), 104.0, 110.0, 100.0, 105.0, 11);

    }

    @Test
    void getValue() {
        FilteredATRIndicator atr = new FilteredATRIndicator(series);
        Collection<Executable> assertions = new ArrayList<>();
        for (int i = 0; i < series.getBarCount(); i++) {
            final Num value = atr.getValue(i);
            Executable ex = () -> Assertions.assertEquals(DecimalNum.valueOf(10), value);
            assertions.add(ex);
        }
        Assertions.assertAll(assertions);
    }
}