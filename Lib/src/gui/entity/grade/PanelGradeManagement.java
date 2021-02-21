package gui.entity.grade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import domain.Grade;
import domain.Subject;
import repository.CRUDGrade;
import repository.CRUDPerformanceTasks;
import repository.CRUDQuarterlyAssessment;
import repository.CRUDStudent;
import repository.CRUDSubject;
import repository.CRUDWrittenWorks;

@SuppressWarnings("serial")
public class PanelGradeManagement extends JPanel {
	
	private DialogViewGrade viewGradeDialog;
	private JTable jtblGrades;
	
	protected CRUDSubject subjectRepository;
	protected CRUDStudent studentRepository;
	protected CRUDGrade gradeRepository;
	protected CRUDPerformanceTasks ptRepository;
	protected CRUDQuarterlyAssessment qaRepository;
	protected CRUDWrittenWorks wwRepository;
	
	protected TemplateGrade gradeTableModel;
	protected JComboBox cmbSubject;
	
	public PanelGradeManagement() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* viewGradeDialog - the main add dialog form */
		// Instantiate the viewGradeDialog that we will use
		viewGradeDialog = new DialogViewGrade();
		// Set its GradeManagementFrame reference to this object.
		viewGradeDialog.gradeManagementFrame = this;
		/* END OF viewGradeDialog
			
		
		/* jpnlHeader - header labels and buttons placed here. */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jpnlHeader = new JPanel();
		jpnlHeader.setBackground(new Color(255, 255, 255));
		jpnlHeader.setAlignmentX(0.0f);
		jpnlHeader.setAlignmentY(0.0f);
		add(jpnlHeader);
		jpnlHeader.setLayout(new BoxLayout(jpnlHeader, BoxLayout.X_AXIS));
		/* END OF jpnlHeader */
		
		/* jlblHeader - header label */
		JLabel jlblHeader = new JLabel("Grade Management Panel");
		jlblHeader.setBackground(new Color(255, 255, 255));
		jlblHeader.setBorder(new EmptyBorder(0, 0, 10, 0));
		jlblHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		jlblHeader.setAlignmentY(0.0f);
		jpnlHeader.add(jlblHeader);
		/* END OF jlblHeader */
		
		/* jpnlButtons - button actions panel */
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setBackground(new Color(255, 255, 255));
		jpnlButtons.setAlignmentX(0.0f);
		jpnlButtons.setAlignmentY(0.0f);
		jpnlButtons.setMaximumSize(new Dimension(32767, 75));
		FlowLayout flowLayout = (FlowLayout) jpnlButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		jpnlHeader.add(jpnlButtons);
		/* END OF jbtnAdd */
		
		/* jbtnUpdate - updates a row in the JTable with a Dialog */
		JButton jbtnViewGrade = new JButton("VIEW GRADE");
		jbtnViewGrade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnViewGrade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblGrades.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a row first before viewing.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// Subject subject = ((Subject) cmbSubject.getSelectedItem());
				String studentNumber = (String) gradeTableModel.getValueAt(rowIndex, 0);
				String studentName = (String) gradeTableModel.getValueAt(rowIndex, 1);
				Grade grade = gradeRepository.getByStudentNumberID(studentNumber);
			
				viewGradeDialog.initialize(grade, studentName);
				// give set up  method here ??
				
				//viewGradeDialog.initializeDialog(student);
				viewGradeDialog.setVisible(true);
			}
		});
		jpnlButtons.add(jbtnViewGrade);
		/* END OF jbtnViewGrade */
		
		cmbSubject = new JComboBox();
		cmbSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(cmbSubject);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  Subject subject = (Subject) cmbSubject.getSelectedItem();
		    	  gradeTableModel.refreshWithSubject(subject);
		      }
		    };
		    
		cmbSubject.addItemListener(itemListener);
		
		/* jscrlpnMainTable - scrollable container for student JTable */
		JScrollPane jscrlpnMainTable = new JScrollPane();
		jscrlpnMainTable.setAlignmentX(0.0f);
		add(jscrlpnMainTable);
		/* END OF jscrlpnMainTable */
		
		/* jtblStudents - table that shows the Students in a tabular format */
		jtblGrades = new JTable();
		jtblGrades.setRowHeight(20);
		jtblGrades.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/* studentTableModel - the main TableModel object that jtblStudents uses */
		gradeTableModel = new TemplateGrade();
		// Link this frame to the TableModel, so it can call studentRepository here.
		gradeTableModel.gradeManagementFrame = this; 
		/* END OF studentTableModel */
		jtblGrades.setModel(gradeTableModel);
		
		// Add the table to the scrollable container
		jscrlpnMainTable.setViewportView(jtblGrades);
		/* END OF jtblStudents */
	}

	
	public void setStudentRepository(CRUDStudent studentRepository) {
		this.studentRepository = studentRepository;
		// Refresh the student table model immediately.
		//gradeTableModel.refresh();
	}

	public void setSubjectRepository(CRUDSubject subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	
	public void setGradeRepository(CRUDGrade gradeRepository) {
		this.gradeRepository = gradeRepository;
	}
	
	public void setPTRepository(CRUDPerformanceTasks ptRepository) {
		this.ptRepository = ptRepository;
	}
	
	public void setQARepository(CRUDQuarterlyAssessment qaRepository) {
		this.qaRepository = qaRepository;
	}
	
	public void setWWRepository(CRUDWrittenWorks wwRepository) {
		this.wwRepository = wwRepository;
	}
	
	@SuppressWarnings("unchecked")
	public void refreshSubjectComboBox() {
		List<Subject> subjectList = subjectRepository.getAll();
		
		Subject[] subjectArray = new Subject[subjectList.size()];
		for(int i = 0; i < subjectList.size(); i++)
			subjectArray[i] = subjectList.get(i);
		
		cmbSubject.setModel(new DefaultComboBoxModel<Subject>(subjectArray));
	}
	
}
