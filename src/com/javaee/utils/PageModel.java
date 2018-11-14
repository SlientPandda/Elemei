package com.javaee.utils;

import java.util.ArrayList;

public class PageModel<T> {

	// 每页显示记录数
	private int pageSize;
	// 表中记录数
	private int totalRecords;
	// 当前页码
	private int pageNo;
	// 当前页中所有记录
	private ArrayList<T> list;
	
	

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public ArrayList<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}
	public PageModel(int totalRecords,int pageNo,int pageSize,ArrayList<T> list){
		this.totalRecords = totalRecords;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.list = list;
	}
	/***
	 * 计算页数量
	 * 
	 * @return
	 */
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	/***
	 * 首页
	 * 
	 * @return
	 */
	public int getTop() {
		return 1;
	}

	/***
	 * 下一页
	 * 
	 * @return
	 */
	public int getNext() {
		if (pageNo < getTotalPages()) {
			return pageNo + 1;
		} else {
			return getTotalPages();
		}
	}

	/***
	 * 上一页
	 * 
	 * @return
	 */
	public int getPrev() {
		if (pageNo > 1) {
			return pageNo - 1;
		} else
			return 1;
	}

	/***
	 * 尾页
	 * 
	 * @return
	 */
	public int getBottom() {
		return getTotalPages();
	}
}
