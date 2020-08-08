package base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import base.error.ApiError;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(value= NoDataFoundException.class)
	public ResponseEntity handleNoDataFoundException() {
		return new ResponseEntity<>(new ApiError(400,"NO Data Found!"),HttpStatus.BAD_REQUEST);
	}

}
