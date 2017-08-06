package com.zxc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
