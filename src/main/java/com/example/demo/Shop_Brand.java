package com.example.demo;

public class Shop_Brand {
	
	int BRAND_ID;
	int HEAD_ID;
	String HEAD_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	String BRAND_NAME;
	public Shop_Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_Brand(int bRAND_ID, int hEAD_ID, String hEAD_NAME, int sHOP_BR_ID, String sHOP_BR_NAME,
			String bRAND_NAME) {
		super();
		BRAND_ID = bRAND_ID;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		BRAND_NAME = bRAND_NAME;
	}
	@Override
	public String toString() {
		return "Shop_Brand [BRAND_ID=" + BRAND_ID + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME
				+ ", SHOP_BR_ID=" + SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", BRAND_NAME=" + BRAND_NAME + "]";
	}
	public int getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(int bRAND_ID) {
		BRAND_ID = bRAND_ID;
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
	public String getBRAND_NAME() {
		return BRAND_NAME;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		BRAND_NAME = bRAND_NAME;
	}

}
