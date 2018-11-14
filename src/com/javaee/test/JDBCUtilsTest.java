package com.javaee.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.javaee.utils.JDBCUtils;

public class JDBCUtilsTest {	
	DataSource myds;
	Context ic;
	
	@Before
	public void setUp() throws Exception {		
		ic = new InitialContext();
		myds = (DataSource)ic.lookup("java:comp/env/jdbc/test");
		JDBCUtils.setMyds(myds);
	}

	@Test
	public void testGetConnection() throws SQLException {
		for(int i=0;i<10;i++){
			Connection conn = JDBCUtils.getConnection();
			System.out.println(conn.hashCode());
			conn.close();
		}
	}

}
