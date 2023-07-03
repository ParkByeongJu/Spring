package spring.di.ui;

import spring.di.entity.Exam;

public class GridDisplayExam implements DisplayExam {

	private Exam exam;
	
	@Override
	public void display() {

		System.out.println("----------------------------------------");
		System.out.printf("Totoal  | %6d\n", exam.total());
		System.out.printf("Average | %6.2f\n", exam.avg());
		System.out.println("----------------------------------------");
		
	}
	
	@Override
	public void setExam(Exam exam)
	{
		this.exam = exam;
	}
	
}
