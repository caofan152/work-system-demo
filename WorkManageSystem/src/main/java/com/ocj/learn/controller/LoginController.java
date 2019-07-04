package com.ocj.learn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocj.learn.bean.ResultGenerator;
import com.ocj.learn.bean.UserBean;
import com.ocj.learn.repository.UserRepository;

@Controller
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	/**
	 * 登录面板
	 */

	@RequestMapping("/login")
	public String login(Model model) {
		return "/login";
	}

	@ResponseBody
	@PostMapping("/validate")
	public Object loginValidate(int account, String password, HttpSession session, HttpServletRequest request) {
		logger.debug("login name = {} , 请求参数:{}", account, request.getAttributeNames());

		// System.out.println("Login 校验");
		String realIp = request.getRemoteHost();
		Object realIPObj = request.getAttribute("X-Real-Ip");
		if (realIPObj != null && StringUtils.isNoneBlank(realIPObj + "")) {
			realIp = (String) realIPObj;
		}

		// md5加密匹配字符串
		UserBean userBean = userRepository.findByAccount(account);

		if (userBean != null) {
			if (userBean.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {

				session.setAttribute("USER_MESSAGE", userBean);
				int type = userBean.getUser_type();
				System.out.println("get user_tper" + type);
				//返回用户类型信息
				if(type == 1) {
					return ResultGenerator.genSuccessMessage("admin");
				}else if(type == 2) {
					return ResultGenerator.genSuccessMessage("teacher");
				}else if(type == 3) {
					return ResultGenerator.genSuccessMessage("student");
				}				
				
			}
		}

		return ResultGenerator.genFailMessage("登录失败");
	}

	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("USER_MESSAGE");
		return "redirect:/login";
	}

}
