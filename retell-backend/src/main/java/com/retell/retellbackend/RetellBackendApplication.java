package com.retell.retellbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RetellBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetellBackendApplication.class, args);
    }

}
