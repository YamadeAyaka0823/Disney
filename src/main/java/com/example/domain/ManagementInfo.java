package com.example.domain;

import java.util.Date;
import java.util.List;

public class ManagementInfo {
	
	/** ID */
	private Integer id;
	/** 開園時間 */
	private String openTime;
	/** カレンダー */
	private Date date;
	
	private List<ManagementMiddle> managementMiddleList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ManagementMiddle> getManagementMiddleList() {
		return managementMiddleList;
	}

	public void setManagementMiddleList(List<ManagementMiddle> managementMiddleList) {
		this.managementMiddleList = managementMiddleList;
	}

	@Override
	public String toString() {
		return "ManagementInfo [id=" + id + ", openTime=" + openTime + ", date=" + date + ", managementMiddleList="
				+ managementMiddleList + "]";
	}
	
	

}
