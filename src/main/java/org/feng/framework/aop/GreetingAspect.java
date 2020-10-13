package org.feng.framework.aop;
@Aspect
@Component
public class GreetingAspect {

    @DeclareParents(value ="aop.GreetingImpl",defaultImpl = ApologyImpl.class)
    private Apology apology;
    @Around("@annotation(aop.demo.Tag")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        before();
        Object result= pjp.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
