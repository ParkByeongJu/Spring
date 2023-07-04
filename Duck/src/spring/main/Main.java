package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.duck.Duck;

public class Main {
    

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/main/setting.xml");
        Duck duck = (Duck) context.getBean("duck");
        duck.displayName();
        duck.performFly();
        duck.performQuack();
    }

}