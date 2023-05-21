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

package ua.com.gfalcon.financier.core.screener.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import ua.com.gfalcon.financier.core.screener.domain.DailyBar;
import ua.com.gfalcon.financier.core.screener.domain.DailyBarId;


/**
 * Daily bars DAO.
 */
@Repository
public interface DailyBarRepository extends ListCrudRepository<DailyBar, DailyBarId>,
        ListPagingAndSortingRepository<DailyBar, DailyBarId> {

    @Query("select d from DailyBar d where d.id.ticker.ticker = ?1 order by d.id.date DESC limit 1")
    Optional<DailyBar> findLatestBarByTicker(@NonNull String ticker);

}
