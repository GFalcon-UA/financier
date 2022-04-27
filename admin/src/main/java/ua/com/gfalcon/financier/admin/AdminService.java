package ua.com.gfalcon.financier.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminService {

    public static void main(String[] args) {
        SpringApplication.run(AdminService.class, args);
    }

}
