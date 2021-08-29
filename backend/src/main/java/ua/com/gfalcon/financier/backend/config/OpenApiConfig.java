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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuration of OpenAPI v3.
 *
 * @author Oleksii Khalikov.
 */
@Configuration
public class OpenApiConfig {

    @Value("${project.version}")
    private String version;

    private Contact getContact() {
        return new Contact().name("Oleksii V. KHALIKOV")
                .email("oleksii.khalikov@gmail.com")
                .url("https://gfalcon.com.ua");
    }

    private License getLicense() {
        return new License().name("Apache License, Version 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");
    }

    /**
     * Declare OpenAPI bean.
     *
     * @return OpenAPI bean
     */
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().components(new Components())
                .info(new Info().title("Financier Application API")
                        .description(
                                "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3.")
                        .version(version)
                        .contact(getContact())
                        .license(getLicense()));
    }

}
