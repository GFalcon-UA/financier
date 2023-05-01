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

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.NaturalId;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Currency domain.
 */
@Getter
@Setter
@Entity(name = "Currency")
@Table(name = "currencies")
@NoArgsConstructor
public class Currency extends VersionedEntity implements Serializable {

    private static final long serialVersionUID = -7728402826351931245L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currencies_seq")
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @NaturalId
    @Column(name = "code", nullable = false, length = 3, unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String code;

    public Currency(String code) {
        this.code = code;
    }

}
