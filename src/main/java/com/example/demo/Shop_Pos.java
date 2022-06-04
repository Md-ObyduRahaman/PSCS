package com.example.demo;

public class Shop_Pos {
	
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	int POS_ID;
	String POS_NAME;

	public Shop_Pos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop_Pos(int sHOP_BR_ID, String sHOP_BR_NAME, int hEAD_ID, String hEAD_NAME, int pOS_ID, String pOS_NAME) {
		super();
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		POS_ID = pOS_ID;
		POS_NAME = pOS_NAME;
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

	public int getPOS_ID() {
		return POS_ID;
	}

	public void setPOS_ID(int pOS_ID) {
		POS_ID = pOS_ID;
	}

	public String getPOS_NAME() {
		return POS_NAME;
	}

	public void setPOS_NAME(String pOS_NAME) {
		POS_NAME = pOS_NAME;
	}

	@Override
	public String toString() {
		return "Shop_Pos [SHOP_BR_ID=" + SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", HEAD_ID=" + HEAD_ID
				+ ", HEAD_NAME=" + HEAD_NAME + ", POS_ID=" + POS_ID + ", POS_NAME=" + POS_NAME + "]";
	}


}
