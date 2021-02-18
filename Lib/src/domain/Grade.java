package domain;

import java.util.List;

public class Grade {
	
	private int subject_id;
	private String studentNumber;
	private String studentName;
	private List<GradeWW> gradeWW;
	private List<GradePT> gradePT;
	private List<GradeQA> gradeQA;
	
	public Grade(int subject_id, String studentNumber, String studentName, List<GradeWW> gradeWW, List<GradePT> gradePT,
			List<GradeQA> gradeQA) {
		super();
		this.subject_id = subject_id;
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.gradeWW = gradeWW;
		this.gradePT = gradePT;
		this.gradeQA = gradeQA;
	}

	public Grade() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<GradeWW> getGradeWW() {
		return gradeWW;
	}

	public void setGradeWW(List<GradeWW> gradeWW) {
		this.gradeWW = gradeWW;
	}

	public List<GradePT> getGradePT() {
		return gradePT;
	}

	public void setGradePT(List<GradePT> gradePT) {
		this.gradePT = gradePT;
	}

	public List<GradeQA> getGradeQA() {
		return gradeQA;
	}

	public void setGradeQA(List<GradeQA> gradeQA) {
		this.gradeQA = gradeQA;
	}

	//select all student then left join all grade types 
	
	
	
	

}
