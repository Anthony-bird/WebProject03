package org.feng.framework.aop;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object result, Method method,Object[] args) throws Throwable{
        System.out.println("After");
    }
}
