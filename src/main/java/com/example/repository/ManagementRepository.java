package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.ManagementInfo;
import com.example.domain.ManagementMiddle;
import com.example.domain.Ticket;


@Repository
public class ManagementRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final ResultSetExtractor<List<ManagementInfo>> MANAGEMENT_INFO_RESULT_SET_EXTRACTOR = (rs) ->{
		List<ManagementInfo> managementInfoList = new ArrayList<>();
		List<ManagementMiddle> managementMiddleList = null;
		
		int preId = -1;
		
		while(rs.next()) {
			int id = rs.getInt("A_id");
			
			if(id != preId) {
				ManagementInfo managementInfo = new ManagementInfo();
				managementInfo.setId(rs.getInt("A_id"));
				managementInfo.setOpenTime(rs.getString("A_open_time"));
				managementInfo.setDate(rs.getDate("A_date"));
				
				managementMiddleList = new ArrayList<>();
				managementInfo.setManagementMiddleList(managementMiddleList);
				managementInfoList.add(managementInfo);
			}
			
			Integer middleCheckId = rs.getInt("B_id");
			
			if(middleCheckId != 0) {
				ManagementMiddle managementMiddle = new ManagementMiddle();
				managementMiddle.setId(rs.getInt("B_id"));
				managementMiddle.setManagementId(rs.getInt("B_management_id"));
				managementMiddle.setTicketId(rs.getInt("B_ticket_id"));
				
				Ticket ticket = new Ticket();
				ticket.setAdult(rs.getInt("C_adult"));
				ticket.setChild(rs.getInt("C_child"));
				ticket.setComment(rs.getString("C_comment"));
				ticket.setDeleted(rs.getBoolean("C_deleted"));
				ticket.setDescription(rs.getString("C_description"));
				ticket.setId(rs.getInt("C_id"));
				ticket.setMiddle(rs.getInt("C_middle"));
				ticket.setName(rs.getString("C_name"));
				ticket.setSenior(rs.getInt("C_senior"));
				managementMiddle.setTicket(ticket);
				managementMiddleList.add(managementMiddle);
			}
			
			preId = id;
		}
		
		return managementInfoList;
	};
	
	/**
	 * 3つのテーブルを結合.
	 * @return
	 */
	private String join3Table() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT A.id A_id, A.open_time A_open_time, A.date A_date, ");
		sb.append(" B.id B_id, B.management_id B_management_id, B.ticket_id B_ticket_id, ");
		sb.append(" C.id C_id, C.adult C_adult, C.child C_child, C.comment C_comment, C.deleted C_deleted, C.description C_description, C.middle C_middle, C.senior C_senior, C.name C_name ");
		sb.append(" FROM management_info A INNER JOIN management_middle B ON A.id = B.management_id ");
		sb.append(" INNER JOIN tickets C ON B.ticket_id = C.id ");
		
		String JoinSql = sb.toString();
		return JoinSql;
	}
	
	/**
	 * 運営情報の全件検索するリポジトリ.
	 * @return
	 */
	public List<ManagementInfo> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append(join3Table());
		List<ManagementInfo> managementInfoList = template.query(sql.toString(), MANAGEMENT_INFO_RESULT_SET_EXTRACTOR);
		return managementInfoList;
	}
	
	/**
	 * IDで運営情報を一件検索するリポジトリ.
	 * @param id
	 * @return
	 */
	public ManagementInfo load(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(join3Table());
		sql.append(" WHERE A.id = :id ");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<ManagementInfo> managementInfoList = template.query(sql.toString(), param, MANAGEMENT_INFO_RESULT_SET_EXTRACTOR);
		if(managementInfoList.size() == 0) {
			return null;
		}
		return managementInfoList.get(0);
	}

}
