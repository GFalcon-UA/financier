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

package ua.com.gfalcon.financier.rest.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * MDC data filter.
 *
 * @author Oleksii Khalikov
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MdcFilter extends MDCInsertingServletFilter {

    public static final String REQUEST_REQUEST_ID = "req.id";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put(REQUEST_REQUEST_ID, createRequestId());
            super.doFilter(request, response, chain);
        } finally {
            MDC.clear();
        }
    }

    private String createRequestId() {
        return UUID.randomUUID()
                .toString();
    }
}
