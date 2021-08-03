package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.models.Cart;
import com.backend.talentagent.models.dto.ShopCartDto;



public interface ShopCartService{

    Optional<Cart> addToCart(ShopCartDto shopCartDto);

    List<Cart> findAllCart();

}
