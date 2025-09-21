package com.github.theinfinity007.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.github.theinfinity007.spring_aop.aspect.AopExpressions.forDaoPackageExcludingGetterAndSetter()")
    public void performApiAnalyticsExcludingGetterAndSetter(){
        System.out.println("\n==========>> Executing @Before advince: Performing API Analytics");
    }

}
