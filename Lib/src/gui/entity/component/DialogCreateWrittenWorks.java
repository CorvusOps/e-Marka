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

public class DialogCreateWrittenWorks extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtfldWWtitle;
	private JTextField txtfldWWtotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCreateWrittenWorks dialog = new DialogCreateWrittenWorks();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCreateWrittenWorks() {
		setTitle("Add Written Work");
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
			JLabel lblWWtitle = new JLabel("Title");
			lblWWtitle.setHorizontalTextPosition(SwingConstants.LEFT);
			lblWWtitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblWWtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblWWtitle = new GridBagConstraints();
			gbc_lblWWtitle.anchor = GridBagConstraints.WEST;
			gbc_lblWWtitle.insets = new Insets(0, 0, 5, 0);
			gbc_lblWWtitle.gridx = 0;
			gbc_lblWWtitle.gridy = 0;
			contentPanel.add(lblWWtitle, gbc_lblWWtitle);
		}
		{
			txtfldWWtitle = new JTextField();
			txtfldWWtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtfldWWtitle.setColumns(10);
			GridBagConstraints gbc_txtfldWWtitle = new GridBagConstraints();
			gbc_txtfldWWtitle.insets = new Insets(0, 0, 5, 0);
			gbc_txtfldWWtitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldWWtitle.gridx = 0;
			gbc_txtfldWWtitle.gridy = 1;
			contentPanel.add(txtfldWWtitle, gbc_txtfldWWtitle);
		}
		{
			JLabel lblWWtotal = new JLabel("Total");
			lblWWtotal.setHorizontalTextPosition(SwingConstants.LEFT);
			lblWWtotal.setHorizontalAlignment(SwingConstants.LEFT);
			lblWWtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblWWtotal = new GridBagConstraints();
			gbc_lblWWtotal.anchor = GridBagConstraints.WEST;
			gbc_lblWWtotal.insets = new Insets(0, 0, 5, 0);
			gbc_lblWWtotal.gridx = 0;
			gbc_lblWWtotal.gridy = 3;
			contentPanel.add(lblWWtotal, gbc_lblWWtotal);
		}
		{
			txtfldWWtotal = new JTextField();
			txtfldWWtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtfldWWtotal.setColumns(10);
			GridBagConstraints gbc_txtfldWWtotal = new GridBagConstraints();
			gbc_txtfldWWtotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldWWtotal.gridx = 0;
			gbc_txtfldWWtotal.gridy = 4;
			contentPanel.add(txtfldWWtotal, gbc_txtfldWWtotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
