package com.skillstorm.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.models.InventoryItem;

@Transactional 
@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer>{
	
	@Procedure("FIND_INVENTORY_BY_WAREHOUSE")
	List<InventoryItem> getInventoryByWarehouse(Integer id);
	
	@Procedure("GET_ALL_INVENTORY")
	List<InventoryItem> getInventory();
	
	@Procedure("FIND_INVENTORY_BY_ITEM")
	List<InventoryItem> getInventoryByItem(Integer id);

	

}