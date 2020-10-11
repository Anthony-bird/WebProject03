package org.feng.framework.aop;

public class HelloImpl implements Hello {
    public void say(String name) {
        System.out.println("Hello!" +name);
    }
}
