package com.example.domain;

public class AtractionCondition {
	
	/** ID */
	private Integer id;
	/** タイプ */
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AtractionCondition [id=" + id + ", type=" + type + "]";
	}
	
	

}
