package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {
	@Id
	@Column(name = "sid")
	private int studentid;
	@Column(name = "sname")
	private String studentname;
	@Column(name = "saddress")
	private String studentaddress;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentaddress() {
		return studentaddress;
	}

	public void setStudentaddress(String studentaddress) {
		this.studentaddress = studentaddress;
	}

	public Student(int studentid, String studentname, String studentaddress) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentaddress = studentaddress;
	}

	public Student() {
		super();
	}

}
