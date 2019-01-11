/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.dto;

import com.vlemos.blockchainproject.domain.Wallet;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author vinicius.lemos
 */
public class WalletDto  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    @NotEmpty(message = "Preenchimento Obrigatorio")
    @Length(min = 2, max = 80, message = "O Tamanho deve ser entre 5 e 80 Caracteres")
    private String nome;

    public WalletDto() {
    }
    
     public WalletDto(Wallet obj) {
         id = obj.getId();
         nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
