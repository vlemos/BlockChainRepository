/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Transaction;
import com.vlemos.blockchainproject.domain.Wallet;
import com.vlemos.blockchainproject.domain.enums.StatusTransacation;
import com.vlemos.blockchainproject.repository.TransactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Lemos
 */

@Service
public class TransactionService {

@Autowired
    private TransactionRepository repo;
    
    public List<Transaction> findAll(){
        return repo.findAll();
    }
    
    public Transaction insert(Transaction obj){
        obj.setId(null);
        return repo.save(obj);
    }
    
    public Transaction transfer(Wallet walletOrigem, Wallet walletDestino, Double valor) {
        Transaction transaction;
        if (existeSaldo(walletOrigem,valor)) {
            transaction = new Transaction(null, walletOrigem, walletDestino, valor, StatusTransacation.PENDING);
        } else {
            return null;
        }
        return transaction;
    }

    private boolean existeSaldo(Wallet walletOrigem, Double valor) {
        if ((walletOrigem.getSaldo() - valor) > 0) {
            return true;
        } else {
            return false;
        }
    }

}
