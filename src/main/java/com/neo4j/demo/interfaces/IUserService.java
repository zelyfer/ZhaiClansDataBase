/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.interfaces;

import com.neo4j.demo.entity.User;
import java.util.Iterator;

/**
 *
 * @author yorg
 */
public interface IUserService {
   public Boolean create(String account, String password);
   public long getCount();
//   public User findByAccount(String account);
//   public Iterator<User> findAll();
//   public void deleteUser(User user);
   
   public String getUserInfoByAccount(String account);
   public Boolean updateUserPersonalInfo(String account, String info);
   public Boolean updateUserHobby(String account, String hobby);
   public Boolean updateUserMoney(String account, String money);
}
