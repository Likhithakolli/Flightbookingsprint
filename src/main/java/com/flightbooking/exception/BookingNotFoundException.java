package com.flightbooking.exception;

public class BookingNotFoundException  extends Exception {
	private String message4;
	public BookingNotFoundException() {}
	public BookingNotFoundException(String message4) {
		this.message4=message4;
	}
	public String getMessage4() {
		return this.message4;
	}
	

}
