package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

public class SF_SHOP_PAYMENT_HIST 
{
	
	String FROM_DATE;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	String TO_DATE;
	
	int PAYED_HIST_ID, TRAN_ID, HEAD_ID, SHOP_BR_ID;
	String TRAN_MON, PAY_MODE,AUTH, HEAD_NAME, SHOP_BR_NAME, TRAN_DATE ;
	
	
	
	public String getFROM_DATE() {
		return FROM_DATE;
	}



	public void setFROM_DATE(String fROM_DATE) {
		FROM_DATE = fROM_DATE;
	}



	public String getTO_DATE() {
		return TO_DATE;
	}



	public void setTO_DATE(String tO_DATE) {
		TO_DATE = tO_DATE;
	}



	public int getPAYED_HIST_ID() {
		return PAYED_HIST_ID;
	}



	public void setPAYED_HIST_ID(int pAYED_HIST_ID) {
		PAYED_HIST_ID = pAYED_HIST_ID;
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



	public String getTRAN_MON() {
		return TRAN_MON;
	}



	public void setTRAN_MON(String tRAN_MON) {
		TRAN_MON = tRAN_MON;
	}



	public String getPAY_MODE() {
		return PAY_MODE;
	}



	public void setPAY_MODE(String pAY_MODE) {
		PAY_MODE = pAY_MODE;
	}



	public String getAUTH() {
		return AUTH;
	}



	public void setAUTH(String aUTH) {
		AUTH = aUTH;
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

	

	public SF_SHOP_PAYMENT_HIST(String fROM_DATE, String tO_DATE, int pAYED_HIST_ID, int tRAN_ID, int hEAD_ID,
			int sHOP_BR_ID, String tRAN_MON, String pAY_MODE, String aUTH, String hEAD_NAME, String sHOP_BR_NAME,
			String tRAN_DATE) {
		super();
		FROM_DATE = fROM_DATE;
		TO_DATE = tO_DATE;
		PAYED_HIST_ID = pAYED_HIST_ID;
		TRAN_ID = tRAN_ID;
		HEAD_ID = hEAD_ID;
		SHOP_BR_ID = sHOP_BR_ID;
		TRAN_MON = tRAN_MON;
		PAY_MODE = pAY_MODE;
		AUTH = aUTH;
		HEAD_NAME = hEAD_NAME;
		SHOP_BR_NAME = sHOP_BR_NAME;
		TRAN_DATE = tRAN_DATE;
	}



	@Override
	public String toString() {
		return "SF_SHOP_PAYMENT_HIST [FROM_DATE=" + FROM_DATE + ", TO_DATE=" + TO_DATE + ", PAYED_HIST_ID="
				+ PAYED_HIST_ID + ", TRAN_ID=" + TRAN_ID + ", HEAD_ID=" + HEAD_ID + ", SHOP_BR_ID=" + SHOP_BR_ID
				+ ", TRAN_MON=" + TRAN_MON + ", PAY_MODE=" + PAY_MODE + ", AUTH=" + AUTH + ", HEAD_NAME=" + HEAD_NAME
				+ ", SHOP_BR_NAME=" + SHOP_BR_NAME + ", TRAN_DATE=" + TRAN_DATE + "]";
	}



	public SF_SHOP_PAYMENT_HIST() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
