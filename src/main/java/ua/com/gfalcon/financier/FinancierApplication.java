package ua.com.gfalcon.financier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Financier application.
 */
@SpringBootApplication
@EnableScheduling
public class FinancierApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancierApplication.class, args);
    }

}
