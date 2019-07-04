package com.ocj.learn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocj.learn.bean.CourseClassBean;
import com.ocj.learn.bean.WorkBean;
import com.ocj.learn.bean.WorkStateBean;
import com.ocj.learn.repository.CourseClassRepository;
import com.ocj.learn.repository.TeacherRepository;
import com.ocj.learn.repository.WorkRepository;
import com.ocj.learn.repository.WorkStateRepository;
import com.ocj.learn.service.TeacherService;

/**
* @author ou
* @time 2019年7月2日 下午9:09:38
*/
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private WorkRepository workRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private WorkStateRepository workStateRepository;
	
	@Autowired
	private CourseClassRepository courseClassRepository;
	
	@Override
	public List<WorkBean> getClassAll() {
		return null;
	}

	@Override
	public List<WorkBean> getAllWork(String work_publisher) {
		return workRepository.getAllWork(work_publisher);
	}

	@Override
	public String getTeacherName(int teacher_number) {
		return teacherRepository.findTeacherName(teacher_number);
	}

	@Override
	public List<WorkStateBean> getAllStudentWork(int work_number) {
		return workStateRepository.getAllStudentWork(work_number);
	}

	@Override
	public WorkStateBean getOneWorkState(int work_number, int finish_student_number) {
		return workStateRepository.getOneWorkState(work_number , finish_student_number);
	}

	@Override
	public WorkBean getOneWork(int work_number) {
		return workRepository.getOneWork(work_number);
	}

	@Override
	public int updateWorkConfirmupdateWorkConfirm(int work_number, int finish_student_number, String grades,
			String work_comment , boolean work_modle) {
		return workStateRepository.updateWorkConfirm(work_number, finish_student_number, grades, work_comment,work_modle);
	}

	@Override
	public List<CourseClassBean> findOneTeacherAllClass(String course_teacher) {
		return courseClassRepository.findOneTeacherAllClass(course_teacher);
	}

}
