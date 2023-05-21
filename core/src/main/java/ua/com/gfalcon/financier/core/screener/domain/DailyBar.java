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

package ua.com.gfalcon.financier.core.screener.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DailyBar.
 */
@Generated
@Getter
@Setter
@Entity(name = "DailyBar")
@Table(name = "daily_bars")
@NoArgsConstructor
public class DailyBar implements Comparable<DailyBar> {

    @EmbeddedId
    private DailyBarId id;

    @Column(name = "open", nullable = false)
    private BigDecimal open;

    @Column(name = "low", nullable = false)
    private BigDecimal low;

    @Column(name = "high", nullable = false)
    private BigDecimal high;

    @Column(name = "close", nullable = false)
    private BigDecimal close;

    @Column(name = "volume", nullable = false)
    private Long value;


    @Override
    public int compareTo(DailyBar o) {
        DailyBarId barId = getId();
        if (barId == null || barId.getDate() == null || o == null || o.getId() == null || o.getId()
                .getDate() == null) {
            return 0;
        }
        return barId.getDate()
                .compareTo(o.getId()
                        .getDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DailyBar dailyBar = (DailyBar) o;

        if (!getId().equals(dailyBar.getId())) {
            return false;
        }
        if (!getOpen().equals(dailyBar.getOpen())) {
            return false;
        }
        if (!getLow().equals(dailyBar.getLow())) {
            return false;
        }
        if (!getHigh().equals(dailyBar.getHigh())) {
            return false;
        }
        if (!getClose().equals(dailyBar.getClose())) {
            return false;
        }
        return getValue().equals(dailyBar.getValue());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getOpen().hashCode();
        result = 31 * result + getLow().hashCode();
        result = 31 * result + getHigh().hashCode();
        result = 31 * result + getClose().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

}
