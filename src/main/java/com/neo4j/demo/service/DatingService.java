/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.service;

import com.neo4j.demo.entity.Dating;
import com.neo4j.demo.entity.User;
import com.neo4j.demo.repository.DatingRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

/**
 *
 * @author yorg
 */
@Service("datingService")
public class DatingService {
   @Autowired
   private DatingRepository datingRepo;
   
   public Dating create(User host, User guest){
      Dating d = host.initDate(guest);
      datingRepo.save(d);
      
      return d;
   }
   
   public long getCount(){
      return datingRepo.count();
   }
   
   public Iterable<Dating> findByHost(User host){
      return datingRepo.findByHost(host);
   }
   
   public Iterable<Dating> findByGuest(User guest){
      return datingRepo.findByGuest(guest);
   }
   
   public Iterable<Dating> getAll(){
      return datingRepo.getAll();
   }
}
