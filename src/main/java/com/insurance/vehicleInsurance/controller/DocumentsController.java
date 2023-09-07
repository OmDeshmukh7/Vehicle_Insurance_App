package com.insurance.vehicleInsurance.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.vehicleInsurance.entity.Documents;
import com.insurance.vehicleInsurance.exception.DocumentException;
import com.insurance.vehicleInsurance.service.DocumentService;

@RestController
public class DocumentsController {

	@Autowired
	DocumentService documentService;

	@PostMapping("/addDocument/")
	public Documents addDocument(@RequestBody Documents document) throws DocumentException {
		return this.documentService.addDocument(document);
	}

	@GetMapping("/findDocument/{id}")
	public Documents getDocumentById(@PathVariable Integer id) throws DocumentException {
		return this.documentService.getDocumentById(id);
	}

	@PutMapping("/updateDocument/")
	public ResponseEntity<Documents> replaceDocument(@RequestBody Documents updateDocument) throws DocumentException {
		Documents document = this.documentService.updateDocument(updateDocument);
		return new ResponseEntity<Documents>(document, HttpStatus.OK);
	}

	@DeleteMapping("/deleteDocument/{id}")
	public ResponseEntity<Documents> deleteDocumentById(@PathVariable Integer id) throws DocumentException {
		Documents document = this.documentService.deleteDocumentById(id);
		return new ResponseEntity<Documents>(document, HttpStatus.OK);
	}

	@GetMapping("/getAllCustomers/")
	@ResponseStatus(HttpStatus.OK)
	public List<Documents> getAllDocuments() {
		List<Documents> documentList = this.documentService.getAllDocuments();
		return documentList;
	}

}
