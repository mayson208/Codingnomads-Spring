package com.codingnomads.corespring.lab;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("Driving with a " + engine.getType() + " engine!");
    }
}