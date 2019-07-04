package com.ocj.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.SelectionOfCoursesByStudentsBean;

/**
* @author ou
* @time 2019年7月2日 上午10:08:47
*/

public interface SelectionOfCoursesByStudentsRepository extends JpaRepository<SelectionOfCoursesByStudentsBean,Long>{

	@Transactional
	@Query(value="select * from selection_of_courses_by_students where course_student_number=?1",nativeQuery = true)
	List<SelectionOfCoursesByStudentsBean> findAllByStudentNumber(int course_student_number);
}
