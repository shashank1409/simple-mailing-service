package com.test.spring.mailservice.controllers;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.mailservice.mailer.IMailer;
import com.test.spring.mailservice.models.Mail;

@RestController
public class MailController {
	
	private IMailer mailer;

	public MailController(IMailer smtpMailer) {
		this.mailer= smtpMailer;
	}

	
	@RequestMapping(value="/mail", method = RequestMethod.POST)
	public String mail(@RequestBody Mail mail) {
		return mailer.send(mail);
	}
	
}
