package com.ocj.learn.controller.admin_controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocj.learn.bean.ClassBean;
import com.ocj.learn.bean.ResultGenerator;
import com.ocj.learn.service.AdminService;

/**
* @author ou
* @time 2019年7月1日 上午8:30:07
*/
@Controller
public class IndexController {

	@Resource
	private AdminService adminService;
	
	@RequestMapping("/adminIndex")
	public String login(Model model) {
		List<ClassBean> list = adminService.getClassAll();
		
		model.addAttribute("COURSE_LIST",list);
		for(ClassBean c: list) {
			System.out.println(c);
		}
		return "admin/index";
	}
	
	@ResponseBody
	@RequestMapping("/addClass")
	public Object addClass(String class_name ,int class_number, HttpServletRequest request) {
		System.out.println("get class_name : "+ class_name + " class_number:"+class_number);
		ClassBean cb = new ClassBean();
		cb.setClass_name(class_name);
		cb.setClass_number(class_number);
		adminService.save(cb);
		
		return ResultGenerator.genSuccessResult("登录成功");
	}

	@RequestMapping("/deleteClass")
	public String deleteClass(int id) {
		adminService.deleteById(id);
		//return ResultGenerator.genSuccessResult("删除成功");
		return "redirect:/adminIndex";
	}
	
}
