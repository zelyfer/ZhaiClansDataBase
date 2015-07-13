/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.service;

import com.neo4j.demo.entity.User;
import com.neo4j.demo.repository.UserRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yorg
 */
@Service("userService")
public class UserService {
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
   
   public Result<User> findAll(){
      Result<User> u = userRepo.findAll();
      return u;
   }
   
   public Iterable<User> getAll(){
      return userRepo.getAll();
   }
   
   
}
