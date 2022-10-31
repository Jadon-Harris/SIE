package com.uta.sie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jadon
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class SieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SieApplication.class, args);
    }

}
