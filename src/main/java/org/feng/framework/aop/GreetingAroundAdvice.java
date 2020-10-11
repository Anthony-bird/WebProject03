package org.feng.framework.aop;

@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation ) throws Throwable {
        before();
        Object result = invocation.proceed();
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
