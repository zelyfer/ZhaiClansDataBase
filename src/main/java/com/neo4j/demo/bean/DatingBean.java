/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.bean;

import com.neo4j.demo.entity.Dating;
import com.neo4j.demo.entity.User;
import com.neo4j.demo.service.DatingService;
import global.Excutable;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import org.springframework.data.neo4j.conversion.Result;

/**
 *
 * @author yorg
 */
@ManagedBean(name = "datingBean")
public class DatingBean {
   DatingService service = null;
   
   public DatingBean(){
      service = (DatingService)(Excutable.context.getBean("datingService"));
   }
   
   public Dating create(User host, User guest){
      return service.create(host, guest);
   }
   
   public long getCount(){
      return service.getCount();
   }
   
   public Iterable<Dating> findByHost(User user){
      return service.findByHost(user);
   }
   
   public Iterable<Dating> findByGuest(User guest){
      return service.findByGuest(guest);
   }
   
   public Iterable<Dating> getAll(){
      return service.getAll();
   }
}
