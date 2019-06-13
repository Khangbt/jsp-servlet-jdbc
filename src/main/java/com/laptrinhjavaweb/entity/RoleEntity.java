package com.laptrinhjavaweb.entity;

import com.javaweb.annotion.Column;
import com.javaweb.annotion.Entity;
import com.javaweb.annotion.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity{
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
