package com.javaee.biz;

import java.util.ArrayList;

public interface DishService {

	/***
	 * ��ҳ��ѯ
	 * @param pageNo ��ǰҳ��
	 * @param pageSize ҳ���С
	 * @return ��ǰҳ�����м�¼
	 */
	public ArrayList findDish4PageList(int pageNo, int pageSize);
	
	public int getTotalRecords();
}
