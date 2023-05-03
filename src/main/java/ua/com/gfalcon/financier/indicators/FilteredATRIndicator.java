package ua.com.gfalcon.financier.indicators;

import java.util.ArrayList;
import java.util.List;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.CachedIndicator;
import org.ta4j.core.indicators.helpers.TRIndicator;
import org.ta4j.core.num.DecimalNum;
import org.ta4j.core.num.Num;

/**
 * Filtered ATR indicator that ignore paranormal bars.
 */
public class FilteredATRIndicator extends CachedIndicator<Num> {

    private final TRIndicator trIndicator;
    private final Integer period;

    public FilteredATRIndicator(BarSeries series) {
        this(new TRIndicator(series));
    }

    public FilteredATRIndicator(TRIndicator tr) {
        this(tr, 5);
    }

    public FilteredATRIndicator(BarSeries series, Integer period) {
        this(new TRIndicator(series), period);
    }

    /**
     * Filtered ATR.
     *
     * @param tr TRIndicator
     * @param period period
     */
    public FilteredATRIndicator(TRIndicator tr, Integer period) {
        super(tr.getBarSeries());
        this.trIndicator = tr;
        this.period = period;
    }

    @Override
    protected Num calculate(int index) {
        List<Num> atrs = new ArrayList<>();

        int trIndex = -1;
        Num atr = trIndicator.getValue(trIndex);

        Result firstIteration = fill(new ArrayList<>(), trIndex);
        trIndex = firstIteration.ind();
        List<Num> filtered = firstIteration.atrs();

        if (filtered.size() == period) {
            return getAverage(filtered);
        }

        while (filtered.size() < period) {
            Result result = fill(filtered, trIndex);
            filtered = result.atrs();
            trIndex = result.ind();
        }

        return getAverage(filtered);
    }

    private Result fill(List<Num> atrs, int trIndex) {
        int ind = trIndex;
        List<Num> list = new ArrayList<>(atrs);
        while (list.size() < period) {
            list.add(trIndicator.getValue(ind));
            ind = ind - 1;
        }
        Num finalAtr = getAverage(list);
        List<Num> list2 = list.stream().filter(num -> isNotParanormalBar(finalAtr, num)).toList();
        return new Result(list2, ind);
    }

    private record Result(List<Num> atrs, Integer ind){}

    private static Num getAverage(List<Num> atrs) {
        Num sum = DecimalNum.valueOf(0);
        for (Num c : atrs) {
            sum = sum.plus(c);
        }
        return sum.dividedBy(DecimalNum.valueOf(atrs.size()));
    }

    private static boolean isNotParanormalBar(Num atr, Num barTr) {
        return !barTr.isGreaterThanOrEqual(atr.multipliedBy(DecimalNum.valueOf(2)))
                && !barTr.isLessThan(atr.dividedBy(DecimalNum.valueOf(3)));
    }

}
