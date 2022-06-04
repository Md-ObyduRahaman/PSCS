package com.example.demo;

public class SF_UNIT
{
	int UNIT_ID;
	String UNIT_NAME;
	public int getUNIT_ID() {
		return UNIT_ID;
	}
	public void setUNIT_ID(int uNIT_ID) {
		UNIT_ID = uNIT_ID;
	}
	public String getUNIT_NAME() {
		return UNIT_NAME;
	}
	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}
	@Override
	public String toString() {
		return "SF_UNIT [UNIT_ID=" + UNIT_ID + ", UNIT_NAME=" + UNIT_NAME + "]";
	}
	public SF_UNIT(int uNIT_ID, String uNIT_NAME) {
		super();
		UNIT_ID = uNIT_ID;
		UNIT_NAME = uNIT_NAME;
	}
	public SF_UNIT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
