package org.feng.framework.aop;


public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        return super.invoke(invocation);
    }
    public void saySorry(String name) {
        System.out.println("Sorry!"+name);
    }
}
