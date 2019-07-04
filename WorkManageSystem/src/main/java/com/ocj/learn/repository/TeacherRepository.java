package com.ocj.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.TeacherBean;

/**
* @author ou
* @time 2019年7月2日 下午9:11:05
*/

public interface TeacherRepository extends JpaRepository<TeacherBean,Long>{

	@Transactional
	@Query(value="select teacher_name from teacher where teacher_number=?1",nativeQuery = true)
	String findTeacherName(int teacher_number);
}
