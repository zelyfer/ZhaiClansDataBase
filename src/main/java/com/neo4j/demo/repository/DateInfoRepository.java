/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.repository;

import com.neo4j.demo.entity.DateInfo;
import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author yorg
 */
public interface DateInfoRepository extends GraphRepository<DateInfo> {
   DateInfo findOne(Long id);
   
   @Query("match (n:DateInfo) return n")
   Collection<DateInfo> getAll();
   
   Collection<DateInfo> findByHostAccount(String hostAccount);
   
   @Query("match (n:DateInfo) " +
           "where n.guestAccount IS NULL " +
           "return n limit 1")
   DateInfo getOneUnmatched();
   
   @Query("match (n:DateInfo) " +
           "where n.guestAccount IS NULL " +
           "return n")
   Collection<DateInfo> getAllUnmatched();
   
}
