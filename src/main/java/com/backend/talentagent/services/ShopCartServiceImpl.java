package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.models.Cart;
import com.backend.talentagent.models.LineItem;
import com.backend.talentagent.models.LineItemId;
import com.backend.talentagent.models.dto.TalentDto;
import com.backend.talentagent.models.dto.ShopCartDto;
import com.backend.talentagent.repository.CartRepository;
import com.backend.talentagent.repository.LineItemRepository;


import org.springframework.stereotype.Service;

@Service
public class ShopCartServiceImpl implements ShopCartService{

    private LineItemRepository lineItemRepository;
    private CartRepository cartRepository;


    public ShopCartServiceImpl(LineItemRepository lineItemRepository, CartRepository cartRepository) {
        this.lineItemRepository = lineItemRepository;
        this.cartRepository = cartRepository;
    }



    @Override
    public Optional<Cart> addToCart(ShopCartDto shopCartDto) {
        // get cart to fetch cartId, gunakan optinal agar terhindar dari null trace
        Optional<Cart> cart = cartRepository.findCartOpen();

        if (!cart.isPresent()){
            cart = Optional.of(cartRepository.save(new Cart()));
        }

        // loop shopcartDto to get talentdot
        for (TalentDto tale : shopCartDto.getTalentDto()) {
            // get id for cart & talent
            LineItemId lineItemId = new LineItemId(cart.get().getId(),
            tale.getTaleId());

            LineItem lineItem = new LineItem(lineItemId, tale.getQuantity(),tale.getPrice());
            lineItemRepository.save(lineItem);
        }
        // 
        return cartRepository.findById(cart.get().getId());
    }



    @Override
    public List<Cart> findAllCart() {
      
        return cartRepository.findAll();
    }
    
    
}
