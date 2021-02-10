package gui.entity.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class PanelComponentPT extends JPanel {
	
	private DialogCreatePT createPTDialog;
	private JTable jtblPT;
	protected TemplatePT ptTableModel;

	public PanelComponentPT() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* addStudentDialog - the main add dialog form */
		// Instantiate the addStudentDialog that we will use
		createPTDialog = new DialogCreatePT();
		// Set its StudentManagementFrame reference to this object.
		createPTDialog.ptManagementFrame = this;
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
		JLabel jlblHeader = new JLabel("Performance Task Panel");
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
		JButton jbtnCreatePT = new JButton("ADD PT");
		jbtnCreatePT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnCreatePT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblPT.getSelectedRow();
				
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
		jpnlButtons.add(jbtnCreatePT);
		/* END OF jbtnDelete */
		
		/* jscrlpnMainTable - scrollable container for student JTable */
		JScrollPane jscrlpnMainTable = new JScrollPane();
		jscrlpnMainTable.setAlignmentX(0.0f);
		add(jscrlpnMainTable);
		/* END OF jscrlpnMainTable */
		
		/* jtblStudents - table that shows the Students in a tabular format */
		jtblPT = new JTable();
		jtblPT.setRowHeight(20);
		jtblPT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/* studentTableModel - the main TableModel object that jtblStudents uses */
		ptTableModel = new TemplatePT();
		// Link this frame to the TableModel, so it can call studentRepository here.
		ptTableModel.ptManagementFrame = this; 
		/* END OF studentTableModel */
		jtblPT.setModel(ptTableModel);
		
		// Add the table to the scrollable container
		jscrlpnMainTable.setViewportView(jtblPT);
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
