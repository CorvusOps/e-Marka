package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.QuarterlyAssessment;
import domain.Subject;

public class CRUDQuarterlyAssessment {
	
	private DataSource dataSource;
	
	public CRUDQuarterlyAssessment(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<QuarterlyAssessment> getAll() {
		List<QuarterlyAssessment> quarterlyAssessmentList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet quarterlyAssessmentResultSet = retrieveStatement.executeQuery("SELECT * FROM quarterlyAssessment LEFT JOIN subject ON subject.id = quarterlyAssessment.quarterlyAssessment_subjectid")) {
			
			while(quarterlyAssessmentResultSet.next()) {
				
				Subject subject = null;
				
				int quarterlyAssessment_id = quarterlyAssessmentResultSet.getInt(1);
				String quarterlyAssessment_title = quarterlyAssessmentResultSet.getString(2);
				float quarterlyAssessment_total = quarterlyAssessmentResultSet.getFloat(3);
				int quarterlyAssessment_subjectid = quarterlyAssessmentResultSet.getInt(4),
					subject_id = quarterlyAssessmentResultSet.getInt(5);
				String subject_name = quarterlyAssessmentResultSet.getString(6),
					   subject_description = quarterlyAssessmentResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
				
				QuarterlyAssessment quarterlyAssessment = new QuarterlyAssessment(quarterlyAssessment_id, quarterlyAssessment_title, quarterlyAssessment_total, subject);
				
				quarterlyAssessmentList.add(quarterlyAssessment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return quarterlyAssessmentList;
	}
	
	public QuarterlyAssessment getByquarterlyAssessmentId(int quarterlyAssessment_id) {
		QuarterlyAssessment quarterlyAssessment = null;
		Subject subject = null;
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet quarterlyAssessmentResultSet = retrieveStatement.executeQuery("SELECT * FROM quarterlyAssessment LEFT JOIN subject ON subject.id = quarterlyAssessment.quarterlyAssessment_subjectid" + 
					" WHERE quarterlyAssessment_id = '" + quarterlyAssessment_id + "'")) {
			
			if(quarterlyAssessmentResultSet.next()) {
				String quarterlyAssessment_title = quarterlyAssessmentResultSet.getString(2);
				float quarterlyAssessment_total = quarterlyAssessmentResultSet.getFloat(3);
				int quarterlyAssessment_subjectid = quarterlyAssessmentResultSet.getInt(4),
					subject_id = quarterlyAssessmentResultSet.getInt(5);
				String subject_name = quarterlyAssessmentResultSet.getString(6),
					   subject_description = quarterlyAssessmentResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
						
				quarterlyAssessment = new QuarterlyAssessment(quarterlyAssessment_id, quarterlyAssessment_title, quarterlyAssessment_total, subject);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return quarterlyAssessment;
	}
	
	public void save(QuarterlyAssessment quarterlyAssessment) {
		try(
			Connection connection = dataSource.getConnection();
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO quarterlyAssessment VALUES (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
			
			insertStatement.setString(1, quarterlyAssessment.getquarterlyAssessment_title());
			insertStatement.setFloat(2, quarterlyAssessment.getquarterlyAssessment_total());
			insertStatement.setInt(3, quarterlyAssessment.getSubject().getId());
			
			insertStatement.execute();
			
			ResultSet generatedKeys = insertStatement.getGeneratedKeys();
			
			int generatedId = 0;
			if(generatedKeys.next()) {
				generatedId = generatedKeys.getInt(1);
			}
			
			generatedKeys.close();
			
			PreparedStatement insertZero =
					connection.prepareStatement("INSERT INTO gradeqa(student_number, quarterlyAssessment_id, gradeQA)" + 
							" SELECT student_number, ? , 0 FROM student WHERE subject_id = ?");
			
			insertZero.setInt(1, generatedId);
			insertZero.setInt(2, quarterlyAssessment.getSubject().getId());
			
			insertZero.execute();
			insertZero.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<QuarterlyAssessment> getByQASubjectID(Subject subject) {
		List<QuarterlyAssessment> quarterlyAssessmentList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet quarterlyAssessmentResultSet = retrieveStatement.executeQuery("SELECT * FROM quarterlyAssessment LEFT JOIN subject ON subject.id = quarterlyAssessment.quarterlyAssessment_subjectid" + 
					" WHERE quarterlyAssessment_subjectid = '" + subject.getId() + "'")) {
			
			while(quarterlyAssessmentResultSet.next()) {
				int 	quarterlyAssessment_id = quarterlyAssessmentResultSet.getInt(1);	
				String 	quarterlyAssessment_title = quarterlyAssessmentResultSet.getString(2);
				float 	quarterlyAssessment_total = quarterlyAssessmentResultSet.getFloat(3);
				int 	quarterlyAssessment_subjectid = quarterlyAssessmentResultSet.getInt(4),
						subject_id = quarterlyAssessmentResultSet.getInt(5);
				String 	subject_name = quarterlyAssessmentResultSet.getString(6),
						subject_description = quarterlyAssessmentResultSet.getString(7);
			
				subject = new Subject(subject_id, subject_name, subject_description);
				
				quarterlyAssessmentList.add(new QuarterlyAssessment(quarterlyAssessment_id, quarterlyAssessment_title, quarterlyAssessment_total, subject));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return quarterlyAssessmentList;
	}
	
}