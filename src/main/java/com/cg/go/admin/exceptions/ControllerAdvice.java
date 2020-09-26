package com.cg.go.admin.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.go.admin.dto.ErrorInfo;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "The Input Format/Syntex is not acceptable.")
	@ExceptionHandler(value = {InvalidFormatException.class})
	protected ErrorInfo handleFormatException(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
	@ResponseBody
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Some Un-expected handeled Exception.")
	@ExceptionHandler(value = {UnknownException.class})
	protected ErrorInfo handleUnknownException(Exception ex, HttpServletRequest req) {
		String bodyOfResponse = ex.getMessage();
		String uri = req.getRequestURL().toString();
		return new ErrorInfo(uri, bodyOfResponse);
	}
	
}
