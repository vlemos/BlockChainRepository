/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vlemos.blockchainproject.resources;

import java.net.URI;
import com.vlemos.blockchainproject.domain.Wallet;
import com.vlemos.blockchainproject.dto.WalletDto;
import com.vlemos.blockchainproject.services.WalletService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author vinicius.lemos
 */
@RestController
@RequestMapping(value = "/wallets")
public class WalletResource {
    
    @Autowired
    private WalletService wallet;
    
      @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Wallet> find(@PathVariable Integer id){
        
        Wallet obj = wallet.find(id);

        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody WalletDto objDto) {
        Wallet obj = wallet.fromDTO(objDto);
        obj = wallet.insert(obj);

        URI uri = null;
        if(obj!= null){
            uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }else{
            return (ResponseEntity<Void>) ResponseEntity.ok();
        }
        
        

    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<WalletDto>> findAll() {
        
        List<Wallet> list = wallet.findAll();
        
        // converte a lista Categoria para CategoriaDto
        List<WalletDto> listDto = list.stream().map(obj -> new WalletDto(obj)).collect(Collectors.toList());
        
        return ResponseEntity.ok().body(listDto);
    }

    
}
