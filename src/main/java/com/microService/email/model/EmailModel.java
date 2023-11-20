package com.microService.email.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.microService.email.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_EMAILS")
public class EmailModel implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID emailId;
private UUID usuarioId;
private String emailDe;
private String emailPara;
private String assunto;
@Column(columnDefinition = "TEXT")
private String texto;
private String dataEnvioEmail = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
private StatusEmail statusEmail;
public EmailModel(UUID emailId, UUID usuarioId, String emailDe, String emailPara, String assunto, String texto,
		String dataEnvioEmail, StatusEmail statusEmail) {
	
	this.emailId = emailId;
	this.usuarioId = usuarioId;
	this.emailDe = emailDe;
	this.emailPara = emailPara;
	this.assunto = assunto;
	this.texto = texto;
	this.dataEnvioEmail = dataEnvioEmail;
	this.statusEmail = statusEmail;
}
public EmailModel() {
	
}
public UUID getEmailId() {
	return emailId;
}
public void setEmailId(UUID emailId) {
	this.emailId = emailId;
}
public UUID getUsuarioId() {
	return usuarioId;
}
public void setUsuarioId(UUID usuarioId) {
	this.usuarioId = usuarioId;
}
public String getEmailDe() {
	return emailDe;
}
public void setEmailDe(String emailDe) {
	this.emailDe = emailDe;
}
public String getEmailPara() {
	return emailPara;
}
public void setEmailPara(String emailPara) {
	this.emailPara = emailPara;
}
public String getAssunto() {
	return assunto;
}
public void setAssunto(String assunto) {
	this.assunto = assunto;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getDataEnvioEmail() {
	return dataEnvioEmail;
}


public void setDataEnvioEmail(String dataEnvioEmail) {
	this.dataEnvioEmail = dataEnvioEmail;
}
public StatusEmail getStatusEmail() {
	return statusEmail;
}
public void setStatusEmail(StatusEmail statusEmail) {
	this.statusEmail = statusEmail;
}





}
