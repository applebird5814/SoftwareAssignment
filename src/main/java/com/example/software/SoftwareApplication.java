package com.example.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// (exclude = SecurityAutoConfiguration.class)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareApplication.class, args);
    }
//test push
}
