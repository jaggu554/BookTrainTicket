package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.request.Passenger;
import com.example.response.Ticket;
import com.example.service.MakeMyTripService;


@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;
	
	
	
	@GetMapping("/")
	public String getForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger p,Model model) {
		//System.out.println(p);
		Ticket ticket=service.bookTicket(p);
		model.addAttribute("msg", "Your Ticket booked with Id:"+ticket.getTicketNum());
		return "index";
	}
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNum") Integer ticketNum,Model model) {
		Ticket ticket=service.getTicket(ticketNum);
		model.addAttribute("ticket", ticket);
		return "data";
		
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "data";
		
	}
	
	
}
