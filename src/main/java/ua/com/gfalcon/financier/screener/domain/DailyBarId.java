/*
 * Copyright (c) 2016-2023 Oleksii Khalikov @GFalcon-UA (http://gfalcon.com.ua)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.com.gfalcon.financier.screener.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DailyBarId.
 */
@Getter
@Embeddable
@NoArgsConstructor
public class DailyBarId implements Serializable {

    private static final long serialVersionUID = 7687897637441545443L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticker", foreignKey = @ForeignKey(name = "fk_instrument_ticker"))
    private Instrument ticker;

    @Column(name = "date", nullable = false)
    @Setter
    private LocalDate date;

    @Transient
    @Setter
    private String symbol;

    /**
     * Create bar id.
     *
     * @param ticker instrument.
     * @param date local date.
     */
    public DailyBarId(Instrument ticker, LocalDate date) {
        this.ticker = ticker;
        this.date = date;
        setSymbol(ticker.getTicker());
    }

    /**
     * Set ticker.
     *
     * @param ticker instrument.     *
     * @return this object.
     */
    public DailyBarId setTicker(Instrument ticker) {
        this.ticker = ticker;
        setSymbol(this.ticker.getTicker());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DailyBarId that = (DailyBarId) o;
        return Objects.equals(getTicker(), that.getTicker()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicker(), getDate());
    }
}
