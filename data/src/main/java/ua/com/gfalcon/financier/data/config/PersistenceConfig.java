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

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;
import javax.xml.stream.XMLStreamException;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import ua.com.gfalcon.financier.data.util.HibernateConfiguration;
import ua.com.gfalcon.financier.data.util.HibernateXmlConfigLoader;

/**
 * Persistence Configuration.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        return null;
    }

    /**
     * Hibernate configuration bean.
     *
     * @return {@link HibernateConfiguration}
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public HibernateConfiguration hibernateConfiguration() {
        ClassLoader classLoader = getClass().getClassLoader();
        HibernateXmlConfigLoader loader = null;
        try (InputStream stream = classLoader.getResourceAsStream("hibernate.cfg.xml")) {
            loader = new HibernateXmlConfigLoader(stream);
            return loader.parse();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
            return new HibernateConfiguration();
        }
    }

    /**
     * JPA Configurations bean.
     *
     * @param hibernateConfiguration hibernate configurations
     * @return JPA {@link Properties}
     */
    @Bean
    public Properties jpaProperties(HibernateConfiguration hibernateConfiguration) {
        Properties jpa = hibernateConfiguration.getProperties();
        jpa.setProperty("hibernate.id.new_generator_mappings", "true");
        jpa.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return jpa;
    }

    /**
     * Session factory bean.
     *
     * @param dataSource    data source
     * @param configuration hibernate configurations
     * @return {@link LocalSessionFactoryBean}
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource, HibernateConfiguration configuration) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setHibernateProperties(configuration.getProperties());
        return bean;
    }

}
