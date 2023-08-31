package com.skillstorm.mappers;

import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skillstorm.dtos.InventoryItemRequestDto;
import com.skillstorm.dtos.InventoryItemResponseDto;
import com.skillstorm.models.InventoryItem;
import com.skillstorm.models.Item;
import com.skillstorm.models.Warehouse;
import com.skillstorm.repositories.ItemRepository;
import com.skillstorm.repositories.WarehouseRepository;

@Component
public class InventoryItemMapper {
	
	@Transient
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private WarehouseRepository wareRepo;
	// convert a InventoryItem Entity into a InventoryItemResponseDto

	public InventoryItemResponseDto convert(InventoryItem inventoryItem) {
		return new InventoryItemResponseDto(inventoryItem.getId(), 
				inventoryItem.getItem(), 
				inventoryItem.getWarehouse(),
				inventoryItem.getQuantity());
	}
	
	// convert a InventoryItemRequestDto into a InventoryItem Entity
	
	public InventoryItem convert(InventoryItemRequestDto inventoryItemDto) {
		
		//Item item = itemFromId(inventoryItemDto.getItemId());
		//Warehouse warehouse = warehouseFromId(inventoryItemDto.getWarehouseId());
		
		return new InventoryItem(inventoryItemDto.getId(),
				inventoryItemDto.getItem(),
				inventoryItemDto.getWarehouse(),
				inventoryItemDto.getQuantity());
	}
	
	public Item itemFromId(int id) {
		logger.debug("item id is " + id);
        return itemRepo.findById(id).orElse(new Item());
    }

	public Warehouse warehouseFromId(int id) {
		logger.debug("warehouse id is " + id);
        return wareRepo.findById(id).orElse(new Warehouse());
    }

}