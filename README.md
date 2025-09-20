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