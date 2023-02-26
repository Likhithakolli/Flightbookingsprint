package com.flightbooking.exception;

public class BookingAlreadyExistsException extends Exception {
	private String message1;
	public BookingAlreadyExistsException() {}
	public BookingAlreadyExistsException(String message1) {
		this.message1=message1;
	}
	public String getMessage1() {
		return this.message1;
	}
	

}
