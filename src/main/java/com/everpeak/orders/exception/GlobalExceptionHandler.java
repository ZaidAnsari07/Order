package com.everpeak.orders.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> handlerResourceNF(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		APIResponse response = APIResponse.builder().message(msg).success(false).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
	}
}
