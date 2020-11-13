package com.demoapp.ptg.exceptions;

import org.springframework.http.HttpStatus;


public class InvalidFieldsException extends Exception {

	private static final long serialVersionUID = -3546280472979543465L;
	
	@Override
	public String getMessage() {
		return "Invalid fields";
	}
	
	public int getCode() {
		return HttpStatus.BAD_REQUEST.value();
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.BAD_REQUEST;
	}

}
