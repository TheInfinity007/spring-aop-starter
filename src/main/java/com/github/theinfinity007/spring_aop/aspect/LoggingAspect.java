package com.github.theinfinity007.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Run this code BEFORE - target object method: "public void addAcount()"
    @Before("execution(public void addAccount())")   // Pointcut expression
    public void beforeAddAccountAdvice(){
        System.out.println("\n==============>> Executing @Before advice on addAccount");
    }
}
