package base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@PostMapping(value = "/saveSsn", 
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"}
			)
	public ResponseEntity<String> enroll(@RequestBody()UserModel model){
		UserEntity saveUser = service.saveUser(model);
		if(null!=saveUser)
			return new ResponseEntity<String>("Enrollment Successfull. SSN : "+saveUser.getSsn(),HttpStatus.CREATED);
		return new ResponseEntity<String>("Couldn't Enroll.",HttpStatus.BAD_REQUEST);
	}
}