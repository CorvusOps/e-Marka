package domain;

public class PerformanceTasks {

	private int performanceTasks_id;
	private String performanceTasks_title;
	private float performanceTasks_total;
	private Subject subject;
	
	public PerformanceTasks(int performanceTasks_id, String performanceTasks_title, float performanceTasks_total,
			Subject subject) {
		super();
		this.performanceTasks_id = performanceTasks_id;
		this.performanceTasks_title = performanceTasks_title;
		this.performanceTasks_total = performanceTasks_total;
		this.subject = subject;
	}
	
	public PerformanceTasks(String performanceTasks_title, float performanceTasks_total,
			Subject subject) {
		super();
		this.performanceTasks_title = performanceTasks_title;
		this.performanceTasks_total = performanceTasks_total;
		this.subject = subject;
	}

	public int getPerformanceTasks_id() {
		return performanceTasks_id;
	}

	public void setPerformanceTasks_id(int performanceTasks_id) {
		this.performanceTasks_id = performanceTasks_id;
	}

	public String getPerformanceTasks_title() {
		return performanceTasks_title;
	}

	public void setPerformanceTasks_title(String performanceTasks_title) {
		this.performanceTasks_title = performanceTasks_title;
	}

	public float getPerformanceTasks_total() {
		return performanceTasks_total;
	}

	public void setPerformanceTasks_total(float performanceTasks_total) {
		this.performanceTasks_total = performanceTasks_total;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
