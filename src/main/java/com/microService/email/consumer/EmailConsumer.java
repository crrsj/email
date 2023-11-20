package com.microService.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.microService.email.dto.EmailDto;
import com.microService.email.model.EmailModel;
import com.microService.email.service.EmailService;

@Component
public class EmailConsumer {
	
	@Autowired
	private EmailService emailService;
 
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailDto dto) {
		System.out.println(dto.emailTo());
		var emailModel = new EmailModel();
		BeanUtils.copyProperties(dto, emailModel);
		emailService.enviarEmail(emailModel);
	}
	
	
}
