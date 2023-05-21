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

package ua.com.gfalcon.financier.core.exceptions;

import lombok.Generated;

/**
 * Exception with HTTP code 401.
 */
@Generated
public class Http401YahooFinanceException extends YahooFinanceException {

    private static final long serialVersionUID = -827640601148802987L;

    public Http401YahooFinanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
