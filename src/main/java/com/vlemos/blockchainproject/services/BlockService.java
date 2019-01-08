/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Block;
import com.vlemos.blockchainproject.repository.BlockRepository;
//import java.util.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinicius.lemos
 */
@Service
public class BlockService {
    @Autowired
    private BlockRepository repo;
    
     public Block insert(Block obj) {
        obj.setId(null);
        return repo.save(obj);
    }
     
}
