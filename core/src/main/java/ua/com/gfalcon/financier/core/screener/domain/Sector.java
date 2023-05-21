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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Sector Entity.
 */
@Generated
@Getter
@Setter
@Entity(name = "Sector")
@Table(name = "sectors")
@NoArgsConstructor
public class Sector extends VersionedEntity implements Serializable {

    private static final long serialVersionUID = -2252684314906136081L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sectors_seq")
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "sector", nullable = false, unique = true, length = 25)
    private String name;

    @OneToMany(mappedBy = "sector", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Industry> industries;

    public Sector(String name) {
        this.name = name;
        this.industries = new HashSet<>();
    }

}
