package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.DocumentsRepository;
import com.insurance.vehicleInsurance.dao.EndUserRepository;
import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.entity.EndUser;
import com.insurance.vehicleInsurance.exception.DocumentException;
import com.insurance.vehicleInsurance.service.DocumentService;

/*Implements all the methods related to documents adding document, getting document and deleting document*/

@Service
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	DocumentsRepository documentsRepository;
	
	@Autowired
	EndUserRepository endUserRepository;
	
	@Override
	public Documents addDocument(Documents newDocument) throws DocumentException {
		Optional<EndUser> endUserOpt = this.endUserRepository.findById(newDocument.getEndUserId());
		if(!endUserOpt.isPresent()) {
			throw new DocumentException("No Customer is present by this id.");
		}
		this.documentsRepository.save(newDocument);
		List<Documents> documents = new ArrayList<Documents>();
		documents.add(newDocument);
		EndUser endUser = endUserOpt.get();
		endUser.setDocuments(documents);
		this.endUserRepository.save(endUser);
		return newDocument;
	}

	@Override
	public Documents getDocumentById(Integer id) throws DocumentException {
		Optional<Documents> documentOpt = this.documentsRepository.findById(id);
		if(documentOpt == null) {
			throw new DocumentException("Document not found for id: "+id);
		}
		return documentOpt.get();
	}

	@Override
	public Documents updateDocument(Documents newDocument) throws DocumentException {
		if(newDocument == null) {
			throw new DocumentException("Please enter valid values.");
		}
		return this.documentsRepository.save(newDocument);
	}

	@Override
	public Documents deleteDocumentById(Integer id) throws DocumentException {
		Optional<Documents>documentOpt = this.documentsRepository.findById(id);
		if(documentOpt == null) {
			throw new DocumentException("Document not found to delete, id: "+id);
		}
		Documents document = documentOpt.get();
		this.documentsRepository.delete(document);
		return document;
	}

	@Override
	public List<Documents> getAllDocuments() {
		return this.documentsRepository.findAll();
	}

	

}
