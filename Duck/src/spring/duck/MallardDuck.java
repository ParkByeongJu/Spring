package spring.duck;

import spring.duck.Quack.Quack;
import spring.duck.fly.FlyWithWings;

public class MallardDuck extends Duck {
    
	public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void displayName() {
        System.out.print("MallardDuck : ");
        
    }
}