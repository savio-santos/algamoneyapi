package com.savio.algamoneyapi.service.exception;

public class MyDataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyDataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyDataIntegrityViolationException(String message) {
		super(message);
	}

}
