package com.zxc.service;

import org.springframework.stereotype.Service;

import com.zxc.entity.Users;


public interface UsersService {
	int doLogin(String userName, String password);
	int  register(Users users);
}
