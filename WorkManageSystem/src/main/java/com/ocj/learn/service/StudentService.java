package com.ocj.learn.service;

import java.util.List;

import com.ocj.learn.bean.SelectionOfCoursesByStudentsBean;
import com.ocj.learn.bean.WorkStateBean;

/**
* @author ou
* @time 2019年7月2日 上午9:26:08
*/

public interface StudentService {

	public WorkStateBean findAllWork(int finish_student_number , int course_number);
	
	public List<SelectionOfCoursesByStudentsBean> findOneStudentCourse(int student_number);
		
	public List<WorkStateBean> findHistoryWork(int student_number, int course_number);
	
}
