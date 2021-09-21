package tw.yayichen.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Object exceptionHandle(Exception e) {
		String msg1 = "error:" + e; 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg1);
	}
}
