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

import java.util.Objects;

/**
 * Utility class for working with {@link String}.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class StringUtils {

  public static boolean isNotBlank(String str) {
    return !isNullOrEmpty(str);
  }

  public static boolean isNullOrEmpty(String str) {
    return Objects.isNull(str) || str.isEmpty();
  }

}
