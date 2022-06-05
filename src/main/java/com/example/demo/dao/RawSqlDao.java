package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account_Statement;
import com.example.demo.model.DISTRICT_DROPDOWN;
import com.example.demo.model.DrpDwn;
import com.example.demo.model.Item;
import com.example.demo.model.LEVEL1;
import com.example.demo.model.LEVEL2;
import com.example.demo.model.LEVEL3;
import com.example.demo.model.Payment;
import com.example.demo.model.SF_BRAND_DROPDOWN;
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
import com.example.demo.model.listSF_ITEM_Dropdown;

@Repository
public class RawSqlDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<User> listUser() {

		String sql = "SELECT U.USR_ID, U.USER_TYPE_ID, Ut.USER_TYPE_NAME,U.USER_NAME,U.PASS_NAME, U.SHOP_BR_ID, SB.SHOP_BR_NAME,U.HEAD_ID,H.HEAD_NAME,U.POS_ID,P.POS_NAME, U.EMAIL_ID, U.VER_CODE \r\n"
				+ " FROM SF_SHOP_USER U,SF_USER_TYPE Ut,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB, SF_SHOP_POS  P WHERE U.USER_TYPE_ID=Ut.USER_TYPE_ID AND U.SHOP_BR_ID=SB.SHOP_BR_ID AND U.HEAD_ID=H.HEAD_ID \r\n"
				+ "  AND U.POS_ID=P.POS_ID";
		ArrayList<User> listUser = (ArrayList<User>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(User.class));

		return listUser;
	}
	
	
	public void insertUser(User user) {
		String sql = "INSERT INTO SF_SHOP_USER (USER_TYPE_ID,USER_NAME,PASS_NAME,SHOP_BR_ID,HEAD_ID,POS_ID,EMAIL_ID,VER_CODE)VALUES(:USER_TYPE_ID, :USER_NAME,:PASS_NAME,:SHOP_BR_ID,:HEAD_ID,:POS_ID,:EMAIL_ID,:VER_CODE)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public User singleUser(int id) {

		String sql = "SELECT U.USR_ID, U.USER_TYPE_ID, Ut.USER_TYPE_NAME,U.USER_NAME,U.PASS_NAME, U.SHOP_BR_ID, SB.SHOP_BR_NAME,U.HEAD_ID,H.HEAD_NAME,U.POS_ID,P.POS_NAME, U.EMAIL_ID, U.VER_CODE \r\n"
				+ "	FROM SF_SHOP_USER U,SF_USER_TYPE Ut,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB, SF_SHOP_POS  P WHERE U.USER_TYPE_ID=Ut.USER_TYPE_ID AND U.SHOP_BR_ID=SB.SHOP_BR_ID AND U.HEAD_ID=H.HEAD_ID \r\n"
				+ "	AND U.POS_ID=P.POS_ID AND USR_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		User user = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(User.class));

		return user;
	}
	
	public void editUser(User user) {
		String sql = "UPDATE SF_SHOP_USER SET USER_TYPE_ID=:USER_TYPE_ID, USER_NAME=:USER_NAME,PASS_NAME=:PASS_NAME,SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,POS_ID=:POS_ID,EMAIL_ID=:EMAIL_ID,VER_CODE=:VER_CODE where USR_ID=:USR_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteUser(int id) {
		
		String sql = "DELETE FROM SF_SHOP_USER WHERE USR_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Shop> listShop() {

		String sql = "SELECT  S.SHOP_ID,S.HEAD_ID,H.HEAD_NAME,S.SHOP_NAME FROM SF_SHOP S,SF_MAIN_HEAD H WHERE S.HEAD_ID=H.HEAD_ID";
		ArrayList<Shop> listShop = (ArrayList<Shop>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop.class));

		return listShop;
	}
	
	public ArrayList<Item> listItem() {

		String sql = "SELECT * FROM SF_ITEM ";
		ArrayList<Item> listItem = (ArrayList<Item>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Item.class));

		return listItem;
	}
	
	public void insertShop(Shop shop) {
		String sql = "INSERT INTO SF_SHOP (HEAD_ID,SHOP_NAME)VALUES(:HEAD_ID, :SHOP_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop singleShop(int id) {

		String sql = "SELECT S.SHOP_ID,S.HEAD_ID,H.HEAD_NAME,S.SHOP_NAME FROM SF_SHOP S,SF_MAIN_HEAD H WHERE S.HEAD_ID=H.HEAD_ID AND SHOP_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop shop = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop.class));

		return shop;
	}
	
	public void editShop(Shop shop) {
		String sql = "UPDATE SF_SHOP SET HEAD_ID=:HEAD_ID, SHOP_NAME=:SHOP_NAME where SHOP_ID=:SHOP_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop(int id) {
		String sql = "DELETE FROM SF_SHOP WHERE SHOP_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Shop_Br> listShop_Br(int sId,int hId) {

		String sql = "SELECT SB.SHOP_BR_ID, SB.SHOP_ID, S.SHOP_NAME,SB.HEAD_ID,H.HEAD_NAME, SB.SHOP_BR_NAME FROM SF_SHOP S,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB\r\n"
				+ " WHERE SB.SHOP_ID = S.SHOP_ID AND S.HEAD_ID= H.HEAD_ID AND SB.SHOP_ID='" + sId +"' AND SB.HEAD_ID='" + hId +"'";
		ArrayList<Shop_Br> listShop_Br = (ArrayList<Shop_Br>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Br.class));

		return listShop_Br;
	}
	
	public ArrayList<Shop_Br> dropShop_Br(int hId) {

		String sql = "SELECT SB.SHOP_BR_ID, SB.SHOP_ID, S.SHOP_NAME,SB.HEAD_ID,H.HEAD_NAME, SB.SHOP_BR_NAME FROM SF_SHOP S,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB\r\n"
				+ " WHERE SB.SHOP_ID = S.SHOP_ID and SB.HEAD_ID=H.HEAD_ID AND SB.HEAD_ID='" + hId +"'";
		ArrayList<Shop_Br> dropShop_Br = (ArrayList<Shop_Br>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Br.class));

		return dropShop_Br;
	}
	
	public ArrayList<Shop_Br> dropShop_Br() {

		String sql = " SELECT SB.SHOP_BR_ID, SB.SHOP_ID, S.SHOP_NAME,SB.HEAD_ID,H.HEAD_NAME, SB.SHOP_BR_NAME FROM SF_SHOP S,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB WHERE SB.SHOP_ID=S.SHOP_ID AND SB.HEAD_ID=H.HEAD_ID";
		ArrayList<Shop_Br> dropShop_Br = (ArrayList<Shop_Br>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Br.class));

		return dropShop_Br;
	}
	
	public void insertShop_Br(Shop_Br shop_br) {
		String sql = "INSERT INTO SF_SHOP_BRANCH (HEAD_ID,SHOP_ID,SHOP_BR_NAME)VALUES(:HEAD_ID,:SHOP_ID,:SHOP_BR_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_br);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_Br singleShop_Br(int id) {

		String sql = "SELECT SB.SHOP_BR_ID, SB.SHOP_ID, S.SHOP_NAME,SB.HEAD_ID,H.HEAD_NAME, SB.SHOP_BR_NAME FROM SF_SHOP S,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB WHERE SB.SHOP_ID=S.SHOP_ID AND SB.HEAD_ID=H.HEAD_ID AND SHOP_BR_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_Br shop_br = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_Br.class));

		return shop_br;
	}
	
	public void editShop_Br(Shop_Br shop_br) {
		String sql = "UPDATE SF_SHOP_BRANCH SET HEAD_ID=:HEAD_ID, SHOP_NAME=:SHOP_NAME where SHOP_BR_ID=:SHOP_BR_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_br);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_Br(int id) {
		String sql = "DELETE FROM SF_SHOP_BRANCH WHERE SHOP_BR_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Shop_Brand> listShop_Brand(int sId,int hId,int SbID) {

		String sql = " SELECT SBr.BRAND_ID,S.SHOP_ID, SBr.HEAD_ID,H.HEAD_NAME,SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.BRAND_NAME \r\n"
				+ " FROM SF_SHOP_BRAND SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S\r\n"
				+ " where SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID\r\n"
				+ " and  SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbID;
		ArrayList<Shop_Brand> listShop_Brand = (ArrayList<Shop_Brand>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Brand.class));

		return listShop_Brand;
	}
	
	public void insertShop_Brand(Shop_Brand shop_brand) {
		String sql = "INSERT INTO SF_SHOP_BRAND (BRAND_ID,HEAD_ID,SHOP_BR_ID,BRAND_NAME)VALUES(:BRAND_ID,:HEAD_ID,:SHOP_BR_ID,:BRAND_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_brand);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_Brand singleShop_Brand(int id) {

		String sql = "SELECT SBr.BRAND_ID, SBr.HEAD_ID,H.HEAD_NAME,SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.BRAND_NAME FROM SF_SHOP_BRAND SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB\r\n"
				+ " WHERE SBr.HEAD_ID=H.HEAD_ID AND SBr.SHOP_BR_ID=SB.SHOP_BR_ID AND BRAND_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_Brand shop_brand = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_Brand.class));

		return shop_brand;
	}
	
	public void editShop_Brand(Shop_Brand shop_brand) {
		String sql = "UPDATE SF_SHOP_BRAND SET HEAD_ID=:HEAD_ID,SHOP_BR_ID=:SHOP_BR_ID,BRAND_NAME=:BRAND_NAME where BRAND_ID=:BRAND_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_brand);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_Brand(int id) {
		String sql = "DELETE FROM SF_SHOP_BRAND WHERE BRAND_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Shop_Contact> listShop_Contact(int sId,int hId,int SbId) {

		String sql = "  SELECT SBr.CON_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.CON_NAME,CON_PHN1,CON_PHN2, \r\n"
				+ "CON_EMAIL,CON_NID,CON_TIN,CON_ADDR1, CON_ADDR2 FROM SF_SHOP_CONTACT SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and \r\n"
				+ " SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbId;
		
		ArrayList<Shop_Contact> listShop_Contact = (ArrayList<Shop_Contact>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Contact.class));

		return listShop_Contact;
	}
	
	public void insertShop_Contact(Shop_Contact shop_contact) {
		String sql = "INSERT INTO SF_SHOP_CONTACT (CON_ID,HEAD_ID,SHOP_BR_ID,CON_NAME,CON_PHN1,CON_PHN2,CON_EMAIL,CON_NID,CON_TIN,CON_ADDR1,CON_ADDR2)VALUES(:CON_ID,:HEAD_ID,:SHOP_BR_ID,:CON_NAME,:CON_PHN1,:CON_PHN2,:CON_EMAIL,:CON_NID,:CON_TIN,:CON_ADDR1,:CON_ADDR2)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_contact);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_Contact singleShop_Contact(int id) {

		String sql = " SELECT SBr.CON_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.CON_NAME,CON_PHN1,CON_PHN2, \r\n"
		+"CON_EMAIL,CON_NID,CON_TIN,CON_ADDR1, CON_ADDR2 FROM SF_SHOP_CONTACT SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where \r\n"
		+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID \r\n"
			+"  AND CON_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_Contact shop_contact = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_Contact.class));

		return shop_contact;
	}
	
	public void editShop_Contact(Shop_Contact shop_contact) {
		
		String sql = "UPDATE SF_SHOP_CONTACT SET SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,CON_NAME=:CON_NAME,CON_PHN1=:CON_PHN1,CON_PHN2=:CON_PHN2,CON_EMAIL=:CON_EMAIL,CON_NID=:CON_NID,CON_TIN=:CON_TIN,CON_ADDR1=:CON_ADDR1,CON_ADDR2=:CON_ADDR2 where CON_ID=:CON_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_contact);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_Contact(int id) {
		String sql = "DELETE FROM SF_SHOP_CONTACT WHERE CON_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	public ArrayList<Shop_Pos> listShop_Pos(int sId,int hId,int SbId) {

		String sql = "  SELECT SBr.POS_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.POS_NAME \r\n"
				+ "FROM SF_SHOP_POS SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and \r\n"
				+ " SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbId;
		
		ArrayList<Shop_Pos> listShop_Pos = (ArrayList<Shop_Pos>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Pos.class));

		return listShop_Pos;
	}
	
	public ArrayList<Shop_Pos> listShop_Pos() {

		String sql = "  SELECT SBr.POS_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.POS_NAME \r\n"
				+ "FROM SF_SHOP_POS SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID ";
		
		ArrayList<Shop_Pos> listShop_Pos = (ArrayList<Shop_Pos>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Pos.class));

		return listShop_Pos;
	}
	
	public ArrayList<Shop_Pos> listShop_Pos(int brId) {

		String sql = "  SELECT SBr.POS_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.POS_NAME \r\n"
				+ "FROM SF_SHOP_POS SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and SBr.SHOP_BR_ID=" + brId ;
		
		ArrayList<Shop_Pos> listShop_Pos = (ArrayList<Shop_Pos>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Pos.class));

		return listShop_Pos;
	}
	
	public void insertShop_Pos(Shop_Pos shop_pos) {
		String sql = "INSERT INTO SF_SHOP_POS (HEAD_ID,SHOP_BR_ID,POS_NAME)VALUES(:HEAD_ID,:SHOP_BR_ID,:POS_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_pos);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_Pos singleShop_Pos(int id) {

		String sql = " SELECT SBr.POS_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.POS_NAME \r\n"
		+"FROM SF_SHOP_POS SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where \r\n"
		+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID \r\n"
			+"  AND POS_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_Pos shop_pos = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_Pos.class));

		return shop_pos;
	}
	
	public void editShop_Pos(Shop_Pos shop_pos) {
		
		String sql = "UPDATE SF_SHOP_POS SET SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,POS_NAME=:POS_NAME where POS_ID=:POS_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_pos);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_Pos(int id) {
		String sql = "DELETE FROM SF_SHOP_POS WHERE POS_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	public ArrayList<Shop_GL> listShop_GL(int sId,int hId,int SbId) {

		String sql = "  SELECT SBr.SHOP_GL_ID,S.SHOP_ID,SBr.HEAD_ID,H.HEAD_NAME,SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.GL_NAME,SBr.TYPE \r\n"
				+ "FROM SF_SHOP_GL SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and \r\n"
				+ " SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbId;
		
		ArrayList<Shop_GL> listShop_GL = (ArrayList<Shop_GL>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_GL.class));

		return listShop_GL;
	}
	
	public void insertShop_GL(Shop_GL shop_gl) {
		String sql = "INSERT INTO SF_SHOP_GL (SHOP_GL_ID,HEAD_ID,SHOP_BR_ID,GL_NAME,TYPE)VALUES(:SHOP_GL_ID,:HEAD_ID,:SHOP_BR_ID,:GL_NAME,:TYPE)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_gl);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_GL singleShop_GL(int id) {

		String sql = " SELECT SBr.SHOP_GL_ID,S.SHOP_ID,SBr.HEAD_ID,H.HEAD_NAME, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.GL_NAME,SBr.TYPE \r\n"
		+"FROM SF_SHOP_GL SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where \r\n"
		+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID \r\n"
			+"  AND SHOP_GL_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_GL shop_gl = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_GL.class));

		return shop_gl;
	}
	
	public void editShop_GL(Shop_GL shop_gl) {
		
		String sql = "UPDATE SF_SHOP_GL SET SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,GL_NAME=:GL_NAME,TYPE=:TYPE where SHOP_GL_ID=:SHOP_GL_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_gl);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_GL(int id) {
		String sql = "DELETE FROM SF_SHOP_GL WHERE SHOP_GL_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	public ArrayList<Shop_vendor> listShop_vendor(int sId,int hId,int SbId) {

		String sql = "  SELECT SBr.VEND_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.VEND_NAME \r\n"
				+ "FROM SF_SHOP_VENDOR SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and \r\n"
				+ " SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbId;
		
		ArrayList<Shop_vendor> listShop_vendor = (ArrayList<Shop_vendor>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_vendor.class));

		return listShop_vendor;
	}
	
	public void insertShop_vendor(Shop_vendor shop_vendor) {
		String sql = "INSERT INTO SF_SHOP_VENDOR (VEND_ID,HEAD_ID,SHOP_BR_ID,VEND_NAME)VALUES(:VEND_ID,:HEAD_ID,:SHOP_BR_ID,:VEND_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_vendor);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_vendor singleShop_vendor(int id) {

		String sql = " SELECT SBr.VEND_ID,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.VEND_NAME \r\n"
		+"FROM SF_SHOP_VENDOR SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S where \r\n"
		+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID \r\n"
			+"  AND VEND_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_vendor shop_vendor = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_vendor.class));

		return shop_vendor;
	}
	
	public void editShop_vendor(Shop_vendor shop_vendor) {
		
		String sql = "UPDATE SF_SHOP_VENDOR SET SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,VEND_NAME=:VEND_NAME where VEND_ID=:VEND_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_vendor);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_vendor(int id) {
		String sql = "DELETE FROM SF_SHOP_VENDOR WHERE VEND_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Shop_loc> listShop_loc(int sId,int hId,int SbId) {

		String sql = "  SELECT SBr.LOC_ID,SBr.THANA_ID,T.THANA_NAME,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.CON_ADDR1,SBr.CON_ADDR2 \r\n"
				+ "FROM SF_SHOP_LOC SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S, SF_THANA T where\r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and SBR.THANA_ID=T.THANA_ID AND \r\n"
				+ " SBr.HEAD_ID=" + hId +" AND SBr.SHOP_BR_ID="+ SbId;
		
		ArrayList<Shop_loc> listShop_loc = (ArrayList<Shop_loc>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_loc.class));

		return listShop_loc;
	}
	
	
	public void insertShop_loc(Shop_loc shop_loc) {
		String sql = "INSERT INTO SF_SHOP_LOC (LOC_ID,THANA_ID,HEAD_ID,SHOP_BR_ID,CON_ADDR1,CON_ADDR2)VALUES(:LOC_ID,:THANA_ID,:HEAD_ID,:SHOP_BR_ID,:CON_ADDR1,:CON_ADDR2)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_loc);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_loc singleShop_loc(int id) {

		String sql = " SELECT SBr.LOC_ID,SBr.THANA_ID,T.THANA_NAME,S.SHOP_ID, SBr.SHOP_BR_ID,SB.SHOP_BR_NAME,SBr.HEAD_ID,H.HEAD_NAME,SBr.CON_ADDR1,SBr.CON_ADDR2,DIS.DIST_ID,DIV.DIV_ID \r\n"
				+ "FROM SF_SHOP_LOC SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S, SF_THANA T, SF_DISTRICT dis,SF_DIVISION div where \r\n"
				+ " SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and SBR.THANA_ID=T.THANA_ID \r\n"
				+ " and T.DIST_ID=DIS.DIST_ID and DIS.DIV_ID=DIV.DIV_ID AND LOC_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_loc shop_loc = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_loc.class));

		return shop_loc;
	}
	
	public void editShop_loc(Shop_loc shop_loc) {
		
		String sql = "UPDATE SF_SHOP_LOC SET THANA_ID=:THANA_ID,SHOP_BR_ID=:SHOP_BR_ID,HEAD_ID=:HEAD_ID,CON_ADDR1=:CON_ADDR1,CON_ADDR2=:CON_ADDR2 where LOC_ID=:LOC_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_loc);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_loc(int id) {
		String sql = "DELETE FROM SF_SHOP_LOC WHERE LOC_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	public ArrayList<DrpDwn> listDrpDwnDIVISION() {

		String sql = "SELECT DIV_ID DCODE,DIV_NAME DNAME FROM SF_DIVISION";
		List<DrpDwn> listDrpDwnDIVISION = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(DrpDwn.class));

		return (ArrayList<DrpDwn>) listDrpDwnDIVISION;
	}
	
	public ArrayList<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN() {

		String sql = "SELECT DIST_ID,DIST_NAME FROM SF_DISTRICT";
		List<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(DISTRICT_DROPDOWN.class));

		return (ArrayList<DISTRICT_DROPDOWN>) listDISTRICT_DROPDOWN;
	}
	
	public ArrayList<THANA_DROPDOWN> listTHANA_DROPDOWN() {

		String sql = "SELECT THANA_ID,THANA_NAME FROM SF_THANA";
		List<THANA_DROPDOWN> listTHANA_DROPDOWN = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(THANA_DROPDOWN.class));

		return (ArrayList<THANA_DROPDOWN>) listTHANA_DROPDOWN;
	}
	
	
	public List<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN(int DIV_ID) {

		String sql = "SELECT DIST_ID ,DIST_NAME FROM SF_DISTRICT WHERE DIV_ID='"+DIV_ID+"'";
		List<DISTRICT_DROPDOWN> listDISTRICT_DROPDOWN = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(DISTRICT_DROPDOWN.class));

		return listDISTRICT_DROPDOWN;
	}
	
	public List<THANA_DROPDOWN> listTHANA_DROPDOWN(int DIST_ID) {

		String sql = "SELECT THANA_ID, THANA_NAME FROM SF_THANA WHERE DIST_ID='"+DIST_ID+"'";
		List<THANA_DROPDOWN> listTHANA_DROPDOWN = jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(THANA_DROPDOWN.class));

		return listTHANA_DROPDOWN;
	}

// Pera//////////
	
	public ArrayList<LEVEL1> listLevel1() {

		String sql = "SELECT  S.SUB_HEAD_ID,S.PARENT_ID,H.HEAD_NAME,S.LEV,S.CHILD_NAME FROM SF_SUB_HEAD S,SF_MAIN_HEAD H WHERE S.PARENT_ID=H.HEAD_ID AND LEV=0";
		ArrayList<LEVEL1> listLevel1 = (ArrayList<LEVEL1>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(LEVEL1.class));

		return listLevel1;
	}
	
	
	public void insertLevel1(LEVEL1 level1) {
		
		String sql = "INSERT INTO SF_SUB_HEAD (PARENT_ID,LEV,CHILD_NAME)VALUES(:PARENT_ID, 0 ,:CHILD_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level1);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public LEVEL1 singleLevel1(int id) {

		String sql = "SELECT  S.SUB_HEAD_ID,S.PARENT_ID,H.HEAD_NAME,S.LEV,S.CHILD_NAME FROM SF_SUB_HEAD S,SF_MAIN_HEAD H WHERE S.PARENT_ID=H.HEAD_ID AND LEV=0 AND SUB_HEAD_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		LEVEL1 level1 = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(LEVEL1.class));

		return level1;
	}
	
	public void editLevel1(LEVEL1 level1) {
		
		String sql = "UPDATE SF_SUB_HEAD SET PARENT_ID=:PARENT_ID, CHILD_NAME=:CHILD_NAME where SUB_HEAD_ID=:SUB_HEAD_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level1);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteLevel1(int id) {
		String sql = "DELETE FROM SF_SUB_HEAD WHERE SUB_HEAD_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
	/// LEVEL-2 //////
	
	public ArrayList<LEVEL2> listLevel2(int level1parent,int level1Sub) {

		String sql = "SELECT SUB_HEAD_ID,PARENT_ID,LEV,CHILD_NAME,(select CHILD_NAME from SF_SUB_HEAD where SUB_HEAD_ID='"+level1Sub+"') HEAD_NAME  FROM SF_SUB_HEAD WHERE LEV=1 AND PARENT_ID='"+level1parent+"'";
			
		ArrayList<LEVEL2> listLevel2 = (ArrayList<LEVEL2>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(LEVEL2.class));

		return listLevel2;
		
	}
	
	public void insertLevel2(LEVEL2 level2) {
		String sql = "INSERT INTO SF_SUB_HEAD (PARENT_ID,LEV,CHILD_NAME)VALUES(:PARENT_ID,1,:CHILD_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level2);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public LEVEL2 singleLevel2(int level1Sub,int id) {

		String sql = "SELECT SUB_HEAD_ID,PARENT_ID,LEV,CHILD_NAME,(select CHILD_NAME from SF_SUB_HEAD where SUB_HEAD_ID='"+level1Sub+"') HEAD_NAME  FROM SF_SUB_HEAD WHERE LEV=1 AND SUB_HEAD_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		LEVEL2 level2 = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(LEVEL2.class));

		return level2;
	}
	
	
	
	public void editLevel2(LEVEL2 level2) {
		String sql = "UPDATE SF_SUB_HEAD SET PARENT_ID=:PARENT_ID, CHILD_NAME=:CHILD_NAME where SUB_HEAD_ID=:SUB_HEAD_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level2);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteLevel2(int id) {
		String sql = "DELETE FROM SF_SUB_HEAD WHERE SUB_HEAD_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	
///// LEVEl 3 ///////	
	
	public ArrayList<LEVEL3> listLevel3(int level1parent,int level1Sub, int level2Sub) {

		String sql = "SELECT SUB_HEAD_ID,PARENT_ID,LEV,CHILD_NAME,(select CHILD_NAME from SF_SUB_HEAD where SUB_HEAD_ID='"+level2Sub+"') HEAD_NAME  FROM SF_SUB_HEAD WHERE LEV=2  AND PARENT_ID='"+level2Sub+"'";
			
		ArrayList<LEVEL3> listLevel3 = (ArrayList<LEVEL3>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(LEVEL3.class));

		return listLevel3;
		
	}
	
	public void insertLevel3(LEVEL3 level3) {
		String sql = "INSERT INTO SF_SUB_HEAD (PARENT_ID,LEV,CHILD_NAME)VALUES(:PARENT_ID,2,:CHILD_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level3);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public LEVEL3 singleLevel3(int id) {

		String sql = "SELECT SUB_HEAD_ID,PARENT_ID,LEV,CHILD_NAME FROM SF_SUB_HEAD WHERE LEV=2  AND SUB_HEAD_ID=?";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		LEVEL3 level3 = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(LEVEL3.class));

		return level3;
	}
	
	public void editLevel3(LEVEL3 level3) {
		String sql = "UPDATE SF_SUB_HEAD SET PARENT_ID=:PARENT_ID, CHILD_NAME=:CHILD_NAME where SUB_HEAD_ID=:SUB_HEAD_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(level3);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteLevel3(int id) {
		String sql = "DELETE FROM SF_SUB_HEAD WHERE SUB_HEAD_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Item> listItem(int headId) {

		String sql = "SELECT ITEM_ID,ITEM_CODE,HEAD_ID,ITEM_NAME,LEVEL_ID  FROM SF_ITEM i WHERE i.HEAD_ID='"+headId+"'";
			
		ArrayList<Item> listItem = (ArrayList<Item>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Item.class));

		return listItem;
		
	}
	
	public ArrayList<Shop_Item> listShop_Item(int sId,int hId,int SbId) {

		String sql = " SELECT SBr.SHOP_ITEM_ID,SBr.ITEM_CODE,I.ITEM_NAME,S.SHOP_ID,SBr.HEAD_ID,H.HEAD_NAME, SBr.SHOP_BR_ID,SBr.BRAND_ID,SBr.RTL_PRICE, \r\n"
				+ "  SBr.SHORT_NAME FROM SF_SHOP_ITEM SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S, SF_ITEM I where\r\n"
				+ "  SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and SBr.ITEM_CODE=I.ITEM_CODE AND\r\n"
				+ "  SBr.HEAD_ID= '"+hId+"' AND SBr.SHOP_BR_ID='"+SbId+"'";
		
		ArrayList<Shop_Item> listShop_Item = (ArrayList<Shop_Item>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Item.class));

		return listShop_Item;
	}
	
	public void insertShop_Item(Shop_Item shop_item) {
		String sql = "INSERT INTO SF_SHOP_ITEM (ITEM_CODE, HEAD_ID, SHOP_BR_ID, BRAND_ID, RTL_PRICE, SHORT_NAME)VALUES(:ITEM_CODE,:HEAD_ID,:SHOP_BR_ID,:BRAND_ID,:RTL_PRICE,:SHORT_NAME)";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_item);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public Shop_Item singleShop_Item(int id) {

		String sql = " SELECT SBr.SHOP_ITEM_ID,SBr.ITEM_CODE,I.ITEM_NAME,S.SHOP_ID,SBr.HEAD_ID,H.HEAD_NAME, SBr.SHOP_BR_ID,SBr.BRAND_ID,SBr.RTL_PRICE, \r\n"
				+ "	SBr.SHORT_NAME FROM SF_SHOP_ITEM SBr,SF_MAIN_HEAD H,SF_SHOP_BRANCH SB,SF_SHOP S, SF_ITEM I where \r\n"
				+ "	 SBR.HEAD_ID=H.HEAD_ID and SBR.SHOP_BR_ID=SB.SHOP_BR_ID and SB.SHOP_ID=S.SHOP_ID and SBr.ITEM_CODE=I.ITEM_CODE  AND SHOP_ITEM_ID=? ";
		Object[] args = { id };
		@SuppressWarnings("deprecation")
		Shop_Item shop_item = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Shop_Item.class));

		return shop_item;
	}
	
	public void editShop_Item(Shop_Item shop_item) {
		
		String sql = "UPDATE SF_SHOP_ITEM SET ITEM_CODE=:ITEM_CODE,HEAD_ID=:HEAD_ID,SHOP_BR_ID=:SHOP_BR_ID,BRAND_ID=:BRAND_ID,RTL_PRICE=:RTL_PRICE,SHORT_NAME=:SHORT_NAME where SHOP_ITEM_ID=:SHOP_ITEM_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(shop_item);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void deleteShop_Item(int id) {
		
		String sql = "DELETE FROM SF_SHOP_ITEM WHERE SHOP_ITEM_ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public ArrayList<Stock> listStock() {

		String sql = "SELECT  S.STOCK_ID,S.HEAD_ID,H.HEAD_NAME,S.SHOP_BR_ID,br.SHOP_BR_NAME,S.SHOP_ITEM_ID,I.ITEM_NAME,S.BUY_PRICE,S.BAL,S.RTL_PRICE FROM SF_SHOP_STOCK S,SF_MAIN_HEAD H,SF_SHOP_BRANCH br,SF_SHOP_ITEM Si,SF_ITEM I  WHERE S.HEAD_ID=H.HEAD_ID AND S.SHOP_BR_ID=BR.SHOP_BR_ID AND SI.SHOP_ITEM_ID=I.ITEM_ID ";
		ArrayList<Stock> listStock = (ArrayList<Stock>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Stock.class));

		return listStock;
	}
	
	/*
	 * public ArrayList<Account_Statement> listAccount_Statement(String date) {
	 * 
	 * String sql =
	 * "select GL.SHOP_GL_ID,GL_NAME,AMT from SF_SHOP_GL_TRAN trn,SF_SHOP_GL gl\r\n"
	 * +
	 * "where TRN.SHOP_GL_ID=GL.SHOP_GL_ID and to_date(TRAN_DATE,'dd/mm/rrrr')=to_date(TRAN_DATE,'dd/mm/rrrr')\r\n"
	 * + " order by GL.SHOP_GL_ID"; ArrayList<Account_Statement>
	 * listAccount_Statement = (ArrayList<Account_Statement>)
	 * jdbcTemplate.query(sql,
	 * BeanPropertyRowMapper.newInstance(Account_Statement.class));
	 * 
	 * return listAccount_Statement; }
	 */
	
	public ArrayList<Account_Statement> listAccount_Statement2(String date) {

		String sql = "select 'Total' as total,GL.SHOP_GL_ID,GL_NAME,sum(amt) AMT from SF_SHOP_GL_TRAN trn,SF_SHOP_GL gl\r\n"
				+ "where TRN.SHOP_GL_ID=GL.SHOP_GL_ID and to_date(TRAN_DATE,'dd/mm/rrrr')=to_date(TRAN_DATE,'dd/mm/rrrr')\r\n"
				+ "group by GL.SHOP_GL_ID,GL_NAME order by GL.SHOP_GL_ID";
		ArrayList<Account_Statement> listAccount_Statement2 = (ArrayList<Account_Statement>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Account_Statement.class));

		return listAccount_Statement2;
	}
	
	public ArrayList<Shop_Pos> listShop_Pos(int Shop_BrId, int HeadId) {

		String sql = "Select * From SF_SHOP_POS where SHOP_BR_ID='"+Shop_BrId+"' and HEAD_ID='"+HeadId+"' ";
		ArrayList<Shop_Pos> listShop_Pos = (ArrayList<Shop_Pos>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_Pos.class));

		return listShop_Pos;
	}
	
	public ArrayList<Shop_vendor> listShop_vendor(int Shop_BrId, int HeadId) {

		String sql = "Select * From SF_SHOP_VENDOR where SHOP_BR_ID='"+Shop_BrId+"' and HEAD_ID=' "+HeadId+"' ";
		ArrayList<Shop_vendor> listShop_vendor = (ArrayList<Shop_vendor>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Shop_vendor.class));

		return listShop_vendor;
	}
	
	public ArrayList<Payment> listPayment(int SHOP_ID,int HEAD_ID, int SHOP_BR_ID) {

		String sql = "SELECT * FROM SF_SHOP_PAYMENT pay,SF_SHOP_BRANCH bra WHERE PAY.SHOP_BR_ID=BRA.SHOP_BR_ID and BRA.SHOP_ID='" + SHOP_ID +"' AND  pay.HEAD_ID='" + HEAD_ID +"' AND  pay.SHOP_BR_ID='"+SHOP_BR_ID+"' ";
		ArrayList<Payment> listPayment = (ArrayList<Payment>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Payment.class));

		return listPayment;
	}
	
	public void insertPayment(Payment payment) {
		String sql = "INSERT INTO SF_SHOP_PAYMENT ( HEAD_ID, SHOP_BR_ID, MNT_AMT, DAY_GAP, INT_AMT, INI_DATE, LAST_PAY, NEXT_PAY, PAY_MON )VALUES( "+payment.getHEAD_ID()+", "+payment.getSHOP_BR_ID()+", "+payment.getMNT_AMT()+", "+payment.getDAY_GAP()+"," +payment.getINT_AMT()+", TO_DATE('"+payment.getINI_DATE()+"', 'YYYY-MM-DD'), TO_DATE('"+payment.getLAST_PAY()+"', 'YYYY-MM-DD'), TO_DATE('"+payment.getNEXT_PAY()+"', 'YYYY-MM-DD'), '"+payment.getPAY_MON()+"')";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(payment);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void insertPayment1(Payment payment) {
		String sql = "INSERT INTO SF_SHOP_PAYMENT_HIST ( HEAD_ID, SHOP_BR_ID, MNT_AMT, TRAN_DATE, TRAN_MON, PAY_MODE,TRAN_ID,  AUTH )VALUES( "+payment.getHEAD_ID()+", "+payment.getSHOP_BR_ID()+", "+payment.getMNT_AMT()+", SYSDATE, '"+payment.getPAY_MON()+"', 'Cash','0', 'Y')";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(payment);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	public Payment singlePayment(int PAYED_ID) {

		String sql = "SELECT PAYED_ID, SHOP_ID, HEAD_ID, SHOP_BR_ID, MNT_AMT, DAY_GAP, INT_AMT,  to_char(INI_DATE,'mm/dd/YyyY') INI_DATE, to_char(LAST_PAY, 'mm/dd/YyyY') LAST_PAY, to_char(NEXT_PAY, 'mm/dd/YyyY') NEXT_PAY, PAY_MON FROM SF_SHOP_PAYMENT WHERE PAYED_ID=? ";
		Object[] args = { PAYED_ID };
		@SuppressWarnings("deprecation")
		Payment payment = jdbcTemplate.queryForObject(sql, args,
				BeanPropertyRowMapper.newInstance(Payment.class));

		return payment;
	}
	
	public void Payment_edit(Payment sale) {
		String sql = "UPDATE SF_SHOP_PAYMENT SET SHOP_ID=:SHOP_ID, HEAD_ID=:HEAD_ID, SHOP_BR_ID=:SHOP_BR_ID, MNT_AMT=:MNT_AMT, DAY_GAP=:DAY_GAP, INT_AMT=:INT_AMT, PAY_MON=:PAY_MON where PAYED_ID=:PAYED_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void Payment_edit1(Payment sale) {
		String sql = "UPDATE SF_SHOP_PAYMENT_HIST SET   MNT_AMT=:MNT_AMT, TRAN_MON=:TRAN_MON where PAYED_HIST_ID=:PAYED_HIST_ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	public void Payment_delete(int PAYED_ID) {
		String sql = "DELETE FROM SF_SHOP_PAYMENT WHERE PAYED_ID = ?";
		jdbcTemplate.update(sql, PAYED_ID);
	}
	
	
	
	public ArrayList<SF_SUB_HEAD> listHead(int HEAD_ID) {

		String sql = "SELECT * FROM  SF_SUB_HEAD\r\n"
				+ " WHERE PARENT_ID='" + HEAD_ID +"' ";
		ArrayList<SF_SUB_HEAD> listHead =  (ArrayList<SF_SUB_HEAD>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(SF_SUB_HEAD.class));

		return listHead;
	}
	
	public ArrayList<SF_SUB_HEAD> listShop_Brand(int SUB_HEAD_ID) {

		String sql = "SELECT * FROM  SF_SUB_HEAD\r\n"
				+ " WHERE PARENT_ID='" + SUB_HEAD_ID +"'";
		ArrayList<SF_SUB_HEAD> listShop_Brand =  (ArrayList<SF_SUB_HEAD>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(SF_SUB_HEAD.class));

		return listShop_Brand;
	}
	
	
	public ArrayList<listSF_ITEM_Dropdown> listSF_ITEM_Dropdown(int SUB_HEAD_ID) {

		String sql = "SELECT * FROM  SF_ITEM\r\n"
				+ " WHERE SUB_HEAD_ID='" + SUB_HEAD_ID +"'";
		//System.out.println(sql);
		ArrayList<listSF_ITEM_Dropdown> listSF_ITEM_Dropdown =  (ArrayList<listSF_ITEM_Dropdown>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(listSF_ITEM_Dropdown.class));

		return listSF_ITEM_Dropdown;
	}

	
	public ArrayList<Un_Auth_Payment> listUn_Auth_Payment() {

		String sql = "Select B.HEAD_NAME, C.SHOP_BR_NAME,A.SHOP_PAID_ID, A.TRAN_DATE, A.TRAN_MON, A.MNT_AMT, A.AUTH\r\n"
				+ " FROM SF_SHOP_PAYMENT_HIST A, SF_MAIN_HEAD B, SF_SHOP_BRANCH C WHERE A.AUTH='N' AND A.HEAD_ID=B.HEAD_ID AND A.SHOP_BR_ID=C.SHOP_BR_ID";  /*AND A.HEAD_ID=B.HEAD_ID AND A.SHOP_BR_ID=C.SHOP_BR_ID*/
		System.out.println(sql);
		ArrayList<Un_Auth_Payment> listUn_Auth_Payment =  (ArrayList<Un_Auth_Payment>) jdbcTemplate.query(sql,
				BeanPropertyRowMapper.newInstance(Un_Auth_Payment.class));

		return listUn_Auth_Payment;
	}
	
	  public void Un_Auth_Payment_edit(int PAYED_HIST_ID) {
	  
		  String sql = "UPDATE SF_SHOP_PAYMENT_HIST SET AUTH='Y' WHERE PAYED_HIST_ID="+PAYED_HIST_ID+" ";
		  
		  jdbcTemplate.update(sql);
	  }
	 
	  public ArrayList<SF_UNIT> listSF_UNIT() {

			String sql = "SELECT UNIT_ID, UNIT_NAME from SF_UNIT";
			ArrayList<SF_UNIT> listSF_UNIT = (ArrayList<SF_UNIT>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(SF_UNIT.class));

			return listSF_UNIT;
		}
	  
	  public ArrayList<SF_BRAND_DROPDOWN> listSF_BRAND_Dropdown() {

			String sql = "SELECT BRAND_ID, BRAND_NAME from SF_SHOP_BRAND";
			ArrayList<SF_BRAND_DROPDOWN> listSF_BRAND_Dropdown = (ArrayList<SF_BRAND_DROPDOWN>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(SF_BRAND_DROPDOWN.class));

			return listSF_BRAND_Dropdown;
		}
	  
	  public List<Item> listItem1(int HEAD_ID) {

			String sql = "SELECT I.ITEM_CODE, I.ITEM_NAME, H.HEAD_NAME from  SF_ITEM I, SF_MAIN_HEAD h where I.HEAD_ID = "+HEAD_ID+" AND I.HEAD_ID=H.HEAD_ID ";
			ArrayList<Item> listItem = (ArrayList<Item>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(Item.class));

			return listItem;
		}
	  
	  public List<Shop_Br> Shop_Br_dropdown(int HEAD_ID) {

			String sql = "SELECT * from  SF_SHOP_BRANCH where HEAD_ID = "+HEAD_ID+" ";
			ArrayList<Shop_Br> Shop_Br_dropdown = (ArrayList<Shop_Br>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(Shop_Br.class));

			return Shop_Br_dropdown;
		}
	  
	  public List<Shop_Item> listShopItem(int HEAD_ID, int SHOP_BR_ID) {

			String sql = "select  si.ITEM_CODE,I.ITEM_NAME,si.RTL_PRICE,h.HEAD_NAME, B.SHOP_BR_NAME, si.SHORT_NAME\r\n"
					+ " from SF_SHOP_ITEM si,SF_ITEM I, SF_MAIN_HEAD h, SF_SHOP_BRANCH B \r\n"
					+ "where SI.ITEM_CODE=I.ITEM_CODE AND si.HEAD_ID = "+HEAD_ID+" AND si.SHOP_BR_ID="+SHOP_BR_ID+" AND si.HEAD_ID=h.head_id and SI.SHOP_BR_ID=B.SHOP_BR_ID ";
			ArrayList<Shop_Item> listShopItem = (ArrayList<Shop_Item>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(Shop_Item.class));

			return listShopItem;
		}
	  
	  public List<Stock> listStockItem(int HEAD_ID, int SHOP_BR_ID) {

			String sql = "SELECT S.SHOP_ITEM_ID,SI.ITEM_NAME, S.BUY_PRICE, S.BAL, S.RTL_PRICE, H.HEAD_NAME, B.SHOP_BR_NAME\r\n"
					+ "  from  SF_SHOP_STOCK S, SF_MAIN_HEAD H, SF_SHOP_BRANCH B, SF_SHOP_ITEM I, SF_ITEM SI\r\n"
					+ "    where S.HEAD_ID = "+HEAD_ID+" AND S.SHOP_BR_ID="+SHOP_BR_ID+"  AND S.HEAD_ID=H.HEAD_ID AND S.SHOP_BR_ID=B.SHOP_BR_ID AND S.SHOP_ITEM_ID=I.SHOP_ITEM_ID  AND I.ITEM_CODE= SI.ITEM_CODE ";
			ArrayList<Stock> listStockItem = (ArrayList<Stock>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(Stock.class));

			return listStockItem;
		}
	  
	  public List<Shop_Contact> listShop_Contact1(int HEAD_ID, int SHOP_BR_ID) {

			String sql = "SELECT * from  SF_SHOP_CONTACT C,SF_MAIN_HEAD H, SF_SHOP_BRANCH B  where C.HEAD_ID = "+HEAD_ID+" AND C.SHOP_BR_ID="+SHOP_BR_ID+" AND C.HEAD_ID=H.HEAD_ID AND C.SHOP_BR_ID=B.SHOP_BR_ID ";
			ArrayList<Shop_Contact> listShop_Contact1 = (ArrayList<Shop_Contact>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(Shop_Contact.class));

			return listShop_Contact1;
		}
	  
	  public List<SHOP_DETAILS> listSHOP_DETAILS(int HEAD_ID, int SHOP_BR_ID) {

			String sql = "SELECT H.HEAD_NAME, B.SHOP_BR_NAME, p.MNT_AMT, P.DAY_GAP, P.INI_DATE, P.LAST_PAY, P.NEXT_PAY, P.INT_AMT \r\n"
					+ "   from  SF_SHOP_PAYMENT p, SF_MAIN_HEAD H, SF_SHOP_BRANCH B\r\n"
					+ "     where P.HEAD_ID = "+HEAD_ID+" AND P.SHOP_BR_ID="+SHOP_BR_ID+" AND P.HEAD_ID=H.HEAD_ID AND P.SHOP_BR_ID=B.SHOP_BR_ID ";
			ArrayList<SHOP_DETAILS> listSHOP_DETAILS = (ArrayList<SHOP_DETAILS>) jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(SHOP_DETAILS.class));

			return listSHOP_DETAILS;
		}
	  
	  public List<SF_SHOP_PAYMENT_HIST> listSF_SHOP_PAYMENT_HIST(String FROM_DATE, String TO_DATE,int HEAD_ID, int SHOP_BR_ID) {

			String sql = " SELECT  H.HEAD_NAME, B.SHOP_BR_NAME,\r\n"
					+ "                    p.TRAN_MON, p.PAY_MODE, p.AUTH, p.TRAN_DATE\r\n"
					+ "                     FROM SF_SHOP_PAYMENT_HIST P,  SF_MAIN_HEAD H, SF_SHOP_BRANCH B\r\n"
					+ "                      where p.HEAD_ID="+HEAD_ID+" AND p.SHOP_BR_ID="+SHOP_BR_ID+" and trunc(TRAN_DATE)>=to_date('"+FROM_DATE+"','rrrr-mm-dd') and trunc(TRAN_DATE)<=to_date('"+TO_DATE+"','rrrr-mm-dd') AND P.HEAD_ID=H.HEAD_ID AND P.SHOP_BR_ID=B.SHOP_BR_ID ";
			List<SF_SHOP_PAYMENT_HIST> listSF_SHOP_PAYMENT_HIST = jdbcTemplate.query(sql,
					BeanPropertyRowMapper.newInstance(SF_SHOP_PAYMENT_HIST.class));

			return listSF_SHOP_PAYMENT_HIST;
		}
	  
	  

}
