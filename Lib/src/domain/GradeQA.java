package domain;

public class GradeQA {
	
	private int GradeQA_id;
	private int studentNumber;
	private int quarterlyAssessment_id;
	private int gradesQA;
	
	public GradeQA(int gradeQA_id, int studentNumber, int quarterlyAssessment_id, int gradesQA) {
		super();
		GradeQA_id = gradeQA_id;
		this.studentNumber = studentNumber;
		this.quarterlyAssessment_id = quarterlyAssessment_id;
		this.gradesQA = gradesQA;
	}

	public int getGradeQA_id() {
		return GradeQA_id;
	}

	public void setGradeQA_id(int gradeQA_id) {
		GradeQA_id = gradeQA_id;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getQuarterlyAssessment_id() {
		return quarterlyAssessment_id;
	}

	public void setQuarterlyAssessment_id(int quarterlyAssessment_id) {
		this.quarterlyAssessment_id = quarterlyAssessment_id;
	}

	public int getGradesQA() {
		return gradesQA;
	}

	public void setGradesQA(int gradesQA) {
		this.gradesQA = gradesQA;
	}

	
}
