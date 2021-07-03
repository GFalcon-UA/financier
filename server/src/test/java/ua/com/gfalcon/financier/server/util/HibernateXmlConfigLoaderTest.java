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

package ua.com.gfalcon.financier.server.util;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLStreamException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests of {@link HibernateXmlConfigLoader}.
 */
public class HibernateXmlConfigLoaderTest {

    @Test
    public void parseTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        HibernateConfiguration configuration = null;

        try (InputStream inputStream = classLoader.getResourceAsStream("hibernate.cfg.xml")) {
            HibernateXmlConfigLoader loader = new HibernateXmlConfigLoader(inputStream);
            configuration = loader.parse();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(configuration);
        Assert.assertEquals(1, configuration.getPackagesToScan()
                .size());
        Assert.assertEquals(8, configuration.getProperties()
                .size());
        Assert.assertEquals("ua.com.gfalcon.financier.server.domain", configuration.getPackagesToScan()
                .get(0));
        Assert.assertEquals("20", configuration.getProperty("hibernate.jdbc.batch_size"));

        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.connection.provider_class"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.dialect"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.default_batch_fetch_size"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.jdbc.batch_size"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.show_sql"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.format_sql"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.use_sql_comments"));
        Assert.assertTrue(configuration.getProperties()
                .containsKey("hibernate.hbm2ddl.auto"));
    }

}
