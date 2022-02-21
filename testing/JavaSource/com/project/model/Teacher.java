package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacherd")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tid")
	private int teachid;
	
	@Column(name="tname")
	private String teachname;
	
	public Teacher(String teachname) {
		super();
		//this.teachid = teachid;
		this.teachname = teachname;
	}
	
	public Teacher() {
		super();
	}
	
	public int getTeachid() {
		return teachid;
	}
	public void setTeachid(int teachid) {
		this.teachid = teachid;
	}
	public String getTeachname() {
		return teachname;
	}
	public void setTeachname(String teachname) {
		this.teachname = teachname;
	}
	
	
	
	
	
}
