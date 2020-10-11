package org.feng.framework.aop;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    public void before( Method method, Object[] args, Object target) throws Throwable{
        System.out.println("Before");
    }
}
