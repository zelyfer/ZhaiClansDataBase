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
   
   public User create(String account, String password){
      User user = User.createUser(account, password);
      return userRepo.save(user);
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
      return user.getAccount() + " " + user.getPassword();
   }
   
   public String updateUserInfo(String account, String info){
      User user = userRepo.findByAccount(account);
      user.setSchool(info);
      User newUser = userRepo.save(user);
      return newUser.getSchool();
   }
   
   public String updateUserHobby(String account, String hobby){
      User user = userRepo.findByAccount(account);
      user.setHobby(hobby);
      User newUser = userRepo.save(user);
      return newUser.getHobby();
   }
}
