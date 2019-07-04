package com.ocj.learn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_name",length=64)
	private String course_name;
	
	@Column(name="course_number",length=64)
	private int course_number;
	
	@Column(name="course_teacher_number",length=64)
	private int course_teacher_number;
	
	@Column(name="course_teacher_name",length=64)
	private String course_teacher_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_number() {
		return course_number;
	}

	public void setCourse_number(int course_number) {
		this.course_number = course_number;
	}

	public int getCourse_teacher_number() {
		return course_teacher_number;
	}

	public void setCourse_teacher_number(int course_teacher_number) {
		this.course_teacher_number = course_teacher_number;
	}


}
