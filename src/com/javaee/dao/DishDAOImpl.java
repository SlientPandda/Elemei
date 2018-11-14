package com.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javaee.bean.Dish;
import com.javaee.utils.JDBCUtils;

public class DishDAOImpl extends baseDAO implements DishesDAO {

	@Override
	public ArrayList<Dish> findDishes() {
		String sql = "select dishid Dishid,name Dishname,price Price,img Imag,description Descrp,Shopid from dish";
		return this.findObjs(sql,null, Dish.class);
	}
	
	@Override
	public ArrayList<Dish> findDishesBy(String sql, Object[] params) {
		return this.findObjs(sql,params, Dish.class);
	}

	@Override
	public int insertDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalDishRecords() {
		String strsql = "select count(*) from dish";
		return getTotalRecords(strsql);
		
	}

	

}
