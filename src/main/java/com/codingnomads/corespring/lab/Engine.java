package com.codingnomads.corespring.lab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Engine {

    private String type;

    public Engine(String type) {
        this.type = type;
    }

    @PostConstruct
    public void init() {
        System.out.println("Engine bean initialized!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Engine bean destroyed!");
    }

    public String getType() {
        return type;
    }
}