package com.zxc.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxc.entity.Users;
import com.zxc.service.UsersService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private UsersController usersController;
	
	@Test
	public void doLoginTest1() {
		assertEquals(1, usersController.doLogin("zxc1", "admin"));
	}
	@Test
	public void doLoginTest2() {
		assertEquals(0, usersController.doLogin("zxc", "admin1"));
	}
	@Test
	public void doLoginTest3() {
		assertEquals(-1, usersController.doLogin("zxc11", "admin"));
	}
	
	@Test
	public void registerTest1() {
		Users users = new Users("zxc1","admin");
		assertEquals(-1, usersController.register(users));
	}
	
}
