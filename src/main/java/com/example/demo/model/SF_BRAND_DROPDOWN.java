package com.example.demo.model;

public class SF_BRAND_DROPDOWN
{
	int BRAND_ID;
	String BRAND_NAME;
	public int getBRAND_ID() {
		return BRAND_ID;
	}
	public void setBRAND_ID(int bRAND_ID) {
		BRAND_ID = bRAND_ID;
	}
	public String getBRAND_NAME() {
		return BRAND_NAME;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		BRAND_NAME = bRAND_NAME;
	}
	@Override
	public String toString() {
		return "SF_BRAND_DROPDOWN [BRAND_ID=" + BRAND_ID + ", BRAND_NAME=" + BRAND_NAME + "]";
	}
	public SF_BRAND_DROPDOWN(int bRAND_ID, String bRAND_NAME) {
		super();
		BRAND_ID = bRAND_ID;
		BRAND_NAME = bRAND_NAME;
	}
	public SF_BRAND_DROPDOWN() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
