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

	@GetMapping(value = "/validateSSN/{ssn}")
	public ResponseEntity<String> validateSSN(@PathVariable("ssn")String ssn) {
		try {
			Boolean isSSNExist = service.findBySSN(ssn);
			if(isSSNExist) {
				System.out.println("VALID SSN");
				return new ResponseEntity<>("VALID",HttpStatus.OK);
			}
			else {
				System.out.println("INVALID SSN");
				return new ResponseEntity<>("INVALID",HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("CATCH BLOCK");
			throw new NoDataFoundException();
		}
	}

}
