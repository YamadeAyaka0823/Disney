package com.example.domain;

public class AtractionMiddle {
	
	/** ID */
	private Integer id;
	/** アトラクションID */
	private Integer atraction_id;
	/** コンディションID */
	private Integer condition_id;
	
	private AtractionCondition atractionCondition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAtraction_id() {
		return atraction_id;
	}

	public void setAtraction_id(Integer atraction_id) {
		this.atraction_id = atraction_id;
	}

	public Integer getCondition_id() {
		return condition_id;
	}

	public void setCondition_id(Integer condition_id) {
		this.condition_id = condition_id;
	}

	public AtractionCondition getAtractionCondition() {
		return atractionCondition;
	}

	public void setAtractionCondition(AtractionCondition atractionCondition) {
		this.atractionCondition = atractionCondition;
	}

	@Override
	public String toString() {
		return "AtractionMiddle [id=" + id + ", atraction_id=" + atraction_id + ", condition_id=" + condition_id
				+ ", atractionCondition=" + atractionCondition + "]";
	}
	

	
	

}
