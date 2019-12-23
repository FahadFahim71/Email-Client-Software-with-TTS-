package Email;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import org.simplejavamail.converter.EmailConverter;
import org.simplejavamail.email.Email;

import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class MessageShow extends HomePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel subject;
	JLabel from;
	JTextArea text;
	Email emailMsg;
	JButton btnForwardEmail;
	JButton btnSpeak;
	JButton btnSpeak2;
	JButton btnSpeak3;
	TextArea textArea;
	int n; //to hold actual email number
	private JButton btnReply;

	
	
	
	public MessageShow(int w) throws MessagingException, IOException {
		super(1);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 831, 653);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel from = new JLabel(messages[w].getFrom()[0].toString());
		from.setFont(new Font("Tahoma", Font.BOLD, 15));
		from.setBounds(12, 13, 578, 16);
		contentPane.add(from);
		
		JLabel subject = new JLabel(messages[w].getSubject());
		subject.setBounds(12, 61, 578, 16);
		contentPane.add(subject);
		emailMsg = EmailConverter.mimeMessageToEmail( (MimeMessage) messages[w]);
		textArea = new TextArea(emailMsg.getPlainText() +"\n\n Attachments: " +emailMsg.getAttachments());
		textArea.setEditable(false);
		textArea.setBounds(10, 122, 580, 363);
		contentPane.add(textArea);
		
		btnForwardEmail = new JButton("Forward Email");
		btnForwardEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnForwardEmail.setBackground(new Color(0, 128, 128));
		btnForwardEmail.setBounds(12, 508, 160, 25);
		contentPane.add(btnForwardEmail);
		
		
		
		btnSpeak = new JButton("Read sender");
		btnSpeak.setBackground(new Color(0, 128, 128));
		btnSpeak.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSpeak.setBounds(602, 12, 139, 20);
		contentPane.add(btnSpeak);
		btnSpeak.addActionListener(this);
		
		btnSpeak2 = new JButton("Read Subject");
		btnSpeak2.setBackground(new Color(0, 128, 128));
		btnSpeak2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSpeak2.setBounds(602, 59, 139, 20);
		btnSpeak2.addActionListener(this);
		contentPane.add(btnSpeak2);
		
		btnSpeak3 = new JButton("Read text");
		btnSpeak3.setBackground(new Color(0, 128, 128));
		btnSpeak3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSpeak3.setBounds(644, 379, 97, 25);
		contentPane.add(btnSpeak3);
		
		btnReply = new JButton("Reply");
		btnReply.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReply.setBackground(new Color(0, 128, 128));
		btnReply.setBounds(12, 546, 97, 25);
		contentPane.add(btnReply);
		btnReply.addActionListener(this);
		
		btnSpeak3.addActionListener(this);
		
		btnForwardEmail.addActionListener(this);
		n = w;
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnForwardEmail)
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Compose frame = new Compose(messages[n].getSubject(), messages[n].getFrom()[0].toString(), (EmailConverter.mimeMessageToEmail( (MimeMessage) messages[n]).getPlainText()));
					
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else if (e.getSource() == btnSpeak)
		{
			try {
				speak(messages[n].getFrom()[0].toString());
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == btnSpeak2)
		{
			try {
				speak(messages[n].getSubject());
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == btnSpeak3)
		{
			speak(textArea.getSelectedText());
		}
		else if (e.getSource() == btnReply)
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Compose frame = new Compose(messages[n].getSubject(), messages[n].getFrom()[0].toString(), EmailConverter.mimeMessageToEmail( (MimeMessage) messages[n]).getPlainText(), messages[n].getFrom()[0].toString());
						frame.setVisible(true);
					} catch (MessagingException e1) {
						e1.printStackTrace();
					} 
				}
			});
			
		}

	}
}
