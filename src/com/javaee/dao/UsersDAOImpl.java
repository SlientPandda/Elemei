package com.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaee.bean.Users;
import com.javaee.utils.JDBCUtils;

public class UsersDAOImpl extends baseDAO implements UsersDAO {

	@Override
	public ArrayList<Users> findUsers() {
		String sql = "select userid Userid,username Username,password Password from users";
		return this.findObjs(sql,null,Users.class);
	}

	@Override
	public int insertUsers(Users users) {
		String sql = "insert into users(username,password) values(?,?)";
		Object[] params={users.getUsername(),users.getPassword()};
		return this.modifyObj(sql, params);
	}

	@Override
	public int updateUsers(Users users) {
		String sql = "update users set username=?,password=?";
		Object[] params={users.getUsername(),users.getPassword()};
		return this.modifyObj(sql, params);
	}

	@Override
	public int deleteUsers(Users users) {
		String sql = "delete from users where userid =?";
		Object[] params={users.getUserid()};
		return this.modifyObj(sql, params);
	}

	@Override
	public ArrayList<Users> findUsersBy(Users users) {
		String sql = "select userid Userid,username Username,"
				+ "password Password from users "
				+ "where Username=? and Password=?";
		Object[] params={users.getUsername(),users.getPassword()};
		return findObjs(sql, params, Users.class);
	}

}
