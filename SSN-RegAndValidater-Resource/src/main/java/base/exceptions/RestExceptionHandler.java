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
	public ResponseEntity<ApiError> handleNoDataFoundException() {
		return new ResponseEntity<ApiError>(new ApiError(400,"Bad Request!"),HttpStatus.BAD_REQUEST);
	}

}
