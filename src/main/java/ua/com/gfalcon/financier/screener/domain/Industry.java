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
 * Industry.
 */
@Generated
@Getter
@Setter
@Entity(name = "Industry")
@Table(name = "industries")
@NoArgsConstructor
public class Industry extends VersionedEntity implements Serializable {

    private static final long serialVersionUID = -7295296563020875587L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "industries_seq")
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "industry", nullable = false, unique = true, length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sector_id", foreignKey = @ForeignKey(name = "INDUSTRIES_sectors_id_fk"))
    private Sector sector;

    /**
     * Constructor.
     *
     * @param industry name of industry
     * @param sector sector object
     */
    public Industry(String industry, Sector sector) {
        this.name = industry;
        this.sector = sector;
        if (sector.getIndustries() != null) {
            sector.getIndustries().add(this);
        }
    }

}
