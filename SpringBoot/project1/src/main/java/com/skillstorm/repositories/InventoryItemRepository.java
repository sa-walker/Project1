package com.skillstorm.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer>{
	
	

}