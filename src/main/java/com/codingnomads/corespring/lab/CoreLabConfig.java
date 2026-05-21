package com.codingnomads.corespring.lab;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:corelab-beans.xml")
public class CoreLabConfig {

    @Bean
    @Scope("singleton")
    public Engine engine() {
        return new Engine("V8");
    }

    @Bean
    @Scope("prototype")
    public Car car(Engine engine) {
        return new Car(engine);
    }

    @Bean
    @Profile("electric")
    public Engine electricEngine() {
        return new Engine("Electric");
    }
}