package com.laptrinhjavaweb.entity;

import com.javaweb.annotion.Column;
import com.javaweb.annotion.Entity;
import com.javaweb.annotion.Table;

@Entity
@Table(name = "rentarea")
public class RentArea extends BaseEntity {
	
	@Column(name ="value")
	String value;
	
	@Column(name = "buildingid")
	private Long buildingId;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	

	
}
