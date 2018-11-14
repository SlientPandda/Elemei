package com.javaee.biz;

import java.util.ArrayList;

import com.javaee.dao.DishesDAO;
import com.javaee.utils.DAOFactory;

public class DishServiceImpl implements DishService {

	@Override
	public ArrayList findDish4PageList(int pageNo, int pageSize) {
		DishesDAO dishDAO = (DishesDAO) DAOFactory.newInstance("DishDAO");
//		String sql = "select dishid Dishid,name Dishname,price Price,img Imag,description Descrp,Shopid from(select row_number() over (order by dishid) rownum,* from dish) dish_z where rownum >= ? and rownum<=?";
	    String sql="select dishid Dishid,name Dishname,price Price,img Imag,description Descrp,Shopid from dish where dishid>=? and dishid<=?";
		Object[] params ={(pageNo-1)*pageSize+1,pageSize*pageNo};
		return dishDAO.findDishesBy(sql,params);
		
	}

	@Override
	public int getTotalRecords() {
		DishesDAO dishDAO = (DishesDAO) DAOFactory.newInstance("DishDAO");
		return dishDAO.getTotalDishRecords();
	}	

}
