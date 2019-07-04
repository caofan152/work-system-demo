package com.ocj.learn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocj.learn.bean.StudentBean;
import com.ocj.learn.repository.CourseClassRepository;
import com.ocj.learn.repository.StudentRepository;
import com.ocj.learn.repository.UserRepository;
import com.ocj.learn.service.WorkService;

/**
* @author ou
* @time 2019年7月2日 上午9:27:32
*/
@Service
public class WorkServiceImpl implements WorkService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseClassRepository courseClassRepository;
	
	@Override
	public List<StudentBean> findAllByClass(String class_name) {
		return studentRepository.findAllByClass(class_name);
	}

	@Override
	public int findCourseNumber(String course_name) {
		return courseClassRepository.findCourseNumber(course_name);
	}
	
	
}
