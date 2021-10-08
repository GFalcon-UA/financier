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

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Tests of {@link LocalDateTimeConverter}.
 *
 * @author Oleksii Khalikov
 */
public class LocalDateTimeConverterTest {

    private final LocalDateTimeConverter self = new LocalDateTimeConverter();

    @Test
    public void convertToDatabaseColumn() {
        assertNotNull(self.convertToDatabaseColumn(LocalDateTime.now()));
    }

    @Test
    public void convertToDatabaseColumnWithNull() {
        assertNull(self.convertToDatabaseColumn(null));
    }

    @Test
    public void convertToEntityAttribute() {
        assertNull(self.convertToEntityAttribute(new Timestamp(LocalDateTime.now()
                .toEpochSecond(ZoneOffset.UTC))));
    }

    @Test
    public void convertToEntityAttributeWithNull() {
        assertNull(self.convertToEntityAttribute(null));
    }
}