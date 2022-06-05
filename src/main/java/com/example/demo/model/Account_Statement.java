package com.example.demo.model;

public class Account_Statement {
	
	String SHOP_GL_ID;
	
	String GL_NAME;
	
	String AMT;

	public Account_Statement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account_Statement(String sHOP_GL_ID, String gL_NAME, String aMT) {
		super();
		SHOP_GL_ID = sHOP_GL_ID;
		GL_NAME = gL_NAME;
		AMT = aMT;
	}

	@Override
	public String toString() {
		return "Account_Statement [SHOP_GL_ID=" + SHOP_GL_ID + ", GL_NAME=" + GL_NAME + ", AMT=" + AMT + "]";
	}

	public String getSHOP_GL_ID() {
		return SHOP_GL_ID;
	}

	public void setSHOP_GL_ID(String sHOP_GL_ID) {
		SHOP_GL_ID = sHOP_GL_ID;
	}

	public String getGL_NAME() {
		return GL_NAME;
	}

	public void setGL_NAME(String gL_NAME) {
		GL_NAME = gL_NAME;
	}

	public String getAMT() {
		return AMT;
	}

	public void setAMT(String aMT) {
		AMT = aMT;
	}
	
	

}
