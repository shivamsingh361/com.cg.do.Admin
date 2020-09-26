package com.cg.go.admin.exceptions;

public class UnknownException extends Exception {

	/**
	 * NA.
	 */
	private static final long serialVersionUID = 1L;

	public UnknownException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownException(String message) {
		super(message);
	}

	public UnknownException(Throwable cause) {
		super(cause);
	}
	public UnknownException() {
	}

}
