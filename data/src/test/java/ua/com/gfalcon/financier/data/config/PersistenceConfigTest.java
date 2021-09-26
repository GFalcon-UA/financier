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

package ua.com.gfalcon.financier.data.config;


import java.util.Properties;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import ua.com.gfalcon.financier.data.util.HibernateConfiguration;


/**
 * Test cases of {@link PersistenceConfig}.
 *
 * @author Oleksii Khalikov
 */
public class PersistenceConfigTest {

    private final PersistenceConfig self = new PersistenceConfig();

    private final HibernateConfiguration hibernateConfigMock = Mockito.mock(HibernateConfiguration.class);

    @Test
    @Ignore("not implemented yet")
    public void dataSource() {
        assertNotNull(self.dataSource());
    }

    @Test
    public void hibernateConfiguration() {
        assertNotNull(self.hibernateConfiguration());
    }

    @Test
    public void jpaProperties() {
        assertNotNull(self.jpaProperties(hibernateConfigMock));
    }

    @Test
    public void sessionFactory() {
        DataSource ds = Mockito.mock(DataSource.class);
        assertNotNull(self.sessionFactory(ds, hibernateConfigMock));
    }

    @Before
    public void setUp() throws Exception {
        Mockito.when(hibernateConfigMock.getProperties())
                .thenReturn(new Properties());
    }

}