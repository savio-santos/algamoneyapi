package com.savio.algamoneyapi.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> Errors = new ArrayList<>();

	public ValidationError() {
	}

	public ValidationError(Integer status, String msg, Long timeStamped) {
		super(status, msg,null, timeStamped);
	}

	public List<FieldMessage> getErrors() {
		return Errors;
	}

	public void AddError(String fielName, String message) {
		Errors.add(new FieldMessage(fielName, message));
	}

}
