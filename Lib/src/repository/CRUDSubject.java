package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Subject;

public class CRUDSubject {
	/**
	 * Information of the database is stored here.
	 */
	private DataSource dataSource;
	
	/**
	 * Constructs a StudentRepository object, also initializing the information of the datasource.
	 */
	public CRUDSubject(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Subject> getAll() {
		List<Subject> subjectList = new ArrayList<>();
		
		try(
			
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet subjectsResultSet = retrieveStatement.executeQuery("SELECT id, name, description FROM subject")) {
			
			while(subjectsResultSet.next())
				subjectList.add(
						new Subject(
								subjectsResultSet.getInt(1),
								subjectsResultSet.getString(2),
								subjectsResultSet.getString(3)));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return subjectList;
	}
	
	public void update(Subject subject) {
		try(
			// Create a connection to the database, auto-closed later since we use try-with-resources
			Connection connection = dataSource.getConnection();
			// Prepare a placeholder object for an INSERT SQL Statement
			PreparedStatement updateStatement =
					connection.prepareStatement("UPDATE subject SET name = ?, description = ? WHERE id = ?")) {
			
			// Bind each field of the student object into the insert statement object.
			updateStatement.setString(1, subject.getName());
			updateStatement.setString(2, subject.getDescription());
			updateStatement.setInt(3, subject.getId());
			
			// Execute the insert statement.
			updateStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Subject subject) {
		try(
			Connection connection = dataSource.getConnection();
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO subject VALUES (null, ?, ?)")) {
			
			insertStatement.setString(1, subject.getName());
			insertStatement.setString(2, subject.getDescription());
			
			insertStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteById(int id) {
		try(Connection connection = dataSource.getConnection();
			PreparedStatement deleteStatement =
					connection.prepareStatement("DELETE FROM subject WHERE id = ?")) {
			
			deleteStatement.setInt(1, id);
			deleteStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
