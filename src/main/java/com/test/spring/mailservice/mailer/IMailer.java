package com.test.spring.mailservice.mailer;

import com.test.spring.mailservice.models.Mail;

public interface IMailer {
	public String send(Mail mail);
}
