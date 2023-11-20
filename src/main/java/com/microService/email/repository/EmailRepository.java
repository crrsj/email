package com.microService.email.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microService.email.model.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel,UUID>{

}
