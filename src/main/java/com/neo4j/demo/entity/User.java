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
   
   
   private String school;
   private String hobby;

   
   public static User createUser(String account, String password){
      User user = new User();
      user.account = account;
      user.password = password;
      user.registerDate = getCurrentTime();
      
      return user;
   }
   
   
   static private String getCurrentTime(){
      SimpleDateFormat time=new SimpleDateFormat("yyyyMMddHHmmss"); 
      return time.format(new Date());
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
   
}
