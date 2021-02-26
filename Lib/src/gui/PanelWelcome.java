package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelWelcome extends JPanel {

	public PanelWelcome() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel pnlWelcomeMessage = new JPanel();
		add(pnlWelcomeMessage);
		GridBagLayout gbl_pnlWelcomeMessage = new GridBagLayout();
		gbl_pnlWelcomeMessage.columnWidths = new int[]{0, 0};
		gbl_pnlWelcomeMessage.rowHeights = new int[]{234, 0, 0, 0};
		gbl_pnlWelcomeMessage.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlWelcomeMessage.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlWelcomeMessage.setLayout(gbl_pnlWelcomeMessage);
		
		JLabel lblNewLabel = new JLabel("Welcome Back to e-Marka!");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 45));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		pnlWelcomeMessage.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblPolytechniv_1_1 = new JLabel("also known as the Electronic Grade Record System");
		lblPolytechniv_1_1.setForeground(Color.GRAY);
		lblPolytechniv_1_1.setFont(new Font("Segoe UI", Font.ITALIC, 25));
		GridBagConstraints gbc_lblPolytechniv_1_1 = new GridBagConstraints();
		gbc_lblPolytechniv_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPolytechniv_1_1.gridx = 0;
		gbc_lblPolytechniv_1_1.gridy = 1;
		pnlWelcomeMessage.add(lblPolytechniv_1_1, gbc_lblPolytechniv_1_1);
		
		JLabel lblPolytechniv_1 = new JLabel("NEXGEN ACADEMY (C) 2021");
		lblPolytechniv_1.setForeground(Color.GRAY);
		lblPolytechniv_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblPolytechniv_1 = new GridBagConstraints();
		gbc_lblPolytechniv_1.gridx = 0;
		gbc_lblPolytechniv_1.gridy = 2;
		pnlWelcomeMessage.add(lblPolytechniv_1, gbc_lblPolytechniv_1);

	}

}
