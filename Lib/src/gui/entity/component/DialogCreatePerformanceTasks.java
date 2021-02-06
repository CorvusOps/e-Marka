package gui.entity.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class DialogCreatePerformanceTasks extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtfldPTtitle;
	private JTextField txtfldPTtotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCreatePerformanceTasks dialog = new DialogCreatePerformanceTasks();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCreatePerformanceTasks() {
		setTitle("Add Performance Task");
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
			JLabel lblPTtitle = new JLabel("Title");
			lblPTtitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblPTtitle.setHorizontalTextPosition(SwingConstants.LEFT);
			lblPTtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblPTtitle = new GridBagConstraints();
			gbc_lblPTtitle.anchor = GridBagConstraints.WEST;
			gbc_lblPTtitle.insets = new Insets(0, 0, 5, 0);
			gbc_lblPTtitle.gridx = 0;
			gbc_lblPTtitle.gridy = 0;
			contentPanel.add(lblPTtitle, gbc_lblPTtitle);
		}
		{
			txtfldPTtitle = new JTextField();
			txtfldPTtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_txtfldPTtitle = new GridBagConstraints();
			gbc_txtfldPTtitle.insets = new Insets(0, 0, 5, 0);
			gbc_txtfldPTtitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldPTtitle.gridx = 0;
			gbc_txtfldPTtitle.gridy = 1;
			contentPanel.add(txtfldPTtitle, gbc_txtfldPTtitle);
			txtfldPTtitle.setColumns(10);
		}
		{
			JLabel lblPTtotal = new JLabel("Total");
			lblPTtotal.setHorizontalTextPosition(SwingConstants.LEFT);
			lblPTtotal.setHorizontalAlignment(SwingConstants.LEFT);
			lblPTtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			GridBagConstraints gbc_lblPTtotal = new GridBagConstraints();
			gbc_lblPTtotal.insets = new Insets(0, 0, 5, 0);
			gbc_lblPTtotal.anchor = GridBagConstraints.WEST;
			gbc_lblPTtotal.gridx = 0;
			gbc_lblPTtotal.gridy = 3;
			contentPanel.add(lblPTtotal, gbc_lblPTtotal);
		}
		{
			txtfldPTtotal = new JTextField();
			txtfldPTtotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			txtfldPTtotal.setColumns(10);
			GridBagConstraints gbc_txtfldPTtotal = new GridBagConstraints();
			gbc_txtfldPTtotal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtfldPTtotal.gridx = 0;
			gbc_txtfldPTtotal.gridy = 4;
			contentPanel.add(txtfldPTtotal, gbc_txtfldPTtotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SaveButton = new JButton("Save");
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
