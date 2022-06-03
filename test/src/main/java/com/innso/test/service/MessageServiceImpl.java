package com.innso.test.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innso.test.entity.Message;
import com.innso.test.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	@Transactional
	public Message createMessage(Message message) {
		message.setDateMessage(new Date(System.currentTimeMillis()));
		return messageRepository.save(message);
		
	}

}
