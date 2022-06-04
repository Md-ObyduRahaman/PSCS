package com.example.demo;

public class THANA_DROPDOWN 
{
	int THANA_ID;
	String THANA_NAME;
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
	@Override
	public String toString() {
		return "THANA_DROPDOWN [THANA_ID=" + THANA_ID + ", THANA_NAME=" + THANA_NAME + "]";
	}
	public THANA_DROPDOWN(int tHANA_ID, String tHANA_NAME) {
		super();
		THANA_ID = tHANA_ID;
		THANA_NAME = tHANA_NAME;
	}
	public THANA_DROPDOWN() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
