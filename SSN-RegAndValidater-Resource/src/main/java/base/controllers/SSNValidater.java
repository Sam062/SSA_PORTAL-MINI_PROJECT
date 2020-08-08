package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import base.service.SSNService;

@RestController
public class SSNValidater {
	@Autowired
	private SSNService service;

	@PostMapping("/validateSSN/{ssn}")
	public ResponseEntity<String> validateSSN(@PathVariable("ssn")Long number) {
		Boolean isSSNExist = service.findBySSN(number);
		if(isSSNExist)
			return new ResponseEntity<String>("VALID",HttpStatus.OK);
		else
			return new ResponseEntity<String>("IN-VALID",HttpStatus.OK);

	}

}
