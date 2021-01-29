package com.example.firstproject.controller;

import javax.mail.MessagingException;

//primary and component in set method
//Qualifier in constructor
//while using set method autowired and constructor  in comment


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.emailer.iEmailerService;

@RestController	
public class EmailServiceController {
//iEmailService emailService = new  DummyEmailSender();
	//Dont create any object with specific type
	//two primary bean cant be allowed
	//@Autowired
	iEmailerService emailservice;
	
// http://localhost:8080/sendemail
	@RequestMapping("/sendEmail")
	public String email() throws MessagingException {
		//call sendEMail method
		emailservice.sendEmail("navnath2018@gmail.com", "Launching of new Apple Model", "Body of the email");
		
		return "Email Sent";
	}
	/*@Autowired
	public EmailServiceController(@Qualifier("smtp") iEmailerService abc) {
		this.emailservice=abc;
	}*/
	/*@Autowired
		public EmailServiceController(@Qualifier("smtp") iEmailerService abc) {
			this.emailservice=abc;
		}
*/
	public iEmailerService getEmailservice() {
		return emailservice;
	}
	@Autowired
	public void setEmailservice(iEmailerService smtpEmailSender)
	{
		this.emailservice = smtpEmailSender;
	}
}
