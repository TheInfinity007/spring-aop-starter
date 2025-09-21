package com.github.theinfinity007.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    @Before("com.github.theinfinity007.spring_aop.aspect.AopExpressions.forDaoPackageExcludingGetterAndSetter()")
    public void logToCloudAsync(){
        System.out.println("\n==========>> Executing @Before advince: Logging to cloud in async fashion");
    }

}
