package com.skillstorm.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.models.InventoryItem;
import com.skillstorm.models.Item;

@Transactional 
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Procedure("FIND_ITEMS_NOT_IN_WAREHOUSE")
	List<Item> getItemsNotInWarehouse(Integer id);
	

}