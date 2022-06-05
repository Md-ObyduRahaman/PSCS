package com.example.demo.model;

public class Shop_Item {
	
	int SHOP_ITEM_ID;
	String ITEM_CODE;
	String ITEM_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int BRAND_ID;
	int RTL_PRICE;
	String SHORT_NAME;
	public Shop_Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getSHOP_ITEM_ID() {
		return SHOP_ITEM_ID;
	}
	public void setSHOP_ITEM_ID(int sHOP_ITEM_ID) {
		SHOP_ITEM_ID = sHOP_ITEM_ID;
	}
	public String getITEM_CODE() {
		return ITEM_CODE;
	}
	public void setITEM_CODE(String iTEM_CODE) {
		ITEM_CODE = iTEM_CODE;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
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
	public int getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(int bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	public int getRTL_PRICE() {
		return RTL_PRICE;
	}
	public void setRTL_PRICE(int rTL_PRICE) {
		RTL_PRICE = rTL_PRICE;
	}
	public String getSHORT_NAME() {
		return SHORT_NAME;
	}
	public void setSHORT_NAME(String sHORT_NAME) {
		SHORT_NAME = sHORT_NAME;
	}
	
	public String getSHOP_BR_NAME() {
		return SHOP_BR_NAME;
	}

	public void setSHOP_BR_NAME(String sHOP_BR_NAME) {
		SHOP_BR_NAME = sHOP_BR_NAME;
	}

	@Override
	public String toString() {
		return "Shop_Item [SHOP_ITEM_ID=" + SHOP_ITEM_ID + ", ITEM_CODE=" + ITEM_CODE + ", ITEM_NAME=" + ITEM_NAME
				+ ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_BR_ID=" + SHOP_BR_ID + ", BRAND_ID="
				+ BRAND_ID + ", RTL_PRICE=" + RTL_PRICE + ", SHORT_NAME=" + SHORT_NAME + "]";
	}

	public Shop_Item(int sHOP_ITEM_ID, String iTEM_CODE, String iTEM_NAME, int hEAD_ID, String hEAD_NAME,
			int sHOP_BR_ID, String sHOP_BR_NAME, int bRAND_ID, int rTL_PRICE, String sHORT_NAME) {
		super();
		SHOP_ITEM_ID = sHOP_ITEM_ID;
		ITEM_CODE = iTEM_CODE;
		ITEM_NAME = iTEM_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		BRAND_ID = bRAND_ID;
		RTL_PRICE = rTL_PRICE;
		SHORT_NAME = sHORT_NAME;
	}
	

}
