package com.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.javaee.biz.DishService;
import com.javaee.utils.DAOFactory;

public class DishServiceImplTest {

	DishService dishService;
	@Before
	public void setUp() throws Exception {
		dishService = (DishService) DAOFactory.newInstance("DishServ");
	}

	@Test
	public void testFindDish4PageList() {
		int pageNo = 3;
		int pageSize = 6;
		assertNotNull(dishService.findDish4PageList(pageNo, pageSize));
		System.out.println(dishService.findDish4PageList(pageNo, pageSize));
	}

}
