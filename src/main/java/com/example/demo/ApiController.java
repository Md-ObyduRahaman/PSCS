package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oracle.jdbc.internal.OracleTypes;


@RestController
@RequestMapping(path = "/api")
public class ApiController {
	
	@Autowired
	RawSqlDao rawSQLDao;
	
	@Autowired
	Dao ronyDao;
	
	
	SimpleJdbcCall getAllStatesJdbcCall6;
	
	public ApiController(DataSource dataSource) {
		this.getAllStatesJdbcCall6 = new SimpleJdbcCall(dataSource);	
	}
	
	  @GetMapping("/district/{DIV_ID}")
	  public List<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN(@PathVariable("DIV_ID") int DIV_ID) {
	  
	  List<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN = new ArrayList<>();
	  listDISTRICT_DROPDOWN = rawSQLDao.listDISTRICT_DROPDOWN(DIV_ID);
	  
	  return listDISTRICT_DROPDOWN;
	  
	  }
	  
	  @GetMapping("/thana/{DIST_ID}")
	  public List<THANA_DROPDOWN> listTHANA_DROPDOWN(@PathVariable("DIST_ID") int DIST_ID) {
	  
	  List<THANA_DROPDOWN> listTHANA_DROPDOWN = new ArrayList<>();
	  listTHANA_DROPDOWN = rawSQLDao.listTHANA_DROPDOWN(DIST_ID);
	  
	  return listTHANA_DROPDOWN;
	  
	  }
	 
	  @GetMapping("/branch/{HEAD_ID}")
	  public ArrayList<Shop_Br> dropShop_Br(@PathVariable("HEAD_ID") int HEAD_ID) {
	  
	  ArrayList<Shop_Br> dropShop_Br = new ArrayList<>();
	  dropShop_Br = rawSQLDao.dropShop_Br(HEAD_ID);
	  
	  return dropShop_Br;
	  
	  }
	  
	  @GetMapping("/pos/{SHOP_BR_ID}")
	  public ArrayList<Shop_Pos> listShop_Pos(@PathVariable("SHOP_BR_ID") int SHOP_BR_ID) {
	  
	  ArrayList<Shop_Pos> listShop_Pos = new ArrayList<>();
	  listShop_Pos = rawSQLDao.listShop_Pos(SHOP_BR_ID);
	  
	  return listShop_Pos;
	  
	  }  
	  
	  @PostMapping(value = "/Item_buy")
	  public String listItem_buy(@RequestBody String postPayload , Errors errors) {

	  JSONArray jsonArray = new JSONArray(postPayload);
	  
	  //System.out.println(jsonArray);
	  
	  //JSONObject jsnobject = new JSONObject(jsonArray);
	  
	  
	  
	  ArrayList<String> ITEM_NAME = new ArrayList<String>();
	  if (jsonArray != null) {   
          
          //Iterating JSON array  
          for (int i=0;i<jsonArray.length();i++){   
        	  JSONObject jsonData = jsonArray.getJSONObject(i);
        	  
        	  ITEM_NAME.add(jsonData.optString("ITEM_NAME"));
        	 // System.out.println(ITEM_NAME);  
        	 
          }   
      }  
	  
	  ArrayList<String> QUANTITY = new ArrayList<String>();
	  if (jsonArray != null) {   
          
          //Iterating JSON array  
          for (int i=0;i<jsonArray.length();i++){   
        	  JSONObject jsonData = jsonArray.getJSONObject(i);
        	  
        	  QUANTITY.add(jsonData.optString("QUANTITY"));
        	  //System.out.println(QUANTITY);  
        	  
          }   
      }  
	  
	  
	  ArrayList<String> RETAIL_PRICE = new ArrayList<String>();
	  if (jsonArray != null) {   
          
          //Iterating JSON array  
          for (int i=0;i<jsonArray.length();i++){   
        	  JSONObject jsonData = jsonArray.getJSONObject(i);
        	  
        	  RETAIL_PRICE.add(jsonData.optString("RETAIL_PRICE"));
        	  //System.out.println(RETAIL_PRICE);  
        	 
          }   
      }  
	  
	  
	  ArrayList<String> BUY_PRICE = new ArrayList<String>();
	  if (jsonArray != null) {   
          
          //Iterating JSON array  
          for (int i=0;i<jsonArray.length();i++){   
        	  JSONObject jsonData = jsonArray.getJSONObject(i);
        	  
        	  BUY_PRICE.add(jsonData.optString("BUY_PRICE"));
        	  //System.out.println(BUY_PRICE);  
        	 
          }   
      }  
	  
	  
	  ArrayList<String> TOTAL_COST = new ArrayList<String>();
	 
	  if (jsonArray != null) {   
          
          //Iterating JSON array  
          for (int i=0;i<jsonArray.length();i++){   
        	  JSONObject jsonData = jsonArray.getJSONObject(i);
        	  
        	  TOTAL_COST.add(jsonData.optString("TOTAL_COST"));
        	  
        	  //System.out.println(TOTAL_COST);  
        	 
          }   
      }  
	  
	  
	  Double GRAND_TOTAL= 0.0;
		  
		          
		          
      for (int i=0;i<TOTAL_COST.size();i++){   
    	  
    	  GRAND_TOTAL= GRAND_TOTAL + Double.parseDouble(TOTAL_COST.get(i));
      }
      System.out.println(GRAND_TOTAL);  
		

		return "redirect:/Item_buy/{ShopId}/{HeadId}/{Shop_BrId}";
	   
	  }

	  @GetMapping("/brand/{id}")
		public List<SF_SUB_HEAD> listShop_Brand(@PathVariable("id") int id) {

			ArrayList<SF_SUB_HEAD> listShop_Brand = new ArrayList<>();
			listShop_Brand = rawSQLDao.listShop_Brand(id);

			return listShop_Brand;

		}
		
		
		@GetMapping("/item/{shID}")
		public List<listSF_ITEM_Dropdown> listSF_ITEM_Dropdown(@PathVariable("shID") int shID) {

			ArrayList<listSF_ITEM_Dropdown> listSF_ITEM_Dropdown = new ArrayList<>();
			listSF_ITEM_Dropdown = rawSQLDao.listSF_ITEM_Dropdown(shID);

			return listSF_ITEM_Dropdown;

		}
		
		@GetMapping("/Shop_branch/{HEAD_ID}")
		  public ArrayList<Shop_Br> Shop_Br_dropdown(@PathVariable("HEAD_ID") int HEAD_ID) {
		  
		  ArrayList<Shop_Br> Shop_Br_dropdown = new ArrayList<>();
		  Shop_Br_dropdown = (ArrayList<Shop_Br>) rawSQLDao.Shop_Br_dropdown(HEAD_ID);
		  
		  return Shop_Br_dropdown;
		  
		  }
		
		@PostMapping("/Item_buy/{ShopId}/{HeadId}/{Shop_BrId}")
		public String item_buy(@CookieValue(value = "user_name", defaultValue = "") String user_name,
				@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
			
			if (user_name.equals("")) {
				return "redirect:/";
			}
			
			
			
			 /*public void listItem_buy1(Item_buy item_buy) {
				  
				  
				  
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
				  
				  Map<String, Object> result =
				  getAllStatesJdbcCall6.withCatalogName("PSCS_CRUD")
				  .withProcedureName("ITEM_INSERT_SHOP_BUY") .declareParameters(new
				  SqlOutParameter("CUR_DATA",
				  OracleTypes.CURSOR)).execute(ITEM_NAME,HEAD_ID,SHOP_BR_ID,ITEM_QTY,UNIT,
				  BUY_PRICE,RTL_PRICE,VEND_ID, TransCode, TOTAL_PRICE);
				  
				  
				  JSONObject json = new JSONObject(result); String out =
				  json.get("OUTPUT").toString();
				  
				  }*/
				 
			  //ronyDao.listItem_buy(listItem_buy);
			
			return "honululu";
		}


}
