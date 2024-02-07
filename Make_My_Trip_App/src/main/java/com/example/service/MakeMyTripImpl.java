package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.request.Passenger;
import com.example.response.Ticket;
@Service
public class MakeMyTripImpl implements MakeMyTripService{

	public String Book_Ticket_Url="http://localhost:8080/ticket";
	
	public String Get_Ticket_Url="http://localhost:8080/get/{ticketNum}";
	
	@Override
	public Ticket bookTicket(Passenger p) {
		
		WebClient webClient=WebClient.create();
		
		Ticket ticket=webClient.post()
				 .uri(Book_Ticket_Url)
				 .bodyValue(p)
				 .retrieve()
				 .bodyToMono(Ticket.class)
				 .block();
		
		return ticket;
//		RestTemplate rt=new RestTemplate();
//		ResponseEntity<Ticket> responseEntity=rt.postForEntity(Book_Ticket_Url, p, Ticket.class);
//		Ticket t=responseEntity.getBody();
//		return t;
	}

	@Override
	public Ticket getTicket(Integer TicketNum) {
//		RestTemplate rt=new RestTemplate();
//		ResponseEntity<Ticket> responseEntity=rt.getForEntity(Get_Ticket_Url, Ticket.class , TicketNum);
//		Ticket t=responseEntity.getBody();
//		return t;
		
		WebClient webClient=WebClient.create();
		
		Ticket ticket=webClient.get()
							  .uri(Get_Ticket_Url, TicketNum)
							  .retrieve()
							  .bodyToMono(Ticket.class)
							  .block();
		return ticket;
	}

	
}
