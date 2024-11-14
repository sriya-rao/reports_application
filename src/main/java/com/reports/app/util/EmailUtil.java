package com.reports.app.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Autowired
	JavaMailSender mailSender;
	
	
	public boolean sendEmail(String subject,String body, String to, File file) {
		try {
			
			MimeMessage message=mailSender.createMimeMessage();
			
			MimeMessageHelper helper=new MimeMessageHelper(message, true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);		
			helper.addAttachment("PlanInfo", file);
		 mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
