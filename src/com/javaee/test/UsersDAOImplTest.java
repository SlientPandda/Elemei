package com.javaee.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.javaee.bean.Users;
import com.javaee.dao.UsersDAO;
import com.javaee.dao.UsersDAOImpl;
import com.javaee.utils.DAOFactory;

public class UsersDAOImplTest {

	UsersDAO userdao = null;

	@Before
	public void setUp() throws Exception {
		userdao = (UsersDAO) DAOFactory.newInstance("UserDAO");
		
	}

	
	public void testFindUsers() {
		assertNotNull(userdao.findUsers());
		ArrayList userslist = userdao.findUsers();
		for (int i = 0; i < userslist.size(); i++) {
			Users user = (Users) userslist.get(i);
			System.out.print(user.getUserid());
			System.out.print(user.getUsername());
			System.out.print(user.getPassword());

		}
	}
	
	@Test
	public void testFindUsersby() {
		Users users = new Users();
		users.setUsername("test");
		users.setPassword("1234");
		assertNotNull(userdao.findUsersBy(users));
		ArrayList userslist = userdao.findUsersBy(users);
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		System.out.println(userslist);
	}
	

	
	public void testInsertUsers() {
		Users user = new Users();
		user.setUsername("test");
		user.setPassword("1234");
		assertEquals(1, userdao.insertUsers(user));
	}

	public void testUpdateUsers() {
		fail("Not yet implemented");
	}

	
	public void testDeleteUsers() {
		Users user = new Users();
		user.setUserid(48);
		assertEquals(1, userdao.deleteUsers(user));
	}

}
