/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.config;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.vlemos.blockchainproject.services.DBServices;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 *
 * @author Vinicius Lemos
 */

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBServices dbService;

    @Bean
    public boolean instantiateDataBase() throws ParseException {
        dbService.instantiateDataBase();
        return true;
    }    
}
