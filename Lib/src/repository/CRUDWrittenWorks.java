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
import domain.WrittenWorks;

public class CRUDWrittenWorks {
	
	private DataSource dataSource;
	
	public CRUDWrittenWorks(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<WrittenWorks> getAll() {
		List<WrittenWorks> writtenWorksList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet writtenWorksResultSet = retrieveStatement.executeQuery("SELECT * FROM writtenWorks LEFT JOIN subject ON subject.id = writtenWorks.writtenWorks_subjectid")) {
			
			while(writtenWorksResultSet.next()) {
				
				Subject subject = null;
				
				int writtenWorks_id = writtenWorksResultSet.getInt(1);
				String writtenWorks_title = writtenWorksResultSet.getString(2);
				float writtenWorks_total = writtenWorksResultSet.getFloat(3);
				int writtenWorks_subjectid = writtenWorksResultSet.getInt(4),
					subject_id = writtenWorksResultSet.getInt(5);
				String subject_name = writtenWorksResultSet.getString(6),
					   subject_description = writtenWorksResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
				
				WrittenWorks writtenWorks = new WrittenWorks(
												writtenWorks_id, writtenWorks_title, writtenWorks_total, subject);
				
				writtenWorksList.add(writtenWorks);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return writtenWorksList;
	}
	
	public WrittenWorks getBywrittenWorksId(int writtenWorks_id) {
		WrittenWorks writtenWorks = null;
		Subject subject = null;
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet writtenWorksResultSet = retrieveStatement.executeQuery("SELECT * FROM writtenWorks LEFT JOIN subject ON subject.id = writtenWorks.writtenWorks_subjectid" + 
					" WHERE writtenWorks_id = '" + writtenWorks_id + "'")) {
			
			if(writtenWorksResultSet.next()) {
				String writtenWorks_title = writtenWorksResultSet.getString(2);
				float writtenWorks_total = writtenWorksResultSet.getFloat(3);
				int writtenWorks_subjectid = writtenWorksResultSet.getInt(4),
					subject_id = writtenWorksResultSet.getInt(5);
				String subject_name = writtenWorksResultSet.getString(6),
					   subject_description = writtenWorksResultSet.getString(7);
				
				subject = new Subject(subject_id, subject_name, subject_description);
						
				writtenWorks = new WrittenWorks(writtenWorks_id, writtenWorks_title, writtenWorks_total, subject);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return writtenWorks;
	}
	
	public void save(WrittenWorks writtenWorks) {
		try(
			Connection connection = dataSource.getConnection();
			PreparedStatement insertStatement =
					connection.prepareStatement("INSERT INTO writtenWorks VALUES (null, ?, ?, ?)")) {
			
			insertStatement.setString(1, writtenWorks.getwrittenWorks_title());
			insertStatement.setFloat(2, writtenWorks.getwrittenWorks_total());
			insertStatement.setInt(3, writtenWorks.getSubject().getId());
			
			insertStatement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<WrittenWorks> getByWWSubjectID(Subject subject) {
		List<WrittenWorks> writtenWorksAssessmentList = new ArrayList<>();
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveStatement = connection.createStatement();
			ResultSet writtenWorksResultSet = retrieveStatement.executeQuery("SELECT * FROM writtenWorks LEFT JOIN subject ON subject.id = writtenWorks.writtenWorks_subjectid" + 
					" WHERE writtenWorks_subjectid = '" + subject.getId() + "'")) {
			
			while(writtenWorksResultSet.next()) {
				int 	writtenWorks_id = writtenWorksResultSet.getInt(1);	
				String 	writtenWorks_title = writtenWorksResultSet.getString(2);
				float 	writtenWorks_total = writtenWorksResultSet.getFloat(3);
				int 	writtenWorks_subjectid = writtenWorksResultSet.getInt(4),
						subject_id = writtenWorksResultSet.getInt(5);
				String 	subject_name = writtenWorksResultSet.getString(6),
						subject_description = writtenWorksResultSet.getString(7);
			
				subject = new Subject(subject_id, subject_name, subject_description);
				
				writtenWorksAssessmentList.add(new WrittenWorks(writtenWorks_id, writtenWorks_title, writtenWorks_total, subject));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return writtenWorksAssessmentList;
	}
	
}