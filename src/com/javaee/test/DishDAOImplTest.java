package com.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.javaee.dao.DishesDAO;
import com.javaee.utils.DAOFactory;

public class DishDAOImplTest {

	DishesDAO dishdao = null;
	@Before
	public void setUp() throws Exception {
		dishdao = (DishesDAO) DAOFactory.newInstance("DishDAO");
	}

	
	public void testFindDishes() {
		assertNotNull(dishdao.findDishes());
		System.out.println(dishdao.findDishes());
	}
	
	@Test
	public void testFindDishesBy() {
		String sql = "select dishid Dishid,name Dishname,price Price,img Imag,"
				+ "description Descrp,Shopid from(select row_number() over (order by dishid) rownum,* from dish) dish_z where rownum between ? and ?";
		Object[] params ={6,11};
		assertNotNull(dishdao.findDishesBy(sql,params));
		System.out.println(dishdao.findDishesBy(sql,params));
	}
	
	@Test
	public void testGetDishNum(){
		assertEquals(18, dishdao.getTotalDishRecords());
	}

}
