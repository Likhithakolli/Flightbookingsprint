package com.flightbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.model.Booking;
import com.flightbooking.repository.BookingRepository;

@Service
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	private BookingRepository repository;
	
	
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

	
	public Booking newBooking(Booking booking) throws BookingAlreadyExistsException {
		if(repository.existsById(booking.getBookingId())) {
			throw new BookingAlreadyExistsException();
		}
		return repository.save(booking);
	}

	
	public void cancelBooking(long bookingId) {// throws BookingNotFoundException {
		Booking book=repository.getOne( bookingId);
		//if(book==null) {
			//throw new BookingNotFoundException();
		//}
		//else
			repository.delete(book);
		
	}
	public Booking getBookingById(long bookingId) throws BookingNotFoundException {
		
		Booking book;
		if(repository.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		else {
			book=repository.findById(bookingId).get();
		}
		return book;
	}


	public Booking findByBookingId(long bookingId) {
		return this.repository.getOne(bookingId);
	}
	
}
