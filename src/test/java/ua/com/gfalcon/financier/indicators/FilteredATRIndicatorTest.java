package ua.com.gfalcon.financier.indicators;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

class FilteredATRIndicatorTest {

    @Test
    void getValue() {
        BarSeries series = new BaseBarSeriesBuilder().withName("test").build();
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

        FilteredATRIndicator atr = new FilteredATRIndicator(series);
        Collection<Executable> assertions = new ArrayList<>();
        for (int i = 0; i < series.getBarCount(); i++) {
            final Num value = atr.getValue(i);
            Executable ex = () -> Assertions.assertEquals(DecimalNum.valueOf(10), value);
            assertions.add(ex);
        }
        Assertions.assertAll(assertions);
    }

    @Test
    void getValueRaised() {
        BarSeries series = new BaseBarSeriesBuilder().withName("test").build();
        ZonedDateTime endTime = ZonedDateTime.now();
        series.addBar(endTime, 104.0, 108.0, 100.0, 106.0, 1);
        series.addBar(endTime.plusDays(1), 104.0, 110.0, 100.0, 105.0, 2);
        series.addBar(endTime.plusDays(2), 104.0, 120.0, 100.0, 105.0, 3);
        series.addBar(endTime.plusDays(3), 104.0, 130.0, 100.0, 105.0, 4);
        series.addBar(endTime.plusDays(4), 104.0, 140.0, 100.0, 105.0, 5);
        series.addBar(endTime.plusDays(5), 104.0, 150.0, 100.0, 105.0, 6);
        series.addBar(endTime.plusDays(6), 105.0, 164.0, 100.0, 105.0, 7);
        series.addBar(endTime.plusDays(7), 104.0, 170.0, 100.0, 105.0, 8);
        series.addBar(endTime.plusDays(8), 104.0, 180.0, 100.0, 105.0, 9);
        series.addBar(endTime.plusDays(9), 104.0, 190.0, 100.0, 105.0, 10);
        series.addBar(endTime.plusDays(10), 104.0, 200.0, 100.0, 105.0, 11);

        FilteredATRIndicator atr = new FilteredATRIndicator(series);
        Collection<Executable> assertions = new ArrayList<>();
        for (int i = 0; i < series.getBarCount(); i++) {
            final Num previous = atr.getValue(i - 1);
            final Num value = atr.getValue(i);
            if (i > 5) {
                Executable ex = () -> Assertions.assertTrue(value.isGreaterThan(previous),
                        "Current: " + value + "; Previous: " + previous);
                assertions.add(ex);
            }
        }
        Assertions.assertAll(assertions);
    }

    @Test
    void noParanormalBar() {
        final DecimalNum value = DecimalNum.valueOf(10);
        Assertions.assertTrue(FilteredATRIndicator.isNotParanormalBar(value, value));
    }

    @Test
    void smallParanormalBar() {
        final DecimalNum atr = DecimalNum.valueOf(10);
        Assertions.assertFalse(FilteredATRIndicator.isNotParanormalBar(atr, atr.dividedBy(DecimalNum.valueOf(3.1))));
    }

    @Test
    void bigParanormalBar() {
        final DecimalNum atr = DecimalNum.valueOf(10);
        Assertions.assertFalse(FilteredATRIndicator.isNotParanormalBar(atr, atr.multipliedBy(DecimalNum.valueOf(2.1))));
    }
}