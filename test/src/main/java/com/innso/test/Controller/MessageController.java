package com.innso.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.innso.test.Exception.MessageNotFoundException;
import com.innso.test.entity.Message;
import com.innso.test.service.MessageService;

@RestController
@RequestMapping(value="/api/message", produces="application/json", consumes = "application/json")
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@PostMapping("/creation")
	ResponseEntity<Message> nouveauMessage(@RequestBody Message messageEntity) {
	    return new ResponseEntity<Message>(messageService.createMessage(messageEntity), HttpStatus.OK);
	}
	
}
