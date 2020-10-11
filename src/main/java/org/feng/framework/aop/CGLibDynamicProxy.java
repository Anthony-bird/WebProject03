package org.feng.framework.aop;

import java.lang.reflect.Method;
/*
* CGLib动态代理
* */
public class CGLibDynamicProxy implements MethodInterceptor {
    private static CGLibDynamicProxy instance = new CGLibDynamicProxy();

    public CGLibDynamicProxy() {
    }

    public static CGLibDynamicProxy getInstance(){
        return instance;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls,this);
    }
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable{
        before();
        Object result= proxy.invokeSuper(target,args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
