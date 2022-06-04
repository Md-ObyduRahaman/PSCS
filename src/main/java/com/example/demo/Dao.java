package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.internal.OracleTypes;

@Repository
public class Dao {
	
	SimpleJdbcCall getAllStatesJdbcCall;
	SimpleJdbcCall getAllStatesJdbcCall1;
	SimpleJdbcCall getAllStatesJdbcCall2;
	SimpleJdbcCall getAllStatesJdbcCall3;
	SimpleJdbcCall getAllStatesJdbcCall4;
	SimpleJdbcCall getAllStatesJdbcCall5;
	SimpleJdbcCall getAllStatesJdbcCall6;
	
	public Dao(DataSource dataSource) {

		this.getAllStatesJdbcCall = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall1 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall2 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall3 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall4 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall5 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall6 = new SimpleJdbcCall(dataSource);
		
	}

	
	public ArrayList<Head>listHead() {

		ArrayList<Head> listHead = new ArrayList<>();

		Map<String, Object> result = getAllStatesJdbcCall2.withCatalogName("pscs_crud")
				.withProcedureName("viewHead")
				.declareParameters(new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR)).execute();

		JSONObject json = new JSONObject(result);

		String out = json.get("CUR_DATA").toString();
		JSONArray jsonArray = new JSONArray(out);


		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			

			listHead.add(new Head(jsonData.optInt("HEAD_ID"),
					jsonData.optString("HEAD_NAME")));
		}

		return listHead;
	}
	
	public ArrayList<UserType>listUserType() {

		ArrayList<UserType> listUserType = new ArrayList<>();

		Map<String, Object> result = getAllStatesJdbcCall3.withCatalogName("pscs_crud")
				.withProcedureName("viewUserType")
				.declareParameters(new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR)).execute();

		JSONObject json = new JSONObject(result);

		String out = json.get("CUR_DATA").toString();
		JSONArray jsonArray = new JSONArray(out);


		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			

			listUserType.add(new UserType(jsonData.optInt("USER_TYPE_ID"),
					jsonData.optString("USER_TYPE_NAME")));
		}

		return listUserType;
	}
	
	public void insertItem(String itemCode,int levell1parent,String itemname, int level) {
		
		

		Map<String, Object> result = getAllStatesJdbcCall4.withCatalogName("pscs_crud")
				.withProcedureName("ITEM_INSERT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER)).execute(itemCode,levell1parent,itemname,level);

		JSONObject json = new JSONObject(result);

		String out = json.get("OUTPUT").toString();


	}
	
public void insertItem1(String itemCode,int levell1parent,String itemname, int level, int SUB_HEAD_ID) {
		
		

		Map<String, Object> result = getAllStatesJdbcCall5.withCatalogName("pscs_crud")
				.withProcedureName("ITEM_INSERT1")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER)).execute(itemCode,levell1parent,itemname,level, SUB_HEAD_ID);

		JSONObject json = new JSONObject(result);

		String out = json.get("OUTPUT").toString();


	}

	public User getLogin(String name, String pass)
	{
	
		User user = null;
		Map<String, Object> result = getAllStatesJdbcCall1.withCatalogName("pscs_crud")
				.withProcedureName("USER_LOGIN")
				.declareParameters(new SqlOutParameter("results_cursor", OracleTypes.VARCHAR)).execute(name, pass);
	
		JSONObject json = new JSONObject(result);
		String fjfhdj = json.get("CUR_DATA").toString();
		JSONArray jsonArray = new JSONArray(fjfhdj);
	
		//System.out.println(jsonArray);
	
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			user = new User(jsonData.optInt("USR_ID"), jsonData.optInt("USER_TYPE_ID"),jsonData.optString("USER_TYPE_NAME"),
					jsonData.optString("USER_NAME"), jsonData.optString("PASS_NAME"), jsonData.optInt("SHOP_BR_ID"), jsonData.optString("SHOP_BR_NAME"),
					jsonData.optInt("HEAD_ID"), jsonData.optString("HEAD_NAME"), jsonData.optInt("POS_ID"),jsonData.optString("POS_NAME"),jsonData.optString("EMAIL_ID"),jsonData.optString("VER_CODE"));
	
		}
	
		return user;
	
	}
	
	
	public void listItem_buy(Item_buy item_buy) {

		
		
		String[] ITEM_NAME = item_buy.getITEM_NAME();
		int HEAD_ID = item_buy.getHEAD_ID();
		int SHOP_BR_ID = item_buy.getSHOP_BR_ID();
		int[] ITEM_QTY = item_buy.getITEM_QTY();
		int[] UNIT = item_buy.getUNIT();
		int[] BUY_PRICE = item_buy.getBUY_PRICE();
		int[] RTL_PRICE = item_buy.getRTL_PRICE();
		int VEND_ID = item_buy.getVEND_ID();
		
		String TransCode = item_buy.getTransCode();
		int TOTAL_PRICE = item_buy.getTOTAL_PRICE();

		Map<String, Object> result = getAllStatesJdbcCall6.withCatalogName("PSCS_CRUD")
				.withProcedureName("ITEM_INSERT_SHOP_BUY")
				.declareParameters(new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR)).execute(ITEM_NAME,HEAD_ID,SHOP_BR_ID,ITEM_QTY,UNIT,BUY_PRICE,RTL_PRICE,VEND_ID, TransCode, TOTAL_PRICE);


		JSONObject json = new JSONObject(result);
//		System.out.println(result);
		String out = json.get("OUTPUT").toString();
		
		/*ArrayList<Item_buy> listItem_buy = new ArrayList<>();
		
		Map<String, Object> result = getAllStatesJdbcCall6.withCatalogName("PSCS_CRUD")
				.withProcedureName("ITEM_INSERT_SHOP_BUY")
				.declareParameters(new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR)).execute();

		JSONObject json = new JSONObject(result);
	
		String out = json.get("CUR_DATA").toString();
		JSONArray jsonArray1 = new JSONArray(out);

		for (int i = 0; i < jsonArray1.length(); i++) {
			JSONObject jsonData = jsonArray1.getJSONObject(i);
			listItem_buy.add(new Item_buy(jsonData.optInt("P_ITEM_CODE"),
					jsonData.optInt("P_HEAD_ID"),jsonData.optInt("P_SHOP_BR_ID"),
					jsonData.optInt("P_QTY"),jsonData.optInt("P_UNIT"),jsonData.optInt("P_BUY_PRICE"),
					jsonData.optInt("P_RTL_PRICE"),jsonData.optInt("P_VEND_ID"),
					jsonData.optString("P_TRAN_CODE"),jsonData.optInt("P_TOTAL")));
		}


		return listItem_buy;*/
	}


}
