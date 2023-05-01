package ua.com.gfalcon.financier.screener.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import lombok.Builder;

@Builder
public record SplitEvent(String ticker, LocalDate date, BigDecimal numerator, BigDecimal denominator) {

    /**
     * Split factor.
     *
     * @return split factor or 1 if some exception.
     */
    public BigDecimal getSplitFactor() {
        if (numerator == null) {
            return BigDecimal.ONE;
        }
        if (denominator == null || denominator.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        }
        return numerator.divide(denominator, RoundingMode.HALF_UP);
    }

}
