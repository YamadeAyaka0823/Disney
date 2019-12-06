package com.example.domain;

import java.util.List;

public class Atraction {
	
	/** アトラクションID */
	private Integer id;
	/** アトラクション名 */
	private String name;
	/** 説明 */
	private String description;
	/** 画像 */
	private String imagePath;
	
	private Boolean deleted;
	/** 一言 */
	private String comment;
	/** 地図 */
	private String map;
	/** 所要時間 */
	private String time;
	/** 収容人数 */
	private String capacity;
	
	private List<AtractionMiddle> atractionMiddleList;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public List<AtractionMiddle> getAtractionMiddleList() {
		return atractionMiddleList;
	}

	public void setAtractionMiddleList(List<AtractionMiddle> atractionMiddleList) {
		this.atractionMiddleList = atractionMiddleList;
	}

	@Override
	public String toString() {
		return "Atraction [id=" + id + ", name=" + name + ", description=" + description + ", imagePath=" + imagePath
				+ ", deleted=" + deleted + ", comment=" + comment + ", map=" + map + ", time=" + time + ", capacity="
				+ capacity + ", atractionMiddleList=" + atractionMiddleList + "]";
	}




	
	

}
