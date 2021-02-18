package gui.entity.student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Student;
import domain.Subject;

@SuppressWarnings("serial")
public class DialogCreateStudent extends JDialog {

private final JPanel contentPanel = new JPanel();
	
	/**
	 * The link to the student management frame that this Dialog is owned by.
	 * This is used to refer to the student repository object in there.
	 */
	protected PanelStudentManagement studentManagementFrame;
	private JTextField jtxtfldFirstName;
	private JTextField jtxtfldMiddleName;
	private JTextField jtxtfldLastName;
	private JTextField jtxtfldAddress;
	private JTextField jtxtfldSection;

	private Subject subject;

	/**
	 * Create the dialog.
	 */
	public DialogCreateStudent() {
		/* This Dialog's Properties */
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 250));
		setTitle("Add Student");
		setBounds(100, 100, 500, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		/* END OF jtxtfldStudentNumber */
	
		/* jlblFirstName - first name label */
		JLabel jlblFirstName = new JLabel("First Name:");
		jlblFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblFirstName = new GridBagConstraints();
		gbc_jlblFirstName.anchor = GridBagConstraints.EAST;
		gbc_jlblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblFirstName.gridx = 0;
		gbc_jlblFirstName.gridy = 0;
		contentPanel.add(jlblFirstName, gbc_jlblFirstName);
		/* END OF jlblFirstName */

		/* jtxtfldFirstName - first name input */
		jtxtfldFirstName = new JTextField();
		jtxtfldFirstName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldFirstName.setColumns(10);
		GridBagConstraints gbc_jtxtfldFirstName = new GridBagConstraints();
		gbc_jtxtfldFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldFirstName.gridx = 1;
		gbc_jtxtfldFirstName.gridy = 0;
		contentPanel.add(jtxtfldFirstName, gbc_jtxtfldFirstName);
		/* END OF jtxtfldFirstName */

		/* jlblMiddleName - middle name label */
		JLabel jlblMiddleName = new JLabel("Middle Name:");
		jlblMiddleName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblMiddleName = new GridBagConstraints();
		gbc_jlblMiddleName.anchor = GridBagConstraints.EAST;
		gbc_jlblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblMiddleName.gridx = 0;
		gbc_jlblMiddleName.gridy = 1;
		contentPanel.add(jlblMiddleName, gbc_jlblMiddleName);
		/* END OF jlblMiddleName */

		/* jtxtfldMiddleName - middle name input */
		jtxtfldMiddleName = new JTextField();
		jtxtfldMiddleName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldMiddleName.setColumns(10);
		GridBagConstraints gbc_jtxtMiddleName = new GridBagConstraints();
		gbc_jtxtMiddleName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtMiddleName.gridx = 1;
		gbc_jtxtMiddleName.gridy = 1;
		contentPanel.add(jtxtfldMiddleName, gbc_jtxtMiddleName);
		/* END OF jtxtfldMiddleName */
	
		/* jlblLastName - last name label */
		JLabel jlblLastName = new JLabel("Last Name:");
		jlblLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblLastName = new GridBagConstraints();
		gbc_jlblLastName.anchor = GridBagConstraints.EAST;
		gbc_jlblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblLastName.gridx = 0;
		gbc_jlblLastName.gridy = 2;
		contentPanel.add(jlblLastName, gbc_jlblLastName);
		/* END OF jlblLastName */
	
		/* jtxtfldLastName - last name input */
		jtxtfldLastName = new JTextField();
		jtxtfldLastName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldLastName.setColumns(10);
		GridBagConstraints gbc_jtxtfldLastName = new GridBagConstraints();
		gbc_jtxtfldLastName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldLastName.gridx = 1;
		gbc_jtxtfldLastName.gridy = 2;
		contentPanel.add(jtxtfldLastName, gbc_jtxtfldLastName);
		/* END OF jtxtfldLastName */

		/* jlblAddress - address label */
		JLabel jlblAddress = new JLabel("Address");
		jlblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblAddress = new GridBagConstraints();
		gbc_jlblAddress.anchor = GridBagConstraints.EAST;
		gbc_jlblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_jlblAddress.gridx = 0;
		gbc_jlblAddress.gridy = 3;
		contentPanel.add(jlblAddress, gbc_jlblAddress);
		/* END OF jlblAddress */
	
		/* jtxtfldAddress - address input */
		jtxtfldAddress = new JTextField();
		jtxtfldAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldAddress.setColumns(10);
		GridBagConstraints gbc_jtxtfldAddress = new GridBagConstraints();
		gbc_jtxtfldAddress.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldAddress.gridx = 1;
		gbc_jtxtfldAddress.gridy = 3;
		contentPanel.add(jtxtfldAddress, gbc_jtxtfldAddress);
		/* END OF jtxtfldAddress */
	
		/* jlblSection - section label */
		JLabel jlblSection = new JLabel("Section:");
		jlblSection.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblSection = new GridBagConstraints();
		gbc_jlblSection.anchor = GridBagConstraints.EAST;
		gbc_jlblSection.insets = new Insets(0, 0, 0, 5);
		gbc_jlblSection.gridx = 0;
		gbc_jlblSection.gridy = 4;
		contentPanel.add(jlblSection, gbc_jlblSection);
		/* END OF jlblSection */

		/* jtxtfldSection - section input */
		jtxtfldSection = new JTextField();
		jtxtfldSection.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldSection.setColumns(10);
		GridBagConstraints gbc_jtxtfldSection = new GridBagConstraints();
		gbc_jtxtfldSection.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldSection.gridx = 1;
		gbc_jtxtfldSection.gridy = 4;
		contentPanel.add(jtxtfldSection, gbc_jtxtfldSection);
		/* END OF jtxtfldSection */
	
		/* jpnlButtons - button actions panel */
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
				// Retrieve inputs, then create a Student object out of it
				Student student =
						new Student(
								jtxtfldFirstName.getText(),
								jtxtfldMiddleName.getText(),
								jtxtfldLastName.getText(),
								jtxtfldAddress.getText(),
								jtxtfldSection.getText(),
								(Subject) subject);

				clearFields();
				studentManagementFrame.studentRepository.save(student);
				JOptionPane.showMessageDialog(null, "Successfully saved student");
				studentManagementFrame.studentTableModel.refreshWithSubject(subject);
				setVisible(false);
			}
		});
		getRootPane().setDefaultButton(jbtnOk);
		/* END OF jbtnOk */
	

		/* jbtnCancel - hides this dialog box */
		JButton jbtnCancel = new JButton("Cancel");
		jbtnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
				setVisible(false);
			}
		});
		jpnlButtons.add(jbtnCancel);
		/* END OF jbtnCancel */
		
	}
	
	/**
	 * Clears the TextFields in this Dialog.
	 */
	private void clearFields() {
		jtxtfldFirstName.setText("");
		jtxtfldMiddleName.setText("");
		jtxtfldLastName.setText("");
		jtxtfldAddress.setText("");
		jtxtfldSection.setText("");
	}
	
	public void setSelectedSubject(Subject subject) {
		this.subject = subject;
	}
}
