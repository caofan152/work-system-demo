package com.ocj.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.WorkBean;

/**
* @author ou
* @time 2019年7月2日 下午9:11:50
*/

public interface WorkRepository extends JpaRepository<WorkBean,Long>{

	@Transactional
	@Query(value="select * from work where work_publisher=?1 ",nativeQuery = true)
	List<WorkBean> getAllWork(String work_publisher);
	
	@Transactional
	@Query(value="select * from work where work_number=?1 ",nativeQuery = true)
	WorkBean getOneWork(int work_number);
		
	@Transactional
	@Query(value="select * from work where work_course_number=?1 ",nativeQuery = true)
	List<WorkBean> getHistoryWork(int work_course_number);
	
	
	//测试
	@Transactional
	@Query(value="select * from work where class_number=?1 ",nativeQuery = true)
	List<WorkBean> test(int class_number);
	
}
