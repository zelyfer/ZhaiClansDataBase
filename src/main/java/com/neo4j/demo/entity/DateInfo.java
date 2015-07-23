/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.entity;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 *
 * @author yorg
 */
@NodeEntity
public class DateInfo {
   @GraphId private Long id;
   
   @Indexed
   private String hostAccount;
   private String guestAccount;
   
   private String time;
   private String place;
   private String topic;

   
   public static DateInfo create(String hostAccount){
      DateInfo dateInfo = new DateInfo();
      dateInfo.hostAccount = hostAccount;
      return dateInfo;
   }
   
   /**
    * @return the id
    */
   public Long getId() {
      return id;
   }

   /**
    * @return the hostAccount
    */
   public String getHostAccount() {
      return hostAccount;
   }

   /**
    * @return the time
    */
   public String getTime() {
      return time;
   }

   /**
    * @param time the time to set
    */
   public void setTime(String time) {
      this.time = time;
   }

   /**
    * @return the place
    */
   public String getPlace() {
      return place;
   }

   /**
    * @param place the place to set
    */
   public void setPlace(String place) {
      this.place = place;
   }

   /**
    * @return the topic
    */
   public String getTopic() {
      return topic;
   }

   /**
    * @param topic the topic to set
    */
   public void setTopic(String topic) {
      this.topic = topic;
   }

   /**
    * @return the guestAccount
    */
   public String getGuestAccount() {
      return guestAccount;
   }

   /**
    * @param guestAccount the guestAccount to set
    */
   public void setGuestAccount(String guestAccount) {
      this.guestAccount = guestAccount;
   }
   
   
}
