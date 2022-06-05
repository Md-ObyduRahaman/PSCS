package com.example.demo.model;

public class Shop {
	
	int SHOP_ID;
	int HEAD_ID;
	String HEAD_NAME;
	String SHOP_NAME;
	public int getSHOP_ID() {
		return SHOP_ID;
	}
	public void setSHOP_ID(int sHOP_ID) {
		SHOP_ID = sHOP_ID;
	}
	public int getHEAD_ID() {
		return HEAD_ID;
	}
	public void setHEAD_ID(int hEAD_ID) {
		HEAD_ID = hEAD_ID;
	}
	public String getHEAD_NAME() {
		return HEAD_NAME;
	}
	public void setHEAD_NAME(String hEAD_NAME) {
		HEAD_NAME = hEAD_NAME;
	}
	public String getSHOP_NAME() {
		return SHOP_NAME;
	}
	public void setSHOP_NAME(String sHOP_NAME) {
		SHOP_NAME = sHOP_NAME;
	}
	@Override
	public String toString() {
		return "Shop [SHOP_ID=" + SHOP_ID + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_NAME="
				+ SHOP_NAME + "]";
	}
	public Shop(int sHOP_ID, int hEAD_ID, String hEAD_NAME, String sHOP_NAME) {
		super();
		SHOP_ID = sHOP_ID;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_NAME = sHOP_NAME;
	}
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

}
