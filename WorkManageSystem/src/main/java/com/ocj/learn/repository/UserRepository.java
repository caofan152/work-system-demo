package com.ocj.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ocj.learn.bean.UserBean;

public interface UserRepository extends JpaRepository<UserBean,Long>{

	UserBean findById(int id);
	UserBean findByAccount(int account);
	
	void deleteById(int id);
	
	@Transactional
	@Modifying
	@Query(value="update user set password=?2 where id=?1",nativeQuery = true)
	int updatePassword(int id , String password);
}
