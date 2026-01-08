package com.product.renting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ProductRentingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductRentingApplication.class, args);
    }

}
