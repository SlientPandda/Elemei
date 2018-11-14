package com.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.javaee.bean.Users;
import com.javaee.biz.UserService;
import com.javaee.utils.DAOFactory;

public class UserServiceImplTest {
	UserService userserv;
	@Before
	public void setUp() throws Exception {
		userserv = (UserService) DAOFactory.newInstance("UserServ");
	}

	@Test
	public void testValidateUser() {
		Users users = new Users();
		users.setUsername("test");
		users.setPassword("1234");
		assertTrue(userserv.validateUser(users));
	}

}
