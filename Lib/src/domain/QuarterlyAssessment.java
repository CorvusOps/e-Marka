package domain;

public class QuarterlyAssessment {
	
	private int quarterlyAssessment_id;
	private String quarterlyAssessment_title;
	private float quarterlyAssessment_total;
	private Subject subject;
	
	public QuarterlyAssessment(int quarterlyAssessment_id, String quarterlyAssessment_title,
			float quarterlyAssessment_total, Subject subject) {
		super();
		this.quarterlyAssessment_id = quarterlyAssessment_id;
		this.quarterlyAssessment_title = quarterlyAssessment_title;
		this.quarterlyAssessment_total = quarterlyAssessment_total;
		this.subject = subject;
	}
	
	public QuarterlyAssessment(String quarterlyAssessment_title,
			float quarterlyAssessment_total, Subject subject) {
		super();
		this.quarterlyAssessment_title = quarterlyAssessment_title;
		this.quarterlyAssessment_total = quarterlyAssessment_total;
		this.subject = subject;
	}

	public String getquarterlyAssessment_title() {
		return quarterlyAssessment_title;
	}

	public void setquarterlyAssessment_title(String quarterlyAssessment_title) {
		this.quarterlyAssessment_title = quarterlyAssessment_title;
	}

	public float getquarterlyAssessment_total() {
		return quarterlyAssessment_total;
	}

	public void setquarterlyAssessment_total(float quarterlyAssessment_total) {
		this.quarterlyAssessment_total = quarterlyAssessment_total;
	}

	public int getquarterlyAssessment_id() {
		return quarterlyAssessment_id;
	}

	public void setquarterlyAssessment_id(int quarterlyAssessment_id) {
		this.quarterlyAssessment_id = quarterlyAssessment_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
}