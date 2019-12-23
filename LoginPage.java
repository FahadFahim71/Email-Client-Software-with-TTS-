package Email;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends MailFunctions implements ActionListener{
	 HomePage frame1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField txtEnterEmail;
	String email;
	String password;
	 JButton btnLogin; 
	static JPasswordField passwordField;
	int t = 0;
	public LoginPage(int x)
	{
		
	}
	
	public LoginPage() {
		super();
		setResizable(false);
		setForeground(SystemColor.textHighlight);
		setBackground(SystemColor.textHighlight);
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblEmail.setBounds(85, 135, 152, 32);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPassword.setBounds(85, 178, 152, 28);
		contentPane.add(lblPassword);
		
		txtEnterEmail = new JTextField();
		txtEnterEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterEmail.setBounds(249, 137, 277, 28);
		contentPane.add(txtEnterEmail);
		txtEnterEmail.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(SystemColor.activeCaptionBorder);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(249, 238, 277, 28);
		contentPane.add(btnLogin);
		
		JLabel lblWelcomeToEmail = new JLabel("Email Client Software");
		lblWelcomeToEmail.setForeground(new Color(0, 0, 0));
		lblWelcomeToEmail.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblWelcomeToEmail.setBounds(12, 13, 410, 42);
		contentPane.add(lblWelcomeToEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 179, 277, 28);
		contentPane.add(passwordField);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin)
		{
			
		
		 email = txtEnterEmail.getText();
		password = passwordField.getText();
		
		receiveMail(email, password);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					frame1 = new HomePage();
					frame1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
}
