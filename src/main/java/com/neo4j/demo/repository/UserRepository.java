/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.repository;

import com.neo4j.demo.entity.User;
import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author yorg
 */
public interface UserRepository extends GraphRepository<User>{
   User findByAccount(String account);
   void delete(User user);
   
   @Query("match (n:User) return n")
   Collection<User> getAll();
}
