package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.ui.HelloWorld;

public class ProgramHello {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		HelloWorld la = context.getBean(HelloWorld.class);
		
		la.sayHello();
		
	}
}
