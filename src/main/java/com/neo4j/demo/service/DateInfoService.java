/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.service;

import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.interfaces.IDateInfoService;
import com.neo4j.demo.repository.DateInfoRepository;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yorg
 */
@Service("dateInfoService")
public class DateInfoService implements IDateInfoService {
   
   @Autowired
   private DateInfoRepository dateInfoRepo;
   
   public DateInfo create(String hostAccount){
      DateInfo date = DateInfo.create(hostAccount);
      return dateInfoRepo.save(date);
   }
   
   public DateInfo findOne(Long id){
      return dateInfoRepo.findOne(id);
   }
   
   public Iterator<DateInfo> findAll(){
      Iterator<DateInfo> dateInfos = dateInfoRepo.getAll().iterator();
      return dateInfos;
   }
   
   public String getOneUnmatched(){
      return dateInfoRepo.getOneUnmatched().toString();
   }
}
