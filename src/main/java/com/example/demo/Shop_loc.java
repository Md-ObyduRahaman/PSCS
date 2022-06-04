package com.example.demo;

public class Shop_loc {
	
	int LOC_ID;
	int DIV_ID;
	String DIV_NAME;
	int DIST_ID;
	String DIST_NAME;
	int THANA_ID;
	String THANA_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	int HEAD_ID;
	String HEAD_NAME;
	String CON_ADDR1;
	String CON_ADDR2;
	public Shop_loc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_loc(int lOC_ID, int dIV_ID, String dIV_NAME, int dIST_ID, String dIST_NAME, int tHANA_ID,
			String tHANA_NAME, int sHOP_BR_ID, String sHOP_BR_NAME, int hEAD_ID, String hEAD_NAME, String cON_ADDR1,
			String cON_ADDR2) {
		super();
		LOC_ID = lOC_ID;
		DIV_ID = dIV_ID;
		DIV_NAME = dIV_NAME;
		DIST_ID = dIST_ID;
		DIST_NAME = dIST_NAME;
		THANA_ID = tHANA_ID;
		THANA_NAME = tHANA_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		CON_ADDR1 = cON_ADDR1;
		CON_ADDR2 = cON_ADDR2;
	}
	@Override
	public String toString() {
		return "Shop_loc [LOC_ID=" + LOC_ID + ", DIV_ID=" + DIV_ID + ", DIV_NAME=" + DIV_NAME + ", DIST_ID=" + DIST_ID
				+ ", DIST_NAME=" + DIST_NAME + ", THANA_ID=" + THANA_ID + ", THANA_NAME=" + THANA_NAME + ", SHOP_BR_ID="
				+ SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME
				+ ", CON_ADDR1=" + CON_ADDR1 + ", CON_ADDR2=" + CON_ADDR2 + "]";
	}
	public int getLOC_ID() {
		return LOC_ID;
	}
	public void setLOC_ID(int lOC_ID) {
		LOC_ID = lOC_ID;
	}
	public int getDIV_ID() {
		return DIV_ID;
	}
	public void setDIV_ID(int dIV_ID) {
		DIV_ID = dIV_ID;
	}
	public String getDIV_NAME() {
		return DIV_NAME;
	}
	public void setDIV_NAME(String dIV_NAME) {
		DIV_NAME = dIV_NAME;
	}
	public int getDIST_ID() {
		return DIST_ID;
	}
	public void setDIST_ID(int dIST_ID) {
		DIST_ID = dIST_ID;
	}
	public String getDIST_NAME() {
		return DIST_NAME;
	}
	public void setDIST_NAME(String dIST_NAME) {
		DIST_NAME = dIST_NAME;
	}
	public int getTHANA_ID() {
		return THANA_ID;
	}
	public void setTHANA_ID(int tHANA_ID) {
		THANA_ID = tHANA_ID;
	}
	public String getTHANA_NAME() {
		return THANA_NAME;
	}
	public void setTHANA_NAME(String tHANA_NAME) {
		THANA_NAME = tHANA_NAME;
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
