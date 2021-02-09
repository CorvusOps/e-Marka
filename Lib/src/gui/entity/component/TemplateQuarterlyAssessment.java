package gui.entity.component;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class TemplateQuarterlyAssessment extends JPanel {

	private JPanel contentPane;
	private JTable jtblQA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateQuarterlyAssessment frame = new TemplateQuarterlyAssessment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TemplateQuarterlyAssessment() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane jscrlpnQATable = new JScrollPane();
		add(jscrlpnQATable);
		
		jtblQA = new JTable();
		jtblQA.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Total"
			}
		));
		jtblQA.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnQATable.setViewportView(jtblQA);
		
	}

}
