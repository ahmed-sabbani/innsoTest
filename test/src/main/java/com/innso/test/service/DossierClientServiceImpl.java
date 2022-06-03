package com.innso.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innso.test.Exception.DossierClientNotFoundException;
import com.innso.test.Exception.MessageNotFoundException;
import com.innso.test.entity.DossierClient;
import com.innso.test.entity.Message;
import com.innso.test.repository.DossierClientRepository;
import com.innso.test.repository.MessageRepository;

@Service
public class DossierClientServiceImpl implements DossierClientService {

	@Autowired
	private DossierClientRepository dossierClientRepository;
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public DossierClient creationDossierClient(DossierClient dossierClientEntity, Long messageId) throws MessageNotFoundException {

		Message message = messageRepository.findById(messageId)
				.orElseThrow(() -> new MessageNotFoundException(messageId));
				
		dossierClientEntity.setDateOuverture(new Date(System.currentTimeMillis()));
		dossierClientEntity.getMessages().add(message);
		return dossierClientRepository.save(dossierClientEntity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DossierClient> getAll() {
		return dossierClientRepository.findAll();
	}

	@Override
	@Transactional
	public DossierClient rattacherMessageAuDossierClient(Long dossierClientId, Long messageId) throws MessageNotFoundException, DossierClientNotFoundException {
		
		Message message = messageRepository.findById(messageId)
				.orElseThrow(() -> new MessageNotFoundException(messageId));
		
		DossierClient dossierClient = dossierClientRepository.findById(dossierClientId)
				.orElseThrow(() -> new DossierClientNotFoundException(dossierClientId));

		
		dossierClient.getMessages().add(message);
		return dossierClientRepository.save(dossierClient);
	}

	@Override
	@Transactional
	public DossierClient ajoutReferenceAuDossierClient(Long dossierClientId, String reference) throws DossierClientNotFoundException {
		
		DossierClient dossierClient = dossierClientRepository.findById(dossierClientId)
				.orElseThrow(() -> new DossierClientNotFoundException(dossierClientId));
		
		dossierClient.setReference(reference);
		
		return dossierClientRepository.save(dossierClient);
	}
		
}
