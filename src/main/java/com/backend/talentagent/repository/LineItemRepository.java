package com.backend.talentagent.repository;



import com.backend.talentagent.models.LineItem;
import com.backend.talentagent.models.LineItemId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem,LineItemId>{
    
}
