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

@RestController
public class SSNPortalRestController {
	@Autowired
	private SSNService service;

	@PostMapping(value = "/saveSsn", 
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"}
	)
	public ResponseEntity<HttpStatus> saveSSN(@RequestBody()UserModel model){
		UserEntity saveUser = service.saveUser(model);
		if(null!=saveUser)
			return new ResponseEntity<>(HttpStatus.CREATED);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}