package gui.entity.subject;

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

import repository.CRUDSubject;

public class PanelSubjectManagement extends JPanel {
	/** (Object Field / Instance Variable)
	 * The Add Dialog form that this frame opens everytime add button is clicked.
	 */
	private DialogCreateSubject addSubjectDialog;

	/** (Object Field / Instance Variable)
	 * The Update Dialog form that this frame opens everytime update button is clicked.
	 */
	private DialogUpdateSubject updateSubjectDialog;
	
	/** (Object Field / Instance Variable)
	 * The Subject Table of this frame.
	 */
	private JTable jtblSubject;
	
	/** (Object Field / Instance Variable)
	 * The main subject repository object that the frame interacts with, to save and retrieve data.
	 */
	
	protected CRUDSubject subjectRepository;

	/** (Object Field / Instance Variable)
	 * The TableModel that jtblSubject uses to show data.
	 */
	protected TemplateSubject subjectTableModel;

	/**
	 * Create the frame. All initialization is done when the object is constructed.
	 */

	public PanelSubjectManagement() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* addSubjectDialog - the main add dialog form */
		// Instantiate the addSubjectDialog that we will use
		addSubjectDialog = new DialogCreateSubject();
		// Set its SubjectManagementFrame reference to this object.
		addSubjectDialog.subjectManagementFrame = this;
		/* END OF addSubjectDialog */
		
		/* updateSubjectDialog - the main update dialog form */
		// Instantiate the updateSubjectDialog that we will use
		updateSubjectDialog = new DialogUpdateSubject();
		// Set its SubjectManagementFrame reference to this object.
		updateSubjectDialog.subjectManagementFrame = this;
		/* END OF addSubjectDialog */
		
		
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
		JLabel jlblHeader = new JLabel("Subject Management Panel");
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
		
		/* jbtnAdd - shows addSubjectDialog when clicked */
		JButton jbtnAdd = new JButton("Add");
		jbtnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addSubjectDialog.setVisible(true);
			}
		});
		jpnlButtons.add(jbtnAdd);
		/* END OF jbtnAdd */
		
		/* jbtnUpdate - updates a row in the JTable with a Dialog */
		JButton jbtnUpdate = new JButton("Update");
		jbtnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblSubject.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a subject first before updating.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				// empty
			}
		});
		jpnlButtons.add(jbtnUpdate);
		/* END OF jbtnUpdate */
		
		/* jbtnDelete - deletes a Subject depending on what's selected in the JTable */
		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = jtblSubject.getSelectedRow();
				
				if(rowIndex == -1) {
					JOptionPane.showMessageDialog(
							null,
							"Please select a subject first before deleting.",
							"Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		jpnlButtons.add(jbtnDelete);
		/* END OF jbtnDelete */
		
		/* jscrlpnMainTable - scrollable container for subject JTable */
		JScrollPane jscrlpnMainTable = new JScrollPane();
		jscrlpnMainTable.setAlignmentX(0.0f);
		add(jscrlpnMainTable);
		/* END OF jscrlpnMainTable */
		
		/* jtblSubject - table that shows the Subject in a tabular format */
		jtblSubject = new JTable();
		jtblSubject.setRowHeight(20);
		jtblSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		/* subjectTableModel - the main TableModel object that jtblSubject uses */
		subjectTableModel = new TemplateSubject();
		// Link this frame to the TableModel, so it can call subjectRepository here.
		subjectTableModel.subjectManagementFrame = this; 
		/* END OF subjectTableModel */
		jtblSubject.setModel(subjectTableModel);
		
		// Add the table to the scrollable container
		jscrlpnMainTable.setViewportView(jtblSubject);
		/* END OF jtblStudents */
	}
	/**
	 * Sets the global subject repository object
	 * that this frame, its SubjectTableModel, and AddSubjectDialog objects use.
	 *  
	 * @param subjectRepository the subject repository object to set.
	 */
	public void setSubjectRepository(CRUDSubject subjectRepository) {
		this.subjectRepository = subjectRepository;
		// Refresh the subject table model immediately.
		subjectTableModel.refresh();
	}

}
