package com.microService.email.dto;

import java.util.UUID;

public record EmailDto(UUID usuarioId,String nome,String emailTo,String subject,String text) {

	public UUID usuarioId() {
		return usuarioId;
	}

	public String emailTo() {
		return emailTo;
	}
	
	public String nome() {
		return nome;
	}

	public String subject() {
		return subject;
	}

	public String text() {
		return text;
	}

	
	
	
}
