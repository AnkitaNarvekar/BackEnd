package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjectd")
public class Subject {
	
	@Id
	@Column(name="subid")
	private int subid;
	
	@Column(name="subname")
	private String subname;

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Subject( String subname) {
		super();
		//this.subid = subid;
		this.subname = subname;
	}

	public Subject() {
		super();
	}
	
	

}
