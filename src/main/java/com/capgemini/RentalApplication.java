package com.capgemini;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalApplication {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active", "mysql");
        SpringApplication.run(RentalApplication.class, args);
    }
}
