package com.javaee.bean;

import java.math.BigDecimal;

public class Dish {
	@Override
	public String toString() {
		return "Dish [dishid=" + dishid + ", dishname=" + dishname + ", price=" + price + ", desc=" + descrp + ", imag="
				+ imag + ",shopid="+shopid+"]";
	}
	private int dishid;	
	private String dishname;
	private Double price;
	private String descrp;
	private String imag;
	private int shopid;
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescrp() {
		return descrp;
	}
	public void setDescrp(String desc) {
		this.descrp = desc;
	}
	public String getImag() {
		return imag;
	}
	public void setImag(String imag) {
		this.imag = imag;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	
}
