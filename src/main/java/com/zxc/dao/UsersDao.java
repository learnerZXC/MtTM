package com.zxc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UsersDao {
	
	@Select("select password from tm_users where username =#{userName}")
	String selectPasswordByUserName(@Param("userName") String userName);
	
}
