package com.example.demo.model;

public class DISTRICT_DROPDOWN
{
	int DIST_ID;
	String DIST_NAME;

	public DISTRICT_DROPDOWN() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "DISTRICT_DROPDOWN [DIST_ID=" + DIST_ID + ", DIST_NAME=" + DIST_NAME + "]";
	}

	public DISTRICT_DROPDOWN(int dIST_ID, String dIST_NAME) {
		super();
		DIST_ID = dIST_ID;
		DIST_NAME = dIST_NAME;
	}

	


}
