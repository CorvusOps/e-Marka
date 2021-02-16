package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.GradePT;

public class GradePTDAO {
	private DataSource dataSource;    
    public GradePTDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<GradePT> getAllByStudentNumber(int studentNumber) {
        List<GradePT> GradePTList = new ArrayList<>();
        
        try(Connection connection = dataSource.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM gradept WHERE student_number = " + studentNumber)) {
            
            while(resultSet.next())
            	GradePTList.add(new GradePT(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return GradePTList;
    }

}
