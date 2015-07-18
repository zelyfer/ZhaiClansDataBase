/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.bean;


import com.neo4j.demo.entity.User;
import com.neo4j.demo.service.UserService;
import global.Excutable;
import java.util.Collection;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yorg
 */
@ManagedBean(name="userBean")
public class UserBean {
   
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
   
   public Collection<User> findAll(){
      return service.findAll().as(Collection.class);
   }
   
   public Iterable<User> getAll(){
      return service.getAll();
   }
   
   public void DeleteUser(User user){
      service.deleteUser(user);
   }
}
