/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Wallet;
import com.vlemos.blockchainproject.dto.WalletDto;
import com.vlemos.blockchainproject.repository.WalletRepository;
import com.vlemos.blockchainproject.services.exceptions.ContraintViolationException;
import com.vlemos.blockchainproject.services.exceptions.DataIntegrityException;
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
    
    
//    Precisa tratar este ponto, pois ao tentar inserir uma carteira com nome já existente, gera uma exceção.
    public Wallet insert(Wallet obj) {
        Wallet savedObj = null;
        obj.setId(null);
        
        try {
            savedObj = repo.save(obj);
        } catch (Exception e) {
            Optional<Wallet> ret = null;    
            return  ret.orElseThrow(() -> new ContraintViolationException(
                  "Já existe uma carteira com este nome"));        
        }
        return savedObj;
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

    public Wallet fromDTO(WalletDto objDto) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new Wallet(objDto.getId(), objDto.getNome(),0.00);
    }

    
    
}
