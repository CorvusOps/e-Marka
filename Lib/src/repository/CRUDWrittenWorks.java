package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public List<WrittenWorks> getAll(List<Integer> ids) {
		if(ids == null || ids.size() <= 0)
			throw new IllegalArgumentException("Invalid ids given.");
		
		List<WrittenWorks> writtenWorkList = new ArrayList<>();
		
		StringBuilder queryBuilder = new StringBuilder("SELECT * FROM writtenWorks LEFT JOIN subject ON subject.id = writtenWorks.writtenWorks_subjectid WHERE writtenWorks_id IN (");
		Iterator<Integer> idsIterator = ids.iterator();
		queryBuilder.append(idsIterator.next());
		while(idsIterator.hasNext()) {
			queryBuilder.append(",");
			queryBuilder.append(idsIterator.next());
		}
		queryBuilder.append(")");
		
		try(
			Connection connection = dataSource.getConnection();
			Statement retrieveWrittenWorkStatement = connection.createStatement();
			ResultSet writtenWorksResultSet = retrieveWrittenWorkStatement.executeQuery(queryBuilder.toString())) {
			
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
				
				writtenWorkList.add(writtenWorks);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return writtenWorkList;
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
					connection.prepareStatement("INSERT INTO writtenWorks VALUES (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
			
			insertStatement.setString(1, writtenWorks.getwrittenWorks_title());
			insertStatement.setFloat(2, writtenWorks.getwrittenWorks_total());
			insertStatement.setInt(3, writtenWorks.getSubject().getId());
			
			insertStatement.execute();
			
			ResultSet generatedKeys = insertStatement.getGeneratedKeys();
			
			int generatedId = 0;
			if(generatedKeys.next()) {
				generatedId = generatedKeys.getInt(1);
			}
			
			
			generatedKeys.close();
			
			PreparedStatement insertZero =
					connection.prepareStatement("INSERT INTO gradeww(student_number, writtenWorks_id, gradeWW)" + 
							" SELECT student_number, ? , 0 FROM student WHERE subject_id = ?");
			
			insertZero.setInt(1, generatedId);
			insertZero.setInt(2, writtenWorks.getSubject().getId());
			
			insertZero.execute();
			insertZero.close();
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