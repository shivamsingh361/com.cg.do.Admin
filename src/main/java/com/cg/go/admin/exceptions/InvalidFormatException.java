package com.cg.go.admin.exceptions;

public class InvalidFormatException extends Exception {

	/**
	 * NA.
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFormatException(String message) {
		super(message);
	}

	public InvalidFormatException() {
	}

}
