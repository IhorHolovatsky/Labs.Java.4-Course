package com.supplyProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SupplyProductApp {
    public static void main(String[] args) {
        SpringApplication.run(SupplyProductApp.class, args);
    }
}

