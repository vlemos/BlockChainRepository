/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.domain.enums;

/**
 *
 * @author Vinicius Lemos
 */
public enum StatusTransacation {
    PENDING(1, "Pending"),
    COMMITED(2, "Commited");

    private int cod;
    private String descricao;

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    private StatusTransacation(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static StatusTransacation toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (StatusTransacation x : StatusTransacation.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id Inválido : " + cod);
    }

}
