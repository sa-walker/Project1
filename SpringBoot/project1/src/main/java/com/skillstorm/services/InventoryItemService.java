package com.skillstorm.services;


import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import java.util.List;

public interface InventoryItemService {
	
	//find by params
	//add - same as save?
    
    // find all
	List<InventoryItemResponseDto> findAll();

	//save
	InventoryItemResponseDto save(InventoryItemRequestDto dto);
	
	//delete
	int delete(InventoryItemRequestDto dto);

}
