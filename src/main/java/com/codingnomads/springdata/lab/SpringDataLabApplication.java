package com.codingnomads.springdata.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.codingnomads.springdata.lab.repositories")
@EntityScan(basePackages = "com.codingnomads.springdata.lab.models")
public class SpringDataLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLabApplication.class, args);
    }
}