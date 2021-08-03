package com.backend.talentagent.models.dto;

import javax.validation.constraints.Min;

public class TalentDto {
    private Long taleId;

    private Long lineItemId;

    @Min(value=1,message="must be greater than 0")
    private int quantity;
    
    private double price;
    
    public TalentDto() {
    }

    public TalentDto(Long taleId, Long lineItemId, @Min(value = 1, message = "must be greater than 0") int quantity,
            double price) {
        this.taleId = taleId;
        this.lineItemId = lineItemId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getTaleId() {
        return taleId;
    }

    public void setTaleId(Long taleId) {
        this.taleId = taleId;
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

  
    
    
}
