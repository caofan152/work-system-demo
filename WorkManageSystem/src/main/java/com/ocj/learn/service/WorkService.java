package com.ocj.learn.service;

import java.util.List;

import com.ocj.learn.bean.StudentBean;

/**
* @author ou
* @time 2019年7月2日 上午9:26:51
*/

public interface WorkService {

	public List<StudentBean> findAllByClass(String class_name);
	
	public int findCourseNumber(String  course_name);
}
