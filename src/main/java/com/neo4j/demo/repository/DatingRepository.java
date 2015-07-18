///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.neo4j.demo.repository;
//
//import com.neo4j.demo.entity.Dating;
//import com.neo4j.demo.entity.User;
//import java.util.Collection;
//import org.springframework.data.neo4j.annotation.Query;
//import org.springframework.data.neo4j.repository.GraphRepository;
//
///**
// *
// * @author yorg
// */
//public interface DatingRepository extends GraphRepository<Dating> {
//   @Query("start host=node({0}) " +
//           "match n -[r]-> (u) " + 
//           "return r")
//   Collection<Dating> findByHost(User host);
//   
//   Dating findOne(Long id);
//   
//   
//   @Query("match (n {account:'00000000000'}) -[r]- (u) " + 
//          "return r")
//   Collection<Dating> findByGuest(User guest);
//   
//   @Query("match (n1)-[r]->(n2) return r")
//   Collection<Dating> getAll();
//   
////   @Query("start r=relationship({0}), guest=node({1}) " +
////           "set r.guest = guest " + 
////           "return r")
////   Dating acceptDate(Dating dating, User guest);
//   
//   
//}
