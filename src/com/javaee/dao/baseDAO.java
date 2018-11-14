package com.javaee.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaee.bean.Users;
import com.javaee.utils.JDBCUtils;

public abstract class baseDAO {
	
//	public Object findObj(String sql, Object[] params,Class clazz){
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = JDBCUtils.getConnection();
//			// 创建statement对象
//			ps = conn.prepareStatement(sql);
//			ParameterMetaData pm = ps.getParameterMetaData();
//			for (int i = 1; i <= pm.getParameterCount(); i++) {
//				ps.setObject(i, params[i-1]);
//			}
//			// 处理结果集
//			rs = ps.executeQuery();			
//			while (rs.next()) {
//				Object obj = MappingObj(rs, clazz);
//				return obj;
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtils.free(rs, ps, conn);
//		}
//		return null;
//	}

	public ArrayList findObjs(String sql,Object[] params, Class clazz) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList objlist = null;
		try {
			conn = JDBCUtils.getConnection();
			// 创建statement对象
			ps = conn.prepareStatement(sql);
			if(null != params){
				ParameterMetaData pm = ps.getParameterMetaData();
				for (int i = 1; i <= pm.getParameterCount(); i++) {
					ps.setObject(i, params[i-1]);
				}
			}
			// 处理结果集
			rs = ps.executeQuery();
			objlist = new ArrayList();
			while (rs.next()) {
				Object obj = MappingObj(rs, clazz);
				objlist.add(obj);
			}
			return objlist;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, ps, conn);
		}
		return null;
	}

	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Object MappingObj(ResultSet rs, Class clazz) throws SQLException {
		// Users users = new Users();
		// users.setUserid(rs.getInt(1));
		// users.setUsername(rs.getString(2));
		// users.setPassword(rs.getString("password"));
		// 实例化对象
		Object obj;
		try {
			obj = clazz.newInstance();
			// 获取映射对象的方法集合
			Method[] methods = clazz.getMethods();
			// 获取结果集中元数据信息
			ResultSetMetaData meta = rs.getMetaData();
			// 按字段数目循环结果集中记录，进行对象映射
			int j = meta.getColumnCount();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				// 构造当前列的set方法名称
				String colname = meta.getColumnLabel(i);
				String methodname = "set" + colname;
				// 循环查找同名方法，并通过反射调用该方法，设置属性值
				System.out.println(methodname);
     			System.out.println(methodname.getClass());
				for (Method method : methods) {
					if (method.getName().equals(methodname)) {
						System.out.println(rs.getObject(i).getClass());
						Object rsobj = rs.getObject(i);
						method.invoke(obj, rsobj);
						break;
					}
				}				
			}
			return obj;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int modifyObj(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			// 创建statement对象
			ps = conn.prepareStatement(sql);
			ParameterMetaData pm = ps.getParameterMetaData();
			for (int i = 1; i <= pm.getParameterCount(); i++) {
				ps.setObject(i, params[i-1]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, ps, conn);
		}
		return 0;
	}
	
	public int getTotalRecords(String sql){
		int count = 0;
		try {
			Connection conn = JDBCUtils.getConnection();
//			String sql = "select count(*) from dish ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			JDBCUtils.free(rs, ps, conn);
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return count;
	}
}
