package com.github.theinfinity007.spring_aop.aspect;

import com.github.theinfinity007.spring_aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SignaturePattern;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
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




    /*
    @Before("forDaoPackage()")
    public void beforeAdviceOnMatchWithPackageNameUsingPointcutDeclaration(){
        System.out.println("\n===============>> Executing @Before advice with match on all methods inside the package dao using pointcut declaration");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n==========>> Executing @Before advince: Performing API Analytics");
    }

     */

    @Before("com.github.theinfinity007.spring_aop.aspect.AopExpressions.forDaoPackageExcludingGetterAndSetter()")
    public void beforeAdviceOnMatchWithPackageNameExcludingGetterAndSetter(JoinPoint joinPoint){
        System.out.println("\n===============>> Executing @Before advice with match on all methods inside the package dao excluding getter and setter");
        
        // display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSig = " + methodSig);
        
        // display the method args
        System.out.println("Printing args");
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            if(arg instanceof Account){
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            } else {
                System.out.println(arg);
            }
        }
    }

    // @AfterReturning advice
    @AfterReturning(
            pointcut = "execution(* com.github.theinfinity007.spring_aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterReturning on method = " + methodName);

        System.out.println("\n==========> Original Result is = " + result);

        // Modify the response or post-process the data.
        convertAccountNameToUpperCase(result);
        System.out.println("\n==========> Modified Result is = " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        result.forEach((item) -> item.setName(item.getName().toUpperCase()));
    }

    // AfterThrowing Advice
    @AfterThrowing(
            pointcut = "execution(* com.github.theinfinity007.spring_aop.dao.AccountDAO.findAccounts(..))",
            throwing = "ex"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @AfterThrowing on method = " + methodName);

        System.out.println("\n==========> The exception is: " + ex);
    }

    @After("execution (* com.github.theinfinity007.spring_aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n==========> Executing @After (finally) on method = " + methodName);
    }

}
