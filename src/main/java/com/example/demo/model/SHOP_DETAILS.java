package com.example.demo.model;

public class SHOP_DETAILS 
{
	int PAYED_ID, TRAN_ID, HEAD_ID, SHOP_BR_ID, MNT_AMT, DAY_GAP, INT_AMT;
	String  HEAD_NAME, SHOP_BR_NAME, INI_DATE, LAST_PAY, NEXT_PAY ;
	public int getPAYED_ID() {
		return PAYED_ID;
	}

	
	public void setPAYED_ID(int pAYED_ID) {
		PAYED_ID = pAYED_ID;
	}



	public int getTRAN_ID() {
		return TRAN_ID;
	}



	public void setTRAN_ID(int tRAN_ID) {
		TRAN_ID = tRAN_ID;
	}



	public int getHEAD_ID() {
		return HEAD_ID;
	}



	public void setHEAD_ID(int hEAD_ID) {
		HEAD_ID = hEAD_ID;
	}



	public int getSHOP_BR_ID() {
		return SHOP_BR_ID;
	}



	public void setSHOP_BR_ID(int sHOP_BR_ID) {
		SHOP_BR_ID = sHOP_BR_ID;
	}



	public int getMNT_AMT() {
		return MNT_AMT;
	}



	public void setMNT_AMT(int mNT_AMT) {
		MNT_AMT = mNT_AMT;
	}



	public int getDAY_GAP() {
		return DAY_GAP;
	}



	public void setDAY_GAP(int dAY_GAP) {
		DAY_GAP = dAY_GAP;
	}



	public int getINT_AMT() {
		return INT_AMT;
	}



	public void setINT_AMT(int iNT_AMT) {
		INT_AMT = iNT_AMT;
	}



	public String getHEAD_NAME() {
		return HEAD_NAME;
	}



	public void setHEAD_NAME(String hEAD_NAME) {
		HEAD_NAME = hEAD_NAME;
	}



	public String getSHOP_BR_NAME() {
		return SHOP_BR_NAME;
	}



	public void setSHOP_BR_NAME(String sHOP_BR_NAME) {
		SHOP_BR_NAME = sHOP_BR_NAME;
	}



	public String getINI_DATE() {
		return INI_DATE;
	}



	public void setINI_DATE(String iNI_DATE) {
		INI_DATE = iNI_DATE;
	}



	public String getLAST_PAY() {
		return LAST_PAY;
	}



	public void setLAST_PAY(String lAST_PAY) {
		LAST_PAY = lAST_PAY;
	}



	public String getNEXT_PAY() {
		return NEXT_PAY;
	}



	public void setNEXT_PAY(String nEXT_PAY) {
		NEXT_PAY = nEXT_PAY;
	}

	public SHOP_DETAILS(int pAYED_ID, int tRAN_ID, int hEAD_ID, int sHOP_BR_ID, int mNT_AMT, int dAY_GAP, int iNT_AMT,
			String hEAD_NAME, String sHOP_BR_NAME, String iNI_DATE, String lAST_PAY, String nEXT_PAY) {
		super();
		PAYED_ID = pAYED_ID;
		TRAN_ID = tRAN_ID;
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		MNT_AMT = mNT_AMT;
		DAY_GAP = dAY_GAP;
		INT_AMT = iNT_AMT;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_NAME = sHOP_BR_NAME;
		INI_DATE = iNI_DATE;
		LAST_PAY = lAST_PAY;
		NEXT_PAY = nEXT_PAY;
	}

	
	@Override
	public String toString() {
		return "SHOP_DETAILS [PAYED_ID=" + PAYED_ID + ", TRAN_ID=" + TRAN_ID + ", HEAD_ID=" + HEAD_ID + ", SHOP_BR_ID="
				+ SHOP_BR_ID + ", MNT_AMT=" + MNT_AMT + ", DAY_GAP=" + DAY_GAP + ", INT_AMT=" + INT_AMT + ", HEAD_NAME="
				+ HEAD_NAME + ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", INI_DATE=" + INI_DATE + ", LAST_PAY=" + LAST_PAY
				+ ", NEXT_PAY=" + NEXT_PAY + "]";
	}


	public SHOP_DETAILS() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
