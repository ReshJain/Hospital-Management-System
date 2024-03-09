package com.jsp.hospital_management_system.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	public IdNotFoundException() {
		super();
		
	}
	

}
