package com.example.demo.model;

public class Shop_Contact {
	
	int CON_ID;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	String CON_NAME;
	String CON_PHN1;
	String CON_PHN2;
	String CON_EMAIL;
	String CON_NID;
	String CON_TIN;
	String CON_ADDR1;
	String CON_ADDR2;
	public Shop_Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_Contact(int cON_ID, int sHOP_BR_ID, String sHOP_BR_NAME, int hEAD_ID, String hEAD_NAME, String cON_NAME,
			String cON_PHN1, String cON_PHN2, String cON_EMAIL, String cON_NID, String cON_TIN, String cON_ADDR1,
			String cON_ADDR2) {
		super();
		CON_ID = cON_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		CON_NAME = cON_NAME;
		CON_PHN1 = cON_PHN1;
		CON_PHN2 = cON_PHN2;
		CON_EMAIL = cON_EMAIL;
		CON_NID = cON_NID;
		CON_TIN = cON_TIN;
		CON_ADDR1 = cON_ADDR1;
		CON_ADDR2 = cON_ADDR2;
	}
	@Override
	public String toString() {
		return "Shop_Contact [CON_ID=" + CON_ID + ", SHOP_BR_ID=" + SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME
				+ ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + ", CON_NAME=" + CON_NAME + ", CON_PHN1="
				+ CON_PHN1 + ", CON_PHN2=" + CON_PHN2 + ", CON_EMAIL=" + CON_EMAIL + ", CON_NID=" + CON_NID
				+ ", CON_TIN=" + CON_TIN + ", CON_ADDR1=" + CON_ADDR1 + ", CON_ADDR2=" + CON_ADDR2 + "]";
	}
	public int getCON_ID() {
		return CON_ID;
	}
	public void setCON_ID(int cON_ID) {
		CON_ID = cON_ID;
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
	public String getCON_NAME() {
		return CON_NAME;
	}
	public void setCON_NAME(String cON_NAME) {
		CON_NAME = cON_NAME;
	}
	public String getCON_PHN1() {
		return CON_PHN1;
	}
	public void setCON_PHN1(String cON_PHN1) {
		CON_PHN1 = cON_PHN1;
	}
	public String getCON_PHN2() {
		return CON_PHN2;
	}
	public void setCON_PHN2(String cON_PHN2) {
		CON_PHN2 = cON_PHN2;
	}
	public String getCON_EMAIL() {
		return CON_EMAIL;
	}
	public void setCON_EMAIL(String cON_EMAIL) {
		CON_EMAIL = cON_EMAIL;
	}
	public String getCON_NID() {
		return CON_NID;
	}
	public void setCON_NID(String cON_NID) {
		CON_NID = cON_NID;
	}
	public String getCON_TIN() {
		return CON_TIN;
	}
	public void setCON_TIN(String cON_TIN) {
		CON_TIN = cON_TIN;
	}
	public String getCON_ADDR1() {
		return CON_ADDR1;
	}
	public void setCON_ADDR1(String cON_ADDR1) {
		CON_ADDR1 = cON_ADDR1;
	}
	public String getCON_ADDR2() {
		return CON_ADDR2;
	}
	public void setCON_ADDR2(String cON_ADDR2) {
		CON_ADDR2 = cON_ADDR2;
	}

}
