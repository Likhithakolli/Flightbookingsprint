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

import com.flightbooking.dao.AdminDao;
import com.flightbooking.dao.AirportDao;
import com.flightbooking.dao.BookingDao;
import com.flightbooking.dao.FlightDao;
import com.flightbooking.dao.TicketDao;
import com.flightbooking.dao.UserDao;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.model.Airport;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Ticket;
import com.flightbooking.model.User;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AirportDao airportDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private TicketDao dao;
	
	@Autowired
	private UserDao userDao;
	
	//Administrator part
	
	@PostMapping("/adminRegistration")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin f=this.adminDao.registerAdmin(admin);
		return new ResponseEntity<>(f, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginAdmin") String loginAdmin(@RequestBody Admin admin) throws InvalidAdminException{
		return this.adminDao.loginAdmin(admin);
	}

	//Airport
	
	@PostMapping("/addAirports")
	public Airport addAirport(@RequestBody Airport airport) {
		return this.airportDao.addAirport(airport);
	}

	
		@GetMapping("/getAllAirports")
		public List<Airport> getAllAirports() {
			return airportDao.getAllAirport();
		}

		
		@PutMapping("/updateAirport/{airportId}")
		public Airport updateAirport(@RequestBody Airport airport) {
			return this.airportDao.updateAirport(airport);
		}
		

	
	//Flight part
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		Flight ft=this.flightDao.addFlight(flight);
		return new ResponseEntity<>(ft, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateFlight/{fightId}")
	public Flight updateFlight(@RequestBody Flight flight) {
		return this.flightDao.updateFlight(flight);
	}
	
	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return this.flightDao.getAllFlights();
	}
	
	@GetMapping("/getFlightById/{flightId}")
	public ResponseEntity<Flight> getFlight(@PathVariable long flightId) throws FlightNotFoundException {
		return new ResponseEntity<>(this.flightDao.getFlightById(flightId),HttpStatus.OK);
	}
	
	
	//user 
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}
	
	// booking part
	
			@GetMapping("/getAllBookings")
			public List<Booking> getAllBookings(){
				return this.bookingDao.getAllBookings();
			}
			
	//Ticket part
		
		@PostMapping("/addTicket")
		public Ticket addTicket(@RequestBody Ticket ticket) {
			return this.dao.addTicket(ticket);
		}
		
		@GetMapping("/FindAllTickets")
		public List<Ticket> findAllTickets() {
			return this.dao.findAllTickets();
		}
		
		@DeleteMapping("/cancelTicket")
		public void cancelTicket(@PathVariable int ticketId) {
			this.dao.getTicketById(ticketId);
			this.dao.cancelTicket(ticketId);
		}
		
}
