package com.example.demo.model;

public class Item_buy {
	
	int ITEM_CODE;
	String[] ITEM_NAME;
	int HEAD_ID;
	int SHOP_BR_ID;
	int[] ITEM_QTY;
	int[] UNIT;
	int[] BUY_PRICE;
	int[] RTL_PRICE;
	int VEND_ID;
	String VEND_NAME;
	String TransCode;
	int TOTAL_PRICE;
	//int POS_ID;
	
	
	
	
	@Override
	public String toString() {
		return "Item_buy [ITEM_CODE=" + ITEM_CODE + ", ITEM_NAME=" + ITEM_NAME + ", HEAD_ID=" + HEAD_ID
				+ ", SHOP_BR_ID=" + SHOP_BR_ID + ", ITEM_QTY=" + ITEM_QTY + ", UNIT=" + UNIT + ", BUY_PRICE="
				+ BUY_PRICE + ", RTL_PRICE=" + RTL_PRICE + ", VEND_ID=" + VEND_ID + ", VEND_NAME=" + VEND_NAME
				+ ", TransCode=" + TransCode + ", TOTAL_PRICE=" + TOTAL_PRICE + "]";
	}
	
	public int getITEM_CODE() {
		return ITEM_CODE;
	}

	public void setITEM_CODE(int iTEM_CODE) {
		ITEM_CODE = iTEM_CODE;
	}

	public String[] getITEM_NAME() {
		return ITEM_NAME;
	}

	public void setITEM_NAME(String[] iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}

	public int getHEAD_ID() {
		return HEAD_ID;
	}

	public void setHEAD_ID(int hEAD_ID) {
		HEAD_ID = hEAD_ID;
	}

	public int getSHOP_BR_ID() {
		return SHOP_BR_ID;
	}

	public void setSHOP_BR_ID(int sHOP_BR_ID) {
		SHOP_BR_ID = sHOP_BR_ID;
	}

	public int[] getITEM_QTY() {
		return ITEM_QTY;
	}

	public void setITEM_QTY(int[] iTEM_QTY) {
		ITEM_QTY = iTEM_QTY;
	}

	public int[] getUNIT() {
		return UNIT;
	}

	public void setUNIT(int[] uNIT) {
		UNIT = uNIT;
	}

	public int[] getBUY_PRICE() {
		return BUY_PRICE;
	}

	public void setBUY_PRICE(int[] bUY_PRICE) {
		BUY_PRICE = bUY_PRICE;
	}

	public int[] getRTL_PRICE() {
		return RTL_PRICE;
	}

	public void setRTL_PRICE(int[] rTL_PRICE) {
		RTL_PRICE = rTL_PRICE;
	}

	public int getVEND_ID() {
		return VEND_ID;
	}

	public void setVEND_ID(int vEND_ID) {
		VEND_ID = vEND_ID;
	}

	public String getVEND_NAME() {
		return VEND_NAME;
	}

	public void setVEND_NAME(String vEND_NAME) {
		VEND_NAME = vEND_NAME;
	}

	public String getTransCode() {
		return TransCode;
	}

	public void setTransCode(String transCode) {
		TransCode = transCode;
	}

	public int getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}

	public void setTOTAL_PRICE(int tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}

	
	
	public Item_buy(int iTEM_CODE, String[] iTEM_NAME, int hEAD_ID, int sHOP_BR_ID, int[] iTEM_QTY, int[] uNIT,
			int[] bUY_PRICE, int[] rTL_PRICE, int vEND_ID, String vEND_NAME, String transCode, int tOTAL_PRICE) {
		super();
		ITEM_CODE = iTEM_CODE;
		ITEM_NAME = iTEM_NAME;
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		ITEM_QTY = iTEM_QTY;
		UNIT = uNIT;
		BUY_PRICE = bUY_PRICE;
		RTL_PRICE = rTL_PRICE;
		VEND_ID = vEND_ID;
		VEND_NAME = vEND_NAME;
		TransCode = transCode;
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public Item_buy(int iTEM_CODE, int hEAD_ID, int sHOP_BR_ID, int[] iTEM_QTY, int[] uNIT, int[] bUY_PRICE,
			int[] rTL_PRICE, int vEND_ID, String transCode, int tOTAL_PRICE) {
		super();
		ITEM_CODE = iTEM_CODE;
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		ITEM_QTY = iTEM_QTY;
		UNIT = uNIT;
		BUY_PRICE = bUY_PRICE;
		RTL_PRICE = rTL_PRICE;
		VEND_ID = vEND_ID;
		TransCode = transCode;
		TOTAL_PRICE = tOTAL_PRICE;
	}

	public Item_buy() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	

}
