package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.request.Passenger;
import com.example.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService {

	private Integer ticketNum = 1;

	Map<Integer,Ticket> datamap=new HashMap();
	
	@Override
	public Ticket bookTicket(Passenger p) {

		Ticket t = new Ticket();
		BeanUtils.copyProperties(p, t);
		t.setCost(147.89);
		t.setStatus("Confirmed");
		t.setTicketNum(ticketNum);
		datamap.put(ticketNum, t);
		ticketNum++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNum) {
		return datamap.get(ticketNum);
		
	}

}
