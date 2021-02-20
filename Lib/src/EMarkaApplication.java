import com.mysql.cj.jdbc.MysqlDataSource;
import gui.FrameMain;
import repository.CRUDGrade;
import repository.CRUDPerformanceTasks;
import repository.CRUDQuarterlyAssessment;
import repository.CRUDStudent;
import repository.CRUDSubject;
import repository.CRUDWrittenWorks;
import repository.GradePTDAO;
import repository.GradeQADAO;
import repository.GradeWWDAO;


public class EMarkaApplication {

	public static void main(String[] args) {
		
		// Create Login Frame
		gui.entry.LogIn logInFrame = new gui.entry.LogIn();
	
		// Create the datasource
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/student_db");
		dataSource.setUser("root");
		dataSource.setPassword("aidenflynn");
		
		GradeWWDAO gradeWWDAO = new GradeWWDAO(dataSource);
		GradePTDAO gradePTDAO = new GradePTDAO(dataSource);
		GradeQADAO gradeQADAO = new GradeQADAO(dataSource);
		
		// Create the repositories
		CRUDStudent studentRepository = new CRUDStudent(dataSource);
		CRUDSubject subjectRepository = new CRUDSubject(dataSource);
		CRUDPerformanceTasks ptRepository = new CRUDPerformanceTasks(dataSource);
		CRUDQuarterlyAssessment qaRepository = new CRUDQuarterlyAssessment(dataSource);
		CRUDWrittenWorks wwRepository = new CRUDWrittenWorks(dataSource);
		CRUDGrade gradeRepository = new CRUDGrade(dataSource, gradeWWDAO, gradePTDAO, gradeQADAO);
		
				
		// Create Student Management Panel
		gui.entity.student.PanelStudentManagement studentManagementPanel = 
				new gui.entity.student.PanelStudentManagement();
		// Wire the repositories that student management panel needs
		studentManagementPanel.setStudentRepository(studentRepository);
		studentManagementPanel.setSubjectRepository(subjectRepository);
		studentManagementPanel.refreshSubjectComboBox();
		
		// Create Subject Management Panel
		gui.entity.subject.PanelSubjectManagement subjectManagementPanel = 
				new gui.entity.subject.PanelSubjectManagement();
		// Wire the repositories that student management panel needs
		subjectManagementPanel.setSubjectRepository(subjectRepository);
		
		//Create Grade Management Panel
		gui.entity.grade.PanelGradeManagement gradeManagementPanel = 
				new gui.entity.grade.PanelGradeManagement();
		//Wire the repository that the grade management needs
		gradeManagementPanel.setStudentRepository(studentRepository);
		gradeManagementPanel.setSubjectRepository(subjectRepository);
		gradeManagementPanel.setGradeRepository(gradeRepository);
		gradeManagementPanel.setPTRepository(ptRepository);
		gradeManagementPanel.setQARepository(qaRepository);
		gradeManagementPanel.setWWRepository(wwRepository);
		gradeManagementPanel.refreshSubjectComboBox();
		
		// Create Written Works Component Management Panel
		gui.entity.component.PanelComponentWW wwComponentPanel = 
				new gui.entity.component.PanelComponentWW();
		wwComponentPanel.setWWRepository(wwRepository);
		wwComponentPanel.setSubjectRepository(subjectRepository);
		wwComponentPanel.refreshSubjectComboBox();
		// Wire the repository that the component management needs
		
		// Create Performance Tasks Component Management Panel
		gui.entity.component.PanelComponentPT ptComponentPanel = 
				new gui.entity.component.PanelComponentPT();
		ptComponentPanel.setPTRepository(ptRepository);
		ptComponentPanel.setSubjectRepository(subjectRepository);
		ptComponentPanel.setStudentRepository(studentRepository);
		ptComponentPanel.refreshSubjectComboBox();
		// Wire the repository that the component management needs
		
		// Create Quarterly Assessment Component Management Panel
		gui.entity.component.PanelComponentQA qaComponentPanel = 
				new gui.entity.component.PanelComponentQA();
		qaComponentPanel.setQARepository(qaRepository);
		qaComponentPanel.setSubjectRepository(subjectRepository);
		qaComponentPanel.refreshSubjectComboBox();
		// Wire the repository that the component management needs
		
		// Create Main Frame
		FrameMain mainFrame = new FrameMain();
		// Wire the components that main frame needs
		mainFrame.setLoginFrame(logInFrame);
		mainFrame.setStudentManagementPanel(studentManagementPanel);
		mainFrame.setSubjectManagementPanel(subjectManagementPanel);
		mainFrame.setGradeManagementPanel(gradeManagementPanel);
		mainFrame.setWWManagementPanel(wwComponentPanel);
		mainFrame.setPTManagementPanel(ptComponentPanel);
		mainFrame.setQAManagementPanel(qaComponentPanel);
		
		logInFrame.setVisible(true);
		logInFrame.setMainFrame(mainFrame);		
		
		
	}

}
