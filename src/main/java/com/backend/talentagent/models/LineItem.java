package com.backend.talentagent.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "line_item")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                 property = "id",scope = Long.class )
public class LineItem {
  @EmbeddedId
  @JsonIdentityReference(alwaysAsId = true)
  private LineItemId id;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("cart_id")
  @JoinColumn(name = "cart_id")
  private Cart cart;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("tale_id")
  @JoinColumn(name = "tale_id")
  private Talent talent;


  private int quantity;

  private double totalPrice;

  public LineItem() {
  }

  





  public LineItem(LineItemId id, int quantity, double totalPrice) {
    this.id = id;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
  }

  

  public LineItemId getId() {
    return id;
  }



  public void setId(LineItemId id) {
    this.id = id;
  }



  public int getQuantity() {
    return quantity;
  }



  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }



  public double getTotalPrice() {
    return totalPrice;
  }



  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  

  public Cart getCart() {
    return cart;
  }




  public void setCart(Cart cart) {
    this.cart = cart;
  }




  public Talent getTalent() {
    return talent;
  }




  public void setTalent(Talent talent) {
    this.talent = talent;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    LineItem other = (LineItem) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

 

}