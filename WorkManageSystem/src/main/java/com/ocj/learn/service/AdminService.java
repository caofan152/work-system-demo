package com.ocj.learn.service;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.ClassBean;

/**
* @author ou
* @time 2019年7月1日 上午8:58:59
*/

public interface AdminService {

	public List<ClassBean> getClassAll();
	
	public void save(ClassBean class_);
	
	@Modifying
	@Transactional
	public void deleteById(int id);
}
