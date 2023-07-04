package spring.aop.entity;

public class AiswExam implements Exam {
	
	private int kor;
	private int eng;
	private int math;
	
	public AiswExam() {
		
	}
	
	public AiswExam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		int result = kor + eng + math;
		return result;
	}

	@Override
	public float avg() {
		// TODO Auto-generated method stub
		
		float result = (float)(total()/3);
		return result;
	}

}
