package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.Passenger;
import com.example.response.Ticket;
import com.example.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@PostMapping(value="/ticket",
			consumes= {"application/json"},
			produces= {"application/json"}
	)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger p) {
		Ticket ticket=service.bookTicket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get/{ticketNum}",
			produces = "application/json"
			)
	public Ticket getTicket(@PathVariable("ticketNum") Integer TicketNum) {
		Ticket ticket=service.getTicket(TicketNum);
		return ticket;
	}

	
}
