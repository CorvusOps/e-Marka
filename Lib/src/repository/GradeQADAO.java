package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.GradeQA;


public class GradeQADAO {
	
	private DataSource dataSource;  
	
    public GradeQADAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<GradeQA> getAllByStudentNumber(String studentNumber) {
        List<GradeQA> GradeQAList = new ArrayList<>();
        
        try(Connection connection = dataSource.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM gradeqa WHERE student_number = " + studentNumber)) {
            
            while(resultSet.next())
            	GradeQAList.add(new GradeQA(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return GradeQAList;
    }

}
