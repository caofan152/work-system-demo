package com.ocj.learn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work_state")
public class WorkStateBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "course_name", length = 64)
	private String course_name;

	@Column(name = "finish_time")
	private String finish_time;

	@Column(name = "finish_student", length = 64)
	private String finish_student;

	@Column(name = "finish_student_number", length = 64)
	private int finish_student_number;

	@Column(name = "grades", length = 11)
	private String grades;

	@Column(name = "work_number", length = 11)
	private int work_number;

	@Column(name = "work_submition", length = 1024)
	private String work_submition;

	@Column(name = "work_class", length = 64)
	private String work_class;

	@Column(name = "work_modle", columnDefinition = "bool default false")
	private boolean work_modle;

	@Column(name = "work_comment", length = 1024)
	private String work_comment;
	
	@Column(name = "work_course_number", length = 11)
	private int work_course_number;
	
	@Column(name = "state", columnDefinition = "bool default false")
	private boolean state;

	
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

	public String getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public String getFinish_student() {
		return finish_student;
	}

	public void setFinish_student(String finish_student) {
		this.finish_student = finish_student;
	}

	public int getFinish_student_number() {
		return finish_student_number;
	}

	public void setFinish_student_number(int finish_student_number) {
		this.finish_student_number = finish_student_number;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public int getWork_number() {
		return work_number;
	}

	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}

	public String getWork_submition() {
		return work_submition;
	}

	public void setWork_submition(String work_submition) {
		this.work_submition = work_submition;
	}

	public String getWork_class() {
		return work_class;
	}

	public void setWork_class(String work_class) {
		this.work_class = work_class;
	}

	public boolean isWork_modle() {
		return work_modle;
	}

	public void setWork_modle(boolean work_modle) {
		this.work_modle = work_modle;
	}

	public String getWork_comment() {
		return work_comment;
	}

	public void setWork_comment(String work_comment) {
		this.work_comment = work_comment;
	}

	public int getWork_course_number() {
		return work_course_number;
	}

	public void setWork_course_number(int work_course_number) {
		this.work_course_number = work_course_number;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}



}
