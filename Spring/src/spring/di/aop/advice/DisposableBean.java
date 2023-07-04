package spring.di.aop.advice;

public class DisposableBean implements org.springframework.beans.factory.DisposableBean {

	@Override
	public void destroy() throws Exception {

		System.out.println("종료");
		
	}

}
