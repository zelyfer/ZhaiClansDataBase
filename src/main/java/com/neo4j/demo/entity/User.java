/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.json.*;

/**
 *
 * @author yorg
 */
@NodeEntity
public class User {
   @GraphId
   private Long id;
    
   @Indexed(unique = true)
   private String account;
   private String password;
   private String registerDate;
   
   private String gender;
   
   private String school;
   private String sid;
   private String major;
   private String birthday;
   private String hometown;
   
   private String money;
   private String hobby;

   
   public static User createUser(String account, String password){
      User user = new User();
      user.account = account;
      user.password = password;
      user.registerDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
      
      return user;
   }
  
   
   /**
    * @return the id
    */
   public Long getId() {
      return id;
   }

   /**
    * @return the account
    */
   public String getAccount() {
      return account;
   }

   /**
    * @return the password
    */
   public String getPassword() {
      return password;
   }

   /**
    * @param password the password to set
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * @return the registerDate
    */
   public String getRegisterDate() {
      return registerDate;
   }

   /**
    * @return the school
    */
   public String getSchool() {
      return school;
   }

   /**
    * @param school the school to set
    */
   public void setSchool(String school) {
      this.school = school;
   }

   /**
    * @return the hobby
    */
   public String getHobby() {
      return hobby;
   }

   /**
    * @param hobby the hobby to set
    */
   public void setHobby(String hobby) {
      this.hobby = hobby;
   }
   
   public String getPersonalInfo(){
      JSONObject obj = new JSONObject();
      try{
         obj.put("gender", gender);
         obj.put("school", school);
         obj.put("sid", sid);
         obj.put("major", major);
         obj.put("birthday", birthday);
         obj.put("hometown", hometown);
      } catch (Exception e){
         e.printStackTrace();
         return null;
      }
      
      return obj.toString();
   }
   
   public void setPersonalInfo(String info){
      try{
         JSONObject obj = new JSONObject(info);
         this.school = obj.getString("school");
         this.sid = obj.getString("sid");
         this.major = obj.getString("major");
         this.birthday = obj.getString("birthday");
         this.hometown = obj.getString("hometown");
      } catch (Exception e){
         e.printStackTrace();
      }
   }

   /**
    * @return the money
    */
   public String getMoney() {
      return money;
   }

   /**
    * @param money the money to set
    */
   public void setMoney(String money) {
      this.money = money;
   }
   
}
