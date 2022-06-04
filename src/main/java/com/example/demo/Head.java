package com.example.demo;

public class Head {
	int HEAD_ID;
	String HEAD_NAME;
	public Head() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Head(int hEAD_ID, String hEAD_NAME) {
		super();
		HEAD_ID = hEAD_ID;
		HEAD_NAME = hEAD_NAME;
	}
	@Override
	public String toString() {
		return "Head [HEAD_ID=" + HEAD_ID + ", HEAD_NAME=" + HEAD_NAME + "]";
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

}
