package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibenatetemplate;

	//insert
	@Transactional
	public int insert(Student student)
	{
		Integer i = (Integer)this.hibenatetemplate.save(student);
		return i;
	}
	
	//Read single data
	public Student getStudent(int studentid)
	{
		Student student = this.hibenatetemplate.get(Student.class, studentid);
		return student;
	}
	
	//Read multiple data
	
	public List<Student> getAllStudent()
	{
		List<Student> students = this.hibenatetemplate.loadAll(Student.class);
		return students;
	}
	
	//update 
	@Transactional
	public void update(Student student)
	{
		this.hibenatetemplate.update(student);
	}
	
	// Delete 
	@Transactional
	public void delete(int studentid)
	{
		Student student = this.hibenatetemplate.get(Student.class, studentid);
		this.hibenatetemplate.delete(student);
	}
	
	
	public HibernateTemplate getHibenatetemplate() {
		return hibenatetemplate;
	}

	public void setHibenatetemplate(HibernateTemplate hibenatetemplate) {
		this.hibenatetemplate = hibenatetemplate;
	}
	
}
