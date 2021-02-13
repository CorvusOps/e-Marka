package domain;

import java.util.List;

public class Grade {
	
	private int subject_id;
	private String studentName;
	private List<GradeWW> gradesWW;
	private List<GradePT> gradePT;
	private List<GradeQA> gradeQA;

	//select all student then left join all grade types 
	public Grade(int subject_id, String studentName, List<GradeWW> gradesWW, List<GradePT> gradePT,
			List<GradeQA> gradeQA) {
		super();
		this.subject_id = subject_id;
		this.studentName = studentName;
		this.gradesWW = gradesWW;
		this.gradePT = gradePT;
		this.gradeQA = gradeQA;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<GradeWW> getGradesWW() {
		return gradesWW;
	}

	public void setGradesWW(List<GradeWW> gradesWW) {
		this.gradesWW = gradesWW;
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
	
	
	

}
