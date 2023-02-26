package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.model.Airport;
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	
}
