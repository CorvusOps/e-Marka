package gui.entity.grade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class DialogViewGrade extends JDialog {
	
	/**
	 * The link to the student management frame that this Dialog is owned by.
	 * This is used to refer to the student repository object in there.
	 */
	protected PanelGradeManagement gradeManagementFrame;

	/**
	 * Create the dialog.
	 */
	public DialogViewGrade() {
		/* This Dialog's Properties */
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 300));
		setTitle("Update Grade");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		/* END OF jtxtfldSection */
	
		/* jpnlButtons - button actions panel */
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel jpnlGrades = new JPanel();
		scrollPane.setViewportView(jpnlGrades);
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtons, BorderLayout.SOUTH);
		/* END OF jpnlButtons */

		/* jbtnOk - save student button */
		JButton jbtnOk = new JButton("OK");
		jbtnOk.setActionCommand("OK");
		jpnlButtons.add(jbtnOk);
		// When this button is clicked, execute actionPerformed
		jbtnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		getRootPane().setDefaultButton(jbtnOk);
		/* END OF jbtnOk */
	

		/* jbtnCancel - hides this dialog box */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		jpnlButtons.add(jbtnCancel);
		/* END OF jbtnCancel */
		
	}
	
	public void gradeList() {
		
	}
	
	/**
	 * Initialize a method 
	 * 		accept a grade object 
	 * 		OK: step 1: retrieve the grade of student from crudgrade by studentNumber
	 * 		OK: step 2: retrieve components 
	 * 		step 3: loop the component objects / make jlabel = title and jtext field = actual grade
	 * 		step 4: set text / jtextfield at current grade at the component 
	 * 		step 6: revalidated hierarchy 
	 * 
	 *  
	 * */
	
}
