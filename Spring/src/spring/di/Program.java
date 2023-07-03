package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.AiswExam;
import spring.di.entity.Exam;
import spring.di.ui.DisplayExam;
import spring.di.ui.GridDisplayExam;
import spring.di.ui.InlineDisplayExam;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml");
		DisplayExam displayExam = context.getBean(DisplayExam.class);

//		Exam exam = new AiswExam(10,10,10);
//		DisplayExam displayExam =
			// new InlineDisplayExam();
//			 new GridDisplayExam();
//		displayExam.setExam(exam);
		
		
		displayExam.display();
		
			
	}

}
