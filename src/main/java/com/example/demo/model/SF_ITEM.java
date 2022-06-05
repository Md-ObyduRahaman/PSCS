package com.example.demo.model;

public class SF_ITEM 
{
	int ITEM_ID;
	String ITEM_CODE;
	String ITEM_NAME;
	int HEAD_ID;
	int LEVEL_ID;
	int SUB_HEAD_ID;
	
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
	public int getLEVEL_ID() {
		return LEVEL_ID;
	}
	public void setLEVEL_ID(int lEVEL_ID) {
		LEVEL_ID = lEVEL_ID;
	}
	public int getSUB_HEAD_ID() {
		return SUB_HEAD_ID;
	}
	public void setSUB_HEAD_ID(int sUB_HEAD_ID) {
		SUB_HEAD_ID = sUB_HEAD_ID;
	}
	@Override
	public String toString() {
		return "SF_ITEM [ITEM_ID=" + ITEM_ID + ", ITEM_CODE=" + ITEM_CODE + ", ITEM_NAME=" + ITEM_NAME + ", HEAD_ID="
				+ HEAD_ID + ", LEVEL_ID=" + LEVEL_ID + ", SUB_HEAD_ID=" + SUB_HEAD_ID + "]";
	}
	public SF_ITEM(int iTEM_ID, String iTEM_CODE, String iTEM_NAME, int hEAD_ID, int lEVEL_ID, int sUB_HEAD_ID) {
		super();
		ITEM_ID = iTEM_ID;
		ITEM_CODE = iTEM_CODE;
		ITEM_NAME = iTEM_NAME;
		HEAD_ID = hEAD_ID;
		LEVEL_ID = lEVEL_ID;
		SUB_HEAD_ID = sUB_HEAD_ID;
	}
	public SF_ITEM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
