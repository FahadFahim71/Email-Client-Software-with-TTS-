package Email;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Color;
import java.awt.Font;

public class Compose extends HomePage implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField recep;
	private JLabel lblSubject;
	private JLabel lblText;
	private JButton btnSend;
	private JTextField subj;
	TextArea textArea;
	JFileChooser fc;

	
	//this constructor is invoked when Compose button is pressed
	public Compose() throws MessagingException {
		super(1);
		setTitle("Compose");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecepient = new JLabel("Recepient");
		lblRecepient.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecepient.setBounds(12, 13, 72, 16);
		contentPane.add(lblRecepient);
		
		recep = new JTextField();
		recep.setBounds(121, 10, 640, 22);
		contentPane.add(recep);
		recep.setColumns(10);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubject.setBounds(12, 54, 72, 16);
		contentPane.add(lblSubject);
		
		lblText = new JLabel("Text");
		lblText.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblText.setBounds(12, 102, 56, 16);
		contentPane.add(lblText);
		
		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSend.setBackground(new Color(0, 128, 128));
		btnSend.addActionListener(this);
		btnSend.setBounds(660, 454, 97, 25);
		contentPane.add(btnSend);
		
		subj = new JTextField();
		subj.setColumns(10);
		subj.setBounds(121, 51, 640, 22);
		contentPane.add(subj);
		
		textArea = new TextArea();
		textArea.setBounds(121, 102, 640, 316);
		contentPane.add(textArea);
		
		btnAddAttachment = new JButton("Add attachment..");
		btnAddAttachment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddAttachment.setBackground(new Color(0, 128, 128));
		btnAddAttachment.setBounds(121, 454, 154, 25);
		contentPane.add(btnAddAttachment);
		btnAddAttachment.addActionListener(this);
		
		fc = new JFileChooser();
		fc.setBounds(121, 444, 640, 250);
		
	}
	
	//this constructor is invoked when Forward button is pressed
	public Compose(String subject, String from, String text) throws MessagingException {
		super(1);
		setTitle("Compose");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 804, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecepient = new JLabel("Recepient");
		lblRecepient.setBounds(12, 13, 72, 16);
		contentPane.add(lblRecepient);
		
		recep = new JTextField();
		recep.setBounds(121, 10, 640, 22);
		contentPane.add(recep);
		recep.setColumns(10);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(12, 54, 72, 16);
		contentPane.add(lblSubject);
		
		lblText = new JLabel("Text");
		lblText.setBounds(12, 102, 56, 16);
		contentPane.add(lblText);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		btnSend.setBounds(660, 454, 97, 25);
		contentPane.add(btnSend);
		
		subj = new JTextField();
		subj.setColumns(10);
		subj.setBounds(121, 51, 640, 22);
		subj.setText("FWD from "+ "[" + from +"]" +" [" + subject +"]");
		contentPane.add(subj);
		
		textArea = new TextArea();
		textArea.setBounds(121, 102, 640, 316);
		textArea.setText("\n--------------\n"+ text +"\n--------------\n");
		contentPane.add(textArea);
		
		btnAddAttachment = new JButton("Add attachment..");
		btnAddAttachment.setBounds(121, 454, 154, 25);
		contentPane.add(btnAddAttachment);
		btnAddAttachment.addActionListener(this);
		
		fc = new JFileChooser();
		fc.setBounds(121, 444, 640, 250);
		
	}
	
	//this constructor is invoked when Reply button is pressed
	public Compose(String subject, String from, String text, String to) throws MessagingException {
		super(1);
		setTitle("Compose");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 804, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecepient = new JLabel("Recepient");
		lblRecepient.setBounds(12, 13, 72, 16);
		contentPane.add(lblRecepient);
		
		recep = new JTextField();
		recep.setBounds(121, 10, 640, 22);
		contentPane.add(recep);
		recep.setColumns(10);
		recep.setText(to);
		
		
		lblSubject = new JLabel("Subject");
		lblSubject.setBounds(12, 54, 72, 16);
		contentPane.add(lblSubject);
		
		lblText = new JLabel("Text");
		lblText.setBounds(12, 102, 56, 16);
		contentPane.add(lblText);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(this);
		btnSend.setBounds(660, 454, 97, 25);
		contentPane.add(btnSend);
		
		subj = new JTextField();
		subj.setColumns(10);
		subj.setBounds(121, 51, 640, 22);
		subj.setText("RE: " +" [" + subject +"] " + " [" + from + "] ");
		contentPane.add(subj);
		
		textArea = new TextArea();
		textArea.setBounds(121, 102, 640, 316);
		textArea.setText("\n--------------\n"+ text+"\n--------------\n");
		contentPane.add(textArea);
		
		btnAddAttachment = new JButton("Add attachment..");
		btnAddAttachment.setBounds(121, 454, 154, 25);
		contentPane.add(btnAddAttachment);
		btnAddAttachment.addActionListener(this);
		
		fc = new JFileChooser();
		fc.setBounds(121, 444, 640, 250);
		
	}
	
	
	String file = new String("No file"); //by default no attachment is to be added
	private JButton btnAddAttachment;
	public void addAttachment()
	{
		 int result = fc.showOpenDialog(null);
		    switch (result) {
		    case JFileChooser.APPROVE_OPTION:
		    	file = fc.getSelectedFile().getAbsolutePath();
				JOptionPane.showMessageDialog(null, file + " has been added as an attachment", "Attachment Info", JOptionPane.PLAIN_MESSAGE );
		      break;
		    case JFileChooser.CANCEL_OPTION:
		    	file = "No file";
				JOptionPane.showMessageDialog(null, "No attachment has been added", "Attachment Info", JOptionPane.PLAIN_MESSAGE );
		      break;
		    }
		   
		
	
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnSend)
		{
			EventQueue.invokeLater(new Runnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					try {
						String subject = subj.getText();
						String to = recep.getText();
						String text = textArea.getText();
						
						System.out.println(email);
						System.out.println(file);
						email = txtEnterEmail.getText();
						password = passwordField.getText();
						System.out.println("email = "+ email);
						System.out.println("password = "+ password);
						sendMail(email, password, subject, to, text, file);
						JOptionPane.showMessageDialog(null, "Email has been sent.", "Email Info", JOptionPane.PLAIN_MESSAGE );
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if (e.getSource()== btnAddAttachment)
		{
			System.out.println("Add attachment button clicked");
			addAttachment();
		}
		
	}
}
