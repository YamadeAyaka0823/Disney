package com.example.domain;

public class Ticket {
	
	/** ID */
	private Integer id;
	/** チケットの種類 */
	private String name;
	/** 大人料金 */
	private Integer adult;
	/** 中年料金 */
	private Integer middle;
	/** 小人料金 */
	private Integer child;
	/** シニア料金 */
	private Integer senior;
	/** コメント */
	private String comment;
	/** 説明 */
	private String description;
	
	private Boolean deleted;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAdult() {
		return adult;
	}
	public void setAdult(Integer adult) {
		this.adult = adult;
	}
	public Integer getMiddle() {
		return middle;
	}
	public void setMiddle(Integer middle) {
		this.middle = middle;
	}
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child = child;
	}
	public Integer getSenior() {
		return senior;
	}
	public void setSenior(Integer senior) {
		this.senior = senior;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", name=" + name + ", adult=" + adult + ", middle=" + middle + ", child=" + child
				+ ", senior=" + senior + ", comment=" + comment + ", description=" + description + ", deleted="
				+ deleted + "]";
	}
	
	

}
