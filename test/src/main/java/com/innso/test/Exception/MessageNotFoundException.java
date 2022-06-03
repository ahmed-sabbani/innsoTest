package com.innso.test.Exception;

import javax.persistence.EntityNotFoundException;
/*
or NoSuchElementException
 */
public class MessageNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageNotFoundException(Long id) {
		super("Could not find Message " + id);
	}
}
