package com.github.theinfinity007.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /*

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

    @Before("execution(public * add*())")
    public void beforeAdviceOnMatchAnyReturnType(){
        System.out.println("\n===============>> Executing @Before advice for method with any return type and have name starting with add");
    }

    @Before("execution(* add*(com.github.theinfinity007.spring_aop.Account))")
    public void beforeAdviceOnMatchInParameter(){
        System.out.println("\n===============>> Executing @Before advice with match on account parameters on method starting with add");
    }


    @Before("execution(* add*(com.github.theinfinity007.spring_aop.Account, ..))")
    public void beforeAdviceOnMatchWithAccountAndMoreParameter(){
        System.out.println("\n===============>> Executing @Before advice with match account and more parameters on method starting with add");
    }

    @Before("execution(* com.github.theinfinity007.spring_aop..add*(..))")
    public void beforeAdviceOnMatchWithAnyNumberOfParameter(){
        System.out.println("\n===============>> Executing @Before advice with match on any no of parameters on method starting with add");
    }


    @Before("execution(* com.github.theinfinity007.spring_aop.dao.*.*(..))")
    public void beforeAdviceOnMatchWithPackageName(){
        System.out.println("\n===============>> Executing @Before advice with match on all methods inside the package dao");
    }
    */


    @Pointcut("execution(* com.github.theinfinity007.spring_aop.dao.*.*(..))")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAdviceOnMatchWithPackageNameUsingPointcutDeclaration(){
        System.out.println("\n===============>> Executing @Before advice with match on all methods inside the package dao using pointcut declaration");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n==========>> Executing @Before advince: Performing API Analytics");
    }

}
