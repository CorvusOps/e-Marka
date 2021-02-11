package gui.entity.subject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.Subject;

@SuppressWarnings("serial")
public class DialogCreateSubject extends JDialog {

private final JPanel contentPanel = new JPanel();
	
	/**
	 * The link to the subject management frame that this Dialog is owned by.
	 * This is used to refer to the subject repository object in there.
	 */
	protected PanelSubjectManagement subjectManagementFrame;
	private JTextField jtxtfldName;
	private JTextField jtxtfldDescription;

	/**
	 * Create the dialog.
	 */
	public DialogCreateSubject() {
		/* This Dialog's Properties */
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 300));
		setTitle("Add Subject");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		/* END OF jtxtfldSubjectNumber */
	
		/* jlblName - name label */
		JLabel jlblName = new JLabel("Name:");
		jlblName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblName = new GridBagConstraints();
		gbc_jlblName.anchor = GridBagConstraints.EAST;
		gbc_jlblName.insets = new Insets(0, 0, 5, 5);
		gbc_jlblName.gridx = 0;
		gbc_jlblName.gridy = 0;
		contentPanel.add(jlblName, gbc_jlblName);
		/* END OF jlblName */

		/* jtxtfldName - name input */
		jtxtfldName = new JTextField();
		jtxtfldName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldName.setColumns(10);
		GridBagConstraints gbc_jtxtfldName = new GridBagConstraints();
		gbc_jtxtfldName.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldName.gridx = 1;
		gbc_jtxtfldName.gridy = 0;
		contentPanel.add(jtxtfldName, gbc_jtxtfldName);
		/* END OF jtxtfldName */

		/* jlblDescription - description label */
		JLabel jlblDescription = new JLabel("Description:");
		jlblDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblDescription = new GridBagConstraints();
		gbc_jlblDescription.anchor = GridBagConstraints.EAST;
		gbc_jlblDescription.insets = new Insets(0, 0, 0, 5);
		gbc_jlblDescription.gridx = 0;
		gbc_jlblDescription.gridy = 1;
		contentPanel.add(jlblDescription, gbc_jlblDescription);
		/* END OF jlblDescription */

		/* jtxtfldDescription - description input */
		jtxtfldDescription = new JTextField();
		jtxtfldDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldDescription.setColumns(10);
		GridBagConstraints gbc_jtxtfldDescription = new GridBagConstraints();
		gbc_jtxtfldDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldDescription.gridx = 1;
		gbc_jtxtfldDescription.gridy = 1;
		contentPanel.add(jtxtfldDescription, gbc_jtxtfldDescription);
		/* END OF jtxtfldDescription */
	
		/* jpnlButtons - button actions panel */
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtons, BorderLayout.SOUTH);
		/* END OF jpnlButtons */

		/* jbtnOk - save subject button */
		JButton jbtnOk = new JButton("OK");
		jbtnOk.setActionCommand("OK");
		jpnlButtons.add(jbtnOk);
		// When this button is clicked, execute actionPerformed
		jbtnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Subject subject =
						new Subject(jtxtfldName.getText(), jtxtfldDescription.getText());

				clearFields();
				subjectManagementFrame.subjectRepository.save(subject);
				JOptionPane.showMessageDialog(null, "Successfully saved subject!", "Success!", EXIT_ON_CLOSE);
				

				subjectManagementFrame.subjectTableModel.refresh();
				
				clearFields();
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
		jtxtfldName.setText("");
		jtxtfldDescription.setText("");
	}

}
