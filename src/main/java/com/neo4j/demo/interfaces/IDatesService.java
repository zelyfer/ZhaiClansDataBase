/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.interfaces;

import com.neo4j.demo.entity.DateInfo;
import com.neo4j.demo.entity.Dates;
import com.neo4j.demo.entity.User;
import java.util.Iterator;

/**
 *
 * @author yorg
 */
public interface IDatesService {
   Dates create(User host, User guest, DateInfo adate);
   Dates create(Long id, String guestAccount);
   Iterator<Dates> findAll();
}
