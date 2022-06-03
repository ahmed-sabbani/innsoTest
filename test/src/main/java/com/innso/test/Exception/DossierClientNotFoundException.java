package com.innso.test.Exception;

import javax.persistence.EntityNotFoundException;
/*
or NoSuchElementException
 */
public class DossierClientNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DossierClientNotFoundException(Long id) {
		super("Could not find Dossier Client " + id);
	}
}
