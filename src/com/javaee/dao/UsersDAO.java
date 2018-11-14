package com.javaee.dao;

import java.util.ArrayList;

import com.javaee.bean.Users;

public interface UsersDAO {
	public ArrayList<Users> findUsers();
	public ArrayList<Users> findUsersBy(Users users);
	public int insertUsers(Users users);
	public int updateUsers(Users users);
	public int deleteUsers(Users users);
}
