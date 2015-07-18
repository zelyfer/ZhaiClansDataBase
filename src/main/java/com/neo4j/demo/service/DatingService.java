///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.neo4j.demo.service;
//
//import com.neo4j.demo.entity.Dating;
//import com.neo4j.demo.entity.User;
//import com.neo4j.demo.interfaces.IDatingService;
//import com.neo4j.demo.repository.DatingRepository;
//import com.neo4j.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author yorg
// */
//@Service("datingService")
//public class DatingService implements IDatingService {
//   @Autowired
//   private DatingRepository datingRepo;
//   
//   @Autowired
//   private UserRepository userRepo;
//   
//   public Dating create(User host, User guest){
//      Dating d = host.startDate(guest);
//      datingRepo.save(d);
//      
//      return d;
//   }
//   
//   public long getCount(){
//      return datingRepo.count();
//   }
//   
//   public Dating findById(Long id){
//      return datingRepo.findOne(id);
//   }
//   
//   public Iterable<Dating> findByHost(User host){
//      return datingRepo.findByHost(host);
//   }
//   
//   public Iterable<Dating> findByGuest(User guest){
//      return datingRepo.findByGuest(guest);
//   }
//   
//   public Iterable<Dating> getAll(){
//      return datingRepo.getAll();
//   }
//   
//   @Override
//   @Transactional
//   public Dating acceptDate(Dating dating, User guest){
//      Dating existDating = findById(dating.getId());
//      User existGuest = userRepo.findOne(guest.getId());
//              
//      if(existDating == null){
//         System.out.println("can not find dating with id: " + dating.getId());
//         return null;
//      }
//      
//      if(existGuest == null){
//         System.out.println("can not find user with id: " + guest.getId());
//         return null;
//      }
//      
//     System.out.println(existDating.getGuest().getAccount());
//     
////     existDating.setPlace("wocaocao");
//
//      existDating.setGuest(existGuest);
//      userRepo.save(existGuest);
//      Dating d2 = datingRepo.save(existDating);
//      
//      System.out.println(d2.getGuest().getAccount());
//      
//      return d2;
//      
//   }
//   
//   
//}
