package com.example.service;

import com.example.request.Passenger;
import com.example.response.Ticket;


public interface MakeMyTripService {


	
	public Ticket bookTicket(Passenger p);
	
	public Ticket getTicket(Integer TicketNum);
	
	
}
