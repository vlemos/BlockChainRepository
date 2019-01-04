/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services;

import com.vlemos.blockchainproject.domain.Block;
import com.vlemos.blockchainproject.domain.BlockChain;
import com.vlemos.blockchainproject.repository.BlockChainRepository;
import com.vlemos.blockchainproject.repository.BlockRepository;
import com.vlemos.blockchainproject.services.exceptions.ObjectNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinicius.lemos
 */
@Service
public class BlockChainService {
    
    @Autowired
    private BlockChainRepository repo;
    
    @Autowired
    private BlockRepository repoBlock;
    
    public BlockChain insert(BlockChain obj) throws ParseException {
        BlockChain blockchain;
        obj.setId(1); //isso garantira que sempre haverá apenas uma blochchain na base
        blockchain = repo.save(obj);
        blockchain = find(1);
        
//        if(blockchain.getChain().isEmpty()){
//            initGenesisBlock(blockchain);
//        } 
        
        return blockchain;
    }
    
      public BlockChain find(Integer id) {
        Optional<BlockChain> obj;
        obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                  "Objeto Não encontrado! Id: " + id + " Tipo " + BlockChain.class.getName()));
    }

    private void initGenesisBlock(BlockChain blockchain) throws ParseException {
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        Block blockGenesis = new Block(null, "1", sdf.parse("01/01/2019 00:00"), 0, blockchain);
        blockchain.getChain().addAll(Arrays.asList(blockGenesis));
        
        repoBlock.save(blockGenesis);
        update(blockchain);
        
        
    }

    public BlockChain update(BlockChain obj) {
        BlockChain newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(obj);
    }
    
     
     private void updateData(BlockChain newObj, BlockChain obj) {
        newObj.setChain(obj.getChain());
        
        
    }

    public int getPreviousHash() {
        BlockChain chain = find(1);
        List<Block> blocks = chain.getChain();
        return blocks.get(blocks.size()-1).getHash();
    }
    
}
