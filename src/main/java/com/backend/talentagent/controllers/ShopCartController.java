package com.backend.talentagent.controllers;


import java.util.Optional;



import com.backend.talentagent.models.Cart;
import com.backend.talentagent.models.dto.ShopCartDto;
import com.backend.talentagent.services.ShopCartService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;


    @GetMapping
    public ResponseEntity<?> findAllLineItems() {
        return ResponseEntity.ok().body(shopCartService.findAllCart());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody ShopCartDto shopCartDto){
        Optional<Cart> cart = shopCartService.addToCart(shopCartDto);
        return ResponseEntity.ok().body(cart);
    }

   

}
