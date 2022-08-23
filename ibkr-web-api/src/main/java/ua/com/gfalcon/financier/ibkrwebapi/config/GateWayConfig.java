/*
 *   Copyright 2016-2022 Oleksii V. KHALIKOV
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

package ua.com.gfalcon.financier.ibkrwebapi.config;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import lombok.extern.slf4j.Slf4j;

/**
 * Loader of IBKR gateway configuration file.
 */
@Component
@Slf4j
public class GateWayConfig {

    public static final String CLIENTPORTAL_CONF_YAML_PATH = "clientportal/root/conf.yaml";

    private final String API_URL;
    private final String LOGIN_URL;

    private final String SSL_CERT;
    private final String SSL_PWD;

    private final String username = "oleksi053";
    private final String password = "gfalcon273";

    public GateWayConfig() {
        Yaml conf = new Yaml();
        Map<String, Object> properties = new LinkedHashMap<>();
        try (InputStream stream = GateWayConfig.class.getClassLoader()
                .getResourceAsStream(CLIENTPORTAL_CONF_YAML_PATH)) {
            properties.putAll(conf.load(stream));
        } catch (Exception e) {
            log.error("Cann`t read IBKR configuration file", e);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("http");

        boolean ssl = (Boolean) properties.getOrDefault("listenSsl", true);
        if (ssl) {
            sb.append("s");
        }
        sb.append("://localhost:");

        int port = (Integer) properties.getOrDefault("listenPort", 5000);
        sb.append(port);
        LOGIN_URL = sb.toString();
        sb.append("/");

        String svcEnvironment = (String) properties.getOrDefault("svcEnvironment", "");
        if (!svcEnvironment.isEmpty()) {
            sb.append(svcEnvironment);
            sb.append("/");
        }
        sb.append("api/");
        API_URL = sb.toString();
        SSL_CERT = (String) properties.getOrDefault("sslCert", "");
        SSL_PWD = (String) properties.getOrDefault("sslPwd", "");
        log.info(API_URL);
    }

    public String getApiUrl() {
        return API_URL;
    }

    public String getLoginUrl() {
        return LOGIN_URL;
    }

    public String getCertificateFilename() {
        return SSL_CERT;
    }

    public String getCertificatePassword() {
        return SSL_PWD;
    }
}
