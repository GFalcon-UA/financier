package ua.com.gfalcon.financier.screener.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Generated;

@Builder
@Generated
public record Bar(String ticker, LocalDateTime timestamp, BigDecimal open, BigDecimal low, BigDecimal high,
                  BigDecimal close, Long volume, Period period) implements Comparable<Bar> {

    @Override
    public int compareTo(@NotNull Bar o) {
        return this.timestamp().compareTo(o.timestamp());
    }

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
