package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Atraction;
import com.example.domain.AtractionCondition;
import com.example.domain.AtractionMiddle;

@Repository
public class AtractionRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
//	private static final RowMapper<AtractionCondition> ATRACTIONCONDITION = (rs,i) ->{
//		AtractionCondition atractionCondition = new AtractionCondition();
//		atractionCondition.setId(rs.getInt("B_id"));
//		atractionCondition.setType(rs.getString("B_type"));
//		return atractionCondition;
//	};
	
	private static final ResultSetExtractor<List<Atraction>> ATRACTION_RESULT_SET_EXTRACTOR = (rs) ->{
		List<Atraction> atractionList = new ArrayList<>();
		List<AtractionMiddle> atractionMiddleList = null;
		
		int preId = -1;
		
		while(rs.next()) {
			int id = rs.getInt("A_id");
			
			if(id != preId) {
				Atraction atraction = new Atraction();
				atraction.setId(rs.getInt("A_id"));
				atraction.setName(rs.getString("A_name"));
				atraction.setDescription(rs.getString("A_description"));
				atraction.setImagePath(rs.getString("A_image_path"));
				atraction.setDeleted(rs.getBoolean("A_deleted"));
				atraction.setCapacity(rs.getString("A_capacity"));
				atraction.setComment(rs.getString("A_comment"));
				atraction.setMap(rs.getString("A_map"));
				atraction.setTime(rs.getString("A_time"));
				
				atractionMiddleList = new ArrayList<>();
				atraction.setAtractionMiddleList(atractionMiddleList);
				atractionList.add(atraction);
			}
			
			Integer middleCheckId = rs.getInt("C_id");
			
			if(middleCheckId != 0) {
				AtractionMiddle atractionMiddle = new AtractionMiddle();
				atractionMiddle.setId(rs.getInt("C_id"));
				atractionMiddle.setAtraction_id(rs.getInt("C_atraction_id"));
				atractionMiddle.setCondition_id(rs.getInt("C_condition_id"));
				
				AtractionCondition atractionCondition = new AtractionCondition();
				atractionCondition.setId(rs.getInt("B_id"));
				atractionCondition.setType(rs.getString("B_type"));
				atractionMiddle.setAtractionCondition(atractionCondition);
				atractionMiddleList.add(atractionMiddle);
			}
			
			preId = id;
		}
		
		return atractionList;
	};
	
	/**
	 * 3つのテーブルを結合.
	 * @return
	 */
	private String join3Table() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT A.id A_id, A.name A_name, A.description A_description, A.image_path A_image_path, A.deleted A_deleted, A.comment A_comment, A.map A_map, A.time A_time, A.capacity A_capacity, ");
		sb.append(" B.id B_id, B.type B_type, ");
		sb.append(" C.id C_id, C.atraction_id C_atraction_id, C.condition_id C_condition_id ");
		sb.append(" FROM atractions A INNER JOIN atraction_middle C ON A.id = C.atraction_id ");
		sb.append(" INNER JOIN atraction_conditions B ON B.id = C.condition_id ");
		
		String JoinSql = sb.toString();
		return JoinSql;
	}
	
	/**
	 * アトラクションの全件検索するリポジトリ.
	 * @return
	 */
	public List<Atraction> findAll(){
		StringBuilder sql = new StringBuilder();
		sql.append(join3Table());
		List<Atraction> atractionList = template.query(sql.toString(), ATRACTION_RESULT_SET_EXTRACTOR);
		return atractionList;
	}
	
	/**
	 * アトラクション1件を検索するリポジトリ.
	 * @param id
	 * @return
	 */
	public Atraction load(Integer id) {
		StringBuilder sql = new StringBuilder();
		sql.append(join3Table());
		sql.append(" WHERE A.id = :id ");
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Atraction> atractionList = template.query(sql.toString(), param, ATRACTION_RESULT_SET_EXTRACTOR);
		if(atractionList.size() == 0) {
			return null;
		}
		return atractionList.get(0);
	}

}
