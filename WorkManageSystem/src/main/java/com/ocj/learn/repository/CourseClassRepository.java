package com.ocj.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.CourseClassBean;

/**
* @author ou
* @time 2019年7月2日 下午9:15:46
*/

public interface CourseClassRepository extends JpaRepository<CourseClassBean,Long>{

	@Transactional
	@Query(value="select * from course_class c where c.course_teacher=?1 ",nativeQuery = true)
	List<CourseClassBean> findOneTeacherAllClass(String course_teacher);
	
	@Transactional
	@Query(value="select course_number from course_class where course_name=?1 limit 1",nativeQuery = true)
	int findCourseNumber(String course_name);
}
