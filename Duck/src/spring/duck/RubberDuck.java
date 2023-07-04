package spring.duck;

import spring.duck.Quack.Squeak;
import spring.duck.fly.FlyNoWay;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void displayName() {
        System.out.print("RubberDuck : ");
    }
}
