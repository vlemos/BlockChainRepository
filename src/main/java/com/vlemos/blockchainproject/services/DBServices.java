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
import com.vlemos.blockchainproject.repository.WalletRepository;
import java.text.ParseException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Lemos
 */
@Service
public class DBServices {


    
    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionService transactionService;


    public void instantiateDataBase() throws ParseException{
        
        Wallet wallet1 = new Wallet(null, "Carteira 1", 100000.00);
        Wallet wallet2 = new Wallet(null, "Carteira 2", 200000.00);
        Wallet wallet3 = new Wallet(null, "Carteira 3", 300000.00);
        
        Transaction transacao1 = transactionService.transfer(wallet1, wallet2, 500.00);
        Transaction transacao2 = transactionService.transfer(wallet1, wallet3, 500.00);
        Transaction transacao3 = transactionService.transfer(wallet3, wallet2, 1500.00);
        
        wallet1.getTransacoesOrigem().addAll(Arrays.asList(transacao1,transacao2));
        wallet3.getTransacoesOrigem().addAll(Arrays.asList(transacao3));
        wallet2.getTransacoesDestino().addAll(Arrays.asList(transacao1,transacao3));
        wallet3.getTransacoesDestino().addAll(Arrays.asList(transacao2));
                
        walletService.insert(wallet1);
        walletService.insert(wallet2);
        walletService.insert(wallet3);
                
        transactionService.insert(transacao1);
        transactionService.insert(transacao2);
        transactionService.insert(transacao3);
        
        

    }
    
}
