package gui.entity.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class TemplateWrittenWorks extends JPanel{

	private JPanel contentPane;
	private JTable jtblWW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemplateWrittenWorks frame = new TemplateWrittenWorks();
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
	public TemplateWrittenWorks() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JScrollPane jscrlpnWWTable = new JScrollPane();
		add(jscrlpnWWTable);
		
		jtblWW = new JTable();
		jtblWW.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Total"
			}
		));
		jtblWW.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jscrlpnWWTable.setViewportView(jtblWW);
		
	}

}
