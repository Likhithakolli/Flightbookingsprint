package com.flightbooking.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="flight_id")
	private long flightId;
	
	private String flightName="King flyer";
	
	@Column(name="departure_date")
	private Date departureDate;
	
	@Column(name="arrival_date")
	private Date arrivalDate;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
   @Column(name="price")
   private long price;
    
   @Column (name="available_seats")
   private int availableSeats; 
   

   @Column(name="destination")
   private String destination;
	
  
   @Column(name="departure")
   private String departure;   
  
   @ManyToOne
   @JoinColumn(name="airport_id")
   private Airport destinationAirport;
   
   @OneToMany(mappedBy="flight")
   @JsonIgnoreProperties({"bookings"})
   private List<Booking> bookings;
   
   
}