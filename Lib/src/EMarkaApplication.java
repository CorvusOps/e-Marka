
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import gui.FrameMain;
import repository.CRUDStudent;
import repository.CRUDSubject;

public class EMarkaApplication {
	
	public static void main(String[] args) {
		// Create the datasource
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/student_db");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		// Create the repositories
		CRUDStudent studentRepository = new CRUDStudent(dataSource);
		CRUDSubject subjectRepository = new CRUDSubject(dataSource);
				
		// Create Student Management Panel
		gui.entity.student.PanelStudentManagement studentManagementPanel = 
				new gui.entity.student.PanelStudentManagement();
		// Wire the repositories that student management panel needs
		studentManagementPanel.setStudentRepository(studentRepository);
		studentManagementPanel.setSubjectRepository(subjectRepository);
		
		// Create Subject Management Panel
		gui.entity.subject.PanelSubjectManagement subjectManagementPanel = 
				new gui.entity.subject.PanelSubjectManagement();
		// Wire the repositories that student management panel needs
		//subjectManagementPanel.setSubjectRepository(subjectRepository);

		
		// Create Main Frame
		FrameMain mainFrame = new FrameMain();
		// Wire the components that main frame needs
		mainFrame.setStudentManagementPanel(studentManagementPanel);
		mainFrame.setSubjectManagementPanel(subjectManagementPanel);
		mainFrame.setVisible(true);
		
		
				
	}

}
