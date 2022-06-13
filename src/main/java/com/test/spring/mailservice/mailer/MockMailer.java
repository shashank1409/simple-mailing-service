package com.test.spring.mailservice.mailer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.test.spring.mailservice.models.Mail;

@Component
@Profile("dev")
public class MockMailer implements IMailer {

	private static Logger log = LogManager.getLogger(MockMailer.class);
	@Override
	public String send(Mail mail) {
		
		log.debug("Entered "+this.getClass());
		
		log.info("Mail sent to "+mail.getTo());
		log.info("Mail sent with subject "+mail.getSubject());
		log.info("Mail sent with body "+mail.getBody());
		return "Mail sent";
	}

}
