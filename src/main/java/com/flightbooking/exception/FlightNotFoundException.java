package com.flightbooking.exception;

public class FlightNotFoundException extends Exception {
	private String message2;
	public FlightNotFoundException() {}
	public FlightNotFoundException(String message2) {
		this.message2=message2;
	}
	public String getMessage2() {
		return this.message2;
	}


}
