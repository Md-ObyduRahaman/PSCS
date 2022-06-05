package com.example.demo.model;

public class LEVEL2 {

		
			int SUB_HEAD_ID;
			int PARENT_ID;
			String HEAD_NAME;
			int LEV;
			String CHILD_NAME;
			public LEVEL2() {
				super();
				// TODO Auto-generated constructor stub
			}
			public LEVEL2(int sUB_HEAD_ID, int pARENT_ID, String hEAD_NAME, int lEV, String cHILD_NAME) {
				super();
				SUB_HEAD_ID = sUB_HEAD_ID;
				PARENT_ID = pARENT_ID;
				HEAD_NAME = hEAD_NAME;
				LEV = lEV;
				CHILD_NAME = cHILD_NAME;
			}
			@Override
			public String toString() {
				return "SF_SUB_HEAD [SUB_HEAD_ID=" + SUB_HEAD_ID + ", PARENT_ID=" + PARENT_ID + ", HEAD_NAME=" + HEAD_NAME
						+ ", LEV=" + LEV + ", CHILD_NAME=" + CHILD_NAME + "]";
			}
			public int getSUB_HEAD_ID() {
				return SUB_HEAD_ID;
			}
			public void setSUB_HEAD_ID(int sUB_HEAD_ID) {
				SUB_HEAD_ID = sUB_HEAD_ID;
			}
			public int getPARENT_ID() {
				return PARENT_ID;
			}
			public void setPARENT_ID(int pARENT_ID) {
				PARENT_ID = pARENT_ID;
			}
			public String getHEAD_NAME() {
				return HEAD_NAME;
			}
			public void setHEAD_NAME(String hEAD_NAME) {
				HEAD_NAME = hEAD_NAME;
			}
			public int getLEV() {
				return LEV;
			}
			public void setLEV(int lEV) {
				LEV = lEV;
			}
			public String getCHILD_NAME() {
				return CHILD_NAME;
			}
			public void setCHILD_NAME(String cHILD_NAME) {
				CHILD_NAME = cHILD_NAME;
			}
			
			

		}

