package com.savio.algamoneyapi.resource.exception;

import javax.servlet.http.HttpServletRequest;

import com.savio.algamoneyapi.service.exception.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.savio.algamoneyapi.service.exception.ObjectNotFoundException;


/* classe responsavel por pegar as exptions do controller rest*/

@ControllerAdvice
public class ResouceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> DataIntegrityViolation(DataIntegrityViolationException e,
			HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
			HttpServletRequest request) {

		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de Validação",
				System.currentTimeMillis());
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.AddError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> ExceptionError(Exception e,
			HttpServletRequest request) {

		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),
				System.currentTimeMillis());
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	
	
}
