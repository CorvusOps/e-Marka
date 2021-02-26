package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.entry.LogIn;
import java.awt.Component;


@SuppressWarnings("serial")
public class FrameMain extends JFrame {
	
	private JPanel jpnlContentPane;
	
	private gui.entity.student.PanelStudentManagement studentManagementPanel;
	private gui.entity.subject.PanelSubjectManagement subjectManagementPanel;
	private gui.entity.grade.PanelGradeManagement gradeManagementPanel;
	private gui.entity.component.PanelComponentWW wwManagementPanel;
	private gui.entity.component.PanelComponentPT ptManagementPanel;
	private gui.entity.component.PanelComponentQA qaManagementPanel;
	private gui.entry.LogIn loginFrame;
	
	private JPanel currentShownPanel;
	private PanelWelcome welcomePanel = new PanelWelcome();

	/**
	 * Create the frame.
	 */
	public FrameMain() {
		setTitle("e-Marka | NexGen Academy");
		setMinimumSize(new Dimension(950, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		jpnlContentPane = new JPanel();
		jpnlContentPane.setBorder(null);
		setContentPane(jpnlContentPane);
		jpnlContentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpnlSidebar = new JPanel();
		jpnlSidebar.setBackground(new Color(55, 0, 55));
		jpnlSidebar.setPreferredSize(new Dimension(185, 10));
		jpnlSidebar.setMinimumSize(new Dimension(185, 10));
		jpnlContentPane.add(jpnlSidebar, BorderLayout.WEST);
		jpnlSidebar.setLayout(new BoxLayout(jpnlSidebar, BoxLayout.Y_AXIS));
		
		JLabel jlblHeader = new JLabel("<html> Electronic Grade Record System </html>");
		jlblHeader.setForeground(new Color(255, 255, 255));
		jlblHeader.setBorder(new EmptyBorder(10, 10, 10, 10));
		jlblHeader.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		jlblHeader.setAlignmentY(0.0f);
		jpnlSidebar.add(jlblHeader);
		
		if(currentShownPanel != null && currentShownPanel != welcomePanel)
			remove(currentShownPanel);
		currentShownPanel = welcomePanel;
		getContentPane().add(welcomePanel, BorderLayout.CENTER);
		
		Component rigidArea_1_1 = Box.createRigidArea(new Dimension(0, 10));
		jpnlSidebar.add(rigidArea_1_1);
		
		jpnlSidebar.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton jbtnStudentsPanel = new JButton("Students");
		jbtnStudentsPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != studentManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = studentManagementPanel;
				studentManagementPanel.refreshSubjectComboBox();
				getContentPane().add(studentManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		
		JLabel lblName = new JLabel("Welcome, Ms. CRUZ, K.S.");
		lblName.setMinimumSize(new Dimension(185, 16));
		lblName.setMaximumSize(new Dimension(185, 16));
		lblName.setPreferredSize(new Dimension(185, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Arial Narrow", Font.ITALIC, 16));
		lblName.setBackground(Color.DARK_GRAY);
		jpnlSidebar.add(lblName);
		
		JLabel lblNumber = new JLabel("(200600059)");
		lblNumber.setPreferredSize(new Dimension(185, 16));
		lblNumber.setMinimumSize(new Dimension(185, 16));
		lblNumber.setMaximumSize(new Dimension(185, 16));
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setForeground(Color.YELLOW);
		lblNumber.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 16));
		lblNumber.setBackground(Color.DARK_GRAY);
		jpnlSidebar.add(lblNumber);
		
		Component rigidArea3 = Box.createRigidArea(new Dimension(0, 10));
		jpnlSidebar.add(rigidArea3);
		
		Component rigidArea4 = Box.createRigidArea(new Dimension(0, 10));
		jpnlSidebar.add(rigidArea4);
		jbtnStudentsPanel.setForeground(new Color(255, 255, 255));
		jbtnStudentsPanel.setBackground(new Color(55, 0, 55));
		jbtnStudentsPanel.setMinimumSize(new Dimension(75, 35));
		jbtnStudentsPanel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jbtnStudentsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnStudentsPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnStudentsPanel.setBorderPainted(false);
		jbtnStudentsPanel.setFocusPainted(false);
		jpnlSidebar.add(jbtnStudentsPanel);
		
		JButton jbtnSubjectsPanel = new JButton("Subjects");
		jbtnSubjectsPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != subjectManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = subjectManagementPanel;
				getContentPane().add(subjectManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		jbtnSubjectsPanel.setMinimumSize(new Dimension(75, 35));
		jbtnSubjectsPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnSubjectsPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnSubjectsPanel.setForeground(Color.WHITE);
		jbtnSubjectsPanel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jbtnSubjectsPanel.setFocusPainted(false);
		jbtnSubjectsPanel.setBorderPainted(false);
		jbtnSubjectsPanel.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(jbtnSubjectsPanel);
		
		JButton jbtnGradesPanel = new JButton("Grades");
		jbtnGradesPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != gradeManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = gradeManagementPanel;
				gradeManagementPanel.refreshSubjectComboBox();
				getContentPane().add(gradeManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		jbtnGradesPanel.setMinimumSize(new Dimension(75, 35));
		jbtnGradesPanel.setMaximumSize(new Dimension(32767, 35));
		jbtnGradesPanel.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnGradesPanel.setForeground(Color.WHITE);
		jbtnGradesPanel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jbtnGradesPanel.setFocusPainted(false);
		jbtnGradesPanel.setBorderPainted(false);
		jbtnGradesPanel.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(jbtnGradesPanel);
		
		JLabel lblComponents = new JLabel("         Components");
		lblComponents.setHorizontalAlignment(SwingConstants.CENTER);
		lblComponents.setForeground(Color.WHITE);
		lblComponents.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblComponents.setBackground(Color.DARK_GRAY);
		jpnlSidebar.add(lblComponents);
		
		JButton jbtnComponentWW = new JButton("Written Works");
		jbtnComponentWW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != wwManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = wwManagementPanel;
				wwManagementPanel.refreshSubjectComboBox();
				getContentPane().add(wwManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		jbtnComponentWW.setMinimumSize(new Dimension(75, 35));
		jbtnComponentWW.setMaximumSize(new Dimension(32767, 35));
		jbtnComponentWW.setHorizontalAlignment(SwingConstants.LEFT);
		jbtnComponentWW.setForeground(Color.WHITE);
		jbtnComponentWW.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		jbtnComponentWW.setFocusPainted(false);
		jbtnComponentWW.setBorderPainted(false);
		jbtnComponentWW.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(jbtnComponentWW);
		
		JButton btnPerformanceTasks = new JButton("Performance Tasks");
		btnPerformanceTasks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != ptManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = ptManagementPanel;
				ptManagementPanel.refreshSubjectComboBox();
				getContentPane().add(ptManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		btnPerformanceTasks.setMinimumSize(new Dimension(75, 35));
		btnPerformanceTasks.setMaximumSize(new Dimension(32767, 35));
		btnPerformanceTasks.setHorizontalAlignment(SwingConstants.LEFT);
		btnPerformanceTasks.setForeground(Color.WHITE);
		btnPerformanceTasks.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnPerformanceTasks.setFocusPainted(false);
		btnPerformanceTasks.setBorderPainted(false);
		btnPerformanceTasks.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(btnPerformanceTasks);
		
		JButton btnQuarterlyAssessment = new JButton("Quarterly Assessment");
		btnQuarterlyAssessment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(currentShownPanel != null && currentShownPanel != qaManagementPanel)
					remove(currentShownPanel);
				currentShownPanel = qaManagementPanel;
				qaManagementPanel.refreshSubjectComboBox();
				getContentPane().add(qaManagementPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		btnQuarterlyAssessment.setMinimumSize(new Dimension(75, 35));
		btnQuarterlyAssessment.setMaximumSize(new Dimension(32767, 35));
		btnQuarterlyAssessment.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuarterlyAssessment.setForeground(Color.WHITE);
		btnQuarterlyAssessment.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnQuarterlyAssessment.setFocusPainted(false);
		btnQuarterlyAssessment.setBorderPainted(false);
		btnQuarterlyAssessment.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(btnQuarterlyAssessment);
		
		JLabel lblLogout = new JLabel("            Log-out");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		lblLogout.setBackground(Color.DARK_GRAY);
		jpnlSidebar.add(lblLogout);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to log-out?", "LOG-OUT OF E-MARKA", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Thank you for using the e-Marka system!", "Success!", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					currentShownPanel = welcomePanel;
					loginFrame.setVisible(true);
				} 
			}
		});
		btnLogout.setMinimumSize(new Dimension(75, 35));
		btnLogout.setMaximumSize(new Dimension(32767, 35));
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnLogout.setFocusPainted(false);
		btnLogout.setBorderPainted(false);
		btnLogout.setBackground(new Color(55, 0, 55));
		jpnlSidebar.add(btnLogout);
	}
	
	
	
	public void setStudentManagementPanel(gui.entity.student.PanelStudentManagement studentManagementPanel) {
		this.studentManagementPanel = studentManagementPanel;
	}
	

	public void setSubjectManagementPanel(gui.entity.subject.PanelSubjectManagement subjectManagementPanel) {
		this.subjectManagementPanel = subjectManagementPanel;
	}
	
	public void setGradeManagementPanel(gui.entity.grade.PanelGradeManagement gradeManagementPanel) {
		this.gradeManagementPanel = gradeManagementPanel;
	}
	
	public void setWWManagementPanel(gui.entity.component.PanelComponentWW wwManagementPanel) {
		this.wwManagementPanel = wwManagementPanel;
	}
	
	public void setPTManagementPanel(gui.entity.component.PanelComponentPT ptManagementPanel) {
		this.ptManagementPanel = ptManagementPanel;
	}

	public void setQAManagementPanel(gui.entity.component.PanelComponentQA qaManagementPanel) {
		this.qaManagementPanel = qaManagementPanel;
	}
	
	public void setLoginFrame(LogIn loginFrame) {
		this.loginFrame = loginFrame;
	}

}
