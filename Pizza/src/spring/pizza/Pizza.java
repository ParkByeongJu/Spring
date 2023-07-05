package spring.pizza;

public abstract class Pizza {

	public void prepare() {
        System.out.println("피자 준비하는중");
    }

    public void bake() {
        System.out.println("피자 굽는 중");
    }

    public void cut() {
        System.out.println("피자 자르는 중");
    }

    public void box() {
        System.out.println("피자 포장 중");
    }
	
}
