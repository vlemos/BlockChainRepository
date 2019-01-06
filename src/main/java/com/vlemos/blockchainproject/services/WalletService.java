/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Wallet;
import com.vlemos.blockchainproject.repository.WalletRepository;
import com.vlemos.blockchainproject.services.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
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
    
        public Wallet find(Integer id) {
        Optional<Wallet> obj;
        obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                  "Objeto Não encontrado! Id: " + id + " Tipo " + Wallet.class.getName()));
    }

    
    public List<Wallet> findAll(){
        return repo.findAll();
    }
    
    public Wallet insert(Wallet obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
      public Wallet update(Wallet obj) {
        Wallet newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(obj);
    }
    
     
     private void updateData(Wallet newObj, Wallet obj) {
        newObj.setNome(obj.getNome());
        newObj.setSaldo(obj.getSaldo());
        newObj.setTransacoesDestino(obj.getTransacoesDestino());
        newObj.setTransacoesOrigem(obj.getTransacoesOrigem());
        
        
        
    }

    
    
}
