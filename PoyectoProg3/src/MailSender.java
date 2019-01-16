
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	
	private final String from = "GafasAmereS@gmail.com";
	private final String password = "gafasgafas99";
	private final String host = "smtp.gmail.com";
	private final String port = "587";
	private final String subject = "pedidos AMERE";
	private String to;
	
	private Properties props;

	
	public MailSender(String dest, String mens) {
		to = dest;
		props = new Properties();
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "false");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(mens.trim());
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
			System.out.println("Message sent to: " + to);
		} catch (Exception ex) {
			System.err.println("Error sending message: " + ex);
		}
		
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(from, password);
		}
	}
}