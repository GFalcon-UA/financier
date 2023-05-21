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

package ua.com.gfalcon.financier.core.providers.yahoo.query;

import lombok.Generated;

/**
 * Module value.
 */
@Generated
public enum YahooModule {
    /**
     * The assetProfile object contains general information about the company, such as industry, fullTimeEmployees, and
     * website and is useful for getting an overview of the company's assets.
     */
    ASSET_PROFILE("assetProfile"),

    /**
     * The defaultKeyStatistics object contains information about a company's stock. This is useful for getting an idea
     * of a company's stock.
     */
    DEFAULT_KEY_STATISTICS("defaultKeyStatistics"),

    /**
     * recommendationTrend object contains information about analyst recommendations. This is useful for getting an idea
     * of whether a stock is being bought or sold by analysts.
     */
    RECOMMENDATION_TREND("recommendationTrend"),

    /**
     * The upgradeDowngradeHistory object contains information about the upgrades and downgrades that analysts have
     * given a company's stock. This is useful for getting an idea of analyst opinion on a company's stock
     */
    UPGRADE_DOWNGRADE_HISTORY("upgradeDowngradeHistory"),

    /**
     * The insiderHolders object contains information about the insider holders of a company's stock. This is useful for
     * getting an idea of who owns a company's stock.
     */
    INSIDER_HOLDERS("insiderHolders"),

    /**
     * The sectorTrend object contains information about the direction of a stock market sector. This is useful for
     * getting an idea of the overall direction of a particular stock market sector.
     */
    SECTOR_TREND("sectorTrend"),

    /**
     * The netSharePurchaseActivity object contains information about the net share purchase activity of a company. This
     * is useful for getting an idea of the overall direction of a company's stock.
     */
    NET_SHARE_PURCHASE_ACTIVITY("netSharePurchaseActivity"),

    /**
     * The industryTrend object contains information about the direction of an industry. This is useful for getting an
     * idea of the overall direction of an industry.
     */
    INDUSTRY_TREND("industryTrend"),

    /**
     * The indexTrend object contains information about the direction of a stock market index. This is useful for
     * getting an idea of the overall direction of the market.
     */
    INDEX_TREND("indexTrend"),

    /**
     * The earningsTrend object contains information about a company's earnings trend. This is useful for getting an
     * idea of a company's current and future profitability.
     */
    EARNINGS_TREND("earningsTrend"),

    /**
     * The earningsHistory object contains information about a company's earnings history. This is useful for getting an
     * idea of a company's past profitability.
     */
    EARNINGS_HISTORY("earningsHistory"),

    /**
     * The earnings object contains information about a company's earnings. This is useful for getting an idea of a
     * company's profitability.
     */
    EARNINGS("earnings"),

    /**
     * The majorHoldersBreakdown object contains information about the top holders of a stock. This is useful for
     * getting an idea of who is buying or selling a stock.
     */
    MAJOR_HOLDERS_BREAKDOWN("majorHoldersBreakdown"),

    /**
     * The financialData object contains information about a company's financial situation. This is useful for getting
     * an idea of a company's financial situation.
     */
    FINANCIAL_DATA("financialData");


    private final String value;

    YahooModule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
