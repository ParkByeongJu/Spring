package spring.pizzaStore;

import spring.pizza.Pizza;
import spring.pizza.NyStyleCheesePizza;
import spring.pizza.NyStyleClamPizza;
import spring.pizza.NyStylePepperoniPizza;
import spring.pizza.NyStyleVeggiePizza;

public class NyPizzaStore extends PizzaStore {

	@Override
	 protected Pizza createPizza(String type) {
        if (type.equals("치즈")) {
            return new NyStyleCheesePizza();
        } else if (type.equals("페퍼로니")) {
            return new NyStylePepperoniPizza();
        } else if (type.equals("조개")){
        	return new NyStyleClamPizza();
        } else if (type.equals("야채")) {
        	return new NyStyleVeggiePizza();
        }else {
            return null;
        }
    }

}
