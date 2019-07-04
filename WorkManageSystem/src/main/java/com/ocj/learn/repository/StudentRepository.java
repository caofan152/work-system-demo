package com.ocj.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.StudentBean;

/**
* @author ou
* @time 2019年7月3日 下午8:39:30
*/

public interface StudentRepository extends JpaRepository<StudentBean,Long>{

	@Transactional
	@Query(value="select * from student where student_class=?1",nativeQuery = true)
	List<StudentBean> findAllByClass(String student_class);
	
}
