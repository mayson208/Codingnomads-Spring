package com.codingnomads.corespring.lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoreLabApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();


        context.getEnvironment().setActiveProfiles("electric");

        context.register(CoreLabConfig.class);
        context.refresh();

        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);

        car1.drive();
        car2.drive();

        System.out.println("Are car1 and car2 the same? " + (car1 == car2));

        String message = (String) context.getBean("xmlMessageBean");
        System.out.println(message);

        context.close();
    }
}