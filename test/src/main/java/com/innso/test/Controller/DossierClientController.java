package com.innso.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.innso.test.Exception.DossierClientNotFoundException;
import com.innso.test.Exception.MessageNotFoundException;
import com.innso.test.entity.DossierClient;
import com.innso.test.service.DossierClientService;

@RestController
@RequestMapping(value="/api/dossierClient", produces="application/json", consumes = "application/json")
public class DossierClientController {
	
	@Autowired
	private DossierClientService dossierClientService;
	
	@PostMapping(value = "/creation")
	ResponseEntity nouveauDossierClient(@RequestBody DossierClient dossierClientEntity,
			@RequestParam(name = "messageId") Long messageId) {
		
		try {
			return new ResponseEntity<DossierClient>(dossierClientService.creationDossierClient(dossierClientEntity, messageId), HttpStatus.OK);
		} catch(MessageNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}			 
	}
	
	@GetMapping(value = "/all")
	ResponseEntity<List<DossierClient>> getAllDossierClient() {
		
		return new ResponseEntity<List<DossierClient>>(dossierClientService.getAll(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/ajoutMessage")
	ResponseEntity ajoutMessage(@RequestParam(name = "dossierClientId") Long dossierClientId,
			@RequestParam(name = "messageId") Long messageId) {
		try {	
			return new ResponseEntity<DossierClient>(dossierClientService.rattacherMessageAuDossierClient(dossierClientId, messageId), HttpStatus.OK); 
		} catch(MessageNotFoundException | DossierClientNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}	
	}
	
	@PutMapping(value = "/ajoutReference")
	ResponseEntity ajoutReference(@RequestParam(name = "dossierClientId") Long dossierClientId,
			@RequestParam(name = "reference") String reference) {
	
		try {
			return new ResponseEntity<DossierClient>(dossierClientService.ajoutReferenceAuDossierClient(dossierClientId, reference), HttpStatus.OK);
		} catch(DossierClientNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}	
	}

}
