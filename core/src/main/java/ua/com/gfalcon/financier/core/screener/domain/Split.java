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
import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Split Entity.
 */
@Generated
@Getter
@Setter
@Entity(name = "Split")
@Table(name = "splits")
@NoArgsConstructor
public class Split extends VersionedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "splits_seq")
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ticker", foreignKey = @ForeignKey(name = "SPLITS_instruments_ticker_fk"))
    private Instrument ticker;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "numerator")
    private BigDecimal numerator;

    @Column(name = "denominator")
    private BigDecimal denominator;


}


