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

package ua.com.gfalcon.financier.server;

import java.io.File;
import java.net.URL;

import org.hibernate.cfg.Configuration;

/**
 * Main class.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class Financier {

    /**
     * Main method.
     *
     * @param args arguments for start application
     */
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread()
                .getContextClassLoader();
        URL url = classLoader.getResource("hibernate.cfg.xml");
        assert url != null;
        File file = new File(url.getFile());
        Configuration configure = new Configuration();
        configure.configure(file);

        configure.getProperties();


    }

}
