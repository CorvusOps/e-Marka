package gui.entity.component;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import domain.Subject;
import repository.CRUDQuarterlyAssessment;
import repository.CRUDSubject;

@SuppressWarnings("serial")
public class PanelComponentQA extends JPanel {
	
	private DialogCreateQA createQADialog;
	private JTable jtblQA;
	protected TemplateQA qaTableModel;
	
	protected CRUDQuarterlyAssessment qaRepository;
	protected CRUDSubject subjectRepository;
	protected JComboBox cmbSubject;

	public PanelComponentQA() {
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setPreferredSize(new Dimension(625, 400));
		setMinimumSize(new Dimension(625, 400));
		
		/* addStudentDialog - the main add dialog form */
		// Instantiate the addStudentDialog that we will use
		createQADialog = new DialogCreateQA();
		// Set its StudentManagementFrame reference to this object.
		createQADialog.qaManagementFrame = this;
		/* END OF addStudentDialog
		
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
		JLabel jlblHeader = new JLabel("List of Quarterly Assessments");
		jlblHeader.setForeground(new Color(128, 0, 128));
		jlblHeader.setBackground(new Color(55, 0, 55));
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
		JButton jbtnCreateQA = new JButton("ADD QA");
		jbtnCreateQA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jbtnCreateQA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Subject subject = ((Subject) cmbSubject.getSelectedItem());
				createQADialog.setSelectedSubject(subject);
				createQADialog.setVisible(true);
			}
		});
		
		cmbSubject = new JComboBox();
		cmbSubject.setModel(new DefaultComboBoxModel(new String[] {"Select Subject Here"}));
		cmbSubject.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  refreshPanel();
		      }
		    };
		 
		cmbSubject.addItemListener(itemListener);
		
		jpnlButtons.add(cmbSubject);
		jpnlButtons.add(jbtnCreateQA);
		/* END OF jbtnDelete */
		
		/* jscrlpnMainTable - scrollable container for student JTable */
		JScrollPane jscrlpnMainTable = new JScrollPane();
		jscrlpnMainTable.setAlignmentX(0.0f);
		add(jscrlpnMainTable);
		/* END OF jscrlpnMainTable */
		
		/* jtblStudents - table that shows the Students in a tabular format */
		jtblQA = new JTable();
		jtblQA.setRowHeight(25);
		jtblQA.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		/* studentTableModel - the main TableModel object that jtblStudents uses */
		qaTableModel = new TemplateQA();
		// Link this frame to the TableModel, so it can call studentRepository here.
		qaTableModel.qaManagementFrame = this; 
		/* END OF studentTableModel */
		jtblQA.setModel(qaTableModel);
		
		// Add the table to the scrollable container
		jscrlpnMainTable.setViewportView(jtblQA);
		/* END OF jtblStudents */
	}

	public void setSubjectRepository(CRUDSubject subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	
	public void setQARepository(CRUDQuarterlyAssessment qaRepository) {
		this.qaRepository = qaRepository;
	}
	
	@SuppressWarnings("unchecked")
	public void refreshSubjectComboBox() {
		List<Subject> subjectList = subjectRepository.getAll();
		
		Subject[] subjectArray = new Subject[subjectList.size()];
		for(int i = 0; i < subjectList.size(); i++)
			subjectArray[i] = subjectList.get(i);
		
		cmbSubject.setModel(new DefaultComboBoxModel<Subject>(subjectArray));
	}
	
	public void refreshPanel() {
		Subject subject = (Subject) cmbSubject.getSelectedItem();
  	  	qaTableModel.refreshWithSubject(subject);
	}
}
