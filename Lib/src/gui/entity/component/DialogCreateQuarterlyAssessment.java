package gui.entity.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Insets;

public class DialogCreateQuarterlyAssessment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtfldQAtitle;
	private JTextField txtfldQAtotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCreateQuarterlyAssessment dialog = new DialogCreateQuarterlyAssessment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCreateQuarterlyAssessment() {
		setTitle("Add Quarterly Assessment");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblQAtitle = new JLabel("Title");
			lblQAtitle.setHorizontalTextPosition(SwingConstants.LEFT);
			lblQAtitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblQAtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblQAtitle = new GridBagConstraints();
			gbc_lblQAtitle.anchor = GridBagConstraints.WEST;
			gbc_lblQAtitle.insets = new Insets(0, 0, 5, 0);
			gbc_lblQAtitle.gridx = 0;
			gbc_lblQAtitle.gridy = 0;
			contentPanel.add(lblQAtitle, gbc_lblQAtitle);
		}
		{
			txtfldQAtitle = new JTextField();
			txtfldQAtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtfldQAtitle.setColumns(10);
			GridBagConstraints gbc_txtfldQAtitle = new GridBagConstraints();
			gbc_txtfldQAtitle.insets = new Insets(0, 0, 5, 0);
			gbc_txtfldQAtitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldQAtitle.gridx = 0;
			gbc_txtfldQAtitle.gridy = 1;
			contentPanel.add(txtfldQAtitle, gbc_txtfldQAtitle);
		}
		{
			JLabel lblQAtotal = new JLabel("Total");
			lblQAtotal.setHorizontalTextPosition(SwingConstants.LEFT);
			lblQAtotal.setHorizontalAlignment(SwingConstants.LEFT);
			lblQAtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblQAtotal = new GridBagConstraints();
			gbc_lblQAtotal.anchor = GridBagConstraints.WEST;
			gbc_lblQAtotal.insets = new Insets(0, 0, 5, 0);
			gbc_lblQAtotal.gridx = 0;
			gbc_lblQAtotal.gridy = 3;
			contentPanel.add(lblQAtotal, gbc_lblQAtotal);
		}
		{
			txtfldQAtotal = new JTextField();
			txtfldQAtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtfldQAtotal.setColumns(10);
			GridBagConstraints gbc_txtfldQAtotal = new GridBagConstraints();
			gbc_txtfldQAtotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldQAtotal.gridx = 0;
			gbc_txtfldQAtotal.gridy = 4;
			contentPanel.add(txtfldQAtotal, gbc_txtfldQAtotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SaveButton = new JButton("Save");
				SaveButton.setActionCommand("OK");
				buttonPane.add(SaveButton);
				getRootPane().setDefaultButton(SaveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
