package com.example.firstproject.emailer;

import javax.mail.MessagingException;

public interface iEmailerService {
	void sendEmail(String emailID,String subject,String mailContent)throws MessagingException;
}
