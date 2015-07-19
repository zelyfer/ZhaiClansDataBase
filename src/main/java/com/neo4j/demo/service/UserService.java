/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.service;

import com.neo4j.demo.entity.User;
import com.neo4j.demo.interfaces.IUserService;
import com.neo4j.demo.repository.UserRepository;
import java.util.Iterator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yorg
 */
@Service("userService")
public class UserService implements IUserService{
   @Autowired
   private UserRepository userRepo;
   
   public Boolean create(String account, String password){
      try{
      User.createUser(account, password);
      }catch (Exception e){
         e.printStackTrace();
         return false;
      }
      return true;
   }
   
   public long getCount(){
      return userRepo.count();
   }
   
   public User findByAccount(String account){
      User user = userRepo.findByAccount(account);
      return user;
   }
   
   public Iterator<User> findAll(){
      return userRepo.getAll().iterator();
   }
   
   public void deleteUser(User user){
      userRepo.delete(user);
   }
   
   public String getUserInfoByAccount(String account){
      User user = userRepo.findByAccount(account);
      
      JSONObject obj = new JSONObject();
      try{
         obj.put("gender", user.getGender());
         obj.put("school", user.getSchool());
         obj.put("sid", user.getSid());
         obj.put("major", user.getMajor());
         obj.put("birthday", user.getBirthday());
         obj.put("hometown", user.getHometown());
      } catch (Exception e){
         e.printStackTrace();
         return null;
      }
      
      return obj.toString();
   }
   
   public Boolean updateUserPersonalInfo(String account, String info){
      User user = userRepo.findByAccount(account);
      
      try{
         JSONObject obj = new JSONObject(info);
         user.setSchool(obj.getString("school"));
         user.setSid(obj.getString("sid"));
         user.setMajor(obj.getString("major"));
         user.setBirthday(obj.getString("birthday"));
         user.setHometown(obj.getString("hometown"));
      } catch (Exception e){
         e.printStackTrace();
         return false;
      }
      
      User newUser = userRepo.save(user);
      return true;
   }
   
   public Boolean updateUserHobby(String account, String hobby){
      User user = userRepo.findByAccount(account);
      user.setHobby(hobby);
      userRepo.save(user);
      return true;
   }
   
   public Boolean updateUserMoney(String account, String money){
      User user = userRepo.findByAccount(account);
      if(money.matches("\\d+")){
         user.setMoney(money);
      }
      userRepo.save(user);
      return true;
   }
}
