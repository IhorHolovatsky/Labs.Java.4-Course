package com.shipping;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShippingServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ShippingServiceApp.class, args);
    }
}
