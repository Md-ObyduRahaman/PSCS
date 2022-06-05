package com.example.demo.model;

public class Un_Auth_Payment
{
	String HEAD_NAME, SHOP_BR_NAME,TRAN_DATE,TRAN_MON, MNT_AMT, AUTH;
	int PAYED_HIST_ID;
	
	public int getPAYED_HIST_ID() {
		return PAYED_HIST_ID;
	}

	public void setPAYED_HIST_ID(int pAYED_HIST_ID) {
		PAYED_HIST_ID = pAYED_HIST_ID;
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

	public String getTRAN_DATE() {
		return TRAN_DATE;
	}

	public void setTRAN_DATE(String tRAN_DATE) {
		TRAN_DATE = tRAN_DATE;
	}

	public String getTRAN_MON() {
		return TRAN_MON;
	}

	public void setTRAN_MON(String tRAN_MON) {
		TRAN_MON = tRAN_MON;
	}

	public String getMNT_AMT() {
		return MNT_AMT;
	}

	public void setMNT_AMT(String mNT_AMT) {
		MNT_AMT = mNT_AMT;
	}

	public String getAUTH() {
		return AUTH;
	}

	public void setAUTH(String aUTH) {
		AUTH = aUTH;
	}

	public Un_Auth_Payment(int pAYED_HIST_ID, String hEAD_NAME, String sHOP_BR_NAME, String tRAN_DATE,
			String tRAN_MON, String mNT_AMT, String aUTH) {
		super();
		PAYED_HIST_ID = pAYED_HIST_ID;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_NAME = sHOP_BR_NAME;
		TRAN_DATE = tRAN_DATE;
		TRAN_MON = tRAN_MON;
		MNT_AMT = mNT_AMT;
		AUTH = aUTH;
	}

	@Override
	public String toString() {
		return "Un_Auth_Payment [PAYED_HIST_ID=" + PAYED_HIST_ID + ", HEAD_NAME=" + HEAD_NAME + ", SHOP_BR_NAME="
				+ SHOP_BR_NAME + ", TRAN_DATE=" + TRAN_DATE + ", TRAN_MON=" + TRAN_MON + ", MNT_AMT=" + MNT_AMT
				+ ", AUTH=" + AUTH + "]";
	}

	public Un_Auth_Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
