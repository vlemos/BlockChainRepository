/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.domain;

import com.vlemos.blockchainproject.domain.enums.StatusTransacation;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vinicius Lemos
 */
@Entity
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "origem_wallet")
    private Wallet origem;
    
    @ManyToOne
    @JoinColumn(name = "destino_Wallet") 
    private Wallet destino;
   
    
    private Double valor;
    private int statusTransaction;
    
    @ManyToOne
    @JoinColumn(name = "block_id") 
    private Block block;
    
    public Transaction() {
    }

    public Transaction(Integer id, Wallet origem, Wallet destino, Double valor, StatusTransacation statusTransaction) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.statusTransaction = (statusTransaction==null) ? null : statusTransaction.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Wallet getOrigem() {
        return origem;
    }

    public void setOrigem(Wallet origem) {
        this.origem = origem;
    }

    public Wallet getDestino() {
        return destino;
    }

    public void setDestino(Wallet destino) {
        this.destino = destino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public StatusTransacation getStatusTransaction() {
        return StatusTransacation.toEnum(statusTransaction);
    }

    public void setStatusTransaction(int statusTransaction) {
        this.statusTransaction = statusTransaction;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
    
       

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.origem);
        hash = 29 * hash + Objects.hashCode(this.destino);
        hash = 29 * hash + Objects.hashCode(this.valor);
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
        final Transaction other = (Transaction) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.origem, other.origem)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }
    
    
    
}
