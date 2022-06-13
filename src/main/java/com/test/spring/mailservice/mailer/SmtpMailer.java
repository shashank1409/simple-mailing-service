package com.test.spring.mailservice.mailer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.test.spring.mailservice.models.Mail;

@Component
@Profile("prod")
public class SmtpMailer implements IMailer{
	
	JavaMailSender mailSender;
	
	@Autowired
	public SmtpMailer(JavaMailSender mailSender) {
		this.mailSender=mailSender;
	}

	private static Logger log = LogManager.getLogger(MockMailer.class);
	@Override
	public String send(Mail mail) {
		try {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper = new MimeMessageHelper(mimeMessage,true);
		
		helper.setSubject(mail.getSubject());
		helper.setTo(mail.getTo());
		helper.setText(mail.getBody(),true);
		mimeMessage.addHeader("X-Priority", "1");
		
		mailSender.send(mimeMessage);
		
		}catch(MessagingException ex) {
			log.error(ex);
			return "Could not sent mail";
		}
		log.info("Mail sent successfully");
		return "Mail sent successfully";
	}

}
