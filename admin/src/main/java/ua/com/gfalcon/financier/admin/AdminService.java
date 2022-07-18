package ua.com.gfalcon.financier.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * Admin service.
 */
@SpringBootApplication
@EnableAdminServer
public class AdminService {

    public static void main(String[] args) {
        SpringApplication.run(AdminService.class, args);
    }

}
