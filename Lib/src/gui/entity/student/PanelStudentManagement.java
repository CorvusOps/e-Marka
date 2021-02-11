package gui.entity.student;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import domain.Student;
import domain.Subject;
import repository.CRUDStudent;
import repository.CRUDSubject;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class PanelStudentManagement extends JPanel {
	/** (Object Field / Instance Variable)
	 * The Add Dialog form that this frame opens everytime add button is clicked.
	 */
	private DialogCreateStudent addStudentDialog;

	/** (Object Field / Instance Variable)
	 * The Add Dialog form that this frame opens everytime add button is clicked.
	 */
	private DialogUpdateStudent updateStudentDialog;
	
	/** (Object Field / Instance Variable)
	 * The Student Table of this frame.
	 */
	private JTable jtblStudents;
	
	/** (Object Field / Instance Variable)
	 * The main student repository object that the frame interacts with, to save and retrieve data.
	 */
	protected CRUDStudent studentRepository;
	
	protected CRUDSubject subjectRepository;

	/** (Object Field / Instance Variable)
	 * The TableModel that jtblStudents uses to show data.
	 */
	protected TemplateStudent studentTableModel;
	protected JComboBox cmbSubject;

	/**
	 * Create the frame. All initialization is done when the object is constructed.
	 */

	public PanelStudentManagement() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* addStudentDialog - the main add dialog form */
		// Instantiate the addStudentDialog that we will use
		addStudentDialog = new DialogCreateStudent();
		// Set its StudentManagementFrame reference to this object.
		addStudentDialog.studentManagementFrame = this;
		/* END OF addStudentDialog */
		
		/* updateStudentDialog - the main update dialog form */
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
		JLabel jlblHeader = new JLabel("Student Panel");
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
		/* END OF jpnlButtons */
		
		/* jbtnAdd - shows addStudentDialog when clicked */
		JButton jbtnAdd = new JButton("Add");
		jbtnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addStudentDialog.refreshSubjectComboBox();
				addStudentDialog.setVisible(true);
			}
		});
		
		cmbSubject = new JComboBox();
		cmbSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		jpnlButtons.add(cmbSubject);
		jpnlButtons.add(jbtnAdd);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  Subject subject = (Subject) cmbSubject.getSelectedItem();
		    	  studentTableModel.refreshWithSubject(subject);
		      }
		    };
		 
		cmbSubject.addItemListener(itemListener);
		
		/* jbtnUpdate - updates a row in the JTable with a Dialog */
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblStudents.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a student first before updating.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String studentNumber = (String) studentTableModel.getValueAt(rowIndex, 0);
				Student student = studentRepository.getByStudentNumber(studentNumber);
			
				updateStudentDialog.initializeDialog(student);
				updateStudentDialog.setVisible(true);
			}
		});
		jpnlButtons.add(jbtnUpdate);
		/* END OF jbtnUpdate */
		
		/* jbtnDelete - deletes a Student depending on what's selected in the JTable */
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblStudents.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a student first before deleting.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				if(JOptionPane.showConfirmDialog(null, "Are you sure?") == JOptionPane.YES_OPTION) {
					String studentNumber = (String) studentTableModel.getValueAt(rowIndex, 0);
					studentRepository.deleteByStudentNumber(studentNumber);
					studentTableModel.refresh();
				} 
			}
		});
		jpnlButtons.add(jbtnDelete);
		/* END OF jbtnDelete */
		
		/* jscrlpnMainTable - scrollable container for student JTable */
		JScrollPane jscrlpnMainTable = new JScrollPane();
		jscrlpnMainTable.setAlignmentX(0.0f);
		add(jscrlpnMainTable);
		/* END OF jscrlpnMainTable */
		
		/* jtblStudents - table that shows the Students in a tabular format */
		jtblStudents = new JTable();
		jtblStudents.setRowHeight(20);
		jtblStudents.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/* studentTableModel - the main TableModel object that jtblStudents uses */
		studentTableModel = new TemplateStudent();
		// Link this frame to the TableModel, so it can call studentRepository here.
		studentTableModel.studentManagementFrame = this; 
		/* END OF studentTableModel */
		jtblStudents.setModel(studentTableModel);
		
		// Add the table to the scrollable container
		jscrlpnMainTable.setViewportView(jtblStudents);
		/* END OF jtblStudents */
	}
	/**
	 * Sets the global student repository object
	 * that this frame, its StudentTableModel, and AddStudentDialog objects use.
	 *  
	 * @param studentRepository the student repository object to set.
	 */
	public void setStudentRepository(CRUDStudent studentRepository) {
		this.studentRepository = studentRepository;
		studentTableModel.refresh();
	}

	public void setSubjectRepository(CRUDSubject subjectRepository) {
		this.subjectRepository = subjectRepository;
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
