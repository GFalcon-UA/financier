/*
 *   Copyright 2016-2021 Oleksii V. KHALIKOV, PE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.financier.data.converters;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests of {@link LocalDateConverter}.
 */
public class LocalDateConverterTest {

    private final LocalDateConverter self = new LocalDateConverter();

    @Test
    public void convertToDatabaseColumn() {
        Assert.assertNotNull(self.convertToDatabaseColumn(LocalDate.now()));
    }

    @Test
    public void convertToDatabaseColumnFromNull() {
        Assert.assertNull(self.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute() {
        LocalDate date = LocalDate.now();
        Assert.assertNotNull(self.convertToEntityAttribute(new Date(date.toEpochDay())));
    }

    @Test
    public void convertToEntityAttributeFromNull() {
        Assert.assertNull(self.convertToEntityAttribute(null));
    }
}