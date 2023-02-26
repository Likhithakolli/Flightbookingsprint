package com.flightbooking.exception;

public class InvalidAdminException extends Exception{
	private String message3;
	public InvalidAdminException() {}
	public InvalidAdminException(String message3) {
		this.message3=message3;
	}
	public String getMessage3() {
		return this.message3;
	}
	


}
