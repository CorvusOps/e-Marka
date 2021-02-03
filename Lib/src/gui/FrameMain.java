package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class FrameMain extends JFrame {
	
	private JPanel jpnlContentPane;
	
	//private gui.entity.student PanelStudentManagement;
	
	private JPanel currentShownPanel;

	/**
	 * Create the frame.
	 */
	public FrameMain() {
		setTitle("E-Record Management System");
		setMinimumSize(new Dimension(800, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(null);
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnlSidebar = new JPanel();
		jpnlSidebar.setBackground(new Color(51, 51, 51));
		jpnlSidebar.setPreferredSize(new Dimension(175, 10));
		jpnlSidebar.setMinimumSize(new Dimension(175, 10));
		jpnlContentPane.add(jpnlSidebar, BorderLayout.WEST);
		jpnlSidebar.setLayout(new BoxLayout(jpnlSidebar, BoxLayout.Y_AXIS));
		
		JLabel jlblHeader = new JLabel("<html>Student Record Management System</html>");
		jlblHeader.setForeground(new Color(255, 255, 255));
		jlblHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
		jlblHeader.setFont(new Font("Montserrat", Font.BOLD, 13));
		jlblHeader.setAlignmentY(0.0f);
		jpnlSidebar.add(jlblHeader);
		
		jpnlSidebar.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton jbtnStudentsPanel = new JButton("Students");
		jbtnStudentsPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/** UPDATE: Later after GUI.
				 * if(currentShownPanel != null && currentShownPanel != studentManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = studentManagementPanel;
				add(studentManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
				*/
			}
		});
		jbtnStudentsPanel.setForeground(new Color(255, 255, 255));
		jbtnStudentsPanel.setBackground(new Color(51, 51, 51));
		jbtnStudentsPanel.setMinimumSize(new Dimension(75, 35));
		jbtnStudentsPanel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jbtnStudentsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnStudentsPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnStudentsPanel.setBorderPainted(false);
		jbtnStudentsPanel.setFocusPainted(false);
		jpnlSidebar.add(jbtnStudentsPanel);
		
		JButton jbtnSubjectsPanel = new JButton("Subjects");
		jbtnSubjectsPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/** UPDATE: Later after GUI.
				 * if(currentShownPanel != null && currentShownPanel != subjectManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = subjectManagementPanel;
				add(subjectManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
				*/
			}
		});
		jbtnSubjectsPanel.setMinimumSize(new Dimension(75, 35));
		jbtnSubjectsPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnSubjectsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSubjectsPanel.setForeground(Color.WHITE);
		jbtnSubjectsPanel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		jbtnSubjectsPanel.setFocusPainted(false);
		jbtnSubjectsPanel.setBorderPainted(false);
		jbtnSubjectsPanel.setBackground(new Color(51, 51, 51));
		jpnlSidebar.add(jbtnSubjectsPanel);
	}
	
	/*
	public void setStudentManagementPanel(gui.entity.student studentManagementPanel) {
		this.studentManagementPanel = PanelStudentManagement;
	}
	*/
	
	/* Update after on the process.
	public void setSubjectManagementPanel(com.github.queebskeleton.studentmanagement.ui.subject.ManagementPanel subjectManagementPanel) {
		this.subjectManagementPanel = subjectManagementPanel;
	}
	}
	*/

}
