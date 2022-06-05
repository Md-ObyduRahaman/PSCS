package com.example.demo.model;

public class Item {
	
	int ITEM_ID;
	String ITEM_CODE;
	int HEAD_ID;
	String HEAD_NAME;
	String ITEM_NAME;
	String LEVEL_ID;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Item(int iTEM_ID, String iTEM_CODE, int hEAD_ID, String hEAD_NAME, String iTEM_NAME, String lEVEL_ID) {
		super();
		ITEM_ID = iTEM_ID;
		ITEM_CODE = iTEM_CODE;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		ITEM_NAME = iTEM_NAME;
		LEVEL_ID = lEVEL_ID;
	}
	
	public String getHEAD_NAME() {
		return HEAD_NAME;
	}

	public void setHEAD_NAME(String hEAD_NAME) {
		HEAD_NAME = hEAD_NAME;
	}

	public int getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(int iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getITEM_CODE() {
		return ITEM_CODE;
	}
	public void setITEM_CODE(String iTEM_CODE) {
		ITEM_CODE = iTEM_CODE;
	}
	public int getHEAD_ID() {
		return HEAD_ID;
	}
	public void setHEAD_ID(int hEAD_ID) {
		HEAD_ID = hEAD_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public String getLEVEL_ID() {
		return LEVEL_ID;
	}
	public void setLEVEL_ID(String lEVEL_ID) {
		LEVEL_ID = lEVEL_ID;
	}
	@Override
	public String toString() {
		return "Item [ITEM_ID=" + ITEM_ID + ", ITEM_CODE=" + ITEM_CODE + ", HEAD_ID=" + HEAD_ID + ", ITEM_NAME="
				+ ITEM_NAME + ", LEVEL_ID=" + LEVEL_ID + "]";
	}
	
	

}
