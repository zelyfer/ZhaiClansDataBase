/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.bean;

import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.entity.Dates;
import com.neo4j.demo.entity.User;
import com.neo4j.demo.interfaces.IDatesService;
import com.neo4j.demo.service.DatesService;
import global.Excutable;
import java.util.Iterator;

/**
 *
 * @author yorg
 */
public class DatesBean implements IDatesService{
   DatesService service;
   
   public DatesBean(){
      service = (DatesService)(Excutable.applicationContext.getBean("datesService"));
   }
   
   public Dates create(User host, User guest, DateInfo date){
      return service.create(host, guest, date);
   }
   
   public Dates create(Long id, String guestAccount){
      return service.create(id, guestAccount);
   }
   
   public Iterator<Dates> findAll(){
      return service.findAll();
   }
   
   
}
