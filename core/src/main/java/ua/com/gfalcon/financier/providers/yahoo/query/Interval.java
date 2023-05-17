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

package ua.com.gfalcon.financier.providers.yahoo.query;

import lombok.Generated;
import lombok.Getter;

/**
 * The time interval between two data points.
 */
@Generated
public enum Interval {
    M1("1m"), M2("2m"), M5("5m"), M15("15m"), M30("30m"), M60("60m"), M90("90m"), H1("1h"), D("1d"), D5("5d"), W("1wk"),
    MO_1("1mo"), MON_3("3mo");

    @Getter
    private String value;

    Interval(String s) {
        this.value = s;
    }
}
