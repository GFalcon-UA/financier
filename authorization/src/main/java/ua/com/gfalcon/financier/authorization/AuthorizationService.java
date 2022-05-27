package ua.com.gfalcon.financier.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@RefreshScope
@EnableEurekaClient
@EnableAuthorizationServer
@EnableResourceServer
public class AuthorizationService {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationService.class, args);
    }

}
