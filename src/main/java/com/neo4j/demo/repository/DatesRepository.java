/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neo4j.demo.repository;

import com.neo4j.demo.entity.Dates;
import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 *
 * @author yorg
 */
public interface DatesRepository extends GraphRepository<Dates> {
   @Query("match ()-[r:DATES]->() return r")
   Collection<Dates> getAll();
}
