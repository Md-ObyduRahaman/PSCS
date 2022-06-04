package com.example.demo;

public class User {
	
	int USR_ID;
	int USER_TYPE_ID;
	String USER_TYPE_NAME;
	String USER_NAME;
	String PASS_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	int POS_ID;
	String POS_NAME;
	String EMAIL_ID;
	String VER_CODE;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uSR_ID, int uSER_TYPE_ID, String uSER_TYPE_NAME, String uSER_NAME, String pASS_NAME, int sHOP_BR_ID,
			String sHOP_BR_NAME, int hEAD_ID, String hEAD_NAME, int pOS_ID, String pOS_NAME, String eMAIL_ID,
			String vER_CODE) {
		super();
		USR_ID = uSR_ID;
		USER_TYPE_ID = uSER_TYPE_ID;
		USER_TYPE_NAME = uSER_TYPE_NAME;
		USER_NAME = uSER_NAME;
		PASS_NAME = pASS_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		POS_ID = pOS_ID;
		POS_NAME = pOS_NAME;
		EMAIL_ID = eMAIL_ID;
		VER_CODE = vER_CODE;
	}
	@Override
	public String toString() {
		return "User [USR_ID=" + USR_ID + ", USER_TYPE_ID=" + USER_TYPE_ID + ", USER_TYPE_NAME=" + USER_TYPE_NAME
				+ ", USER_NAME=" + USER_NAME + ", PASS_NAME=" + PASS_NAME + ", SHOP_BR_ID=" + SHOP_BR_ID
				+ ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", POS_ID="
				+ POS_ID + ", POS_NAME=" + POS_NAME + ", EMAIL_ID=" + EMAIL_ID + ", VER_CODE=" + VER_CODE + "]";
	}
	public int getUSR_ID() {
		return USR_ID;
	}
	public void setUSR_ID(int uSR_ID) {
		USR_ID = uSR_ID;
	}
	public int getUSER_TYPE_ID() {
		return USER_TYPE_ID;
	}
	public void setUSER_TYPE_ID(int uSER_TYPE_ID) {
		USER_TYPE_ID = uSER_TYPE_ID;
	}
	public String getUSER_TYPE_NAME() {
		return USER_TYPE_NAME;
	}
	public void setUSER_TYPE_NAME(String uSER_TYPE_NAME) {
		USER_TYPE_NAME = uSER_TYPE_NAME;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPASS_NAME() {
		return PASS_NAME;
	}
	public void setPASS_NAME(String pASS_NAME) {
		PASS_NAME = pASS_NAME;
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
	public String getEMAIL_ID() {
		return EMAIL_ID;
	}
	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}
	public String getVER_CODE() {
		return VER_CODE;
	}
	public void setVER_CODE(String vER_CODE) {
		VER_CODE = vER_CODE;
	}
	
	

}
