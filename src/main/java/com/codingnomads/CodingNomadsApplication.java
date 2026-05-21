package com.codingnomads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.codingnomads.springdata.lab"
})
public class CodingNomadsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingNomadsApplication.class, args);
    }
}