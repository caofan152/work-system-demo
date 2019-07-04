package com.ocj.learn.controller.teacher;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocj.learn.bean.CourseClassBean;
import com.ocj.learn.bean.UserBean;
import com.ocj.learn.bean.WorkBean;
import com.ocj.learn.bean.WorkStateBean;
import com.ocj.learn.service.TeacherService;

/**
 * @author ou
 * @time 2019年7月2日 下午9:00:10
 */

@Controller
public class TeacherIndexController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private TeacherService teacherService;

	@RequestMapping("/teacherIndex")
	public String studentIndex(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean us = (UserBean) session.getAttribute("USER_MESSAGE");

		System.out.println("session us " + us.getAccount());

		String teacherName = teacherService.getTeacherName(us.getAccount());
		List<WorkBean> list = teacherService.getAllWork(teacherName);
		List<CourseClassBean> ccb = teacherService.findOneTeacherAllClass(teacherName);
		
		System.out.println("get teacherName : " + teacherName);
		
		for(CourseClassBean c: ccb) {
			System.out.println(c.getCourse_teacher()+"课程名"+c.getCourse_name());
		}
		
		model.addAttribute("CUR_TEACHER", teacherName);
		model.addAttribute("WORK_LIST", list);

		return "teacher/index";
	}
	
	@RequestMapping("/work_student_detail")
	public String workStudentDetail(int work_number, Model model, HttpSession session) {
		
		if(session.getAttribute("CURRENT_STUDENT_WN_")==null) {
			session.setAttribute("CURRENT_STUDENT_WN_", work_number);
		}else {
			work_number = (Integer) session.getAttribute("CURRENT_STUDENT_WN_");
		}
				
		List<WorkStateBean> list = teacherService.getAllStudentWork(work_number);
		
		model.addAttribute("WORkSTUDENTDETAIL", list);
		
		System.out.println("jump");
		return "teacher/work_student_detail";
	}
	
	@RequestMapping("/work_detail")
	public String work_detail(Integer work_number, Integer finish_student_number , Model model , HttpSession session) {
		
		
		if(session.getAttribute("CURRENT_STUDENT_WN")==null) {
			session.setAttribute("CURRENT_STUDENT_WN", work_number);
			session.setAttribute("CURRENT_STUDENT_FN", finish_student_number);
		}else {
			work_number = (Integer) session.getAttribute("CURRENT_STUDENT_WN");
			finish_student_number = (Integer) session.getAttribute("CURRENT_STUDENT_FN");
		}
		
		WorkStateBean wsb = teacherService.getOneWorkState(work_number,finish_student_number);
		
		WorkBean wb = teacherService.getOneWork(work_number);
		
		model.addAttribute("WORK_SUB",wsb);
		model.addAttribute("WORK",wb);
		
		return "teacher/work_detail";
	}
	
	@RequestMapping("/confirm_work")
	public String confirmWork(Integer work_number, Integer finish_student_number, String grades , String work_comment ,boolean work_model) {
		
		System.out.println(work_number+finish_student_number+grades+work_comment+work_model);
		
		int result= teacherService.updateWorkConfirmupdateWorkConfirm(work_number, finish_student_number, grades, work_comment , work_model);
		
		return "teacher/work_student_detail";
	}
	
	@RequestMapping("/jump_wsd")
	public String jump() {
		return "teacher/class_detail";
	}
	
	@ResponseBody
	@RequestMapping("/get_courses")
	public List<CourseClassBean> getCourses(String teacher_name){
		
		return  teacherService.findOneTeacherAllClass(teacher_name);
	}

}
