package com.backend.talentagent.repository;

import java.util.Optional;

import com.backend.talentagent.models.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart,Long>{
    @Query("select c from cart c where c.isClosed=false")
    Optional<Cart> findCartOpen();



}
    