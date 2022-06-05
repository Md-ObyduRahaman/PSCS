package com.example.demo.model;

public class Month
{
	String MONTH_CODE,MONTH_NAME;

	public String getMONTH_CODE() {
		return MONTH_CODE;
	}

	public void setMONTH_CODE(String mONTH_CODE) {
		MONTH_CODE = mONTH_CODE;
	}

	public String getMONTH_NAME() {
		return MONTH_NAME;
	}

	public void setMONTH_NAME(String mONTH_NAME) {
		MONTH_NAME = mONTH_NAME;
	}

	@Override
	public String toString() {
		return "Month [MONTH_CODE=" + MONTH_CODE + ", MONTH_NAME=" + MONTH_NAME + "]";
	}

	public Month(String mONTH_CODE, String mONTH_NAME) {
		super();
		MONTH_CODE = mONTH_CODE;
		MONTH_NAME = mONTH_NAME;
	}

	public Month() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
