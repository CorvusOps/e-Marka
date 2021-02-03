package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Student;

public class CRUDStudent {
	/**
	 * Information of the database is stored here.
	 */
	private DataSource dataSource;
	
	/**
	 * Constructs a StudentRepository object, also initializing the information of the datasource.
	 */
	public CRUDStudent(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * Gets all records from the database table `student`, and maps each row to a Student object.
	 * 
	 * @return list of Student objects mapped and retrieved from the database.
	 */
	public List<Student> getAll() {
		// Hold all mapped Student objects from rows, here
		List<Student> studentList = new ArrayList<>();
		
		try(
			// Create a connection to the database, auto-closed later since we use try-with-resources
			Connection connection = dataSource.getConnection();
			// Create a placeholder for an SQL retrieve statement
			Statement retrieveStatement = connection.createStatement();
			// Execute the SQL retrieve statement, then grab its results in the ResultSet object
			ResultSet studentsResultSet = retrieveStatement.executeQuery("SELECT * FROM student")) {
			
			// For each record in the ResultSet, map it to a new Student object
			// then add it to our final list.
			while(studentsResultSet.next()) {
				String studentNumber = studentsResultSet.getString(1),
					   firstName = studentsResultSet.getString(2),
					   middleName = studentsResultSet.getString(3),
					   lastName = studentsResultSet.getString(4),
					   address = studentsResultSet.getString(5),
					   section = studentsResultSet.getString(6);
				Student student = new Student(studentNumber, firstName, middleName, lastName, address, section, null);
				studentList.add(student);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Return the final list.
		return studentList;
	}
	
	/**
	 * Gets all records from the database table `student`, and maps each row to a Student object.
	 * 
	 * @return list of Student objects mapped and retrieved from the database.
	 */
	public Student getByStudentNumber(String studentNumber) {
		Student student = null;
		
		try(
			// Create a connection to the database, auto-closed later since we use try-with-resources
			Connection connection = dataSource.getConnection();
			// Create a placeholder for an SQL retrieve statement
			Statement retrieveStatement = connection.createStatement();
			// Execute the SQL retrieve statement, then grab its results in the ResultSet object
			ResultSet studentResultSet = retrieveStatement.executeQuery("SELECT * FROM student WHERE student_number = '" + studentNumber + "'")) {
			
			// For each record in the ResultSet, map it to a new Student object
			// then add it to our final list.
			if(studentResultSet.next()) {
				String firstName = studentResultSet.getString(2),
					   middleName = studentResultSet.getString(3),
					   lastName = studentResultSet.getString(4),
					   address = studentResultSet.getString(5),
					   section = studentResultSet.getString(6);
				student = new Student(studentNumber, firstName, middleName, lastName, address, section, null);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Return the final student
		return student;
	}
	
	/**
	 * Saves a student to the database.<br><br>
	 * 
	 * Maps the student object to a database table row.
	 * 
	 * @param student the student to be saved.
	 */
	public void save(Student student) {
		try(
			// Create a connection to the database, auto-closed later since we use try-with-resources
			Connection connection = dataSource.getConnection();
			// Prepare a placeholder object for an INSERT SQL Statement
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?, ?, ?, ?)")) {
			
			// Bind each field of the student object into the insert statement object.
			insertStatement.setString(1, student.getStudentNumber());
			insertStatement.setString(2, student.getFirstName());
			insertStatement.setString(3, student.getMiddleName());
			insertStatement.setString(4, student.getLastName());
			insertStatement.setString(5, student.getAddress());
			insertStatement.setString(6, student.getSection());
			insertStatement.setInt(7, student.getSubject().getId());
			
			// Execute the insert statement.
			insertStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Student student) {
		try(
			// Create a connection to the database, auto-closed later since we use try-with-resources
			Connection connection = dataSource.getConnection();
			// Prepare a placeholder object for an INSERT SQL Statement
			PreparedStatement updateStatement =
					connection.prepareStatement("UPDATE student SET first_name = ?, middle_name = ?, last_name = ?, address = ?, section = ? WHERE student_number = ?")) {
			
			// Bind each field of the student object into the insert statement object.
			updateStatement.setString(1, student.getFirstName());
			updateStatement.setString(2, student.getMiddleName());
			updateStatement.setString(3, student.getLastName());
			updateStatement.setString(4, student.getAddress());
			updateStatement.setString(5, student.getSection());
			updateStatement.setString(6, student.getStudentNumber());
			
			// Execute the insert statement.
			updateStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByStudentNumber(String studentNumber) {
		try(Connection connection = dataSource.getConnection();
			PreparedStatement deleteStatement =
					connection.prepareStatement("DELETE FROM student WHERE student_number = ?")) {
			
			deleteStatement.setString(1, studentNumber);
			deleteStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
