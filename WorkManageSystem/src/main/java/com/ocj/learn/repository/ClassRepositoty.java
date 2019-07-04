package com.ocj.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocj.learn.bean.ClassBean;

/**
* @author ou
* @time 2019年7月1日 上午9:05:41
*/

public interface ClassRepositoty extends JpaRepository<ClassBean,Long>{

	ClassBean findById(int id);
	//ClassBean findByClassNumber(int class_number);
	
	void deleteById(int id);
}
