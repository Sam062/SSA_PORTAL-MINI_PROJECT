package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import base.service.SSNService;

@RestController
public class SSNValidater {
	@Autowired
	private SSNService service;

	@PostMapping("/validateSSN/{ssn}")
	public @ResponseBody String validateSSN(@PathVariable("ssn")Long number) {
		Boolean isSSNExist = service.findBySSN(number);
		if(isSSNExist)
			return "GIVEN SSN IS VALID.";
		else
			return "PLEASE ENROLL FOR SSN AND TRY AGAIN";

	}

}
