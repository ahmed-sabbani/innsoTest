package com.innso.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innso.test.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Message findByNomAuteur(String nomAuteur);
	
}
