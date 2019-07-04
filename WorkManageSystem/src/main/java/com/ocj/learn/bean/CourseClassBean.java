package com.ocj.learn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_class")
public class CourseClassBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_number",length=11)
	private int course_number;
	
	@Column(name="class_number",length=11)
	private int class_number;
	
	@Column(name="class_name",length=64)
	private String class_name;
	
	@Column(name="course_teacher",length=64)
	private String course_teacher;
	
	@Column(name="course_name",length=64)
	private String course_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourse_number() {
		return course_number;
	}

	public void setCourse_number(int course_number) {
		this.course_number = course_number;
	}

	public int getClass_number() {
		return class_number;
	}

	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	
	
}
