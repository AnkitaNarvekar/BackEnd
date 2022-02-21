package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentd")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int studid;
	
	@Column(name="sname")
	private String studname;
	
	@Column(name="semail")
	private String studemail;
	
	public Student(String studname, String studemail) {
		super();
		//this.studid = studid;
		this.studname = studname;
		this.studemail = studemail;
	}
	
	
	
	public Student() {
		super();
	}



	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getStudemail() {
		return studemail;
	}
	public void setStudemail(String studemail) {
		this.studemail = studemail;
	}
	
	/*@Override
	public String toString() {
		
		
		return "Student [studid=" + studid + ",studname=" + studname +",studemail=" +studemail +"]";
		
		
		
	}
	*/
	

}
