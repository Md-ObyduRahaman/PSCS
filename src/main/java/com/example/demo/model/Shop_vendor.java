package com.example.demo.model;

public class Shop_vendor {
	
	int VEND_ID;
	int HEAD_ID;
	String HEAD_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	String VEND_NAME;
	public Shop_vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_vendor(int vEND_ID, int hEAD_ID, String hEAD_NAME, int sHOP_BR_ID, String sHOP_BR_NAME,
			String vEND_NAME) {
		super();
		VEND_ID = vEND_ID;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		VEND_NAME = vEND_NAME;
	}
	public int getVEND_ID() {
		return VEND_ID;
	}
	public void setVEND_ID(int vEND_ID) {
		VEND_ID = vEND_ID;
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
	public int getSHOP_BR_ID() {
		return SHOP_BR_ID;
	}
	public void setSHOP_BR_ID(int sHOP_BR_ID) {
		SHOP_BR_ID = sHOP_BR_ID;
	}
	public String getSHOP_BR_NAME() {
		return SHOP_BR_NAME;
	}
	public void setSHOP_BR_NAME(String sHOP_BR_NAME) {
		SHOP_BR_NAME = sHOP_BR_NAME;
	}
	public String getVEND_NAME() {
		return VEND_NAME;
	}
	public void setVEND_NAME(String vEND_NAME) {
		VEND_NAME = vEND_NAME;
	}
	@Override
	public String toString() {
		return "Shop_vendor [VEND_ID=" + VEND_ID + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_BR_ID="
				+ SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", VEND_NAME=" + VEND_NAME + "]";
	}


}
