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
import org.json.JSONObject;
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
   
   public String create(String hostAccount){
      DateInfo date = DateInfo.create(hostAccount);
      DateInfo dateInfo = dateInfoRepo.save(date);
      return dateInfo.getId().toString();
   }
   
   public DateInfo findOne(Long id){
      return dateInfoRepo.findOne(id);
   }
   
   public Iterator<DateInfo> findAll(){
      Iterator<DateInfo> dateInfos = dateInfoRepo.getAll().iterator();
      return dateInfos;
   }
   
   private String getDateInfoString(DateInfo date){
      JSONObject obj = new JSONObject();
      try{
         obj.put("host", date.getHostAccount());
         obj.put("guest", date.getGuestAccount());
         obj.put("time", date.getTime());
         obj.put("place", date.getPlace());
      }catch (Exception e){
         e.printStackTrace();
         return null;
      }
      
      return obj.toString();
   }
   
   public String getOneUnmatched(){
      DateInfo dateInfo = dateInfoRepo.getOneUnmatched();
      return toJSON(dateInfo);
   }
   
   public String toJSON(DateInfo dateInfo){
      JSONObject obj = new JSONObject();
      try{
         obj.put("id", dateInfo.getId().toString());
         obj.put("host",dateInfo.getHostAccount());
         obj.put("guest",dateInfo.getGuestAccount());
         obj.put("time",dateInfo.getTime());
         obj.put("place", dateInfo.getPlace());
         obj.put("topic",dateInfo.getTopic());
      }catch (Exception e){
         e.printStackTrace();
      }
      return obj.toString();
   }
   
   public String updateDateInfo(String id, String time, String place, String topic){
      Long realId = Long.parseLong(id);
      DateInfo dateInfo = findOne(realId);
      dateInfo.setTime(time);
      dateInfo.setPlace(place);
      dateInfo.setTopic(topic);
      DateInfo newDateInfo = dateInfoRepo.save(dateInfo);
      return toJSON(newDateInfo);
   }
   
   public String create(String hostAccount, String time, String place, String topic){
      DateInfo date = DateInfo.create(hostAccount);
      date.setTime(time);
      date.setPlace(place);
      date.setTopic(topic);
      DateInfo newDateInfo = dateInfoRepo.save(date);
      return newDateInfo.getId().toString();
   }
}
