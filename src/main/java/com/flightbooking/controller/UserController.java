package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dao.BookingDao;
import com.flightbooking.dao.FlightDao;
import com.flightbooking.dao.TicketDao;
import com.flightbooking.dao.UserDao;
import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.BookingNotFoundException;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Ticket;
import com.flightbooking.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private TicketDao dao;
	
	//user part
	
	// Post mapping request for registering the user and his/her details
	@PostMapping("/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User usr= this.userDao.registerUser(user);
		return new ResponseEntity<>(usr, HttpStatus.CREATED);
	}
	
	//Post mapping request for login to check credentials
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody User user) throws UserNotFoundException{
		return this.userDao.loginUser(user);
	}
	
	//Put mapping request updating the details of the user
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable long userId) throws UserNotFoundException{
		return this.userDao.updateUser(user,userId);
	}
	
	//Delete mapping request for deleting the account of user
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId)throws UserNotFoundException {
		this.userDao.deleteUser(userId);
		return new ResponseEntity<>("User Deleted", HttpStatus.OK);
	}
	
	//Get mapping request to get the user details by giving the id
	@GetMapping("/getUserById/{userId}")
	public User getUserById(@PathVariable long userId) throws UserNotFoundException {
		return this.userDao.getUserById(userId);
	}
	
	//to get the list of users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}
	
	
	//booking
	
	@PostMapping("/newBooking")
	public ResponseEntity<Booking>  newBooking(@RequestBody Booking booking) throws BookingAlreadyExistsException {
		Booking book=this.bookingDao.newBooking(booking);
		return new ResponseEntity<>(book,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<String> cancelBooking(@PathVariable long bookingId) throws BookingNotFoundException{
		this.bookingDao.cancelBooking(bookingId);
		return new ResponseEntity<>("Booking Deleted", HttpStatus.OK);
	
	}
	@GetMapping("/getbooking/{bookingId}")
	public ResponseEntity getEmployeeById(@PathVariable long bookingId) throws BookingNotFoundException {
		return new ResponseEntity(this.bookingDao.getBookingById(bookingId),HttpStatus.OK);
	}
	
	
	/*@GetMapping("/findByBookingId/{bookingId}")
	public Booking findByBookingId(@PathVariable long bookingId ){
		return this.bookingDao.findByBookingId(bookingId);
	
}*/
	//flight
	
	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return this.flightDao.getAllFlights();
	}
	
	@GetMapping("/getFlightByDestination/{destination}")
	public List<Flight> getFlightByDestination(@PathVariable String destination) throws FlightNotFoundException{
		return this.flightDao.getFlightByDestination(destination);
	}
	
	
	
	//Ticket
	@GetMapping("/getTicketById/{ticketId}")
	public Ticket getTicketById(@PathVariable int ticketId) {
		return this.dao.getTicketById(ticketId);
	}
	
	
}