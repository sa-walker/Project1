package com.skillstorm.services;


import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.dtos.ItemResponseDto;

import java.util.List;

public interface InventoryItemService {
	
	//find by params
	//add - same as save?
    
    // find all
	List<InventoryItemResponseDto> findAll();
	InventoryItemResponseDto getReferenceById(Integer id);
	
	List<Object> getInventoryLevels();
	
	// get all the inventory items in a certain warehouse
	List<InventoryItemResponseDto> findByWarehouseId(Integer id);
	
	//list stock for each warehouses for a certain item
	List<InventoryItemResponseDto> findByItemId(Integer id);

	//save
	InventoryItemResponseDto save(InventoryItemRequestDto dto);
	
	//delete
	int delete(int id);

}
