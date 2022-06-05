package com.example.demo.model;

public class Shop_Br {
	
	int SHOP_BR_ID;
	int SHOP_ID;
	String SHOP_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	String SHOP_BR_NAME;
	
	public int getSHOP_BR_ID() {
		return SHOP_BR_ID;
	}
	public void setSHOP_BR_ID(int sHOP_BR_ID) {
		SHOP_BR_ID = sHOP_BR_ID;
	}
	public int getSHOP_ID() {
		return SHOP_ID;
	}
	public void setSHOP_ID(int sHOP_ID) {
		SHOP_ID = sHOP_ID;
	}
	public String getSHOP_NAME() {
		return SHOP_NAME;
	}
	public void setSHOP_NAME(String sHOP_NAME) {
		SHOP_NAME = sHOP_NAME;
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
	public String getSHOP_BR_NAME() {
		return SHOP_BR_NAME;
	}
	public void setSHOP_BR_NAME(String sHOP_BR_NAME) {
		SHOP_BR_NAME = sHOP_BR_NAME;
	}
	@Override
	public String toString() {
		return "Shop_Br [SHOP_BR_ID=" + SHOP_BR_ID + ", SHOP_ID=" + SHOP_ID + ", SHOP_NAME=" + SHOP_NAME + ", HEAD_ID="
				+ HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_BR_NAME=" + SHOP_BR_NAME + "]";
	}
	public Shop_Br(int sHOP_BR_ID, int sHOP_ID, String sHOP_NAME, int hEAD_ID, String hEAD_NAME, String sHOP_BR_NAME) {
		super();
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_ID = sHOP_ID;
		SHOP_NAME = sHOP_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_NAME = sHOP_BR_NAME;
	}
	public Shop_Br() {
		super();
		// TODO Auto-generated constructor stub
	}

}
