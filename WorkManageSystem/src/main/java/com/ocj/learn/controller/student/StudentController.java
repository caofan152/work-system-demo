package com.ocj.learn.controller.student;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ocj.learn.bean.SelectionOfCoursesByStudentsBean;
import com.ocj.learn.bean.UserBean;
import com.ocj.learn.bean.WorkBean;
import com.ocj.learn.bean.WorkStateBean;
import com.ocj.learn.repository.WorkRepository;
import com.ocj.learn.repository.WorkStateRepository;
import com.ocj.learn.service.StudentService;

/**
* @author ou
* @time 2019年7月2日 上午9:20:36
*/
@Controller
public class StudentController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private StudentService studentService;
	@Autowired
	private WorkStateRepository workStateRepository;
	@Autowired
	private WorkRepository workRepository;
	
	@RequestMapping("/student_index")
	public String studentIndex(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserBean us = (UserBean) session.getAttribute("USER_MESSAGE");
		
		System.out.println("session us " + us.getAccount());
		
		List<SelectionOfCoursesByStudentsBean> list = studentService.findOneStudentCourse(us.getAccount());
		model.addAttribute("COURSE_LIST",list);
				
		return "student/index";
	}
	
	
	@RequestMapping("/work_history")
	public String workHistory(Integer work_course_number,Model model) {
		
		System.out.println(" work_course_number "+work_course_number);
		
		List<WorkBean> wb = workRepository.getHistoryWork(work_course_number);
		model.addAttribute("HISTORY_WORK",wb);
		return "student/work_history";
	}

	@RequestMapping("/student_work_detail")
	public String workDetail(Integer work_course_number, Integer finish_student_number,Integer work_number,Model  model) {
		
		WorkStateBean wsb = workStateRepository.findOneWorkDetail(work_course_number,finish_student_number);
		WorkBean wb = workRepository.getOneWork(work_number);
		model.addAttribute("WORKDETAIL",wsb);
		model.addAttribute("WORK",wb);
		
		System.out.println(" get _work_course_number : " + wsb.getWork_course_number());
		
		return "student/work_detail";
	}
	
	
	
}
