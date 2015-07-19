/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.interfaces;

import com.neo4j.demo.entity.DateInfo;
import java.util.Iterator;

/**
 *
 * @author yorg
 */
public interface IDateInfoService {
   DateInfo create(String hostAccount);
   DateInfo findOne(Long id);
   Iterator<DateInfo> findAll();
   
   
   String getOneUnmatched();
   
   
}
