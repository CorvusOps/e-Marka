package gui.entity.component;

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
import domain.WrittenWorks;

@SuppressWarnings("serial")
public class DialogCreateWW extends JDialog {

private final JPanel contentPanel = new JPanel();
	
	/**
	 * The link to the student management frame that this Dialog is owned by.
	 * This is used to refer to the student repository object in there.
	 */
	protected PanelComponentWW wwManagementFrame;
	
	// Input Fields
	private JTextField jtxtfldComponentTitle;
	private JTextField jtxtfldComponentTotal;
	private Subject subject;

	/**
	 * Create the dialog.
	 */
	public DialogCreateWW() {
		/* This Dialog's Properties */
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 150));
		setTitle("Add Written Work");
		setBounds(100, 100, 504, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		/* END OF dialog properties */
		
		/* jlblStudentNumber - student no. label */
		JLabel jlblComponentTitle = new JLabel("Title of Written Work :");
		jlblComponentTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblComponentTitle = new GridBagConstraints();
		gbc_jlblComponentTitle.insets = new Insets(0, 0, 5, 5);
		gbc_jlblComponentTitle.anchor = GridBagConstraints.EAST;
		gbc_jlblComponentTitle.gridx = 0;
		gbc_jlblComponentTitle.gridy = 0;
		contentPanel.add(jlblComponentTitle, gbc_jlblComponentTitle);
		/* END OF jlblStudentNumber */

		/* jtxtfldStudentNumber - student no. input */
		jtxtfldComponentTitle = new JTextField();
		jtxtfldComponentTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jtxtfldComponentTitle = new GridBagConstraints();
		gbc_jtxtfldComponentTitle.insets = new Insets(0, 0, 5, 0);
		gbc_jtxtfldComponentTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldComponentTitle.gridx = 1;
		gbc_jtxtfldComponentTitle.gridy = 0;
		contentPanel.add(jtxtfldComponentTitle, gbc_jtxtfldComponentTitle);
		jtxtfldComponentTitle.setColumns(10);
		/* END OF jtxtfldFirstName */

		/* jlblMiddleName - middle name label */
		JLabel jlblComponentTotal = new JLabel("Total :");
		jlblComponentTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GridBagConstraints gbc_jlblComponentTotal = new GridBagConstraints();
		gbc_jlblComponentTotal.anchor = GridBagConstraints.EAST;
		gbc_jlblComponentTotal.insets = new Insets(0, 0, 0, 5);
		gbc_jlblComponentTotal.gridx = 0;
		gbc_jlblComponentTotal.gridy = 1;
		contentPanel.add(jlblComponentTotal, gbc_jlblComponentTotal);
		/* END OF jlblMiddleName */

		/* jtxtfldMiddleName - middle name input */
		jtxtfldComponentTotal = new JTextField();
		jtxtfldComponentTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtxtfldComponentTotal.setColumns(10);
		GridBagConstraints gbc_jtxtfldComponentTotal = new GridBagConstraints();
		gbc_jtxtfldComponentTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtxtfldComponentTotal.gridx = 1;
		gbc_jtxtfldComponentTotal.gridy = 1;
		contentPanel.add(jtxtfldComponentTotal, gbc_jtxtfldComponentTotal);
		/* END OF jtxtfldSection */
	
		/* jpnlButtons - button actions panel */
		JPanel jpnlButtons = new JPanel();
		jpnlButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(jpnlButtons, BorderLayout.SOUTH);
		/* END OF jpnlButtons */

		/* jbtnOk - save student button */
		JButton jbtnAdd = new JButton("ADD");
		jbtnAdd.setActionCommand("OK");
		jpnlButtons.add(jbtnAdd);
		// When this button is clicked, execute actionPerformed
		jbtnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WrittenWorks writtenWorks =
						new WrittenWorks(
								jtxtfldComponentTitle.getText(),
								Float.parseFloat(jtxtfldComponentTotal.getText()),
								(Subject) subject);

				clearFields();
				wwManagementFrame.wwRepository.save(writtenWorks);
				JOptionPane.showMessageDialog(null, "Successfully saved!");
				wwManagementFrame.wwTableModel.refreshWithSubject(subject); 
				clearFields();
				setVisible(false);
			}
		});
		getRootPane().setDefaultButton(jbtnAdd);
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
	
	private void clearFields() {
		jtxtfldComponentTitle.setText("");
		jtxtfldComponentTotal.setText("");
	}
	
	public void setSelectedSubject(Subject subject) {
		this.subject = subject;
	}
}
