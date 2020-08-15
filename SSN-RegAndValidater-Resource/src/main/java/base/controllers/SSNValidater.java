package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import base.exceptions.NoDataFoundException;
import base.service.SSNService;

@RestController
public class SSNValidater {
	@Autowired
	private SSNService service;

	@GetMapping(value = "/validateSSN/{ssn}", produces = "application/json")
	public ResponseEntity<String> validateSSN(@PathVariable("ssn")String ssn) {
		try {
			Boolean isSSNExist = service.findBySSN(ssn);
			if(isSSNExist)
				return new ResponseEntity<>("VALID",HttpStatus.OK);
			else {
				return new ResponseEntity<>("INVALID",HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			throw new NoDataFoundException();
		}
	}

}
