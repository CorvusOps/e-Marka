package gui.entity.grade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

@SuppressWarnings("serial")
public class PanelGradeManagement extends JPanel {
	
	private DialogViewGrade viewGradeDialog;
	private JTable jtblGrades;
	protected TemplateGrade gradeTableModel;

	public PanelGradeManagement() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* addStudentDialog - the main add dialog form */
		// Instantiate the addStudentDialog that we will use
		viewGradeDialog = new DialogViewGrade();
		// Set its StudentManagementFrame reference to this object.
		viewGradeDialog.gradeManagementFrame = this;
		/* END OF addStudentDialog
		
		/* updateStudentDialog - the main update dialog form 
		// Instantiate the updateStudentDialog that we will use
		updateStudentDialog = new DialogUpdateStudent();
		// Set its StudentManagementFrame reference to this object.
		updateStudentDialog.studentManagementFrame = this;
		/* END OF addStudentDialog */
		
		
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
				/* This update will be implemented after the GUI.
				String studentNumber = (String) studentTableModel.getValueAt(rowIndex, 0);
				Student student = studentRepository.getByStudentNumber(studentNumber);
			
				updateStudentDialog.initializeDialog(student);
				updateStudentDialog.setVisible(true);
				 */
			}
		});
		
		JComboBox cmbSubject = new JComboBox();
		cmbSubject.setModel(new DefaultComboBoxModel(new String[] {"Select Subject Here"}));
		cmbSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jpnlButtons.add(cmbSubject);
		jpnlButtons.add(jbtnViewGrade);
		/* END OF jbtnDelete */
		
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

	/*
	public void setStudentRepository(CRUDStudent studentRepository) {
		this.studentRepository = studentRepository;
		// Refresh the student table model immediately.
		studentTableModel.refresh();
	}

	public void setSubjectRepository(CRUDSubject subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	*/
}
