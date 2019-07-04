package com.ocj.learn.service;

import java.util.List;

import com.ocj.learn.bean.CourseClassBean;
import com.ocj.learn.bean.WorkBean;
import com.ocj.learn.bean.WorkStateBean;

/**
* @author ou
* @time 2019年7月2日 下午9:01:56
*/

public interface TeacherService {

	public List<WorkBean> getClassAll();
	
	public List<WorkBean> getAllWork(String work_publisher);
	
	public String getTeacherName(int teacher_number);
	
	public List<WorkStateBean> getAllStudentWork(int work_number);
	
	public WorkStateBean getOneWorkState(int work_number, int finish_student_number);
	
	public WorkBean getOneWork(int work_number);
	
	public int updateWorkConfirmupdateWorkConfirm(int work_number , int finish_student_number, String grades , String work_comment, boolean work_modle);
	
	//查找某一教师对应的每一个上课班级
	public List<CourseClassBean> findOneTeacherAllClass(String course_teacher);
}
