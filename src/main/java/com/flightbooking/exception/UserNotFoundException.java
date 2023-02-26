package com.flightbooking.exception;

public class UserNotFoundException extends Exception {
	private String message5;
	public UserNotFoundException() {}
	public UserNotFoundException(String message5) {
		this.message5=message5;
	}
	public String getMessage5() {
		return this.message5;
	}

}
