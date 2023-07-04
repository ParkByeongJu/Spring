package spring.duck;

import spring.duck.Quack.MuteQuack;
import spring.duck.fly.FlyWithWings;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void displayName() {
        System.out.print("DecoyDuck : ");
    }
}
