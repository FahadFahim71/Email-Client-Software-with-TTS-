package Email;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

public class HomePage extends LoginPage implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JButton btnCompose;
	JButton [] btn;
	JButton btnRefresh;
	int i; //counter variable
	int w; //variable to determine corresponding email number
	private JLabel lblRecentEmails;
	
	public HomePage(int x)
	{
		super(1);
	}
	public HomePage() throws MessagingException {
		super(1);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 868, 620);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		setTitle("Home Page");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCompose = new JButton("Compose ");
		btnCompose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCompose.setBackground(new Color(0, 128, 128));
		btnCompose.setBounds(12, 68, 106, 25);
		btnCompose.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(btnCompose);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBackground(new Color(0, 128, 128));
		btnRefresh.setBounds(12, 93, 106, 25);
		contentPane.add(btnRefresh);
		
		lblRecentEmails = new JLabel("Recent Emails");
		lblRecentEmails.setForeground(new Color(0, 0, 0));
		lblRecentEmails.setBackground(new Color(0, 128, 128));
		lblRecentEmails.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblRecentEmails.setBounds(265, 13, 202, 32);
		contentPane.add(lblRecentEmails);
			
		btnRefresh.addActionListener(this);

		w = messages.length - 10;
		int y=68;
		btn = new JButton[10];
		for (i=0; i<10; i++)
		{
		btn[i] = new JButton();
		btn[i].setBounds(158, y, 600, 25);
		btn[i].setBackground(new Color(0, 128, 128));
		btn[i].setText(messages[w+(9-i)].getFrom()[0].toString() + ": " + messages[w+(9-i)].getSubject());
		
		contentPane.add(btn[i]);

		btn[i].setVisible(true);
		
		btn[i].addActionListener(this);
		
		y=y+35;

		
		}
		System.out.println("------------");
	
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnCompose)
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Compose frame = new Compose();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if(e.getSource() == btnRefresh)
		{
			
					 
			 email = LoginPage.txtEnterEmail.getText();
		 password = LoginPage.passwordField.getText();
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
		else{
			w=messages.length-10;
		
		 if (e.getSource() == btn[0])
		{
	
						System.out.println("Button pressed");
						
						EventQueue.invokeLater(new Runnable() {
						public void run(){
						try {
							MessageShow frame = new MessageShow(w+(9-0));
							frame.setVisible(true);
						} catch (MessagingException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}}

						});
						
		}
		 else  if (e.getSource() == btn[1])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-1));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[2])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-2));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[3])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-3));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[4])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-4));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[5])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-5));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[6])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-6));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[7])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-7));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[8])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					MessageShow frame = new MessageShow(w+(9-8));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 else  if (e.getSource() == btn[9])
			{
				
				System.out.println("Button pressed");
				
				EventQueue.invokeLater(new Runnable() {
				public void run(){
				try {
					
					MessageShow frame = new MessageShow(w+(9-9));
					frame.setVisible(true);
				} catch (MessagingException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}

				});
				
			
			}
		 
		 
		}
}
}
