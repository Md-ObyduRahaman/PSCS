package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.Dao;
import com.example.demo.dao.RawSqlDao;
import com.example.demo.model.Account_Statement;
import com.example.demo.model.DISTRICT_DROPDOWN;
import com.example.demo.model.DrpDwn;
import com.example.demo.model.Head;
import com.example.demo.model.Item;
import com.example.demo.model.Item_buy;
import com.example.demo.model.LEVEL1;
import com.example.demo.model.LEVEL2;
import com.example.demo.model.LEVEL3;
import com.example.demo.model.Month;
import com.example.demo.model.Payment;
import com.example.demo.model.SF_SHOP_PAYMENT_HIST;
import com.example.demo.model.SF_SUB_HEAD;
import com.example.demo.model.SF_UNIT;
import com.example.demo.model.SHOP_DETAILS;
import com.example.demo.model.Shop;
import com.example.demo.model.Shop_Br;
import com.example.demo.model.Shop_Brand;
import com.example.demo.model.Shop_Contact;
import com.example.demo.model.Shop_GL;
import com.example.demo.model.Shop_Item;
import com.example.demo.model.Shop_Pos;
import com.example.demo.model.Shop_loc;
import com.example.demo.model.Shop_vendor;
import com.example.demo.model.Stock;
import com.example.demo.model.THANA_DROPDOWN;
import com.example.demo.model.Un_Auth_Payment;
import com.example.demo.model.User;
import com.example.demo.model.UserType;





@Controller
public class MainController {
	
	@Resource
	Dao dao;
	@Resource
	RawSqlDao rawSqlDao;
	
	
	///// Login //////
	
	@GetMapping("/")
	public String Login(Model model) {
		User login = new User();
		model.addAttribute("login", login);

		return "login";
	}
	
	@PostMapping("/")
	public String loginUser(HttpServletResponse response, Model model, User user) {
		
		User user1 = dao.getLogin(user.getUSER_NAME(), user.getPASS_NAME());

		if (user1 != null) {
			if (user1.getUSER_NAME().equals(user.getUSER_NAME())
					&& user1.getPASS_NAME().equals(user.getPASS_NAME())) {
				
				Cookie cookie = new Cookie("user_name", user1.getUSER_NAME());
				response.addCookie(cookie);
				
//				Cookie cookie1 = new Cookie("user_type", user1.getUSER_TYPE_NAME());
//				response.addCookie(cookie1);
			
	
				return "redirect:/Shop";
			} 
			
			else {
				
				return "redirect:/";
			}

		} else {

			User login = new User();
			model.addAttribute("login", login);

			String msg = "User Id Password Missmatch! Login Failed";
			model.addAttribute("msg", msg);
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String LogOut(HttpServletResponse response, Model model) {
		User login = new User();
		model.addAttribute("login", login);
		Cookie cookie = new Cookie("user_name", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "login";
	}
	
	@GetMapping("/Stock")
	public String Stock(@CookieValue(value = "user_name", defaultValue = "") String user_name,Model model) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		
		String flag = "0";
		

	
		ArrayList<Stock> listStock = rawSqlDao.listStock();
		model.addAttribute("listStock", listStock);
		
		model.addAttribute("flag", flag);
		
		return "Shop_stock";
	}
	
	@GetMapping("/Shop")
	public String Shop(@CookieValue(value = "user_name", defaultValue = "") String user_name,Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		String flag = "0";
	
	    Shop shop = new Shop();

		ArrayList<Shop> listShop = rawSqlDao.listShop();
		model.addAttribute("shop", shop);
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		model.addAttribute("listShop", listShop);
		model.addAttribute("flag", flag);

		return "shop";
	}
	
	@PostMapping("/Shop")
	public String shop_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,Shop shop) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}

		rawSqlDao.insertShop(shop);

		return "redirect:/Shop";
	}

	@GetMapping("/Shop/{id}")
	public String shop_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			@PathVariable("id") int id, Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		String flag = "1";

		Shop shop = rawSqlDao.singleShop(id);

		ArrayList<Shop> listShop = rawSqlDao.listShop();

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		model.addAttribute("listShop", listShop);
		model.addAttribute("shop", shop);
		model.addAttribute("flag", flag);
		model.addAttribute("id", id);
	

		return "Shop";
	}

	@PostMapping("/Shop/{id}")
	public String shop_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id, Model model, Shop shop) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop.setSHOP_ID(id);

		rawSqlDao.editShop(shop);

		return "redirect:/Shop";
	}

	@PostMapping("/Shop_delete/{id}")
	public String shop_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop(id);

		return "redirect:/Shop";
	}
	
	// SHOP BRANCH
	
	@GetMapping("/Shop_Br/{ShopId}/{HeadId}")
	public String Shop_Br(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId, Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		Shop_Br shop_br = new Shop_Br();

		ArrayList<Shop> listShop = rawSqlDao.listShop();
		model.addAttribute("listShop", listShop);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_br", shop_br);
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);


		return "Shop_Br";
	}
	
	
	@PostMapping("/Shop_Br/{ShopId}/{HeadId}")
	public String shop_br_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			Shop_Br shop_br) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_br.setSHOP_ID(sId);
		shop_br.setHEAD_ID(hId);

		rawSqlDao.insertShop_Br(shop_br);

		return "redirect:/Shop_Br/" + sId + "/" + hId;

	}

	@GetMapping("/Shop_Br/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_br_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int id, Model model) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_Br shop_br = rawSqlDao.singleShop_Br(id);

		ArrayList<Shop> listShop = rawSqlDao.listShop();
		
		model.addAttribute("listShop", listShop);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_br", shop_br);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("id", id);
	

		return "Shop_Br";
	}

	@PostMapping("/Shop_Br/{ShopId}/{HeadId}/{Shop_BrId}")
	public String editShop_Br(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int id, Model model, Shop_Br shop_br) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_br.setSHOP_ID(sId);
		shop_br.setHEAD_ID(hId);
		shop_br.setSHOP_BR_ID(id);

		rawSqlDao.editShop_Br(shop_br);

		return "redirect:/Shop_Br/" + sId + "/" + hId;
	}

	@PostMapping("/Shop_Br_delete/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_br_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int id) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_Br(id);

		return "redirect:/Shop_Br/" + sId + "/" + hId;
	}
	
	
	// SHOP_BRAND
	
	@GetMapping("/Shop_Brand/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_Brand(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		Shop_Brand shop_brand = new Shop_Brand();

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("listShop_Br", listShop_Br);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Brand> listShop_Brand = rawSqlDao.listShop_Brand(sId,hId,SbId);
		model.addAttribute("shop_brand", shop_brand);
		model.addAttribute("listShop_Brand", listShop_Brand);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_Brand";
	}
	
	@PostMapping("/Shop_Brand/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_brand_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_Brand shop_brand) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_brand.setHEAD_ID(hId);
		shop_brand.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_Brand(shop_brand);

		return "redirect:/Shop_Brand/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_Brand/{ShopId}/{HeadId}/{Shop_BrId}/{Brand}")
	public String shop_brand_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Brand") int Brid, Model model) {
	
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_Brand shop_brand = rawSqlDao.singleShop_Brand(Brid);
		
		ArrayList<Shop_Brand> listShop_Brand = rawSqlDao.listShop_Brand(sId,hId,SbId);
		
		model.addAttribute("listShop_Brand", listShop_Brand);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_brand", shop_brand);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("Brid", Brid);
		
	

		return "Shop_Brand";
	}

	@PostMapping("/Shop_Brand/{ShopId}/{HeadId}/{Shop_BrId}/{Brand}")
	public String editShop_Brand(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Brand") int Brid, Model model, Shop_Brand shop_brand) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_brand.setHEAD_ID(hId);
		shop_brand.setSHOP_BR_ID(SbId);
		shop_brand.setBRAND_ID(Brid);

		rawSqlDao.editShop_Brand(shop_brand);

		return "redirect:/Shop_Brand/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_Brand_delete/{ShopId}/{HeadId}/{Shop_BrId}/{Brand}")
	public String shop_brand_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Brand") int Brid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_Brand(Brid);

		return "redirect:/Shop_Brand/" + sId + "/" + hId + "/" + SbId;
	}

	
	
	@GetMapping("/User")
	public String User(@CookieValue(value = "user_name", defaultValue = "") String user_name,Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";
	
	    User user = new User();

		/*
		 * ArrayList<Shop_Br> dropShop_Br = rawSqlDao.dropShop_Br();
		 * model.addAttribute("dropShop_Br", dropShop_Br);
		 */
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		ArrayList<User> listUser = rawSqlDao.listUser();
		model.addAttribute("listUser", listUser);
		
		ArrayList<UserType> listUserType = dao.listUserType();
		model.addAttribute("listUserType", listUserType);
		
		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos();
		model.addAttribute("listShop_Pos", listShop_Pos);
		
		model.addAttribute("user", user);
		model.addAttribute("flag", flag);

		return "user";
	}
	
	
	@PostMapping("/User")
	public String user_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,User user) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.insertUser(user);

		return "redirect:/User";
	}

	@GetMapping("/User/{id}")
	public String user_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		User user = rawSqlDao.singleUser(id);

		ArrayList<Shop_Br> dropShop_Br = rawSqlDao.dropShop_Br();
		model.addAttribute("dropShop_Br", dropShop_Br);
		
		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos();
		model.addAttribute("listShop_Pos", listShop_Pos);
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		ArrayList<User> listUser = rawSqlDao.listUser();
		model.addAttribute("listUser", listUser);
		
		ArrayList<UserType> listUserType = dao.listUserType();
		model.addAttribute("listUserType", listUserType);
		
		model.addAttribute("user", user);
		model.addAttribute("flag", flag);
		model.addAttribute("id", id);
	

		return "user";
	}

	@PostMapping("/User/{id}")
	public String user_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id, Model model, User user) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		user.setUSR_ID(id);

		rawSqlDao.editUser(user);

		return "redirect:/User";
	}

	@PostMapping("/User_delete/{id}")
	public String user_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteUser(id);

		return "redirect:/User";
	}
	
	
	//SHOP CONTACT
	
	
	@GetMapping("/Shop_Contact/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_Contact(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		Shop_Contact shop_contact = new Shop_Contact();

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("listShop_Br", listShop_Br);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Contact> listShop_Contact = rawSqlDao.listShop_Contact(sId,hId,SbId);
		model.addAttribute("shop_contact", shop_contact);
		model.addAttribute("listShop_Contact", listShop_Contact);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_Contact";
	}
	
	
	@PostMapping("/Shop_Contact/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_contact_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_Contact shop_contact) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_contact.setSHOP_BR_ID(SbId);
		shop_contact.setHEAD_ID(hId);

		rawSqlDao.insertShop_Contact(shop_contact);

		return "redirect:/Shop_Contact/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_Contact/{ShopId}/{HeadId}/{Shop_BrId}/{Contact}")
	public String shop_contact_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Contact") int Conid, Model model) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_Contact shop_contact = rawSqlDao.singleShop_Contact(Conid);
		
		ArrayList<Shop_Contact> listShop_Contact = rawSqlDao.listShop_Contact(sId,hId,SbId);
		
		model.addAttribute("listShop_Contact", listShop_Contact);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_contact", shop_contact);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("Conid", Conid);
		
	

		return "Shop_Contact";
	}

	@PostMapping("/Shop_Contact/{ShopId}/{HeadId}/{Shop_BrId}/{Contact}")
	public String editShop_Contact(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Contact") int Conid, Model model, Shop_Contact shop_contact) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_contact.setHEAD_ID(hId);
		shop_contact.setSHOP_BR_ID(SbId);
		shop_contact.setCON_ID(Conid);

		rawSqlDao.editShop_Contact(shop_contact);

		return "redirect:/Shop_Contact/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_Contact_delete/{ShopId}/{HeadId}/{Shop_BrId}/{Contact}")
	public String shop_contact_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Contact") int Conid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_Contact(Conid);

		return "redirect:/Shop_Contact/" + sId + "/" + hId + "/" + SbId;
	}
	
	
	// SHOP POS
	
	@GetMapping("/Shop_Pos/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_Pos(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		Shop_Pos shop_pos = new Shop_Pos();

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("listShop_Br", listShop_Br);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos(sId,hId,SbId);
		model.addAttribute("shop_pos", shop_pos);
		model.addAttribute("listShop_Pos", listShop_Pos);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_pos";
	}
	
	
	@PostMapping("/Shop_Pos/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_pos_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_Pos shop_pos) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_pos.setHEAD_ID(hId);
		shop_pos.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_Pos(shop_pos);

		return "redirect:/Shop_Pos/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_Pos/{ShopId}/{HeadId}/{Shop_BrId}/{Pos}")
	public String shop_pos_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Pos") int Posid, Model model) {
	
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_Pos shop_pos = rawSqlDao.singleShop_Pos(Posid);
		
		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos(sId,hId,SbId);
		
		model.addAttribute("listShop_Pos", listShop_Pos);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_pos", shop_pos);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("Posid", Posid);
		
	

		return "Shop_pos";
	}

	@PostMapping("/Shop_Pos/{ShopId}/{HeadId}/{Shop_BrId}/{Pos}")
	public String editShop_Pos(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Pos") int Posid, Model model, Shop_Pos shop_pos) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_pos.setHEAD_ID(hId);
		shop_pos.setSHOP_BR_ID(SbId);
		shop_pos.setPOS_ID(Posid);

		rawSqlDao.editShop_Pos(shop_pos);

		return "redirect:/Shop_Pos/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_Pos_delete/{ShopId}/{HeadId}/{Shop_BrId}/{Pos}")
	public String shop_pos_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Pos") int Posid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_Pos(Posid);

		return "redirect:/Shop_Pos/" + sId + "/" + hId + "/" + SbId;
	}
	

	// SHOP LOCATION
	
	@GetMapping("/Shop_loc/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_loc(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

	
		  Shop_loc shop_loc = new Shop_loc();
		  
		  ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		  model.addAttribute("listShop_Br", listShop_Br);
		  
		  ArrayList<Head> listHead = dao.listHead(); 
		  model.addAttribute("listHead",listHead);
		  
		  ArrayList<Shop_loc> listShop_loc = rawSqlDao.listShop_loc(sId,hId,SbId); 
		  
		  ArrayList<DrpDwn> listDrpDwnDIVISION = rawSqlDao.listDrpDwnDIVISION();
		  model.addAttribute("listDrpDwnDIVISION", listDrpDwnDIVISION);
		  
		  ArrayList<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN = rawSqlDao.listDISTRICT_DROPDOWN();
		  model.addAttribute("listDISTRICT_DROPDOWN", listDISTRICT_DROPDOWN);
		  
		  ArrayList<THANA_DROPDOWN> listTHANA_DROPDOWN = rawSqlDao.listTHANA_DROPDOWN();
		  model.addAttribute("listTHANA_DROPDOWN", listTHANA_DROPDOWN);
		  
		  model.addAttribute("shop_loc",shop_loc);
		  model.addAttribute("listShop_loc", listShop_loc);
		 
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_loc";
	}
	
	@PostMapping("/Shop_loc/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_loc_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_loc shop_loc) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_loc.setHEAD_ID(hId);
		shop_loc.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_loc(shop_loc);

		return "redirect:/Shop_loc/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_loc/{ShopId}/{HeadId}/{Shop_BrId}/{Loc}")
	public String shop_loc_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Loc") int Locid, Model model) {
	
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_loc shop_loc = rawSqlDao.singleShop_loc(Locid);
		
		ArrayList<Shop_loc> listShop_loc = rawSqlDao.listShop_loc(sId,hId,SbId);
		
		model.addAttribute("listShop_loc", listShop_loc);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_loc", shop_loc);
		
		ArrayList<DrpDwn> listDrpDwnDIVISION = rawSqlDao.listDrpDwnDIVISION();
		  model.addAttribute("listDrpDwnDIVISION", listDrpDwnDIVISION);
		  
		  ArrayList<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN = rawSqlDao.listDISTRICT_DROPDOWN();
		  model.addAttribute("listDISTRICT_DROPDOWN", listDISTRICT_DROPDOWN);
		  
		  ArrayList<THANA_DROPDOWN> listTHANA_DROPDOWN = rawSqlDao.listTHANA_DROPDOWN();
		  model.addAttribute("listTHANA_DROPDOWN", listTHANA_DROPDOWN);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("Locid", Locid);
		
	

		return "Shop_loc";
	}

	@PostMapping("/Shop_loc/{ShopId}/{HeadId}/{Shop_BrId}/{Loc}")
	public String editShop_loc(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Loc") int Locid, Model model, Shop_loc shop_loc) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_loc.setHEAD_ID(hId);
		shop_loc.setSHOP_BR_ID(SbId);
		shop_loc.setLOC_ID(Locid);

		rawSqlDao.editShop_loc(shop_loc);

		return "redirect:/Shop_loc/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_loc_delete/{HeadId}/{Shop_BrId}/{Loc}")
	public String shop_loc_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("Loc") int Locid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_loc(Locid);

		return "redirect:/Shop_loc/" + sId + "/" + hId + "/" + SbId;
	}
	
	
	// SHOP GL
	
	@GetMapping("/Shop_GL/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_GL(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

	
		Shop_GL shop_gl = new Shop_GL();
		  
		  ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		  model.addAttribute("listShop_Br", listShop_Br);
		  
		  ArrayList<Head> listHead = dao.listHead(); 
		  model.addAttribute("listHead",listHead);
		  
		  ArrayList<Shop_GL> listShop_GL = rawSqlDao.listShop_GL(sId,hId,SbId); 
		
		  
		  model.addAttribute("shop_gl",shop_gl);
		  model.addAttribute("listShop_GL", listShop_GL);
		 
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_GL";
	}
	
	@PostMapping("/Shop_GL/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_gl_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_GL shop_gl) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_gl.setHEAD_ID(hId);
		shop_gl.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_GL(shop_gl);

		return "redirect:/Shop_GL/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_GL/{ShopId}/{HeadId}/{Shop_BrId}/{GL}")
	public String shop_gl_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("GL") int glid, Model model) {
	
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_GL shop_gl = rawSqlDao.singleShop_GL(glid);
		
		ArrayList<Shop_GL> listShop_GL = rawSqlDao.listShop_GL(sId,hId,SbId);
		
		model.addAttribute("listShop_GL", listShop_GL);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_gl", shop_gl);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("glid", glid);
		
	

		return "Shop_GL";
	}

	@PostMapping("/Shop_GL/{ShopId}/{HeadId}/{Shop_BrId}/{GL}")
	public String editShop_GL(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("GL") int glid, Model model, Shop_GL shop_gl) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_gl.setHEAD_ID(hId);
		shop_gl.setSHOP_BR_ID(SbId);
		shop_gl.setSHOP_GL_ID(glid);

		rawSqlDao.editShop_GL(shop_gl);

		return "redirect:/Shop_GL/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_GL_delete/{ShopId}/{HeadId}/{Shop_BrId}/{GL}")
	public String shop_gl_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("GL") int glid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_GL(glid);

		return "redirect:/Shop_GL/" + sId + "/" + hId + "/" + SbId;
	}
	
	@GetMapping("/Shop_vendor/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_vendor(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

	
		Shop_vendor shop_vendor = new Shop_vendor();
		  
		  ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		  model.addAttribute("listShop_Br", listShop_Br);
		  
		  ArrayList<Head> listHead = dao.listHead(); 
		  model.addAttribute("listHead",listHead);
		  
		  ArrayList<Shop_vendor> listShop_vendor = rawSqlDao.listShop_vendor(sId,hId,SbId); 
		
		  
		  model.addAttribute("shop_vendor",shop_vendor);
		  model.addAttribute("listShop_vendor", listShop_vendor);
		 
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		


		return "Shop_vendor";
	}
	
	@PostMapping("/Shop_vendor/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_vendor_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_vendor shop_vendor) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_vendor.setHEAD_ID(hId);
		shop_vendor.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_vendor(shop_vendor);

		return "redirect:/Shop_vendor/" + sId + "/" + hId + "/" +SbId;

	}

	@GetMapping("/Shop_vendor/{ShopId}/{HeadId}/{Shop_BrId}/{VEND}")
	public String shop_vendor_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("VEND") int venid, Model model) {
	
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_vendor shop_vendor = rawSqlDao.singleShop_vendor(venid);
		
		ArrayList<Shop_vendor> listShop_vendor = rawSqlDao.listShop_vendor(sId,hId,SbId);
		
		model.addAttribute("listShop_vendor", listShop_vendor);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_vendor", shop_vendor);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("venid", venid);
		
	

		return "Shop_vendor";
	}

	@PostMapping("/Shop_vendor/{ShopId}/{HeadId}/{Shop_BrId}/{VEND}")
	public String editShop_vendor(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("VEND") int venid, Model model, Shop_vendor shop_vendor) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_vendor.setHEAD_ID(hId);
		shop_vendor.setSHOP_BR_ID(SbId);
		shop_vendor.setVEND_ID(venid);

		rawSqlDao.editShop_vendor(shop_vendor);

		return "redirect:/Shop_vendor/" + sId + "/" + hId + "/" + SbId;
	}

	@PostMapping("/Shop_vendor_delete/{ShopId}/{HeadId}/{Shop_BrId}/{VEND}")
	public String shop_vendor_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("VEND") int venid) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_vendor(venid);

		return "redirect:/Shop_vendor/" + sId + "/" + hId + "/" + SbId;
	}
	
//////////// LEVEL - 1////////////////
	
	@GetMapping("/Level1")
	public String Level1(@CookieValue(value = "user_name", defaultValue = "") String user_name,Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";
	
		LEVEL1 level1 = new LEVEL1();

		ArrayList<LEVEL1> listLevel1 = rawSqlDao.listLevel1();
		model.addAttribute("listLevel1", listLevel1);
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		
		model.addAttribute("level1", level1);
		model.addAttribute("flag", flag);

		return "level1";
	}
	
	@PostMapping("/Level1")
	public String level1_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,LEVEL1 level1) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.insertLevel1(level1);

		return "redirect:/Level1";
	}
	
	@GetMapping("/Level1/{id}")
	public String level1_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			@PathVariable("id") int id, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		LEVEL1 level1 = rawSqlDao.singleLevel1(id);

		ArrayList<LEVEL1> listLevel1 = rawSqlDao.listLevel1();

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);

		model.addAttribute("listLevel1", listLevel1);
		model.addAttribute("level1", level1);
		model.addAttribute("flag", flag);
		model.addAttribute("id", id);
	

		return "level1";
	}

	@PostMapping("/Level1/{id}")
	public String level1_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id, Model model, LEVEL1 level1) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		level1.setSUB_HEAD_ID(id);

		rawSqlDao.editLevel1(level1);

		return "redirect:/Level1";
	}

	@PostMapping("/Level1_delete/{id}")
	public String level1_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("id") int id) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteLevel1(id);

		return "redirect:/Level1";
	}
	
	
	/////////// LEVEL 2 ////////////
	
	@GetMapping("/Level2/{Level1Parent}/{Level1SUB}")
	public String Level2(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		SF_SUB_HEAD level2 = new SF_SUB_HEAD();

		ArrayList<LEVEL1> listLevel1 = rawSqlDao.listLevel1();
		model.addAttribute("listLevel1", listLevel1);

		ArrayList<LEVEL2> listLevel2 = rawSqlDao.listLevel2(levell1parent,levell1Sub);
		model.addAttribute("listLevel2", listLevel2);
		
		model.addAttribute("level2", level2);	
		model.addAttribute("flag", flag);
		model.addAttribute("levell1Sub", levell1Sub);
		model.addAttribute("levell1parent", levell1parent);
		
	


		return "level2";
	}
	
	
	@PostMapping("/Level2/{Level1Parent}/{Level1SUB}")
	public String level2_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,
			LEVEL2 level2) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		level2.setPARENT_ID(levell1Sub);

		rawSqlDao.insertLevel2(level2);

		return "redirect:/Level2/" +levell1parent +"/"+ levell1Sub ;

	}
	
	@GetMapping("/Level2/{Level1Parent}/{Level1SUB}/{id}")
	public String level2_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub, @PathVariable("id") int id, Model model) {
	
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		LEVEL2 level2 = rawSqlDao.singleLevel2(levell1Sub,id);

		ArrayList<LEVEL1> listLevel1 = rawSqlDao.listLevel1();
		model.addAttribute("listLevel1", listLevel1);

		ArrayList<LEVEL2> listLevel2 = rawSqlDao.listLevel2(levell1parent,levell1Sub);
		model.addAttribute("listLevel2", listLevel2);
		
		model.addAttribute("level2", level2);	
		model.addAttribute("flag", flag);
		model.addAttribute("levell1Sub", levell1Sub);
		
		model.addAttribute("listLevel2", listLevel2);
		model.addAttribute("flag", flag);
		model.addAttribute("levell1Sub", levell1Sub);
		model.addAttribute("levell1parent", levell1parent);
	
		model.addAttribute("id", id);
	

		return "level2";
	}
	
	@PostMapping("/Level2/{Level1Parent}/{Level1SUB}/{id}")
	public String level2_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,@PathVariable("id") int id, Model model, LEVEL2 level2) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		level2.setPARENT_ID(levell1Sub);
		level2.setSUB_HEAD_ID(id);
		
		String l1=String.valueOf(levell1parent);
		/*if(l1.length()==1) {
			l1='0'+l1;
		}*/
		String l2=String.valueOf(levell1Sub);
		/*if(l2.length()==1) {
			l2='0'+l2;
		}*/
		String l3=String.valueOf(id);
		/*if(l3.length()==1) {
			l3='0'+l3;
		}*/

		
		String itemCode = l1+l2+l3; /* l1+l2+l3+"00" */
		
		
		
		String itemname = level2.getHEAD_NAME()+"-"+level2.getCHILD_NAME();
		
		
		dao.insertItem(itemCode,levell1parent,itemname,1);
		
		rawSqlDao.editLevel2(level2);

		return "redirect:/Level2/"+levell1parent +"/"+ levell1Sub ;
	}

	@PostMapping("/Level2_delete/{Level1Parent}/{Level1SUB}/{id}")
	public String level2_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,@PathVariable("id") int id) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteLevel2(id);

		return "redirect:/Level2/"+levell1parent +"/"+ levell1Sub;
	}
	
	
	//////////// Level 3 ///////////
	
	@GetMapping("/Level3/{Level1Parent}/{Levell1Sub}/{Level2SUB}")
	public String Level3(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Levell1Sub") int levell1Sub,@PathVariable("Level2SUB") int levell2Sub, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";

		LEVEL3 level3 = new LEVEL3();

		ArrayList<LEVEL2> listLevel2 = rawSqlDao.listLevel2(levell1parent,levell1Sub);
		model.addAttribute("listLevel2", listLevel2);

		ArrayList<LEVEL3> listLevel3 = rawSqlDao.listLevel3(levell1parent,levell1Sub,levell2Sub);
		model.addAttribute("listLevel3", listLevel3);
		
		model.addAttribute("level3", level3);	
		model.addAttribute("flag", flag);
		model.addAttribute("levell2Sub", levell2Sub);
		model.addAttribute("Level1SUB", levell1Sub);
		model.addAttribute("levell1parent", levell1parent);
	


		return "level3";
	}
	
	
	@PostMapping("/Level3/{Level1Parent}/{Levell1Sub}/{Level2SUB}")
	public String level3_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Levell1Sub") int levell1Sub,@PathVariable("Level2SUB") int levell2Sub,
			LEVEL3 level3) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		level3.setPARENT_ID(levell2Sub);

		rawSqlDao.insertLevel3(level3);

		return "redirect:/Level3/" +levell1parent +"/"+levell1Sub+"/"+levell2Sub ;

	}
	
	@GetMapping("/Level3/{Level1Parent}/{Level1SUB}/{Level2SUB}/{id}")
	public String level3_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,@PathVariable("Level2SUB") int levell2Sub, @PathVariable("id") int id, Model model) {
	
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		LEVEL3 level3 = rawSqlDao.singleLevel3(id);

		ArrayList<LEVEL2> listLevel2 = rawSqlDao.listLevel2(levell1parent,levell1Sub);
		model.addAttribute("listLevel2", listLevel2);

		ArrayList<LEVEL3> listLevel3 = rawSqlDao.listLevel3(levell1parent,levell1Sub,levell2Sub);
		model.addAttribute("listLevel3", listLevel3);
		if(!listLevel3.isEmpty()) {
			model.addAttribute("HEAD_NAME",listLevel3.get(0).getHEAD_NAME());
		}		
		
		model.addAttribute("level3", level3);	
		model.addAttribute("flag", flag);
		model.addAttribute("levell2Sub", levell2Sub);
		
		model.addAttribute("listLevel3", listLevel3);
		model.addAttribute("flag", flag);
		model.addAttribute("levell2Sub", levell2Sub);
		model.addAttribute("Level1SUB", levell1Sub);
		model.addAttribute("levell1parent", levell1parent);
	
		model.addAttribute("id", id);
	

		return "level3";
	}
	
	
	@PostMapping("/Level3/{Level1Parent}/{Level1SUB}/{Level2SUB}/{id}")
	public String level3_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,@PathVariable("Level2SUB") int levell2Sub,@PathVariable("id") int id, Model model, LEVEL3 level3) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		level3.setPARENT_ID(levell2Sub);
		level3.setSUB_HEAD_ID(id);
		
		int SUB_HEAD_ID = level3.getPARENT_ID();
		String l1=String.valueOf(levell1parent);
		/*if(l1.length()==1) {
			l1='0'+l1;
		}*/
		String l2=String.valueOf(levell1Sub);
		/*if(l2.length()==1) {
			l2='0'+l2;
		}*/
		String l3=String.valueOf(levell2Sub);
		/*if(l3.length()==1) {
			l3='0'+l3;
		}*/
		
		String l4=String.valueOf(id);
		/*if(l4.length()==1) {
			l4='0'+l4;
		}*/


		
		String itemCode = l4; /* l1+l2+l3+ */
		
		int level = level3.getLEV();
		
		String itemname = level3.getHEAD_NAME()+"-"+level3.getCHILD_NAME();
		
		
		dao.insertItem1(itemCode,levell1parent, itemname,level, SUB_HEAD_ID);

		rawSqlDao.editLevel3(level3);

		return "redirect:/Level3/"+levell1parent+"/"+levell1Sub+"/"+levell2Sub;
	}

	@PostMapping("/Level3_delete/{Level1Parent}/{Level1SUB}/{Level2SUB}/{id}")
	public String level3_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("Level1Parent") int levell1parent,@PathVariable("Level1SUB") int levell1Sub,@PathVariable("Level2SUB") int levell2Sub,@PathVariable("id") int id) {

		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteLevel3(id);

		return "redirect:/Level3/"+levell1parent+"/"+levell1Sub+"/"+levell2Sub;
	}
	
	@GetMapping("/Shop_Item/{ShopId}/{HeadId}/{Shop_BrId}")
	public String Shop_Item(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";
		Shop_Item shop_item = new Shop_Item();
		
		ArrayList<SF_SUB_HEAD> listHead = rawSqlDao.listHead(hId); 
		model.addAttribute("listHead",listHead);
		
		ArrayList<Shop_Item> listShop_Item = rawSqlDao.listShop_Item(sId,hId,SbId); 
		model.addAttribute("listShop_Item", listShop_Item);
		
		/*ArrayList<SF_BRAND_DROPDOWN> listSF_BRAND_Dropdown = rawSqlDao.listSF_BRAND_Dropdown(); 
		model.addAttribute("listSF_BRAND_Dropdown", listSF_BRAND_Dropdown); */
		
		model.addAttribute("shop_item",shop_item);
		 
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		
		return "Shop_Item";
	}
	
	@PostMapping("/Shop_Item/{ShopId}/{HeadId}/{Shop_BrId}")
	public String shop_item_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId,@PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId,
			Shop_Item shop_item) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		shop_item.setHEAD_ID(hId);
		shop_item.setSHOP_BR_ID(SbId);

		rawSqlDao.insertShop_Item(shop_item);

		return "redirect:/Shop_Item/" + sId + "/" + hId + "/" +SbId;

	}

	/*@GetMapping("/Shop_Item/{ShopId}/{HeadId}/{Shop_BrId}/{itemID}")
	public String shop_item_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("itemID") int Itemid, Model model) {
	
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";

		Shop_Item shop_item = rawSqlDao.singleShop_Item(Itemid);
		
		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos(sId,hId,SbId);
		
		model.addAttribute("listShop_Pos", listShop_Pos);

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		ArrayList<Item> listItem = rawSqlDao.listItem(hId); 
		  model.addAttribute("listItem",listItem);
		  
		  ArrayList<Shop_Brand> listShop_Brand = rawSqlDao.listShop_Brand(sId,hId,SbId);
		  model.addAttribute("listShop_Brand", listShop_Brand);
		
		 ArrayList<Shop_Item> listShop_Item = rawSqlDao.listShop_Item(sId,hId,SbId); 
		  model.addAttribute("listShop_Item", listShop_Item);

		ArrayList<Shop_Br> listShop_Br = rawSqlDao.listShop_Br(sId, hId);
		model.addAttribute("shop_item", shop_item);
		
		model.addAttribute("listShop_Br", listShop_Br);
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		model.addAttribute("Itemid", Itemid);
		
	

		return "Shop_Item";
	}*/

	/*@PostMapping("/Shop_Item/{ShopId}/{HeadId}/{Shop_BrId}/{itemID}")
	public String editShop_Pos(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("itemID") int Itemid, Model model, Shop_Item shop_item) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		shop_item.setHEAD_ID(hId);
		shop_item.setSHOP_BR_ID(SbId);
		shop_item.setSHOP_ITEM_ID(Itemid);

		rawSqlDao.editShop_Item(shop_item);

		return "redirect:/Shop_Item/" + sId + "/" + hId + "/" + SbId;
	}*/

	@GetMapping("/Shop_Item_delete/{ShopId}/{HeadId}/{Shop_BrId}/{itemID}")
	public String shop_item_delete(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId,
			@PathVariable("Shop_BrId") int SbId,@PathVariable("itemID") int Itemid, Model model) {
		if (user_name.equals("")) {
			return "redirect:/";
		}
		rawSqlDao.deleteShop_Item(Itemid);
		
		
		
		String flag = "0";
		Shop_Item shop_item = new Shop_Item();
		
		ArrayList<SF_SUB_HEAD> listHead = rawSqlDao.listHead(hId); 
		model.addAttribute("listHead",listHead);
		
		ArrayList<Shop_Item> listShop_Item = rawSqlDao.listShop_Item(sId,hId,SbId); 
		model.addAttribute("listShop_Item", listShop_Item);
		 
		model.addAttribute("shop_item",shop_item);
		 
		model.addAttribute("flag", flag);
		model.addAttribute("sId", sId);
		model.addAttribute("hId", hId);
		model.addAttribute("SbId", SbId);
		
		return "Shop_Item";

		/* return "redirect:/Shop_Item/" + sId + "/" + hId + "/" + SbId; */
	}
	
	@GetMapping("/Item_buy/{ShopId}/{HeadId}/{Shop_BrId}")
	public String item_buy(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			@PathVariable("ShopId") int sId, @PathVariable("HeadId") int hId, @PathVariable("Shop_BrId") int SbId, Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";
		model.addAttribute("flag", flag);

		Date todaysdate = new Date();
		
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		String TransDate = format2.format(todaysdate);
		model.addAttribute("TransDate", TransDate);
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		String TransCode = format1.format(todaysdate);
		model.addAttribute("TransCode", TransCode);
		
		ArrayList<Shop_Pos> listShop_Pos = rawSqlDao.listShop_Pos(sId, hId);
		if(!listShop_Pos.isEmpty())
		{
			model.addAttribute("POS_ID", listShop_Pos.get(0).getPOS_ID());
		}
		
		ArrayList<Shop_vendor> listShop_vendor = rawSqlDao.listShop_vendor(sId, hId);
		model.addAttribute("listShop_vendor", listShop_vendor);
		
		model.addAttribute("user_name", user_name);
		
		ArrayList<Item> listItem = rawSqlDao.listItem();
		model.addAttribute("listItem", listItem);
		
		ArrayList<SF_UNIT> listItem1 = rawSqlDao.listSF_UNIT();
		model.addAttribute("listItem1", listItem1);
		
		Item_buy item_buy = new Item_buy();
		model.addAttribute("item_buy", item_buy);
		
		return "itemBuy";
	}
	
	
	
	@GetMapping("/Account_Statement")
	public String Account_Statement(@CookieValue(value = "user_name", defaultValue = "") String user_name,Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		String flag = "0";
	
		Account_Statement accountStat = new Account_Statement();
		model.addAttribute("accountStat", accountStat);
		
		
		
		model.addAttribute("flag", flag);

		return "accountStat";
	}
	
	@PostMapping("/Account_Statement")
	public String accountStat_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,Account_Statement accStat, Model model) {
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		Account_Statement accountStat = new Account_Statement();
		model.addAttribute("accountStat", accountStat);

//		ArrayList<Account_Statement> itemModel1 = rawSqlDao.listAccount_Statement(accStat.SHOP_GL_ID);
//		
		ArrayList<Account_Statement> itemModel2 = rawSqlDao.listAccount_Statement2(accStat.getSHOP_GL_ID());
//		ArrayList<Account_Statement> itemModels=new ArrayList<>();
		
		
		
//		String previd="";
//        int ij=0;
//        for(int i=0;i<itemModel1.size();i++){
//            if(i==0){
//                itemModels.add(new Account_Statement(itemModel1.get(i).SHOP_GL_ID,itemModel1.get(i).GL_NAME,itemModel1.get(i).AMT));
//                previd=itemModel1.get(i).SHOP_GL_ID;
//            }else{
//                if(itemModel1.get(i).SHOP_GL_ID.equals(previd)){
//                    itemModels.add(new Account_Statement(itemModel1.get(i).SHOP_GL_ID,itemModel1.get(i).GL_NAME,itemModel1.get(i).AMT));
//                }else{
//                    itemModels.add(new Account_Statement(itemModel2.get(ij).GL_NAME,"Total",itemModel2.get(ij).AMT));
//                    ij++;
//                    previd=itemModel1.get(i).SHOP_GL_ID;
//                    itemModels.add(new Account_Statement(itemModel1.get(i).SHOP_GL_ID,itemModel1.get(i).GL_NAME,itemModel1.get(i).AMT));
//                }
//            }
//
//        }
        model.addAttribute("itemModel2", itemModel2);
        model.addAttribute("date", accStat.getSHOP_GL_ID());
		return "accountStat";
	}
	
	
	@GetMapping("/Payment/{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}")
	public String Payment(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("SHOP_ID") int SHOP_ID,@PathVariable("HEAD_ID") int HEAD_ID, @PathVariable("SHOP_BR_ID") int SHOP_BR_ID, Model model) {
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "0";
		ArrayList<Month> listMonth = new ArrayList<Month>();
		listMonth.add(new Month("January", "January"));
		listMonth.add(new Month("Februaury", "Februaury"));
		listMonth.add(new Month("March", "March"));
		listMonth.add(new Month("April", "April"));
		listMonth.add(new Month("May", "May"));
		listMonth.add(new Month("June", "June"));
		listMonth.add(new Month("July", "July"));
		listMonth.add(new Month("August", "August"));
		listMonth.add(new Month("September", "September"));
		listMonth.add(new Month("October", "October"));
		listMonth.add(new Month("November", "November"));
		listMonth.add(new Month("December", "December"));
		model.addAttribute("listMonth", listMonth);
		Payment payment = new Payment();
		model.addAttribute("payment", payment);
		
		
		ArrayList<Payment> listPayment = rawSqlDao.listPayment(SHOP_ID, HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listPayment", listPayment);
		
		model.addAttribute("flag", flag);
		model.addAttribute("SHOP_ID", SHOP_ID);
		model.addAttribute("HEAD_ID", HEAD_ID);
		model.addAttribute("SHOP_BR_ID", SHOP_BR_ID);

		return "Payment";
	}
	
	@GetMapping("/Payment/{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}/{PAYED_ID}")
	public String Payment_single(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("SHOP_ID") int SHOP_ID, @PathVariable("HEAD_ID") int HEAD_ID,
			@PathVariable("SHOP_BR_ID") int SHOP_BR_ID,@PathVariable("PAYED_ID") int PAYED_ID, Model model) {
	
		if (user_name.equals("")) {
			return "redirect:/";
		}
		String flag = "1";
		
		ArrayList<Month> listMonth = new ArrayList<Month>();
		listMonth.add(new Month("January", "January"));
		listMonth.add(new Month("Februaury", "Februaury"));
		listMonth.add(new Month("March", "March"));
		listMonth.add(new Month("April", "April"));
		listMonth.add(new Month("May", "May"));
		listMonth.add(new Month("June", "June"));
		listMonth.add(new Month("July", "July"));
		listMonth.add(new Month("August", "August"));
		listMonth.add(new Month("September", "September"));
		listMonth.add(new Month("October", "October"));
		listMonth.add(new Month("November", "November"));
		listMonth.add(new Month("December", "December"));
		model.addAttribute("listMonth", listMonth);

		Payment payment = rawSqlDao.singlePayment(PAYED_ID);
		model.addAttribute("payment", payment);
		
		ArrayList<Payment> listPayment = rawSqlDao.listPayment(SHOP_ID, HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listPayment", listPayment);
		
			int MNT_AMT = payment.getMNT_AMT();
			int DAY_GAP = payment.getDAY_GAP();
			int INT_AMT = payment.getINT_AMT();
			String PAY_MON = payment.getPAY_MON();
			String INI_DATE = payment.getINI_DATE();
			
			
			
			model.addAttribute("MNT_AMT", MNT_AMT);
			model.addAttribute("DAY_GAP", DAY_GAP);
			model.addAttribute("INT_AMT", INT_AMT);
			model.addAttribute("PAY_MON", PAY_MON);
			model.addAttribute("INI_DATE", INI_DATE);
			
		model.addAttribute("flag", flag);
		model.addAttribute("SHOP_ID", SHOP_ID);
		model.addAttribute("HEAD_ID", HEAD_ID);
		model.addAttribute("SHOP_BR_ID", SHOP_BR_ID);
		model.addAttribute("PAYED_ID", PAYED_ID);
		
		
		return "Payment";
	}
	
	@PostMapping("/Payment/{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}")
	public String Payment_save(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("SHOP_ID") int SHOP_ID, @PathVariable("HEAD_ID") int HEAD_ID, @PathVariable("SHOP_BR_ID") int SHOP_BR_ID,
			Payment payment) {

		if (user_name.equals("")) {
			return "redirect:/";
		}
		payment.setSHOP_ID(SHOP_ID);
		payment.setHEAD_ID(HEAD_ID);
		payment.setSHOP_BR_ID(SHOP_BR_ID);
		
		rawSqlDao.insertPayment(payment);
		rawSqlDao.insertPayment1(payment);

		return "redirect:/Payment/"+SHOP_ID+"/"+HEAD_ID+"/"+SHOP_BR_ID;

	} 
	
	@PostMapping("/Payment_edit/{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}/{PAYED_ID}")
	public String Payment_edit(@PathVariable("SHOP_ID") int SHOP_ID, @PathVariable("HEAD_ID") int HEAD_ID,
			@PathVariable("SHOP_BR_ID") int SHOP_BR_ID,@PathVariable("PAYED_ID") int PAYED_ID, Model model,
			Payment payment) {

		payment.setPAYED_ID(PAYED_ID);
		
		rawSqlDao.Payment_edit(payment);
		
		/* rawSqlDao.Payment_edit1(payment); */

		return "redirect:/Payment/"+payment.getSHOP_ID()+"/"+payment.getHEAD_ID()+"/"+payment.getSHOP_BR_ID();
	}

	@PostMapping("/Payment_delete/{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}/{PAYED_ID}")
	public String Payment_delete(@PathVariable("SHOP_ID") int SHOP_ID, @PathVariable("HEAD_ID") int HEAD_ID,
			@PathVariable("SHOP_BR_ID") int SHOP_BR_ID,@PathVariable("PAYED_ID") int PAYED_ID, Payment payment) {

		rawSqlDao.Payment_delete(PAYED_ID);

		return "redirect:/Payment/"+payment.getSHOP_ID()+"/"+payment.getHEAD_ID()+"/"+payment.getSHOP_BR_ID();
	}

	
	@GetMapping("/UnAuth_Payment") /* /{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID} */
	public String Un_Auth_Payment(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	/*@PathVariable("SHOP_ID") int SHOP_ID,@PathVariable("HEAD_ID") int HEAD_ID, @PathVariable("SHOP_BR_ID") int SHOP_BR_ID,*/
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		//String flag = "0";
		
		
		ArrayList<Un_Auth_Payment> listUn_Auth_Payment = rawSqlDao.listUn_Auth_Payment();
		model.addAttribute("listUn_Auth_Payment", listUn_Auth_Payment);
		
		//model.addAttribute("flag", flag);
		//model.addAttribute("SHOP_ID", SHOP_ID);
		//model.addAttribute("HEAD_ID", HEAD_ID);
		//model.addAttribute("SHOP_BR_ID", SHOP_BR_ID);

		return "Un_Auth_Payment";
	}
	
	@GetMapping("/UnAuth_Payment/{PAYED_HIST_ID}") /* /{SHOP_ID}/{HEAD_ID}/{SHOP_BR_ID}/{PAYED_HIST_ID} */
	public String Un_Auth_Payment_edit(@CookieValue(value = "user_name", defaultValue = "") String user_name,@PathVariable("PAYED_HIST_ID") int PAYED_HIST_ID, Model model)/*@PathVariable("SHOP_ID") int SHOP_ID,
	@PathVariable("HEAD_ID") int HEAD_ID,@PathVariable("SHOP_BR_ID") int SHOP_BR_ID,
	@PathVariable("PAYED_HIST_ID") int PAYED_HIST_ID,*/
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		//String flag = "0";
		//un_Auth_Payment.setPAYED_HIST_ID(PAYED_HIST_ID);

		
		rawSqlDao.Un_Auth_Payment_edit(PAYED_HIST_ID);
		
		ArrayList<Un_Auth_Payment> listUn_Auth_Payment = rawSqlDao.listUn_Auth_Payment();
		model.addAttribute("listUn_Auth_Payment", listUn_Auth_Payment);
		
		//model.addAttribute("flag", flag);
		//model.addAttribute("SHOP_ID", SHOP_ID);
		//model.addAttribute("HEAD_ID", HEAD_ID);
		//model.addAttribute("SHOP_BR_ID", SHOP_BR_ID);

		return "Un_Auth_Payment";
	}
	
	@GetMapping("/ITEM_LIST")
	public String ITEM_LIST(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		Head head = new Head();
		model.addAttribute("head", head);
		
		
		return "ITEM_LIST";
	}
	
	@PostMapping("/ITEM_LIST")
	public String ITEM_LIST_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			Head head, Model model) {

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		int HEAD_ID = head.getHEAD_ID();
		
		List<Item> listItem = rawSqlDao.listItem1(HEAD_ID);
		model.addAttribute("listItem", listItem);
		
		return "ITEM_LIST";
	}
	
	
	@GetMapping("/SHOP_ITEM_LIST")
	public String SHOP_ITEM_LIST(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		Shop_Item shop_Item = new Shop_Item();
		model.addAttribute("shop_Item", shop_Item);
		
		
		return "SHOP_ITEM_LIST";
	}
	
	@PostMapping("/SHOP_ITEM_LIST")
	public String SHOP_ITEM_LIST_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			Shop_Item shop_Item, Model model) {

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		int HEAD_ID = shop_Item.getHEAD_ID();
		int SHOP_BR_ID = shop_Item.getSHOP_BR_ID();
		
		List<Shop_Item> listShopItem = rawSqlDao.listShopItem(HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listShopItem", listShopItem);
		
		return "SHOP_ITEM_LIST";
	}
	
	
	@GetMapping("/SHOP_STOCK_LIST")
	public String SHOP_STOCK_LIST(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		Stock stock = new Stock();
		model.addAttribute("stock", stock);
		
		
		return "SHOP_STOCK_LIST";
	}
	
	@PostMapping("/SHOP_STOCK_LIST")
	public String SHOP_STOCK_LIST_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			Stock stock, Model model) {

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		int HEAD_ID = stock.getHEAD_ID();
		int SHOP_BR_ID = stock.getSHOP_BR_ID();
		
		List<Stock> listStockItem = rawSqlDao.listStockItem(HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listStockItem", listStockItem);
		
		return "SHOP_STOCK_LIST";
	}
	
	@GetMapping("/SHOP_CONTACT_LIST")
	public String SHOP_CONTACT_LIST(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		Shop_Contact shop_Contact = new Shop_Contact();
		model.addAttribute("shop_Contact", shop_Contact);
		
		
		return "SHOP_CONTACT_LIST";
	}
	
	@PostMapping("/SHOP_CONTACT_LIST")
	public String SHOP_CONTACT_LIST_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			Shop_Contact shop_Contact, Model model) {

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		int HEAD_ID = shop_Contact.getHEAD_ID();
		int SHOP_BR_ID = shop_Contact.getSHOP_BR_ID();
		
		List<Shop_Contact> listShop_Contact = rawSqlDao.listShop_Contact1(HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listShop_Contact", listShop_Contact);
		
		return "SHOP_CONTACT_LIST";
	}
	
	
	@GetMapping("/SHOP_DETAILS_LIST")
	public String SHOP_PAYMENT_LIST(@CookieValue(value = "user_name", defaultValue = "") String user_name, Model model)
	{
		
		
		if (user_name.equals("")) {
			return "redirect:/";
		}
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		SHOP_DETAILS sHOP_DETAILS = new SHOP_DETAILS();
		model.addAttribute("sHOP_DETAILS", sHOP_DETAILS);
		
		
		return "SHOP_DETAILS_LIST";
	}
	
	@PostMapping("/SHOP_DETAILS_LIST")
	public String SHOP_PAYMENT_LIST_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			SHOP_DETAILS sHOP_DETAILS, Model model) {

		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		int HEAD_ID = sHOP_DETAILS.getHEAD_ID();
		int SHOP_BR_ID = sHOP_DETAILS.getSHOP_BR_ID();
		
		List<SHOP_DETAILS> listSHOP_DETAILS = rawSqlDao.listSHOP_DETAILS(HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listSHOP_DETAILS", listSHOP_DETAILS);
		
		return "SHOP_DETAILS_LIST";
	}
	
	@GetMapping("/PAYMENT_LIST")
	public String IC_SMS_DASHBOARD(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			 Model model) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date result = cal.getTime();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		
		String fromDate=formatter1.format(result);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String toDate=formatter.format(date);
		
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		
		//model.addAttribute("TO_DATE", toDate);
		SF_SHOP_PAYMENT_HIST sF_SHOP_PAYMENT_HIST = new SF_SHOP_PAYMENT_HIST();
		sF_SHOP_PAYMENT_HIST.setTO_DATE(toDate);
		sF_SHOP_PAYMENT_HIST.setFROM_DATE(fromDate);
		model.addAttribute("sF_SHOP_PAYMENT_HIST", sF_SHOP_PAYMENT_HIST);

		

		return "PAYMENT_LIST";
	}

	@PostMapping("/PAYMENT_LIST")
	public String IC_SMS_DASHBOARD_Table(@CookieValue(value = "user_name", defaultValue = "") String user_name,
			 Model model, SF_SHOP_PAYMENT_HIST sF_SHOP_PAYMENT_HIST) {

		
		String FROM_DATE = sF_SHOP_PAYMENT_HIST.getFROM_DATE();
		String TO_DATE1 = sF_SHOP_PAYMENT_HIST.getTO_DATE();
		int HEAD_ID = sF_SHOP_PAYMENT_HIST.getHEAD_ID();
		int SHOP_BR_ID =  sF_SHOP_PAYMENT_HIST.getSHOP_BR_ID();
		ArrayList<Head> listHead = dao.listHead();
		model.addAttribute("listHead", listHead);
		List<SF_SHOP_PAYMENT_HIST> listSF_SHOP_PAYMENT_HIST = rawSqlDao.listSF_SHOP_PAYMENT_HIST(FROM_DATE, TO_DATE1, HEAD_ID, SHOP_BR_ID);
		model.addAttribute("listSF_SHOP_PAYMENT_HIST", listSF_SHOP_PAYMENT_HIST);
		model.addAttribute("sF_SHOP_PAYMENT_HIST", sF_SHOP_PAYMENT_HIST);
		
		return "PAYMENT_LIST";
	}


}
