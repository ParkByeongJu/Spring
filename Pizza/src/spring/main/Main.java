package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.pizza.Pizza;
import spring.pizzaStore.NyPizzaStore;
import spring.pizzaStore.PizzaStore;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/main/setting.xml");
		
		PizzaStore pizzaStore = (PizzaStore) context.getBean("pizzaStore");
        String pizzaType = (String) context.getBean("pizzaType");
        Pizza pizza = pizzaStore.orderPizza(pizzaType);


		
	}

}
