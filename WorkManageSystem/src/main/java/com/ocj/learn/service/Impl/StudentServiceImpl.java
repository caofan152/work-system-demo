package com.ocj.learn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocj.learn.bean.SelectionOfCoursesByStudentsBean;
import com.ocj.learn.bean.WorkStateBean;
import com.ocj.learn.repository.SelectionOfCoursesByStudentsRepository;
import com.ocj.learn.repository.WorkStateRepository;
import com.ocj.learn.service.StudentService;

/**
 * @author ou
 * @time 2019年7月2日 上午9:27:18
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private WorkStateRepository workStateRepository;
	
	@Autowired
	private SelectionOfCoursesByStudentsRepository socbsRepository;

	@Override
	public List<SelectionOfCoursesByStudentsBean> findOneStudentCourse(int student_number) {
		return socbsRepository.findAllByStudentNumber(student_number);
	}

	//返回某学生某一课程的全部历史作业信息
	@Override
	public List<WorkStateBean> findHistoryWork(int student_number, int course_number) {
		
		return workStateRepository.findHistoryWork(student_number,course_number);
	}

	@Override
	public WorkStateBean findAllWork(int finish_student_number, int course_number) {
		// TODO Auto-generated method stub
		return null;
	}
}
