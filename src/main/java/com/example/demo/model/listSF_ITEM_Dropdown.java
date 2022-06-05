package com.example.demo.model;

public class listSF_ITEM_Dropdown 
{
	String ITEM_CODE;
	String ITEM_NAME;
	public String getITEM_CODE() {
		return ITEM_CODE;
	}
	public void setITEM_CODE(String iTEM_CODE) {
		ITEM_CODE = iTEM_CODE;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	@Override
	public String toString() {
		return "listSF_ITEM_Dropdown [ITEM_CODE=" + ITEM_CODE + ", ITEM_NAME=" + ITEM_NAME + "]";
	}
	public listSF_ITEM_Dropdown(String iTEM_CODE, String iTEM_NAME) {
		super();
		ITEM_CODE = iTEM_CODE;
		ITEM_NAME = iTEM_NAME;
	}
	public listSF_ITEM_Dropdown() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
