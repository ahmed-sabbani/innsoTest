package com.innso.test.service;

import java.util.List;

import com.innso.test.Exception.DossierClientNotFoundException;
import com.innso.test.Exception.MessageNotFoundException;
import com.innso.test.entity.DossierClient;

public interface DossierClientService {

	DossierClient creationDossierClient(DossierClient dossierClientEntity, Long messageId) throws MessageNotFoundException;
	
	List<DossierClient> getAll();
	
	DossierClient rattacherMessageAuDossierClient(Long dossierClientId, Long messageId) throws MessageNotFoundException, DossierClientNotFoundException;
	
	DossierClient ajoutReferenceAuDossierClient(Long dossierClientId, String reference) throws DossierClientNotFoundException;
}
