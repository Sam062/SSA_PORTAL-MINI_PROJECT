package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import base.exceptions.NoDataFoundException;
import base.service.SSNService;

@RestController
public class SSNValidater {
	@Autowired
	private SSNService service;

	@PostMapping("/validateSSN/{ssn}")
	public ResponseEntity<String> validateSSN(@PathVariable("ssn")String ssn) {
		Boolean isSSNExist = service.findBySSN(ssn);
		if(isSSNExist)
			return new ResponseEntity<String>("VALID",HttpStatus.OK);
		else
			throw new NoDataFoundException();

	}

}
