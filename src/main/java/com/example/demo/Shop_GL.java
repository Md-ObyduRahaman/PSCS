package com.example.demo;

public class Shop_GL {
	
	int SHOP_GL_ID;
	int HEAD_ID;
	String HEAD_NAME;
	int SHOP_BR_ID;
	String SHOP_BR_NAME;
	String GL_NAME;
	String TYPE;
	
	public Shop_GL() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_GL(int sHOP_GL_ID, int hEAD_ID, String hEAD_NAME, int sHOP_BR_ID, String sHOP_BR_NAME, String gL_NAME,
			String tYPE) {
		super();
		SHOP_GL_ID = sHOP_GL_ID;
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_ID = sHOP_BR_ID;
		SHOP_BR_NAME = sHOP_BR_NAME;
		GL_NAME = gL_NAME;
		TYPE = tYPE;
	}
	@Override
	public String toString() {
		return "Shop_GL [SHOP_GL_ID=" + SHOP_GL_ID + ", HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME
				+ ", SHOP_BR_ID=" + SHOP_BR_ID + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", GL_NAME=" + GL_NAME + ", TYPE="
				+ TYPE + "]";
	}
	public int getSHOP_GL_ID() {
		return SHOP_GL_ID;
	}
	public void setSHOP_GL_ID(int sHOP_GL_ID) {
		SHOP_GL_ID = sHOP_GL_ID;
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
	public String getGL_NAME() {
		return GL_NAME;
	}
	public void setGL_NAME(String gL_NAME) {
		GL_NAME = gL_NAME;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	
	

}
