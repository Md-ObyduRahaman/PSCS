package com.example.demo.model;

public class Stock {
	
	int STOCK_ID;
	int HEAD_ID;
	String HEAD_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int SHOP_ITEM_ID;
	String ITEM_NAME;
	int BUY_PRICE;
	int BAL;
	int RTL_PRICE;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int sTOCK_ID, int hEAD_ID, String hEAD_NAME, int sHOP_BR_ID, String sHOP_BR_NAME, int sHOP_ITEM_ID,
			String iTEM_NAME, int bUY_PRICE, int bAL, int rTL_PRICE) {
		super();
		STOCK_ID = sTOCK_ID;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		SHOP_ITEM_ID = sHOP_ITEM_ID;
		ITEM_NAME = iTEM_NAME;
		BUY_PRICE = bUY_PRICE;
		BAL = bAL;
		RTL_PRICE = rTL_PRICE;
	}
	@Override
	public String toString() {
		return "Stock [STOCK_ID=" + STOCK_ID + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_BR_ID="
				+ SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", SHOP_ITEM_ID=" + SHOP_ITEM_ID + ", ITEM_NAME="
				+ ITEM_NAME + ", BUY_PRICE=" + BUY_PRICE + ", BAL=" + BAL + ", RTL_PRICE=" + RTL_PRICE + "]";
	}
	public int getSTOCK_ID() {
		return STOCK_ID;
	}
	public void setSTOCK_ID(int sTOCK_ID) {
		STOCK_ID = sTOCK_ID;
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
	public int getSHOP_ITEM_ID() {
		return SHOP_ITEM_ID;
	}
	public void setSHOP_ITEM_ID(int sHOP_ITEM_ID) {
		SHOP_ITEM_ID = sHOP_ITEM_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public int getBUY_PRICE() {
		return BUY_PRICE;
	}
	public void setBUY_PRICE(int bUY_PRICE) {
		BUY_PRICE = bUY_PRICE;
	}
	public int getBAL() {
		return BAL;
	}
	public void setBAL(int bAL) {
		BAL = bAL;
	}
	public int getRTL_PRICE() {
		return RTL_PRICE;
	}
	public void setRTL_PRICE(int rTL_PRICE) {
		RTL_PRICE = rTL_PRICE;
	}

}
