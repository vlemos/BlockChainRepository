/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.services.exceptions;

/**
 *
 * @author vinicius.lemos
 */
public class ContraintViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContraintViolationException(String msg) {
        super(msg);
    }

    public ContraintViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
