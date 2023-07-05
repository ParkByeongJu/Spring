package spring.pizzaStore;

import spring.pizza.Pizza;
import spring.pizza.ChicagoStyleCheesePizza;
import spring.pizza.ChicagoStyleClamPizza;
import spring.pizza.ChicagoStylePepperoniPizza;
import spring.pizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("치즈")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("페퍼로니")) {
            return new ChicagoStylePepperoniPizza();
        } else if (type.equals("조개")){
            return new ChicagoStyleClamPizza();
        } else if (type.equals("야채")) {
            return new ChicagoStyleVeggiePizza();
        } else {
            return null;
        }
    }

}
