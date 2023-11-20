package com.microService.email.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.microService.email.enums.StatusEmail;
import com.microService.email.model.EmailModel;
import com.microService.email.repository.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
    @Autowired
	private EmailRepository emailRepository;
	
    @Autowired
    private JavaMailSender javaMailSender;

	public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
		super();
		this.emailRepository = emailRepository;
		this.javaMailSender = javaMailSender;
	}
    
    @Value(value = "${spring.mail.username}")
    private String emailDe;
    
    @Transactional
    public EmailModel enviarEmail(EmailModel emailModel) {
    	try {
			emailModel.setDataEnvioEmail(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailModel.getTexto());
		    javaMailSender.send(message);
		    emailModel.setStatusEmail(StatusEmail.ENVIADO);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERRO);
		} finally {
			return emailRepository.save(emailModel);
		}
    }
	
}
