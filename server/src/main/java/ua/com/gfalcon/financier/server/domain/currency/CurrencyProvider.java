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

package ua.com.gfalcon.financier.server.domain.currency;

import org.javamoney.moneta.internal.JDKCurrencyProvider;

/**
 * Currency provider.
 *
 * @author Oleksii Khalikov
 * @see javax.money.spi.CurrencyProviderSpi
 * @since 1.0.0
 */
public class CurrencyProvider {

  public static final String DEFAULT = new JDKCurrencyProvider().getProviderName();

  private CurrencyProvider() {
  }

}
