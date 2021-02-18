package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.GradeWW;

public class GradeWWDAO {
	private  DataSource dataSource;    
    public GradeWWDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<GradeWW> getAllByStudentNumber(String studentNumber) {
        List<GradeWW> GradeWWList = new ArrayList<>();
        
        try(Connection connection = dataSource.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM gradeww WHERE student_number = " + studentNumber)) {
            
            while(resultSet.next())
            	GradeWWList.add(new GradeWW(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return GradeWWList;
    }

}
