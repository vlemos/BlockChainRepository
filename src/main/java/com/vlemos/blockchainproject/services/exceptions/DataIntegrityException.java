/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services.exceptions;

/**
 *
 * @author Vinicius Lemos
 */
public class DataIntegrityException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public DataIntegrityException(String msg){
        super(msg);
    }
    public DataIntegrityException(String msg, Throwable cause){
        super(msg, cause);
    }

    
}
