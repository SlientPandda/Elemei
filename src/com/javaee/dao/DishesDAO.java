package com.javaee.dao;

import java.util.ArrayList;

import com.javaee.bean.Dish;

public interface DishesDAO {
	public ArrayList<Dish> findDishes();
	public ArrayList<Dish> findDishesBy(String sql,Object[] params);
	/***
	 * 查找dish表中记录数
	 * @return
	 */
	public int getTotalDishRecords();
	public int insertDish(Dish dish);
	public int updateDish(Dish dish);
	public int deleteDish(Dish dish);
}
