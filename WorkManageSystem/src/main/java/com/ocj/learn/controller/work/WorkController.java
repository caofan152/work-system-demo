package com.ocj.learn.controller.work;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocj.learn.bean.ResultGenerator;
import com.ocj.learn.bean.StudentBean;
import com.ocj.learn.bean.WorkStateBean;
import com.ocj.learn.repository.WorkStateRepository;
import com.ocj.learn.service.WorkService;

/**
 * @author ou
 * @time 2019年7月3日 下午3:30:35
 */
@Controller
public class WorkController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private WorkService workService;
	@Autowired
	private WorkStateRepository ws;
;
	
	
	@ResponseBody
	@RequestMapping("/new_work")
	public Object addNewWork(String work_title, String class_name, String work_details , String course_name) {

		//生成随机10位数的作业编号
		int work_number = (int) ((Math.random() * 9 + 1) * 10000 * 10000);
		System.out.println("class name : " + class_name + " work_title " +work_title+" work_details "+work_details+" course_name "+course_name);
		List<StudentBean> stb = workService.findAllByClass(class_name);
	    
		List<WorkStateBean> wsb = new ArrayList<WorkStateBean>();
		
		int work_course_number = workService.findCourseNumber(course_name);
		System.out.println("work_course_number " + work_course_number);

		
		int i = 0;
		for(StudentBean s : stb) {
		
			WorkStateBean wsbean = new WorkStateBean();
			wsbean.setFinish_student(s.getStudent_name());
			wsbean.setFinish_student(s.getStudent_name());
			wsbean.setFinish_student_number(s.getStudent_number());
			wsbean.setWork_class(class_name);
			wsbean.setWork_number(work_number);
			wsbean.setCourse_name(course_name);
			wsbean.setWork_course_number(work_course_number);
			wsb.add(i, wsbean);

			/*wsb.get(i).setFinish_student(s.getStudent_name());
			wsb.get(i).setFinish_student_number(s.getStudent_number());
			wsb.get(i).setWork_class(class_name);
			wsb.get(i).setWork_number(work_number);
			wsb.get(i).setCourse_name(course_name);
			wsb.get(i).setWork_course_number(work_course_number[0]);*/
			i++;
		}
		
		ws.saveAll(wsb);
		
		return ResultGenerator.genSuccessResult("添加成功");
	}
	
	@RequestMapping("/addWork")
	public String addWork(Model model) {

		return "teacher/add_newWork";
	}
	
	//学生提交作业
	@ResponseBody
	@RequestMapping("/workCommite")
	public Object workCommite(String finish_time , String work_submition ,boolean state , Integer finish_student_number, Integer work_number) {
		
		ws.updateWorkByStudentConfirm(finish_time , work_submition , state ,  finish_student_number,  work_number);
		
		return ResultGenerator.genSuccessResult("添加成功");
	}
}
