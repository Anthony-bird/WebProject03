package org.feng.framework.aop;

public class ApologyImpl implements Apology {
    public void saySorry(String name) {
        System.out.println("Sorry!" + name);
    }
}
