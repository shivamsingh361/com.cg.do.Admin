package com.cg.go.admin.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.go.admin.dto.ErrorInfo;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "The Input Format/Syntex is not acceptable.")
	@ExceptionHandler(value = {InvalidFormatException.class})
	protected ResponseEntity<ErrorInfo> handleFormatException(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = "The Input Format/Syntex is not acceptable.\n"+ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ResponseEntity<ErrorInfo>(new ErrorInfo(uri, bodyOfResponse), HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason = "Some Un-expected handeled Exception.")
	@ExceptionHandler(value = {UnknownException.class})
	protected ResponseEntity<ErrorInfo> handleUnknownException(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = "Some Un-expected handeled Exception.\n"+ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ResponseEntity<ErrorInfo>(new ErrorInfo(uri, bodyOfResponse), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
