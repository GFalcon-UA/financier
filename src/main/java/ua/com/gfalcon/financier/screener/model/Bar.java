package ua.com.gfalcon.financier.screener.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record Bar(String ticker, LocalDateTime timestamp, BigDecimal open, BigDecimal low, BigDecimal high,
                  BigDecimal close, Long volume, Period period) {

    /**
     * Date of bar.
     *
     * @return local date.
     */
    public LocalDate date() {
        return timestamp().toLocalDate();
    }

    public BigDecimal range() {
        return high().subtract(low());
    }

}
