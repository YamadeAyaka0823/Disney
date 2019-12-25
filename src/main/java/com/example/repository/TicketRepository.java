package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Ticket;

@Repository
public class TicketRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Ticket> TICKET_ROW_MAPPER = (rs,i) -> {
		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt("id"));
		ticket.setName(rs.getString("name"));
		ticket.setAdult(rs.getInt("adult"));
		ticket.setMiddle(rs.getInt("middle"));
		ticket.setChild(rs.getInt("child"));
		ticket.setComment(rs.getString("comment"));
		ticket.setDescription(rs.getString("description"));
		ticket.setSenior(rs.getInt("senior"));
		ticket.setDeleted(rs.getBoolean("deleted"));
		return ticket;
	};
	
	/**
	 * チケットの種類全件検索するためのリポジトリ.
	 * @return
	 */
	public List<Ticket> findAll(){
		String sql = "SELECT id, name, adult, middle, child, comment, description, senior, deleted FROM tickets ORDER BY id";
		List<Ticket> ticketList = template.query(sql, TICKET_ROW_MAPPER);
		return ticketList;
	}

}
