package ua.com.gfalcon.financier.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Configuration service.
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigurationService {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationService.class, args);
    }
}
