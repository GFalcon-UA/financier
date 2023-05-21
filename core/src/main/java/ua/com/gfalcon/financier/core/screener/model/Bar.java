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

package ua.com.gfalcon.financier.core.screener.model;

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
