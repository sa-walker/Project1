package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.models.InventoryItem;
import com.skillstorm.repositories.InventoryItemRepository;

public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
    private InventoryItemRepository inventoryItemRepository;
	
	// Save operation
    @Override
    public InventoryItem saveInventoryItem(InventoryItem inventoryItem)
    {
        return inventoryItemRepository.save(inventoryItem);
    }
  
}
