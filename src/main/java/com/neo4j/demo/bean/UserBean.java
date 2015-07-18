/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.bean;


import com.neo4j.demo.entity.User;
import com.neo4j.demo.interfaces.IUserService;
import com.neo4j.demo.service.UserService;
import global.Excutable;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author yorg
 */
@ManagedBean(name="userBean")
public class UserBean implements IUserService{
   
   UserService service = null;
   
   public UserBean(){
      service = (UserService)(Excutable.applicationContext.getBean("userService"));
   }
   
   public User create(String account, String password){

      return service.create(account, password);
      
   }
   
   public long getCount(){
      return service.getCount();
   }
   
   public User findByAccount(String account){
      User user =  service.findByAccount(account);
      return user;
   }
   
   public Iterator<User> findAll(){
      return service.findAll();
   }
   
   public void deleteUser(User user){
      service.deleteUser(user);
   }
   
   public String getUserInfoByAccount(String account){
      return service.getUserInfoByAccount(account);
   }
   
   public String updateUserPersonalInfo(String account, String info){
      return service.updateUserPersonalInfo(account, info);
   }
   
   public String updateUserHobby(String account, String info){
      return service.updateUserHobby(account, info);
   }
   
   public String updateUserMoney(String account, String money){
      return service.updateUserMoney(account, money);
   }
}
