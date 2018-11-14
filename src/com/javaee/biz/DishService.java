package com.javaee.biz;

import java.util.ArrayList;

public interface DishService {

	/***
	 * 分页查询
	 * @param pageNo 当前页码
	 * @param pageSize 页面大小
	 * @return 当前页的所有记录
	 */
	public ArrayList findDish4PageList(int pageNo, int pageSize);
	
	public int getTotalRecords();
}
