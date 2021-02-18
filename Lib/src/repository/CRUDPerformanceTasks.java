package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.PerformanceTasks;
import domain.Subject;

public class CRUDPerformanceTasks {
	
	private DataSource dataSource;
	
	public CRUDPerformanceTasks(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<PerformanceTasks> getAll() {
		List<PerformanceTasks> performanceTasksList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet performanceTasksResultSet = retrieveStatement.executeQuery("SELECT * FROM performanceTasks LEFT JOIN subject ON subject.id = performanceTasks.performanceTasks_subjectid")) {
			
			while(performanceTasksResultSet.next()) {
				
				Subject subject = null;
				
				int performanceTasks_id = performanceTasksResultSet.getInt(1);
				String performanceTasks_title = performanceTasksResultSet.getString(2);
				float performanceTasks_total = performanceTasksResultSet.getFloat(3);
				int performanceTasks_subjectid = performanceTasksResultSet.getInt(4),
					subject_id = performanceTasksResultSet.getInt(5);
				String subject_name = performanceTasksResultSet.getString(6),
					   subject_description = performanceTasksResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
				
				PerformanceTasks performanceTasks = new PerformanceTasks(
												performanceTasks_id, performanceTasks_title, performanceTasks_total, subject);
				
				performanceTasksList.add(performanceTasks);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return performanceTasksList;
	}
	
	public PerformanceTasks getByPerformanceTasksId(int performanceTasks_id) {
		PerformanceTasks performanceTasks = null;
		Subject subject = null;
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet performanceTasksResultSet = retrieveStatement.executeQuery("SELECT * FROM performanceTasks LEFT JOIN subject ON subject.id = performanceTasks.performanceTasks_subjectid" + 
					" WHERE performanceTasks_id = '" + performanceTasks_id + "'")) {
			
			if(performanceTasksResultSet.next()) {
				String performanceTasks_title = performanceTasksResultSet.getString(2);
				float performanceTasks_total = performanceTasksResultSet.getFloat(3);
				int performanceTasks_subjectid = performanceTasksResultSet.getInt(4),
					subject_id = performanceTasksResultSet.getInt(5);
				String subject_name = performanceTasksResultSet.getString(6),
					   subject_description = performanceTasksResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
						
				performanceTasks = new PerformanceTasks(performanceTasks_id, performanceTasks_title, performanceTasks_total, subject);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return performanceTasks;
	}
	
	public void save(PerformanceTasks performanceTasks) {
		try(
			Connection connection = dataSource.getConnection();
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO performanceTasks VALUES (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
			
			insertStatement.setString(1, performanceTasks.getPerformanceTasks_title());
			insertStatement.setFloat(2, performanceTasks.getPerformanceTasks_total());
			insertStatement.setInt(3, performanceTasks.getSubject().getId());
			
			insertStatement.execute();
			
			ResultSet generatedKeys = insertStatement.getGeneratedKeys();
			
			int generatedId = 0;
			if(generatedKeys.next()) {
				generatedId = generatedKeys.getInt(1);
			}
			
			generatedKeys.close();
			
			PreparedStatement insertZero =
					connection.prepareStatement("INSERT INTO gradept(student_number, performanceTasks_id, gradePT)" + 
							" SELECT student_number, ? , 0 FROM student WHERE subject_id = ?");
			
			insertZero.setInt(1, generatedId);
			insertZero.setInt(2, performanceTasks.getSubject().getId());
			
			insertZero.execute();
			insertZero.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PerformanceTasks> getByPTSubjectID(Subject subject) {
		List<PerformanceTasks> performanceTasksList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet performanceTasksResultSet = retrieveStatement.executeQuery("SELECT * FROM performanceTasks LEFT JOIN subject ON subject.id = performanceTasks.performanceTasks_subjectid" + 
					" WHERE performanceTasks_subjectid = '" + subject.getId() + "'")) {
			
			while(performanceTasksResultSet.next()) {
				int 	performanceTasks_id = performanceTasksResultSet.getInt(1);	
				String 	performanceTasks_title = performanceTasksResultSet.getString(2);
				float 	performanceTasks_total = performanceTasksResultSet.getFloat(3);
				int 	performanceTasks_subjectid = performanceTasksResultSet.getInt(4),
						subject_id = performanceTasksResultSet.getInt(5);
				String 	subject_name = performanceTasksResultSet.getString(6),
						subject_description = performanceTasksResultSet.getString(7);
			
				subject = new Subject(subject_id, subject_name, subject_description);
				
				performanceTasksList.add(new PerformanceTasks(performanceTasks_id, performanceTasks_title, performanceTasks_total, subject));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return performanceTasksList;
	}
	
}