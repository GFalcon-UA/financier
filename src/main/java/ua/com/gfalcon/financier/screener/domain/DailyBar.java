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

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DailyBar.
 */
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

    @Column(name = "value", nullable = false)
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
}