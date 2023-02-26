package com.flightbooking.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.Ticket;
import com.flightbooking.repository.TicketRepository;

@Service
public class TicketDaoImpl implements TicketDao {
	
	@Autowired
	private TicketRepository repository;
		
	public List<Ticket> findAllTickets() {
		return this.repository.findAll();
	}
	
	public Ticket addTicket(Ticket ticket) {
		return repository.save(ticket) ;
	}

	public Ticket getTicketById(int ticketId) {	
		return this.repository.findById(ticketId).orElse(null);
	}

	@Override
	public void cancelTicket(int ticketId) {
		Ticket tic = repository.getOne(ticketId);
		repository.delete(tic);
	}
	
	
}
