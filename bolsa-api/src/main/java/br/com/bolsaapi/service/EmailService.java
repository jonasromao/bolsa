package br.com.bolsaapi.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import br.com.bolsaapi.dto.EmailDTO;

@Component
public class EmailService {
	
	private String remetente = System.getenv("MAIL_REMETENTE");
	private String senha = System.getenv("MAIL_SENHA");

	public void sendMail( List<String> destinatarios, EmailDTO email ) {

		Session session = getSession( remetente, senha );

		try {
			Transport transport = session.getTransport( "smtp" );
			transport.connect( "smtp.gmail.com", 587, remetente, senha );
			sendEmail( transport, session, remetente, destinatarios, email );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		

		
	}

	private Message getMessage( Session session, String remetente, List<String> destinatarios, EmailDTO email ) throws AddressException, MessagingException {
		Message message = new MimeMessage( session );
		message.setFrom( new InternetAddress( remetente ) );

		StringBuilder strDestinarios = new StringBuilder();

		destinatarios.forEach( destinario -> {

			strDestinarios.append( destinario + "," );

		} );

		Address[] toUser = InternetAddress.parse( strDestinarios.toString() );

		message.setRecipients( Message.RecipientType.TO, toUser );
		message.setSubject( email.getTitulo() );

		message.setContent( email.getCorpo(), "text/html" );

		return message;
	}

	private void sendEmail( Transport transport, Session session, String remetente, List<String> destinatarios, EmailDTO email ) throws InterruptedException, AddressException, MessagingException {

		Message message = getMessage( session, remetente, destinatarios, email );

		Transport.send( message );

	}

	private Session getSession( final String remetente, final String senha ) {
		Properties prop = new Properties();

		prop.put( "mail.smtp.host", "smtp.gmail.com" );
		prop.put( "mail.smtp.port", "587" );
		prop.put( "mail.smtp.auth", "true" );
		prop.put( "mail.smtp.starttls.enable", "true" ); // TLS

		final PasswordAuthentication auth = new PasswordAuthentication( remetente, senha );

		Session session = Session.getInstance( prop, new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return auth;
			}
		} );

		/** Ativa Debug para sesso */
		session.setDebug( true );

		return session;
	}

}
