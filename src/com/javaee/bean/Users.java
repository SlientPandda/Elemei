package com.javaee.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Users {
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}
	private int userid;	
	private String username;
	private String password;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
