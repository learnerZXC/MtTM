package com.zxc.service;

import org.springframework.stereotype.Service;


public interface UsersService {
	int doLogin(String userName, String password);
}
