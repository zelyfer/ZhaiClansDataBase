/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.service;

import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.entity.Dates;
import com.neo4j.demo.entity.User;
import com.neo4j.demo.interfaces.IDatesService;
import com.neo4j.demo.repository.DateInfoRepository;
import com.neo4j.demo.repository.DatesRepository;
import com.neo4j.demo.repository.UserRepository;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yorg
 */
@Service("datesService")
public class DatesService implements IDatesService{
   
   @Autowired
   private DatesRepository datesRepo;
   
   @Autowired
   private DateInfoRepository dateInfoRepo;
   
   @Autowired
   private UserRepository userRepo;
   
   public Dates create(User host, User guest, DateInfo date){
      Dates dates = Dates.create(host, guest, date);
      return datesRepo.save(dates);
   }
   
   public Dates create(Long dateInfoId, String guestAccount){
      DateInfo dateInfo = dateInfoRepo.findOne(dateInfoId);
      String hostAccount = dateInfo.getHostAccount();
      User host = userRepo.findByAccount(hostAccount);
      User guest = userRepo.findByAccount(guestAccount);
      return this.create(host, guest, dateInfo);
   }
   
   public Iterator<Dates> findAll(){
      return datesRepo.getAll().iterator();
   }
}
