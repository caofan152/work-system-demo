package com.ocj.learn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocj.learn.bean.ResultGenerator;
import com.ocj.learn.repository.UserRepository;

/**
 * @author ou
 * @time 2019年7月1日 下午7:04:48
 */
@Controller
public class ChangePasswordController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping("/change_password")
	public Object loginValidate(int id, String password, HttpSession session, HttpServletRequest request) {
		logger.debug("login id = {} , 请求参数:{}", id, request.getAttributeNames());

		String md5_pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		logger.debug("md5 secret: " + md5_pwd);

		int result = userRepository.updatePassword(id, md5_pwd);
		System.out.println("update result : " + result);

		if (result == 0) {
			return ResultGenerator.genFailMessage("登录失败");
		}
		return ResultGenerator.genSuccessResult("登录成功");
	}

	@RequestMapping("/changePassword")
	public String changePassword(Model model) {

		return "changePassword";
	}

}
