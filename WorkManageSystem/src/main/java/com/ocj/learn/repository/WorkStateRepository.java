package com.ocj.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.WorkStateBean;

/**
* @author ou
* @time 2019年7月2日 上午9:36:06
*/
public interface WorkStateRepository extends JpaRepository<WorkStateBean,Long>{

	@Transactional
	@Query(value="select * from work_state where finish_student_number=?1 and work_course_number=?2",nativeQuery = true)
	List<WorkStateBean> findHistoryWork(int finish_student_number, int work_course_number);//查找某一学生全部的历史作业
	
	@Transactional
	@Query(value="select * from work_state where work_number=?1",nativeQuery = true)
	List<WorkStateBean> getAllStudentWork(int work_number);
	
	@Transactional
	@Query(value="select * from work_state where work_number=?1 and finish_student_number=?2",nativeQuery = true)
	WorkStateBean getOneWorkState(int work_number, int finish_student_number);
	
	@Transactional
	@Modifying
	@Query(value="update work_state set grades=?3 , work_comment=?4 , work_modle=?5 where work_number=?1 and finish_student_number=?2",nativeQuery = true)
	int updateWorkConfirm(int work_number , int finish_student_number, String grades , String work_comment ,boolean work_modle);
	
	@Transactional
	@Modifying
	@Query(value="update work_state set finish_time=?1 , work_submition=?2 , state=?3 where finish_student_number=?4 and work_number=?5",nativeQuery = true)
	int updateWorkByStudentConfirm(String finish_time , String work_submition, boolean state , int finish_student_number ,int work_number);
	
	@Transactional
	@Query(value="select * from work_state where work_course_number=?1 and finish_student_number=?2",nativeQuery = true)
	WorkStateBean findOneWorkDetail(int work_course_number,int finish_student_number);
}
