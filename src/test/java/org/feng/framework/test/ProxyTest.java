package org.feng.framework.test;

import org.feng.framework.aop.CGLibProxy;
import org.feng.framework.aop.Hello;
import org.feng.framework.aop.HelloImpl;

public class ProxyTest {
    public static void main(String[] args) {
//        HelloProxy helloProxy = new HelloProxy();
//        helloProxy.say("Jack");

//        Hello hello = new HelloImpl();
//        DynamicProxy dynamicProxy = new DynamicProxy(hello);
//        Hello helloProxy= (Hello) Proxy.newProxyInstance(
//        hello.getClass().getClassLoader(),
//        hello.getClass().getInterfaces(),
//        dynamicProxy);
//        helloProxy.say("Jack");

//        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
//        Hello helloProxy = dynamicProxy.getProxy();
//        helloProxy.say("Jack");

//        CGLibProxy cgLibProxy = new CGLibProxy();
//        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
//        helloProxy.say("Jack");

        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Jack");
    }
}
