/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.bean;

import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.interfaces.IDateInfoService;
import com.neo4j.demo.service.DateInfoService;
import global.Excutable;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author yorg
 */
@ManagedBean(name="dateInfoBean")
public class DateInfoBean implements IDateInfoService{
   DateInfoService service;
   
   public DateInfoBean(){
      service = (DateInfoService)(Excutable.applicationContext.getBean("dateInfoService"));
   }
   
   
   public String create(String hostAccount){
      return service.create(hostAccount);
   }
   
   public DateInfo findOne(Long id){
      return service.findOne(id);
   }
   
   public Iterator<DateInfo> findAll(){
      return service.findAll();
   }
   
   public String getOneUnmatched(){
      return service.getOneUnmatched();
   }
   
   public String toJSON(DateInfo dateInfo){
      return service.toJSON(dateInfo);
   }
   
   public String updateDateInfo(String id, String time, String place, String topic){
      return service.updateDateInfo(id, time, place, topic);
   }
   
   public String create(String hostAccount, String time, String place, String topic){
      return service.create(hostAccount, time, place, topic);
   }
}
