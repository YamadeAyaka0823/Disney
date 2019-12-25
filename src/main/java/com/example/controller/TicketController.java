package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Ticket;
import com.example.service.TicketService;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	/**
	 * チケットの全件検索.
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		List<Ticket> ticketList = ticketService.findAll();
		model.addAttribute("ticketList", ticketList);
		return "park_ticket";
	}

}
