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
public class Dates {
   @GraphId private Long id;
   
   @StartNode @Fetch private User host;
   
   @EndNode @Fetch private User guest;
   
   private DateInfo date;
   
   public static Dates create(User host, User guest, DateInfo date){
      Dates dates = new Dates();
      dates.host = host;
      dates.guest = guest;
      dates.date = date;
      return dates;
   }

   /**
    * @return the id
    */
   public Long getId() {
      return id;
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
    * @return the date
    */
   public DateInfo getDate() {
      return date;
   }
}
