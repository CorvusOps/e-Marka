package domain;

public class Student {
	/**
	 * Student number of the Student, also the ID in the database.
	 */
	private String studentNumber;
	/**
	 * First name of the Student.
	 */
	private String firstName;
	/**
	 * Middle name of the Student.
	 */
	private String middleName;
	/**
	 * Last name of the Student.
	 */
	private String lastName;
	/**
	 * Address of the Student.
	 */
	private String address;
	/**
	 * Section of the Student.
	 */
	private String section;
	/** Object Composition.
	 * Subject of this Student
	 */
	private Subject subject;
	
	/**
	 * Constructs a Student with pre-initialized data.
	 * Typically use this when Students are retrieved from the database,
	 * where data is already pre-existing.
	 * 
	 * @param studentNumber
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param address
	 * @param section
	 */
	public Student(
			String studentNumber,
			String firstName,
			String middleName,
			String lastName,
			String address,
			String section,
			Subject subject) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.section = section;
		this.subject = subject;
	}
	
	public Student(
			String firstName,
			String middleName,
			String lastName,
			String address,
			String section,
			Subject subject) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.section = section;
		this.subject = subject;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
