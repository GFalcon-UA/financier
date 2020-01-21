/*
 *   Copyright 2016-2020 Oleksii V. KHALIKOV, PE
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

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class HibernateConfiguration {

  private Properties properties;
  private List<String> packagesToScan;

  public HibernateConfiguration() {
    this.properties = new Properties();
    this.packagesToScan = new LinkedList<>();
  }

  public List<String> getPackagesToScan() {
    return packagesToScan;
  }

  public Properties getProperties() {
    return properties;
  }

  public void addProperty(String key, Object value) {
    properties.put(key, value);
  }

  public void addPackage(String packageToScane) {
    packagesToScan.add(packageToScane);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

}
