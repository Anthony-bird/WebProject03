package org.feng.framework.aop;

import org.feng.framework.aop.CGLibDynamicProxy;
import org.feng.framework.aop.Greeting;
import org.feng.framework.aop.GreetingImpl;

public class Client {
    public static void main(String[] args) {
//        Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
//        greetingProxy.sayHello("Jack");

//        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
//        greeting.sayHello("Jack");

//        Greeting greeting = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
//        greeting.sayHello("Jack");

//        ProxyFactory proxyFactory = new ProxyFactory(); //创建代理工程
//        proxyFactory.setTarget(new GreetingImpl());        //射入目标类对象
//        proxyFactory.addAdvice(new GreetingBeforeAdvice()); //添加前置增强
//        proxyFactory.addAdvice(new GreetingAfterAdvice());  //添加后置增强
//
//        Greeting greeting = (Greeting) proxyFactory.getProxy(); //从代理工厂中获取代理
//        greeting.sayHello("Jack");  //调用代理的方法

//        ProxyFactory proxyFactory = new ProxyFactory(); //创建代理工程
//        proxyFactory.setTarget(new GreetingImpl());        //射入目标类对象
//        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
//        proxyFactory.addAdvice(new GreetingAroundAdvice()); //添加环绕增强
//        Greeting greeting = (Greeting) proxyFactory.getProxy(); //从代理工厂中获取代理
//        greeting.sayHello("Jack");  //调用代理的方法

        ApplicationContext context = new ClassPathXmlApplicationContext("main/resources/spring-aop.xml");//获取Spring Context
//        Greeting greeting = (Greeting) context.getBean("greetingProxy");  //从Context中根据id获取Bean对象(其实就是一个代理)
//        greeting.sayHello("Jack"); //调用代理的方法
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy"); //注意:转型为目标类，而并非他的Greeting接口
        greetingImpl.sayHello("Jack");

        Apology apology = (Apology) greetingImpl;//将目标类强制向上转型为Apology接口(这是引入增强给我们带来的特性,也就是"接口动态实现"功能)
        apology.saySorry("Jack");

        ApplicationContext context2 = new ClassPathXmlApplicationContext("main/resources/spring-aop.xml");//获取Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingImpl");
        greeting.sayHello("Jack");

        Apology apology2 = (Apology) greetingImpl;//将目标类强制向上转型为Apology接口
        apology2.saySorry("Jack");
    }
}
