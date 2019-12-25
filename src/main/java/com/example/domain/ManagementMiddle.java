package com.example.domain;

public class ManagementMiddle {
	
	/** ID */
	private Integer id;
	/** 運営情報ID */
	private Integer managementId;
	/** チケットID */
	private Integer ticketId;
	
	private Ticket ticket;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getManagementId() {
		return managementId;
	}

	public void setManagementId(Integer managementId) {
		this.managementId = managementId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "ManagementMiddle [id=" + id + ", managementId=" + managementId + ", ticketId=" + ticketId + ", ticket="
				+ ticket + "]";
	}
	

	
	

}
