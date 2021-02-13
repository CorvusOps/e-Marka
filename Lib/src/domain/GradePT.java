package domain;

public class GradePT {
	
	private int GradePT_id;
	private int studentNumber;
	private int performanceTasks_id;
	private int gradesPT;
	
	public GradePT(int gradePT_id, int studentNumber, int performanceTasks_id, int gradesPT) {
		super();
		GradePT_id = gradePT_id;
		this.studentNumber = studentNumber;
		this.performanceTasks_id = performanceTasks_id;
		this.gradesPT = gradesPT;
	}

	public int getGradePT_id() {
		return GradePT_id;
	}

	public void setGradePT_id(int gradePT_id) {
		GradePT_id = gradePT_id;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getPerformanceTasks_id() {
		return performanceTasks_id;
	}

	public void setPerformanceTasks_id(int performanceTasks_id) {
		this.performanceTasks_id = performanceTasks_id;
	}

	public int getGradesPT() {
		return gradesPT;
	}

	public void setGradesPT(int gradesPT) {
		this.gradesPT = gradesPT;
	}
	
		
}
