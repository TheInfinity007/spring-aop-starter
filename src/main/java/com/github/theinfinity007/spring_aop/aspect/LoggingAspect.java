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
        System.out.println("\n==============>> Executing @Before advice on all addAccount");
    }

    @Before("execution(public void com.github.theinfinity007.spring_aop.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdviceOnASpecificClass(){
        System.out.println("\n===============>> Executing @Before advice for AccountDAO addAccount method");
    }

    @Before("execution(public void add*())")
    public void beforeAdviceOnAnyMethodStartingWithAdd(){
        System.out.println("\n===============>> Executing @Before advice for method starting with add");
    }


}
