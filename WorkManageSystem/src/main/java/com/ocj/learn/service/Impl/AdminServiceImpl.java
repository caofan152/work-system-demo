package com.ocj.learn.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocj.learn.bean.ClassBean;
import com.ocj.learn.repository.ClassRepositoty;
import com.ocj.learn.service.AdminService;

/**
 * @author ou
 * @time 2019年7月1日 上午8:59:36
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ClassRepositoty classRepositoty;

	@Override
	public List<ClassBean> getClassAll() {
		return classRepositoty.findAll();
	}

	@Override
	public void save(ClassBean class_) {
		classRepositoty.save(class_);
	}

	@Override
	public void deleteById(int id) {
		classRepositoty.deleteById(id);
	}

}
