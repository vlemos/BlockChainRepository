/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.repository;

import com.vlemos.blockchainproject.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinicius.lemos
 */
@Repository
public interface BlockRepository extends JpaRepository<Block, Integer>{
    
}
