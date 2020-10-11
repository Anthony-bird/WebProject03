package org.feng.framework.aop;

import java.lang.reflect.Method;

public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice,AfterReturningAdvice {

    public void before( Method method, Object[] args, Object target) throws Throwable{
        System.out.println("Before");
    }
    public void afterReturning(Object result, Method method, Object[] args,Object target) throws Throwable{
        System.out.println("After");
    }
}
