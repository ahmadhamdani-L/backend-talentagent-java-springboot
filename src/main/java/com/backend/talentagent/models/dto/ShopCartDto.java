package com.backend.talentagent.models.dto;

import java.util.List;

public class ShopCartDto {
    private Long cartId;
    private List<TalentDto> talentDto;
    
    public ShopCartDto() {
    }

    public ShopCartDto(Long cartId, List<TalentDto> talentDto) {
        this.cartId = cartId;
        this.talentDto = talentDto;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<TalentDto> getTalentDto() {
        return talentDto;
    }

    public void setTalentDto(List<TalentDto> talentDto) {
        this.talentDto = talentDto;
    }

    
}
