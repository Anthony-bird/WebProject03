package org.feng.framework.aop;

@Component
public class GreetingImpl implements Greeting {
    @Tag
    public void sayHello(String name) {
        System.out.println("Hello!" +name);

        throw new RuntimeException("Error"); //抛出增强
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning!" +name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night!" +name);
    }
}
