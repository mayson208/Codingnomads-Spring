/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);

    @Pointcut("execution(* com.codingnomads.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    private void greetingMethod() {}

    @Before("greetingMethod()")
    public void beforeGreeting(JoinPoint joinPoint) {
        LOGGER.info("Before advice: " + joinPoint.getSignature().getName());
    }

    @After("greetingMethod()")
    public void afterGreeting(JoinPoint joinPoint) {
        LOGGER.info("After advice: " + joinPoint.getSignature().getName());
    }
}
