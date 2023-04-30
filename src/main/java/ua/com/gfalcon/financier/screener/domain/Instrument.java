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

import java.time.LocalDate;

import org.hibernate.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Instrument.
 */
@Getter
@Setter
@Entity(name = "Instrument")
@Table(name = "instruments")
@NoArgsConstructor
public class Instrument extends VersionedEntity {

    @Id
    @Column(name = "ticker", length = 20)
    private String ticker;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "currency_id", foreignKey = @ForeignKey(name = "instruments_currencies_id_fk"))
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "stock_exchange_id", foreignKey = @ForeignKey(name = "instruments_stock_exchanges_id_fk"))
    private StockExchange stockExchange;

    @ManyToOne
    @JoinColumn(name = "time_zone_id", foreignKey = @ForeignKey(name = "instruments_time_zones_id_fk"))
    private MarketTimeZone timeZone;

    @ManyToOne
    @JoinColumn(name = "industry_id", foreignKey = @ForeignKey(name = "instruments_industries_id_fk"))
    private Industry industry;

    @ManyToOne
    @JoinColumn(name = "geo_id", foreignKey = @ForeignKey(name = "instruments_geos_id_fk"))
    private Geo geo;

    @Column(name = "optionable")
    private boolean optionable;

    @Column(name = "shortable")
    private boolean shortable;

    @Column(name = "info", length = Length.LONG)
    private String info;

    @Column(name = "last_bar_date")
    private LocalDate lastBarDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "daily_history_provider")
    private DataProvider dailyHistoryProvider;

}
