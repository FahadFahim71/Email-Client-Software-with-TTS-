package Email;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import javax.swing.JButton;


public class MailFunctions extends TTS{
	//receive email block
	
	public MailFunctions() //default no argument constructor
	{
		
	}
	
	
	private static final long serialVersionUID = 1L;
		
		static Message messages[];
		 static Message message;
		 static Properties properties;
		 static Store emailStore;
		 static Folder emailFolder;
		 static Session emailSession;
		 static Flags seen;
		 static FlagTerm unseenFlagTerm;
		 static DataSource attach;
		 //static Email emailMsg;
		public static void receiveMail(String user, String password) 
		{  
			
			   System.out.println("Checking for emails");
			   //getting the session object
			   properties = new Properties();  
			   properties.setProperty("mail.store.protocol", "imaps");  
			   properties.setProperty("mail.smtp.ssl.enable", "imaps");  
			   emailSession = Session.getDefaultInstance(properties);  
			     
			   //IMAP store object  
			   try {
				emailStore = emailSession.getStore("imaps");
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			   try {
				   System.out.println("username: " + user);
				   System.out.println("password: " + password);
				emailStore.connect("imap.gmail.com", user, password);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

			   //creating the folder object and opening it
			   try {
				emailFolder = emailStore.getFolder("INBOX");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			   try {
				emailFolder.open(Folder.READ_WRITE);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	
			   try {
				messages = emailFolder.getMessages();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	  
	  
		
	//Send email block
		JButton compose = new JButton("Compose");
		static Transport tran;
		static Properties props;
		public static void sendMail(String username, String password, String subject, String to, String text, String file) throws AddressException, MessagingException{
			 
			 props = new Properties();
		      props.put("mail.smtp.auth", "true");
				 props.put("mail.smtp.starttls.enable", "true");
				 props.put("mail.smtp.host", "smtp.gmail.com");
				 props.put("mail.smtp.port", "587");
				 props.put("mail.from", username);
				 
		      // Getting the Session object.
		      Session session = Session.getInstance(props);

		     
		         // Creating a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Setting from email address
		         message.setFrom(new InternetAddress(username));

		         // Setting recipient email address
		         message.setRecipients(Message.RecipientType.TO,
		            InternetAddress.parse(to));

		         // Setting email subject
		         message.setSubject(subject);

		         // Creating the message part
		         BodyPart messageBodyPart = new MimeBodyPart();

		         // setting email text
		         messageBodyPart.setText(text);

		         // Creating a multipart message
		         Multipart multipart = new MimeMultipart();

		         // Set text message part
		         multipart.addBodyPart(messageBodyPart);

		         // Part two is attachment
		         messageBodyPart = new MimeBodyPart();
		         if(file.equals("No file")) //if no attachment is added
		         {
		         }
		         else 
		         {
		         String filename = file;
		         DataSource source = new FileDataSource(filename);
		         messageBodyPart.setDataHandler(new DataHandler(source));
		         messageBodyPart.setFileName(filename);
		         multipart.addBodyPart(messageBodyPart);
		         }

		         // setting the complete message parts
		         message.setContent(multipart);

		         // Sending the message
		          tran =  session.getTransport("smtp");
				 tran.connect("smtp.gmail.com", username, password);
		        tran.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

		         System.out.println("Sent message successfully....");
		  
			 
		}
}
