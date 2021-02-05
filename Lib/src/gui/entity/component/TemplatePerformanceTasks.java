package gui.entity.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class TemplatePerformanceTasks extends JPanel {

	private JPanel contentPane;
	private JTable jtblPT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplatePerformanceTasks frame = new TemplatePerformanceTasks();
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
	public TemplatePerformanceTasks() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane jscrlpnPTTable = new JScrollPane();
		add(jscrlpnPTTable);
		
		jtblPT = new JTable();
		jtblPT.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jtblPT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Total"
			}
		));
		jscrlpnPTTable.setViewportView(jtblPT);
		
	}

}
