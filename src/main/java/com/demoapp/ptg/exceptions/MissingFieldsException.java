package com.demoapp.ptg.exceptions;

import org.springframework.http.HttpStatus;


public class MissingFieldsException extends Exception {

	private static final long serialVersionUID = -4037169155458914456L;
	
	@Override
	public String getMessage() {
		return "Missing fields";
	}
	
	public int getCode() {
		return HttpStatus.BAD_REQUEST.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
