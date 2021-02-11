package domain;

public class WrittenWorks {

	private int writtenWorks_id;
	private String writtenWorks_title;
	private float writtenWorks_total;
	private Subject subject;
	
	public WrittenWorks(String writtenWorks_title, float writtenWorks_total,
			Subject subject) {
		super();
		this.writtenWorks_title = writtenWorks_title;
		this.writtenWorks_total = writtenWorks_total;
		this.subject = subject;
	}
	
	public WrittenWorks(int writtenWorks_id, String writtenWorks_title, float writtenWorks_total,
			Subject subject) {
		super();
		this.writtenWorks_id = writtenWorks_id;
		this.writtenWorks_title = writtenWorks_title;
		this.writtenWorks_total = writtenWorks_total;
		this.subject = subject;
	}

	public int getwrittenWorks_id() {
		return writtenWorks_id;
	}

	public void setwrittenWorks_id(int writtenWorks_id) {
		this.writtenWorks_id = writtenWorks_id;
	}

	public String getwrittenWorks_title() {
		return writtenWorks_title;
	}

	public void setwrittenWorks_title(String writtenWorks_title) {
		this.writtenWorks_title = writtenWorks_title;
	}
	
	public float getwrittenWorks_total() {
		return writtenWorks_total;
	}

	public void setwrittenWorks_total(float writtenWorks_total) {
		this.writtenWorks_total = writtenWorks_total;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return writtenWorks_title;
	}
	
	
}
