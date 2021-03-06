package com.zxc.service.impl;

import java.util.Objects;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.zxc.dao.UsersDao;
import com.zxc.entity.Users;
import com.zxc.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public int doLogin(String userName, String password) {
		String rightPassword = usersDao.selectPasswordByUserName(userName);
		if(rightPassword == null || ("").equals(rightPassword)) {
			return -1;	//用户名不存在
		}else if(rightPassword != null && !Objects.equals(password,rightPassword)) {
			return 0;	//密码错误
		}else if (rightPassword != null && Objects.equals(password,rightPassword)) {
			return 1;	//登录成功
		}
		return -2;
	}

	@Override
	public int register(Users users) {
		try {
			int result = usersDao.register(users);
			if(result ==0) {
				return 0;
			}
		}catch (Exception e) {
			return -1;
		}
		return -2;
	}

}
