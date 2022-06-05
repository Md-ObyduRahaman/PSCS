package com.example.demo.model;

public class DrpDwn {
	
		int DCODE;
		String DNAME;
		public DrpDwn() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DrpDwn(int dCODE, String dNAME) {
			super();
			DCODE = dCODE;
			DNAME = dNAME;
		}
		@Override
		public String toString() {
			return "DrpDwn [DCODE=" + DCODE + ", DNAME=" + DNAME + "]";
		}
		public int getDCODE() {
			return DCODE;
		}
		public void setDCODE(int dCODE) {
			DCODE = dCODE;
		}
		public String getDNAME() {
			return DNAME;
		}
		public void setDNAME(String dNAME) {
			DNAME = dNAME;
		}

}
