package com.zxc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.zxc.entity.Users;
import com.zxc.service.UsersService;

/*
 * 用户类的controller层
 */

@Controller
@RequestMapping(value = "/users")
public class UsersController {
	@Autowired
	private UsersService usersService ;
	
	@RequestMapping(value = "/login")
	public String Login() {
		return "login";
	}
	@RequestMapping(value = "/dologin")
	public int doLogin(String userName,String password){
		int result = usersService.doLogin(userName, password);
		if(result == 1) {
			return 1; //登录成功
		}else if(result == -1){
			return -1; //用户名不存在
		}else if(result == 0){
			return 0;	//密码错误
		}
		return -2;
	}
	
	public  int  register (Users users) {
		int result = usersService.register(users);
		if(result == 0) {
			return 0; //注册成功
		}else if(result ==-1) {
			return -1; //注册失败
		}
		return -2;
	}
}
