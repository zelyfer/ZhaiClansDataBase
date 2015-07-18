///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.neo4j.demo.interfaces;
//
//import com.neo4j.demo.entity.Dating;
//import com.neo4j.demo.entity.User;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author yorg
// */
//public interface IDatingService {
//   public Dating create(User host, User guest);
//   public long getCount();
//   public Dating findById(Long id);
//   public Iterable<Dating> findByHost(User host);
//   public Iterable<Dating> findByGuest(User guest);
//   public Iterable<Dating> getAll();
//   
//   @Transactional
//   public Dating acceptDate(Dating dating, User guest);
//}
