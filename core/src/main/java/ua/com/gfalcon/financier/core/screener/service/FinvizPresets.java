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

package ua.com.gfalcon.financier.core.screener.service;

import java.util.List;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.NoArgsConstructor;
import ua.com.gfalcon.finviz.screener.filter.FilterParameter;
import ua.com.gfalcon.finviz.screener.filter.params.AverageTrueRange;
import ua.com.gfalcon.finviz.screener.filter.params.AverageVolume;
import ua.com.gfalcon.finviz.screener.filter.params.IPOdate;
import ua.com.gfalcon.finviz.screener.filter.params.Industry;
import ua.com.gfalcon.finviz.screener.filter.params.MarketCap;
import ua.com.gfalcon.finviz.screener.filter.params.Price;

/**
 * Finviz screener preset configurations.
 */
@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FinvizPresets {

    public static final List<FilterParameter> FOR_TRADING_FILTER = List.of(Industry.STOCK, AverageVolume.OVER_300_K,
            IPOdate.MORE_THAN_5_YEARS_AGO, Price.FROM_1_TO_20, AverageTrueRange.OVER_0_25, MarketCap.SMALL_PLUS);

}
