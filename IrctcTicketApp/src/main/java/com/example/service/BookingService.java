package com.example.service;

import com.example.request.Passenger;
import com.example.response.Ticket;

public interface BookingService {

	public Ticket bookTicket(Passenger p);
	
	public Ticket getTicket(Integer ticketNum);
}
