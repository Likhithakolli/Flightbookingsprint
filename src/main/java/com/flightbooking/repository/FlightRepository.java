package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightbooking.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("Select f from Flight f where f.destination=:destination")
	public List<Flight> getFlightByDestination(String destination);
	
}
