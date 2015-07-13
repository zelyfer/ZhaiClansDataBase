/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.entity;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 *
 * @author yorg
 */
@RelationshipEntity(type = "DATES")
public class Dating {
   @StartNode
   @Fetch
   private User host;
   
   @EndNode
   @Fetch
   private User guest;
   
   @GraphId
   private Long id;
   
   private String time;
   private String place;
   private String[] topic;
   
   private int dateCount;
   
   
   public static Dating create(User host, User guest){
      Dating d = new Dating();
      d.host = host;
      d.guest = guest;
      return d;
   }

   /**
    * @return the host
    */
   public User getHost() {
      return host;
   }

   /**
    * @return the guest
    */
   public User getGuest() {
      return guest;
   }

   /**
    * @param guest the guest to set
    */
   public void setGuest(User guest) {
      this.guest = guest;
   }

   /**
    * @return the id
    */
   public Long getId() {
      return id;
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
   public String[] getTopic() {
      return topic;
   }

   /**
    * @param topic the topic to set
    */
   public void setTopic(String[] topic) {
      this.topic = topic;
   }

   /**
    * @return the dateCount
    */
   public int getDateCount() {
      return dateCount;
   }

   /**
    * @param dateCount the dateCount to set
    */
   public void setDateCount(int dateCount) {
      this.dateCount = dateCount;
   }
}
