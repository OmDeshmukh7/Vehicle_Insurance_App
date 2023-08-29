package com.insurance.vehicleInsurance.serviceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.vehicleInsurance.dao.DocumentsRepository;
import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.exception.DocumentException;
import com.insurance.vehicleInsurance.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService{

	@Autowired
	DocumentsRepository documentsRepository;
	
	@Override
	public Documents addDocument(Documents newDocument) throws DocumentException {
		Optional<Documents>documentOpt = this.documentsRepository.findById(newDocument.getDocumentId());
		if(documentOpt.isPresent()) {
			throw new DocumentException("Document already exists");
		}
		return this.documentsRepository.save(newDocument);
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
