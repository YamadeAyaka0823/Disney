package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Ticket;
import com.example.repository.TicketRepository;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	/**
	 * チケットの種類を全件検索するサービス.
	 * @return
	 */
	public List<Ticket> findAll(){
		return ticketRepository.findAll();
	}

}
