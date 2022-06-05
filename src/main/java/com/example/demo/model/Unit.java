package com.example.demo.model;

public class Unit {
	
	String UNIT_CODE,UNIT_NAME;

	public Unit(String uNIT_CODE, String uNIT_NAME) {
		super();
		UNIT_CODE = uNIT_CODE;
		UNIT_NAME = uNIT_NAME;
	}

	public String getUNIT_CODE() {
		return UNIT_CODE;
	}

	public void setUNIT_CODE(String uNIT_CODE) {
		UNIT_CODE = uNIT_CODE;
	}

	public String getUNIT_NAME() {
		return UNIT_NAME;
	}

	public void setUNIT_NAME(String uNIT_NAME) {
		UNIT_NAME = uNIT_NAME;
	}

	@Override
	public String toString() {
		return "Unit [UNIT_CODE=" + UNIT_CODE + ", UNIT_NAME=" + UNIT_NAME + "]";
	}
	
	

}
