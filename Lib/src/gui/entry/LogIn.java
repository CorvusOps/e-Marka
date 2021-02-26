package gui.entry;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.FrameMain;
import repository.CRUDPerformanceTasks;
import java.awt.Color;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblMainHeader;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private String authUname;
	private String authPword;
	
	private FrameMain mainFrame;
	private JLabel lblNexgenAcademyInc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("LOG-IN TO E-MARKA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{471, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNexgenAcademyInc = new JLabel("e-Marka | NexGen Academy, Inc. ");
		lblNexgenAcademyInc.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNexgenAcademyInc = new GridBagConstraints();
		gbc_lblNexgenAcademyInc.insets = new Insets(0, 0, 5, 0);
		gbc_lblNexgenAcademyInc.gridx = 0;
		gbc_lblNexgenAcademyInc.gridy = 0;
		contentPane.add(lblNexgenAcademyInc, gbc_lblNexgenAcademyInc);
		
		lblMainHeader = new JLabel("You are entering a secured system. Input credentials below to continue.");
		lblMainHeader.setFont(new Font("Arial Narrow", Font.ITALIC, 16));
		GridBagConstraints gbc_lblMainHeader = new GridBagConstraints();
		gbc_lblMainHeader.insets = new Insets(0, 0, 5, 0);
		gbc_lblMainHeader.gridx = 0;
		gbc_lblMainHeader.gridy = 1;
		contentPane.add(lblMainHeader, gbc_lblMainHeader);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField(50);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txtUsername.setMinimumSize(new Dimension(250, 30));
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 0;
		gbc_txtUsername.gridy = 3;
		contentPane.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 4;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setMinimumSize(new Dimension(250, 30));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.gridx = 0;
		gbc_txtPassword.gridy = 5;
		contentPane.add(txtPassword, gbc_txtPassword);
		
		btnLogin = new JButton("Log-in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authUname = txtUsername.getText();
				char[] temp = txtPassword.getPassword();
				authPword = String.valueOf(temp);  
				
				if (authUname.contentEquals("admin") && authPword.contentEquals("admin")) {
					clearFields();
					JOptionPane.showMessageDialog(null, "Successful login! You can now access the system.", "Success!", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					mainFrame.setVisible(true);
				}
				
				else 
					JOptionPane.showMessageDialog(null, "Wrong Credentials! Try Again.", "Warning!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnLogin.setMaximumSize(new Dimension(100, 30));
		btnLogin.setMinimumSize(new Dimension(100, 30));
		btnLogin.setPreferredSize(new Dimension(70, 30));
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 6;
		contentPane.add(btnLogin, gbc_btnLogin);
	}

	public void clearFields() {
		txtUsername.setText("");
		txtPassword.setText("");
	}
	
	public void setMainFrame(FrameMain mainFrame) {
		this.mainFrame = mainFrame;
	}
}
