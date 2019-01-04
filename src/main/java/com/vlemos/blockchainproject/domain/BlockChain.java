/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author vinicius.lemos
 */

@Entity
@Proxy(lazy = false)
public class BlockChain implements Serializable{
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "blockChain")
    List<Block> chain = new ArrayList<>();

    public BlockChain(int id) {
        this.id = id;
    }

    public BlockChain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public List<Block> getChain() {
        return chain;
    }

    public void setChain(List<Block> chain) {
        this.chain = chain;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlockChain other = (BlockChain) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
    
}
