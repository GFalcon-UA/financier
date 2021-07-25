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

package ua.com.gfalcon.financier.backend.config;

import static java.util.Objects.nonNull;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * MVC context configuration.
 *
 * @author Oleksii Khalikov.
 */
@Configuration
public class MvcConfig {

    @Value("${rest.api.base.path}")
    private String restApiBasePath;
    @Value("${cors.allowed.origins}")
    private String[] corsAllowedOrigins;

    /**
     * CORS configuration.
     *
     * @return {@link WebMvcConfigurer}
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins(corsAllowedOrigins);
            }
        };
    }

    /**
     * Request mapping handler configuration.
     *
     * @return {@link WebMvcRegistrations}
     */
    @Bean
    public WebMvcRegistrations webMvcRegistrationsHandlerMapping() {
        final MvcConfig config = this;
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {
                    @Override
                    protected void registerHandlerMethod(Object handler, Method method, RequestMappingInfo mapping) {
                        Class<?> beanType = method.getDeclaringClass();
                        RestController restApiController = beanType.getAnnotation(RestController.class);
                        if (restApiController != null) {
                            RequestMappingInfo.Builder builder = RequestMappingInfo.paths(config.restApiBasePath)
                                    .methods(mapping.getMethodsCondition()
                                            .getMethods()
                                            .toArray(new RequestMethod[0]))
                                    .customCondition(mapping.getParamsCondition())
                                    .customCondition(mapping.getHeadersCondition())
                                    .customCondition(mapping.getConsumesCondition())
                                    .customCondition(mapping.getProducesCondition());
                            if (nonNull(mapping.getName())) {
                                builder.mappingName(mapping.getName());
                            }
                            if (nonNull(mapping.getCustomCondition())) {
                                builder.customCondition(mapping.getCustomCondition());
                            }
                            mapping = builder.build();
                        }
                        super.registerHandlerMethod(handler, method, mapping);
                    }
                };
            }
        };
    }
}
