package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import domain.Grade;
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
	                int studentNumber = resultSet.getInt(1);
	                String studentFirstName = resultSet.getString(2),
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
	  
	  
	  // getStudentBySubjectID <- retrieve that specific student only from the list
	  // updateGrades <- update grades from 0
	  
	
}
