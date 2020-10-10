package org.feng.framework.test;

import org.feng.framework.HelloProxy;

public class ProxyTest {
    public static void main(String[] args) {
        HelloProxy helloProxy = new HelloProxy();
        helloProxy.say("Jack");
    }
}
