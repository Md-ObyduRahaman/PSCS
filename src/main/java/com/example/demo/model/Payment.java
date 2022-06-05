package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Payment
{
	int PAYED_ID, HEAD_ID, SHOP_BR_ID, MNT_AMT,  DAY_GAP, INT_AMT, SHOP_ID;
	
	int PAYED_HIST_ID, TRAN_DATE, TRAN_MON, TRAN_ID, PAY_MODE, AUTH;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	String INI_DATE, LAST_PAY, NEXT_PAY;
	String  PAY_MON;
	public int getPAYED_ID() {
		return PAYED_ID;
	}
	public void setPAYED_ID(int pAYED_ID) {
		PAYED_ID = pAYED_ID;
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
	public int getSHOP_ID() {
		return SHOP_ID;
	}
	public void setSHOP_ID(int sHOP_ID) {
		SHOP_ID = sHOP_ID;
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
	public String getPAY_MON() {
		return PAY_MON;
	}
	public void setPAY_MON(String pAY_MON) {
		PAY_MON = pAY_MON;
	}
	
	
	
	
	public int getPAYED_HIST_ID() {
		return PAYED_HIST_ID;
	}
	public void setPAYED_HIST_ID(int pAYED_HIST_ID) {
		PAYED_HIST_ID = pAYED_HIST_ID;
	}
	public int getTRAN_DATE() {
		return TRAN_DATE;
	}
	public void setTRAN_DATE(int tRAN_DATE) {
		TRAN_DATE = tRAN_DATE;
	}
	public int getTRAN_MON() {
		return TRAN_MON;
	}
	public void setTRAN_MON(int tRAN_MON) {
		TRAN_MON = tRAN_MON;
	}
	public int getTRAN_ID() {
		return TRAN_ID;
	}
	public void setTRAN_ID(int tRAN_ID) {
		TRAN_ID = tRAN_ID;
	}
	public int getPAY_MODE() {
		return PAY_MODE;
	}
	public void setPAY_MODE(int pAY_MODE) {
		PAY_MODE = pAY_MODE;
	}
	public int getAUTH() {
		return AUTH;
	}
	public void setAUTH(int aUTH) {
		AUTH = aUTH;
	}
	
	public Payment(int hEAD_ID, int sHOP_BR_ID, int mNT_AMT, int pAYED_HIST_ID, int tRAN_DATE, int tRAN_MON,
			int tRAN_ID, int pAY_MODE, int aUTH) {
		super();
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		MNT_AMT = mNT_AMT;
		PAYED_HIST_ID = pAYED_HIST_ID;
		TRAN_DATE = tRAN_DATE;
		TRAN_MON = tRAN_MON;
		TRAN_ID = tRAN_ID;
		PAY_MODE = pAY_MODE;
		AUTH = aUTH;
	}
	@Override
	public String toString() {
		return "Payment [PAYED_ID=" + PAYED_ID + ", HEAD_ID=" + HEAD_ID + ", SHOP_BR_ID=" + SHOP_BR_ID + ", MNT_AMT="
				+ MNT_AMT + ", DAY_GAP=" + DAY_GAP + ", INT_AMT=" + INT_AMT + ", SHOP_ID=" + SHOP_ID
				+ ", PAYED_HIST_ID=" + PAYED_HIST_ID + ", TRAN_DATE=" + TRAN_DATE + ", TRAN_MON=" + TRAN_MON
				+ ", TRAN_ID=" + TRAN_ID + ", PAY_MODE=" + PAY_MODE + ", AUTH=" + AUTH + ", INI_DATE=" + INI_DATE
				+ ", LAST_PAY=" + LAST_PAY + ", NEXT_PAY=" + NEXT_PAY + ", PAY_MON=" + PAY_MON + "]";
	}
	
	
	public Payment(int pAYED_ID, int hEAD_ID, int sHOP_BR_ID, int mNT_AMT, int dAY_GAP, int iNT_AMT, int sHOP_ID,
			String iNI_DATE, String lAST_PAY, String nEXT_PAY, String pAY_MON) {
		super();
		PAYED_ID = pAYED_ID;
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		MNT_AMT = mNT_AMT;
		DAY_GAP = dAY_GAP;
		INT_AMT = iNT_AMT;
		SHOP_ID = sHOP_ID;
		INI_DATE = iNI_DATE;
		LAST_PAY = lAST_PAY;
		NEXT_PAY = nEXT_PAY;
		PAY_MON = pAY_MON;
	}
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
