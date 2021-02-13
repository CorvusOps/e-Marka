package domain;

public class GradeWW {
	
	private int GradeWW_id;
	private int studentNumber;
	private int writtenWorks_id;
	private int gradesWW;
	
	public GradeWW(int gradeWW_id, int studentNumber, int writtenWorks_id, int gradesWW) {
		super();
		GradeWW_id = gradeWW_id;
		this.studentNumber = studentNumber;
		this.writtenWorks_id = writtenWorks_id;
		this.gradesWW = gradesWW;
	}

	public int getGradeWW_id() {
		return GradeWW_id;
	}

	public void setGradeWW_id(int gradeWW_id) {
		GradeWW_id = gradeWW_id;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getWrittenWorks_id() {
		return writtenWorks_id;
	}

	public void setWrittenWorks_id(int writtenWorks_id) {
		this.writtenWorks_id = writtenWorks_id;
	}

	public int getGradesWW() {
		return gradesWW;
	}

	public void setGradesWW(int gradesWW) {
		this.gradesWW = gradesWW;
	}
	
	

}
