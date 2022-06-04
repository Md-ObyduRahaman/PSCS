package com.example.demo;

public class UserType {
	
	int USER_TYPE_ID;
	String USER_TYPE_NAME;
	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserType(int uSER_TYPE_ID, String uSER_TYPE_NAME) {
		super();
		USER_TYPE_ID = uSER_TYPE_ID;
		USER_TYPE_NAME = uSER_TYPE_NAME;
	}
	public int getUSER_TYPE_ID() {
		return USER_TYPE_ID;
	}
	public void setUSER_TYPE_ID(int uSER_TYPE_ID) {
		USER_TYPE_ID = uSER_TYPE_ID;
	}
	public String getUSER_TYPE_NAME() {
		return USER_TYPE_NAME;
	}
	public void setUSER_TYPE_NAME(String uSER_TYPE_NAME) {
		USER_TYPE_NAME = uSER_TYPE_NAME;
	}
	@Override
	public String toString() {
		return "UserType [USER_TYPE_ID=" + USER_TYPE_ID + ", USER_TYPE_NAME=" + USER_TYPE_NAME + "]";
	}
	

}
