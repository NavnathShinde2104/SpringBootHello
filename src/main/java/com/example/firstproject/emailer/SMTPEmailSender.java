package com.example.firstproject.emailer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
//@Primary
//@Qualifier("smtp")

public class SMTPEmailSender implements iEmailerService {

	private static Log log=LogFactory.getLog(SMTPEmailSender.class);
	private JavaMailSender javaMailSender;
	
	public SMTPEmailSender(JavaMailSender javaMailSender) {
		// TODO Auto-generated constructor stub
		this.javaMailSender=javaMailSender;
	}
	@Override
	public void sendEmail(String emailID, String subject, String mailContent) throws MessagingException {
		// TODO Auto-generated method stub
		log.info("SMTP mail receiver id:"+emailID);
		log.info("SMTP mail subject:"+subject);
		log.info("SMTP mail body:"+mailContent);
		log.warn("This is just a SMTP email sender");
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true); // true indicates
 					  				                   // multipart message
		helper.setSubject("This is test message");
		helper.setTo("navnath2018@gmail.com");
		helper.setText("<h1> Welcome to spring tool suite </h1>", true); // true indicates html

		// continue using helper for more functionalities
        // like adding attachments, etc.  
		
		javaMailSender.send(message);

	}
}