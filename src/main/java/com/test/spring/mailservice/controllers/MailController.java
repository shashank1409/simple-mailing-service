package com.test.spring.mailservice.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.mailservice.mailer.IMailer;
import com.test.spring.mailservice.models.Mail;

@RestController
public class MailController {
	
	private IMailer mailer;

	public MailController(IMailer smtpMailer) {
		this.mailer= smtpMailer;
	}

	
	@RequestMapping("/mail")
	public String mail() {
		Mail mail = new Mail("dixit.shashank1409@gmail.com", "Congratuations!!", "The mail you were trying to send is received successfully.\nRegards,\nShashank Dixit");
		return mailer.send(mail);
	}
	
}
