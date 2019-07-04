package com.ocj.learn.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class WorkBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "start_time", length = 64)
	private String start_time;

	@Column(name = "end_time", length = 64)
	private String end_time;

	@Column(name = "work_title", length = 256)
	private String work_title;

	@Column(name = "work_details", length = 1024)
	private String work_details;

	@Column(name = "work_number", length = 11)
	private int work_number;

	@Column(name = "class_name", length = 64)
	private String class_name;
	
	@Column(name="class_number",length=11)
	private int class_number;
	
	@Column(name = "work_publisher", length = 64)
	private String work_publisher;
	
	@Column(name="work_course_number",length=11)
	private int work_course_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getWork_title() {
		return work_title;
	}

	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}

	public String getWork_details() {
		return work_details;
	}

	public void setWork_details(String work_details) {
		this.work_details = work_details;
	}

	public int getWork_number() {
		return work_number;
	}

	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getClass_number() {
		return class_number;
	}

	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}

	public String getWork_publisher() {
		return work_publisher;
	}

	public void setWork_publisher(String work_publisher) {
		this.work_publisher = work_publisher;
	}

	public int getWork_course_number() {
		return work_course_number;
	}

	public void setWork_course_number(int work_course_number) {
		this.work_course_number = work_course_number;
	}
}
