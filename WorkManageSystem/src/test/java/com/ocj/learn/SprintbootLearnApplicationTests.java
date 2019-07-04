package com.ocj.learn;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ocj.learn.bean.CourseClassBean;
import com.ocj.learn.bean.SelectionOfCoursesByStudentsBean;
import com.ocj.learn.repository.CourseClassRepository;
import com.ocj.learn.repository.SelectionOfCoursesByStudentsRepository;
import com.ocj.learn.repository.WorkRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprintbootLearnApplicationTests {

	private WorkRepository wr;
	private CourseClassRepository cr;
	@Autowired
	private SelectionOfCoursesByStudentsRepository so;
	
	@Autowired
	private CourseClassRepository ccr;
	
	@Test
	public void contextLoads() {
		int  i =  ccr.findCourseNumber("信息安全");
		//for(int n : i) {
			System.out.println(i);
		//}
		
	}

}
