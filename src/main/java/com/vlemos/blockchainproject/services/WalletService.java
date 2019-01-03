/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Wallet;
import com.vlemos.blockchainproject.repository.WalletRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Lemos
 */

@Service
public class WalletService {
    
    @Autowired
    private WalletRepository repo;
    
    public List<Wallet> findAll(){
        return repo.findAll();
    }
    
    public Wallet insert(Wallet obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
    
}
