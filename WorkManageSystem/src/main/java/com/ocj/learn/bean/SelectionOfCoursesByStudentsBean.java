package com.ocj.learn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="selection_of_courses_by_students")
public class SelectionOfCoursesByStudentsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_name",length=64)
	private String course_name;
	
	@Column(name="course_number",length=11)
	private int course_number;
	
	@Column(name="course_student_number",length=11)
	private int course_student_number;
	
	@Column(name="course_teacher",length=64)
	private String course_teacher;
	
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

	public int getCourse_student_number() {
		return course_student_number;
	}

	public void setCourse_student_number(int course_student_number) {
		this.course_student_number = course_student_number;
	}

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}
	
	
	
}
