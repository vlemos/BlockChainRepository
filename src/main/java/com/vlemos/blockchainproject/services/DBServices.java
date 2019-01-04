/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Block;
import com.vlemos.blockchainproject.domain.BlockChain;
import com.vlemos.blockchainproject.domain.Transaction;
import com.vlemos.blockchainproject.domain.Wallet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private BlockChainService blockChainService;

    @Autowired
    private BlockService blockService;
    
    public void instantiateDataBase() throws ParseException{
        
        // Processo de Criação de Carteiras de Teste
        Wallet wallet1 = new Wallet(null, "Carteira 1", 100000.00);
        Wallet wallet2 = new Wallet(null, "Carteira 2", 200000.00);
        Wallet wallet3 = new Wallet(null, "Carteira 3", 300000.00);
        
        // Processo de Criação Transações de Teste
        Transaction transacao1 = transactionService.transfer(wallet1, wallet2, 500.00);
        Transaction transacao2 = transactionService.transfer(wallet1, wallet3, 500.00);
        Transaction transacao3 = transactionService.transfer(wallet3, wallet2, 1500.00);
        
        
        // Adicionando as transações nas carteiras
        wallet1.getTransacoesOrigem().addAll(Arrays.asList(transacao1,transacao2));
        wallet3.getTransacoesOrigem().addAll(Arrays.asList(transacao3));
        wallet2.getTransacoesDestino().addAll(Arrays.asList(transacao1,transacao3));
        wallet3.getTransacoesDestino().addAll(Arrays.asList(transacao2));
        
        // Salvando as Carteiras
        walletService.insert(wallet1);
        walletService.insert(wallet2);
        walletService.insert(wallet3);
                
        // Salvando as Transações
        transactionService.insert(transacao1);
        transactionService.insert(transacao2);
        transactionService.insert(transacao3);
        
        // Criando a BlockChain
        BlockChain blockChain = new BlockChain(1);
        BlockChain blockChain2 = new BlockChain(2); // apenas para teste, pois o sistema deve garantir a criação de apenas uma blockChain
        
        // Salvando a BlockChain
        blockChainService.insert(blockChain);
        blockChainService.insert(blockChain2); // apenas para teste, pois o sistema deve garantir a criação de apenas uma blockChain
        
        // Criando os Blocos de Teste 
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
         
        //Block previousBlock = blockChain.getChain().indexOf(blockChain.getChain().size()-1);
        
        
        //blockChainService.getPreviousHash()
        Block block1 = new Block(null, "1", sdf.parse("15/01/2019 15:00"), 0,blockChain);
        block1.getTransactions().addAll(Arrays.asList(transacao1,transacao3));
        
        transacao1.setBlock(block1);
        transacao3.setBlock(block1);      
        
        blockChain.getChain().addAll(Arrays.asList(block1));
        
        // Atualizando tudo
        
        
        // insert block
        blockService.insert(block1);
        
        // update transacoes
        transactionService.update(transacao1);
        transactionService.update(transacao3);
        
        // update blockchain
        blockChainService.update(blockChain);
        
        
     //   Block block2 = new Block(null, "1", sdf.parse("19/01/2019 22:30"), 123123,blockChain);
       // block2.getTransactions().addAll(Arrays.asList(transacao2));
        

    }
    
}
