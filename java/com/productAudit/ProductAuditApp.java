package com.productAudit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductAuditApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductAuditApp.class, args);
    }
}
