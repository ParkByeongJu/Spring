package spring.di.ui;

import spring.di.entity.Exam;

public class InlineDisplayExam implements DisplayExam {

	private Exam exam;
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.printf("Totoal : %d   Average : %f ~~~~~~\n", exam.total(), exam.avg());
		
	}
	
	@Override
	public void setExam(Exam exam)
	{
		this.exam = exam;
	}

}
