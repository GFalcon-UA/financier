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
import lombok.experimental.SuperBuilder;

@Generated
@SuperBuilder
@Getter
public class ChartQueryParameters extends HistoryQueryParameters {

    /**
     * The range for which the data is returned.
     */
    private Range range;

    private Boolean dividendsEvents;

    private Boolean splitEvents;

    private Boolean includePrePost;

    private ChartQueryParameters() {
        super();
    }
}
