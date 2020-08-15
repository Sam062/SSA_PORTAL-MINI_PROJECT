package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import base.entity.UserEntity;
import base.model.UserModel;
import base.service.SSNService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("This SSN Rest Controller.")
public class SSNEnrollmentRestController {
	@Autowired
	private SSNService service;

	@ApiOperation("This Resource is used to Create SSN record in Database.")
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/saveSsn", 
	consumes = "application/json"
			)
	public ResponseEntity<String> enroll(@RequestBody UserModel model){
		System.out.println(model);
		UserEntity saveUser = service.saveUser(model);
		String body="Your SSN Enrollment Completed Successfully. SSN : "+saveUser.getSsn();
		return new ResponseEntity<String>(body,HttpStatus.CREATED);
	}
}