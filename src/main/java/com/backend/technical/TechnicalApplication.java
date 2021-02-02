package com.backend.technical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.backend.technical.*")
@ComponentScan({"com.backend.technical.controllers", "com.backend.technical.services"})
public class TechnicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechnicalApplication.class, args);
    }

}
