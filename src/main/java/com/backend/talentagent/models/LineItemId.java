package com.backend.talentagent.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class LineItemId implements Serializable {

  private static final long serialVersionUID = 1L;

  
  @Column(name = "cart_id")
  private Long cartId;
  @Column(name = "tale_id")
  private Long taleId;

  
  public LineItemId() {
  }

  public LineItemId(Long cartId, Long taleId) {
    this.cartId = cartId;
    this.taleId = taleId;
  }


    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
     
      result = prime * result + ((taleId == null) ? 0 : taleId.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      LineItemId other = (LineItemId) obj;
      if (cartId == null) {
        if (other.cartId != null)
          return false;
      } else if (!cartId.equals(other.cartId))
        return false;
    
      if (taleId == null) {
        if (other.taleId != null)
          return false;
      } else if (!taleId.equals(other.taleId))
        return false;
      return true;
    }

  


}