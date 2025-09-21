package com.github.theinfinity007.spring_aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

// @Aspect -> @Aspect is option if the class only contain the pointcut declarations
public class AopExpressions {
    @Pointcut("execution(* com.github.theinfinity007.spring_aop.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // declaration for getter methods
    @Pointcut("execution(* com.github.theinfinity007.spring_aop.dao.*.get*(..))")
    public void getter() {
    }

    // declaration for setter methods
    @Pointcut("execution(* com.github.theinfinity007.spring_aop.dao.*.set*(..))")
    public void setter() {
    }

    // declaration: include package.. exclude getter/setter
    @Pointcut("forDaoPackage() && (!(getter() || setter()))")
    public void forDaoPackageExcludingGetterAndSetter() {
    }
}
