package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Grade;
import domain.GradePT;
import domain.GradeQA;
import domain.GradeWW;
import domain.Subject;

/**
 * Goal: select all student then left join all grade types  
 * SELECT GRADEWW
 * 
 */

public class CRUDGrade {

	private DataSource dataSource;
	private GradeWWDAO gradeWWDAO;
	private GradePTDAO gradePTDAO;
	private GradeQADAO gradeQADAO;
	
	public CRUDGrade(DataSource dataSource,
			GradeWWDAO gradeWWDAO,
			GradePTDAO gradePTDAO,
			GradeQADAO gradeQADAO) {
		this.dataSource = dataSource;
		this.gradeWWDAO = gradeWWDAO;
		this.gradePTDAO = gradePTDAO;
		this.gradeQADAO = gradeQADAO;
	}
	
	  public List<Grade> getAllBySubjectId(Subject subject) {
	        List<Grade> gradeList = new ArrayList<>();
	        
	        try(Connection connection = dataSource.getConnection();
	            Statement selectStatement = connection.createStatement();
	            ResultSet resultSet = selectStatement.executeQuery("SELECT student_number, first_name, last_name FROM student LEFT JOIN subject ON subject.id = student.subject_id"
	            		+ " WHERE subject_id = '" + subject.getId() + "'")) {
	            
	            while(resultSet.next()) {
	            	String studentNumber = resultSet.getString(1),
	            		   studentFirstName = resultSet.getString(2),
	                       studentLastName = resultSet.getString(3);
	                
	                Grade grade = new Grade();
	                grade.setStudentNumber(studentNumber);
	                grade.setStudentName(studentFirstName + " " + studentLastName);
	                
	                grade.setGradeWW(gradeWWDAO.getAllByStudentNumber(studentNumber));
	                grade.setGradePT(gradePTDAO.getAllByStudentNumber(studentNumber));
	                grade.setGradeQA(gradeQADAO.getAllByStudentNumber(studentNumber));
	                gradeList.add(grade);
	            }
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return gradeList;
	    }
	  
	  // readByTable 
	  // getStudentBySubjectID <- retrieve that specific student only from the list
	  // updateGrades <- update grades from 0
	  
	  public Grade getByStudentNumberID(String studentNumber) {
		  	Grade grade = new Grade();  
	        
	        try(Connection connection = dataSource.getConnection();
	            Statement selectStatement = connection.createStatement();
	            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM student " +
	            									"WHERE student_number = '" + studentNumber + "'")) {
	        	// what to get here again ???
	        	if(resultSet.next()) {
	                String studentFirstName = resultSet.getString(1),
	                       studentLastName = resultSet.getString(2);
	                
	                grade.setStudentNumber(studentNumber);
	                grade.setStudentName(studentFirstName + " " + studentLastName);
	                
	                grade.setGradeWW(gradeWWDAO.getAllByStudentNumber(studentNumber));
	                grade.setGradePT(gradePTDAO.getAllByStudentNumber(studentNumber));
	                grade.setGradeQA(gradeQADAO.getAllByStudentNumber(studentNumber));
	            }
	            
	        } catch(SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return grade;
	    }
	  
	  public void update(Grade grade) {
			try(
				// Create a connection to the database, auto-closed later since we use try-with-resources
				Connection connection = dataSource.getConnection();
				// Prepare a placeholder object for an INSERT SQL Statement
				PreparedStatement updateWWStatement =
						connection.prepareStatement("UPDATE gradeww" + 
								"SET gradeWW = ? " + 
								"WHERE gradeWW_id = ? ");
				PreparedStatement updatePTStatement =
						connection.prepareStatement("UPDATE gradept" + 
								"SET gradePT = ? " + 
								"WHERE gradePT_id = ? ");
				PreparedStatement updateQAStatement =
						connection.prepareStatement("UPDATE gradeqa" + 
								"SET gradeQA = ? " + 
								"WHERE gradeQA_id = ? ")) {
				
				// Bind each field of the student object into the insert statement object.
				
				for(GradeWW gradeWW : grade.getGradeWW()) {
					updateWWStatement.setInt(1, gradeWW.getGradesWW());
					updateWWStatement.setInt(2, gradeWW.getGradeWW_id());
					updateWWStatement.addBatch();
				}
				updateWWStatement.executeBatch();
				
				for(GradePT gradePT : grade.getGradePT()) {
					updatePTStatement.setInt(1, gradePT.getGradesPT());
					updatePTStatement.setInt(2, gradePT.getGradePT_id());
					updatePTStatement.addBatch();
				}
				updatePTStatement.executeBatch();
				
				for(GradeQA gradeQA : grade.getGradeQA()) {
					updateQAStatement.setInt(1, gradeQA.getGradesQA());
					updateQAStatement.setInt(2, gradeQA.getGradeQA_id());
					updateQAStatement.addBatch();
				}
				updateQAStatement.executeBatch();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
}
