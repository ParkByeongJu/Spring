package spring.duck.fly;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {

		System.out.print("날 수 없다. ");
		
	}

}
