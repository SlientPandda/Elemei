package com.javaee.biz;

import com.javaee.bean.Users;
import com.javaee.dao.UsersDAO;
import com.javaee.utils.DAOFactory;

public class UserServiceImpl  {


	public boolean validateUser(Users users) {
		// UsersDAO userdao = new UsersDAOImpl();
		UsersDAO userdao = (UsersDAO) DAOFactory.newInstance("UserDAO");
		if (userdao.findUsersBy(users) != null) {
			return true;
		} else {
			return false;
		}
	}
}
