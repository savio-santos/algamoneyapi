package com.savio.algamoneyapi.service.exception;

public class PessoaInativaException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public PessoaInativaException(String message, Throwable cause) {
			super(message, cause);
		}

		public PessoaInativaException(String message) {
			super(message);
		}
}
