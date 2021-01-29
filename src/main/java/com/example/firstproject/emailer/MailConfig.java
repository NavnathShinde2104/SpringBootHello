	
//spring.profiles.active=zomato,dev

package com.example.firstproject.emailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

//This class will be use to configure the beans of DummyEmailSender.java and SMTPEmailerSender.java
//as we don't have source of SMTPEmailerSender.java and DummyEmailSender.java
//But we want to use them as spring bean

@Configuration

public class MailConfig {

	//iEmailService emailService = new  DummyEmailSender();	
	
	@Bean
	@Profile("dev")
	public iEmailerService dummyEmailSender()
	{
		return new DummyEmailSender();
	}
	
	@Bean
	@Profile("prod")
	public iEmailerService SMTPEmailSender(JavaMailSender javaMailSender)
	{
		return new SMTPEmailSender(javaMailSender);
	}
}
