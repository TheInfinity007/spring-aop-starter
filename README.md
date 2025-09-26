# Spring AOP Starter


## AOP Terminology

* Pointcut: a predicate expression for where advice should be applied


### Pointcut Expression Language
* Spring AOP uses AspectJ's pointcut expression language
* One of the example is `execution` pointcuts
  * Applies to execution of a given method


Examples
=> Match on Method Name

```
execution(modifiers-pattern? return-type-pattern declaring-type-pattern?
    method-name-pattern(param pattern) throws-pattern?)
```   
modifiers -> public, protected and (default/none:package:visible)
return type -> void, boolean, String, List<Customer>,...
Declaring type -> class name
method name -> Name of the method
Param -> Parameter types to match
Throw -> Exception types to match

Note: The pattern is optional if it has `?`

## Pointcut Expression Examples
Match on method names
* Match only addAccount() method in AccountDAO class
`
@Before("execution(public void com.github.theinfinity007.spring_aop.dao.AccoountDAO.addAccount())")
`

* Match any addAccount() method in any class
`@Before("execution(public void addAccount())")`

* Match methods starting with add in any class
`@Before("execution(pubic void add*())")`

* Use wildcard on return type
`@Before("execution(public * add*())")`

* Match without the modifier as it is optional
`@Before("execution(* add*())")`

## Parameter Pattern Wildcards
For param-pattern
* () - matches a method with no arguments
* (*) - matches a method with one argument of any type
* (..) - matches a method with 0 or more arguments of any type

Examples
* Match addAccount method with no argument
`@Before("execution(* addAccount())"
* Match addAccount methods that have Account param
  `@Before("execution(* addAccount(com.github.theinfinity007.spring_aop.Account))")`

* Match addAccount method with any number of arguemnts
  `@Before("execution(* addAccount(..))")`

### Match on package
* Match any method in DAO Package: com.github.theinfinity007.spring_aop.dao with any return type and any number of arguments
`@Before("executing(* com.github.theinfinity007.spring_aop.dao.*.*(..))")`


## Pointcut Declaration

Example
```
@Pointcut("execution(* com.github.theinfinity007.spring_aop.dao.*.*(..)))")
private void forDaoPackage(){}


@Before("forDaoPackage()")
public void beforeAddAccountAdvice(){
  ...
}

@Before("forDaoPackage()")
public void performApiAnalyticsAdvice(){
  ...
}
```

### Benefits of Pointcut Declarations
* Easily reuse pointcut expressions
* Update pointcut in on location
* Can also share and combine pointcut expressions

## Combining Pointcut Expressions
Combining pointcut expressions using logic operators
* AND (&&)
* OR (||)
* NOT (!)


* Works like an if statement
* Execution happens if only if it evaluates to true

`@Before("expressionOne() && exressionTwo()")`


## JoinPoints: 
* Access the method Signature
* Access the method arguments
```
@Before("...)
public void beforeAddAccountAdvice(JoinPoint joinPoint){
  MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
  System.out.println("Method: " + methodSig);
  
  // arguments
  Object[] args = joinPoint.getArgs();
  // loop through args
  for(Object arg: args){
    System.out.println(arg);
   }
}
```

# AfterReturning Advice

This Advice will run after the method call (success execution)

```
@AfterReturning("execution(public void com.github.theinfinity007.spring_aop.dao.AccoountDAO.findAccounts())")
public void afterReturningFindAccountsAdvice(){
System.out.println("Executing @AfterReturning advice");
}
```

Supports accessing the return value
```
@AfterReturning(
  pointcut = "execution(public void com.github.theinfinity007.spring_aop.dao.AccoountDAO.findAccounts())"
  returning = "result"
)
public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
  System.out.println("Executing @AfterReturning advice");
  
  System.out.println("Printing return value", result);
  
}
```

